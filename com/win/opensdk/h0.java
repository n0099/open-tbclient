package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class h0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40828a;

    /* renamed from: b  reason: collision with root package name */
    public int f40829b;

    /* renamed from: c  reason: collision with root package name */
    public long f40830c;

    /* renamed from: d  reason: collision with root package name */
    public int f40831d;

    /* renamed from: e  reason: collision with root package name */
    public int f40832e;

    /* renamed from: f  reason: collision with root package name */
    public long f40833f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f40834g;

    public h0(i0 i0Var) {
        this.f40834g = i0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40828a));
        hashMap.put("dy", Integer.valueOf(this.f40829b));
        hashMap.put("dts", Long.valueOf(this.f40830c));
        hashMap.put("ux", Integer.valueOf(this.f40831d));
        hashMap.put("uy", Integer.valueOf(this.f40832e));
        hashMap.put("uts", Long.valueOf(this.f40833f));
        i0 i0Var = this.f40834g;
        z.a(hashMap, i0Var.p, i0Var.q, i0Var.r, i0Var.s, i0Var.t, i0Var.u);
        return hashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40828a = (int) motionEvent.getRawX();
            this.f40829b = (int) motionEvent.getRawY();
            this.f40830c = System.currentTimeMillis();
            this.f40834g.p = (int) motionEvent.getX();
            this.f40834g.q = (int) motionEvent.getY();
            i0.a(this.f40834g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40831d = (int) motionEvent.getRawX();
            this.f40832e = (int) motionEvent.getRawY();
            this.f40833f = System.currentTimeMillis();
            this.f40834g.r = (int) motionEvent.getX();
            this.f40834g.s = (int) motionEvent.getY();
            i0 i0Var = this.f40834g;
            Info info = i0Var.f40838c;
            if (info == null || !o1.a(info, i0Var.f40843h)) {
                return false;
            }
            this.f40834g.f40843h = System.currentTimeMillis();
            i0 i0Var2 = this.f40834g;
            Context context = i0Var2.f40836a;
            String open = i0Var2.f40838c.getOpen();
            i0 i0Var3 = this.f40834g;
            o1.a(context, open, i0Var3.f40838c, i0Var3.f40842g, a().toString());
            x0.a(this.f40834g.f40836a).a(new y0(this.f40834g.f40838c), (String) null).a("desc", a().toString()).a();
            z.a(this.f40834g.f40838c, a().toString());
            PBNativeListener pBNativeListener = this.f40834g.f40841f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
