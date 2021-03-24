package d.b.g0.a.d2.b;

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
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.j;
import d.b.g0.a.k;
import d.b.g0.a.u0.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public View f43836a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f43837b;

    /* renamed from: c  reason: collision with root package name */
    public int f43838c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.e0.l.e f43839d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.j f43840e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f43841f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<SwanAppConfigData.k> f43842g;

    /* renamed from: h  reason: collision with root package name */
    public String f43843h;
    public String i;

    /* renamed from: d.b.g0.a.d2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0643a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43844e;

        public View$OnClickListenerC0643a(int i) {
            this.f43844e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g(this.f43844e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f43846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f43847f;

        public b(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f43846e = swanAppBottomTabIconView;
            this.f43847f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43846e.setIconView(this.f43847f);
            if (a.this.f43843h == null) {
                this.f43846e.setTextColor(a.this.f43840e.f12637a);
            } else {
                this.f43846e.setTextColor(SwanAppConfigData.s(a.this.f43843h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f43849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f43850f;

        public c(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f43849e = swanAppBottomTabIconView;
            this.f43850f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43849e.setIconView(this.f43850f);
            if (a.this.i == null) {
                this.f43849e.setTextColor(a.this.f43840e.f12638b);
            } else {
                this.f43849e.setTextColor(SwanAppConfigData.s(a.this.i));
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
            a.this.f43837b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f43853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43854f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            this.f43853e = swanAppBottomTabIconView;
            this.f43854f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43853e.setTextView(this.f43854f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f43855e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            this.f43855e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43855e.setRedDotVisibleState(false);
        }
    }

    public a(d.b.g0.a.e0.l.e eVar) {
        this.f43839d = eVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        d.b.g0.a.y0.e.b n = n();
        if (n == null) {
            return false;
        }
        String j2 = d.b.g0.a.m1.a.a.j(n);
        if (TextUtils.isEmpty(j2)) {
            j2 = d.e.h(n.G(), n.n1()).getPath();
        }
        String str = j2 + File.separator + kVar.f12643b;
        if (d.b.g0.p.d.n(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            k0.X(new b(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void B(String str) {
        this.f43843h = str;
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        d.b.g0.a.y0.e.b n = n();
        if (n == null) {
            return false;
        }
        String j2 = d.b.g0.a.m1.a.a.j(n);
        if (TextUtils.isEmpty(j2)) {
            j2 = d.e.h(n.G(), n.n1()).getPath();
        }
        String str = j2 + File.separator + kVar.f12644c;
        if (d.b.g0.p.d.n(str)) {
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
        for (int i = 0; i < this.f43842g.size(); i++) {
            if (this.f43842g.get(i).f12642a.equals(str)) {
                u(i);
                this.f43838c = i;
                return;
            }
        }
    }

    public void f(View view, Context context, String str) {
        if (this.f43839d.V1()) {
            SwanAppConfigData I = d.b.g0.a.z0.f.V().I();
            if (I == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.j jVar = I.f12616e;
            this.f43840e = jVar;
            ArrayList<SwanAppConfigData.k> arrayList = jVar.f12641e;
            this.f43842g = arrayList;
            int size = arrayList.size();
            this.f43841f = new ArrayList<>(size);
            this.f43836a = view.findViewById(d.b.g0.a.f.bottom_bar_shadow);
            SwanAppConfigData.j jVar2 = this.f43840e;
            y(jVar2.f12639c, jVar2.f12640d);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.b.g0.a.f.ai_apps_bottom_tab);
            this.f43837b = linearLayout;
            linearLayout.setVisibility(0);
            this.f43837b.setBackgroundColor(this.f43840e.f12640d);
            int m = h0.m(AppRuntime.getAppContext());
            boolean z = false;
            for (int i = 0; i < size; i++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.f43842g.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.f12642a, !TextUtils.isEmpty(str) ? str : d.b.g0.a.z0.f.V().l()) && !z) {
                    C(swanAppBottomTabIconView, kVar);
                    this.f43838c = i;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, kVar);
                }
                swanAppBottomTabIconView.setTextView(kVar.f12645d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0643a(i));
                this.f43841f.add(swanAppBottomTabIconView);
                this.f43837b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i) {
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        u(i);
        v(i);
        if (this.f43838c == i) {
            return;
        }
        this.f43838c = i;
        this.f43839d.p3();
        this.f43839d.Q2(d.b.g0.a.e1.b.c(this.f43842g.get(i).f12642a, d.b.g0.a.z0.f.V().h()), uuid);
        d.b.g0.a.e0.l.e.v3("switchTab");
        this.f43839d.s3();
    }

    public boolean h(String str, String str2, String str3, String str4) {
        if (this.f43836a == null || this.f43837b == null) {
            return false;
        }
        y(SwanAppConfigData.s(str4), SwanAppConfigData.s(str3));
        z(str3);
        B(str);
        D(str2);
        Iterator<SwanAppBottomTabIconView> it = this.f43841f.iterator();
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
            this.f43841f.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean j(boolean z) {
        View view = this.f43836a;
        if (view == null || this.f43837b == null) {
            return false;
        }
        view.setVisibility(8);
        if (z) {
            l();
            return true;
        }
        this.f43837b.setVisibility(8);
        return true;
    }

    @AnyThread
    public boolean k(int i) {
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (q(i) && (swanAppBottomTabIconView = this.f43841f.get(i)) != null) {
            k0.X(new f(this, swanAppBottomTabIconView));
            return true;
        }
        return false;
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43837b, "translationY", 0.0f, d.b.g0.a.w0.a.c().getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public LinearLayout m() {
        return this.f43837b;
    }

    public final d.b.g0.a.y0.e.b n() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y != null) {
            return y.L();
        }
        return null;
    }

    public int o(String str) {
        ArrayList<SwanAppConfigData.k> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.f43842g) != null && arrayList.size() != 0) {
            for (int i = 0; i < this.f43842g.size(); i++) {
                SwanAppConfigData.k kVar = this.f43842g.get(i);
                if (kVar != null && TextUtils.equals(kVar.f12642a, str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean p() {
        LinearLayout linearLayout = this.f43837b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean q(int i) {
        ArrayList<SwanAppBottomTabIconView> arrayList = this.f43841f;
        return arrayList != null && i < arrayList.size() && i >= 0;
    }

    public boolean r(boolean z) {
        View view = this.f43836a;
        if (view == null || this.f43837b == null) {
            return false;
        }
        view.setVisibility(0);
        this.f43837b.setVisibility(0);
        t(z);
        return true;
    }

    public boolean s(int i) {
        if (q(i)) {
            this.f43841f.get(i).setRedDotVisibleState(true);
            return true;
        }
        return false;
    }

    public final void t(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43837b, "translationY", d.b.g0.a.w0.a.c().getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    public final void u(int i) {
        A(this.f43841f.get(this.f43838c), this.f43842g.get(this.f43838c));
        C(this.f43841f.get(i), this.f43842g.get(i));
    }

    public final void v(int i) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.f43842g.get(i);
        String a3 = this.f43839d.a3(d.b.g0.a.e1.b.c(kVar.f12642a, d.b.g0.a.z0.f.V().h()).f44361a);
        hashMap.put("index", String.valueOf(i));
        hashMap.put("pagePath", kVar.f12642a);
        hashMap.put("text", kVar.f12645d);
        hashMap.put("wvID", a3);
        d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b("onTabItemTap", hashMap));
    }

    public boolean w(int i, String str) {
        if (q(i)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f43841f.get(i);
            swanAppBottomTabIconView.setBadgeVisibleState(true);
            swanAppBottomTabIconView.setBadgeText(str);
            return true;
        }
        return false;
    }

    public boolean x(int i, String str, String str2, String str3) {
        if (q(i)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f43841f.get(i);
            k0.X(new e(this, swanAppBottomTabIconView, str));
            if (!TextUtils.isEmpty(str2)) {
                this.f43842g.get(i).f12643b = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f43842g.get(i).f12644c = str3;
            }
            if (swanAppBottomTabIconView.a()) {
                return C(swanAppBottomTabIconView, this.f43842g.get(i));
            }
            return A(swanAppBottomTabIconView, this.f43842g.get(i));
        }
        return false;
    }

    public final void y(int i, int i2) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i) {
            this.f43836a.setVisibility(0);
            this.f43836a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.b.g0.a.c.aiapps_white));
        } else if (-16777216 == i) {
            this.f43836a.setVisibility(0);
            this.f43836a.setBackgroundColor(i2);
        } else {
            this.f43836a.setVisibility(0);
            this.f43836a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.b.g0.a.c.aiapps_white));
        }
    }

    public final void z(String str) {
        this.f43837b.setBackgroundColor(SwanAppConfigData.s(str));
    }
}
