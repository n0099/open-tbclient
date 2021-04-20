package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40283a;

    /* renamed from: b  reason: collision with root package name */
    public int f40284b;

    /* renamed from: c  reason: collision with root package name */
    public long f40285c;

    /* renamed from: d  reason: collision with root package name */
    public int f40286d;

    /* renamed from: e  reason: collision with root package name */
    public int f40287e;

    /* renamed from: f  reason: collision with root package name */
    public long f40288f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p0 f40289g;

    public o0(p0 p0Var) {
        this.f40289g = p0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40283a));
        hashMap.put("dy", Integer.valueOf(this.f40284b));
        hashMap.put("dts", Long.valueOf(this.f40285c));
        hashMap.put("ux", Integer.valueOf(this.f40286d));
        hashMap.put("uy", Integer.valueOf(this.f40287e));
        hashMap.put("uts", Long.valueOf(this.f40288f));
        p0 p0Var = this.f40289g;
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
            this.f40283a = (int) motionEvent.getRawX();
            this.f40284b = (int) motionEvent.getRawY();
            this.f40285c = System.currentTimeMillis();
            this.f40289g.p = (int) motionEvent.getX();
            this.f40289g.q = (int) motionEvent.getY();
            p0.a(this.f40289g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40286d = (int) motionEvent.getRawX();
            this.f40287e = (int) motionEvent.getRawY();
            this.f40288f = System.currentTimeMillis();
            this.f40289g.r = (int) motionEvent.getX();
            this.f40289g.s = (int) motionEvent.getY();
            p0 p0Var = this.f40289g;
            Info info = p0Var.f40296c;
            if (info == null || !R1.a(info, p0Var.f40301h)) {
                return false;
            }
            this.f40289g.f40301h = System.currentTimeMillis();
            p0 p0Var2 = this.f40289g;
            Context context = p0Var2.f40294a;
            String open = p0Var2.f40296c.getOpen();
            p0 p0Var3 = this.f40289g;
            R1.a(context, open, p0Var3.f40296c, p0Var3.f40300g, a().toString());
            a1.a(this.f40289g.f40294a).a(new b1(this.f40289g.f40296c), (String) null).a("desc", a().toString()).a();
            G.a(this.f40289g.f40296c, a().toString());
            PBNativeListener pBNativeListener = this.f40289g.f40299f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
