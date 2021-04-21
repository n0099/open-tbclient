package com.bytedance.sdk.openadsdk.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.p;
import d.c.c.b.b.b;
import d.c.c.b.b.d;
import d.c.c.b.d.g;
import d.c.c.b.d.n;
import d.c.c.b.d.o;
/* loaded from: classes5.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f29194a;

    /* renamed from: c  reason: collision with root package name */
    public static d.c.c.b.f.a f29195c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29196b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29197d;

    /* renamed from: e  reason: collision with root package name */
    public d.c.c.b.b.b f29198e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29199f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29200g;

    /* renamed from: h  reason: collision with root package name */
    public d.c.c.b.b.d f29201h;
    public com.bytedance.sdk.openadsdk.i.a.b i;

    /* loaded from: classes5.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29202a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29203b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29204c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29205d;

        public a(ImageView imageView, String str, int i, int i2) {
            this.f29202a = imageView;
            this.f29203b = str;
            this.f29204c = i;
            this.f29205d = i2;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29202a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29203b)) ? false : true;
        }

        @Override // d.c.c.b.b.d.k
        public void a() {
            int i;
            ImageView imageView = this.f29202a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29202a.getContext()).isFinishing()) || this.f29202a == null || !c() || (i = this.f29204c) == 0) {
                return;
            }
            this.f29202a.setImageResource(i);
        }

        @Override // d.c.c.b.d.o.a
        public void a(o<Bitmap> oVar) {
        }

        @Override // d.c.c.b.b.d.k
        public boolean a(byte[] bArr) {
            return false;
        }

        @Override // d.c.c.b.b.d.k
        public void b() {
            this.f29202a = null;
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29202a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29202a.getContext()).isFinishing()) || this.f29202a == null || this.f29205d == 0 || !c()) {
                return;
            }
            this.f29202a.setImageResource(this.f29205d);
        }

        @Override // d.c.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29202a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29202a.getContext()).isFinishing()) || this.f29202a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29202a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29196b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.c.c.b.f.a a() {
        return f29195c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29194a == null) {
            synchronized (e.class) {
                if (f29194a == null) {
                    f29194a = new e(p.a());
                }
            }
        }
        return f29194a;
    }

    private void i() {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29201h == null) {
            this.f29201h = new d.c.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29197d == null) {
            synchronized (e.class) {
                if (this.f29197d == null) {
                    this.f29197d = d.c.c.b.a.b(this.f29196b);
                }
            }
        }
        return this.f29197d;
    }

    public n e() {
        if (this.f29200g == null) {
            synchronized (e.class) {
                if (this.f29200g == null) {
                    this.f29200g = d.c.c.b.a.b(this.f29196b);
                }
            }
        }
        return this.f29200g;
    }

    public n f() {
        if (this.f29199f == null) {
            synchronized (e.class) {
                if (this.f29199f == null) {
                    this.f29199f = d.c.c.b.a.b(this.f29196b);
                }
            }
        }
        return this.f29199f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.i;
    }

    public d.c.c.b.b.d h() {
        j();
        return this.f29201h;
    }

    public static void a(d.c.c.b.f.a aVar) {
        f29195c = aVar;
    }

    public void a(String str, b.InterfaceC1827b interfaceC1827b) {
        if (this.f29198e == null) {
            this.f29198e = new d.c.c.b.b.b(this.f29196b, d());
        }
        this.f29198e.d(str, interfaceC1827b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29201h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }
}
