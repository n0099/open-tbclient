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
    public static volatile e f29501a;

    /* renamed from: c  reason: collision with root package name */
    public static d.c.c.b.f.a f29502c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29503b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29504d;

    /* renamed from: e  reason: collision with root package name */
    public d.c.c.b.b.b f29505e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29506f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29507g;

    /* renamed from: h  reason: collision with root package name */
    public d.c.c.b.b.d f29508h;
    public com.bytedance.sdk.openadsdk.i.a.b i;

    /* loaded from: classes6.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29509a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29510b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29511c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29512d;

        public a(ImageView imageView, String str, int i, int i2) {
            this.f29509a = imageView;
            this.f29510b = str;
            this.f29511c = i;
            this.f29512d = i2;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29509a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29510b)) ? false : true;
        }

        @Override // d.c.c.b.b.d.k
        public void a() {
            int i;
            ImageView imageView = this.f29509a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29509a.getContext()).isFinishing()) || this.f29509a == null || !c() || (i = this.f29511c) == 0) {
                return;
            }
            this.f29509a.setImageResource(i);
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
            this.f29509a = null;
        }

        @Override // d.c.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29509a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29509a.getContext()).isFinishing()) || this.f29509a == null || this.f29512d == 0 || !c()) {
                return;
            }
            this.f29509a.setImageResource(this.f29512d);
        }

        @Override // d.c.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29509a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29509a.getContext()).isFinishing()) || this.f29509a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29509a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29503b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.c.c.b.f.a a() {
        return f29502c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29501a == null) {
            synchronized (e.class) {
                if (f29501a == null) {
                    f29501a = new e(p.a());
                }
            }
        }
        return f29501a;
    }

    private void i() {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29508h == null) {
            this.f29508h = new d.c.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29504d == null) {
            synchronized (e.class) {
                if (this.f29504d == null) {
                    this.f29504d = d.c.c.b.a.b(this.f29503b);
                }
            }
        }
        return this.f29504d;
    }

    public n e() {
        if (this.f29507g == null) {
            synchronized (e.class) {
                if (this.f29507g == null) {
                    this.f29507g = d.c.c.b.a.b(this.f29503b);
                }
            }
        }
        return this.f29507g;
    }

    public n f() {
        if (this.f29506f == null) {
            synchronized (e.class) {
                if (this.f29506f == null) {
                    this.f29506f = d.c.c.b.a.b(this.f29503b);
                }
            }
        }
        return this.f29506f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.i;
    }

    public d.c.c.b.b.d h() {
        j();
        return this.f29508h;
    }

    public static void a(d.c.c.b.f.a aVar) {
        f29502c = aVar;
    }

    public void a(String str, b.InterfaceC1796b interfaceC1796b) {
        if (this.f29505e == null) {
            this.f29505e = new d.c.c.b.b.b(this.f29503b, d());
        }
        this.f29505e.d(str, interfaceC1796b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29508h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }
}
