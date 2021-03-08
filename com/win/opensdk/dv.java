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
/* loaded from: classes14.dex */
public class dv {

    /* renamed from: a  reason: collision with root package name */
    public Context f8159a;
    public View d;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public Info qkh;
    public dq qlI;
    public PBNativeListener qlX;
    public cy qlY;
    public int r;
    public int s;
    public int t;
    public int u;
    public long v;
    public int w;
    public int x;
    public long y;
    public List e = Collections.synchronizedList(new ArrayList());
    public long h = 0;
    public du qlZ = new dc(this);
    public boolean j = false;
    public long k = 0;

    public dv(Context context, String str) {
        this.f8159a = context;
        this.qlI = new dq(context, str, F.NATIVE);
        this.qlI.qlS = this.qlZ;
        this.qlY = new cy(context);
    }

    public static /* synthetic */ void a(dv dvVar, View view) {
        if (dvVar.t <= 0 || dvVar.u <= 0) {
            dvVar.u = view.getHeight();
            dvVar.t = view.getWidth();
        }
    }

    public final List I(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            try {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        arrayList.add(childAt);
                        if (!(childAt instanceof PBMediaView)) {
                            arrayList.addAll(I(childAt));
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    public void a() {
        try {
            c();
            if (this.qlI != null) {
                this.qlI.a();
                this.qlI = null;
            }
            if (this.qlX != null) {
                this.qlX = null;
            }
        } catch (Exception e) {
        }
    }

    public boolean b() {
        Info info = this.qkh;
        return info != null && info.isEffective();
    }

    public void c() {
        try {
            for (View view : this.e) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.e.clear();
            if (this.d != null) {
                this.d = null;
            }
        } catch (Exception e) {
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
        v.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
        return hashMap;
    }

    public void a(View view, PBMediaView pBMediaView) {
        List arrayList = new ArrayList();
        if (view != null) {
            arrayList = I(view);
        }
        a(view, pBMediaView, arrayList);
    }

    public void a(View view, PBMediaView pBMediaView, List list) {
        if (view != null && list != null && list.size() != 0 && b()) {
            this.h = 0L;
            if (this.d != null) {
                c();
            }
            this.d = view;
            try {
                dt dtVar = new dt(this);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    View view2 = (View) it.next();
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.e.contains(view2)) {
                            this.e.add(view2);
                        }
                        view2.setOnClickListener(dtVar);
                        view2.setOnTouchListener(dtVar);
                    }
                }
            } catch (Exception e) {
            }
            if (pBMediaView != null) {
                try {
                    if (pBMediaView.getHtmlWebView() != null) {
                        bg htmlWebView = pBMediaView.getHtmlWebView();
                        htmlWebView.a(b() ? this.qkh.getLoad() : "", this.qkh);
                        if (this.qkh.isNat()) {
                            htmlWebView.c.setOnTouchListener(new dm(this));
                        }
                        htmlWebView.qlc = new dp(this);
                    }
                } catch (Exception e2) {
                }
            }
            ca.iT(this.f8159a).a(new cd(this.qkh)).a();
            PBNativeListener pBNativeListener = this.qlX;
            if (pBNativeListener != null) {
                pBNativeListener.onDisplayed();
            }
            if (this.qkh != null) {
                bp.b(this.f8159a, this.qkh.getId() + ":" + System.currentTimeMillis(), false);
            }
            v.d(this.qkh);
            new ek().a(view, this.qkh, new dj(this, view));
        }
    }
}
