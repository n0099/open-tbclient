package d.a.h0.a.s0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
import d.a.h0.a.s0.d;
import d.a.h0.a.s0.e.e.b;
/* loaded from: classes2.dex */
public class c implements d.a.h0.a.s0.d {
    public static final boolean j = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Context f43883a;

    /* renamed from: b  reason: collision with root package name */
    public String f43884b;

    /* renamed from: c  reason: collision with root package name */
    public String f43885c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.e0.l.e f43886d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f43887e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.a.s0.e.e.b f43888f;

    /* renamed from: g  reason: collision with root package name */
    public f f43889g;

    /* renamed from: h  reason: collision with root package name */
    public int f43890h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f43891i = new e();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43892e;

        public a(int i2) {
            this.f43892e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.x0(this.f43892e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.p0();
        }
    }

    /* renamed from: d.a.h0.a.s0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0752c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43896f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43897g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43898h;

        public RunnableC0752c(int i2, int i3, int i4, int i5) {
            this.f43895e = i2;
            this.f43896f = i3;
            this.f43897g = i4;
            this.f43898h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.v0(this.f43895e, this.f43896f, this.f43897g, this.f43898h);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u0();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.a.h0.a.s0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f43889g != null) {
                c.this.f43889g.a();
            }
        }

        @Override // d.a.h0.a.s0.e.e.b.e
        public void b(int i2) {
            e("onKeyboardShow", "height: " + i2);
            if (c.this.f43889g != null) {
                c.this.f43889g.b(i2);
            }
        }

        @Override // d.a.h0.a.s0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f43889g != null) {
                c.this.f43889g.c(str);
            }
        }

        @Override // d.a.h0.a.s0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f43889g != null) {
                c.this.f43889g.d();
            }
        }

        public final void e(String str, @Nullable String str2) {
            if (c.j) {
                String str3 = ("【" + c.this.e0() + "-" + c.this.hashCode() + "】\t") + "【" + str + "】";
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

        void b(int i2);

        void c(String str);

        void d();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f43885c = (String) invoker.get("id");
        }
        this.f43883a = d.a.h0.a.w0.a.c();
        this.f43884b = str;
        this.f43887e = new Handler(this.f43883a.getMainLooper());
        this.f43886d = n0();
    }

    @Override // d.a.h0.a.s0.d
    public void A(@NonNull d.a aVar) {
        if (d.a.h0.a.r1.e.h() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String a() {
        return this.f43884b;
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String e0() {
        return this.f43885c;
    }

    @Nullable
    public final d.a.h0.a.e0.l.e n0() {
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.h0.a.e0.l.c j2 = W.j(i2);
            if (j2 instanceof d.a.h0.a.e0.l.e) {
                d.a.h0.a.e0.l.e eVar = (d.a.h0.a.e0.l.e) j2;
                if (TextUtils.equals(eVar.W2(), this.f43884b)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity o0() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            return null;
        }
        return h2.A();
    }

    public final void p0() {
        d.a.h0.a.s0.e.e.b bVar = this.f43888f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f43888f = null;
    }

    public void q0() {
        this.f43887e.post(new b());
    }

    public void r0() {
        this.f43887e.post(new d());
    }

    public void release() {
    }

    public void s0(int i2, int i3, int i4, int i5) {
        this.f43887e.post(new RunnableC0752c(i2, i3, i4, i5));
    }

    public void t0(int i2) {
        this.f43887e.post(new a(i2));
    }

    public final void u0() {
        d.a.h0.a.e0.l.e eVar = this.f43886d;
        if (eVar == null || this.f43890h == 0) {
            return;
        }
        this.f43890h = 0;
        if (eVar.a3().getScrollY() > 0) {
            this.f43886d.a3().setScrollY(0);
        }
    }

    public final void v0(int i2, int i3, int i4, int i5) {
        int i6;
        if (this.f43886d == null) {
            return;
        }
        d.a.h0.a.p.d.c j2 = d.a.h0.a.z0.f.V().j();
        if (this.f43890h == i4 || j2 == null) {
            return;
        }
        this.f43890h = i4;
        int height = ((this.f43886d.a3().getHeight() - i2) - i3) + j2.getWebViewScrollY() + h0.i(this.f43883a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f43886d.a3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f43886d.a3().setScrollY(i6);
    }

    public void w0(@NonNull f fVar) {
        this.f43889g = fVar;
    }

    public final void x0(int i2) {
        Activity o0 = o0();
        if (o0 == null) {
            return;
        }
        d.a.h0.a.s0.e.e.b bVar = new d.a.h0.a.s0.e.e.b(o0, i2, this.f43891i);
        this.f43888f = bVar;
        bVar.e();
    }
}
