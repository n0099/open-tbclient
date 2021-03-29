package d.b.g0.a.s0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.s0.d;
/* loaded from: classes2.dex */
public final class c implements d.b.g0.a.s0.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45855g = k.f45051a;

    /* renamed from: h  reason: collision with root package name */
    public static final int f45856h = h0.f(38.0f);

    /* renamed from: a  reason: collision with root package name */
    public String f45857a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f45858b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.e0.l.e f45859c;

    /* renamed from: d  reason: collision with root package name */
    public int f45860d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f45861e;

    /* renamed from: f  reason: collision with root package name */
    public f f45862f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45864f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45865g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45866h;

        public a(int i, int i2, int i3, int i4) {
            this.f45863e = i;
            this.f45864f = i2;
            this.f45865g = i3;
            this.f45866h = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.v0(this.f45863e, this.f45864f, this.f45865g, this.f45866h);
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

    /* renamed from: d.b.g0.a.s0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0789c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45868e;

        public RunnableC0789c(int i) {
            this.f45868e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.x0(this.f45868e);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ShowConfirmBarLayout.b {
        public d() {
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            c.this.t0("onConfirmBtnClick", null);
            if (c.this.f45862f != null) {
                c.this.f45862f.a();
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
            this.f45858b = (String) invoker.get("id");
        }
        this.f45857a = str;
        this.f45859c = m0();
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
        return this.f45857a;
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String c0() {
        return this.f45858b;
    }

    @Nullable
    public final d.b.g0.a.e0.l.e m0() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i = 0; i < k; i++) {
            d.b.g0.a.e0.l.c j = W.j(i);
            if (j instanceof d.b.g0.a.e0.l.e) {
                d.b.g0.a.e0.l.e eVar = (d.b.g0.a.e0.l.e) j;
                if (TextUtils.equals(eVar.X2(), this.f45857a)) {
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
        Activity n0 = n0();
        if (n0 == null) {
            return;
        }
        View decorView = n0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f45861e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f45861e);
        this.f45861e = null;
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
        k0.T(new RunnableC0789c(i));
    }

    public final void t0(String str, @Nullable String str2) {
        if (f45855g) {
            String str3 = (" <<" + c0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void u0() {
        d.b.g0.a.e0.l.e eVar = this.f45859c;
        if (eVar == null || this.f45860d == 0) {
            return;
        }
        this.f45860d = 0;
        if (eVar.b3().getScrollY() > 0) {
            this.f45859c.b3().setScrollY(0);
        }
    }

    public final void v0(int i, int i2, int i3, int i4) {
        if (this.f45859c == null) {
            return;
        }
        d.b.g0.a.p.d.c o = d.b.g0.a.z0.f.V().o();
        if (this.f45860d == i3 || o == null) {
            return;
        }
        this.f45860d = i3;
        int i5 = this.f45861e == null ? 0 : f45856h;
        int height = ((this.f45859c.b3().getHeight() - i) - i2) + o.getWebViewScrollY();
        if (height - i4 < i3) {
            if (i4 > height) {
                this.f45859c.b3().setScrollY(i3 + i5);
            } else {
                this.f45859c.b3().setScrollY((i3 - height) + i4 + i5);
            }
        }
    }

    public void w0(@NonNull f fVar) {
        this.f45862f = fVar;
    }

    public final void x0(int i) {
        Activity n0 = n0();
        if (n0 == null) {
            return;
        }
        View decorView = n0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f45861e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(n0);
            this.f45861e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d());
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i) - f45856h;
            frameLayout.addView(this.f45861e, layoutParams);
        }
    }
}
