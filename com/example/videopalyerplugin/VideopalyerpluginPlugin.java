package com.example.videopalyerplugin;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.util.ak;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class VideopalyerpluginPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    private FlutterState flutterState;
    VideoPlayer player;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.flutterState = new FlutterState(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getTextureRegistry());
        this.channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "videopalyerplugin");
        this.channel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (!methodCall.method.equals("create")) {
            if (methodCall.method.equals("checkNeedAutoPlay")) {
                result.success(Boolean.valueOf(ak.rI(((Integer) methodCall.argument("sourceType")).intValue())));
            } else if (methodCall.method.equals("isLocalSettingCanAutoPlay")) {
                result.success(Boolean.valueOf(ak.bFV()));
            } else {
                result.notImplemented();
            }
        } else {
            TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.flutterState.textureRegistry.createSurfaceTexture();
            this.player = new VideoPlayer(this.flutterState.applicationContext, this.flutterState.binaryMessenger, createSurfaceTexture, (String) methodCall.argument("url"));
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", Long.valueOf(createSurfaceTexture.id()));
            result.success(hashMap);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
    }

    /* loaded from: classes6.dex */
    private static final class FlutterState {
        private final Context applicationContext;
        private final BinaryMessenger binaryMessenger;
        private final TextureRegistry textureRegistry;

        FlutterState(Context context, BinaryMessenger binaryMessenger, TextureRegistry textureRegistry) {
            this.applicationContext = context;
            this.binaryMessenger = binaryMessenger;
            this.textureRegistry = textureRegistry;
        }
    }
}
