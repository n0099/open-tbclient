package com.win.opensdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40389a;

    /* renamed from: b  reason: collision with root package name */
    public n1 f40390b;

    /* renamed from: c  reason: collision with root package name */
    public Info f40391c;

    /* renamed from: d  reason: collision with root package name */
    public View f40392d;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f40394f;

    /* renamed from: g  reason: collision with root package name */
    public h2 f40395g;
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
    public List f40393e = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public long f40396h = 0;
    public o1 i = new j0(this);
    public boolean j = false;
    public long k = 0;

    public p0(Context context, String str) {
        this.f40389a = context;
        n1 n1Var = new n1(context, str, F.NATIVE);
        this.f40390b = n1Var;
        n1Var.f40374g = this.i;
        this.f40395g = new h2(context);
    }

    public static /* synthetic */ void a(p0 p0Var, View view) {
        if (p0Var.t <= 0 || p0Var.u <= 0) {
            p0Var.u = view.getHeight();
            p0Var.t = view.getWidth();
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
            if (this.f40390b != null) {
                this.f40390b.a();
                this.f40390b = null;
            }
            if (this.f40394f != null) {
                this.f40394f = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        Info info = this.f40391c;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.f40393e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.f40393e.clear();
            if (this.f40392d != null) {
                this.f40392d = null;
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
        List arrayList = new ArrayList();
        if (view != null) {
            arrayList = a(view);
        }
        a(view, pBMediaView, arrayList);
    }

    public void a(View view, PBMediaView pBMediaView, List list) {
        if (view == null || list == null || list.size() == 0 || !b()) {
            return;
        }
        this.f40396h = 0L;
        if (this.f40392d != null) {
            c();
        }
        this.f40392d = view;
        try {
            o0 o0Var = new o0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f40393e.contains(view2)) {
                        this.f40393e.add(view2);
                    }
                    view2.setOnClickListener(o0Var);
                    view2.setOnTouchListener(o0Var);
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    S htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f40391c.getLoad() : "", this.f40391c);
                    if (this.f40391c.isNat()) {
                        htmlWebView.f40172c.setOnTouchListener(new m0(this));
                    }
                    htmlWebView.f40171b = new n0(this);
                }
            } catch (Exception unused2) {
            }
        }
        a1.a(this.f40389a).b(new b1(this.f40391c)).a();
        PBNativeListener pBNativeListener = this.f40394f;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
        if (this.f40391c != null) {
            V1.b(this.f40389a, this.f40391c.getId() + ":" + System.currentTimeMillis(), false);
        }
        G.a(this.f40391c);
        new t0().a(view, this.f40391c, new l0(this, view));
    }
}
