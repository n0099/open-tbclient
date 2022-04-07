package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {
    public static int a = 8;
    public static volatile c b;
    public a<Integer, Bitmap> c;

    /* loaded from: classes7.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {
        public final int a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.a = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.a;
        }
    }

    public c() {
        this.c = null;
        int i = a;
        this.c = new a<>(i, i / 2);
    }

    public static ByteArrayOutputStream b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public Bitmap a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public void a(final int i, final String str) {
        if (TextUtils.isEmpty(str) || a(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.m().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00b4 */
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0006 */
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: int */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: int */
            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: int */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: int */
            /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: int */
            /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: int */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable[]] */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e;
                int i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                try {
                    try {
                        i a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                        if (a2 == null) {
                            f.a(null, null, null, null);
                            return;
                        }
                        inputStream = a2.a();
                        try {
                            byteArrayOutputStream = c.b(inputStream);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e2) {
                                byteArrayInputStream2 = null;
                                e = e2;
                                byteArrayInputStream = null;
                            } catch (Throwable th2) {
                                byteArrayInputStream2 = null;
                                th = th2;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception e3) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e = e3;
                            byteArrayOutputStream = null;
                        } catch (Throwable th3) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            th = th3;
                            byteArrayOutputStream = null;
                        }
                        try {
                            byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                int a3 = com.ss.android.socialbase.appdownloader.c.a(com.ss.android.socialbase.downloader.downloader.c.N(), 44.0f);
                                options.inSampleSize = c.a(a3, a3, options);
                                options.inJustDecodeBounds = false;
                                c.this.c.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                f.a(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                            } catch (Exception e4) {
                                e = e4;
                                e.printStackTrace();
                                i2 = new Closeable[]{inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                f.a((Closeable[]) i2);
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream2 = null;
                            e = e5;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                            Closeable[] closeableArr = new Closeable[i2];
                            closeableArr[0] = inputStream;
                            closeableArr[1] = byteArrayOutputStream;
                            closeableArr[2] = byteArrayInputStream;
                            closeableArr[3] = byteArrayInputStream2;
                            f.a(closeableArr);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e6) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e6;
                    inputStream = null;
                } catch (Throwable th6) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th6;
                    inputStream = null;
                }
            }
        });
    }

    public static int a(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
