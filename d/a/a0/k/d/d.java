package d.a.a0.k.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class d {
    public static boolean a(String str, OutputStream outputStream) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        IOException e2;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            d.a.a0.n.c.c(bufferedInputStream2, bufferedOutputStream);
                            return true;
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        e2.printStackTrace();
                        d.a.a0.n.c.c(bufferedInputStream, bufferedOutputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        d.a.a0.n.c.c(bufferedInputStream, bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream2;
                    d.a.a0.n.c.c(bufferedInputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                e2 = e4;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
            }
        } catch (IOException e5) {
            e2 = e5;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x0025 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable[]] */
    public static Bitmap b(String str) {
        ?? r3;
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            try {
                r3 = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream(), 8192);
                try {
                    bitmap2 = BitmapFactory.decodeStream(r3);
                    d.a.a0.n.c.c(new Closeable[]{r3});
                    bitmap = r3;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    d.a.a0.n.c.c(new Closeable[]{r3});
                    bitmap = r3;
                    return bitmap2;
                }
            } catch (Throwable th) {
                th = th;
                bitmap2 = bitmap;
                d.a.a0.n.c.c(new Closeable[]{bitmap2});
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            r3 = 0;
        } catch (Throwable th2) {
            th = th2;
            d.a.a0.n.c.c(new Closeable[]{bitmap2});
            throw th;
        }
        return bitmap2;
    }
}
