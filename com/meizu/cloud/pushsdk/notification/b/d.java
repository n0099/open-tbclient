package com.meizu.cloud.pushsdk.notification.b;

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
/* loaded from: classes3.dex */
public class d {
    private final File a;
    private final File b;
    private String c;

    public d(String str, String str2) {
        this.a = new File(str);
        this.b = new File(str2);
        this.c = this.b.getAbsolutePath();
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract mInput file = " + this.a.toString());
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract mOutput file = " + this.b.toString());
    }

    private void b() {
        if (this.a != null && this.a.exists()) {
            if (this.a.delete()) {
                com.meizu.cloud.a.a.i("ZipExtractTask", "Delete file:" + this.a.toString() + " after extracted.");
            } else {
                com.meizu.cloud.a.a.i("ZipExtractTask", "Can't delete file:" + this.a.toString() + " after extracted.");
            }
        }
    }

    public boolean a() {
        return c() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4, 113=4, 115=4, 116=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0013 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0013 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v33, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        ZipFile zipFile;
        IOException iOException;
        String str;
        ZipException zipException;
        boolean z;
        long j;
        boolean z2;
        FileOutputStream fileOutputStream;
        String str2 = 0;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        long j2 = 0;
        try {
            try {
                zipFile = new ZipFile(this.a);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                String name = nextElement.getName();
                                str2 = str2;
                                str2 = str2;
                                if (str2 == 0 && name != null) {
                                    String str3 = name.split("/")[0];
                                    com.meizu.cloud.a.a.i("ZipExtractTask", "Extract temp directory=" + this.b + "/" + str3);
                                    str2 = str3;
                                }
                                File file = new File(this.b, name);
                                if (!file.getParentFile().exists()) {
                                    if (file.getParentFile().mkdirs()) {
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Make Destination directory=" + file.getParentFile().getAbsolutePath());
                                    } else {
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Can't make destination directory=" + file.getParentFile().getAbsolutePath());
                                    }
                                }
                                j2 += a(zipFile.getInputStream(nextElement), fileOutputStream);
                                new FileOutputStream(file).close();
                            }
                        } catch (ZipException e) {
                            str = str2;
                            zipException = e;
                            com.meizu.cloud.a.a.e("ZipExtractTask", "ZipException :" + zipException.toString());
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e2) {
                                    com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e2.toString());
                                    z = false;
                                    j = j2;
                                }
                            }
                            z = false;
                            j = j2;
                            com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                            if (z) {
                            }
                            b();
                            return j;
                        } catch (IOException e3) {
                            str = str2;
                            iOException = e3;
                            com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + iOException.toString());
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e4) {
                                    com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e4.toString());
                                    z = false;
                                    j = j2;
                                }
                            }
                            z = false;
                            j = j2;
                            com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                            if (z) {
                            }
                            b();
                            return j;
                        }
                    }
                    String str4 = this.b + "/" + str2;
                    if (this.c.equals(str4)) {
                        z2 = false;
                    } else {
                        a.a(str4, this.c);
                        z2 = true;
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e5.toString());
                            j = j2;
                            boolean z3 = z2;
                            str = str2;
                            z = z3;
                        }
                    }
                    j = j2;
                    boolean z4 = z2;
                    str = str2;
                    z = z4;
                } catch (ZipException e6) {
                    str = null;
                    zipException = e6;
                } catch (IOException e7) {
                    str = null;
                    iOException = e7;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        str2.close();
                    } catch (IOException e8) {
                        com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e8.toString());
                    }
                }
                throw th;
            }
        } catch (ZipException e9) {
            zipFile = null;
            zipException = e9;
            str = null;
        } catch (IOException e10) {
            zipFile = null;
            iOException = e10;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        if (z) {
            a.b(this.b + "/" + str);
        }
        b();
        return j;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private int a(InputStream inputStream, OutputStream outputStream) {
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
                    i = read + i;
                } finally {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        com.meizu.cloud.a.a.e("ZipExtractTask", "out.close() IOException e=" + e.toString());
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        com.meizu.cloud.a.a.e("ZipExtractTask", "in.close() IOException e=" + e2.toString());
                    }
                }
            } catch (IOException e3) {
                com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e3.toString());
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    com.meizu.cloud.a.a.e("ZipExtractTask", "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    com.meizu.cloud.a.a.e("ZipExtractTask", "in.close() IOException e=" + e5.toString());
                }
            }
        }
        bufferedOutputStream.flush();
        return i;
    }
}
