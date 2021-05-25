package d.a.l0.a.o2.b;

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
import d.a.l0.a.a1.e;
import d.a.l0.a.j2.h;
import d.a.l0.a.k;
import d.a.l0.a.r1.i;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public View f43932a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f43933b;

    /* renamed from: c  reason: collision with root package name */
    public int f43934c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.h0.g.f f43935d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.l f43936e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f43937f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.m> f43938g;

    /* renamed from: h  reason: collision with root package name */
    public String f43939h;

    /* renamed from: i  reason: collision with root package name */
    public String f43940i;

    /* renamed from: d.a.l0.a.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0784a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43941e;

        public View$OnClickListenerC0784a(int i2) {
            this.f43941e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g(this.f43941e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f43943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f43944f;

        public b(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f43943e = swanAppBottomTabIconView;
            this.f43944f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43943e.setIconView(this.f43944f);
            if (a.this.f43939h == null) {
                this.f43943e.setTextColor(a.this.f43936e.f11289a);
            } else {
                this.f43943e.setTextColor(SwanAppConfigData.s(a.this.f43939h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f43946e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f43947f;

        public c(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f43946e = swanAppBottomTabIconView;
            this.f43947f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43946e.setIconView(this.f43947f);
            if (a.this.f43940i == null) {
                this.f43946e.setTextColor(a.this.f43936e.f11290b);
            } else {
                this.f43946e.setTextColor(SwanAppConfigData.s(a.this.f43940i));
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
            a.this.f43933b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f43950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43951f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            this.f43950e = swanAppBottomTabIconView;
            this.f43951f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43950e.setTextView(this.f43951f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f43952e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            this.f43952e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43952e.setRedDotVisibleState(false);
        }
    }

    public a(d.a.l0.a.h0.g.f fVar) {
        this.f43935d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        d.a.l0.a.f1.e.b n = n();
        if (n == null) {
            return false;
        }
        String l = d.a.l0.a.u1.a.a.l(n);
        if (TextUtils.isEmpty(l)) {
            l = e.C0561e.i(n.H(), n.u1()).getPath();
        }
        String str = l + File.separator + mVar.f11297b;
        if (d.a.l0.t.d.u(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            q0.b0(new b(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void B(String str) {
        this.f43939h = str;
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        d.a.l0.a.f1.e.b n = n();
        if (n == null) {
            return false;
        }
        String l = d.a.l0.a.u1.a.a.l(n);
        if (TextUtils.isEmpty(l)) {
            l = e.C0561e.i(n.H(), n.u1()).getPath();
        }
        String str = l + File.separator + mVar.f11298c;
        if (d.a.l0.t.d.u(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            q0.b0(new c(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void D(String str) {
        this.f43940i = str;
    }

    public void E(String str) {
        for (int i2 = 0; i2 < this.f43938g.size(); i2++) {
            if (this.f43938g.get(i2).f11296a.equals(str)) {
                u(i2);
                this.f43934c = i2;
                return;
            }
        }
    }

    public void f(View view, Context context, String str) {
        if (this.f43935d.Z1()) {
            SwanAppConfigData s = d.a.l0.a.g1.f.V().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.l lVar = s.f11250f;
            this.f43936e = lVar;
            List<SwanAppConfigData.m> list = lVar.f11293e;
            this.f43938g = list;
            int size = list.size();
            this.f43937f = new ArrayList<>(size);
            this.f43932a = view.findViewById(d.a.l0.a.f.bottom_bar_shadow);
            y(this.f43936e.f11291c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.l0.a.f.ai_apps_bottom_tab);
            this.f43933b = linearLayout;
            linearLayout.setVisibility(0);
            this.f43933b.setBackgroundColor(this.f43936e.f11292d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.m mVar = this.f43938g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(mVar.f11296a, !TextUtils.isEmpty(str) ? str : d.a.l0.a.g1.f.V().f()) && !z) {
                    C(swanAppBottomTabIconView, mVar);
                    this.f43934c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, mVar);
                }
                swanAppBottomTabIconView.setTextView(mVar.f11299d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0784a(i2));
                this.f43937f.add(swanAppBottomTabIconView);
                this.f43933b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i2) {
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        u(i2);
        v(i2);
        if (this.f43934c == i2) {
            return;
        }
        this.f43934c = i2;
        this.f43935d.A3();
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(this.f43938g.get(i2).f11296a, d.a.l0.a.g1.f.V().A());
        h.f(e2.f43357e, "5");
        this.f43935d.Y2(e2, uuid);
        d.a.l0.a.h0.g.f.H3("switchTab");
        this.f43935d.D3();
    }

    public boolean h(String str, String str2, String str3, String str4) {
        if (this.f43932a == null || this.f43933b == null) {
            return false;
        }
        y(SwanAppConfigData.s(str4));
        z(str3);
        B(str);
        D(str2);
        Iterator<SwanAppBottomTabIconView> it = this.f43937f.iterator();
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
            this.f43937f.get(i2).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean j(boolean z) {
        View view = this.f43932a;
        if (view == null || this.f43933b == null) {
            return false;
        }
        view.setVisibility(8);
        if (z) {
            l();
            return true;
        }
        this.f43933b.setVisibility(8);
        return true;
    }

    @AnyThread
    public boolean k(int i2) {
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (q(i2) && (swanAppBottomTabIconView = this.f43937f.get(i2)) != null) {
            q0.b0(new f(this, swanAppBottomTabIconView));
            return true;
        }
        return false;
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43933b, "translationY", 0.0f, d.a.l0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public LinearLayout m() {
        return this.f43933b;
    }

    public final d.a.l0.a.f1.e.b n() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 != null) {
            return i2.N();
        }
        return null;
    }

    public int o(String str) {
        List<SwanAppConfigData.m> list;
        if (!TextUtils.isEmpty(str) && (list = this.f43938g) != null && list.size() != 0) {
            for (int i2 = 0; i2 < this.f43938g.size(); i2++) {
                SwanAppConfigData.m mVar = this.f43938g.get(i2);
                if (mVar != null && TextUtils.equals(mVar.f11296a, str)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean p() {
        LinearLayout linearLayout = this.f43933b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean q(int i2) {
        ArrayList<SwanAppBottomTabIconView> arrayList = this.f43937f;
        return arrayList != null && i2 < arrayList.size() && i2 >= 0;
    }

    public boolean r(boolean z) {
        View view = this.f43932a;
        if (view == null || this.f43933b == null) {
            return false;
        }
        view.setVisibility(0);
        this.f43933b.setVisibility(0);
        t(z);
        return true;
    }

    public boolean s(int i2) {
        if (q(i2)) {
            this.f43937f.get(i2).setRedDotVisibleState(true);
            return true;
        }
        return false;
    }

    public final void t(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43933b, "translationY", d.a.l0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    public final void u(int i2) {
        A(this.f43937f.get(this.f43934c), this.f43938g.get(this.f43934c));
        C(this.f43937f.get(i2), this.f43938g.get(i2));
    }

    public final void v(int i2) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.m mVar = this.f43938g.get(i2);
        String j3 = this.f43935d.j3(d.a.l0.a.l1.b.e(mVar.f11296a, d.a.l0.a.g1.f.V().A()).f43357e);
        hashMap.put("index", String.valueOf(i2));
        hashMap.put("pagePath", mVar.f11296a);
        hashMap.put("text", mVar.f11299d);
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, j3);
        d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("onTabItemTap", hashMap));
    }

    public boolean w(int i2, String str) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f43937f.get(i2);
            swanAppBottomTabIconView.setBadgeVisibleState(true);
            swanAppBottomTabIconView.setBadgeText(str);
            return true;
        }
        return false;
    }

    public boolean x(int i2, String str, String str2, String str3) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f43937f.get(i2);
            q0.b0(new e(this, swanAppBottomTabIconView, str));
            if (!TextUtils.isEmpty(str2)) {
                this.f43938g.get(i2).f11297b = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f43938g.get(i2).f11298c = str3;
            }
            if (swanAppBottomTabIconView.a()) {
                return C(swanAppBottomTabIconView, this.f43938g.get(i2));
            }
            return A(swanAppBottomTabIconView, this.f43938g.get(i2));
        }
        return false;
    }

    public final void y(int i2) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i2) {
            this.f43932a.setVisibility(0);
            this.f43932a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.f43932a.setVisibility(0);
            this.f43932a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.l0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.f43932a.setVisibility(0);
            this.f43932a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        this.f43933b.setBackgroundColor(SwanAppConfigData.s(str));
    }
}
