package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import d.h.c.i.a.f;
import d.h.c.i.a.g;
import d.h.c.i.a.q;
import d.h.c.i.a.r;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public MethodChannel channel;
    public Context context;
    public final Executor executor;
    public final Executor uiThreadExecutor = new UiThreadExecutor();

    /* loaded from: classes7.dex */
    public static class UiThreadExecutor implements Executor {
        public final Handler handler;

        public UiThreadExecutor() {
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    }

    public PathProviderPlugin() {
        r rVar = new r();
        rVar.e("path-provider-background-%d");
        rVar.f(5);
        this.executor = Executors.newSingleThreadExecutor(rVar.b());
    }

    public static /* synthetic */ void a(q qVar, Callable callable) {
        try {
            qVar.A(callable.call());
        } catch (Throwable th) {
            qVar.B(th);
        }
    }

    private <T> void executeInBackground(final Callable<T> callable, final MethodChannel.Result result) {
        final q F = q.F();
        g.a(F, new f<T>() { // from class: io.flutter.plugins.pathprovider.PathProviderPlugin.1
            @Override // d.h.c.i.a.f
            public void onFailure(Throwable th) {
                result.error(th.getClass().getName(), th.getMessage(), null);
            }

            @Override // d.h.c.i.a.f
            public void onSuccess(T t) {
                result.success(t);
            }
        }, this.uiThreadExecutor);
        this.executor.execute(new Runnable() { // from class: f.a.c.a.f
            @Override // java.lang.Runnable
            public final void run() {
                PathProviderPlugin.a(q.this, callable);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getApplicationSupportDirectory */
    public String g() {
        return PathUtils.getFilesDir(this.context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderApplicationDocumentsDirectory */
    public String c() {
        return PathUtils.getDataDirectory(this.context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderExternalCacheDirectories */
    public List<String> e() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderExternalStorageDirectories */
    public List<String> f(String str) {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderStorageDirectory */
    public String d() {
        File externalFilesDir = this.context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderTemporaryDirectory */
    public String b() {
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
            executeInBackground(new Callable() { // from class: f.a.c.a.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PathProviderPlugin.this.b();
                }
            }, result);
        } else if (c2 == 1) {
            executeInBackground(new Callable() { // from class: f.a.c.a.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PathProviderPlugin.this.c();
                }
            }, result);
        } else if (c2 == 2) {
            executeInBackground(new Callable() { // from class: f.a.c.a.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PathProviderPlugin.this.d();
                }
            }, result);
        } else if (c2 == 3) {
            executeInBackground(new Callable() { // from class: f.a.c.a.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PathProviderPlugin.this.e();
                }
            }, result);
        } else if (c2 == 4) {
            final String androidType = StorageDirectoryMapper.androidType((Integer) methodCall.argument("type"));
            executeInBackground(new Callable() { // from class: f.a.c.a.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PathProviderPlugin.this.f(androidType);
                }
            }, result);
        } else if (c2 != 5) {
            result.notImplemented();
        } else {
            executeInBackground(new Callable() { // from class: f.a.c.a.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PathProviderPlugin.this.g();
                }
            }, result);
        }
    }
}
