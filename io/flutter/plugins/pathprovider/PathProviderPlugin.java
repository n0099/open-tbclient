package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public MethodChannel channel;
    public Context context;

    private String getApplicationSupportDirectory() {
        return PathUtils.getFilesDir(this.context);
    }

    private String getPathProviderApplicationDocumentsDirectory() {
        return PathUtils.getDataDirectory(this.context);
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

    private String getPathProviderStorageDirectory() {
        File externalFilesDir = this.context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    private String getPathProviderTemporaryDirectory() {
        return this.context.getCacheDir().getPath();
    }

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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        char c2;
        String str = methodCall.method;
        switch (str.hashCode()) {
            case -1832373352:
                if (str.equals("getApplicationSupportDirectory")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1208689078:
                if (str.equals("getExternalCacheDirectories")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 299667825:
                if (str.equals("getExternalStorageDirectories")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1200320591:
                if (str.equals("getApplicationDocumentsDirectory")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1252916648:
                if (str.equals("getStorageDirectory")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1711844626:
                if (str.equals("getTemporaryDirectory")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            result.success(getPathProviderTemporaryDirectory());
        } else if (c2 == 1) {
            result.success(getPathProviderApplicationDocumentsDirectory());
        } else if (c2 == 2) {
            result.success(getPathProviderStorageDirectory());
        } else if (c2 == 3) {
            result.success(getPathProviderExternalCacheDirectories());
        } else if (c2 == 4) {
            result.success(getPathProviderExternalStorageDirectories(StorageDirectoryMapper.androidType((Integer) methodCall.argument("type"))));
        } else if (c2 != 5) {
            result.notImplemented();
        } else {
            result.success(getApplicationSupportDirectory());
        }
    }
}
