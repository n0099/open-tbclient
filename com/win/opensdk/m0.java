package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f40262a;

    public m0(p0 p0Var) {
        this.f40262a = p0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40262a.j = true;
            this.f40262a.k = System.currentTimeMillis();
            this.f40262a.l = motionEvent.getX();
            this.f40262a.m = motionEvent.getY();
            this.f40262a.n = (int) motionEvent.getRawX();
            this.f40262a.o = (int) motionEvent.getRawY();
            this.f40262a.p = (int) motionEvent.getX();
            this.f40262a.q = (int) motionEvent.getY();
            this.f40262a.v = System.currentTimeMillis();
            p0.a(this.f40262a, view);
        } else if (action == 1) {
            this.f40262a.w = (int) motionEvent.getRawX();
            this.f40262a.x = (int) motionEvent.getRawY();
            this.f40262a.r = (int) motionEvent.getX();
            this.f40262a.s = (int) motionEvent.getY();
            this.f40262a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40262a.l);
            Math.abs(motionEvent.getY() - this.f40262a.m);
            if (System.currentTimeMillis() - this.f40262a.k < 2000) {
                p0 p0Var = this.f40262a;
                if (p0Var.j && (info = p0Var.f40296c) != null && R1.a(info, p0Var.f40301h)) {
                    this.f40262a.f40301h = System.currentTimeMillis();
                    p0 p0Var2 = this.f40262a;
                    Context context = p0Var2.f40294a;
                    String open = p0Var2.f40296c.getOpen();
                    p0 p0Var3 = this.f40262a;
                    R1.a(context, open, p0Var3.f40296c, p0Var3.f40300g, p0Var3.d().toString());
                    a1.a(this.f40262a.f40294a).a(new b1(this.f40262a.f40296c), (String) null).a("desc", this.f40262a.d().toString()).a();
                    p0 p0Var4 = this.f40262a;
                    G.a(p0Var4.f40296c, p0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f40262a.f40299f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
