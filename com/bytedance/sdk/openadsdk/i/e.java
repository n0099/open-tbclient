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
    public static volatile e f29448a;

    /* renamed from: c  reason: collision with root package name */
    public static d.b.c.b.f.a f29449c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29450b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29451d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.b.b.b f29452e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29453f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29454g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.b.b.d f29455h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.a.b f29456i;

    /* loaded from: classes6.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29457a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29458b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29459c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29460d;

        public a(ImageView imageView, String str, int i2, int i3) {
            this.f29457a = imageView;
            this.f29458b = str;
            this.f29459c = i2;
            this.f29460d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29457a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29458b)) ? false : true;
        }

        @Override // d.b.c.b.b.d.k
        public void a() {
            int i2;
            ImageView imageView = this.f29457a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29457a.getContext()).isFinishing()) || this.f29457a == null || !c() || (i2 = this.f29459c) == 0) {
                return;
            }
            this.f29457a.setImageResource(i2);
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
            this.f29457a = null;
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29457a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29457a.getContext()).isFinishing()) || this.f29457a == null || this.f29460d == 0 || !c()) {
                return;
            }
            this.f29457a.setImageResource(this.f29460d);
        }

        @Override // d.b.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29457a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29457a.getContext()).isFinishing()) || this.f29457a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29457a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29450b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.b.c.b.f.a a() {
        return f29449c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29448a == null) {
            synchronized (e.class) {
                if (f29448a == null) {
                    f29448a = new e(p.a());
                }
            }
        }
        return f29448a;
    }

    private void i() {
        if (this.f29456i == null) {
            this.f29456i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29455h == null) {
            this.f29455h = new d.b.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29451d == null) {
            synchronized (e.class) {
                if (this.f29451d == null) {
                    this.f29451d = d.b.c.b.a.b(this.f29450b);
                }
            }
        }
        return this.f29451d;
    }

    public n e() {
        if (this.f29454g == null) {
            synchronized (e.class) {
                if (this.f29454g == null) {
                    this.f29454g = d.b.c.b.a.b(this.f29450b);
                }
            }
        }
        return this.f29454g;
    }

    public n f() {
        if (this.f29453f == null) {
            synchronized (e.class) {
                if (this.f29453f == null) {
                    this.f29453f = d.b.c.b.a.b(this.f29450b);
                }
            }
        }
        return this.f29453f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.f29456i;
    }

    public d.b.c.b.b.d h() {
        j();
        return this.f29455h;
    }

    public static void a(d.b.c.b.f.a aVar) {
        f29449c = aVar;
    }

    public void a(String str, b.InterfaceC1897b interfaceC1897b) {
        if (this.f29452e == null) {
            this.f29452e = new d.b.c.b.b.b(this.f29450b, d());
        }
        this.f29452e.d(str, interfaceC1897b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29455h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }
}
