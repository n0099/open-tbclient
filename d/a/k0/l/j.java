package d.a.k0.l;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f44299a;

    public static String a(Context context) {
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (!TextUtils.isEmpty(f44299a)) {
            return f44299a;
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        if (packageInfo == null) {
            return "";
        }
        f44299a = b(packageInfo, packageInfo.applicationInfo.sourceDir);
        return f44299a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(PackageInfo packageInfo, String str) {
        PublicKey publicKey;
        byte[] encoded;
        Signature[] signatureArr;
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

    public static PublicKey d(String str) {
        JarFile jarFile;
        int i2;
        boolean z;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArr = new byte[8192];
            try {
                jarFile = new JarFile(str);
            } catch (Throwable th) {
                th = th;
                jarFile = null;
            }
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
            } catch (Throwable th2) {
                th = th2;
                if (jarFile != null) {
                    jarFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            c.d(th3);
            return null;
        }
    }

    public static Certificate[] e(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
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
