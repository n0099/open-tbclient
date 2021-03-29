package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f39973a;

    public m0(p0 p0Var) {
        this.f39973a = p0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39973a.j = true;
            this.f39973a.k = System.currentTimeMillis();
            this.f39973a.l = motionEvent.getX();
            this.f39973a.m = motionEvent.getY();
            this.f39973a.n = (int) motionEvent.getRawX();
            this.f39973a.o = (int) motionEvent.getRawY();
            this.f39973a.p = (int) motionEvent.getX();
            this.f39973a.q = (int) motionEvent.getY();
            this.f39973a.v = System.currentTimeMillis();
            p0.a(this.f39973a, view);
        } else if (action == 1) {
            this.f39973a.w = (int) motionEvent.getRawX();
            this.f39973a.x = (int) motionEvent.getRawY();
            this.f39973a.r = (int) motionEvent.getX();
            this.f39973a.s = (int) motionEvent.getY();
            this.f39973a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f39973a.l);
            Math.abs(motionEvent.getY() - this.f39973a.m);
            if (System.currentTimeMillis() - this.f39973a.k < 2000) {
                p0 p0Var = this.f39973a;
                if (p0Var.j && (info = p0Var.f40007c) != null && R1.a(info, p0Var.f40012h)) {
                    this.f39973a.f40012h = System.currentTimeMillis();
                    p0 p0Var2 = this.f39973a;
                    Context context = p0Var2.f40005a;
                    String open = p0Var2.f40007c.getOpen();
                    p0 p0Var3 = this.f39973a;
                    R1.a(context, open, p0Var3.f40007c, p0Var3.f40011g, p0Var3.d().toString());
                    a1.a(this.f39973a.f40005a).a(new b1(this.f39973a.f40007c), (String) null).a("desc", this.f39973a.d().toString()).a();
                    p0 p0Var4 = this.f39973a;
                    G.a(p0Var4.f40007c, p0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f39973a.f40010f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
