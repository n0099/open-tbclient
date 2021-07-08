package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* loaded from: classes9.dex */
public class ResourceExtractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] SUPPORTED_ABIS;
    public static final String TAG = "ResourceExtractor";
    public static final String TIMESTAMP_PREFIX = "res_timestamp-";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AssetManager mAssetManager;
    @NonNull
    public final String mDataDirPath;
    public ExtractTask mExtractTask;
    @NonNull
    public final PackageManager mPackageManager;
    @NonNull
    public final String mPackageName;
    @NonNull
    public final HashSet<String> mResources;

    /* loaded from: classes9.dex */
    public static class ExtractTask extends AsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final AssetManager mAssetManager;
        @NonNull
        public final String mDataDirPath;
        @NonNull
        public final PackageManager mPackageManager;
        @NonNull
        public final String mPackageName;
        @NonNull
        public final HashSet<String> mResources;

        public ExtractTask(@NonNull String str, @NonNull HashSet<String> hashSet, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hashSet, str2, packageManager, assetManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDataDirPath = str;
            this.mResources = hashSet;
            this.mAssetManager = assetManager;
            this.mPackageName = str2;
            this.mPackageManager = packageManager;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @WorkerThread
        private boolean extractAPK(@NonNull File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) {
                Iterator<String> it = this.mResources.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    try {
                        String str = "assets/" + next;
                        File file2 = new File(file, next);
                        if (!file2.exists()) {
                            if (file2.getParentFile() != null) {
                                file2.getParentFile().mkdirs();
                            }
                            InputStream open = this.mAssetManager.open(next);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                ResourceExtractor.copy(open, fileOutputStream);
                                fileOutputStream.close();
                                if (open != null) {
                                    open.close();
                                }
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                    break;
                                } catch (Throwable th2) {
                                    if (open != null) {
                                        try {
                                            open.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                    }
                                    throw th2;
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException unused) {
                    } catch (IOException e2) {
                        Log.w(ResourceExtractor.TAG, "Exception unpacking resources: " + e2.getMessage());
                        ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                File file = new File(this.mDataDirPath);
                String checkTimestamp = ResourceExtractor.checkTimestamp(file, this.mPackageManager, this.mPackageName);
                if (checkTimestamp == null) {
                    return null;
                }
                ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
                if (extractAPK(file) && checkTimestamp != null) {
                    try {
                        new File(file, checkTimestamp).createNewFile();
                    } catch (IOException unused) {
                        Log.w(ResourceExtractor.TAG, "Failed to write resource timestamp");
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(635504028, "Lio/flutter/embedding/engine/loader/ResourceExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(635504028, "Lio/flutter/embedding/engine/loader/ResourceExtractor;");
                return;
            }
        }
        SUPPORTED_ABIS = getSupportedAbis();
    }

    public ResourceExtractor(@NonNull String str, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, packageManager, assetManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDataDirPath = str;
        this.mPackageName = str2;
        this.mPackageManager = packageManager;
        this.mAssetManager = assetManager;
        this.mResources = new HashSet<>();
    }

    public static String checkTimestamp(@NonNull File file, @NonNull PackageManager packageManager, @NonNull String str) {
        InterceptResult invokeLLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, file, packageManager, str)) == null) {
            try {
                if (packageManager.getPackageInfo(str, 0) == null) {
                    return TIMESTAMP_PREFIX;
                }
                String str2 = TIMESTAMP_PREFIX + getVersionCode(packageInfo) + "-" + packageInfo.lastUpdateTime;
                String[] existingTimestamps = getExistingTimestamps(file);
                if (existingTimestamps == null) {
                    return str2;
                }
                int length = existingTimestamps.length;
                if (existingTimestamps.length == 1 && str2.equals(existingTimestamps[0])) {
                    return null;
                }
                return str2;
            } catch (PackageManager.NameNotFoundException unused) {
                return TIMESTAMP_PREFIX;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static void copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream, outputStream) != null) {
            return;
        }
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void deleteFiles(@NonNull String str, @NonNull HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, hashSet) == null) {
            File file = new File(str);
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                File file2 = new File(file, it.next());
                if (file2.exists()) {
                    file2.delete();
                }
            }
            String[] existingTimestamps = getExistingTimestamps(file);
            if (existingTimestamps == null) {
                return;
            }
            for (String str2 : existingTimestamps) {
                new File(file, str2).delete();
            }
        }
    }

    public static String[] getExistingTimestamps(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) ? file.list(new FilenameFilter() { // from class: io.flutter.embedding.engine.loader.ResourceExtractor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, str)) == null) ? str.startsWith(ResourceExtractor.TIMESTAMP_PREFIX) : invokeLL.booleanValue;
            }
        }) : (String[]) invokeL.objValue;
    }

    public static String[] getSupportedAbis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return Build.SUPPORTED_ABIS;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(Build.CPU_ABI, Build.CPU_ABI2));
            arrayList.removeAll(Arrays.asList(null, ""));
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeV.objValue;
    }

    public static long getVersionCode(@NonNull PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, packageInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        }
        return invokeL.longValue;
    }

    public ResourceExtractor addResource(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mResources.add(str);
            return this;
        }
        return (ResourceExtractor) invokeL.objValue;
    }

    public ResourceExtractor addResources(@NonNull Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            this.mResources.addAll(collection);
            return this;
        }
        return (ResourceExtractor) invokeL.objValue;
    }

    public ResourceExtractor start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ExtractTask extractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
            this.mExtractTask = extractTask;
            extractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return this;
        }
        return (ResourceExtractor) invokeV.objValue;
    }

    public void waitForCompletion() {
        ExtractTask extractTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (extractTask = this.mExtractTask) == null) {
            return;
        }
        try {
            extractTask.get();
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            deleteFiles(this.mDataDirPath, this.mResources);
        }
    }
}
