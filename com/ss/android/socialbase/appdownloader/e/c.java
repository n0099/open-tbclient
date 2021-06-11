package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import d.o.a.e.b.g.d;
import d.o.a.e.b.l.e;
import d.o.a.e.b.o.k;
import java.io.BufferedInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static int f39510b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f39511c;

    /* renamed from: a  reason: collision with root package name */
    public a<Integer, Bitmap> f39512a;

    /* loaded from: classes7.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f39513a;

        public a(int i2, int i3) {
            super(i3, 0.75f, true);
            this.f39513a = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f39513a;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39515f;

        public b(String str, int i2) {
            this.f39514e = str;
            this.f39515f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            Exception e2;
            try {
                try {
                    k x = d.x(true, 0, this.f39514e, null);
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
                        int c2 = d.o.a.e.a.d.c(d.l(), 44.0f);
                        options.inSampleSize = c.a(c2, c2, options);
                        options.inJustDecodeBounds = false;
                        bufferedInputStream.reset();
                        c.this.f39512a.put(Integer.valueOf(this.f39515f), BitmapFactory.decodeStream(bufferedInputStream, null, options));
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
        this.f39512a = null;
        int i2 = f39510b;
        this.f39512a = new a<>(i2, i2 / 2);
    }

    public static int a(int i2, int i3, BitmapFactory.Options options) {
        if (options.outWidth > i2 || options.outHeight > i3) {
            return Math.min(Math.round(options.outWidth / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }

    public static c d() {
        if (f39511c == null) {
            synchronized (c.class) {
                if (f39511c == null) {
                    f39511c = new c();
                }
            }
        }
        return f39511c;
    }

    public Bitmap b(int i2) {
        return this.f39512a.get(Integer.valueOf(i2));
    }

    public void e(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.x0().submit(new b(str, i2));
    }
}
