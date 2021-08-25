package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f68643a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f68644b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-752059374, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-752059374, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/l;");
                return;
            }
        }
        f68643a = new byte[]{80, 75, 3, 4};
        f68644b = new byte[]{80, 75, 5, 6};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        ?? fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65537, null, inputStream, str, str2) != null) {
            return;
        }
        ZipInputStream zipInputStream = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        if (!z) {
                            inputStream.reset();
                            if (!a(inputStream)) {
                                throw new RuntimeException("not zip file  channel:" + str2);
                            }
                            throw new RuntimeException("unzip file: channel:" + str2);
                        }
                        b.a(zipInputStream2);
                        return;
                    }
                    z = true;
                    String name = nextEntry.getName();
                    if (!a(name)) {
                        if (name.startsWith(str2 + File.separator)) {
                            if (nextEntry.isDirectory()) {
                                File file = new File(canonicalPath, name);
                                if (file.getCanonicalPath().startsWith(canonicalPath)) {
                                    file.mkdirs();
                                } else {
                                    throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                                }
                            } else {
                                String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                                if (canonicalPath2.startsWith(canonicalPath)) {
                                    File file2 = new File(canonicalPath2);
                                    file2.getParentFile().mkdirs();
                                    try {
                                        fileOutputStream = new FileOutputStream(file2);
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                    try {
                                        d.a(zipInputStream2, fileOutputStream);
                                        b.a((Closeable) fileOutputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        zipInputStream = fileOutputStream;
                                        b.a(zipInputStream);
                                        throw th;
                                    }
                                } else {
                                    throw new RuntimeException("directory traversal, file name:" + name);
                                }
                            }
                        } else {
                            throw new RuntimeException("the zip package outermost folder is not named by channel channel:" + str2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    b.a(zipInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.startsWith("__MACOSX/") || str.equals(".DS_Store") || str.contains(Constants.PATH_PARENT) : invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (java.util.Arrays.equals(com.bytedance.sdk.openadsdk.preload.geckox.utils.l.f68644b, r1) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(InputStream inputStream) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                byte[] bArr = new byte[4];
                boolean z = false;
                if (inputStream.read(bArr, 0, 4) == 4) {
                    if (!Arrays.equals(f68643a, bArr)) {
                    }
                    z = true;
                    return z;
                }
                return false;
            } finally {
                b.a(inputStream);
            }
        }
        return invokeL.booleanValue;
    }
}
