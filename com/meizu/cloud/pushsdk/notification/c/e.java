package com.meizu.cloud.pushsdk.notification.c;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes8.dex */
public class e {
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final File f57372b;

    /* renamed from: c  reason: collision with root package name */
    public String f57373c;

    public e(String str, String str2) {
        this.a = new File(str);
        File file = new File(str2);
        this.f57372b = file;
        this.f57373c = file.getAbsolutePath();
        c.k.a.a.a.d("ZipExtractTask", "Extract mInput file = " + this.a.toString());
        c.k.a.a.a.d("ZipExtractTask", "Extract mOutput file = " + this.f57372b.toString());
    }

    private int a(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i2 = 0;
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    i2 += read;
                } catch (IOException e2) {
                    c.k.a.a.a.b("ZipExtractTask", "Extracted IOException:" + e2.toString());
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                        c.k.a.a.a.b("ZipExtractTask", "out.close() IOException e=" + e3.toString());
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        sb = new StringBuilder();
                        sb.append("in.close() IOException e=");
                        sb.append(e.toString());
                        c.k.a.a.a.b("ZipExtractTask", sb.toString());
                        return i2;
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e5) {
                    c.k.a.a.a.b("ZipExtractTask", "out.close() IOException e=" + e5.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e6) {
                    c.k.a.a.a.b("ZipExtractTask", "in.close() IOException e=" + e6.toString());
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e7) {
            c.k.a.a.a.b("ZipExtractTask", "out.close() IOException e=" + e7.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e8) {
            e = e8;
            sb = new StringBuilder();
            sb.append("in.close() IOException e=");
            sb.append(e.toString());
            c.k.a.a.a.b("ZipExtractTask", sb.toString());
            return i2;
        }
        return i2;
    }

    private void b() {
        StringBuilder sb;
        String str;
        File file = this.a;
        if (file == null || !file.exists()) {
            return;
        }
        if (this.a.delete()) {
            sb = new StringBuilder();
            str = "Delete file:";
        } else {
            sb = new StringBuilder();
            str = "Can't delete file:";
        }
        sb.append(str);
        sb.append(this.a.toString());
        sb.append(" after extracted.");
        c.k.a.a.a.d("ZipExtractTask", sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r13 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        r7 = r13.split("/")[0];
        c.k.a.a.a.d("ZipExtractTask", "Extract temp directory=" + r18.f57372b + "/" + r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        long j2;
        String str;
        Throwable th;
        IOException iOException;
        StringBuilder sb;
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        String str2;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        ZipFile zipFile2 = null;
        String str3 = null;
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        ZipFile zipFile5 = null;
        boolean z = false;
        long j3 = 0;
        try {
            try {
                zipFile = new ZipFile(this.a);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (ZipException e2) {
            e = e2;
            j2 = 0;
            str = null;
        } catch (IOException e3) {
            e = e3;
            j2 = 0;
            str = null;
        } catch (Exception e4) {
            e = e4;
            j2 = 0;
            str = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name != null && name.contains("../")) {
                        throw new Exception("unsecurity zip file");
                    }
                    File file = new File(this.f57372b, name);
                    if (!file.getParentFile().exists()) {
                        if (file.getParentFile().mkdirs()) {
                            str2 = "Make Destination directory=" + file.getParentFile().getAbsolutePath();
                        } else {
                            str2 = "Can't make destination directory=" + file.getParentFile().getAbsolutePath();
                        }
                        c.k.a.a.a.d("ZipExtractTask", str2);
                    }
                    j3 += a(zipFile.getInputStream(nextElement), fileOutputStream);
                    new FileOutputStream(file).close();
                }
            }
            String str4 = this.f57372b + "/" + str3;
            if (!this.f57373c.equals(str4)) {
                a.a(str4, this.f57373c);
                z = true;
            }
            try {
                zipFile.close();
            } catch (IOException e5) {
                c.k.a.a.a.b("ZipExtractTask", "Extracted IOException:" + e5.toString());
            }
        } catch (ZipException e6) {
            e = e6;
            str = null;
            zipFile4 = zipFile;
            j2 = 0;
            c.k.a.a.a.b("ZipExtractTask", "ZipException :" + e.toString());
            if (zipFile4 != null) {
                try {
                    zipFile4.close();
                } catch (IOException e7) {
                    iOException = e7;
                    sb = new StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    c.k.a.a.a.b("ZipExtractTask", sb.toString());
                    str3 = str;
                    j3 = j2;
                    long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                    c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis2 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j3;
                }
            }
            str3 = str;
            j3 = j2;
            long currentThreadTimeMillis22 = SystemClock.currentThreadTimeMillis();
            c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis22 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j3;
        } catch (IOException e8) {
            e = e8;
            str = null;
            zipFile5 = zipFile;
            j2 = 0;
            c.k.a.a.a.b("ZipExtractTask", "Extracted IOException:" + e.toString());
            if (zipFile5 != null) {
                try {
                    zipFile5.close();
                } catch (IOException e9) {
                    iOException = e9;
                    sb = new StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    c.k.a.a.a.b("ZipExtractTask", sb.toString());
                    str3 = str;
                    j3 = j2;
                    long currentThreadTimeMillis222 = SystemClock.currentThreadTimeMillis();
                    c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis222 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j3;
                }
            }
            str3 = str;
            j3 = j2;
            long currentThreadTimeMillis2222 = SystemClock.currentThreadTimeMillis();
            c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis2222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j3;
        } catch (Exception e10) {
            e = e10;
            str = null;
            zipFile2 = zipFile;
            j2 = 0;
            c.k.a.a.a.b("ZipExtractTask", "Extracted Exception " + e.toString());
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e11) {
                    iOException = e11;
                    sb = new StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    c.k.a.a.a.b("ZipExtractTask", sb.toString());
                    str3 = str;
                    j3 = j2;
                    long currentThreadTimeMillis22222 = SystemClock.currentThreadTimeMillis();
                    c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis22222 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j3;
                }
            }
            str3 = str;
            j3 = j2;
            long currentThreadTimeMillis222222 = SystemClock.currentThreadTimeMillis();
            c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis222222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j3;
        } catch (Throwable th3) {
            th = th3;
            zipFile3 = zipFile;
            if (zipFile3 != null) {
                try {
                    zipFile3.close();
                } catch (IOException e12) {
                    c.k.a.a.a.b("ZipExtractTask", "Extracted IOException:" + e12.toString());
                }
            }
            throw th;
        }
        long currentThreadTimeMillis2222222 = SystemClock.currentThreadTimeMillis();
        c.k.a.a.a.d("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(currentThreadTimeMillis2222222 - currentThreadTimeMillis));
        if (z) {
            a.b(this.f57372b + "/" + str3);
        }
        b();
        return j3;
    }

    public boolean a() {
        return c() > 0;
    }
}
