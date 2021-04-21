package d.b.h0.a.s0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.s0.d;
/* loaded from: classes2.dex */
public final class c implements d.b.h0.a.s0.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46576g = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public static final int f46577h = h0.f(38.0f);

    /* renamed from: a  reason: collision with root package name */
    public String f46578a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f46579b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.e0.l.e f46580c;

    /* renamed from: d  reason: collision with root package name */
    public int f46581d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f46582e;

    /* renamed from: f  reason: collision with root package name */
    public f f46583f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46584e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46585f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46586g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46587h;

        public a(int i, int i2, int i3, int i4) {
            this.f46584e = i;
            this.f46585f = i2;
            this.f46586g = i3;
            this.f46587h = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.v0(this.f46584e, this.f46585f, this.f46586g, this.f46587h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u0();
        }
    }

    /* renamed from: d.b.h0.a.s0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0821c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46589e;

        public RunnableC0821c(int i) {
            this.f46589e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.x0(this.f46589e);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ShowConfirmBarLayout.b {
        public d() {
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            c.this.t0("onConfirmBtnClick", null);
            if (c.this.f46583f != null) {
                c.this.f46583f.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.o0();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f46579b = (String) invoker.get("id");
        }
        this.f46578a = str;
        this.f46580c = m0();
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
        return this.f46578a;
    }

    @Override // d.b.h0.a.s0.d
    @Nullable
    public String c0() {
        return this.f46579b;
    }

    @Nullable
    public final d.b.h0.a.e0.l.e m0() {
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i = 0; i < k; i++) {
            d.b.h0.a.e0.l.c j = W.j(i);
            if (j instanceof d.b.h0.a.e0.l.e) {
                d.b.h0.a.e0.l.e eVar = (d.b.h0.a.e0.l.e) j;
                if (TextUtils.equals(eVar.X2(), this.f46578a)) {
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
        Activity n0 = n0();
        if (n0 == null) {
            return;
        }
        View decorView = n0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f46582e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f46582e);
        this.f46582e = null;
    }

    public void p0() {
        k0.T(new e());
    }

    public void q0() {
        k0.T(new b());
    }

    public void r0(int i, int i2, int i3, int i4) {
        k0.T(new a(i, i2, i3, i4));
    }

    public void release() {
    }

    public void s0(int i) {
        k0.T(new RunnableC0821c(i));
    }

    public final void t0(String str, @Nullable String str2) {
        if (f46576g) {
            String str3 = (" <<" + c0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void u0() {
        d.b.h0.a.e0.l.e eVar = this.f46580c;
        if (eVar == null || this.f46581d == 0) {
            return;
        }
        this.f46581d = 0;
        if (eVar.b3().getScrollY() > 0) {
            this.f46580c.b3().setScrollY(0);
        }
    }

    public final void v0(int i, int i2, int i3, int i4) {
        if (this.f46580c == null) {
            return;
        }
        d.b.h0.a.p.d.c o = d.b.h0.a.z0.f.V().o();
        if (this.f46581d == i3 || o == null) {
            return;
        }
        this.f46581d = i3;
        int i5 = this.f46582e == null ? 0 : f46577h;
        int height = ((this.f46580c.b3().getHeight() - i) - i2) + o.getWebViewScrollY();
        if (height - i4 < i3) {
            if (i4 > height) {
                this.f46580c.b3().setScrollY(i3 + i5);
            } else {
                this.f46580c.b3().setScrollY((i3 - height) + i4 + i5);
            }
        }
    }

    public void w0(@NonNull f fVar) {
        this.f46583f = fVar;
    }

    public final void x0(int i) {
        Activity n0 = n0();
        if (n0 == null) {
            return;
        }
        View decorView = n0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f46582e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(n0);
            this.f46582e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d());
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i) - f46577h;
            frameLayout.addView(this.f46582e, layoutParams);
        }
    }
}
