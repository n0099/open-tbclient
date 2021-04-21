package d.b.h0.a.d2.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.j1.j;
import d.b.h0.a.k;
import d.b.h0.a.u0.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public View f44558a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f44559b;

    /* renamed from: c  reason: collision with root package name */
    public int f44560c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.e0.l.e f44561d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.j f44562e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f44563f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<SwanAppConfigData.k> f44564g;

    /* renamed from: h  reason: collision with root package name */
    public String f44565h;
    public String i;

    /* renamed from: d.b.h0.a.d2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0676a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44566e;

        public View$OnClickListenerC0676a(int i) {
            this.f44566e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g(this.f44566e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f44568e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f44569f;

        public b(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f44568e = swanAppBottomTabIconView;
            this.f44569f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44568e.setIconView(this.f44569f);
            if (a.this.f44565h == null) {
                this.f44568e.setTextColor(a.this.f44562e.f12307a);
            } else {
                this.f44568e.setTextColor(SwanAppConfigData.s(a.this.f44565h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f44571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f44572f;

        public c(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f44571e = swanAppBottomTabIconView;
            this.f44572f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44571e.setIconView(this.f44572f);
            if (a.this.i == null) {
                this.f44571e.setTextColor(a.this.f44562e.f12308b);
            } else {
                this.f44571e.setTextColor(SwanAppConfigData.s(a.this.i));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f44559b.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f44575e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44576f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            this.f44575e = swanAppBottomTabIconView;
            this.f44576f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44575e.setTextView(this.f44576f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f44577e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            this.f44577e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44577e.setRedDotVisibleState(false);
        }
    }

    public a(d.b.h0.a.e0.l.e eVar) {
        this.f44561d = eVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        d.b.h0.a.y0.e.b n = n();
        if (n == null) {
            return false;
        }
        String j2 = d.b.h0.a.m1.a.a.j(n);
        if (TextUtils.isEmpty(j2)) {
            j2 = d.e.h(n.G(), n.n1()).getPath();
        }
        String str = j2 + File.separator + kVar.f12313b;
        if (d.b.h0.p.d.n(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            k0.X(new b(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void B(String str) {
        this.f44565h = str;
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        d.b.h0.a.y0.e.b n = n();
        if (n == null) {
            return false;
        }
        String j2 = d.b.h0.a.m1.a.a.j(n);
        if (TextUtils.isEmpty(j2)) {
            j2 = d.e.h(n.G(), n.n1()).getPath();
        }
        String str = j2 + File.separator + kVar.f12314c;
        if (d.b.h0.p.d.n(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            k0.X(new c(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void D(String str) {
        this.i = str;
    }

    public void E(String str) {
        for (int i = 0; i < this.f44564g.size(); i++) {
            if (this.f44564g.get(i).f12312a.equals(str)) {
                u(i);
                this.f44560c = i;
                return;
            }
        }
    }

    public void f(View view, Context context, String str) {
        if (this.f44561d.V1()) {
            SwanAppConfigData I = d.b.h0.a.z0.f.V().I();
            if (I == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.j jVar = I.f12286e;
            this.f44562e = jVar;
            ArrayList<SwanAppConfigData.k> arrayList = jVar.f12311e;
            this.f44564g = arrayList;
            int size = arrayList.size();
            this.f44563f = new ArrayList<>(size);
            this.f44558a = view.findViewById(d.b.h0.a.f.bottom_bar_shadow);
            SwanAppConfigData.j jVar2 = this.f44562e;
            y(jVar2.f12309c, jVar2.f12310d);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.b.h0.a.f.ai_apps_bottom_tab);
            this.f44559b = linearLayout;
            linearLayout.setVisibility(0);
            this.f44559b.setBackgroundColor(this.f44562e.f12310d);
            int m = h0.m(AppRuntime.getAppContext());
            boolean z = false;
            for (int i = 0; i < size; i++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.f44564g.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.f12312a, !TextUtils.isEmpty(str) ? str : d.b.h0.a.z0.f.V().l()) && !z) {
                    C(swanAppBottomTabIconView, kVar);
                    this.f44560c = i;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, kVar);
                }
                swanAppBottomTabIconView.setTextView(kVar.f12315d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0676a(i));
                this.f44563f.add(swanAppBottomTabIconView);
                this.f44559b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i) {
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        u(i);
        v(i);
        if (this.f44560c == i) {
            return;
        }
        this.f44560c = i;
        this.f44561d.p3();
        this.f44561d.Q2(d.b.h0.a.e1.b.c(this.f44564g.get(i).f12312a, d.b.h0.a.z0.f.V().h()), uuid);
        d.b.h0.a.e0.l.e.v3("switchTab");
        this.f44561d.s3();
    }

    public boolean h(String str, String str2, String str3, String str4) {
        if (this.f44558a == null || this.f44559b == null) {
            return false;
        }
        y(SwanAppConfigData.s(str4), SwanAppConfigData.s(str3));
        z(str3);
        B(str);
        D(str2);
        Iterator<SwanAppBottomTabIconView> it = this.f44563f.iterator();
        while (it.hasNext()) {
            SwanAppBottomTabIconView next = it.next();
            if (next.a()) {
                next.setTextColor(SwanAppConfigData.s(str2));
            } else {
                next.setTextColor(SwanAppConfigData.s(str));
            }
        }
        return true;
    }

    public boolean i(int i) {
        if (q(i)) {
            this.f44563f.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean j(boolean z) {
        View view = this.f44558a;
        if (view == null || this.f44559b == null) {
            return false;
        }
        view.setVisibility(8);
        if (z) {
            l();
            return true;
        }
        this.f44559b.setVisibility(8);
        return true;
    }

    @AnyThread
    public boolean k(int i) {
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (q(i) && (swanAppBottomTabIconView = this.f44563f.get(i)) != null) {
            k0.X(new f(this, swanAppBottomTabIconView));
            return true;
        }
        return false;
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f44559b, "translationY", 0.0f, d.b.h0.a.w0.a.c().getResources().getDimensionPixelSize(d.b.h0.a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public LinearLayout m() {
        return this.f44559b;
    }

    public final d.b.h0.a.y0.e.b n() {
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y != null) {
            return y.L();
        }
        return null;
    }

    public int o(String str) {
        ArrayList<SwanAppConfigData.k> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.f44564g) != null && arrayList.size() != 0) {
            for (int i = 0; i < this.f44564g.size(); i++) {
                SwanAppConfigData.k kVar = this.f44564g.get(i);
                if (kVar != null && TextUtils.equals(kVar.f12312a, str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean p() {
        LinearLayout linearLayout = this.f44559b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean q(int i) {
        ArrayList<SwanAppBottomTabIconView> arrayList = this.f44563f;
        return arrayList != null && i < arrayList.size() && i >= 0;
    }

    public boolean r(boolean z) {
        View view = this.f44558a;
        if (view == null || this.f44559b == null) {
            return false;
        }
        view.setVisibility(0);
        this.f44559b.setVisibility(0);
        t(z);
        return true;
    }

    public boolean s(int i) {
        if (q(i)) {
            this.f44563f.get(i).setRedDotVisibleState(true);
            return true;
        }
        return false;
    }

    public final void t(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f44559b, "translationY", d.b.h0.a.w0.a.c().getResources().getDimensionPixelSize(d.b.h0.a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    public final void u(int i) {
        A(this.f44563f.get(this.f44560c), this.f44564g.get(this.f44560c));
        C(this.f44563f.get(i), this.f44564g.get(i));
    }

    public final void v(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.f44564g.get(i);
        String a3 = this.f44561d.a3(d.b.h0.a.e1.b.c(kVar.f12312a, d.b.h0.a.z0.f.V().h()).f45083a);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.f12312a);
        hashMap.put("text", kVar.f12315d);
        hashMap.put("wvID", a3);
        d.b.h0.a.z0.f.V().N(new d.b.h0.a.k0.b.b("onTabItemTap", hashMap));
    }

    public boolean w(int i, String str) {
        if (q(i)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f44563f.get(i);
            swanAppBottomTabIconView.setBadgeVisibleState(true);
            swanAppBottomTabIconView.setBadgeText(str);
            return true;
        }
        return false;
    }

    public boolean x(int i, String str, String str2, String str3) {
        if (q(i)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f44563f.get(i);
            k0.X(new e(this, swanAppBottomTabIconView, str));
            if (!TextUtils.isEmpty(str2)) {
                this.f44564g.get(i).f12313b = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f44564g.get(i).f12314c = str3;
            }
            if (swanAppBottomTabIconView.a()) {
                return C(swanAppBottomTabIconView, this.f44564g.get(i));
            }
            return A(swanAppBottomTabIconView, this.f44564g.get(i));
        }
        return false;
    }

    public final void y(int i, int i2) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i) {
            this.f44558a.setVisibility(0);
            this.f44558a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.b.h0.a.c.aiapps_white));
        } else if (-16777216 == i) {
            this.f44558a.setVisibility(0);
            this.f44558a.setBackgroundColor(i2);
        } else {
            this.f44558a.setVisibility(0);
            this.f44558a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.b.h0.a.c.aiapps_white));
        }
    }

    public final void z(String str) {
        this.f44559b.setBackgroundColor(SwanAppConfigData.s(str));
    }
}
