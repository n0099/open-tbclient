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
    public Context f40733a;

    /* renamed from: b  reason: collision with root package name */
    public K0 f40734b;

    /* renamed from: c  reason: collision with root package name */
    public Info f40735c;

    /* renamed from: d  reason: collision with root package name */
    public View f40736d;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f40738f;

    /* renamed from: g  reason: collision with root package name */
    public E1 f40739g;
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
    public List f40737e = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public long f40740h = 0;

    /* renamed from: i  reason: collision with root package name */
    public L0 f40741i = new c0(this);
    public boolean j = false;
    public long k = 0;

    public i0(Context context, String str) {
        this.f40733a = context;
        K0 k0 = new K0(context, str, y.NATIVE);
        this.f40734b = k0;
        k0.f40539g = this.f40741i;
        this.f40739g = new E1(context);
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
            if (this.f40734b != null) {
                this.f40734b.a();
                this.f40734b = null;
            }
            if (this.f40738f != null) {
                this.f40738f = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        Info info = this.f40735c;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.f40737e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.f40737e.clear();
            if (this.f40736d != null) {
                this.f40736d = null;
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
        this.f40740h = 0L;
        if (this.f40736d != null) {
            c();
        }
        this.f40736d = view;
        try {
            h0 h0Var = new h0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f40737e.contains(view2)) {
                        this.f40737e.add(view2);
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
                    htmlWebView.a(b() ? this.f40735c.getLoad() : "", this.f40735c);
                    if (this.f40735c.isNat()) {
                        htmlWebView.f40530c.setOnTouchListener(new f0(this));
                    }
                    htmlWebView.f40529b = new g0(this);
                }
            } catch (Exception unused2) {
            }
        }
        x0.a(this.f40733a).a(new y0(this.f40735c)).a();
        PBNativeListener pBNativeListener = this.f40738f;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
        if (this.f40735c != null) {
            s1.b(this.f40733a, this.f40735c.getId() + ":" + System.currentTimeMillis(), false);
        }
        z.a(this.f40735c);
        new m0().a(view, this.f40735c, new e0(this, view));
    }
}
