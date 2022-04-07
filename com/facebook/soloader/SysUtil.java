package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public final class SysUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte APK_SIGNATURE_VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    @DoNotOptimize
    @TargetApi(21)
    /* loaded from: classes4.dex */
    public static final class LollipopSysdeps {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public LollipopSysdeps() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @DoNotOptimize
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(65537, null, fileDescriptor, j) == null) {
                try {
                    Os.posix_fallocate(fileDescriptor, 0L, j);
                } catch (ErrnoException e) {
                    int i = e.errno;
                    if (i != OsConstants.EOPNOTSUPP && i != OsConstants.ENOSYS && i != OsConstants.EINVAL) {
                        throw new IOException(e.toString(), e);
                    }
                }
            }
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.SUPPORTED_ABIS : (String[]) invokeV.objValue;
        }
    }

    public SysUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int copyBytes(RandomAccessFile randomAccessFile, InputStream inputStream, int i, byte[] bArr) throws IOException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, randomAccessFile, inputStream, i, bArr)) == null) {
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, 0, Math.min(bArr.length, i - i2));
                if (read == -1) {
                    break;
                }
                randomAccessFile.write(bArr, 0, read);
                i2 += read;
            }
            return i2;
        }
        return invokeLLIL.intValue;
    }

    public static void deleteOrThrow(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, file) == null) || file.delete()) {
            return;
        }
        throw new IOException("could not delete file " + file);
    }

    public static void dumbDeleteRecursive(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    dumbDeleteRecursive(file2);
                }
            }
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("could not delete: " + file);
        }
    }

    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, fileDescriptor, j) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        LollipopSysdeps.fallocateIfSupported(fileDescriptor, j);
    }

    public static int findAbiScore(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, strArr, str)) == null) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] != null && str.equals(strArr[i])) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static void fsyncRecursive(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, file) == null) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        fsyncRecursive(file2);
                    }
                    return;
                }
                throw new IOException("cannot list directory " + file);
            } else if (!file.getPath().endsWith("_lock")) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    randomAccessFile.getFD().sync();
                    randomAccessFile.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    public static int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String[] getSupportedAbis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Build.VERSION.SDK_INT < 21 ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : LollipopSysdeps.getSupportedAbis() : (String[]) invokeV.objValue;
    }

    public static byte[] makeApkDepBlock(File file, Context context) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, file, context)) == null) {
            File canonicalFile = file.getCanonicalFile();
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeByte((byte) 1);
                obtain.writeString(canonicalFile.getPath());
                obtain.writeLong(canonicalFile.lastModified());
                obtain.writeInt(getAppVersionCode(context));
                return obtain.marshall();
            } finally {
                obtain.recycle();
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static void mkdirOrThrow(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, file) == null) || file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("cannot mkdir: " + file);
    }
}
