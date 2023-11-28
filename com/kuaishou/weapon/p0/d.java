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
/* loaded from: classes10.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 2048;
    public static final String b = ".gz";
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
        if (interceptable == null || interceptable.invokeLL(65537, null, inputStream, outputStream) == null) {
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            gZIPOutputStream.write(bArr, 0, read);
                        } else {
                            gZIPOutputStream.flush();
                            gZIPOutputStream.finish();
                            gZIPOutputStream.close();
                            return;
                        }
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
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, inputStream, outputStream) == null) {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = gZIPInputStream2.read(bArr, 0, 2048);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            gZIPInputStream2.close();
                            try {
                                gZIPInputStream2.close();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                    }
                } catch (Exception unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
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
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused2) {
                            return bArr3;
                        }
                    } catch (Throwable unused3) {
                        byte[] bArr4 = bArr3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        bArr2 = bArr4;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        return bArr2;
                    }
                } catch (Throwable unused6) {
                    bArr2 = null;
                }
            } catch (Throwable unused7) {
                bArr2 = null;
                byteArrayInputStream = null;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r1 == null) goto L17;
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
                return bArr;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }
}
