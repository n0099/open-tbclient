package d.a.m0.a.y0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.y0.d;
/* loaded from: classes3.dex */
public final class c implements d.a.m0.a.y0.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49627g = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static final int f49628h = n0.g(38.0f);

    /* renamed from: a  reason: collision with root package name */
    public String f49629a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f49630b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.h0.g.f f49631c;

    /* renamed from: d  reason: collision with root package name */
    public int f49632d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f49633e;

    /* renamed from: f  reason: collision with root package name */
    public f f49634f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49636f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49637g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49638h;

        public a(int i2, int i3, int i4, int i5) {
            this.f49635e = i2;
            this.f49636f = i3;
            this.f49637g = i4;
            this.f49638h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.D0(this.f49635e, this.f49636f, this.f49637g, this.f49638h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.C0();
        }
    }

    /* renamed from: d.a.m0.a.y0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0975c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49641e;

        public RunnableC0975c(int i2) {
            this.f49641e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F0(this.f49641e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ShowConfirmBarLayout.b {
        public d() {
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            c.this.B0("onConfirmBtnClick", null);
            if (c.this.f49634f != null) {
                c.this.f49634f.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.w0();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        if (invoker != null) {
            this.f49630b = (String) invoker.get("id");
        }
        this.f49629a = str;
        this.f49631c = u0();
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
        q0.X(new RunnableC0975c(i2));
    }

    public final void B0(String str, @Nullable String str2) {
        if (f49627g) {
            String str3 = (" <<" + k0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void C0() {
        d.a.m0.a.h0.g.f fVar = this.f49631c;
        if (fVar == null || this.f49632d == 0) {
            return;
        }
        this.f49632d = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f49631c.k3().setScrollY(0);
        }
    }

    public final void D0(int i2, int i3, int i4, int i5) {
        if (this.f49631c == null) {
            return;
        }
        d.a.m0.a.p.e.c h2 = d.a.m0.a.g1.f.V().h();
        if (this.f49632d == i4 || h2 == null) {
            return;
        }
        this.f49632d = i4;
        int i6 = this.f49633e == null ? 0 : f49628h;
        int height = ((this.f49631c.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f49631c.k3().setScrollY(i4 + i6);
            } else {
                this.f49631c.k3().setScrollY((i4 - height) + i5 + i6);
            }
        }
    }

    public void E0(@NonNull f fVar) {
        this.f49634f = fVar;
    }

    public final void F0(int i2) {
        Activity v0 = v0();
        if (v0 == null) {
            return;
        }
        View decorView = v0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f49633e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(v0);
            this.f49633e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d());
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f49628h;
            frameLayout.addView(this.f49633e, layoutParams);
        }
    }

    @Override // d.a.m0.a.y0.d
    @Nullable
    public String b() {
        return this.f49629a;
    }

    @Override // d.a.m0.a.y0.d
    @Nullable
    public String k0() {
        return this.f49630b;
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
            d.a.m0.a.h0.g.d j = W.j(i2);
            if (j instanceof d.a.m0.a.h0.g.f) {
                d.a.m0.a.h0.g.f fVar = (d.a.m0.a.h0.g.f) j;
                if (TextUtils.equals(fVar.g3(), this.f49629a)) {
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
        Activity v0 = v0();
        if (v0 == null) {
            return;
        }
        View decorView = v0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f49633e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f49633e);
        this.f49633e = null;
    }

    public void x0() {
        q0.X(new e());
    }

    public void y0() {
        q0.X(new b());
    }

    public void z0(int i2, int i3, int i4, int i5) {
        q0.X(new a(i2, i3, i4, i5));
    }
}
