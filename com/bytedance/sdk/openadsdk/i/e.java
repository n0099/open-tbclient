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
/* loaded from: classes5.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f30089a;

    /* renamed from: c  reason: collision with root package name */
    public static d.b.c.b.f.a f30090c;

    /* renamed from: b  reason: collision with root package name */
    public Context f30091b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f30092d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.b.b.b f30093e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f30094f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f30095g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.b.b.d f30096h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.a.b f30097i;

    /* loaded from: classes5.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f30098a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30099b;

        /* renamed from: c  reason: collision with root package name */
        public final int f30100c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30101d;

        public a(ImageView imageView, String str, int i2, int i3) {
            this.f30098a = imageView;
            this.f30099b = str;
            this.f30100c = i2;
            this.f30101d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f30098a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f30099b)) ? false : true;
        }

        @Override // d.b.c.b.b.d.k
        public void a() {
            int i2;
            ImageView imageView = this.f30098a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f30098a.getContext()).isFinishing()) || this.f30098a == null || !c() || (i2 = this.f30100c) == 0) {
                return;
            }
            this.f30098a.setImageResource(i2);
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
            this.f30098a = null;
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f30098a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f30098a.getContext()).isFinishing()) || this.f30098a == null || this.f30101d == 0 || !c()) {
                return;
            }
            this.f30098a.setImageResource(this.f30101d);
        }

        @Override // d.b.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f30098a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f30098a.getContext()).isFinishing()) || this.f30098a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f30098a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f30091b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.b.c.b.f.a a() {
        return f30090c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f30089a == null) {
            synchronized (e.class) {
                if (f30089a == null) {
                    f30089a = new e(p.a());
                }
            }
        }
        return f30089a;
    }

    private void i() {
        if (this.f30097i == null) {
            this.f30097i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f30096h == null) {
            this.f30096h = new d.b.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f30092d == null) {
            synchronized (e.class) {
                if (this.f30092d == null) {
                    this.f30092d = d.b.c.b.a.b(this.f30091b);
                }
            }
        }
        return this.f30092d;
    }

    public n e() {
        if (this.f30095g == null) {
            synchronized (e.class) {
                if (this.f30095g == null) {
                    this.f30095g = d.b.c.b.a.b(this.f30091b);
                }
            }
        }
        return this.f30095g;
    }

    public n f() {
        if (this.f30094f == null) {
            synchronized (e.class) {
                if (this.f30094f == null) {
                    this.f30094f = d.b.c.b.a.b(this.f30091b);
                }
            }
        }
        return this.f30094f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.f30097i;
    }

    public d.b.c.b.b.d h() {
        j();
        return this.f30096h;
    }

    public static void a(d.b.c.b.f.a aVar) {
        f30090c = aVar;
    }

    public void a(String str, b.InterfaceC1767b interfaceC1767b) {
        if (this.f30093e == null) {
            this.f30093e = new d.b.c.b.b.b(this.f30091b, d());
        }
        this.f30093e.d(str, interfaceC1767b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f30096h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }
}
