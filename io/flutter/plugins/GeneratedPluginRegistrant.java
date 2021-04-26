package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import d.a.o.a.a;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
@Keep
/* loaded from: classes7.dex */
public final class GeneratedPluginRegistrant {
    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        flutterEngine.getPlugins().add(new a());
        flutterEngine.getPlugins().add(new d.a.o.b.a());
        flutterEngine.getPlugins().add(new PathProviderPlugin());
        flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
    }
}
