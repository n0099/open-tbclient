package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
/* loaded from: classes3.dex */
public class am {

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

    public static Bitmap a(Context context, String str) {
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
                        com.xiaomi.channel.commonutils.file.b.a(inputStream2);
                    } catch (IOException e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.channel.commonutils.file.b.a(inputStream2);
                        com.xiaomi.channel.commonutils.file.b.a(inputStream);
                        return bitmap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.file.b.a(inputStream2);
                    com.xiaomi.channel.commonutils.file.b.a(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
            } catch (Throwable th3) {
                inputStream2 = null;
                th = th3;
                com.xiaomi.channel.commonutils.file.b.a(inputStream2);
                com.xiaomi.channel.commonutils.file.b.a(inputStream);
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
        com.xiaomi.channel.commonutils.file.b.a(inputStream);
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
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
                httpURLConnection4.setConnectTimeout(8000);
                httpURLConnection4.setReadTimeout(MessageConfig.SOCKET_TIME_OUT_MS_2G);
                httpURLConnection4.connect();
                int contentLength = httpURLConnection4.getContentLength();
                if (!z || contentLength <= 102400) {
                    int responseCode = httpURLConnection4.getResponseCode();
                    if (responseCode != 200) {
                        com.xiaomi.channel.commonutils.logger.b.a("Invalid Http Response Code " + responseCode + " received");
                        com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
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
                                com.xiaomi.channel.commonutils.logger.b.a("length 102400 exhausted.");
                                a aVar2 = new a(null, BdStatsConstant.MAX_WRITE_LOG_SIZE);
                                com.xiaomi.channel.commonutils.file.b.a(inputStream);
                                if (httpURLConnection4 != null) {
                                    httpURLConnection4.disconnect();
                                }
                                aVar = aVar2;
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                a aVar3 = new a(byteArray, byteArray.length);
                                com.xiaomi.channel.commonutils.file.b.a(inputStream);
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
                                com.xiaomi.channel.commonutils.file.b.a(inputStream2);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return null;
                            } catch (Throwable th) {
                                inputStream = inputStream2;
                                HttpURLConnection httpURLConnection5 = httpURLConnection2;
                                th = th;
                                httpURLConnection3 = httpURLConnection5;
                                com.xiaomi.channel.commonutils.file.b.a(inputStream);
                                if (httpURLConnection3 != null) {
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            httpURLConnection = httpURLConnection4;
                            e = e2;
                            try {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                com.xiaomi.channel.commonutils.file.b.a(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection3 = httpURLConnection;
                                com.xiaomi.channel.commonutils.file.b.a(inputStream);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            httpURLConnection3 = httpURLConnection4;
                            th = th3;
                            com.xiaomi.channel.commonutils.file.b.a(inputStream);
                            if (httpURLConnection3 != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
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

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0052 */
    public static b a(Context context, String str, boolean z) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3 = null;
        b bVar = new b(null, 0L);
        try {
            try {
                a a2 = a(str, z);
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.file.b.a((Closeable) null);
                } else {
                    bVar.b = a2.b;
                    byte[] bArr = a2.a;
                    if (bArr != null) {
                        if (z) {
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                            try {
                                int a3 = a(context, byteArrayInputStream);
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inSampleSize = a3;
                                bVar.a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                                byteArrayInputStream3 = byteArrayInputStream;
                            } catch (Exception e) {
                                e = e;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                com.xiaomi.channel.commonutils.file.b.a(byteArrayInputStream);
                                return bVar;
                            }
                        } else {
                            bVar.a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        }
                    }
                    com.xiaomi.channel.commonutils.file.b.a(byteArrayInputStream3);
                }
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream3 = byteArrayInputStream2;
                com.xiaomi.channel.commonutils.file.b.a(byteArrayInputStream3);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.xiaomi.channel.commonutils.file.b.a(byteArrayInputStream3);
            throw th;
        }
        return bVar;
    }
}
