package d.a.l0.a.y0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.y0.d;
/* loaded from: classes3.dex */
public final class c implements d.a.l0.a.y0.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45845g = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static final int f45846h = n0.g(38.0f);

    /* renamed from: a  reason: collision with root package name */
    public String f45847a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f45848b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.h0.g.f f45849c;

    /* renamed from: d  reason: collision with root package name */
    public int f45850d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f45851e;

    /* renamed from: f  reason: collision with root package name */
    public f f45852f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45854f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45855g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45856h;

        public a(int i2, int i3, int i4, int i5) {
            this.f45853e = i2;
            this.f45854f = i3;
            this.f45855g = i4;
            this.f45856h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.G0(this.f45853e, this.f45854f, this.f45855g, this.f45856h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F0();
        }
    }

    /* renamed from: d.a.l0.a.y0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0916c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45859e;

        public RunnableC0916c(int i2) {
            this.f45859e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.I0(this.f45859e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ShowConfirmBarLayout.b {
        public d() {
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            c.this.E0("onConfirmBtnClick", null);
            if (c.this.f45852f != null) {
                c.this.f45852f.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.z0();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f45848b = (String) invoker.get("id");
        }
        this.f45847a = str;
        this.f45849c = x0();
    }

    public void A0() {
        q0.X(new e());
    }

    @Override // d.a.l0.a.y0.d
    public void B(@NonNull d.a aVar) {
        if (d.a.l0.a.a2.e.i() == null) {
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
        q0.X(new RunnableC0916c(i2));
    }

    public final void E0(String str, @Nullable String str2) {
        if (f45845g) {
            String str3 = (" <<" + n0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void F0() {
        d.a.l0.a.h0.g.f fVar = this.f45849c;
        if (fVar == null || this.f45850d == 0) {
            return;
        }
        this.f45850d = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f45849c.k3().setScrollY(0);
        }
    }

    public final void G0(int i2, int i3, int i4, int i5) {
        if (this.f45849c == null) {
            return;
        }
        d.a.l0.a.p.e.c h2 = d.a.l0.a.g1.f.V().h();
        if (this.f45850d == i4 || h2 == null) {
            return;
        }
        this.f45850d = i4;
        int i6 = this.f45851e == null ? 0 : f45846h;
        int height = ((this.f45849c.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f45849c.k3().setScrollY(i4 + i6);
            } else {
                this.f45849c.k3().setScrollY((i4 - height) + i5 + i6);
            }
        }
    }

    public void H0(@NonNull f fVar) {
        this.f45852f = fVar;
    }

    public final void I0(int i2) {
        Activity y0 = y0();
        if (y0 == null) {
            return;
        }
        View decorView = y0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f45851e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(y0);
            this.f45851e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d());
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f45846h;
            frameLayout.addView(this.f45851e, layoutParams);
        }
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String b() {
        return this.f45847a;
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String n0() {
        return this.f45848b;
    }

    public void release() {
    }

    @Nullable
    public final d.a.l0.a.h0.g.f x0() {
        g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            return null;
        }
        int k = W.k();
        for (int i2 = 0; i2 < k; i2++) {
            d.a.l0.a.h0.g.d j = W.j(i2);
            if (j instanceof d.a.l0.a.h0.g.f) {
                d.a.l0.a.h0.g.f fVar = (d.a.l0.a.h0.g.f) j;
                if (TextUtils.equals(fVar.g3(), this.f45847a)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity y0() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
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
        ShowConfirmBarLayout showConfirmBarLayout = this.f45851e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f45851e);
        this.f45851e = null;
    }
}
