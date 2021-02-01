package com.meizu.cloud.pushsdk.notification.c;

import android.os.SystemClock;
import com.baidu.android.imsdk.retrieve.Constants;
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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final File f11340a;

    /* renamed from: b  reason: collision with root package name */
    private final File f11341b;
    private String c;

    public e(String str, String str2) {
        this.f11340a = new File(str);
        this.f11341b = new File(str2);
        this.c = this.f11341b.getAbsolutePath();
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract mInput file = " + this.f11340a.toString());
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract mOutput file = " + this.f11341b.toString());
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
        if (this.f11340a == null || !this.f11340a.exists()) {
            return;
        }
        if (this.f11340a.delete()) {
            com.meizu.cloud.a.a.i("ZipExtractTask", "Delete file:" + this.f11340a.toString() + " after extracted.");
        } else {
            com.meizu.cloud.a.a.i("ZipExtractTask", "Can't delete file:" + this.f11340a.toString() + " after extracted.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0270 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        Exception e;
        String str;
        ZipFile zipFile;
        IOException e2;
        ZipException e3;
        String str2;
        FileOutputStream fileOutputStream;
        ZipFile zipFile2 = null;
        boolean z = false;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        long j = 0;
        try {
            try {
                zipFile = new ZipFile(this.f11340a);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    String str3 = null;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                String name = nextElement.getName();
                                if (name != null && name.contains(Constants.PATH_PARENT)) {
                                    throw new Exception("unsecurity zip file");
                                }
                                if (str3 != null || name == null) {
                                    str2 = str3;
                                } else {
                                    str2 = name.split("/")[0];
                                    try {
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract temp directory=" + this.f11341b + "/" + str2);
                                    } catch (ZipException e4) {
                                        e3 = e4;
                                        str = str2;
                                        com.meizu.cloud.a.a.e("ZipExtractTask", "ZipException :" + e3.toString());
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e5) {
                                                com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e5.toString());
                                            }
                                        }
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.f11340a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                                        if (z) {
                                        }
                                        b();
                                        return j;
                                    } catch (IOException e6) {
                                        e2 = e6;
                                        str = str2;
                                        com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e2.toString());
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e7) {
                                                com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e7.toString());
                                            }
                                        }
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.f11340a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                                        if (z) {
                                        }
                                        b();
                                        return j;
                                    } catch (Exception e8) {
                                        e = e8;
                                        str = str2;
                                        com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted Exception " + e.toString());
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e9) {
                                                com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e9.toString());
                                            }
                                        }
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.f11340a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                                        if (z) {
                                        }
                                        b();
                                        return j;
                                    }
                                }
                                File file = new File(this.f11341b, name);
                                if (!file.getParentFile().exists()) {
                                    if (file.getParentFile().mkdirs()) {
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Make Destination directory=" + file.getParentFile().getAbsolutePath());
                                    } else {
                                        com.meizu.cloud.a.a.i("ZipExtractTask", "Can't make destination directory=" + file.getParentFile().getAbsolutePath());
                                    }
                                }
                                j += a(zipFile.getInputStream(nextElement), fileOutputStream);
                                new FileOutputStream(file).close();
                                str3 = str2;
                            }
                        } catch (ZipException e10) {
                            e3 = e10;
                            str = str3;
                        } catch (IOException e11) {
                            e2 = e11;
                            str = str3;
                        } catch (Exception e12) {
                            e = e12;
                            str = str3;
                        }
                    }
                    String str4 = this.f11341b + "/" + str3;
                    if (!this.c.equals(str4)) {
                        a.a(str4, this.c);
                        z = true;
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e13) {
                            com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e13.toString());
                            str = str3;
                        }
                    }
                    str = str3;
                } catch (ZipException e14) {
                    e3 = e14;
                    str = null;
                } catch (IOException e15) {
                    e2 = e15;
                    str = null;
                } catch (Exception e16) {
                    e = e16;
                    str = null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        zipFile2.close();
                    } catch (IOException e17) {
                        com.meizu.cloud.a.a.e("ZipExtractTask", "Extracted IOException:" + e17.toString());
                    }
                }
                throw th;
            }
        } catch (ZipException e18) {
            e3 = e18;
            str = null;
            zipFile = null;
        } catch (IOException e19) {
            e2 = e19;
            str = null;
            zipFile = null;
        } catch (Exception e20) {
            e = e20;
            str = null;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        com.meizu.cloud.a.a.i("ZipExtractTask", "Extract file " + this.f11340a + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        if (z) {
            a.b(this.f11341b + "/" + str);
        }
        b();
        return j;
    }

    public boolean a() {
        return c() > 0;
    }
}
