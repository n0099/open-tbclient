package d.m.b.b.a;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ed, code lost:
        if (r8.length() == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context) {
        String str;
        synchronized (e.class) {
            try {
                String str2 = context.getFilesDir().getAbsolutePath() + "/" + IAdRequestParam.CELL_ID;
                if (new File(str2).exists()) {
                    c("chmod 777 " + str2);
                    String c2 = c(str2);
                    c("chmod 600 " + str2);
                    if (c2 != null && c2.length() > 0) {
                        return c2;
                    }
                }
                InputStream open = context.getResources().getAssets().open(IAdRequestParam.CELL_ID);
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
                c("chmod 777 " + str2);
                str = c(str2);
                if (str == null || str.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "rw");
                    randomAccessFile.seek(16L);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    str = c(str2);
                }
                c("chmod 600 " + str2);
            } catch (Throwable unused) {
                str = "0[<!>]EXCEPTION[<!>]";
            }
            if (str != null) {
            }
            str = "0[<!>]ERROR[<!>]";
            return str;
        }
    }

    public static String b(BufferedInputStream bufferedInputStream) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x004c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x007d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:? */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        r1.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007c, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        ?? r3;
        BufferedOutputStream bufferedOutputStream2 = null;
        r0 = null;
        String str2 = null;
        bufferedOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec(IAdRequestParam.SCREEN_HEIGHT);
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = null;
                r3 = bufferedOutputStream;
                e.printStackTrace();
                if (bufferedOutputStream != null) {
                }
                if (r3 != null) {
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                throw th;
            }
            try {
                r3 = new BufferedInputStream(process.getInputStream());
                try {
                    try {
                        bufferedOutputStream.write(str.getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        process.waitFor();
                        str2 = b(r3);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        try {
                            r3.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                        if (r3 != null) {
                            try {
                                r3.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    bufferedInputStream = r3;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                r3 = null;
            } catch (Throwable th3) {
                th = th3;
                r3 = null;
                bufferedOutputStream2 = bufferedOutputStream;
                bufferedInputStream = r3;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            process = null;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            bufferedInputStream = null;
        }
    }
}
