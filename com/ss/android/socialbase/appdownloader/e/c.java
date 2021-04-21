package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import d.p.a.e.b.g.d;
import d.p.a.e.b.l.e;
import d.p.a.e.b.o.k;
import java.io.BufferedInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static int f39071b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f39072c;

    /* renamed from: a  reason: collision with root package name */
    public a<Integer, Bitmap> f39073a;

    /* loaded from: classes6.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f39074a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.f39074a = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f39074a;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39076f;

        public b(String str, int i) {
            this.f39075e = str;
            this.f39076f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            Exception e2;
            try {
                try {
                    k x = d.x(true, 0, this.f39075e, null);
                    if (x == null) {
                        e.C(null);
                        return;
                    }
                    bufferedInputStream = new BufferedInputStream(x.a());
                    try {
                        bufferedInputStream.mark(bufferedInputStream.available());
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        int c2 = d.p.a.e.a.d.c(d.l(), 44.0f);
                        options.inSampleSize = c.a(c2, c2, options);
                        options.inJustDecodeBounds = false;
                        bufferedInputStream.reset();
                        c.this.f39073a.put(Integer.valueOf(this.f39076f), BitmapFactory.decodeStream(bufferedInputStream, null, options));
                        e.C(bufferedInputStream);
                    } catch (Exception e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        e.C(bufferedInputStream);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    e.C(bufferedInputStream);
                    throw th;
                }
            } catch (Exception e4) {
                bufferedInputStream = null;
                e2 = e4;
            } catch (Throwable th3) {
                bufferedInputStream = null;
                th = th3;
                e.C(bufferedInputStream);
                throw th;
            }
        }
    }

    public c() {
        this.f39073a = null;
        int i = f39071b;
        this.f39073a = new a<>(i, i / 2);
    }

    public static int a(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    public static c d() {
        if (f39072c == null) {
            synchronized (c.class) {
                if (f39072c == null) {
                    f39072c = new c();
                }
            }
        }
        return f39072c;
    }

    public Bitmap b(int i) {
        return this.f39073a.get(Integer.valueOf(i));
    }

    public void e(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.x0().submit(new b(str, i));
    }
}
