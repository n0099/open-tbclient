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
import com.baidu.android.common.others.IStringUtil;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes7.dex */
public class FlutterLoader {
    public static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
    public static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
    public static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
    public static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    public static final String DEFAULT_LIBRARY = "libflutter.so";
    public static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
    public static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    public static final String TAG = "FlutterLoader";
    public static FlutterLoader instance;
    @Nullable
    public ResourceExtractor resourceExtractor;
    @Nullable
    public Settings settings;
    public static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + AOT_SHARED_LIBRARY_NAME;
    public static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + VM_SNAPSHOT_DATA_KEY;
    public static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + ISOLATE_SNAPSHOT_DATA_KEY;
    public static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY = FlutterLoader.class.getName() + IStringUtil.EXTENSION_SEPARATOR + FLUTTER_ASSETS_DIR_KEY;
    public String aotSharedLibraryName = DEFAULT_AOT_SHARED_LIBRARY_NAME;
    public String vmSnapshotData = DEFAULT_VM_SNAPSHOT_DATA;
    public String isolateSnapshotData = DEFAULT_ISOLATE_SNAPSHOT_DATA;
    public String flutterAssetsDir = DEFAULT_FLUTTER_ASSETS_DIR;
    public boolean initialized = false;

    /* loaded from: classes7.dex */
    public static class Settings {
        public String logTag;

        @Nullable
        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    @NonNull
    private String fullAssetPathFrom(@NonNull String str) {
        return this.flutterAssetsDir + File.separator + str;
    }

    @NonNull
    private ApplicationInfo getApplicationInfo(@NonNull Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    public static FlutterLoader getInstance() {
        if (instance == null) {
            instance = new FlutterLoader();
        }
        return instance;
    }

    private void initConfig(@NonNull Context context) {
        Bundle bundle = getApplicationInfo(context).metaData;
        if (bundle == null) {
            return;
        }
        this.aotSharedLibraryName = bundle.getString(PUBLIC_AOT_SHARED_LIBRARY_NAME, DEFAULT_AOT_SHARED_LIBRARY_NAME);
        this.flutterAssetsDir = bundle.getString(PUBLIC_FLUTTER_ASSETS_DIR_KEY, DEFAULT_FLUTTER_ASSETS_DIR);
        this.vmSnapshotData = bundle.getString(PUBLIC_VM_SNAPSHOT_DATA_KEY, DEFAULT_VM_SNAPSHOT_DATA);
        this.isolateSnapshotData = bundle.getString(PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY, DEFAULT_ISOLATE_SNAPSHOT_DATA);
    }

    private void initResources(@NonNull Context context) {
        new ResourceCleaner(context).start();
    }

    public void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        if (this.initialized) {
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

    public void ensureInitializationCompleteAsync(@NonNull final Context context, @Nullable final String[] strArr, @NonNull final Handler handler, @NonNull final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                if (this.initialized) {
                    handler.post(runnable);
                    return;
                } else {
                    new Thread(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FlutterLoader.this.resourceExtractor != null) {
                                FlutterLoader.this.resourceExtractor.waitForCompletion();
                            }
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    FlutterLoader.this.ensureInitializationComplete(context.getApplicationContext(), strArr);
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    handler.post(runnable);
                                }
                            });
                        }
                    }).start();
                    return;
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    @NonNull
    public String findAppBundlePath() {
        return this.flutterAssetsDir;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str) {
        return fullAssetPathFrom(str);
    }

    public void startInitialization(@NonNull Context context) {
        startInitialization(context, new Settings());
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        return getLookupKeyForAsset("packages" + File.separator + str2 + File.separator + str);
    }

    public void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        if (this.settings != null) {
            return;
        }
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
