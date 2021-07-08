package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes9.dex */
public class FlutterLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    public static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
    public static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
    public static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
    public static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    public static final String DEFAULT_LIBRARY = "libflutter.so";
    public static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
    public static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    public static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
    public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
    public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
    public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
    public static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    public static final String TAG = "FlutterLoader";
    public static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    public static FlutterLoader instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String aotSharedLibraryName;
    public String flutterAssetsDir;
    public boolean initialized;
    public String isolateSnapshotData;
    @Nullable
    public ResourceExtractor resourceExtractor;
    @Nullable
    public Settings settings;
    public String vmSnapshotData;

    /* loaded from: classes9.dex */
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1080064349, "Lio/flutter/embedding/engine/loader/FlutterLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1080064349, "Lio/flutter/embedding/engine/loader/FlutterLoader;");
                return;
            }
        }
        PUBLIC_AOT_SHARED_LIBRARY_NAME = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + AOT_SHARED_LIBRARY_NAME;
        PUBLIC_VM_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + VM_SNAPSHOT_DATA_KEY;
        PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + ISOLATE_SNAPSHOT_DATA_KEY;
        PUBLIC_FLUTTER_ASSETS_DIR_KEY = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + FLUTTER_ASSETS_DIR_KEY;
    }

    public FlutterLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.aotSharedLibraryName = DEFAULT_AOT_SHARED_LIBRARY_NAME;
        this.vmSnapshotData = DEFAULT_VM_SNAPSHOT_DATA;
        this.isolateSnapshotData = DEFAULT_ISOLATE_SNAPSHOT_DATA;
        this.flutterAssetsDir = DEFAULT_FLUTTER_ASSETS_DIR;
        this.initialized = false;
    }

    @NonNull
    private String fullAssetPathFrom(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            return this.flutterAssetsDir + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    private ApplicationInfo getApplicationInfo(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    @NonNull
    public static FlutterLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (instance == null) {
                instance = new FlutterLoader();
            }
            return instance;
        }
        return (FlutterLoader) invokeV.objValue;
    }

    private void initConfig(@NonNull Context context) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) || (bundle = getApplicationInfo(context).metaData) == null) {
            return;
        }
        this.aotSharedLibraryName = bundle.getString(PUBLIC_AOT_SHARED_LIBRARY_NAME, DEFAULT_AOT_SHARED_LIBRARY_NAME);
        this.flutterAssetsDir = bundle.getString(PUBLIC_FLUTTER_ASSETS_DIR_KEY, DEFAULT_FLUTTER_ASSETS_DIR);
        this.vmSnapshotData = bundle.getString(PUBLIC_VM_SNAPSHOT_DATA_KEY, DEFAULT_VM_SNAPSHOT_DATA);
        this.isolateSnapshotData = bundle.getString(PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY, DEFAULT_ISOLATE_SNAPSHOT_DATA);
    }

    private void initResources(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            new ResourceCleaner(context).start();
        }
    }

    public void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, strArr) == null) || this.initialized) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                try {
                    if (this.resourceExtractor != null) {
                        this.resourceExtractor.waitForCompletion();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    ApplicationInfo applicationInfo = getApplicationInfo(context);
                    arrayList.add("--icu-native-lib-path=" + applicationInfo.nativeLibraryDir + File.separator + DEFAULT_LIBRARY);
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + applicationInfo.nativeLibraryDir + File.separator + this.aotSharedLibraryName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("--cache-dir-path=");
                    sb.append(PathUtils.getCacheDirectory(context));
                    arrayList.add(sb.toString());
                    if (this.settings.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.settings.getLogTag());
                    }
                    FlutterJNI.nativeInit(context, (String[]) arrayList.toArray(new String[0]), null, PathUtils.getFilesDir(context), PathUtils.getCacheDirectory(context));
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
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, strArr, handler, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.settings != null) {
                    if (this.initialized) {
                        handler.post(runnable);
                        return;
                    } else {
                        new Thread(new Runnable(this, context, strArr, handler, runnable) { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1
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
                                    if (this.this$0.resourceExtractor != null) {
                                        this.this$0.resourceExtractor.waitForCompletion();
                                    }
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1.1
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
                                                AnonymousClass1 anonymousClass1 = this.this$1;
                                                anonymousClass1.this$0.ensureInitializationComplete(anonymousClass1.val$applicationContext.getApplicationContext(), this.this$1.val$args);
                                                AnonymousClass1 anonymousClass12 = this.this$1;
                                                anonymousClass12.val$callbackHandler.post(anonymousClass12.val$callback);
                                            }
                                        }
                                    });
                                }
                            }
                        }).start();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flutterAssetsDir : (String) invokeV.objValue;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? fullAssetPathFrom(str) : (String) invokeL.objValue;
    }

    public void startInitialization(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            startInitialization(context, new Settings());
        }
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            return getLookupKeyForAsset("packages" + File.separator + str2 + File.separator + str);
        }
        return (String) invokeLL.objValue;
    }

    public void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, context, settings) == null) && this.settings == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Context applicationContext = context.getApplicationContext();
                this.settings = settings;
                long uptimeMillis = SystemClock.uptimeMillis();
                initConfig(applicationContext);
                initResources(applicationContext);
                System.loadLibrary("flutter");
                VsyncWaiter.getInstance((WindowManager) applicationContext.getSystemService("window")).init();
                FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - uptimeMillis);
                return;
            }
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
    }
}
