package d.a.h0.a.d2.b;

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
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j1.j;
import d.a.h0.a.k;
import d.a.h0.a.u0.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public View f41853a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f41854b;

    /* renamed from: c  reason: collision with root package name */
    public int f41855c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.e0.l.e f41856d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.j f41857e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f41858f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<SwanAppConfigData.k> f41859g;

    /* renamed from: h  reason: collision with root package name */
    public String f41860h;

    /* renamed from: i  reason: collision with root package name */
    public String f41861i;

    /* renamed from: d.a.h0.a.d2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0615a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41862e;

        public View$OnClickListenerC0615a(int i2) {
            this.f41862e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g(this.f41862e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f41864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f41865f;

        public b(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f41864e = swanAppBottomTabIconView;
            this.f41865f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41864e.setIconView(this.f41865f);
            if (a.this.f41860h == null) {
                this.f41864e.setTextColor(a.this.f41857e.f12178a);
            } else {
                this.f41864e.setTextColor(SwanAppConfigData.s(a.this.f41860h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f41867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f41868f;

        public c(SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            this.f41867e = swanAppBottomTabIconView;
            this.f41868f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41867e.setIconView(this.f41868f);
            if (a.this.f41861i == null) {
                this.f41867e.setTextColor(a.this.f41857e.f12179b);
            } else {
                this.f41867e.setTextColor(SwanAppConfigData.s(a.this.f41861i));
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
            a.this.f41854b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView f41871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41872f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            this.f41871e = swanAppBottomTabIconView;
            this.f41872f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41871e.setTextView(this.f41872f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f41873e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            this.f41873e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41873e.setRedDotVisibleState(false);
        }
    }

    public a(d.a.h0.a.e0.l.e eVar) {
        this.f41856d = eVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        d.a.h0.a.y0.e.b n = n();
        if (n == null) {
            return false;
        }
        String j2 = d.a.h0.a.m1.a.a.j(n);
        if (TextUtils.isEmpty(j2)) {
            j2 = d.e.h(n.G(), n.n1()).getPath();
        }
        String str = j2 + File.separator + kVar.f12184b;
        if (d.a.h0.p.d.n(str)) {
            swanAppBottomTabIconView.setmIsSelect(false);
            k0.X(new b(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void B(String str) {
        this.f41860h = str;
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.k kVar) {
        d.a.h0.a.y0.e.b n = n();
        if (n == null) {
            return false;
        }
        String j2 = d.a.h0.a.m1.a.a.j(n);
        if (TextUtils.isEmpty(j2)) {
            j2 = d.e.h(n.G(), n.n1()).getPath();
        }
        String str = j2 + File.separator + kVar.f12185c;
        if (d.a.h0.p.d.n(str)) {
            swanAppBottomTabIconView.setmIsSelect(true);
            k0.X(new c(swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
            return true;
        }
        return false;
    }

    public final void D(String str) {
        this.f41861i = str;
    }

    public void E(String str) {
        for (int i2 = 0; i2 < this.f41859g.size(); i2++) {
            if (this.f41859g.get(i2).f12183a.equals(str)) {
                u(i2);
                this.f41855c = i2;
                return;
            }
        }
    }

    public void f(View view, Context context, String str) {
        if (this.f41856d.U1()) {
            SwanAppConfigData u = d.a.h0.a.z0.f.V().u();
            if (u == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.j jVar = u.f12156e;
            this.f41857e = jVar;
            ArrayList<SwanAppConfigData.k> arrayList = jVar.f12182e;
            this.f41859g = arrayList;
            int size = arrayList.size();
            this.f41858f = new ArrayList<>(size);
            this.f41853a = view.findViewById(d.a.h0.a.f.bottom_bar_shadow);
            SwanAppConfigData.j jVar2 = this.f41857e;
            y(jVar2.f12180c, jVar2.f12181d);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.h0.a.f.ai_apps_bottom_tab);
            this.f41854b = linearLayout;
            linearLayout.setVisibility(0);
            this.f41854b.setBackgroundColor(this.f41857e.f12181d);
            int m = h0.m(AppRuntime.getAppContext());
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.k kVar = this.f41859g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m / size, -1);
                layoutParams.gravity = 1;
                if (TextUtils.equals(kVar.f12183a, !TextUtils.isEmpty(str) ? str : d.a.h0.a.z0.f.V().h()) && !z) {
                    C(swanAppBottomTabIconView, kVar);
                    this.f41855c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, kVar);
                }
                swanAppBottomTabIconView.setTextView(kVar.f12186d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0615a(i2));
                this.f41858f.add(swanAppBottomTabIconView);
                this.f41854b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i2) {
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        u(i2);
        v(i2);
        if (this.f41855c == i2) {
            return;
        }
        this.f41855c = i2;
        this.f41856d.o3();
        this.f41856d.P2(d.a.h0.a.e1.b.c(this.f41859g.get(i2).f12183a, d.a.h0.a.z0.f.V().A()), uuid);
        d.a.h0.a.e0.l.e.u3("switchTab");
        this.f41856d.r3();
    }

    public boolean h(String str, String str2, String str3, String str4) {
        if (this.f41853a == null || this.f41854b == null) {
            return false;
        }
        y(SwanAppConfigData.s(str4), SwanAppConfigData.s(str3));
        z(str3);
        B(str);
        D(str2);
        Iterator<SwanAppBottomTabIconView> it = this.f41858f.iterator();
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
            this.f41858f.get(i2).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean j(boolean z) {
        View view = this.f41853a;
        if (view == null || this.f41854b == null) {
            return false;
        }
        view.setVisibility(8);
        if (z) {
            l();
            return true;
        }
        this.f41854b.setVisibility(8);
        return true;
    }

    @AnyThread
    public boolean k(int i2) {
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        if (q(i2) && (swanAppBottomTabIconView = this.f41858f.get(i2)) != null) {
            k0.X(new f(this, swanAppBottomTabIconView));
            return true;
        }
        return false;
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f41854b, "translationY", 0.0f, d.a.h0.a.w0.a.c().getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    public LinearLayout m() {
        return this.f41854b;
    }

    public final d.a.h0.a.y0.e.b n() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 != null) {
            return h2.L();
        }
        return null;
    }

    public int o(String str) {
        ArrayList<SwanAppConfigData.k> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.f41859g) != null && arrayList.size() != 0) {
            for (int i2 = 0; i2 < this.f41859g.size(); i2++) {
                SwanAppConfigData.k kVar = this.f41859g.get(i2);
                if (kVar != null && TextUtils.equals(kVar.f12183a, str)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean p() {
        LinearLayout linearLayout = this.f41854b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean q(int i2) {
        ArrayList<SwanAppBottomTabIconView> arrayList = this.f41858f;
        return arrayList != null && i2 < arrayList.size() && i2 >= 0;
    }

    public boolean r(boolean z) {
        View view = this.f41853a;
        if (view == null || this.f41854b == null) {
            return false;
        }
        view.setVisibility(0);
        this.f41854b.setVisibility(0);
        t(z);
        return true;
    }

    public boolean s(int i2) {
        if (q(i2)) {
            this.f41858f.get(i2).setRedDotVisibleState(true);
            return true;
        }
        return false;
    }

    public final void t(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f41854b, "translationY", d.a.h0.a.w0.a.c().getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    public final void u(int i2) {
        A(this.f41858f.get(this.f41855c), this.f41859g.get(this.f41855c));
        C(this.f41858f.get(i2), this.f41859g.get(i2));
    }

    public final void v(int i2) {
        HashMap hashMap = new HashMap();
        SwanAppConfigData.k kVar = this.f41859g.get(i2);
        String Z2 = this.f41856d.Z2(d.a.h0.a.e1.b.c(kVar.f12183a, d.a.h0.a.z0.f.V().A()).f42392a);
        hashMap.put("index", String.valueOf(i2));
        hashMap.put("pagePath", kVar.f12183a);
        hashMap.put("text", kVar.f12186d);
        hashMap.put("wvID", Z2);
        d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.b("onTabItemTap", hashMap));
    }

    public boolean w(int i2, String str) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f41858f.get(i2);
            swanAppBottomTabIconView.setBadgeVisibleState(true);
            swanAppBottomTabIconView.setBadgeText(str);
            return true;
        }
        return false;
    }

    public boolean x(int i2, String str, String str2, String str3) {
        if (q(i2)) {
            SwanAppBottomTabIconView swanAppBottomTabIconView = this.f41858f.get(i2);
            k0.X(new e(this, swanAppBottomTabIconView, str));
            if (!TextUtils.isEmpty(str2)) {
                this.f41859g.get(i2).f12184b = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f41859g.get(i2).f12185c = str3;
            }
            if (swanAppBottomTabIconView.a()) {
                return C(swanAppBottomTabIconView, this.f41859g.get(i2));
            }
            return A(swanAppBottomTabIconView, this.f41859g.get(i2));
        }
        return false;
    }

    public final void y(int i2, int i3) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i2) {
            this.f41853a.setVisibility(0);
            this.f41853a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.h0.a.c.aiapps_white));
        } else if (-16777216 == i2) {
            this.f41853a.setVisibility(0);
            this.f41853a.setBackgroundColor(i3);
        } else {
            this.f41853a.setVisibility(0);
            this.f41853a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.h0.a.c.aiapps_white));
        }
    }

    public final void z(String str) {
        this.f41854b.setBackgroundColor(SwanAppConfigData.s(str));
    }
}
