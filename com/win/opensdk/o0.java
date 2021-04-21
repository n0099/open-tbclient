package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40378a;

    /* renamed from: b  reason: collision with root package name */
    public int f40379b;

    /* renamed from: c  reason: collision with root package name */
    public long f40380c;

    /* renamed from: d  reason: collision with root package name */
    public int f40381d;

    /* renamed from: e  reason: collision with root package name */
    public int f40382e;

    /* renamed from: f  reason: collision with root package name */
    public long f40383f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p0 f40384g;

    public o0(p0 p0Var) {
        this.f40384g = p0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40378a));
        hashMap.put("dy", Integer.valueOf(this.f40379b));
        hashMap.put("dts", Long.valueOf(this.f40380c));
        hashMap.put("ux", Integer.valueOf(this.f40381d));
        hashMap.put("uy", Integer.valueOf(this.f40382e));
        hashMap.put("uts", Long.valueOf(this.f40383f));
        p0 p0Var = this.f40384g;
        G.a(hashMap, p0Var.p, p0Var.q, p0Var.r, p0Var.s, p0Var.t, p0Var.u);
        return hashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40378a = (int) motionEvent.getRawX();
            this.f40379b = (int) motionEvent.getRawY();
            this.f40380c = System.currentTimeMillis();
            this.f40384g.p = (int) motionEvent.getX();
            this.f40384g.q = (int) motionEvent.getY();
            p0.a(this.f40384g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40381d = (int) motionEvent.getRawX();
            this.f40382e = (int) motionEvent.getRawY();
            this.f40383f = System.currentTimeMillis();
            this.f40384g.r = (int) motionEvent.getX();
            this.f40384g.s = (int) motionEvent.getY();
            p0 p0Var = this.f40384g;
            Info info = p0Var.f40391c;
            if (info == null || !R1.a(info, p0Var.f40396h)) {
                return false;
            }
            this.f40384g.f40396h = System.currentTimeMillis();
            p0 p0Var2 = this.f40384g;
            Context context = p0Var2.f40389a;
            String open = p0Var2.f40391c.getOpen();
            p0 p0Var3 = this.f40384g;
            R1.a(context, open, p0Var3.f40391c, p0Var3.f40395g, a().toString());
            a1.a(this.f40384g.f40389a).a(new b1(this.f40384g.f40391c), (String) null).a("desc", a().toString()).a();
            G.a(this.f40384g.f40391c, a().toString());
            PBNativeListener pBNativeListener = this.f40384g.f40394f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
