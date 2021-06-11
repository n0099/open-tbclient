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
public class Y0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40660a;

    /* renamed from: b  reason: collision with root package name */
    public K0 f40661b;

    /* renamed from: c  reason: collision with root package name */
    public Info f40662c;

    /* renamed from: d  reason: collision with root package name */
    public View f40663d;

    /* renamed from: f  reason: collision with root package name */
    public r f40665f;

    /* renamed from: g  reason: collision with root package name */
    public E1 f40666g;
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
    public List f40664e = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public long f40667h = 0;

    /* renamed from: i  reason: collision with root package name */
    public L0 f40668i = new S0(this);
    public boolean j = false;
    public long k = 0;

    public Y0(Context context, String str) {
        this.f40660a = context;
        K0 k0 = new K0(context, str, y.SPLASH);
        this.f40661b = k0;
        k0.f40539g = this.f40668i;
        this.f40666g = new E1(context);
    }

    public static /* synthetic */ void a(Y0 y0, View view) {
        if (y0.t <= 0 || y0.u <= 0) {
            y0.u = view.getHeight();
            y0.t = view.getWidth();
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
            if (this.f40661b != null) {
                this.f40661b.a();
                this.f40661b = null;
            }
            if (this.f40665f != null) {
                this.f40665f = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        Info info = this.f40662c;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.f40664e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.f40664e.clear();
            if (this.f40663d != null) {
                this.f40663d = null;
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
        List<View> arrayList = new ArrayList();
        if (view != null) {
            arrayList = a(view);
        }
        if (view == null || arrayList == null || arrayList.size() == 0 || !b()) {
            return;
        }
        this.f40667h = 0L;
        if (this.f40663d != null) {
            c();
        }
        this.f40663d = view;
        try {
            X0 x0 = new X0(this);
            for (View view2 : arrayList) {
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f40664e.contains(view2)) {
                        this.f40664e.add(view2);
                    }
                    if (!(view2 instanceof CircleProgressbar)) {
                        view2.setOnClickListener(x0);
                        view2.setOnTouchListener(x0);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    K htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f40662c.getLoad() : "", this.f40662c);
                    if (this.f40662c.isNat()) {
                        htmlWebView.f40530c.setOnTouchListener(new V0(this));
                    }
                    htmlWebView.f40529b = new W0(this);
                }
            } catch (Exception unused2) {
            }
        }
        x0.a(this.f40660a).a(new y0(this.f40662c)).a();
        r rVar = this.f40665f;
        if (rVar != null) {
            rVar.onDisplayed();
        }
        if (this.f40662c != null) {
            s1.b(this.f40660a, this.f40662c.getId() + ":" + System.currentTimeMillis(), false);
        }
        z.a(this.f40662c);
        new m0().a(view, this.f40662c, new U0(this, view));
    }
}
