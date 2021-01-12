package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.qq.e.comm.plugin.ac.g;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.j.b.f;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.k;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.FileUtil;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements Runnable {
    private static final ConcurrentHashMap<String, Object> f = new ConcurrentHashMap<>();
    private static final com.qq.e.comm.plugin.j.b g = new b.a().a(false).a(10000).b(10000).a();
    private static final LruCache<String, SoftReference<Bitmap>> h = new LruCache<>(5);

    /* renamed from: a  reason: collision with root package name */
    private final String f12343a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<ImageView> f12344b;
    private final b c;
    private final File d;
    private final boolean e;

    public d(String str, ImageView imageView, b bVar, boolean z) {
        this.f12343a = str;
        this.f12344b = new WeakReference<>(imageView);
        this.c = bVar;
        this.d = new File(ah.l(), FileUtil.getFileName(str));
        this.e = z;
    }

    private void a() {
        Object obj = f.get(this.f12343a);
        if (obj != null) {
            synchronized (obj) {
                Object obj2 = f.get(this.f12343a);
                if (obj2 != null) {
                    try {
                        obj2.wait(5000L);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    private void a(final int i, final Exception exc) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.p.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.c != null) {
                    d.this.c.a(d.this.f12343a, i, exc);
                }
            }
        });
    }

    private void a(final c cVar, final boolean z) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.p.d.2
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = (ImageView) d.this.f12344b.get();
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (cVar.a() && (imageView instanceof g)) {
                        ((g) imageView).a(cVar.b());
                    } else if (cVar.c() != null) {
                        imageView.setImageBitmap(cVar.c());
                    }
                }
                if (d.this.c != null) {
                    d.this.c.a(d.this.f12343a, imageView, new e.a().a(cVar.c()).a(z).a(d.this.d).a());
                }
            }
        });
    }

    private boolean a(boolean z) {
        boolean z2 = true;
        if (this.e) {
            a(new c(), z);
        } else {
            try {
                c c = c();
                if (c != null) {
                    a(c, z);
                } else if (z) {
                    this.d.delete();
                    z2 = false;
                } else {
                    a(102, new Exception("DecodeFailed"));
                }
            } catch (Exception e) {
                a(102, new Exception("DecodeFailed"));
            } catch (OutOfMemoryError e2) {
                a(101, new Exception(e2));
            }
        }
        return z2;
    }

    private void b() throws com.qq.e.comm.plugin.j.c {
        f fVar = new f(this.f12343a, this.d, 1, g);
        if (!fVar.c()) {
            throw new com.qq.e.comm.plugin.j.c(fVar.a(), fVar.b());
        }
    }

    private c c() throws OutOfMemoryError {
        Movie b2 = k.b(this.d);
        if (b2 != null) {
            return new c(b2);
        }
        Bitmap a2 = k.a(this.d, this.f12344b.get());
        if (a2 != null) {
            h.put(e(), new SoftReference<>(a2));
            return new c(a2);
        }
        return null;
    }

    private Bitmap d() {
        String e = e();
        SoftReference<Bitmap> softReference = h.get(e);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            h.remove(e);
            return null;
        }
        return bitmap;
    }

    private String e() {
        ImageView imageView = this.f12344b.get();
        int a2 = k.a(imageView);
        return this.f12343a + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + a2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + k.b(imageView);
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap d;
        a();
        if (!this.e && (d = d()) != null) {
            a(new c(d), true);
        } else if (this.d.exists() && a(true)) {
        } else {
            f.putIfAbsent(this.f12343a, new Object());
            Object obj = f.get(this.f12343a);
            synchronized (obj) {
                try {
                    b();
                    a(false);
                    f.remove(this.f12343a);
                    obj.notifyAll();
                } catch (com.qq.e.comm.plugin.j.c e) {
                    a(e.a(), e);
                    f.remove(this.f12343a);
                    obj.notifyAll();
                }
            }
        }
    }
}
