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
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f37054a;

    /* renamed from: b  reason: collision with root package name */
    public K0 f37055b;

    /* renamed from: c  reason: collision with root package name */
    public Info f37056c;

    /* renamed from: d  reason: collision with root package name */
    public View f37057d;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f37059f;

    /* renamed from: g  reason: collision with root package name */
    public E1 f37060g;
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
    public List f37058e = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public long f37061h = 0;

    /* renamed from: i  reason: collision with root package name */
    public L0 f37062i = new c0(this);
    public boolean j = false;
    public long k = 0;

    public i0(Context context, String str) {
        this.f37054a = context;
        K0 k0 = new K0(context, str, y.NATIVE);
        this.f37055b = k0;
        k0.f36860g = this.f37062i;
        this.f37060g = new E1(context);
    }

    public static /* synthetic */ void a(i0 i0Var, View view) {
        if (i0Var.t <= 0 || i0Var.u <= 0) {
            i0Var.u = view.getHeight();
            i0Var.t = view.getWidth();
        }
    }

    public final List a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            try {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
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
            if (this.f37055b != null) {
                this.f37055b.a();
                this.f37055b = null;
            }
            if (this.f37059f != null) {
                this.f37059f = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        Info info = this.f37056c;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.f37058e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.f37058e.clear();
            if (this.f37057d != null) {
                this.f37057d = null;
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
        z.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
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
        this.f37061h = 0L;
        if (this.f37057d != null) {
            c();
        }
        this.f37057d = view;
        try {
            h0 h0Var = new h0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f37058e.contains(view2)) {
                        this.f37058e.add(view2);
                    }
                    view2.setOnClickListener(h0Var);
                    view2.setOnTouchListener(h0Var);
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    K htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f37056c.getLoad() : "", this.f37056c);
                    if (this.f37056c.isNat()) {
                        htmlWebView.f36851c.setOnTouchListener(new f0(this));
                    }
                    htmlWebView.f36850b = new g0(this);
                }
            } catch (Exception unused2) {
            }
        }
        x0.a(this.f37054a).a(new y0(this.f37056c)).a();
        PBNativeListener pBNativeListener = this.f37059f;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
        if (this.f37056c != null) {
            s1.b(this.f37054a, this.f37056c.getId() + ":" + System.currentTimeMillis(), false);
        }
        z.a(this.f37056c);
        new m0().a(view, this.f37056c, new e0(this, view));
    }
}
