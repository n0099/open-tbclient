package com.bytedance.sdk.openadsdk.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.p;
import d.b.c.b.b.b;
import d.b.c.b.b.d;
import d.b.c.b.d.g;
import d.b.c.b.d.n;
import d.b.c.b.d.o;
/* loaded from: classes6.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f29263a;

    /* renamed from: c  reason: collision with root package name */
    public static d.b.c.b.f.a f29264c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29265b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29266d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.b.b.b f29267e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29268f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29269g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.b.b.d f29270h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.a.b f29271i;

    /* loaded from: classes6.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29272a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29273b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29274c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29275d;

        public a(ImageView imageView, String str, int i2, int i3) {
            this.f29272a = imageView;
            this.f29273b = str;
            this.f29274c = i2;
            this.f29275d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29272a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29273b)) ? false : true;
        }

        @Override // d.b.c.b.b.d.k
        public void a() {
            int i2;
            ImageView imageView = this.f29272a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29272a.getContext()).isFinishing()) || this.f29272a == null || !c() || (i2 = this.f29274c) == 0) {
                return;
            }
            this.f29272a.setImageResource(i2);
        }

        @Override // d.b.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
        }

        @Override // d.b.c.b.b.d.k
        public boolean a(byte[] bArr) {
            return false;
        }

        @Override // d.b.c.b.b.d.k
        public void b() {
            this.f29272a = null;
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29272a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29272a.getContext()).isFinishing()) || this.f29272a == null || this.f29275d == 0 || !c()) {
                return;
            }
            this.f29272a.setImageResource(this.f29275d);
        }

        @Override // d.b.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29272a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29272a.getContext()).isFinishing()) || this.f29272a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29272a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29265b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.b.c.b.f.a a() {
        return f29264c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29263a == null) {
            synchronized (e.class) {
                if (f29263a == null) {
                    f29263a = new e(p.a());
                }
            }
        }
        return f29263a;
    }

    private void i() {
        if (this.f29271i == null) {
            this.f29271i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29270h == null) {
            this.f29270h = new d.b.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29266d == null) {
            synchronized (e.class) {
                if (this.f29266d == null) {
                    this.f29266d = d.b.c.b.a.b(this.f29265b);
                }
            }
        }
        return this.f29266d;
    }

    public n e() {
        if (this.f29269g == null) {
            synchronized (e.class) {
                if (this.f29269g == null) {
                    this.f29269g = d.b.c.b.a.b(this.f29265b);
                }
            }
        }
        return this.f29269g;
    }

    public n f() {
        if (this.f29268f == null) {
            synchronized (e.class) {
                if (this.f29268f == null) {
                    this.f29268f = d.b.c.b.a.b(this.f29265b);
                }
            }
        }
        return this.f29268f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.f29271i;
    }

    public d.b.c.b.b.d h() {
        j();
        return this.f29270h;
    }

    public static void a(d.b.c.b.f.a aVar) {
        f29264c = aVar;
    }

    public void a(String str, b.InterfaceC1835b interfaceC1835b) {
        if (this.f29267e == null) {
            this.f29267e = new d.b.c.b.b.b(this.f29265b, d());
        }
        this.f29267e.d(str, interfaceC1835b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29270h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }
}
