package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f39994a;

    /* renamed from: b  reason: collision with root package name */
    public int f39995b;

    /* renamed from: c  reason: collision with root package name */
    public long f39996c;

    /* renamed from: d  reason: collision with root package name */
    public int f39997d;

    /* renamed from: e  reason: collision with root package name */
    public int f39998e;

    /* renamed from: f  reason: collision with root package name */
    public long f39999f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p0 f40000g;

    public o0(p0 p0Var) {
        this.f40000g = p0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f39994a));
        hashMap.put("dy", Integer.valueOf(this.f39995b));
        hashMap.put("dts", Long.valueOf(this.f39996c));
        hashMap.put("ux", Integer.valueOf(this.f39997d));
        hashMap.put("uy", Integer.valueOf(this.f39998e));
        hashMap.put("uts", Long.valueOf(this.f39999f));
        p0 p0Var = this.f40000g;
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
            this.f39994a = (int) motionEvent.getRawX();
            this.f39995b = (int) motionEvent.getRawY();
            this.f39996c = System.currentTimeMillis();
            this.f40000g.p = (int) motionEvent.getX();
            this.f40000g.q = (int) motionEvent.getY();
            p0.a(this.f40000g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f39997d = (int) motionEvent.getRawX();
            this.f39998e = (int) motionEvent.getRawY();
            this.f39999f = System.currentTimeMillis();
            this.f40000g.r = (int) motionEvent.getX();
            this.f40000g.s = (int) motionEvent.getY();
            p0 p0Var = this.f40000g;
            Info info = p0Var.f40007c;
            if (info == null || !R1.a(info, p0Var.f40012h)) {
                return false;
            }
            this.f40000g.f40012h = System.currentTimeMillis();
            p0 p0Var2 = this.f40000g;
            Context context = p0Var2.f40005a;
            String open = p0Var2.f40007c.getOpen();
            p0 p0Var3 = this.f40000g;
            R1.a(context, open, p0Var3.f40007c, p0Var3.f40011g, a().toString());
            a1.a(this.f40000g.f40005a).a(new b1(this.f40000g.f40007c), (String) null).a("desc", a().toString()).a();
            G.a(this.f40000g.f40007c, a().toString());
            PBNativeListener pBNativeListener = this.f40000g.f40010f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
