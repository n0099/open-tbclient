package com.bytedance.sdk.openadsdk.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.g;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.q;
import com.bytedance.sdk.adnet.d.h;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes4.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f7512a;
    private static com.bytedance.sdk.adnet.e.a c;

    /* renamed from: b  reason: collision with root package name */
    private Context f7513b;
    private o d;
    private com.bytedance.sdk.adnet.b.b e;
    private o f;
    private o g;
    private com.bytedance.sdk.adnet.b.d h;
    private com.bytedance.sdk.openadsdk.i.a.b i;

    public static com.bytedance.sdk.adnet.e.a a() {
        return c;
    }

    public static void a(com.bytedance.sdk.adnet.e.a aVar) {
        c = aVar;
    }

    public static g b() {
        return new g();
    }

    public static e a(Context context) {
        if (f7512a == null) {
            synchronized (e.class) {
                if (f7512a == null) {
                    f7512a = new e(context);
                }
            }
        }
        return f7512a;
    }

    private e(Context context) {
        this.f7513b = context == null ? p.a() : context.getApplicationContext();
    }

    public void a(String str, b.a aVar) {
        j();
        if (this.e == null) {
            this.e = new com.bytedance.sdk.adnet.b.b(this.f7513b, this.d);
        }
        this.e.a(str, aVar);
    }

    public o c() {
        j();
        return this.d;
    }

    public o d() {
        k();
        return this.g;
    }

    public o e() {
        if (this.f == null) {
            this.f = com.bytedance.sdk.adnet.a.a(this.f7513b, l());
        }
        return this.f;
    }

    public com.bytedance.sdk.openadsdk.i.a.b f() {
        h();
        return this.i;
    }

    public com.bytedance.sdk.adnet.b.d g() {
        i();
        return this.h;
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.InterfaceC0972d interfaceC0972d) {
        i();
        this.h.a(str, interfaceC0972d);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements d.InterfaceC0972d {

        /* renamed from: a  reason: collision with root package name */
        private ImageView f7514a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7515b;
        private final int c;
        private final int d;

        a(ImageView imageView, String str, int i, int i2) {
            this.f7514a = imageView;
            this.f7515b = str;
            this.c = i;
            this.d = i2;
            if (this.f7514a != null) {
                this.f7514a.setTag(1094453505, str);
            }
        }

        @Override // com.bytedance.sdk.adnet.core.p.a
        public void a(com.bytedance.sdk.adnet.core.p<Bitmap> pVar) {
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0972d
        public void a() {
            if ((this.f7514a == null || !(this.f7514a.getContext() instanceof Activity) || !((Activity) this.f7514a.getContext()).isFinishing()) && this.f7514a != null && c() && this.c != 0) {
                this.f7514a.setImageResource(this.c);
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0972d
        public void a(d.c cVar, boolean z) {
            if ((this.f7514a == null || !(this.f7514a.getContext() instanceof Activity) || !((Activity) this.f7514a.getContext()).isFinishing()) && this.f7514a != null && c() && cVar.a() != null) {
                this.f7514a.setImageBitmap(cVar.a());
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0972d
        public void b() {
            this.f7514a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.p.a
        public void b(com.bytedance.sdk.adnet.core.p<Bitmap> pVar) {
            if ((this.f7514a == null || !(this.f7514a.getContext() instanceof Activity) || !((Activity) this.f7514a.getContext()).isFinishing()) && this.f7514a != null && this.d != 0 && c()) {
                this.f7514a.setImageResource(this.d);
            }
        }

        private boolean c() {
            Object tag;
            return (this.f7514a == null || (tag = this.f7514a.getTag(1094453505)) == null || !tag.equals(this.f7515b)) ? false : true;
        }
    }

    private void h() {
        if (this.i == null) {
            k();
            this.i = new com.bytedance.sdk.openadsdk.i.a.b(this.g);
        }
    }

    private void i() {
        if (this.h == null) {
            k();
            this.h = new com.bytedance.sdk.adnet.b.d(this.g, com.bytedance.sdk.openadsdk.i.a.a());
        }
    }

    private void j() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.adnet.a.a(this.f7513b, l());
        }
    }

    private void k() {
        if (this.g == null) {
            this.g = com.bytedance.sdk.adnet.a.a(this.f7513b, l());
        }
    }

    private com.bytedance.sdk.adnet.e.a l() {
        return a() != null ? a() : new m(new h(), h.f6355a, d.f7511a);
    }

    public void a(q qVar) {
        com.bytedance.sdk.adnet.a.a(qVar);
    }
}
