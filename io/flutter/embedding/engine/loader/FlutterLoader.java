package io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class FlutterLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    public static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    public static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    public static final String DEFAULT_LIBRARY = "libflutter.so";
    public static final String ENABLE_SKPARAGRAPH_META_DATA_KEY = "io.flutter.embedding.android.EnableSkParagraph";
    public static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    public static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    public static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    public static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    public static final String TAG = "FlutterLoader";
    public static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    public static FlutterLoader instance;
    public transient /* synthetic */ FieldHolder $fh;
    public FlutterApplicationInfo flutterApplicationInfo;
    public FlutterJNI flutterJNI;
    @Nullable
    public Future<InitResult> initResultFuture;
    public long initStartTimestampMillis;
    public boolean initialized;
    @Nullable
    public Settings settings;

    /* loaded from: classes8.dex */
    public static class InitResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String appStoragePath;
        public final String dataDirPath;
        public final String engineCachesPath;

        public InitResult(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    /* loaded from: classes8.dex */
    public static class Settings {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String logTag;

        public Settings() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Nullable
        public String getLogTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.logTag : (String) invokeV.objValue;
        }

        public void setLogTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.logTag = str;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((FlutterJNI) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @NonNull
    private String fullAssetPathFrom(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            return this.flutterApplicationInfo.flutterAssetsDir + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public static FlutterLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (instance == null) {
                instance = new FlutterLoader();
            }
            return instance;
        }
        return (FlutterLoader) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResourceExtractor initResources(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
            return null;
        }
        return (ResourceExtractor) invokeL.objValue;
    }

    @NonNull
    public boolean automaticallyRegisterPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.flutterApplicationInfo.automaticallyRegisterPlugins : invokeV.booleanValue;
    }

    public void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, strArr) == null) || this.initialized) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                try {
                    InitResult initResult = this.initResultFuture.get();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    arrayList.add("--icu-native-lib-path=" + this.flutterApplicationInfo.nativeLibraryDir + File.separator + DEFAULT_LIBRARY);
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.nativeLibraryDir + File.separator + this.flutterApplicationInfo.aotSharedLibraryName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("--cache-dir-path=");
                    sb.append(initResult.engineCachesPath);
                    arrayList.add(sb.toString());
                    if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                        arrayList.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                    }
                    if (this.settings.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.settings.getLogTag());
                    }
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    int i2 = bundle != null ? bundle.getInt(OLD_GEN_HEAP_SIZE_META_DATA_KEY) : 0;
                    if (i2 == 0) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                        i2 = (int) ((memoryInfo.totalMem / 1000000.0d) / 2.0d);
                    }
                    arrayList.add("--old-gen-heap-size=" + i2);
                    if (bundle != null && bundle.getBoolean(ENABLE_SKPARAGRAPH_META_DATA_KEY)) {
                        arrayList.add("--enable-skparagraph");
                    }
                    this.flutterJNI.init(context, (String[]) arrayList.toArray(new String[0]), null, initResult.appStoragePath, initResult.engineCachesPath, SystemClock.uptimeMillis() - this.initStartTimestampMillis);
                    this.initialized = true;
                    return;
                } catch (Exception e2) {
                    Log.e(TAG, "Flutter initialization failed.", e2);
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    public void ensureInitializationCompleteAsync(@NonNull Context context, @Nullable String[] strArr, @NonNull Handler handler, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, strArr, handler, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.settings != null) {
                    if (this.initialized) {
                        handler.post(runnable);
                        return;
                    } else {
                        Executors.newSingleThreadExecutor().execute(new Runnable(this, context, strArr, handler, runnable) { // from class: io.flutter.embedding.engine.loader.FlutterLoader.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ FlutterLoader this$0;
                            public final /* synthetic */ Context val$applicationContext;
                            public final /* synthetic */ String[] val$args;
                            public final /* synthetic */ Runnable val$callback;
                            public final /* synthetic */ Handler val$callbackHandler;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, context, strArr, handler, runnable};
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
                                this.val$applicationContext = context;
                                this.val$args = strArr;
                                this.val$callbackHandler = handler;
                                this.val$callback = runnable;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.this$0.initResultFuture.get();
                                        new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: io.flutter.embedding.engine.loader.FlutterLoader.2.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass2 this$1;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    AnonymousClass2 anonymousClass2 = this.this$1;
                                                    anonymousClass2.this$0.ensureInitializationComplete(anonymousClass2.val$applicationContext.getApplicationContext(), this.this$1.val$args);
                                                    AnonymousClass2 anonymousClass22 = this.this$1;
                                                    anonymousClass22.val$callbackHandler.post(anonymousClass22.val$callback);
                                                }
                                            }
                                        });
                                    } catch (Exception e2) {
                                        Log.e(FlutterLoader.TAG, "Flutter initialization failed.", e2);
                                        throw new RuntimeException(e2);
                                    }
                                }
                            }
                        });
                        return;
                    }
                }
                throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            }
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
    }

    @NonNull
    public String findAppBundlePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.flutterApplicationInfo.flutterAssetsDir : (String) invokeV.objValue;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? fullAssetPathFrom(str) : (String) invokeL.objValue;
    }

    public boolean initialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.initialized : invokeV.booleanValue;
    }

    public void startInitialization(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            startInitialization(context, new Settings());
        }
    }

    public FlutterLoader(@NonNull FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterJNI};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.initialized = false;
        this.flutterJNI = flutterJNI;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            return getLookupKeyForAsset("packages" + File.separator + str2 + File.separator + str);
        }
        return (String) invokeLL.objValue;
    }

    public void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, settings) == null) && this.settings == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Context applicationContext = context.getApplicationContext();
                this.settings = settings;
                this.initStartTimestampMillis = SystemClock.uptimeMillis();
                this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
                VsyncWaiter.getInstance((WindowManager) applicationContext.getSystemService("window")).init();
                this.initResultFuture = Executors.newSingleThreadExecutor().submit(new Callable<InitResult>(this, applicationContext) { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterLoader this$0;
                    public final /* synthetic */ Context val$appContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, applicationContext};
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
                        this.val$appContext = applicationContext;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public InitResult call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            ResourceExtractor initResources = this.this$0.initResources(this.val$appContext);
                            this.this$0.flutterJNI.loadLibrary();
                            Executors.newSingleThreadExecutor().execute(new Runnable(this) { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.flutterJNI.prefetchDefaultFontManager();
                                    }
                                }
                            });
                            if (initResources != null) {
                                initResources.waitForCompletion();
                            }
                            return new InitResult(PathUtils.getFilesDir(this.val$appContext), PathUtils.getCacheDirectory(this.val$appContext), PathUtils.getDataDirectory(this.val$appContext));
                        }
                        return (InitResult) invokeV.objValue;
                    }
                });
                return;
            }
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
    }
}
