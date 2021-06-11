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
    public static volatile e f29366a;

    /* renamed from: c  reason: collision with root package name */
    public static d.b.c.b.f.a f29367c;

    /* renamed from: b  reason: collision with root package name */
    public Context f29368b;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f29369d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.b.b.b f29370e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n f29371f;

    /* renamed from: g  reason: collision with root package name */
    public volatile n f29372g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.b.b.d f29373h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.a.b f29374i;

    /* loaded from: classes6.dex */
    public static class a implements d.k {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29375a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29376b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29377c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29378d;

        public a(ImageView imageView, String str, int i2, int i3) {
            this.f29375a = imageView;
            this.f29376b = str;
            this.f29377c = i2;
            this.f29378d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.f29375a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f29376b)) ? false : true;
        }

        @Override // d.b.c.b.b.d.k
        public void a() {
            int i2;
            ImageView imageView = this.f29375a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29375a.getContext()).isFinishing()) || this.f29375a == null || !c() || (i2 = this.f29377c) == 0) {
                return;
            }
            this.f29375a.setImageResource(i2);
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
            this.f29375a = null;
        }

        @Override // d.b.c.b.d.o.a
        public void b(o<Bitmap> oVar) {
            ImageView imageView = this.f29375a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29375a.getContext()).isFinishing()) || this.f29375a == null || this.f29378d == 0 || !c()) {
                return;
            }
            this.f29375a.setImageResource(this.f29378d);
        }

        @Override // d.b.c.b.b.d.k
        public void a(d.i iVar, boolean z) {
            ImageView imageView = this.f29375a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.f29375a.getContext()).isFinishing()) || this.f29375a == null || !c() || iVar.a() == null) {
                return;
            }
            this.f29375a.setImageBitmap(iVar.a());
        }
    }

    public e(Context context) {
        this.f29368b = context == null ? p.a() : context.getApplicationContext();
    }

    public static d.b.c.b.f.a a() {
        return f29367c;
    }

    public static g b() {
        return new g();
    }

    public static e c() {
        if (f29366a == null) {
            synchronized (e.class) {
                if (f29366a == null) {
                    f29366a = new e(p.a());
                }
            }
        }
        return f29366a;
    }

    private void i() {
        if (this.f29374i == null) {
            this.f29374i = new com.bytedance.sdk.openadsdk.i.a.b(d());
        }
    }

    private void j() {
        if (this.f29373h == null) {
            this.f29373h = new d.b.c.b.b.d(d(), com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    public n d() {
        if (this.f29369d == null) {
            synchronized (e.class) {
                if (this.f29369d == null) {
                    this.f29369d = d.b.c.b.a.b(this.f29368b);
                }
            }
        }
        return this.f29369d;
    }

    public n e() {
        if (this.f29372g == null) {
            synchronized (e.class) {
                if (this.f29372g == null) {
                    this.f29372g = d.b.c.b.a.b(this.f29368b);
                }
            }
        }
        return this.f29372g;
    }

    public n f() {
        if (this.f29371f == null) {
            synchronized (e.class) {
                if (this.f29371f == null) {
                    this.f29371f = d.b.c.b.a.b(this.f29368b);
                }
            }
        }
        return this.f29371f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b g() {
        i();
        return this.f29374i;
    }

    public d.b.c.b.b.d h() {
        j();
        return this.f29373h;
    }

    public static void a(d.b.c.b.f.a aVar) {
        f29367c = aVar;
    }

    public void a(String str, b.InterfaceC1894b interfaceC1894b) {
        if (this.f29370e == null) {
            this.f29370e = new d.b.c.b.b.b(this.f29368b, d());
        }
        this.f29370e.d(str, interfaceC1894b);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.k kVar) {
        j();
        this.f29373h.f(str, kVar);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }
}
