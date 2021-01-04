package com.pgl.sys.ces.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class e {
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (r0.length() == 0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context) {
        String str;
        String str2;
        synchronized (e.class) {
            try {
                str2 = context.getFilesDir().getAbsolutePath() + "/" + IXAdRequestInfo.CELL_ID;
            } finally {
                if (str != null) {
                }
                str = "0[<!>]ERROR[<!>]";
                return str;
            }
            if (!new File(str2).exists() || (str = a(str2)) == null || str.length() <= 0) {
                InputStream open = context.getResources().getAssets().open(IXAdRequestInfo.CELL_ID);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                a("chmod 777 " + str2);
                str = a(str2);
                if (str == null || str.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "rw");
                    randomAccessFile.seek(16L);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    str = a(str2);
                }
                if (str != null) {
                }
                str = "0[<!>]ERROR[<!>]";
            }
        }
        return str;
    }

    private static String a(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String str2 = null;
        try {
            try {
                process = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
                try {
                    bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                } catch (Exception e) {
                    e = e;
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            process = null;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(process.getInputStream());
            try {
                bufferedOutputStream.write(str.getBytes());
                bufferedOutputStream.write(10);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                process.waitFor();
                str2 = b(bufferedInputStream);
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return str2;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
        return str2;
    }

    private static String b(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (read >= 4096);
        return sb.toString();
    }
}
