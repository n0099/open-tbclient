package d.a.l0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import d.a.l0.a.y0.d;
import d.a.l0.a.y0.e.e.b;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.y0.d {
    public static final boolean j = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public Context f49459a;

    /* renamed from: b  reason: collision with root package name */
    public String f49460b;

    /* renamed from: c  reason: collision with root package name */
    public String f49461c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.h0.g.f f49462d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f49463e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.y0.e.e.b f49464f;

    /* renamed from: g  reason: collision with root package name */
    public f f49465g;

    /* renamed from: h  reason: collision with root package name */
    public int f49466h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f49467i = new e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49468e;

        public a(int i2) {
            this.f49468e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E0(this.f49468e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.w0();
        }
    }

    /* renamed from: d.a.l0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0964c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49472f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49473g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49474h;

        public RunnableC0964c(int i2, int i3, int i4, int i5) {
            this.f49471e = i2;
            this.f49472f = i3;
            this.f49473g = i4;
            this.f49474h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.C0(this.f49471e, this.f49472f, this.f49473g, this.f49474h);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.B0();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f49465g != null) {
                c.this.f49465g.a();
            }
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void b(int i2) {
            e("onKeyboardShow", "height: " + i2);
            if (c.this.f49465g != null) {
                c.this.f49465g.b(i2);
            }
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f49465g != null) {
                c.this.f49465g.c(str);
            }
        }

        @Override // d.a.l0.a.y0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f49465g != null) {
                c.this.f49465g.d();
            }
        }

        public final void e(String str, @Nullable String str2) {
            if (c.j) {
                String str3 = ("【" + c.this.k0() + "-" + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f49461c = (String) invoker.get("id");
        }
        this.f49459a = d.a.l0.a.c1.a.b();
        this.f49460b = str;
        this.f49463e = new Handler(this.f49459a.getMainLooper());
        this.f49462d = u0();
    }

    @Override // d.a.l0.a.y0.d
    public void A(@NonNull d.a aVar) {
        if (d.a.l0.a.a2.e.i() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    public void A0(int i2) {
        this.f49463e.post(new a(i2));
    }

    public final void B0() {
        d.a.l0.a.h0.g.f fVar = this.f49462d;
        if (fVar == null || this.f49466h == 0) {
            return;
        }
        this.f49466h = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f49462d.k3().setScrollY(0);
        }
    }

    public final void C0(int i2, int i3, int i4, int i5) {
        int i6;
        if (this.f49462d == null) {
            return;
        }
        d.a.l0.a.p.e.c h2 = d.a.l0.a.g1.f.V().h();
        if (this.f49466h == i4 || h2 == null) {
            return;
        }
        this.f49466h = i4;
        int height = ((this.f49462d.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.f49459a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f49462d.k3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f49462d.k3().setScrollY(i6);
    }

    public void D0(@NonNull f fVar) {
        this.f49465g = fVar;
    }

    public final void E0(int i2) {
        Activity v0 = v0();
        if (v0 == null) {
            return;
        }
        d.a.l0.a.y0.e.e.b bVar = new d.a.l0.a.y0.e.e.b(v0, i2, this.f49467i);
        this.f49464f = bVar;
        bVar.e();
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String b() {
        return this.f49460b;
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String k0() {
        return this.f49461c;
    }

    public void release() {
    }

    @Nullable
    public final d.a.l0.a.h0.g.f u0() {
        g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.l0.a.h0.g.d j2 = W.j(i2);
            if (j2 instanceof d.a.l0.a.h0.g.f) {
                d.a.l0.a.h0.g.f fVar = (d.a.l0.a.h0.g.f) j2;
                if (TextUtils.equals(fVar.g3(), this.f49460b)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity v0() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            return null;
        }
        return i2.k();
    }

    public final void w0() {
        d.a.l0.a.y0.e.e.b bVar = this.f49464f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f49464f = null;
    }

    public void x0() {
        this.f49463e.post(new b());
    }

    public void y0() {
        this.f49463e.post(new d());
    }

    public void z0(int i2, int i3, int i4, int i5) {
        this.f49463e.post(new RunnableC0964c(i2, i3, i4, i5));
    }
}
