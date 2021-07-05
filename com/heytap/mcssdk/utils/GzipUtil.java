package com.heytap.mcssdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes7.dex */
public class GzipUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IO_BUF_SIZE = 1024;
    public transient /* synthetic */ FieldHolder $fh;

    public GzipUtil() {
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0067 A[Catch: IOException -> 0x006e, TryCatch #4 {IOException -> 0x006e, blocks: (B:35:0x0062, B:37:0x0067, B:38:0x006a), top: B:51:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] compress(String str) {
        InterceptResult invokeL;
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        IOException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return "".getBytes();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
                try {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = byteArrayInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                gZIPOutputStream.write(bArr, 0, read);
                                gZIPOutputStream.flush();
                            }
                            byteArrayInputStream.close();
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e2 = e3;
                            LogUtil.e(e2);
                            byteArrayInputStream.close();
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                            return byteArrayOutputStream.toByteArray();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            byteArrayInputStream.close();
                            if (0 != 0) {
                                gZIPOutputStream2.close();
                            }
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    gZIPOutputStream = null;
                    e2 = e5;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream.close();
                    if (0 != 0) {
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String uncompress(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        Throwable th;
        IOException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read <= 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                                byteArrayOutputStream.flush();
                            }
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e2 = e3;
                            LogUtil.e(e2);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            return byteArrayOutputStream.toString();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } catch (IOException e6) {
                gZIPInputStream = null;
                e2 = e6;
            } catch (Throwable th3) {
                gZIPInputStream = null;
                th = th3;
                if (gZIPInputStream != null) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
            return byteArrayOutputStream.toString();
        }
        return (String) invokeL.objValue;
    }
}
