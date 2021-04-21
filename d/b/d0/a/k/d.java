package d.b.d0.a.k;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class d {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0055 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static byte[] a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                if (file.exists()) {
                    fileInputStream = new FileInputStream((File) file);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[32768];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    c(byteArrayOutputStream);
                                    c(fileInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            b.i().c("Failed to read file", e);
                            c(byteArrayOutputStream);
                            c(fileInputStream);
                            return null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        file = 0;
                        c(file);
                        c(fileInputStream);
                        throw th;
                    }
                } else {
                    throw new FileNotFoundException();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            file = 0;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0026 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public static void b(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream4 = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = 0;
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(bArr);
                fileOutputStream.flush();
                bufferedOutputStream.flush();
                c(fileOutputStream);
                fileOutputStream3 = bufferedOutputStream;
            } catch (IOException e3) {
                e = e3;
                fileOutputStream4 = fileOutputStream;
                fileOutputStream2 = bufferedOutputStream;
                try {
                    b.i().c("Failed to save file", e);
                    c(fileOutputStream4);
                    fileOutputStream3 = fileOutputStream2;
                    c(fileOutputStream3);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream4;
                    fileOutputStream4 = fileOutputStream2;
                    c(fileOutputStream);
                    c(fileOutputStream4);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream4 = bufferedOutputStream;
                try {
                    b.i().c("Failed to save file", th);
                    c(fileOutputStream);
                    c(fileOutputStream4);
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    c(fileOutputStream);
                    c(fileOutputStream4);
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
        c(fileOutputStream3);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                b.i().f("Failed to close the target", e2);
            }
        }
    }
}
