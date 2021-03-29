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
    public Context f39625a;

    /* renamed from: b  reason: collision with root package name */
    public n1 f39626b;

    /* renamed from: c  reason: collision with root package name */
    public Info f39627c;

    /* renamed from: d  reason: collision with root package name */
    public View f39628d;

    /* renamed from: f  reason: collision with root package name */
    public r f39630f;

    /* renamed from: g  reason: collision with root package name */
    public h2 f39631g;
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
    public List f39629e = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public long f39632h = 0;
    public o1 i = new v1(this);
    public boolean j = false;
    public long k = 0;

    public B1(Context context, String str) {
        this.f39625a = context;
        n1 n1Var = new n1(context, str, F.SPLASH);
        this.f39626b = n1Var;
        n1Var.f39990g = this.i;
        this.f39631g = new h2(context);
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
            if (this.f39626b != null) {
                this.f39626b.a();
                this.f39626b = null;
            }
            if (this.f39630f != null) {
                this.f39630f = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        Info info = this.f39627c;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.f39629e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.f39629e.clear();
            if (this.f39628d != null) {
                this.f39628d = null;
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
        this.f39632h = 0L;
        if (this.f39628d != null) {
            c();
        }
        this.f39628d = view;
        try {
            A1 a1 = new A1(this);
            for (View view2 : arrayList) {
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f39629e.contains(view2)) {
                        this.f39629e.add(view2);
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
                    htmlWebView.a(b() ? this.f39627c.getLoad() : "", this.f39627c);
                    if (this.f39627c.isNat()) {
                        htmlWebView.f39788c.setOnTouchListener(new y1(this));
                    }
                    htmlWebView.f39787b = new z1(this);
                }
            } catch (Exception unused2) {
            }
        }
        a1.a(this.f39625a).b(new b1(this.f39627c)).a();
        r rVar = this.f39630f;
        if (rVar != null) {
            rVar.onDisplayed();
        }
        if (this.f39627c != null) {
            V1.b(this.f39625a, this.f39627c.getId() + ":" + System.currentTimeMillis(), false);
        }
        G.a(this.f39627c);
        new t0().a(view, this.f39627c, new x1(this, view));
    }
}
