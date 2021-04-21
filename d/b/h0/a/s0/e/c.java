package d.b.h0.a.s0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import d.b.h0.a.s0.d;
import d.b.h0.a.s0.e.e.b;
/* loaded from: classes2.dex */
public class c implements d.b.h0.a.s0.d {
    public static final boolean j = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Context f46518a;

    /* renamed from: b  reason: collision with root package name */
    public String f46519b;

    /* renamed from: c  reason: collision with root package name */
    public String f46520c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.e0.l.e f46521d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f46522e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.a.s0.e.e.b f46523f;

    /* renamed from: g  reason: collision with root package name */
    public f f46524g;

    /* renamed from: h  reason: collision with root package name */
    public int f46525h;
    public b.e i = new e();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46526e;

        public a(int i) {
            this.f46526e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.w0(this.f46526e);
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

    /* renamed from: d.b.h0.a.s0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0813c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46530f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46531g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46532h;

        public RunnableC0813c(int i, int i2, int i3, int i4) {
            this.f46529e = i;
            this.f46530f = i2;
            this.f46531g = i3;
            this.f46532h = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u0(this.f46529e, this.f46530f, this.f46531g, this.f46532h);
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

        @Override // d.b.h0.a.s0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f46524g != null) {
                c.this.f46524g.a();
            }
        }

        @Override // d.b.h0.a.s0.e.e.b.e
        public void b(int i) {
            e("onKeyboardShow", "height: " + i);
            if (c.this.f46524g != null) {
                c.this.f46524g.b(i);
            }
        }

        @Override // d.b.h0.a.s0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f46524g != null) {
                c.this.f46524g.c(str);
            }
        }

        @Override // d.b.h0.a.s0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f46524g != null) {
                c.this.f46524g.d();
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
            this.f46520c = (String) invoker.get("id");
        }
        this.f46518a = d.b.h0.a.w0.a.c();
        this.f46519b = str;
        this.f46522e = new Handler(this.f46518a.getMainLooper());
        this.f46521d = m0();
    }

    @Override // d.b.h0.a.s0.d
    public void T(@NonNull d.a aVar) {
        if (d.b.h0.a.r1.e.y() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    @Override // d.b.h0.a.s0.d
    @Nullable
    public String b() {
        return this.f46519b;
    }

    @Override // d.b.h0.a.s0.d
    @Nullable
    public String c0() {
        return this.f46520c;
    }

    @Nullable
    public final d.b.h0.a.e0.l.e m0() {
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i = 0; i < k; i++) {
            d.b.h0.a.e0.l.c j2 = W.j(i);
            if (j2 instanceof d.b.h0.a.e0.l.e) {
                d.b.h0.a.e0.l.e eVar = (d.b.h0.a.e0.l.e) j2;
                if (TextUtils.equals(eVar.X2(), this.f46519b)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity n0() {
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            return null;
        }
        return y.A();
    }

    public final void o0() {
        d.b.h0.a.s0.e.e.b bVar = this.f46523f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f46523f = null;
    }

    public void p0() {
        this.f46522e.post(new b());
    }

    public void q0() {
        this.f46522e.post(new d());
    }

    public void r0(int i, int i2, int i3, int i4) {
        this.f46522e.post(new RunnableC0813c(i, i2, i3, i4));
    }

    public void release() {
    }

    public void s0(int i) {
        this.f46522e.post(new a(i));
    }

    public final void t0() {
        d.b.h0.a.e0.l.e eVar = this.f46521d;
        if (eVar == null || this.f46525h == 0) {
            return;
        }
        this.f46525h = 0;
        if (eVar.b3().getScrollY() > 0) {
            this.f46521d.b3().setScrollY(0);
        }
    }

    public final void u0(int i, int i2, int i3, int i4) {
        int i5;
        if (this.f46521d == null) {
            return;
        }
        d.b.h0.a.p.d.c o = d.b.h0.a.z0.f.V().o();
        if (this.f46525h == i3 || o == null) {
            return;
        }
        this.f46525h = i3;
        int height = ((this.f46521d.b3().getHeight() - i) - i2) + o.getWebViewScrollY() + h0.i(this.f46518a);
        if (i4 > height) {
            i4 = height;
        }
        int i6 = height - i3;
        int scrollY = this.f46521d.b3().getScrollY();
        if (i6 < 0) {
            i5 = i4 - i6;
        } else {
            if (i4 > i6) {
                scrollY = i4 - i6;
            }
            i5 = scrollY;
        }
        this.f46521d.b3().setScrollY(i5);
    }

    public void v0(@NonNull f fVar) {
        this.f46524g = fVar;
    }

    public final void w0(int i) {
        Activity n0 = n0();
        if (n0 == null) {
            return;
        }
        d.b.h0.a.s0.e.e.b bVar = new d.b.h0.a.s0.e.e.b(n0, i, this.i);
        this.f46523f = bVar;
        bVar.e();
    }
}
