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
/* loaded from: classes5.dex */
public class e {
    private final File a;
    private final File b;
    private String c;

    public e(String str, String str2) {
        this.a = new File(str);
        this.b = new File(str2);
        this.c = this.b.getAbsolutePath();
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract mInput file = " + this.a.toString());
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract mOutput file = " + this.b.toString());
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

    private void b() {
        if (this.a == null || !this.a.exists()) {
            return;
        }
        if (this.a.delete()) {
            com.meizu.cloud.a.a.i("ZipExtractTask", "Delete file:" + this.a.toString() + " after extracted.");
        } else {
            com.meizu.cloud.a.a.i("ZipExtractTask", "Can't delete file:" + this.a.toString() + " after extracted.");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:105:0x0013 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:106:0x0013 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x00b9 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v45, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x027d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        ZipFile zipFile;
        Exception exc;
        String str;
        IOException iOException;
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
                                if (name != null && name.contains("../")) {
                                    throw new Exception("unsecurity zip file");
                                }
                                if (str2 == 0 && name != null) {
                                    str2 = name.split("/")[0];
                                    com.meizu.cloud.a.a.i("ZipExtractTask", "Extract temp directory=" + this.b + "/" + ((String) str2));
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
                        } catch (Exception e5) {
                            str = str2;
                            exc = e5;
                            com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted Exception " + exc.toString());
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e6) {
                                    com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e6.toString());
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
                    String str3 = this.b + "/" + str2;
                    if (this.c.equals(str3)) {
                        z2 = false;
                    } else {
                        a.a(str3, this.c);
                        z2 = true;
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e7) {
                            com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e7.toString());
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
                } catch (ZipException e8) {
                    str = null;
                    zipException = e8;
                } catch (IOException e9) {
                    str = null;
                    iOException = e9;
                } catch (Exception e10) {
                    str = null;
                    exc = e10;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        str2.close();
                    } catch (IOException e11) {
                        com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e11.toString());
                    }
                }
                throw th;
            }
        } catch (ZipException e12) {
            zipFile = null;
            zipException = e12;
            str = null;
        } catch (IOException e13) {
            zipFile = null;
            iOException = e13;
            str = null;
        } catch (Exception e14) {
            zipFile = null;
            exc = e14;
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

    public boolean a() {
        return c() > 0;
    }
}
