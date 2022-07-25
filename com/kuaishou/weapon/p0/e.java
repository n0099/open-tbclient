package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes5.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 2048;
    public static final String b = ".gz";
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65537, null, inputStream, outputStream) != null) {
            return;
        }
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                        return;
                    }
                    gZIPOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable unused) {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
            gZIPOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            byte[] bArr3 = null;
            byteArrayOutputStream = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        a(byteArrayInputStream, byteArrayOutputStream2);
                        bArr3 = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable unused2) {
                        byte[] bArr4 = bArr3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        bArr2 = bArr4;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (byteArrayInputStream == null) {
                            return bArr2;
                        }
                        bArr3 = bArr2;
                        byteArrayInputStream.close();
                        return bArr3;
                    }
                } catch (Throwable unused4) {
                    bArr2 = null;
                }
            } catch (Throwable unused5) {
                bArr2 = null;
                byteArrayInputStream = null;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused6) {
            }
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, inputStream, outputStream) != null) {
            return;
        }
        GZIPInputStream gZIPInputStream = null;
        try {
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = gZIPInputStream2.read(bArr, 0, 2048);
                        if (read == -1) {
                            gZIPInputStream2.close();
                            gZIPInputStream2.close();
                            return;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                } catch (Exception unused) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        b(byteArrayInputStream, byteArrayOutputStream2);
                        bArr = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable unused2) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                byteArrayInputStream = null;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused6) {
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
