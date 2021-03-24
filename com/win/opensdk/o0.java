package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f39993a;

    /* renamed from: b  reason: collision with root package name */
    public int f39994b;

    /* renamed from: c  reason: collision with root package name */
    public long f39995c;

    /* renamed from: d  reason: collision with root package name */
    public int f39996d;

    /* renamed from: e  reason: collision with root package name */
    public int f39997e;

    /* renamed from: f  reason: collision with root package name */
    public long f39998f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ p0 f39999g;

    public o0(p0 p0Var) {
        this.f39999g = p0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f39993a));
        hashMap.put("dy", Integer.valueOf(this.f39994b));
        hashMap.put("dts", Long.valueOf(this.f39995c));
        hashMap.put("ux", Integer.valueOf(this.f39996d));
        hashMap.put("uy", Integer.valueOf(this.f39997e));
        hashMap.put("uts", Long.valueOf(this.f39998f));
        p0 p0Var = this.f39999g;
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
            this.f39993a = (int) motionEvent.getRawX();
            this.f39994b = (int) motionEvent.getRawY();
            this.f39995c = System.currentTimeMillis();
            this.f39999g.p = (int) motionEvent.getX();
            this.f39999g.q = (int) motionEvent.getY();
            p0.a(this.f39999g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f39996d = (int) motionEvent.getRawX();
            this.f39997e = (int) motionEvent.getRawY();
            this.f39998f = System.currentTimeMillis();
            this.f39999g.r = (int) motionEvent.getX();
            this.f39999g.s = (int) motionEvent.getY();
            p0 p0Var = this.f39999g;
            Info info = p0Var.f40006c;
            if (info == null || !R1.a(info, p0Var.f40011h)) {
                return false;
            }
            this.f39999g.f40011h = System.currentTimeMillis();
            p0 p0Var2 = this.f39999g;
            Context context = p0Var2.f40004a;
            String open = p0Var2.f40006c.getOpen();
            p0 p0Var3 = this.f39999g;
            R1.a(context, open, p0Var3.f40006c, p0Var3.f40010g, a().toString());
            a1.a(this.f39999g.f40004a).a(new b1(this.f39999g.f40006c), (String) null).a("desc", a().toString()).a();
            G.a(this.f39999g.f40006c, a().toString());
            PBNativeListener pBNativeListener = this.f39999g.f40009f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
