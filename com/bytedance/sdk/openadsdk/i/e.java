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
    public static volatile e f29334a;

    /* renamed from: c  reason: collision with root package name */
    public static d.b.c.b.f.a f29335c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29336b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29337d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.b.b.b f29338e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29339f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29340g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.b.b.d f29341h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.a.b f29342i;

    /* loaded from: classes6.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29343a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29344b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29345c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29346d;

        public a(ImageView imageView, String str, int i2, int i3) {
            this.f29343a = imageView;
            this.f29344b = str;
            this.f29345c = i2;
            this.f29346d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29343a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29344b)) ? false : true;
        }

        @Override // d.b.c.b.b.d.k
        public void a() {
            int i2;
            ImageView imageView = this.f29343a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29343a.getContext()).isFinishing()) || this.f29343a == null || !c() || (i2 = this.f29345c) == 0) {
                return;
            }
            this.f29343a.setImageResource(i2);
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
            this.f29343a = null;
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29343a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29343a.getContext()).isFinishing()) || this.f29343a == null || this.f29346d == 0 || !c()) {
                return;
            }
            this.f29343a.setImageResource(this.f29346d);
        }

        @Override // d.b.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29343a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29343a.getContext()).isFinishing()) || this.f29343a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29343a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29336b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.b.c.b.f.a a() {
        return f29335c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29334a == null) {
            synchronized (e.class) {
                if (f29334a == null) {
                    f29334a = new e(p.a());
                }
            }
        }
        return f29334a;
    }

    private void i() {
        if (this.f29342i == null) {
            this.f29342i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29341h == null) {
            this.f29341h = new d.b.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29337d == null) {
            synchronized (e.class) {
                if (this.f29337d == null) {
                    this.f29337d = d.b.c.b.a.b(this.f29336b);
                }
            }
        }
        return this.f29337d;
    }

    public n e() {
        if (this.f29340g == null) {
            synchronized (e.class) {
                if (this.f29340g == null) {
                    this.f29340g = d.b.c.b.a.b(this.f29336b);
                }
            }
        }
        return this.f29340g;
    }

    public n f() {
        if (this.f29339f == null) {
            synchronized (e.class) {
                if (this.f29339f == null) {
                    this.f29339f = d.b.c.b.a.b(this.f29336b);
                }
            }
        }
        return this.f29339f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.f29342i;
    }

    public d.b.c.b.b.d h() {
        j();
        return this.f29341h;
    }

    public static void a(d.b.c.b.f.a aVar) {
        f29335c = aVar;
    }

    public void a(String str, b.InterfaceC1831b interfaceC1831b) {
        if (this.f29338e == null) {
            this.f29338e = new d.b.c.b.b.b(this.f29336b, d());
        }
        this.f29338e.d(str, interfaceC1831b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29341h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }
}
