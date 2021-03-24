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
/* loaded from: classes6.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f29500a;

    /* renamed from: c  reason: collision with root package name */
    public static d.c.c.b.f.a f29501c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29502b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29503d;

    /* renamed from: e  reason: collision with root package name */
    public d.c.c.b.b.b f29504e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29505f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29506g;

    /* renamed from: h  reason: collision with root package name */
    public d.c.c.b.b.d f29507h;
    public com.bytedance.sdk.openadsdk.i.a.b i;

    /* loaded from: classes6.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29508a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29509b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29510c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29511d;

        public a(ImageView imageView, String str, int i, int i2) {
            this.f29508a = imageView;
            this.f29509b = str;
            this.f29510c = i;
            this.f29511d = i2;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29508a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29509b)) ? false : true;
        }

        @Override // d.c.c.b.b.d.k
        public void a() {
            int i;
            ImageView imageView = this.f29508a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29508a.getContext()).isFinishing()) || this.f29508a == null || !c() || (i = this.f29510c) == 0) {
                return;
            }
            this.f29508a.setImageResource(i);
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
            this.f29508a = null;
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29508a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29508a.getContext()).isFinishing()) || this.f29508a == null || this.f29511d == 0 || !c()) {
                return;
            }
            this.f29508a.setImageResource(this.f29511d);
        }

        @Override // d.c.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29508a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29508a.getContext()).isFinishing()) || this.f29508a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29508a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29502b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.c.c.b.f.a a() {
        return f29501c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29500a == null) {
            synchronized (e.class) {
                if (f29500a == null) {
                    f29500a = new e(p.a());
                }
            }
        }
        return f29500a;
    }

    private void i() {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29507h == null) {
            this.f29507h = new d.c.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29503d == null) {
            synchronized (e.class) {
                if (this.f29503d == null) {
                    this.f29503d = d.c.c.b.a.b(this.f29502b);
                }
            }
        }
        return this.f29503d;
    }

    public n e() {
        if (this.f29506g == null) {
            synchronized (e.class) {
                if (this.f29506g == null) {
                    this.f29506g = d.c.c.b.a.b(this.f29502b);
                }
            }
        }
        return this.f29506g;
    }

    public n f() {
        if (this.f29505f == null) {
            synchronized (e.class) {
                if (this.f29505f == null) {
                    this.f29505f = d.c.c.b.a.b(this.f29502b);
                }
            }
        }
        return this.f29505f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.i;
    }

    public d.c.c.b.b.d h() {
        j();
        return this.f29507h;
    }

    public static void a(d.c.c.b.f.a aVar) {
        f29501c = aVar;
    }

    public void a(String str, b.InterfaceC1795b interfaceC1795b) {
        if (this.f29504e == null) {
            this.f29504e = new d.c.c.b.b.b(this.f29502b, d());
        }
        this.f29504e.d(str, interfaceC1795b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29507h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }
}
