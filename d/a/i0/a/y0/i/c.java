package d.a.i0.a.y0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import d.a.i0.a.y0.d;
/* loaded from: classes.dex */
public final class c implements d.a.i0.a.y0.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45669g = k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public static final int f45670h = n0.g(38.0f);

    /* renamed from: a  reason: collision with root package name */
    public String f45671a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f45672b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.h0.g.f f45673c;

    /* renamed from: d  reason: collision with root package name */
    public int f45674d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f45675e;

    /* renamed from: f  reason: collision with root package name */
    public f f45676f;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45678f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45679g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45680h;

        public a(int i2, int i3, int i4, int i5) {
            this.f45677e = i2;
            this.f45678f = i3;
            this.f45679g = i4;
            this.f45680h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.G0(this.f45677e, this.f45678f, this.f45679g, this.f45680h);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F0();
        }
    }

    /* renamed from: d.a.i0.a.y0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0905c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45683e;

        public RunnableC0905c(int i2) {
            this.f45683e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.I0(this.f45683e);
        }
    }

    /* loaded from: classes.dex */
    public class d implements ShowConfirmBarLayout.b {
        public d() {
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            c.this.E0("onConfirmBtnClick", null);
            if (c.this.f45676f != null) {
                c.this.f45676f.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.z0();
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f45672b = (String) invoker.get("id");
        }
        this.f45671a = str;
        this.f45673c = x0();
    }

    public void A0() {
        q0.X(new e());
    }

    @Override // d.a.i0.a.y0.d
    public void B(@NonNull d.a aVar) {
        if (d.a.i0.a.a2.e.i() == null) {
            aVar.a(false);
        } else {
            aVar.a(true);
        }
    }

    public void B0() {
        q0.X(new b());
    }

    public void C0(int i2, int i3, int i4, int i5) {
        q0.X(new a(i2, i3, i4, i5));
    }

    public void D0(int i2) {
        q0.X(new RunnableC0905c(i2));
    }

    public final void E0(String str, @Nullable String str2) {
        if (f45669g) {
            String str3 = (" <<" + n0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void F0() {
        d.a.i0.a.h0.g.f fVar = this.f45673c;
        if (fVar == null || this.f45674d == 0) {
            return;
        }
        this.f45674d = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f45673c.k3().setScrollY(0);
        }
    }

    public final void G0(int i2, int i3, int i4, int i5) {
        if (this.f45673c == null) {
            return;
        }
        d.a.i0.a.p.e.c h2 = d.a.i0.a.g1.f.V().h();
        if (this.f45674d == i4 || h2 == null) {
            return;
        }
        this.f45674d = i4;
        int i6 = this.f45675e == null ? 0 : f45670h;
        int height = ((this.f45673c.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f45673c.k3().setScrollY(i4 + i6);
            } else {
                this.f45673c.k3().setScrollY((i4 - height) + i5 + i6);
            }
        }
    }

    public void H0(@NonNull f fVar) {
        this.f45676f = fVar;
    }

    public final void I0(int i2) {
        Activity y0 = y0();
        if (y0 == null) {
            return;
        }
        View decorView = y0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f45675e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(y0);
            this.f45675e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d());
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f45670h;
            frameLayout.addView(this.f45675e, layoutParams);
        }
    }

    @Override // d.a.i0.a.y0.d
    @Nullable
    public String b() {
        return this.f45671a;
    }

    @Override // d.a.i0.a.y0.d
    @Nullable
    public String n0() {
        return this.f45672b;
    }

    public void release() {
    }

    @Nullable
    public final d.a.i0.a.h0.g.f x0() {
        g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.i0.a.h0.g.d j = W.j(i2);
            if (j instanceof d.a.i0.a.h0.g.f) {
                d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) j;
                if (TextUtils.equals(fVar.g3(), this.f45671a)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity y0() {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null) {
            return null;
        }
        return i2.k();
    }

    public final void z0() {
        Activity y0 = y0();
        if (y0 == null) {
            return;
        }
        View decorView = y0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f45675e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f45675e);
        this.f45675e = null;
    }
}
