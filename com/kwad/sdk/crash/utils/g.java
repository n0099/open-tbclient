package com.kwad.sdk.crash.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tachikoma.core.utility.FileUtil;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f58778b;

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f58779c;

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f58780d;

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f58781e;

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f58782f;

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f58783g;

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f58784h;

    /* renamed from: i  reason: collision with root package name */
    public static final char f58785i;

    /* renamed from: j  reason: collision with root package name */
    public static final BigInteger f58786j;

    /* renamed from: k  reason: collision with root package name */
    public static final BigInteger f58787k;
    public static final File[] l;
    public static final String m;
    public static final Charset n;
    public static final char o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639243221, "Lcom/kwad/sdk/crash/utils/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639243221, "Lcom/kwad/sdk/crash/utils/g;");
                return;
            }
        }
        a = Charset.forName("US-ASCII");
        f58778b = Charset.forName("UTF-8");
        BigInteger valueOf = BigInteger.valueOf(1024L);
        f58779c = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        f58780d = multiply;
        BigInteger multiply2 = f58779c.multiply(multiply);
        f58781e = multiply2;
        BigInteger multiply3 = f58779c.multiply(multiply2);
        f58782f = multiply3;
        BigInteger multiply4 = f58779c.multiply(multiply3);
        f58783g = multiply4;
        f58784h = f58779c.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(LockFreeTaskQueueCore.FROZEN_MASK));
        f58786j = multiply5;
        f58787k = f58779c.multiply(multiply5);
        l = new File[0];
        m = Character.toString('.');
        n = Charset.forName("UTF-8");
        o = File.separatorChar;
        f58785i = a() ? '/' : FileUtil.WINDOWS_SEPARATOR;
    }

    public static FileInputStream a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (!file.exists()) {
                throw new FileNotFoundException("File '" + file + "' does not exist");
            } else if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (file.canRead()) {
                return new FileInputStream(file);
            } else {
                throw new IOException("File '" + file + "' cannot be read");
            }
        }
        return (FileInputStream) invokeL.objValue;
    }

    public static FileOutputStream a(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, file, z)) == null) {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
            } else if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
            return new FileOutputStream(file, z);
        }
        return (FileOutputStream) invokeLZ.objValue;
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, file, charset)) != null) {
            return (String) invokeLL.objValue;
        }
        try {
            fileInputStream = a(file);
            try {
                String a2 = h.a(fileInputStream, a.a(charset));
                b.a((InputStream) fileInputStream);
                return a2;
            } catch (Throwable th) {
                th = th;
                b.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void a(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2) == null) {
            a(file, file2, true);
        }
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{file, file2, fileFilter, Boolean.valueOf(z)}) == null) {
            if (file == null) {
                throw new NullPointerException("Source must not be null");
            }
            if (file2 == null) {
                throw new NullPointerException("Destination must not be null");
            }
            if (!file.exists()) {
                throw new FileNotFoundException("Source '" + file + "' does not exist");
            } else if (!file.isDirectory()) {
                throw new IOException("Source '" + file + "' exists but is not a directory");
            } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            } else {
                ArrayList arrayList = null;
                if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                    File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                    if (listFiles != null && listFiles.length > 0) {
                        arrayList = new ArrayList(listFiles.length);
                        for (File file3 : listFiles) {
                            arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                        }
                    }
                }
                a(file, file2, fileFilter, z, arrayList);
            }
        }
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{file, file2, fileFilter, Boolean.valueOf(z), list}) == null) {
            File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (!file2.canWrite()) {
                throw new IOException("Destination '" + file2 + "' cannot be written to");
            }
            for (File file3 : listFiles) {
                File file4 = new File(file2, file3.getName());
                if (list == null || !list.contains(file3.getCanonicalPath())) {
                    if (file3.isDirectory()) {
                        a(file3, file4, fileFilter, z, list);
                    } else {
                        b(file3, file4, z);
                    }
                }
            }
            if (z) {
                file2.setLastModified(file.lastModified());
            }
        }
    }

    public static void a(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, file, file2, z) == null) {
            a(file, file2, null, z);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? o == '\\' : invokeV.booleanValue;
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, file) == null) && file.exists()) {
            if (!f(file)) {
                c(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00aa */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static void b(File file, File file2, boolean z) {
        FileInputStream fileInputStream;
        ?? r4;
        FileChannel fileChannel;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLZ(65546, null, file, file2, z) != null) {
            return;
        }
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r4 = 0;
        }
        try {
            r4 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel2 = r4.getChannel();
                    long size = fileChannel.size();
                    long j2 = 0;
                    while (j2 < size) {
                        long j3 = size - j2;
                        j2 += fileChannel2.transferFrom(fileChannel, j2, j3 > 31457280 ? 31457280L : j3);
                    }
                    b.a(fileChannel2);
                    b.a((OutputStream) r4);
                    b.a(fileChannel);
                    b.a((InputStream) fileInputStream);
                    if (file.length() == file2.length()) {
                        if (z) {
                            file2.setLastModified(file.lastModified());
                            return;
                        }
                        return;
                    }
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                } catch (Throwable th2) {
                    th = th2;
                    b.a(fileChannel2);
                    b.a((OutputStream) r4);
                    b.a(fileChannel);
                    b.a((InputStream) fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
        } catch (Throwable th4) {
            th = th4;
            r4 = 0;
            fileChannel = r4;
            b.a(fileChannel2);
            b.a((OutputStream) r4);
            b.a(fileChannel);
            b.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, file) == null) {
            if (!file.exists()) {
                throw new IllegalArgumentException(file + " does not exist");
            } else if (!file.isDirectory()) {
                throw new IllegalArgumentException(file + " is not a directory");
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    throw new IOException("Failed to list contents of " + file);
                }
                IOException e2 = null;
                for (File file2 : listFiles) {
                    try {
                        e(file2);
                    } catch (IOException e3) {
                        e2 = e3;
                    }
                }
                if (e2 != null) {
                    throw e2;
                }
            }
        }
    }

    public static String d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, file)) == null) ? a(file, Charset.defaultCharset()) : (String) invokeL.objValue;
    }

    public static void e(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, file) == null) {
            if (file.isDirectory()) {
                b(file);
                return;
            }
            boolean exists = file.exists();
            if (file.delete()) {
                return;
            }
            if (exists) {
                throw new IOException("Unable to delete file: " + file);
            }
            throw new FileNotFoundException("File does not exist: " + file);
        }
    }

    public static boolean f(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, file)) == null) {
            if (file != null) {
                if (a()) {
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
}
