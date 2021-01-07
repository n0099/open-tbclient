package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.g;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f13333a = 8;
    private static volatile c pXZ;
    private a<Integer, Bitmap> pYa;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a  reason: collision with root package name */
        final int f13336a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.f13336a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f13336a;
        }
    }

    public static c eGU() {
        if (pXZ == null) {
            synchronized (c.class) {
                if (pXZ == null) {
                    pXZ = new c();
                }
            }
        }
        return pXZ;
    }

    private c() {
        this.pYa = null;
        this.pYa = new a<>(f13333a, f13333a / 2);
    }

    public Bitmap a(int i) {
        return this.pYa.get(Integer.valueOf(i));
    }

    public void a(final int i, final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.ss.android.socialbase.downloader.downloader.b.ut().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    InputStream inputStream = null;
                    try {
                        try {
                            g b2 = com.ss.android.socialbase.downloader.downloader.b.b(true, 0, str, null);
                            if (b2 != null) {
                                inputStream = b2.a();
                                c.this.pYa.put(Integer.valueOf(i), BitmapFactory.decodeStream(inputStream));
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
