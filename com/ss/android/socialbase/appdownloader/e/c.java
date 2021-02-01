package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.g;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f13035a = 8;
    private static volatile c qdD;
    private a<Integer, Bitmap> qdE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a  reason: collision with root package name */
        final int f13038a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.f13038a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f13038a;
        }
    }

    public static c eFv() {
        if (qdD == null) {
            synchronized (c.class) {
                if (qdD == null) {
                    qdD = new c();
                }
            }
        }
        return qdD;
    }

    private c() {
        this.qdE = null;
        this.qdE = new a<>(f13035a, f13035a / 2);
    }

    public Bitmap a(int i) {
        return this.qdE.get(Integer.valueOf(i));
    }

    public void a(final int i, final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.ss.android.socialbase.downloader.downloader.b.uj().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    InputStream inputStream = null;
                    try {
                        try {
                            g b2 = com.ss.android.socialbase.downloader.downloader.b.b(true, 0, str, null);
                            if (b2 != null) {
                                inputStream = b2.a();
                                c.this.qdE.put(Integer.valueOf(i), BitmapFactory.decodeStream(inputStream));
                                com.ss.android.socialbase.downloader.m.d.a(inputStream);
                                return;
                            }
                            com.ss.android.socialbase.downloader.m.d.a(null);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            com.ss.android.socialbase.downloader.m.d.a(inputStream);
                            return;
                        }
                    } catch (Throwable th) {
                        com.ss.android.socialbase.downloader.m.d.a(inputStream);
                        throw th;
                    }
                    com.ss.android.socialbase.downloader.m.d.a(inputStream);
                    throw th;
                }
            });
        }
    }
}
