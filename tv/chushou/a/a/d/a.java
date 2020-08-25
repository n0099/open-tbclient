package tv.chushou.a.a.d;

import android.support.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
/* loaded from: classes6.dex */
public final class a {
    public static void b(@Nullable Closeable... closeableArr) {
        if (closeableArr != null) {
            try {
                for (Closeable closeable : closeableArr) {
                    if (closeable != null) {
                        closeable.close();
                    }
                }
            } catch (IOException e) {
                tv.chushou.a.a.c.a.elU().e(null, "IOUtils:IOException thrown while closing Closeable.", e);
            }
        }
    }

    public static long e(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        if (inputStream != null && outputStream != null) {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            }
            outputStream.flush();
        }
        return j;
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String k(InputStream inputStream, String str) throws IOException {
        if (inputStream == null) {
            return "";
        }
        str = (str == null || str.isEmpty()) ? "UTF-8" : "UTF-8";
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public static void a(OutputStream outputStream, String str, String str2) throws IOException {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader = null;
        if (outputStream != null && str != null) {
            str2 = (str2 == null || str2.isEmpty()) ? "UTF-8" : "UTF-8";
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new StringReader(str));
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, str2));
                    try {
                        char[] cArr = new char[1024];
                        while (true) {
                            int read = bufferedReader2.read(cArr);
                            if (read != -1) {
                                bufferedWriter.write(cArr, 0, read);
                            } else {
                                bufferedWriter.flush();
                                b(bufferedWriter);
                                b(bufferedReader2);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        b(bufferedWriter);
                        b(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = null;
                    bufferedReader = bufferedReader2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
        }
    }

    public static String j(File file, String str) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || file.isDirectory()) {
            return "";
        }
        String str2 = "";
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str2 = k(fileInputStream, str);
                    b(fileInputStream);
                } catch (IOException e) {
                    e = e;
                    tv.chushou.a.a.c.a.elU().e(null, "IOUtils:read string from file=" + file + " failed", e);
                    b(fileInputStream);
                    return str2;
                }
            } catch (Throwable th) {
                th = th;
                b(fileInputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            b(fileInputStream);
            throw th;
        }
        return str2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x008a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x008c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0007 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x002f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v6, types: [tv.chushou.a.a.c.b] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static boolean b(String str, String str2, File file) {
        ?? r3;
        int i = 1;
        i = 1;
        i = 1;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        if (str != null && file != null) {
            File parentFile = file.getParentFile();
            if (at(parentFile)) {
                String str3 = file.getName() + ".tmp";
                File file2 = new File(parentFile, str3);
                try {
                    try {
                        r3 = new FileOutputStream(file2);
                        try {
                            a(r3, str, str2);
                            b(new Closeable[]{r3});
                            if (file2.renameTo(file)) {
                                r0 = 1;
                                str3 = r3;
                            } else {
                                ?? elU = tv.chushou.a.a.c.a.elU();
                                elU.e(null, "IOUtils:rename file failed");
                                i = elU;
                                str3 = r3;
                            }
                        } catch (IOException e) {
                            e = e;
                            tv.chushou.a.a.c.a.elU().e(null, "IOUtils:write string to file=" + file.getAbsolutePath() + " failed", e);
                            ?? r1 = {r3};
                            b(r1);
                            i = r1;
                            str3 = r3;
                            return r0;
                        }
                    } catch (Throwable th) {
                        th = th;
                        ?? r12 = new Closeable[i];
                        r12[r0] = str3;
                        b(r12);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    r3 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str3 = null;
                    ?? r122 = new Closeable[i];
                    r122[r0] = str3;
                    b(r122);
                    throw th;
                }
            }
        }
        return r0;
    }

    public static void delete(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    delete(file2);
                }
            }
            file.delete();
        }
    }

    public static boolean at(File file) {
        boolean z = false;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory() || (file.delete() && file.mkdirs())) {
                        z = true;
                    }
                } else {
                    z = file.mkdirs();
                }
            } catch (Exception e) {
            }
        }
        return z;
    }
}
