package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.baidu.ar.constants.HttpConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class ag {

    /* loaded from: classes3.dex */
    public static class a {
        byte[] a;
        int b;

        public a(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public Bitmap a;
        public long b;

        public b(Bitmap bitmap, long j) {
            this.a = bitmap;
            this.b = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(String str) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        a aVar;
        int i = 102400;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setConnectTimeout(8000);
                httpURLConnection3.setReadTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
                httpURLConnection3.connect();
                int contentLength = httpURLConnection3.getContentLength();
                if (contentLength > 102400) {
                    com.xiaomi.channel.commonutils.logger.b.a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    com.xiaomi.channel.commonutils.file.a.a((InputStream) null);
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    aVar = null;
                } else {
                    int responseCode = httpURLConnection3.getResponseCode();
                    if (responseCode != 200) {
                        com.xiaomi.channel.commonutils.logger.b.a("Invalid Http Response Code " + responseCode + " received");
                        com.xiaomi.channel.commonutils.file.a.a((InputStream) null);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        aVar = null;
                    } else {
                        inputStream = httpURLConnection3.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
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
                                com.xiaomi.channel.commonutils.logger.b.a("length 102400 exhausted.");
                                a aVar2 = new a(null, 102400);
                                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                aVar = aVar2;
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                a aVar3 = new a(byteArray, byteArray.length);
                                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                aVar = aVar3;
                            }
                        } catch (IOException e) {
                            httpURLConnection = httpURLConnection3;
                            e = e;
                            try {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                httpURLConnection2 = httpURLConnection;
                                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            httpURLConnection2 = httpURLConnection3;
                            th = th2;
                            com.xiaomi.channel.commonutils.file.a.a(inputStream);
                            if (httpURLConnection2 != null) {
                            }
                            throw th;
                        }
                    }
                }
                return aVar;
            } catch (IOException e2) {
                inputStream = null;
                a aVar4 = aVar;
                e = e2;
                httpURLConnection = aVar4;
            } catch (Throwable th3) {
                inputStream = null;
                httpURLConnection2 = aVar;
                th = th3;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public static b a(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        a a2;
        b bVar = new b(null, 0L);
        try {
            a2 = a(str);
        } catch (Exception e) {
            e = e;
            byteArrayInputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayInputStream = null;
            com.xiaomi.channel.commonutils.file.a.a(byteArrayInputStream);
            throw th;
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.file.a.a((InputStream) null);
            return bVar;
        }
        bVar.b = a2.b;
        byte[] bArr = a2.a;
        if (bArr != null) {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    int a3 = a(context, byteArrayInputStream);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = a3;
                    bVar.a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.channel.commonutils.file.a.a(byteArrayInputStream);
                    return bVar;
                }
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.channel.commonutils.file.a.a(byteArrayInputStream);
                throw th;
            }
        } else {
            byteArrayInputStream = null;
        }
        com.xiaomi.channel.commonutils.file.a.a(byteArrayInputStream);
        return bVar;
    }

    public static Bitmap b(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        Bitmap bitmap = null;
        Uri parse = Uri.parse(str);
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                int a2 = a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
                try {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a2;
                        bitmap = BitmapFactory.decodeStream(inputStream2, null, options);
                        com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                    } catch (IOException e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                        com.xiaomi.channel.commonutils.file.a.a(inputStream);
                        return bitmap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                    com.xiaomi.channel.commonutils.file.a.a(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
            } catch (Throwable th3) {
                inputStream2 = null;
                th = th3;
                com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                com.xiaomi.channel.commonutils.file.a.a(inputStream);
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
        com.xiaomi.channel.commonutils.file.a.a(inputStream);
        return bitmap;
    }
}
