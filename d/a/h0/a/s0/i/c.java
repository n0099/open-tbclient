package d.a.h0.a.s0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.s0.d;
/* loaded from: classes2.dex */
public final class c implements d.a.h0.a.s0.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43943g = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public static final int f43944h = h0.f(38.0f);

    /* renamed from: a  reason: collision with root package name */
    public String f43945a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f43946b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.e0.l.e f43947c;

    /* renamed from: d  reason: collision with root package name */
    public int f43948d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f43949e;

    /* renamed from: f  reason: collision with root package name */
    public f f43950f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43951e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43952f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43953g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43954h;

        public a(int i2, int i3, int i4, int i5) {
            this.f43951e = i2;
            this.f43952f = i3;
            this.f43953g = i4;
            this.f43954h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.w0(this.f43951e, this.f43952f, this.f43953g, this.f43954h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.v0();
        }
    }

    /* renamed from: d.a.h0.a.s0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0760c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43957e;

        public RunnableC0760c(int i2) {
            this.f43957e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.y0(this.f43957e);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ShowConfirmBarLayout.b {
        public d() {
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            c.this.u0("onConfirmBtnClick", null);
            if (c.this.f43950f != null) {
                c.this.f43950f.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.p0();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f43946b = (String) invoker.get("id");
        }
        this.f43945a = str;
        this.f43947c = n0();
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
        return this.f43945a;
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String e0() {
        return this.f43946b;
    }

    @Nullable
    public final d.a.h0.a.e0.l.e n0() {
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.h0.a.e0.l.c j = W.j(i2);
            if (j instanceof d.a.h0.a.e0.l.e) {
                d.a.h0.a.e0.l.e eVar = (d.a.h0.a.e0.l.e) j;
                if (TextUtils.equals(eVar.W2(), this.f43945a)) {
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
        Activity o0 = o0();
        if (o0 == null) {
            return;
        }
        View decorView = o0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f43949e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f43949e);
        this.f43949e = null;
    }

    public void q0() {
        k0.T(new e());
    }

    public void r0() {
        k0.T(new b());
    }

    public void release() {
    }

    public void s0(int i2, int i3, int i4, int i5) {
        k0.T(new a(i2, i3, i4, i5));
    }

    public void t0(int i2) {
        k0.T(new RunnableC0760c(i2));
    }

    public final void u0(String str, @Nullable String str2) {
        if (f43943g) {
            String str3 = (" <<" + e0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void v0() {
        d.a.h0.a.e0.l.e eVar = this.f43947c;
        if (eVar == null || this.f43948d == 0) {
            return;
        }
        this.f43948d = 0;
        if (eVar.a3().getScrollY() > 0) {
            this.f43947c.a3().setScrollY(0);
        }
    }

    public final void w0(int i2, int i3, int i4, int i5) {
        if (this.f43947c == null) {
            return;
        }
        d.a.h0.a.p.d.c j = d.a.h0.a.z0.f.V().j();
        if (this.f43948d == i4 || j == null) {
            return;
        }
        this.f43948d = i4;
        int i6 = this.f43949e == null ? 0 : f43944h;
        int height = ((this.f43947c.a3().getHeight() - i2) - i3) + j.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f43947c.a3().setScrollY(i4 + i6);
            } else {
                this.f43947c.a3().setScrollY((i4 - height) + i5 + i6);
            }
        }
    }

    public void x0(@NonNull f fVar) {
        this.f43950f = fVar;
    }

    public final void y0(int i2) {
        Activity o0 = o0();
        if (o0 == null) {
            return;
        }
        View decorView = o0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f43949e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(o0);
            this.f43949e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d());
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f43944h;
            frameLayout.addView(this.f43949e, layoutParams);
        }
    }
}
