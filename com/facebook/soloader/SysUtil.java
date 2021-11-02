package com.facebook.soloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.facebook.soloader.MinElf;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
/* loaded from: classes11.dex */
public final class SysUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte APK_SIGNATURE_VERSION = 1;
    public static final String TAG = "SysUtil";
    public transient /* synthetic */ FieldHolder $fh;

    @DoNotOptimize
    @TargetApi(21)
    /* loaded from: classes11.dex */
    public static final class LollipopSysdeps {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public LollipopSysdeps() {
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

        @DoNotOptimize
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(65537, null, fileDescriptor, j) == null) {
                try {
                    Os.posix_fallocate(fileDescriptor, 0L, j);
                } catch (ErrnoException e2) {
                    int i2 = e2.errno;
                    if (i2 != OsConstants.EOPNOTSUPP && i2 != OsConstants.ENOSYS && i2 != OsConstants.EINVAL) {
                        throw new IOException(e2.toString(), e2);
                    }
                }
            }
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                String[] strArr = Build.SUPPORTED_ABIS;
                TreeSet treeSet = new TreeSet();
                try {
                    if (is64Bit()) {
                        treeSet.add(MinElf.ISA.AARCH64.toString());
                        treeSet.add(MinElf.ISA.X86_64.toString());
                    } else {
                        treeSet.add(MinElf.ISA.ARM.toString());
                        treeSet.add(MinElf.ISA.X86.toString());
                    }
                    ArrayList arrayList = new ArrayList();
                    for (String str : strArr) {
                        if (treeSet.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                    return (String[]) arrayList.toArray(new String[arrayList.size()]);
                } catch (ErrnoException e2) {
                    String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", Arrays.toString(strArr), Integer.valueOf(e2.errno), e2.getMessage());
                    return Build.SUPPORTED_ABIS;
                }
            }
            return (String[]) invokeV.objValue;
        }

        @DoNotOptimize
        public static boolean is64Bit() throws ErrnoException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Os.readlink("/proc/self/exe").contains(WebKitFactory.OS_64) : invokeV.booleanValue;
        }
    }

    @DoNotOptimize
    @TargetApi(23)
    /* loaded from: classes11.dex */
    public static final class MarshmallowSysdeps {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MarshmallowSysdeps() {
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

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                String[] strArr = Build.SUPPORTED_ABIS;
                TreeSet treeSet = new TreeSet();
                if (is64Bit()) {
                    treeSet.add(MinElf.ISA.AARCH64.toString());
                    treeSet.add(MinElf.ISA.X86_64.toString());
                } else {
                    treeSet.add(MinElf.ISA.ARM.toString());
                    treeSet.add(MinElf.ISA.X86.toString());
                }
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return (String[]) invokeV.objValue;
        }

        @DoNotOptimize
        public static boolean is64Bit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Process.is64Bit() : invokeV.booleanValue;
        }
    }

    public SysUtil() {
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

    public static int copyBytes(RandomAccessFile randomAccessFile, InputStream inputStream, int i2, byte[] bArr) throws IOException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, randomAccessFile, inputStream, i2, bArr)) == null) {
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, 0, Math.min(bArr.length, i2 - i3));
                if (read == -1) {
                    break;
                }
                randomAccessFile.write(bArr, 0, read);
                i3 += read;
            }
            return i3;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, strArr, str)) == null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2] != null && str.equals(strArr[i2])) {
                    return i2;
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, file) == null) {
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
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f40168a);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return MarshmallowSysdeps.getSupportedAbis();
            }
            return i2 >= 21 ? LollipopSysdeps.getSupportedAbis() : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return (String[]) invokeV.objValue;
    }

    @SuppressLint({"CatchGeneralException"})
    public static boolean is64Bit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return MarshmallowSysdeps.is64Bit();
            }
            if (i2 >= 21) {
                try {
                    return LollipopSysdeps.is64Bit();
                } catch (Exception e2) {
                    String.format("Could not read /proc/self/exe. Err msg: %s", e2.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static byte[] makeApkDepBlock(File file, Context context) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, file, context)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65547, null, file) == null) || file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("cannot mkdir: " + file);
    }
}
