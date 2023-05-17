package com.meizu.cloud.pushsdk.notification.c;

import android.os.SystemClock;
import com.meizu.cloud.pushinternal.DebugLogger;
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
/* loaded from: classes9.dex */
public class e {
    public final File a;
    public final File b;
    public final String c;

    public e(String str, String str2) {
        this.a = new File(str);
        File file = new File(str2);
        this.b = file;
        this.c = file.getAbsolutePath();
        DebugLogger.i("ZipExtractTask", "Extract mInput file = " + this.a.toString());
        DebugLogger.i("ZipExtractTask", "Extract mOutput file = " + this.b.toString());
    }

    private int a(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    i += read;
                } catch (IOException e) {
                    DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e2.toString());
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("in.close() IOException e=");
                        sb.append(e.toString());
                        DebugLogger.e("ZipExtractTask", sb.toString());
                        return i;
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    DebugLogger.e("ZipExtractTask", "in.close() IOException e=" + e5.toString());
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e6.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e7) {
            e = e7;
            sb = new StringBuilder();
            sb.append("in.close() IOException e=");
            sb.append(e.toString());
            DebugLogger.e("ZipExtractTask", sb.toString());
            return i;
        }
        return i;
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
        DebugLogger.i("ZipExtractTask", sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r13 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        r7 = r13.split("/")[0];
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract temp directory=" + r18.b + "/" + r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        long j;
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
        long j2 = 0;
        try {
            try {
                zipFile = new ZipFile(this.a);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (ZipException e) {
            e = e;
            j = 0;
            str = null;
        } catch (IOException e2) {
            e = e2;
            j = 0;
            str = null;
        } catch (Exception e3) {
            e = e3;
            j = 0;
            str = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name != null && name.contains("../")) {
                        throw new Exception("Unsafe zip file");
                    }
                    if (name != null) {
                        File file = new File(this.b, name);
                        if (!file.getParentFile().exists()) {
                            if (file.getParentFile().mkdirs()) {
                                str2 = "Make Destination directory=" + file.getParentFile().getAbsolutePath();
                            } else {
                                str2 = "Can't make destination directory=" + file.getParentFile().getAbsolutePath();
                            }
                            DebugLogger.i("ZipExtractTask", str2);
                        }
                        j2 += a(zipFile.getInputStream(nextElement), fileOutputStream);
                        new FileOutputStream(file).close();
                    }
                }
            }
            String str4 = this.b + "/" + str3;
            if (!this.c.equals(str4)) {
                a.a(str4, this.c);
                z = true;
            }
            try {
                zipFile.close();
            } catch (IOException e4) {
                DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e4.toString());
            }
        } catch (ZipException e5) {
            e = e5;
            str = null;
            zipFile4 = zipFile;
            j = 0;
            DebugLogger.e("ZipExtractTask", "ZipException :" + e.toString());
            if (zipFile4 != null) {
                try {
                    zipFile4.close();
                } catch (IOException e6) {
                    iOException = e6;
                    sb = new StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    DebugLogger.e("ZipExtractTask", sb.toString());
                    str3 = str;
                    j2 = j;
                    long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                    DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis2 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j2;
                }
            }
            str3 = str;
            j2 = j;
            long currentThreadTimeMillis22 = SystemClock.currentThreadTimeMillis();
            DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis22 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j2;
        } catch (IOException e7) {
            e = e7;
            str = null;
            zipFile5 = zipFile;
            j = 0;
            DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
            if (zipFile5 != null) {
                try {
                    zipFile5.close();
                } catch (IOException e8) {
                    iOException = e8;
                    sb = new StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    DebugLogger.e("ZipExtractTask", sb.toString());
                    str3 = str;
                    j2 = j;
                    long currentThreadTimeMillis222 = SystemClock.currentThreadTimeMillis();
                    DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis222 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j2;
                }
            }
            str3 = str;
            j2 = j;
            long currentThreadTimeMillis2222 = SystemClock.currentThreadTimeMillis();
            DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis2222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j2;
        } catch (Exception e9) {
            e = e9;
            str = null;
            zipFile2 = zipFile;
            j = 0;
            DebugLogger.e("ZipExtractTask", "Extracted Exception " + e.toString());
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e10) {
                    iOException = e10;
                    sb = new StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    DebugLogger.e("ZipExtractTask", sb.toString());
                    str3 = str;
                    j2 = j;
                    long currentThreadTimeMillis22222 = SystemClock.currentThreadTimeMillis();
                    DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis22222 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j2;
                }
            }
            str3 = str;
            j2 = j;
            long currentThreadTimeMillis222222 = SystemClock.currentThreadTimeMillis();
            DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis222222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j2;
        } catch (Throwable th3) {
            th = th3;
            zipFile3 = zipFile;
            if (zipFile3 != null) {
                try {
                    zipFile3.close();
                } catch (IOException e11) {
                    DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e11.toString());
                }
            }
            throw th;
        }
        long currentThreadTimeMillis2222222 = SystemClock.currentThreadTimeMillis();
        DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis2222222 - currentThreadTimeMillis));
        if (z) {
            a.b(this.b + "/" + str3);
        }
        b();
        return j2;
    }

    public boolean a() {
        return c() > 0;
    }
}
