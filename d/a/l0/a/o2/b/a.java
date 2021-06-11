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
    public static final boolean j = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public View f47608a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f47609b;

    /* renamed from: c  reason: collision with root package name */
    public int f47610c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.h0.g.f f47611d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.l f47612e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f47613f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.m> f47614g;

    /* renamed from: h  reason: collision with root package name */
    public String f47615h;

    /* renamed from: i  reason: collision with root package name */
    public String f47616i;

    /* renamed from: d.a.l0.a.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0840a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47617e;

        public View$OnClickListenerC0840a(int i2) {
            this.f47617e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g(this.f47617e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47620f;

        public b(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f47619e = swanAppBottomTabIconView;
            this.f47620f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47619e.setIconView(this.f47620f);
            if (a.this.f47615h == null) {
                this.f47619e.setTextColor(a.this.f47612e.f11351a);
            } else {
                this.f47619e.setTextColor(SwanAppConfigData.s(a.this.f47615h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47623f;

        public c(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f47622e = swanAppBottomTabIconView;
            this.f47623f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47622e.setIconView(this.f47623f);
            if (a.this.f47616i == null) {
                this.f47622e.setTextColor(a.this.f47612e.f11352b);
            } else {
                this.f47622e.setTextColor(SwanAppConfigData.s(a.this.f47616i));
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
            a.this.f47609b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f47626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47627f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            this.f47626e = swanAppBottomTabIconView;
            this.f47627f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47626e.setTextView(this.f47627f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47628e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            this.f47628e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47628e.setRedDotVisibleState(false);
        }
    }

    public a(d.a.l0.a.h0.g.f fVar) {
        this.f47611d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        d.a.l0.a.f1.e.b n = n();
        if (n == null) {
            return false;
        }
        String l = d.a.l0.a.u1.a.a.l(n);
        if (TextUtils.isEmpty(l)) {
            l = e.C0617e.i(n.H(), n.u1()).getPath();
        }
        String str = l + File.separator + mVar.f11359b;
        if (d.a.l0.t.d.u(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            q0.b0(new b(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void B(String str) {
        this.f47615h = str;
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        d.a.l0.a.f1.e.b n = n();
        if (n == null) {
            return false;
        }
        String l = d.a.l0.a.u1.a.a.l(n);
        if (TextUtils.isEmpty(l)) {
            l = e.C0617e.i(n.H(), n.u1()).getPath();
        }
        String str = l + File.separator + mVar.f11360c;
        if (d.a.l0.t.d.u(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            q0.b0(new c(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void D(String str) {
        this.f47616i = str;
    }

    public void E(String str) {
        for (int i2 = 0; i2 < this.f47614g.size(); i2++) {
            if (this.f47614g.get(i2).f11358a.equals(str)) {
                u(i2);
                this.f47610c = i2;
                return;
            }
        }
    }

    public void f(View view, Context context, String str) {
        if (this.f47611d.Z1()) {
            SwanAppConfigData s = d.a.l0.a.g1.f.V().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.l lVar = s.f11312f;
            this.f47612e = lVar;
            List<SwanAppConfigData.m> list = lVar.f11355e;
            this.f47614g = list;
            int size = list.size();
            this.f47613f = new ArrayList<>(size);
            this.f47608a = view.findViewById(d.a.l0.a.f.bottom_bar_shadow);
            y(this.f47612e.f11353c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.l0.a.f.ai_apps_bottom_tab);
            this.f47609b = linearLayout;
            linearLayout.setVisibility(0);
            this.f47609b.setBackgroundColor(this.f47612e.f11354d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.m mVar = this.f47614g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(mVar.f11358a, !TextUtils.isEmpty(str) ? str : d.a.l0.a.g1.f.V().f()) && !z) {
                    C(swanAppBottomTabIconView, mVar);
                    this.f47610c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, mVar);
                }
                swanAppBottomTabIconView.setTextView(mVar.f11361d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0840a(i2));
                this.f47613f.add(swanAppBottomTabIconView);
                this.f47609b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i2) {
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        u(i2);
        v(i2);
        if (this.f47610c == i2) {
            return;
        }
        this.f47610c = i2;
        this.f47611d.A3();
        d.a.l0.a.l1.b e2 = d.a.l0.a.l1.b.e(this.f47614g.get(i2).f11358a, d.a.l0.a.g1.f.V().A());
        h.f(e2.f47033e, "5");
        this.f47611d.Y2(e2, uuid);
        d.a.l0.a.h0.g.f.H3("switchTab");
        this.f47611d.D3();
    }

    public boolean h(String str, String str2, String str3, String str4) {
        if (this.f47608a == null || this.f47609b == null) {
            return false;
        }
        y(SwanAppConfigData.s(str4));
        z(str3);
        B(str);
        D(str2);
        Iterator<SwanAppBottomTabIconView> it = this.f47613f.iterator();
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
            this.f47613f.get(i2).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean j(boolean z) {
        View view = this.f47608a;
        if (view == null || this.f47609b == null) {
            return false;
        }
        view.setVisibility(8);
        if (z) {
            l();
            return true;
        }
        this.f47609b.setVisibility(8);
        return true;
    }

    @AnyThread
    public boolean k(int i2) {
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (q(i2) && (swanAppBottomTabIconView = this.f47613f.get(i2)) != null) {
            q0.b0(new f(this, swanAppBottomTabIconView));
            return true;
        }
        return false;
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47609b, "translationY", 0.0f, d.a.l0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public LinearLayout m() {
        return this.f47609b;
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
        if (!TextUtils.isEmpty(str) && (list = this.f47614g) != null && list.size() != 0) {
            for (int i2 = 0; i2 < this.f47614g.size(); i2++) {
                SwanAppConfigData.m mVar = this.f47614g.get(i2);
                if (mVar != null && TextUtils.equals(mVar.f11358a, str)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean p() {
        LinearLayout linearLayout = this.f47609b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean q(int i2) {
        ArrayList<SwanAppBottomTabIconView> arrayList = this.f47613f;
        return arrayList != null && i2 < arrayList.size() && i2 >= 0;
    }

    public boolean r(boolean z) {
        View view = this.f47608a;
        if (view == null || this.f47609b == null) {
            return false;
        }
        view.setVisibility(0);
        this.f47609b.setVisibility(0);
        t(z);
        return true;
    }

    public boolean s(int i2) {
        if (q(i2)) {
            this.f47613f.get(i2).setRedDotVisibleState(true);
            return true;
        }
        return false;
    }

    public final void t(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47609b, "translationY", d.a.l0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    public final void u(int i2) {
        A(this.f47613f.get(this.f47610c), this.f47614g.get(this.f47610c));
        C(this.f47613f.get(i2), this.f47614g.get(i2));
    }

    public final void v(int i2) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.m mVar = this.f47614g.get(i2);
        String j3 = this.f47611d.j3(d.a.l0.a.l1.b.e(mVar.f11358a, d.a.l0.a.g1.f.V().A()).f47033e);
        hashMap.put("index", String.valueOf(i2));
        hashMap.put("pagePath", mVar.f11358a);
        hashMap.put("text", mVar.f11361d);
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, j3);
        d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("onTabItemTap", hashMap));
    }

    public boolean w(int i2, String str) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f47613f.get(i2);
            swanAppBottomTabIconView.setBadgeVisibleState(true);
            swanAppBottomTabIconView.setBadgeText(str);
            return true;
        }
        return false;
    }

    public boolean x(int i2, String str, String str2, String str3) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f47613f.get(i2);
            q0.b0(new e(this, swanAppBottomTabIconView, str));
            if (!TextUtils.isEmpty(str2)) {
                this.f47614g.get(i2).f11359b = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f47614g.get(i2).f11360c = str3;
            }
            if (swanAppBottomTabIconView.a()) {
                return C(swanAppBottomTabIconView, this.f47614g.get(i2));
            }
            return A(swanAppBottomTabIconView, this.f47614g.get(i2));
        }
        return false;
    }

    public final void y(int i2) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i2) {
            this.f47608a.setVisibility(0);
            this.f47608a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.f47608a.setVisibility(0);
            this.f47608a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.l0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.f47608a.setVisibility(0);
            this.f47608a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        this.f47609b.setBackgroundColor(SwanAppConfigData.s(str));
    }
}
