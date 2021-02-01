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
/* loaded from: classes6.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f7215a;
    private static com.bytedance.sdk.adnet.e.a c;

    /* renamed from: b  reason: collision with root package name */
    private Context f7216b;
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
        if (f7215a == null) {
            synchronized (e.class) {
                if (f7215a == null) {
                    f7215a = new e(context);
                }
            }
        }
        return f7215a;
    }

    private e(Context context) {
        this.f7216b = context == null ? p.a() : context.getApplicationContext();
    }

    public void a(String str, b.a aVar) {
        j();
        if (this.e == null) {
            this.e = new com.bytedance.sdk.adnet.b.b(this.f7216b, this.d);
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
            this.f = com.bytedance.sdk.adnet.a.a(this.f7216b, l());
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

    public void a(String str, ImageView imageView, d.InterfaceC0997d interfaceC0997d) {
        i();
        this.h.a(str, interfaceC0997d);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements d.InterfaceC0997d {

        /* renamed from: a  reason: collision with root package name */
        private ImageView f7217a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7218b;
        private final int c;
        private final int d;

        a(ImageView imageView, String str, int i, int i2) {
            this.f7217a = imageView;
            this.f7218b = str;
            this.c = i;
            this.d = i2;
            if (this.f7217a != null) {
                this.f7217a.setTag(1094453505, str);
            }
        }

        @Override // com.bytedance.sdk.adnet.core.p.a
        public void a(com.bytedance.sdk.adnet.core.p<Bitmap> pVar) {
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0997d
        public void a() {
            if ((this.f7217a == null || !(this.f7217a.getContext() instanceof Activity) || !((Activity) this.f7217a.getContext()).isFinishing()) && this.f7217a != null && c() && this.c != 0) {
                this.f7217a.setImageResource(this.c);
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0997d
        public void a(d.c cVar, boolean z) {
            if ((this.f7217a == null || !(this.f7217a.getContext() instanceof Activity) || !((Activity) this.f7217a.getContext()).isFinishing()) && this.f7217a != null && c() && cVar.a() != null) {
                this.f7217a.setImageBitmap(cVar.a());
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0997d
        public void b() {
            this.f7217a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.p.a
        public void b(com.bytedance.sdk.adnet.core.p<Bitmap> pVar) {
            if ((this.f7217a == null || !(this.f7217a.getContext() instanceof Activity) || !((Activity) this.f7217a.getContext()).isFinishing()) && this.f7217a != null && this.d != 0 && c()) {
                this.f7217a.setImageResource(this.d);
            }
        }

        private boolean c() {
            Object tag;
            return (this.f7217a == null || (tag = this.f7217a.getTag(1094453505)) == null || !tag.equals(this.f7218b)) ? false : true;
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
            this.d = com.bytedance.sdk.adnet.a.a(this.f7216b, l());
        }
    }

    private void k() {
        if (this.g == null) {
            this.g = com.bytedance.sdk.adnet.a.a(this.f7216b, l());
        }
    }

    private com.bytedance.sdk.adnet.e.a l() {
        return a() != null ? a() : new m(new h(), h.f6058a, d.f7214a);
    }

    public void a(q qVar) {
        com.bytedance.sdk.adnet.a.a(qVar);
    }
}
