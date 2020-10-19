package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
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
/* loaded from: classes12.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private static long f5050a;

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f5051a;

        /* renamed from: a  reason: collision with other field name */
        byte[] f844a;

        public a(byte[] bArr, int i) {
            this.f844a = bArr;
            this.f5051a = i;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f5052a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f845a;

        public b(Bitmap bitmap, long j) {
            this.f845a = bitmap;
            this.f5052a = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.m55a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        Bitmap bitmap = null;
        Uri parse = Uri.parse(str);
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                int a2 = a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = a2;
                    bitmap = BitmapFactory.decodeStream(inputStream2, null, options);
                    com.xiaomi.push.y.a(inputStream2);
                    com.xiaomi.push.y.a(inputStream);
                } catch (IOException e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.y.a(inputStream2);
                    com.xiaomi.push.y.a(inputStream);
                    return bitmap;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
            } catch (Throwable th3) {
                inputStream2 = null;
                th = th3;
                com.xiaomi.push.y.a(inputStream2);
                com.xiaomi.push.y.a(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            inputStream2 = null;
        } catch (Throwable th4) {
            inputStream = null;
            inputStream2 = null;
            th = th4;
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(String str, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        a aVar;
        int i = BdStatsConstant.MAX_WRITE_LOG_SIZE;
        HttpURLConnection httpURLConnection3 = null;
        try {
            HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection4.setConnectTimeout(CoolPraiseGuideLottieView.ANIM_DURATION);
                httpURLConnection4.setReadTimeout(20000);
                httpURLConnection4.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                httpURLConnection4.connect();
                int contentLength = httpURLConnection4.getContentLength();
                if (!z || contentLength <= 102400) {
                    int responseCode = httpURLConnection4.getResponseCode();
                    if (responseCode != 200) {
                        com.xiaomi.channel.commonutils.logger.b.m55a("Invalid Http Response Code " + responseCode + " received");
                        com.xiaomi.push.y.a((Closeable) null);
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                        aVar = null;
                    } else {
                        inputStream = httpURLConnection4.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            if (!z) {
                                i = 2048000;
                            }
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
                                com.xiaomi.channel.commonutils.logger.b.m55a("length 102400 exhausted.");
                                a aVar2 = new a(null, BdStatsConstant.MAX_WRITE_LOG_SIZE);
                                com.xiaomi.push.y.a(inputStream);
                                if (httpURLConnection4 != null) {
                                    httpURLConnection4.disconnect();
                                }
                                aVar = aVar2;
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                a aVar3 = new a(byteArray, byteArray.length);
                                com.xiaomi.push.y.a(inputStream);
                                if (httpURLConnection4 != null) {
                                    httpURLConnection4.disconnect();
                                }
                                aVar = aVar3;
                            }
                        } catch (SocketTimeoutException e) {
                            inputStream2 = inputStream;
                            httpURLConnection2 = httpURLConnection4;
                            try {
                                com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                                com.xiaomi.push.y.a(inputStream2);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return null;
                            } catch (Throwable th) {
                                inputStream = inputStream2;
                                HttpURLConnection httpURLConnection5 = httpURLConnection2;
                                th = th;
                                httpURLConnection3 = httpURLConnection5;
                                com.xiaomi.push.y.a(inputStream);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            httpURLConnection = httpURLConnection4;
                            e = e2;
                            try {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                com.xiaomi.push.y.a(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection3 = httpURLConnection;
                                com.xiaomi.push.y.a(inputStream);
                                if (httpURLConnection3 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            httpURLConnection3 = httpURLConnection4;
                            th = th3;
                            com.xiaomi.push.y.a(inputStream);
                            if (httpURLConnection3 != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m55a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    com.xiaomi.push.y.a((Closeable) null);
                    if (httpURLConnection4 != null) {
                        httpURLConnection4.disconnect();
                    }
                    aVar = null;
                }
                return aVar;
            } catch (SocketTimeoutException e3) {
                inputStream2 = null;
                httpURLConnection2 = aVar;
            } catch (IOException e4) {
                inputStream = null;
                a aVar4 = aVar;
                e = e4;
                httpURLConnection = aVar4;
            } catch (Throwable th4) {
                inputStream = null;
                httpURLConnection3 = aVar;
                th = th4;
            }
        } catch (SocketTimeoutException e5) {
            httpURLConnection2 = null;
            inputStream2 = null;
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    public static b a(Context context, String str, boolean z) {
        ByteArrayInputStream byteArrayInputStream;
        b bVar = new b(null, 0L);
        Bitmap b2 = b(context, str);
        try {
            if (b2 != null) {
                bVar.f845a = b2;
            } else {
                try {
                    a a2 = a(str, z);
                    if (a2 == null) {
                        com.xiaomi.push.y.a((Closeable) null);
                    } else {
                        bVar.f5052a = a2.f5051a;
                        byte[] bArr = a2.f844a;
                        if (bArr != null) {
                            if (z) {
                                byteArrayInputStream = new ByteArrayInputStream(bArr);
                                try {
                                    int a3 = a(context, byteArrayInputStream);
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inSampleSize = a3;
                                    bVar.f845a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                                    a(context, a2.f844a, str);
                                    com.xiaomi.push.y.a(byteArrayInputStream);
                                } catch (Exception e) {
                                    e = e;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    com.xiaomi.push.y.a(byteArrayInputStream);
                                    return bVar;
                                }
                            } else {
                                bVar.f845a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            }
                        }
                        byteArrayInputStream = null;
                        a(context, a2.f844a, str);
                        com.xiaomi.push.y.a(byteArrayInputStream);
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    com.xiaomi.push.y.a((Closeable) null);
                    throw th;
                }
            }
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f5050a == 0) {
                f5050a = com.xiaomi.push.x.a(file);
            }
            if (f5050a > 15728640) {
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
                f5050a = 0L;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, byte[] bArr, String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        FileOutputStream fileOutputStream = null;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m55a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, com.xiaomi.push.bf.a(str));
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
            } catch (Exception e) {
                e = e;
                bufferedOutputStream2 = null;
                fileOutputStream = fileOutputStream2;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                fileOutputStream = fileOutputStream2;
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                com.xiaomi.push.y.a(bufferedOutputStream);
                com.xiaomi.push.y.a(fileOutputStream2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.y.a(bufferedOutputStream2);
                    com.xiaomi.push.y.a(fileOutputStream);
                    if (f5050a != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    com.xiaomi.push.y.a(bufferedOutputStream);
                    com.xiaomi.push.y.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                com.xiaomi.push.y.a(bufferedOutputStream);
                com.xiaomi.push.y.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
        if (f5050a != 0) {
            f5050a = com.xiaomi.push.x.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
        }
    }

    private static Bitmap b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        Bitmap bitmap = null;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bf.a(str));
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(fileInputStream);
                        file.setLastModified(System.currentTimeMillis());
                        com.xiaomi.push.y.a(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.y.a(fileInputStream);
                        return bitmap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.push.y.a(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                com.xiaomi.push.y.a(fileInputStream);
                throw th;
            }
        }
        return bitmap;
    }
}
