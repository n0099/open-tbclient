package com.repackage;

import android.os.Environment;
import android.os.StatFs;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
/* loaded from: classes6.dex */
public class ki {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "baidu";
    public static final File b;
    public static final char c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964035481, "Lcom/repackage/ki;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964035481, "Lcom/repackage/ki;");
                return;
            }
        }
        b = Environment.getExternalStorageDirectory();
        c = File.separatorChar;
    }

    public static void A(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, outputStream) == null) {
            outputStream.write(new byte[]{Base64.INTERNAL_PADDING, 33, 65, 77, 82, 10}, 0, 6);
        }
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            File file = new File(q(t(str, str2)));
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String w = w(str);
            if (c()) {
                File file = new File(w);
                return file.exists() || file.mkdirs();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                StatFs statFs = new StatFs(b.getPath());
                return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void e(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, file) == null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        IOException e = null;
                        for (File file2 : listFiles) {
                            try {
                                p(file2);
                            } catch (IOException e2) {
                                e = e2;
                            }
                        }
                        if (e != null) {
                            throw e;
                        }
                        return;
                    }
                    throw new IOException("Failed to list contents of " + file);
                }
                throw new IllegalArgumentException(file + " is not a directory");
            }
            throw new IllegalArgumentException(file + " does not exist");
        }
    }

    public static void f(File file, File file2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, file, file2) == null) {
            g(file, file2, true);
        }
    }

    public static void g(File file, File file2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, file, file2, z) == null) {
            if (file == null) {
                throw new NullPointerException("Source must not be null");
            }
            if (file2 != null) {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                            File parentFile = file2.getParentFile();
                            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
                            } else if (file2.exists() && !file2.canWrite()) {
                                throw new IOException("Destination '" + file2 + "' exists but is read-only");
                            } else {
                                o(file, file2, z);
                                return;
                            }
                        }
                        throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
                    }
                    throw new IOException("Source '" + file + "' exists but is a directory");
                }
                throw new FileNotFoundException("Source '" + file + "' does not exist");
            }
            throw new NullPointerException("Destination must not be null");
        }
    }

    public static File h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (b(str)) {
                try {
                    if (a(str, str2)) {
                        File r = r(str, str2);
                        if (!r.exists() || r.delete()) {
                            if (r.createNewFile()) {
                                return r;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static File i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? j(null, str) : (File) invokeL.objValue;
    }

    public static File j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            if (b(str)) {
                try {
                    File r = r(str, str2);
                    if (r.exists()) {
                        return r;
                    }
                    if (r.createNewFile()) {
                        return r;
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? l(null, str) : invokeL.booleanValue;
    }

    public static boolean l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            if (b(str)) {
                File r = r(str, str2);
                try {
                    if (r.exists()) {
                        return r.delete();
                    }
                    return false;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void m(File file) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, file) == null) && file.exists()) {
            if (!y(file)) {
                e(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean n(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (file.isDirectory()) {
                    e(file);
                }
            } catch (Exception unused) {
            }
            try {
                return file.delete();
            } catch (Exception unused2) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00ad */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static void o(File file, File file2, boolean z) throws IOException {
        FileInputStream fileInputStream;
        ?? r6;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLZ(65552, null, file, file2, z) != null) {
            return;
        }
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel3 = 0;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                r6 = new FileOutputStream(file2);
            } catch (Error e) {
                e = e;
                obj = null;
                fileChannel2 = null;
            } catch (Throwable th) {
                th = th;
                r6 = 0;
                fileChannel2 = r6;
                ri.d(fileChannel3);
                ri.f(r6);
                ri.d(fileChannel2);
                ri.e(fileInputStream);
                throw th;
            }
        } catch (Error e2) {
            e = e2;
            fileChannel = null;
            r6 = 0;
            fileChannel2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            r6 = 0;
        }
        try {
            fileChannel2 = fileInputStream.getChannel();
            try {
                fileChannel3 = r6.getChannel();
                long size = fileChannel2.size();
                long j = 0;
                while (j < size) {
                    long j2 = size - j;
                    j += fileChannel3.transferFrom(fileChannel2, j, j2 > 31457280 ? 31457280L : j2);
                }
                ri.d(fileChannel3);
                ri.f(r6);
                ri.d(fileChannel2);
                ri.e(fileInputStream);
                if (file.length() == file2.length()) {
                    if (z) {
                        file2.setLastModified(file.lastModified());
                        return;
                    }
                    return;
                }
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            } catch (Error e3) {
                e = e3;
                fileChannel = fileChannel3;
                fileChannel3 = fileInputStream;
                r6 = r6;
                try {
                    throw new IOException("Failed Error to copy contents from '" + file + "' to '" + file2 + "' with " + e.toString());
                } catch (Throwable th3) {
                    th = th3;
                    FileChannel fileChannel4 = fileChannel;
                    fileInputStream = fileChannel3;
                    fileChannel3 = fileChannel4;
                    ri.d(fileChannel3);
                    ri.f(r6);
                    ri.d(fileChannel2);
                    ri.e(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                ri.d(fileChannel3);
                ri.f(r6);
                ri.d(fileChannel2);
                ri.e(fileInputStream);
                throw th;
            }
        } catch (Error e4) {
            e = e4;
            fileChannel2 = null;
            obj = r6;
            fileChannel3 = fileInputStream;
            fileChannel = fileChannel2;
            r6 = obj;
            throw new IOException("Failed Error to copy contents from '" + file + "' to '" + file2 + "' with " + e.toString());
        } catch (Throwable th5) {
            th = th5;
            fileChannel2 = null;
        }
    }

    public static void p(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, file) == null) {
            if (file.isDirectory()) {
                m(file);
                return;
            }
            boolean exists = file.exists();
            if (file.delete()) {
                return;
            }
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        }
        return (String) invokeL.objValue;
    }

    public static File r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, str2)) == null) {
            if (b(str)) {
                try {
                    return new File(t(str, str2));
                } catch (SecurityException e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) ? t(null, str) : (String) invokeL.objValue;
    }

    public static String t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) {
            if (str != null) {
                return b + "/" + a + "/" + str + "/" + str2;
            }
            return b + "/" + a + "/" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static long u(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, file)) == null) {
            long j = 0;
            FileInputStream fileInputStream = null;
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        j = fileInputStream2.available();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        ng.c(fileInputStream);
                        throw th;
                    }
                    fileInputStream = fileInputStream2;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            ng.c(fileInputStream);
            return j;
        }
        return invokeL.longValue;
    }

    public static InputStream v(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, file)) == null) {
            if (file != null) {
                try {
                    return new FileInputStream(file);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    public static String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            if (str != null) {
                return b + "/" + a + "/" + str + "/";
            }
            return b + "/" + a + "/";
        }
        return (String) invokeL.objValue;
    }

    public static int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState.equals("mounted")) {
                return 0;
            }
            if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable") || externalStorageState.equals("removed")) {
                return 1;
            }
            return externalStorageState.equals(SwanKV.FLAVOR_SHARED) ? 2 : 3;
        }
        return invokeV.intValue;
    }

    public static boolean y(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, file)) == null) {
            if (file != null) {
                if (z()) {
                    return false;
                }
                if (file.getParent() != null) {
                    file = new File(file.getParentFile().getCanonicalFile(), file.getName());
                }
                return !file.getCanonicalFile().equals(file.getAbsoluteFile());
            }
            throw new NullPointerException("File must not be null");
        }
        return invokeL.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? c == '\\' : invokeV.booleanValue;
    }
}
