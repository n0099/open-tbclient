package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.performance_monitor.PerformanceMonitorPlugin;
import com.example.global_state_sync_plugin.GlobalStateSyncPlugin;
import com.example.image_loader_plugin.ImageLoaderPlugin;
import com.example.image_picker.ImagePickerPlugin;
import com.example.shareplugin.SharepluginPlugin;
import com.example.utility_plugin.UtilityPlugin;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.oversketch.progresshud.ProgresshudPlugin;
import d.b.e.a;
import d.b.m.c;
import d.b.x.b;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
@Keep
/* loaded from: classes7.dex */
public final class GeneratedPluginRegistrant {
    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        flutterEngine.getPlugins().add(new a());
        flutterEngine.getPlugins().add(new c());
        flutterEngine.getPlugins().add(new d.b.p.a.a());
        flutterEngine.getPlugins().add(new FlutterBoostPlugin());
        flutterEngine.getPlugins().add(new d.b.p.b.a());
        flutterEngine.getPlugins().add(new GlobalStateSyncPlugin());
        flutterEngine.getPlugins().add(new ImageLoaderPlugin());
        flutterEngine.getPlugins().add(new ImagePickerPlugin());
        flutterEngine.getPlugins().add(new d.b.y.a());
        flutterEngine.getPlugins().add(new b());
        flutterEngine.getPlugins().add(new ProgresshudPlugin());
        flutterEngine.getPlugins().add(new PathProviderPlugin());
        flutterEngine.getPlugins().add(new PerformanceMonitorPlugin());
        flutterEngine.getPlugins().add(new SharepluginPlugin());
        flutterEngine.getPlugins().add(new UtilityPlugin());
        flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
    }
}
