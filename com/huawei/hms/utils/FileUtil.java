package com.huawei.hms.utils;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public abstract class FileUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;
    public static boolean a;
    public static ScheduledExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a(File file, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = j;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File file = this.a;
                if (file == null) {
                    HMSLog.e(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, "In writeFile Failed to get local file.");
                    return;
                }
                File parentFile = file.getParentFile();
                if (parentFile != null && (parentFile.mkdirs() || parentFile.isDirectory())) {
                    RandomAccessFile randomAccessFile = null;
                    try {
                        try {
                            long length = this.a.length();
                            if (length > this.b) {
                                String canonicalPath = this.a.getCanonicalPath();
                                if (!this.a.delete()) {
                                    HMSLog.e(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, "last file delete failed.");
                                }
                                randomAccessFile = new RandomAccessFile(new File(canonicalPath), "rw");
                            } else {
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.a, "rw");
                                try {
                                    randomAccessFile2.seek(length);
                                    randomAccessFile = randomAccessFile2;
                                } catch (IOException e) {
                                    e = e;
                                    randomAccessFile = randomAccessFile2;
                                    HMSLog.e(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, "writeFile exception:", e);
                                    IOUtils.closeQuietly(randomAccessFile);
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile = randomAccessFile2;
                                    IOUtils.closeQuietly(randomAccessFile);
                                    throw th;
                                }
                            }
                            randomAccessFile.writeBytes(this.c + System.getProperty("line.separator"));
                        } catch (IOException e2) {
                            e = e2;
                        }
                        IOUtils.closeQuietly(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    HMSLog.e(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, "In writeFile, Failed to create directory.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1624614704, "Lcom/huawei/hms/utils/FileUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1624614704, "Lcom/huawei/hms/utils/FileUtil;");
                return;
            }
        }
        b = Executors.newSingleThreadScheduledExecutor();
    }

    public FileUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean verifyHash(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, file)) == null) {
            byte[] digest = SHA256.digest(file);
            if (digest != null && HEX.encodeHexString(digest, true).equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void writeFile(File file, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{file, str, Long.valueOf(j)}) == null) {
            b.execute(new a(file, j, str));
        }
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, file, file2, str, Long.valueOf(j), Integer.valueOf(i)}) == null) && file != null && file.isFile() && file.exists()) {
            if (!a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, "file delete failed.");
                }
                a = true;
            }
            writeFile(file2, str + "|" + j + "|" + i, 10240L);
        }
    }
}
