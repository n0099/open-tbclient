package d.b.z.h;

import android.content.pm.Signature;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static Object f64930a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<byte[]> f64931b;

    public static Signature[] a(String str) {
        WeakReference<byte[]> weakReference;
        JarFile jarFile;
        byte[] bArr;
        JarFile jarFile2;
        boolean z;
        synchronized (f64930a) {
            weakReference = f64931b;
            jarFile = null;
            if (weakReference != null) {
                f64931b = null;
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
            jarFile2 = new JarFile(str);
            try {
                Enumeration<JarEntry> entries = jarFile2.entries();
                Certificate[] certificateArr = null;
                while (true) {
                    if (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                            Certificate[] b2 = b(jarFile2, nextElement, bArr);
                            if (b2 == null) {
                                try {
                                    jarFile2.close();
                                } catch (IOException unused) {
                                }
                                return null;
                            } else if (certificateArr == null) {
                                certificateArr = b2;
                            } else {
                                for (int i = 0; i < certificateArr.length; i++) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= b2.length) {
                                            z = false;
                                            break;
                                        } else if (certificateArr[i] != null && certificateArr[i].equals(b2[i2])) {
                                            z = true;
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                    if (!z || certificateArr.length != b2.length) {
                                        try {
                                            jarFile2.close();
                                        } catch (IOException unused2) {
                                        }
                                        return null;
                                    }
                                }
                                continue;
                            }
                        }
                    } else {
                        synchronized (f64930a) {
                            f64931b = weakReference;
                        }
                        if (certificateArr == null || certificateArr.length <= 0) {
                            try {
                                jarFile2.close();
                            } catch (IOException unused3) {
                            }
                            return null;
                        }
                        int length = certificateArr.length;
                        Signature[] signatureArr = new Signature[certificateArr.length];
                        for (int i3 = 0; i3 < length; i3++) {
                            signatureArr[i3] = new Signature(certificateArr[i3].getEncoded());
                        }
                        try {
                            jarFile2.close();
                        } catch (IOException unused4) {
                        }
                        return signatureArr;
                    }
                }
            } catch (Exception unused5) {
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (IOException unused6) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                jarFile = jarFile2;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        } catch (Exception unused8) {
            jarFile2 = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Certificate[] b(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                try {
                } catch (IOException unused) {
                } catch (RuntimeException unused2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                bufferedInputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            bufferedInputStream = null;
        } catch (RuntimeException unused6) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
