package com.qq.e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import com.baidu.mobads.container.util.AdIconUtil;
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
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f41039a;

    /* renamed from: b  reason: collision with root package name */
    public static Cipher f41040b;

    /* renamed from: c  reason: collision with root package name */
    public static Cipher f41041c;

    /* renamed from: d  reason: collision with root package name */
    public static String f41042d;

    /* renamed from: e  reason: collision with root package name */
    public static byte[] f41043e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0518a extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0518a(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        f41039a = new byte[]{91, -62};
        f41040b = null;
        f41041c = null;
        f41042d = String.format("AES/%s/PKCS7Padding", "ECB");
        f41043e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);
    }

    @SuppressLint({"TrulyRandom"})
    public static synchronized Cipher a() throws C0518a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f41040b != null) {
                    return f41040b;
                }
                try {
                    Cipher cipher = Cipher.getInstance(f41042d);
                    cipher.init(1, new SecretKeySpec(f41043e, "AES"));
                    f41040b = cipher;
                    return cipher;
                } catch (Exception e2) {
                    throw new C0518a("Fail To Init Cipher", e2);
                }
            }
        }
        return (Cipher) invokeV.objValue;
    }

    public static byte[] a(byte[] bArr) throws b {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.write(f41039a);
                dataOutputStream.writeByte(1);
                dataOutputStream.writeByte(2);
                dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e2) {
                throw new b("Exception while packaging byte array", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static synchronized Cipher b() throws C0518a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (a.class) {
                if (f41041c != null) {
                    return f41041c;
                }
                try {
                    Cipher cipher = Cipher.getInstance(f41042d);
                    cipher.init(2, new SecretKeySpec(f41043e, "AES"));
                    f41041c = cipher;
                    return cipher;
                } catch (Exception e2) {
                    throw new C0518a("Fail To Init Cipher", e2);
                }
            }
        }
        return (Cipher) invokeV.objValue;
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws b {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bArr)) == null) {
            if (bArr == null || bArr.length < 4) {
                throw new b("S2SS Package FormatError", null);
            }
            try {
                byte[] bArr2 = new byte[4];
                new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
                if (f41039a[0] == bArr2[0] && f41039a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                    return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
                }
                throw new b("S2SS Package Magic/Version FormatError", null);
            } catch (Exception e2) {
                throw new b("Exception while packaging byte array", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr) throws C0518a {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            try {
                return a().doFinal(bArr);
            } catch (Exception e2) {
                throw new C0518a("Exception While encrypt byte array", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] d(byte[] bArr) throws C0518a {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) {
            try {
                return b().doFinal(bArr);
            } catch (Exception e2) {
                throw new C0518a("Exception While dencrypt byte array", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
