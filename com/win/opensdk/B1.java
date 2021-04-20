package com.win.opensdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CircleProgressbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class B1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f39914a;

    /* renamed from: b  reason: collision with root package name */
    public n1 f39915b;

    /* renamed from: c  reason: collision with root package name */
    public Info f39916c;

    /* renamed from: d  reason: collision with root package name */
    public View f39917d;

    /* renamed from: f  reason: collision with root package name */
    public r f39919f;

    /* renamed from: g  reason: collision with root package name */
    public h2 f39920g;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public long v;
    public int w;
    public int x;
    public long y;

    /* renamed from: e  reason: collision with root package name */
    public List f39918e = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public long f39921h = 0;
    public o1 i = new v1(this);
    public boolean j = false;
    public long k = 0;

    public B1(Context context, String str) {
        this.f39914a = context;
        n1 n1Var = new n1(context, str, F.SPLASH);
        this.f39915b = n1Var;
        n1Var.f40279g = this.i;
        this.f39920g = new h2(context);
    }

    public static /* synthetic */ void a(B1 b1, View view) {
        if (b1.t <= 0 || b1.u <= 0) {
            b1.u = view.getHeight();
            b1.t = view.getWidth();
        }
    }

    public final List a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            try {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        arrayList.add(childAt);
                        if (!(childAt instanceof PBMediaView)) {
                            arrayList.addAll(a(childAt));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public void a() {
        try {
            c();
            if (this.f39915b != null) {
                this.f39915b.a();
                this.f39915b = null;
            }
            if (this.f39919f != null) {
                this.f39919f = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        Info info = this.f39916c;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.f39918e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.f39918e.clear();
            if (this.f39917d != null) {
                this.f39917d = null;
            }
        } catch (Exception unused) {
        }
    }

    public HashMap d() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.n));
        hashMap.put("dy", Integer.valueOf(this.o));
        hashMap.put("dts", Long.valueOf(this.v));
        hashMap.put("ux", Integer.valueOf(this.w));
        hashMap.put("uy", Integer.valueOf(this.x));
        hashMap.put("uts", Long.valueOf(this.y));
        G.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
        return hashMap;
    }

    public void a(View view, PBMediaView pBMediaView) {
        List<View> arrayList = new ArrayList();
        if (view != null) {
            arrayList = a(view);
        }
        if (view == null || arrayList == null || arrayList.size() == 0 || !b()) {
            return;
        }
        this.f39921h = 0L;
        if (this.f39917d != null) {
            c();
        }
        this.f39917d = view;
        try {
            A1 a1 = new A1(this);
            for (View view2 : arrayList) {
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f39918e.contains(view2)) {
                        this.f39918e.add(view2);
                    }
                    if (!(view2 instanceof CircleProgressbar)) {
                        view2.setOnClickListener(a1);
                        view2.setOnTouchListener(a1);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    S htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f39916c.getLoad() : "", this.f39916c);
                    if (this.f39916c.isNat()) {
                        htmlWebView.f40077c.setOnTouchListener(new y1(this));
                    }
                    htmlWebView.f40076b = new z1(this);
                }
            } catch (Exception unused2) {
            }
        }
        a1.a(this.f39914a).b(new b1(this.f39916c)).a();
        r rVar = this.f39919f;
        if (rVar != null) {
            rVar.onDisplayed();
        }
        if (this.f39916c != null) {
            V1.b(this.f39914a, this.f39916c.getId() + ":" + System.currentTimeMillis(), false);
        }
        G.a(this.f39916c);
        new t0().a(view, this.f39916c, new x1(this, view));
    }
}
