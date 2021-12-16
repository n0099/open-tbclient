package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
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
/* loaded from: classes4.dex */
public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MethodChannel channel;
    public Context context;
    public final Executor executor;
    public final Executor uiThreadExecutor;

    /* loaded from: classes4.dex */
    public static class UiThreadExecutor implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler handler;

        public UiThreadExecutor() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.handler.post(runnable);
            }
        }
    }

    public PathProviderPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uiThreadExecutor = new UiThreadExecutor();
        this.executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("path-provider-background-%d").setPriority(5).build());
    }

    public static /* synthetic */ void a(SettableFuture settableFuture, Callable callable) {
        try {
            settableFuture.set(callable.call());
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    private <T> void executeInBackground(final Callable<T> callable, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, callable, result) == null) {
            final SettableFuture create = SettableFuture.create();
            Futures.addCallback(create, new FutureCallback<T>(this, result) { // from class: io.flutter.plugins.pathprovider.PathProviderPlugin.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PathProviderPlugin this$0;
                public final /* synthetic */ MethodChannel.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, result};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = result;
                }

                @Override // com.google.common.util.concurrent.FutureCallback
                public void onFailure(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                        this.val$result.error(th.getClass().getName(), th.getMessage(), null);
                    }
                }

                @Override // com.google.common.util.concurrent.FutureCallback
                public void onSuccess(T t) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                        this.val$result.success(t);
                    }
                }
            }, this.uiThreadExecutor);
            this.executor.execute(new Runnable() { // from class: g.a.c.a.f
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PathProviderPlugin.a(SettableFuture.this, callable);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getApplicationSupportDirectory */
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? PathUtils.getFilesDir(this.context) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderApplicationDocumentsDirectory */
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? PathUtils.getDataDirectory(this.context) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderExternalCacheDirectories */
    public List<String> e() {
        InterceptResult invokeV;
        File[] externalCacheDirs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderExternalStorageDirectories */
    public List<String> f(String str) {
        InterceptResult invokeL;
        File[] externalFilesDirs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderStorageDirectory */
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            File externalFilesDir = this.context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return null;
            }
            return externalFilesDir.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPathProviderTemporaryDirectory */
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.context.getCacheDir().getPath() : (String) invokeV.objValue;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, registrar) == null) {
            PathProviderPlugin pathProviderPlugin = new PathProviderPlugin();
            pathProviderPlugin.channel = new MethodChannel(registrar.messenger(), "plugins.flutter.io/path_provider");
            pathProviderPlugin.context = registrar.context();
            pathProviderPlugin.channel.setMethodCallHandler(pathProviderPlugin);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, flutterPluginBinding) == null) {
            this.channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/path_provider");
            this.context = flutterPluginBinding.getApplicationContext();
            this.channel.setMethodCallHandler(this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, flutterPluginBinding) == null) {
            this.channel.setMethodCallHandler(null);
            this.channel = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, methodCall, result) == null) {
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
                executeInBackground(new Callable() { // from class: g.a.c.a.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PathProviderPlugin.this.b() : invokeV.objValue;
                    }
                }, result);
            } else if (c2 == 1) {
                executeInBackground(new Callable() { // from class: g.a.c.a.e
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PathProviderPlugin.this.c() : invokeV.objValue;
                    }
                }, result);
            } else if (c2 == 2) {
                executeInBackground(new Callable() { // from class: g.a.c.a.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PathProviderPlugin.this.d() : invokeV.objValue;
                    }
                }, result);
            } else if (c2 == 3) {
                executeInBackground(new Callable() { // from class: g.a.c.a.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PathProviderPlugin.this.e() : invokeV.objValue;
                    }
                }, result);
            } else if (c2 == 4) {
                final String androidType = StorageDirectoryMapper.androidType((Integer) methodCall.argument("type"));
                executeInBackground(new Callable() { // from class: g.a.c.a.c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PathProviderPlugin.this.f(androidType) : invokeV.objValue;
                    }
                }, result);
            } else if (c2 != 5) {
                result.notImplemented();
            } else {
                executeInBackground(new Callable() { // from class: g.a.c.a.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PathProviderPlugin.this.g() : invokeV.objValue;
                    }
                }, result);
            }
        }
    }
}
