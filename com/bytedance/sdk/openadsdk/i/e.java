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
    public static volatile e f29186a;

    /* renamed from: c  reason: collision with root package name */
    public static d.c.c.b.f.a f29187c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29188b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29189d;

    /* renamed from: e  reason: collision with root package name */
    public d.c.c.b.b.b f29190e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29191f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29192g;

    /* renamed from: h  reason: collision with root package name */
    public d.c.c.b.b.d f29193h;
    public com.bytedance.sdk.openadsdk.i.a.b i;

    /* loaded from: classes5.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29194a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29195b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29196c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29197d;

        public a(ImageView imageView, String str, int i, int i2) {
            this.f29194a = imageView;
            this.f29195b = str;
            this.f29196c = i;
            this.f29197d = i2;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29194a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29195b)) ? false : true;
        }

        @Override // d.c.c.b.b.d.k
        public void a() {
            int i;
            ImageView imageView = this.f29194a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29194a.getContext()).isFinishing()) || this.f29194a == null || !c() || (i = this.f29196c) == 0) {
                return;
            }
            this.f29194a.setImageResource(i);
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
            this.f29194a = null;
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29194a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29194a.getContext()).isFinishing()) || this.f29194a == null || this.f29197d == 0 || !c()) {
                return;
            }
            this.f29194a.setImageResource(this.f29197d);
        }

        @Override // d.c.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29194a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29194a.getContext()).isFinishing()) || this.f29194a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29194a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29188b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.c.c.b.f.a a() {
        return f29187c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29186a == null) {
            synchronized (e.class) {
                if (f29186a == null) {
                    f29186a = new e(p.a());
                }
            }
        }
        return f29186a;
    }

    private void i() {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29193h == null) {
            this.f29193h = new d.c.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29189d == null) {
            synchronized (e.class) {
                if (this.f29189d == null) {
                    this.f29189d = d.c.c.b.a.b(this.f29188b);
                }
            }
        }
        return this.f29189d;
    }

    public n e() {
        if (this.f29192g == null) {
            synchronized (e.class) {
                if (this.f29192g == null) {
                    this.f29192g = d.c.c.b.a.b(this.f29188b);
                }
            }
        }
        return this.f29192g;
    }

    public n f() {
        if (this.f29191f == null) {
            synchronized (e.class) {
                if (this.f29191f == null) {
                    this.f29191f = d.c.c.b.a.b(this.f29188b);
                }
            }
        }
        return this.f29191f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.i;
    }

    public d.c.c.b.b.d h() {
        j();
        return this.f29193h;
    }

    public static void a(d.c.c.b.f.a aVar) {
        f29187c = aVar;
    }

    public void a(String str, b.InterfaceC1824b interfaceC1824b) {
        if (this.f29190e == null) {
            this.f29190e = new d.c.c.b.b.b(this.f29188b, d());
        }
        this.f29190e.d(str, interfaceC1824b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29193h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }
}
