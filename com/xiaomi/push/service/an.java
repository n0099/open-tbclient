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
/* loaded from: classes7.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static long f38051a;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f38052a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f888a;

        public a(byte[] bArr, int i2) {
            this.f888a = bArr;
            this.f38052a = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f38053a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f889a;

        public b(Bitmap bitmap, long j) {
            this.f889a = bitmap;
            this.f38053a = j;
        }
    }

    public static int a(Context context, InputStream inputStream) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.m57a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        int i3 = options.outWidth;
        if (i3 <= round || (i2 = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i3 / round, i2 / round);
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
        } catch (IOException e2) {
            e = e2;
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
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.y.a(inputStream2);
                com.xiaomi.push.y.a(inputStream);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
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
        } catch (IOException e2) {
            e = e2;
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
                com.xiaomi.channel.commonutils.logger.b.m57a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                com.xiaomi.push.y.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                com.xiaomi.channel.commonutils.logger.b.m57a("Invalid Http Response Code " + responseCode + " received");
                com.xiaomi.push.y.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = z ? 102400 : 2048000;
                byte[] bArr = new byte[1024];
                while (i2 > 0) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    i2 -= read;
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (i2 <= 0) {
                    com.xiaomi.channel.commonutils.logger.b.m57a("length 102400 exhausted.");
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
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.y.a(inputStream);
            }
        } catch (SocketTimeoutException unused3) {
            inputStream = null;
        } catch (IOException e4) {
            e = e4;
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
                bVar.f889a = b2;
                return bVar;
            }
            try {
                a2 = a(str, z);
            } catch (Exception e2) {
                e = e2;
            }
            if (a2 == null) {
                com.xiaomi.push.y.a((Closeable) null);
                return bVar;
            }
            bVar.f38053a = a2.f38052a;
            byte[] bArr = a2.f888a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f889a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e3) {
                        e = e3;
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
                    bVar.f889a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f888a, str);
            com.xiaomi.push.y.a(byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f38051a == 0) {
                f38051a = com.xiaomi.push.x.a(file);
            }
            if (f38051a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (!listFiles[i2].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i2].lastModified()) > 1209600) {
                            listFiles[i2].delete();
                        }
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
                f38051a = 0L;
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
            com.xiaomi.channel.commonutils.logger.b.m57a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        ?? file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File((File) file, com.xiaomi.push.bm.a(str));
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                file = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
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
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream2 = bufferedOutputStream;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.push.y.a(bufferedOutputStream2);
            closeable = file;
            com.xiaomi.push.y.a(closeable);
            file = (f38051a > 0L ? 1 : (f38051a == 0L ? 0 : -1));
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
        file = (f38051a > 0L ? 1 : (f38051a == 0L ? 0 : -1));
        if (file != 0) {
            f38051a = com.xiaomi.push.x.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
        }
    }

    public static Bitmap b(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bm.a(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (file.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
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
            } catch (Exception e3) {
                e = e3;
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
