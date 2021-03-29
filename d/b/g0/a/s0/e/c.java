package d.b.g0.a.s0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import d.b.g0.a.s0.d;
import d.b.g0.a.s0.e.e.b;
/* loaded from: classes2.dex */
public class c implements d.b.g0.a.s0.d {
    public static final boolean j = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45797a;

    /* renamed from: b  reason: collision with root package name */
    public String f45798b;

    /* renamed from: c  reason: collision with root package name */
    public String f45799c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.e0.l.e f45800d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f45801e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.s0.e.e.b f45802f;

    /* renamed from: g  reason: collision with root package name */
    public f f45803g;

    /* renamed from: h  reason: collision with root package name */
    public int f45804h;
    public b.e i = new e();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45805e;

        public a(int i) {
            this.f45805e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.w0(this.f45805e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.o0();
        }
    }

    /* renamed from: d.b.g0.a.s0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0781c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45810g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45811h;

        public RunnableC0781c(int i, int i2, int i3, int i4) {
            this.f45808e = i;
            this.f45809f = i2;
            this.f45810g = i3;
            this.f45811h = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u0(this.f45808e, this.f45809f, this.f45810g, this.f45811h);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.t0();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.b.g0.a.s0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f45803g != null) {
                c.this.f45803g.a();
            }
        }

        @Override // d.b.g0.a.s0.e.e.b.e
        public void b(int i) {
            e("onKeyboardShow", "height: " + i);
            if (c.this.f45803g != null) {
                c.this.f45803g.b(i);
            }
        }

        @Override // d.b.g0.a.s0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f45803g != null) {
                c.this.f45803g.c(str);
            }
        }

        @Override // d.b.g0.a.s0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f45803g != null) {
                c.this.f45803g.d();
            }
        }

        public final void e(String str, @Nullable String str2) {
            if (c.j) {
                String str3 = ("【" + c.this.c0() + "-" + c.this.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f45799c = (String) invoker.get("id");
        }
        this.f45797a = d.b.g0.a.w0.a.c();
        this.f45798b = str;
        this.f45801e = new Handler(this.f45797a.getMainLooper());
        this.f45800d = m0();
    }

    @Override // d.b.g0.a.s0.d
    public void T(@NonNull d.a aVar) {
        if (d.b.g0.a.r1.e.y() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String b() {
        return this.f45798b;
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String c0() {
        return this.f45799c;
    }

    @Nullable
    public final d.b.g0.a.e0.l.e m0() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i = 0; i < k; i++) {
            d.b.g0.a.e0.l.c j2 = W.j(i);
            if (j2 instanceof d.b.g0.a.e0.l.e) {
                d.b.g0.a.e0.l.e eVar = (d.b.g0.a.e0.l.e) j2;
                if (TextUtils.equals(eVar.X2(), this.f45798b)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity n0() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            return null;
        }
        return y.A();
    }

    public final void o0() {
        d.b.g0.a.s0.e.e.b bVar = this.f45802f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f45802f = null;
    }

    public void p0() {
        this.f45801e.post(new b());
    }

    public void q0() {
        this.f45801e.post(new d());
    }

    public void r0(int i, int i2, int i3, int i4) {
        this.f45801e.post(new RunnableC0781c(i, i2, i3, i4));
    }

    public void release() {
    }

    public void s0(int i) {
        this.f45801e.post(new a(i));
    }

    public final void t0() {
        d.b.g0.a.e0.l.e eVar = this.f45800d;
        if (eVar == null || this.f45804h == 0) {
            return;
        }
        this.f45804h = 0;
        if (eVar.b3().getScrollY() > 0) {
            this.f45800d.b3().setScrollY(0);
        }
    }

    public final void u0(int i, int i2, int i3, int i4) {
        int i5;
        if (this.f45800d == null) {
            return;
        }
        d.b.g0.a.p.d.c o = d.b.g0.a.z0.f.V().o();
        if (this.f45804h == i3 || o == null) {
            return;
        }
        this.f45804h = i3;
        int height = ((this.f45800d.b3().getHeight() - i) - i2) + o.getWebViewScrollY() + h0.i(this.f45797a);
        if (i4 > height) {
            i4 = height;
        }
        int i6 = height - i3;
        int scrollY = this.f45800d.b3().getScrollY();
        if (i6 < 0) {
            i5 = i4 - i6;
        } else {
            if (i4 > i6) {
                scrollY = i4 - i6;
            }
            i5 = scrollY;
        }
        this.f45800d.b3().setScrollY(i5);
    }

    public void v0(@NonNull f fVar) {
        this.f45803g = fVar;
    }

    public final void w0(int i) {
        Activity n0 = n0();
        if (n0 == null) {
            return;
        }
        d.b.g0.a.s0.e.e.b bVar = new d.b.g0.a.s0.e.e.b(n0, i, this.i);
        this.f45802f = bVar;
        bVar.e();
    }
}
