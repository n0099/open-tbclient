package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
/* loaded from: classes7.dex */
public class SharedPreferencesPlugin implements FlutterPlugin {
    public static final String CHANNEL_NAME = "plugins.flutter.io/shared_preferences";
    public MethodChannel channel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SharedPreferencesPlugin().setupChannel(registrar.messenger(), registrar.context());
    }

    private void setupChannel(BinaryMessenger binaryMessenger, Context context) {
        this.channel = new MethodChannel(binaryMessenger, CHANNEL_NAME);
        this.channel.setMethodCallHandler(new MethodCallHandlerImpl(context));
    }

    private void teardownChannel() {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setupChannel(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        teardownChannel();
    }
}
