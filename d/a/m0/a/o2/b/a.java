package d.a.m0.a.o2.b;

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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import d.a.m0.a.a1.e;
import d.a.m0.a.j2.h;
import d.a.m0.a.k;
import d.a.m0.a.r1.i;
import d.a.m0.a.v2.q0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public View f47716a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f47717b;

    /* renamed from: c  reason: collision with root package name */
    public int f47718c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.h0.g.f f47719d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.l f47720e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f47721f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.m> f47722g;

    /* renamed from: h  reason: collision with root package name */
    public String f47723h;

    /* renamed from: i  reason: collision with root package name */
    public String f47724i;

    /* renamed from: d.a.m0.a.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0843a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47725e;

        public View$OnClickListenerC0843a(int i2) {
            this.f47725e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g(this.f47725e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47728f;

        public b(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f47727e = swanAppBottomTabIconView;
            this.f47728f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47727e.setIconView(this.f47728f);
            if (a.this.f47723h == null) {
                this.f47727e.setTextColor(a.this.f47720e.f11433a);
            } else {
                this.f47727e.setTextColor(SwanAppConfigData.s(a.this.f47723h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47731f;

        public c(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f47730e = swanAppBottomTabIconView;
            this.f47731f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47730e.setIconView(this.f47731f);
            if (a.this.f47724i == null) {
                this.f47730e.setTextColor(a.this.f47720e.f11434b);
            } else {
                this.f47730e.setTextColor(SwanAppConfigData.s(a.this.f47724i));
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
            a.this.f47717b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f47734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47735f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            this.f47734e = swanAppBottomTabIconView;
            this.f47735f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47734e.setTextView(this.f47735f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47736e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            this.f47736e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47736e.setRedDotVisibleState(false);
        }
    }

    public a(d.a.m0.a.h0.g.f fVar) {
        this.f47719d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        d.a.m0.a.f1.e.b n = n();
        if (n == null) {
            return false;
        }
        String l = d.a.m0.a.u1.a.a.l(n);
        if (TextUtils.isEmpty(l)) {
            l = e.C0620e.i(n.H(), n.u1()).getPath();
        }
        String str = l + File.separator + mVar.f11441b;
        if (d.a.m0.t.d.u(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            q0.b0(new b(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void B(String str) {
        this.f47723h = str;
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        d.a.m0.a.f1.e.b n = n();
        if (n == null) {
            return false;
        }
        String l = d.a.m0.a.u1.a.a.l(n);
        if (TextUtils.isEmpty(l)) {
            l = e.C0620e.i(n.H(), n.u1()).getPath();
        }
        String str = l + File.separator + mVar.f11442c;
        if (d.a.m0.t.d.u(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            q0.b0(new c(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void D(String str) {
        this.f47724i = str;
    }

    public void E(String str) {
        for (int i2 = 0; i2 < this.f47722g.size(); i2++) {
            if (this.f47722g.get(i2).f11440a.equals(str)) {
                u(i2);
                this.f47718c = i2;
                return;
            }
        }
    }

    public void f(View view, Context context, String str) {
        if (this.f47719d.Z1()) {
            SwanAppConfigData s = d.a.m0.a.g1.f.V().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.l lVar = s.f11394f;
            this.f47720e = lVar;
            List<SwanAppConfigData.m> list = lVar.f11437e;
            this.f47722g = list;
            int size = list.size();
            this.f47721f = new ArrayList<>(size);
            this.f47716a = view.findViewById(d.a.m0.a.f.bottom_bar_shadow);
            y(this.f47720e.f11435c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.m0.a.f.ai_apps_bottom_tab);
            this.f47717b = linearLayout;
            linearLayout.setVisibility(0);
            this.f47717b.setBackgroundColor(this.f47720e.f11436d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.m mVar = this.f47722g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(mVar.f11440a, !TextUtils.isEmpty(str) ? str : d.a.m0.a.g1.f.V().f()) && !z) {
                    C(swanAppBottomTabIconView, mVar);
                    this.f47718c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, mVar);
                }
                swanAppBottomTabIconView.setTextView(mVar.f11443d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0843a(i2));
                this.f47721f.add(swanAppBottomTabIconView);
                this.f47717b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i2) {
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        u(i2);
        v(i2);
        if (this.f47718c == i2) {
            return;
        }
        this.f47718c = i2;
        this.f47719d.A3();
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(this.f47722g.get(i2).f11440a, d.a.m0.a.g1.f.V().A());
        h.f(e2.f47141e, "5");
        this.f47719d.Y2(e2, uuid);
        d.a.m0.a.h0.g.f.H3("switchTab");
        this.f47719d.D3();
    }

    public boolean h(String str, String str2, String str3, String str4) {
        if (this.f47716a == null || this.f47717b == null) {
            return false;
        }
        y(SwanAppConfigData.s(str4));
        z(str3);
        B(str);
        D(str2);
        Iterator<SwanAppBottomTabIconView> it = this.f47721f.iterator();
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

    public boolean i(int i2) {
        if (q(i2)) {
            this.f47721f.get(i2).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean j(boolean z) {
        View view = this.f47716a;
        if (view == null || this.f47717b == null) {
            return false;
        }
        view.setVisibility(8);
        if (z) {
            l();
            return true;
        }
        this.f47717b.setVisibility(8);
        return true;
    }

    @AnyThread
    public boolean k(int i2) {
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (q(i2) && (swanAppBottomTabIconView = this.f47721f.get(i2)) != null) {
            q0.b0(new f(this, swanAppBottomTabIconView));
            return true;
        }
        return false;
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47717b, "translationY", 0.0f, d.a.m0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public LinearLayout m() {
        return this.f47717b;
    }

    public final d.a.m0.a.f1.e.b n() {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 != null) {
            return i2.N();
        }
        return null;
    }

    public int o(String str) {
        List<SwanAppConfigData.m> list;
        if (!TextUtils.isEmpty(str) && (list = this.f47722g) != null && list.size() != 0) {
            for (int i2 = 0; i2 < this.f47722g.size(); i2++) {
                SwanAppConfigData.m mVar = this.f47722g.get(i2);
                if (mVar != null && TextUtils.equals(mVar.f11440a, str)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean p() {
        LinearLayout linearLayout = this.f47717b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean q(int i2) {
        ArrayList<SwanAppBottomTabIconView> arrayList = this.f47721f;
        return arrayList != null && i2 < arrayList.size() && i2 >= 0;
    }

    public boolean r(boolean z) {
        View view = this.f47716a;
        if (view == null || this.f47717b == null) {
            return false;
        }
        view.setVisibility(0);
        this.f47717b.setVisibility(0);
        t(z);
        return true;
    }

    public boolean s(int i2) {
        if (q(i2)) {
            this.f47721f.get(i2).setRedDotVisibleState(true);
            return true;
        }
        return false;
    }

    public final void t(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47717b, "translationY", d.a.m0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    public final void u(int i2) {
        A(this.f47721f.get(this.f47718c), this.f47722g.get(this.f47718c));
        C(this.f47721f.get(i2), this.f47722g.get(i2));
    }

    public final void v(int i2) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.m mVar = this.f47722g.get(i2);
        String j3 = this.f47719d.j3(d.a.m0.a.l1.b.e(mVar.f11440a, d.a.m0.a.g1.f.V().A()).f47141e);
        hashMap.put("index", String.valueOf(i2));
        hashMap.put("pagePath", mVar.f11440a);
        hashMap.put("text", mVar.f11443d);
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, j3);
        d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.b("onTabItemTap", hashMap));
    }

    public boolean w(int i2, String str) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f47721f.get(i2);
            swanAppBottomTabIconView.setBadgeVisibleState(true);
            swanAppBottomTabIconView.setBadgeText(str);
            return true;
        }
        return false;
    }

    public boolean x(int i2, String str, String str2, String str3) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f47721f.get(i2);
            q0.b0(new e(this, swanAppBottomTabIconView, str));
            if (!TextUtils.isEmpty(str2)) {
                this.f47722g.get(i2).f11441b = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f47722g.get(i2).f11442c = str3;
            }
            if (swanAppBottomTabIconView.a()) {
                return C(swanAppBottomTabIconView, this.f47722g.get(i2));
            }
            return A(swanAppBottomTabIconView, this.f47722g.get(i2));
        }
        return false;
    }

    public final void y(int i2) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i2) {
            this.f47716a.setVisibility(0);
            this.f47716a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.f47716a.setVisibility(0);
            this.f47716a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.m0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.f47716a.setVisibility(0);
            this.f47716a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        this.f47717b.setBackgroundColor(SwanAppConfigData.s(str));
    }
}
