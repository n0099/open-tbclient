package d.a.m0.l;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes7.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f43651a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
            } catch (Throwable th) {
                c.d(th);
            }
            if (!TextUtils.isEmpty(f43651a)) {
                return f43651a;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            f43651a = b(packageInfo, packageInfo.applicationInfo.sourceDir);
            return f43651a;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(PackageInfo packageInfo, String str) {
        InterceptResult invokeLL;
        PublicKey publicKey;
        byte[] encoded;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, packageInfo, str)) != null) {
            return (String) invokeLL.objValue;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && signatureArr[0] != null) {
            try {
                publicKey = c(signatureArr[0]);
            } catch (Throwable th) {
                c.d(th);
            }
            if (publicKey == null) {
                publicKey = d(str);
            }
            return (publicKey == null || (encoded = publicKey.getEncoded()) == null) ? "" : g.b(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
        }
        publicKey = null;
        if (publicKey == null) {
        }
        if (publicKey == null) {
            return "";
        }
    }

    public static PublicKey c(Signature signature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, signature)) == null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
                c.d(th);
            }
            return generateCertificate.getPublicKey();
        }
        return (PublicKey) invokeL.objValue;
    }

    public static PublicKey d(String str) {
        InterceptResult invokeL;
        JarFile jarFile;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (PublicKey) invokeL.objValue;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArr = new byte[8192];
            try {
                jarFile = new JarFile(str);
                try {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    Certificate[] certificateArr = null;
                    while (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                            Certificate[] e2 = e(jarFile, nextElement, bArr);
                            if (e2 != null && e2.length > 0) {
                                if (certificateArr == null) {
                                    certificateArr = e2;
                                } else {
                                    while (i2 < certificateArr.length) {
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= e2.length) {
                                                z = false;
                                                break;
                                            } else if (certificateArr[i2] != null && certificateArr[i2].equals(e2[i3])) {
                                                z = true;
                                                break;
                                            } else {
                                                i3++;
                                            }
                                        }
                                        i2 = (z && certificateArr.length == e2.length) ? i2 + 1 : 0;
                                        jarFile.close();
                                        jarFile.close();
                                        return null;
                                    }
                                    continue;
                                }
                            }
                            jarFile.close();
                            jarFile.close();
                            return null;
                        }
                    }
                    jarFile.close();
                    if (certificateArr == null || certificateArr.length <= 0) {
                        return null;
                    }
                    return certificateArr[0].getPublicKey();
                } catch (Throwable th) {
                    th = th;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                jarFile = null;
            }
        } catch (Throwable th3) {
            c.d(th3);
            return null;
        }
    }

    public static Certificate[] e(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jarFile, jarEntry, bArr)) != null) {
            return (Certificate[]) invokeLLL.objValue;
        }
        try {
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                try {
                } catch (Throwable th) {
                    th = th;
                    try {
                        c.d(th);
                        return new Certificate[0];
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                c.d(th2);
                            }
                        }
                    }
                }
            }
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : new Certificate[0];
            try {
                bufferedInputStream.close();
            } catch (Throwable th3) {
                c.d(th3);
            }
            return certificates;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }
}
