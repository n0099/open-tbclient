package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
/* loaded from: classes10.dex */
public class aw {
    public static long a;

    /* loaded from: classes10.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f912a;

        public a(byte[] bArr, int i) {
            this.f912a = bArr;
            this.a = i;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f913a;

        public b(Bitmap bitmap, long j) {
            this.f913a = bitmap;
            this.a = j;
        }
    }

    public static int a(Context context, InputStream inputStream) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.m182a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        int i2 = options.outWidth;
        if (i2 <= round || (i = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i2 / round, i / round);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x002d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Uri parse = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
            } catch (Throwable th) {
                th = th;
                r0 = context;
            }
        } catch (IOException e) {
            e = e;
            inputStream2 = null;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            int a2 = a(context, inputStream);
            inputStream2 = context.getContentResolver().openInputStream(parse);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                com.xiaomi.push.y.a(inputStream2);
                com.xiaomi.push.y.a(inputStream);
                return decodeStream;
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.y.a(inputStream2);
                com.xiaomi.push.y.a(inputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.y.a((Closeable) r0);
            com.xiaomi.push.y.a(inputStream);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00dd, code lost:
        if (r1 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00df, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fc, code lost:
        if (r1 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ff, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0101: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:64:0x0101 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String str, boolean z) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
            }
        } catch (SocketTimeoutException unused) {
            httpURLConnection = null;
            inputStream = null;
        } catch (IOException e) {
            e = e;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            if (z && contentLength > 102400) {
                com.xiaomi.channel.commonutils.logger.b.m182a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                com.xiaomi.push.y.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                com.xiaomi.channel.commonutils.logger.b.m182a("Invalid Http Response Code " + responseCode + " received");
                com.xiaomi.push.y.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = z ? 102400 : 2048000;
                byte[] bArr = new byte[1024];
                while (i > 0) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    i -= read;
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (i <= 0) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("length 102400 exhausted.");
                    a aVar = new a(null, 102400);
                    com.xiaomi.push.y.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a aVar2 = new a(byteArray, byteArray.length);
                com.xiaomi.push.y.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return aVar2;
            } catch (SocketTimeoutException unused2) {
                com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                com.xiaomi.push.y.a(inputStream);
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.y.a(inputStream);
            }
        } catch (SocketTimeoutException unused3) {
            inputStream = null;
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.y.a(closeable2);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static b a(Context context, String str, boolean z) {
        a a2;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        Bitmap b2 = b(context, str);
        try {
            if (b2 != null) {
                bVar.f913a = b2;
                return bVar;
            }
            try {
                a2 = a(str, z);
            } catch (Exception e) {
                e = e;
            }
            if (a2 == null) {
                com.xiaomi.push.y.a((Closeable) null);
                return bVar;
            }
            bVar.a = a2.a;
            byte[] bArr = a2.f912a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f913a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.y.a(byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.push.y.a(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f913a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f912a, str);
            com.xiaomi.push.y.a(byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (a == 0) {
                a = com.xiaomi.push.x.a(file);
            }
            if (a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                a = 0L;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00a9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, byte[] bArr, String str) {
        Closeable closeable;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m182a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        ?? file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File((File) file, com.xiaomi.push.bo.a(str));
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                file = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(file);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            file = 0;
        } catch (Throwable th2) {
            th = th2;
            file = 0;
        }
        try {
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            com.xiaomi.push.y.a(bufferedOutputStream);
            closeable = file;
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.push.y.a(bufferedOutputStream2);
            closeable = file;
            com.xiaomi.push.y.a(closeable);
            file = (a > 0L ? 1 : (a == 0L ? 0 : -1));
            if (file != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            com.xiaomi.push.y.a(bufferedOutputStream2);
            com.xiaomi.push.y.a((Closeable) file);
            throw th;
        }
        com.xiaomi.push.y.a(closeable);
        file = (a > 0L ? 1 : (a == 0L ? 0 : -1));
        if (file != 0) {
            a = com.xiaomi.push.x.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
        }
    }

    public static Bitmap b(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bo.a(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (file.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e) {
                    e = e;
                    bitmap = null;
                }
            } catch (Throwable th2) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th2;
                fileInputStream = fileInputStream3;
            }
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream);
                file.setLastModified(System.currentTimeMillis());
                com.xiaomi.push.y.a(fileInputStream);
                return bitmap2;
            } catch (Exception e2) {
                e = e2;
                Bitmap bitmap3 = bitmap2;
                fileInputStream2 = fileInputStream;
                bitmap = bitmap3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.y.a(fileInputStream2);
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                com.xiaomi.push.y.a(fileInputStream);
                throw th;
            }
        }
        return null;
    }
}
