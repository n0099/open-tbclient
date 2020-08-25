package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    private Context context;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        PathProviderPlugin pathProviderPlugin = new PathProviderPlugin();
        pathProviderPlugin.channel = new MethodChannel(registrar.messenger(), "plugins.flutter.io/path_provider");
        pathProviderPlugin.context = registrar.context();
        pathProviderPlugin.channel.setMethodCallHandler(pathProviderPlugin);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/path_provider");
        this.context = flutterPluginBinding.getApplicationContext();
        this.channel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -1832373352:
                if (str.equals("getApplicationSupportDirectory")) {
                    c = 5;
                    break;
                }
                break;
            case -1208689078:
                if (str.equals("getExternalCacheDirectories")) {
                    c = 3;
                    break;
                }
                break;
            case 299667825:
                if (str.equals("getExternalStorageDirectories")) {
                    c = 4;
                    break;
                }
                break;
            case 1200320591:
                if (str.equals("getApplicationDocumentsDirectory")) {
                    c = 1;
                    break;
                }
                break;
            case 1252916648:
                if (str.equals("getStorageDirectory")) {
                    c = 2;
                    break;
                }
                break;
            case 1711844626:
                if (str.equals("getTemporaryDirectory")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                result.success(getPathProviderTemporaryDirectory());
                return;
            case 1:
                result.success(getPathProviderApplicationDocumentsDirectory());
                return;
            case 2:
                result.success(getPathProviderStorageDirectory());
                return;
            case 3:
                result.success(getPathProviderExternalCacheDirectories());
                return;
            case 4:
                result.success(getPathProviderExternalStorageDirectories(StorageDirectoryMapper.androidType((Integer) methodCall.argument("type"))));
                return;
            case 5:
                result.success(getApplicationSupportDirectory());
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    private String getPathProviderTemporaryDirectory() {
        return this.context.getCacheDir().getPath();
    }

    private String getApplicationSupportDirectory() {
        return PathUtils.getFilesDir(this.context);
    }

    private String getPathProviderApplicationDocumentsDirectory() {
        return PathUtils.getDataDirectory(this.context);
    }

    private String getPathProviderStorageDirectory() {
        File externalFilesDir = this.context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    private List<String> getPathProviderExternalCacheDirectories() {
        File[] externalCacheDirs;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.context.getExternalCacheDirs()) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalCacheDir = this.context.getExternalCacheDir();
            if (externalCacheDir != null) {
                arrayList.add(externalCacheDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private List<String> getPathProviderExternalStorageDirectories(String str) {
        File[] externalFilesDirs;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.context.getExternalFilesDirs(str)) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalFilesDir = this.context.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                arrayList.add(externalFilesDir.getAbsolutePath());
            }
        }
        return arrayList;
    }
}
