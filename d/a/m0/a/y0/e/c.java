package d.a.m0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import d.a.m0.a.y0.d;
import d.a.m0.a.y0.e.e.b;
/* loaded from: classes3.dex */
public class c implements d.a.m0.a.y0.d {
    public static final boolean j = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public Context f49567a;

    /* renamed from: b  reason: collision with root package name */
    public String f49568b;

    /* renamed from: c  reason: collision with root package name */
    public String f49569c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.h0.g.f f49570d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f49571e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.y0.e.e.b f49572f;

    /* renamed from: g  reason: collision with root package name */
    public f f49573g;

    /* renamed from: h  reason: collision with root package name */
    public int f49574h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f49575i = new e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49576e;

        public a(int i2) {
            this.f49576e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E0(this.f49576e);
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

    /* renamed from: d.a.m0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0967c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49579e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49580f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49581g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49582h;

        public RunnableC0967c(int i2, int i3, int i4, int i5) {
            this.f49579e = i2;
            this.f49580f = i3;
            this.f49581g = i4;
            this.f49582h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.C0(this.f49579e, this.f49580f, this.f49581g, this.f49582h);
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

        @Override // d.a.m0.a.y0.e.e.b.e
        public void a() {
            e("onKeyboardHide", null);
            if (c.this.f49573g != null) {
                c.this.f49573g.a();
            }
        }

        @Override // d.a.m0.a.y0.e.e.b.e
        public void b(int i2) {
            e("onKeyboardShow", "height: " + i2);
            if (c.this.f49573g != null) {
                c.this.f49573g.b(i2);
            }
        }

        @Override // d.a.m0.a.y0.e.e.b.e
        public void c(String str) {
            e("onInput", "inputText: " + str);
            if (c.this.f49573g != null) {
                c.this.f49573g.c(str);
            }
        }

        @Override // d.a.m0.a.y0.e.e.b.e
        public void d() {
            e("onDeletePressed", null);
            if (c.this.f49573g != null) {
                c.this.f49573g.d();
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
            this.f49569c = (String) invoker.get("id");
        }
        this.f49567a = d.a.m0.a.c1.a.b();
        this.f49568b = str;
        this.f49571e = new Handler(this.f49567a.getMainLooper());
        this.f49570d = u0();
    }

    @Override // d.a.m0.a.y0.d
    public void A(@NonNull d.a aVar) {
        if (d.a.m0.a.a2.e.i() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    public void A0(int i2) {
        this.f49571e.post(new a(i2));
    }

    public final void B0() {
        d.a.m0.a.h0.g.f fVar = this.f49570d;
        if (fVar == null || this.f49574h == 0) {
            return;
        }
        this.f49574h = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f49570d.k3().setScrollY(0);
        }
    }

    public final void C0(int i2, int i3, int i4, int i5) {
        int i6;
        if (this.f49570d == null) {
            return;
        }
        d.a.m0.a.p.e.c h2 = d.a.m0.a.g1.f.V().h();
        if (this.f49574h == i4 || h2 == null) {
            return;
        }
        this.f49574h = i4;
        int height = ((this.f49570d.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.f49567a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f49570d.k3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f49570d.k3().setScrollY(i6);
    }

    public void D0(@NonNull f fVar) {
        this.f49573g = fVar;
    }

    public final void E0(int i2) {
        Activity v0 = v0();
        if (v0 == null) {
            return;
        }
        d.a.m0.a.y0.e.e.b bVar = new d.a.m0.a.y0.e.e.b(v0, i2, this.f49575i);
        this.f49572f = bVar;
        bVar.e();
    }

    @Override // d.a.m0.a.y0.d
    @Nullable
    public String b() {
        return this.f49568b;
    }

    @Override // d.a.m0.a.y0.d
    @Nullable
    public String k0() {
        return this.f49569c;
    }

    public void release() {
    }

    @Nullable
    public final d.a.m0.a.h0.g.f u0() {
        g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.m0.a.h0.g.d j2 = W.j(i2);
            if (j2 instanceof d.a.m0.a.h0.g.f) {
                d.a.m0.a.h0.g.f fVar = (d.a.m0.a.h0.g.f) j2;
                if (TextUtils.equals(fVar.g3(), this.f49568b)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity v0() {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return null;
        }
        return i2.k();
    }

    public final void w0() {
        d.a.m0.a.y0.e.e.b bVar = this.f49572f;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.f49572f = null;
    }

    public void x0() {
        this.f49571e.post(new b());
    }

    public void y0() {
        this.f49571e.post(new d());
    }

    public void z0(int i2, int i3, int i4, int i5) {
        this.f49571e.post(new RunnableC0967c(i2, i3, i4, i5));
    }
}
