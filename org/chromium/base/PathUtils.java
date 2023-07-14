package org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.PathUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.task.AsyncTask;
@MainDex
/* loaded from: classes2.dex */
public abstract class PathUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CACHE_DIRECTORY = 2;
    public static final int DATA_DIRECTORY = 0;
    public static final int NUM_DIRECTORIES = 3;
    public static final String TAG = "PathUtils";
    public static final int THUMBNAIL_DIRECTORY = 1;
    public static final String THUMBNAIL_DIRECTORY_NAME = "textures";
    public static String sCacheSubDirectory;
    public static String sDataDirectorySuffix;
    public static FutureTask<String[]> sDirPathFetchTask;
    public static final AtomicBoolean sInitializationStarted = new AtomicBoolean();

    @NonNull
    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() {
        List arrayList = new ArrayList();
        StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
        try {
            File[] externalFilesDirs = ContextUtils.getApplicationContext().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
            if (externalFilesDirs != null) {
                arrayList = Arrays.asList(externalFilesDirs);
            }
            if (allowDiskWrites != null) {
                allowDiskWrites.close();
            }
            return toAbsolutePathStrings(arrayList);
        } catch (Throwable th) {
            if (allowDiskWrites != null) {
                try {
                    allowDiskWrites.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    public static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = ContextUtils.getApplicationContext().getApplicationInfo();
        int i = applicationInfo.flags;
        if ((i & 128) == 0 && (i & 1) != 0) {
            return "/system/lib/";
        }
        return applicationInfo.nativeLibraryDir;
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    public static void resetForTesting() {
        sInitializationStarted.set(false);
        sDirPathFetchTask = null;
        sDataDirectorySuffix = null;
        sCacheSubDirectory = null;
    }

    @SuppressLint({"NewApi"})
    public static void chmod(String str, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            Os.chmod(str, i);
        } catch (Exception unused) {
            Log.e("PathUtils", "Failed to set permissions for path \"" + str + "\"", new Object[0]);
        }
    }

    public static void setPrivateDataDirectorySuffix(String str, String str2) {
        if (!sInitializationStarted.getAndSet(true)) {
            sDataDirectorySuffix = str;
            sCacheSubDirectory = str2;
            sDirPathFetchTask = new FutureTask<>(new Callable() { // from class: com.baidu.tieba.xzb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? PathUtils.setPrivateDataDirectorySuffixInternal() : invokeV.objValue;
                }
            });
            AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
        }
    }

    public static String getDirectoryPath(int i) {
        return getOrComputeDirectoryPaths()[i];
    }

    public static void setPrivateDataDirectorySuffix(String str) {
        setPrivateDataDirectorySuffix(str, null);
    }

    @NonNull
    @CalledByNative
    public static String getDownloadsDirectory() {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                String str = getAllPrivateDownloadsDirectories()[0];
                if (allowDiskReads != null) {
                    allowDiskReads.close();
                }
                return str;
            }
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            if (allowDiskReads != null) {
                allowDiskReads.close();
            }
            return path;
        } catch (Throwable th) {
            if (allowDiskReads != null) {
                try {
                    allowDiskReads.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String[] getOrComputeDirectoryPaths() {
        if (!sDirPathFetchTask.isDone()) {
            StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
            try {
                sDirPathFetchTask.run();
                if (allowDiskWrites != null) {
                    allowDiskWrites.close();
                }
            } catch (Throwable th) {
                if (allowDiskWrites != null) {
                    try {
                        allowDiskWrites.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        try {
            return sDirPathFetchTask.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @RequiresApi(30)
    @CalledByNative
    public static String[] getExternalDownloadVolumesNames() {
        ArrayList arrayList = new ArrayList();
        for (String str : MediaStore.getExternalVolumeNames(ContextUtils.getApplicationContext())) {
            if (!TextUtils.isEmpty(str) && !str.contains("external_primary")) {
                arrayList.add(new File(((StorageManager) ContextUtils.getApplicationContext().getSystemService(StorageManager.class)).getStorageVolume(MediaStore.Files.getContentUri(str)).getDirectory().getAbsolutePath(), Environment.DIRECTORY_DOWNLOADS));
            }
        }
        return toAbsolutePathStrings(arrayList);
    }

    public static String[] setPrivateDataDirectorySuffixInternal() {
        String[] strArr = new String[3];
        Context applicationContext = ContextUtils.getApplicationContext();
        strArr[0] = applicationContext.getDir(sDataDirectorySuffix, 0).getPath();
        chmod(strArr[0], com.baidu.pass.face.platform.utils.FileUtils.S_IRWXU);
        strArr[1] = applicationContext.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (applicationContext.getCacheDir() != null) {
            if (sCacheSubDirectory == null) {
                strArr[2] = applicationContext.getCacheDir().getPath();
            } else {
                File file = new File(applicationContext.getCacheDir(), sCacheSubDirectory);
                file.mkdir();
                strArr[2] = file.getPath();
                chmod(strArr[2], 1472);
            }
        }
        return strArr;
    }

    @NonNull
    public static String[] toAbsolutePathStrings(@NonNull List<File> list) {
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
