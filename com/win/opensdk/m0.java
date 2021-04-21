package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f40357a;

    public m0(p0 p0Var) {
        this.f40357a = p0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40357a.j = true;
            this.f40357a.k = System.currentTimeMillis();
            this.f40357a.l = motionEvent.getX();
            this.f40357a.m = motionEvent.getY();
            this.f40357a.n = (int) motionEvent.getRawX();
            this.f40357a.o = (int) motionEvent.getRawY();
            this.f40357a.p = (int) motionEvent.getX();
            this.f40357a.q = (int) motionEvent.getY();
            this.f40357a.v = System.currentTimeMillis();
            p0.a(this.f40357a, view);
        } else if (action == 1) {
            this.f40357a.w = (int) motionEvent.getRawX();
            this.f40357a.x = (int) motionEvent.getRawY();
            this.f40357a.r = (int) motionEvent.getX();
            this.f40357a.s = (int) motionEvent.getY();
            this.f40357a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40357a.l);
            Math.abs(motionEvent.getY() - this.f40357a.m);
            if (System.currentTimeMillis() - this.f40357a.k < 2000) {
                p0 p0Var = this.f40357a;
                if (p0Var.j && (info = p0Var.f40391c) != null && R1.a(info, p0Var.f40396h)) {
                    this.f40357a.f40396h = System.currentTimeMillis();
                    p0 p0Var2 = this.f40357a;
                    Context context = p0Var2.f40389a;
                    String open = p0Var2.f40391c.getOpen();
                    p0 p0Var3 = this.f40357a;
                    R1.a(context, open, p0Var3.f40391c, p0Var3.f40395g, p0Var3.d().toString());
                    a1.a(this.f40357a.f40389a).a(new b1(this.f40357a.f40391c), (String) null).a("desc", this.f40357a.d().toString()).a();
                    p0 p0Var4 = this.f40357a;
                    G.a(p0Var4.f40391c, p0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f40357a.f40394f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
