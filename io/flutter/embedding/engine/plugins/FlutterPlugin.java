package io.flutter.embedding.engine.plugins;

import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.TextureRegistry;
/* loaded from: classes7.dex */
public interface FlutterPlugin {

    /* loaded from: classes7.dex */
    public interface FlutterAssets {
        String getAssetFilePathByName(@NonNull String str);

        String getAssetFilePathByName(@NonNull String str, @NonNull String str2);

        String getAssetFilePathBySubpath(@NonNull String str);

        String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2);
    }

    void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding);

    void onDetachedFromEngine(@NonNull FlutterPluginBinding flutterPluginBinding);

    /* loaded from: classes7.dex */
    public static class FlutterPluginBinding {
        private final Context applicationContext;
        private final BinaryMessenger binaryMessenger;
        private final FlutterAssets flutterAssets;
        private final FlutterEngine flutterEngine;
        private final PlatformViewRegistry platformViewRegistry;
        private final TextureRegistry textureRegistry;

        public FlutterPluginBinding(@NonNull Context context, @NonNull FlutterEngine flutterEngine, @NonNull BinaryMessenger binaryMessenger, @NonNull TextureRegistry textureRegistry, @NonNull PlatformViewRegistry platformViewRegistry, @NonNull FlutterAssets flutterAssets) {
            this.applicationContext = context;
            this.flutterEngine = flutterEngine;
            this.binaryMessenger = binaryMessenger;
            this.textureRegistry = textureRegistry;
            this.platformViewRegistry = platformViewRegistry;
            this.flutterAssets = flutterAssets;
        }

        @NonNull
        public Context getApplicationContext() {
            return this.applicationContext;
        }

        @NonNull
        @Deprecated
        public FlutterEngine getFlutterEngine() {
            return this.flutterEngine;
        }

        @NonNull
        public BinaryMessenger getBinaryMessenger() {
            return this.binaryMessenger;
        }

        @NonNull
        public TextureRegistry getTextureRegistry() {
            return this.textureRegistry;
        }

        @NonNull
        public PlatformViewRegistry getPlatformViewRegistry() {
            return this.platformViewRegistry;
        }

        @NonNull
        public FlutterAssets getFlutterAssets() {
            return this.flutterAssets;
        }
    }
}
