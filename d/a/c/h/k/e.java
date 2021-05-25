package d.a.c.h.k;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Object f39184a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<byte[]> f39185b;

    public static Signature[] a(String str, Util.a aVar) throws CertificateEncodingException, IOException {
        WeakReference<byte[]> weakReference;
        byte[] bArr;
        Certificate[] b2;
        boolean z;
        if (TextUtils.isEmpty(str) || aVar == null) {
            return null;
        }
        synchronized (f39184a) {
            weakReference = f39185b;
            if (weakReference != null) {
                f39185b = null;
                bArr = weakReference.get();
            } else {
                bArr = null;
            }
            if (bArr == null) {
                bArr = new byte[8192];
                weakReference = new WeakReference<>(bArr);
            }
        }
        try {
            JarFile jarFile = new JarFile(str);
            aVar.f2251c = 1;
            Enumeration<JarEntry> entries = jarFile.entries();
            Certificate[] certificateArr = null;
            loop0: while (true) {
                if (entries.hasMoreElements()) {
                    JarEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        String name = nextElement.getName();
                        if (!name.startsWith("META-INF/")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("jarFile_");
                            sb.append(jarFile.getName());
                            sb.append("-JarEntry_");
                            sb.append(name);
                            aVar.f2250b = sb.toString();
                            aVar.f2251c = 2;
                            try {
                                b2 = b(jarFile, nextElement, bArr, aVar);
                            } catch (Exception e2) {
                                sb.append("-Exception_");
                                sb.append(e2.toString());
                                aVar.f2250b = sb.toString();
                                b2 = b(jarFile, nextElement, bArr, aVar);
                            }
                            aVar.f2251c = 5;
                            if (b2 == null) {
                                aVar.f2251c = 6;
                                BdLog.e("Package " + str + " has no certificates at entry " + nextElement.getName() + "; ignoring!");
                                jarFile.close();
                                return null;
                            } else if (certificateArr == null) {
                                certificateArr = b2;
                            } else {
                                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= b2.length) {
                                            z = false;
                                            break;
                                        } else if (certificateArr[i2] != null && certificateArr[i2].equals(b2[i3])) {
                                            z = true;
                                            break;
                                        } else {
                                            i3++;
                                        }
                                    }
                                    if (!z || certificateArr.length != b2.length) {
                                        break loop0;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                } else {
                    aVar.f2251c = 8;
                    jarFile.close();
                    synchronized (f39184a) {
                        f39185b = weakReference;
                    }
                    aVar.f2251c = 9;
                    if (certificateArr != null && certificateArr.length > 0) {
                        int length = certificateArr.length;
                        Signature[] signatureArr = new Signature[certificateArr.length];
                        for (int i4 = 0; i4 < length; i4++) {
                            signatureArr[i4] = new Signature(certificateArr[i4].getEncoded());
                        }
                        return signatureArr;
                    }
                    BdLog.e("Package " + str + " has no certificates; ignoring!");
                    return null;
                }
            }
            aVar.f2251c = 7;
            jarFile.close();
            return null;
        } catch (IOException e3) {
            BdLog.e("Exception reading " + str + "----" + e3.getMessage());
            throw e3;
        } catch (RuntimeException e4) {
            BdLog.e("Exception reading " + str + "----" + e4.getMessage());
            throw e4;
        } catch (CertificateEncodingException e5) {
            BdLog.e("Exception reading " + str + "----" + e5.getMessage());
            throw e5;
        }
    }

    public static Certificate[] b(JarFile jarFile, JarEntry jarEntry, byte[] bArr, Util.a aVar) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (RuntimeException e3) {
            e = e3;
        }
        try {
            aVar.f2251c = 3;
            while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
            }
            aVar.f2251c = 4;
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            d.a.c.e.m.a.c(bufferedInputStream);
            return certificates;
        } catch (IOException e4) {
            e = e4;
            BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
            throw e;
        } catch (RuntimeException e5) {
            e = e5;
            BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
            throw e;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            d.a.c.e.m.a.c(bufferedInputStream2);
            throw th;
        }
    }
}
