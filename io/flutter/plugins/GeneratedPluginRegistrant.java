package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.d.a;
import com.baidu.f.c;
import com.baidu.network_service_plugin.b;
import com.baidu.performance_monitor.PerformanceMonitorPlugin;
import com.example.flutter_lottie.FlutterLottiePlugin;
import com.example.global_state_sync_plugin.GlobalStateSyncPlugin;
import com.example.image_loader_plugin.ImageLoaderPlugin;
import com.example.image_picker.ImagePickerPlugin;
import com.example.shareplugin.SharepluginPlugin;
import com.example.utility_plugin.UtilityPlugin;
import com.example.videopalyerplugin.VideopalyerpluginPlugin;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.oversketch.progresshud.ProgresshudPlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
@Keep
/* loaded from: classes6.dex */
public final class GeneratedPluginRegistrant {
    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        ShimPluginRegistry shimPluginRegistry = new ShimPluginRegistry(flutterEngine);
        flutterEngine.getPlugins().add(new a());
        flutterEngine.getPlugins().add(new c());
        flutterEngine.getPlugins().add(new FlutterBoostPlugin());
        flutterEngine.getPlugins().add(new com.baidu.h.a.a());
        FlutterLottiePlugin.registerWith(shimPluginRegistry.registrarFor("com.example.flutter_lottie.FlutterLottiePlugin"));
        flutterEngine.getPlugins().add(new GlobalStateSyncPlugin());
        flutterEngine.getPlugins().add(new ImageLoaderPlugin());
        flutterEngine.getPlugins().add(new ImagePickerPlugin());
        flutterEngine.getPlugins().add(new com.baidu.k.a());
        flutterEngine.getPlugins().add(new b());
        flutterEngine.getPlugins().add(new ProgresshudPlugin());
        flutterEngine.getPlugins().add(new PathProviderPlugin());
        flutterEngine.getPlugins().add(new PerformanceMonitorPlugin());
        flutterEngine.getPlugins().add(new SharepluginPlugin());
        flutterEngine.getPlugins().add(new UtilityPlugin());
        flutterEngine.getPlugins().add(new VideopalyerpluginPlugin());
        flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
    }
}
