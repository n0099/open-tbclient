package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class h0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40725a;

    /* renamed from: b  reason: collision with root package name */
    public int f40726b;

    /* renamed from: c  reason: collision with root package name */
    public long f40727c;

    /* renamed from: d  reason: collision with root package name */
    public int f40728d;

    /* renamed from: e  reason: collision with root package name */
    public int f40729e;

    /* renamed from: f  reason: collision with root package name */
    public long f40730f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f40731g;

    public h0(i0 i0Var) {
        this.f40731g = i0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40725a));
        hashMap.put("dy", Integer.valueOf(this.f40726b));
        hashMap.put("dts", Long.valueOf(this.f40727c));
        hashMap.put("ux", Integer.valueOf(this.f40728d));
        hashMap.put("uy", Integer.valueOf(this.f40729e));
        hashMap.put("uts", Long.valueOf(this.f40730f));
        i0 i0Var = this.f40731g;
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
            this.f40725a = (int) motionEvent.getRawX();
            this.f40726b = (int) motionEvent.getRawY();
            this.f40727c = System.currentTimeMillis();
            this.f40731g.p = (int) motionEvent.getX();
            this.f40731g.q = (int) motionEvent.getY();
            i0.a(this.f40731g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40728d = (int) motionEvent.getRawX();
            this.f40729e = (int) motionEvent.getRawY();
            this.f40730f = System.currentTimeMillis();
            this.f40731g.r = (int) motionEvent.getX();
            this.f40731g.s = (int) motionEvent.getY();
            i0 i0Var = this.f40731g;
            Info info = i0Var.f40735c;
            if (info == null || !o1.a(info, i0Var.f40740h)) {
                return false;
            }
            this.f40731g.f40740h = System.currentTimeMillis();
            i0 i0Var2 = this.f40731g;
            Context context = i0Var2.f40733a;
            String open = i0Var2.f40735c.getOpen();
            i0 i0Var3 = this.f40731g;
            o1.a(context, open, i0Var3.f40735c, i0Var3.f40739g, a().toString());
            x0.a(this.f40731g.f40733a).a(new y0(this.f40731g.f40735c), (String) null).a("desc", a().toString()).a();
            z.a(this.f40731g.f40735c, a().toString());
            PBNativeListener pBNativeListener = this.f40731g.f40738f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
