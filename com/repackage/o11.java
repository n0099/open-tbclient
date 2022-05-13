package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* loaded from: classes6.dex */
public class o11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755492670, "Lcom/repackage/o11;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755492670, "Lcom/repackage/o11;");
        }
    }

    public static long a(File file, File file2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, file2)) == null) {
            long j = 0;
            if (file == null || file2 == null || !file.exists()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                j = b(fileInputStream, fileOutputStream);
                ni0.a(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    ni0.a(fileInputStream2);
                    ni0.a(fileOutputStream);
                    return j;
                } catch (Throwable th3) {
                    th = th3;
                    ni0.a(fileInputStream2);
                    ni0.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                ni0.a(fileInputStream2);
                ni0.a(fileOutputStream);
                throw th;
            }
            ni0.a(fileOutputStream);
            return j;
        }
        return invokeLL.longValue;
    }

    public static long b(InputStream inputStream, FileOutputStream fileOutputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, fileOutputStream)) == null) {
            if (inputStream != null && fileOutputStream != null) {
                try {
                    byte[] bArr = new byte[3072];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                            j += read;
                        } else {
                            fileOutputStream.flush();
                            return j;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0026 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    public static int c(@NonNull File file) {
        InterceptResult invokeL;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            int i = 0;
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i < length) {
                        File file2 = listFiles[i];
                        if (file2.isFile()) {
                            c = file2.delete();
                        } else {
                            c = c(file2);
                        }
                        i2 += c;
                        i++;
                    }
                    i = i2;
                }
                file.delete();
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static String d(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String decode = Uri.decode(str);
            if (decode != null) {
                int indexOf = decode.indexOf(63);
                if (indexOf > 0) {
                    decode = decode.substring(0, indexOf);
                }
                if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                    return decode.substring(lastIndexOf);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String e(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            String str = null;
            if (file == null) {
                return null;
            }
            System.currentTimeMillis();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        }
                        str = sb.toString();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        th = th2;
                        h(fileInputStream);
                        h(bufferedReader);
                        throw th;
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (IOException unused3) {
                bufferedReader = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                fileInputStream = null;
                th = th4;
                bufferedReader = null;
            }
            h(fileInputStream);
            h(bufferedReader);
            System.currentTimeMillis();
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return e(ki0.b().getFileStreamPath(str));
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static byte[] g(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (file == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            if (!file.exists()) {
                byte[] bArr = new byte[0];
                ni0.a(null);
                ni0.a(null);
                return bArr;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException | OutOfMemoryError unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[32768];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        ni0.a(byteArrayOutputStream);
                        ni0.a(fileInputStream);
                        return byteArray;
                    }
                }
            } catch (IOException | OutOfMemoryError unused2) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                ni0.a(byteArrayOutputStream2);
                ni0.a(fileInputStream);
                return new byte[0];
            } catch (Throwable th2) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                th = th2;
                ni0.a(byteArrayOutputStream2);
                ni0.a(fileInputStream);
                throw th;
            }
        } catch (IOException | OutOfMemoryError unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void h(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static boolean i(byte[] bArr, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65545, null, bArr, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists() && !file.createNewFile()) {
                ni0.a(null);
                ni0.a(null);
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
            } catch (Throwable unused) {
                bufferedOutputStream = null;
            }
            try {
                bufferedOutputStream.write(bArr);
                fileOutputStream2.flush();
                bufferedOutputStream.flush();
                ni0.a(fileOutputStream2);
                ni0.a(bufferedOutputStream);
                return true;
            } catch (Throwable unused2) {
                fileOutputStream = fileOutputStream2;
                ni0.a(fileOutputStream);
                ni0.a(bufferedOutputStream);
                return false;
            }
        } catch (Throwable unused3) {
            bufferedOutputStream = null;
        }
    }

    public static boolean j(String str, String str2) {
        InterceptResult invokeLL;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream openFileOutput = ki0.b().openFileOutput(str2, 0);
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput));
                    } catch (IOException unused) {
                        bufferedWriter = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = null;
                    }
                    try {
                        bufferedWriter.write(str);
                        bufferedWriter.flush();
                        h(openFileOutput);
                        h(bufferedWriter);
                        return true;
                    } catch (IOException unused2) {
                        fileOutputStream = openFileOutput;
                        h(fileOutputStream);
                        h(bufferedWriter);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = openFileOutput;
                        h(fileOutputStream);
                        h(bufferedWriter);
                        throw th;
                    }
                } catch (IOException unused3) {
                    bufferedWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = null;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
