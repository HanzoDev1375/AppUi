package com.mcal.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import com.mcal.example.adapters.LayoutAdapters;
import com.mcal.example.databinding.ActivityMainBinding;
import com.mcal.example.utils.FileHelper;
import com.mcal.example.utils.ZipHelper;
import com.mcal.uidesigner.XmlLayoutDesignActivity;
import com.mcal.webview.BaseActivity;
import com.mcal.webview.WebViewActivity;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import java.io.File;
import java.io.IOException;

public class MainActivity extends BaseActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    //   setupToolbar(binding.toolbar.getId(), "App UI Designer");
    extractRes();
    getLayouts();
    startWebView();
  }

  private File getResDir() {
    return new File(getFilesDir(), "res");
  }

  private File getLayoutDir() {
    return new File(getResDir(), "layout");
  }

  private void extractRes() {
    try {

      File resFile = new File(getFilesDir(), "res.zip");
      FileHelper.copyAssetsFile(this, "res.zip", resFile);
      ZipHelper.INSTANCE.unzip(resFile, getResDir().getPath());
    } catch (IOException err) {

    }
  }

  private void getLayouts() {
    ItemAdapter<LayoutAdapters> apkItemAdapter = new ItemAdapter<>();
    FastAdapter<LayoutAdapters> fastApkAdapter = FastAdapter.with(apkItemAdapter);

    binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    binding.recyclerView.setAdapter(fastApkAdapter);

    Long i = 0L;
    for (File file : getLayoutDir().listFiles()) {
      String name = file.getName();
      if (name.endsWith(".xml")) {
        apkItemAdapter.add(new LayoutAdapters().withId(i).withTitle(name));
        i++;
      }
    }

    fastApkAdapter.setOnClickListener(
        (View v, IAdapter<LayoutAdapters> adapter, LayoutAdapters item, Integer position) -> {
          if (item.getItemTitle() != null) {
            XmlLayoutDesignActivity.show(
                this, "xml", new File(getLayoutDir(), item.getItemTitle()).getPath(), false, false);
          }
          return true;
        });
  }

  private void startWebView() {
    binding.openWebView.setOnClickListener(
        v -> {
          Intent intent = new Intent(this, WebViewActivity.class);
          intent.putExtra(
              WebViewActivity.HTML_URL,
              "https://timscriptov.ru/apkeditor/doc/instructions/index.html");
          startActivity(intent);
        });
  }
}
