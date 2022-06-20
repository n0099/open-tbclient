package com.qq.e.comm.net.rr;

import android.annotation.TargetApi;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static Cipher b;
    public static Cipher c;
    public static final String d;
    public static final byte[] e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0380a extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0380a(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-597008493, "Lcom/qq/e/comm/net/rr/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-597008493, "Lcom/qq/e/comm/net/rr/a;");
                return;
            }
        }
        a = new byte[]{91, -62};
        d = String.format("AES/%s/PKCS7Padding", "ECB");
        e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);
    }

    public static byte[] a(byte[] bArr) throws C0380a {
        InterceptResult invokeL;
        Cipher cipher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            synchronized (a.class) {
                cipher = c;
                if (cipher == null) {
                    try {
                        cipher = Cipher.getInstance(d);
                        cipher.init(2, new SecretKeySpec(e, "AES"));
                        c = cipher;
                    } catch (Exception e2) {
                        throw new C0380a("Fail To Init Cipher", e2);
                    }
                }
            }
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e3) {
                throw new C0380a("Exception While dencrypt byte array", e3);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr) throws C0380a {
        InterceptResult invokeL;
        Cipher cipher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            synchronized (a.class) {
                cipher = b;
                if (cipher == null) {
                    try {
                        cipher = Cipher.getInstance(d);
                        cipher.init(1, new SecretKeySpec(e, "AES"));
                        b = cipher;
                    } catch (Exception e2) {
                        throw new C0380a("Fail To Init Cipher", e2);
                    }
                }
            }
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e3) {
                throw new C0380a("Exception While encrypt byte array", e3);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr) throws b {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.write(a);
                dataOutputStream.writeByte(1);
                dataOutputStream.writeByte(2);
                dataOutputStream.write(b(f(bArr)));
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e2) {
                throw new b("Exception while packaging byte array", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    @TargetApi(9)
    public static byte[] d(byte[] bArr) throws b {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            if (bArr == null || bArr.length < 4) {
                throw new b("S2SS Package FormatError", null);
            }
            try {
                byte[] bArr2 = new byte[4];
                new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
                if (a[0] == bArr2[0] && a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                    return e(a(Arrays.copyOfRange(bArr, 4, bArr.length)));
                }
                throw new b("S2SS Package Magic/Version FormatError", null);
            } catch (Exception e2) {
                throw new b("Exception while packaging byte array", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            GZIPInputStream gZIPInputStream2 = null;
            r0 = null;
            byte[] bArr2 = null;
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr3 = new byte[1024];
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                while (true) {
                    try {
                        try {
                            int read = gZIPInputStream.read(bArr3);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr3, 0, read);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    return bArr2;
                                }
                            }
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            return bArr2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPInputStream2 = gZIPInputStream;
                        if (gZIPInputStream2 != null) {
                            try {
                                gZIPInputStream2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                }
                byteArrayOutputStream.flush();
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    return bArr2;
                }
            } catch (Exception e6) {
                e = e6;
                gZIPInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream2 != null) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x002b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0010 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] f(byte[] bArr) {
        ?? r2;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65542;
            InterceptResult invokeL = interceptable.invokeL(65542, null, bArr);
            if (invokeL != null) {
                return (byte[]) invokeL.objValue;
            }
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        bArr = byteArrayOutputStream.toByteArray();
                        try {
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            r2 = gZIPOutputStream;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            r2 = gZIPOutputStream;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                bArr = null;
                                r2 = gZIPOutputStream;
                                return bArr;
                            }
                        }
                        byteArrayOutputStream.close();
                        bArr = null;
                        r2 = gZIPOutputStream;
                        return bArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream2 = r2;
                    if (gZIPOutputStream2 != null) {
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                gZIPOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPOutputStream2 != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        }
        return bArr;
    }
}
