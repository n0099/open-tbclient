package com.huawei.hms.hatool;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;
/* loaded from: classes10.dex */
public final class t0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            }
            try {
                p0 p0Var = new p0(1024);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    p0Var.a(bArr, read);
                }
                if (p0Var.b() == 0) {
                    a((Closeable) fileInputStream);
                    return "";
                }
                String str = new String(p0Var.a(), "UTF-8");
                a((Closeable) fileInputStream);
                return str;
            } catch (FileNotFoundException unused3) {
                fileInputStream2 = fileInputStream;
                y.f("hmsSdk", "getInfoFromFile(): No files need to be read");
                a((Closeable) fileInputStream2);
                return "";
            } catch (IOException unused4) {
                fileInputStream2 = fileInputStream;
                y.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                a((Closeable) fileInputStream2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                a((Closeable) fileInputStream2);
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            a((Closeable) byteArrayOutputStream);
        }
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
            y.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
        }
    }

    public static void a(File file, String str) {
        String str2;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, file, str) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused3) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): No files need to be read";
                y.f("hmsSdk", str2);
                fileOutputStream = fileOutputStream2;
                a((Closeable) fileOutputStream);
            } catch (IOException unused4) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): io exc from write info to file!";
                y.f("hmsSdk", str2);
                fileOutputStream = fileOutputStream2;
                a((Closeable) fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                a((Closeable) fileOutputStream2);
                throw th;
            }
            a((Closeable) fileOutputStream);
        }
    }

    public static void a(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, outputStream) == null) || outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused) {
            y.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, httpURLConnection) == null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception unused) {
                y.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
            }
            httpURLConnection.disconnect();
            y.a("hmsSdk", " connHttp disconnect");
        }
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            deflater.end();
            a((OutputStream) byteArrayOutputStream);
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }
}
