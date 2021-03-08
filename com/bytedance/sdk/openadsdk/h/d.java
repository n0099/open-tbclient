package com.bytedance.sdk.openadsdk.h;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.g;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f4798a;
    private static com.bytedance.sdk.adnet.e.a c;
    private Context b;
    private n d;
    private com.bytedance.sdk.adnet.b.b e;
    private n f;
    private n g;
    private com.bytedance.sdk.adnet.b.d h;
    private com.bytedance.sdk.openadsdk.h.a.b i;

    public static com.bytedance.sdk.adnet.e.a a() {
        return c;
    }

    public static void a(com.bytedance.sdk.adnet.e.a aVar) {
        c = aVar;
    }

    public static g b() {
        return new g();
    }

    public static d a(Context context) {
        if (f4798a == null) {
            synchronized (d.class) {
                if (f4798a == null) {
                    f4798a = new d(context);
                }
            }
        }
        return f4798a;
    }

    private d(Context context) {
        this.b = context == null ? p.a() : context.getApplicationContext();
    }

    public void a(String str, b.a aVar) {
        j();
        if (this.e == null) {
            this.e = new com.bytedance.sdk.adnet.b.b(this.b, this.d);
        }
        this.e.a(str, aVar);
    }

    public n c() {
        j();
        return this.d;
    }

    public n d() {
        k();
        return this.g;
    }

    public n e() {
        if (this.f == null) {
            this.f = com.bytedance.sdk.adnet.a.hW(this.b);
        }
        return this.f;
    }

    public com.bytedance.sdk.openadsdk.h.a.b f() {
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

    public void a(String str, ImageView imageView, d.InterfaceC1007d interfaceC1007d) {
        i();
        this.h.a(str, interfaceC1007d);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements d.InterfaceC1007d {

        /* renamed from: a  reason: collision with root package name */
        private ImageView f4799a;
        private final String b;
        private final int c;
        private final int d;

        a(ImageView imageView, String str, int i, int i2) {
            this.f4799a = imageView;
            this.b = str;
            this.c = i;
            this.d = i2;
            if (this.f4799a != null) {
                this.f4799a.setTag(1094453505, str);
            }
        }

        @Override // com.bytedance.sdk.adnet.core.o.a
        public void a(o<Bitmap> oVar) {
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1007d
        public void a() {
            if ((this.f4799a == null || !(this.f4799a.getContext() instanceof Activity) || !((Activity) this.f4799a.getContext()).isFinishing()) && this.f4799a != null && c() && this.c != 0) {
                this.f4799a.setImageResource(this.c);
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1007d
        public void a(d.c cVar, boolean z) {
            if ((this.f4799a == null || !(this.f4799a.getContext() instanceof Activity) || !((Activity) this.f4799a.getContext()).isFinishing()) && this.f4799a != null && c() && cVar.a() != null) {
                this.f4799a.setImageBitmap(cVar.a());
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1007d
        public void b() {
            this.f4799a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.o.a
        public void b(o<Bitmap> oVar) {
            if ((this.f4799a == null || !(this.f4799a.getContext() instanceof Activity) || !((Activity) this.f4799a.getContext()).isFinishing()) && this.f4799a != null && this.d != 0 && c()) {
                this.f4799a.setImageResource(this.d);
            }
        }

        private boolean c() {
            Object tag;
            return (this.f4799a == null || (tag = this.f4799a.getTag(1094453505)) == null || !tag.equals(this.b)) ? false : true;
        }
    }

    private void h() {
        if (this.i == null) {
            k();
            this.i = new com.bytedance.sdk.openadsdk.h.a.b(this.g);
        }
    }

    private void i() {
        if (this.h == null) {
            k();
            this.h = new com.bytedance.sdk.adnet.b.d(this.g, com.bytedance.sdk.openadsdk.h.a.a());
        }
    }

    private void j() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.adnet.a.hW(this.b);
        }
    }

    private void k() {
        if (this.g == null) {
            this.g = com.bytedance.sdk.adnet.a.hW(this.b);
        }
    }
}
