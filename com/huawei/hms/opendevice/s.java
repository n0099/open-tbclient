package com.huawei.hms.opendevice;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.oha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
/* loaded from: classes8.dex */
public abstract class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int read = inputStream.read();
            while (-1 != read) {
                byteArrayOutputStream.write(read);
                read = inputStream.read();
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            a((Closeable) inputStream);
            oha.c(byteArrayOutputStream);
            return byteArrayOutputStream2;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0045 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Reader, java.io.InputStreamReader] */
    public static String a(String str) {
        Reader reader;
        Reader reader2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            reader = 65537;
            InterceptResult invokeL = interceptable.invokeL(65537, null, str);
            if (invokeL != null) {
                return (String) invokeL.objValue;
            }
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(reader);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                            HMSLog.e("StreamUtil", "file not exist.");
                            reader2 = reader;
                            IOUtils.closeQuietly(reader2);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (IOException unused2) {
                            bufferedReader = bufferedReader2;
                            HMSLog.e("StreamUtil", "read value IOException.");
                            reader2 = reader;
                            IOUtils.closeQuietly(reader2);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            IOUtils.closeQuietly((Reader) reader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            throw th;
                        }
                    }
                    IOUtils.closeQuietly((Reader) reader);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                } catch (FileNotFoundException unused3) {
                } catch (IOException unused4) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused5) {
            reader = null;
        } catch (IOException unused6) {
            reader = null;
        } catch (Throwable th3) {
            th = th3;
            reader = 0;
        }
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.w("StreamUtil", "close IOException");
            }
        }
    }

    public static void a(File file) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, file) != null) || file.exists()) {
            return;
        }
        if (file.getParentFile() != null) {
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                HMSLog.e("StreamUtil", "make parent dirs failed.");
                throw new IOException("make parent dirs failed");
            } else if (file.createNewFile()) {
                return;
            } else {
                HMSLog.e("StreamUtil", "create file failed.");
                throw new IOException("create file failed");
            }
        }
        HMSLog.e("StreamUtil", "parent file is null.");
        throw new IOException("parent file is null");
    }

    public static void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpURLConnection) == null) && httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
                HMSLog.w("StreamUtil", "close HttpURLConnection Exception");
            }
        }
    }
}
