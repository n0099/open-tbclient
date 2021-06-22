package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class f0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f40819a;

    public f0(i0 i0Var) {
        this.f40819a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40819a.j = true;
            this.f40819a.k = System.currentTimeMillis();
            this.f40819a.l = motionEvent.getX();
            this.f40819a.m = motionEvent.getY();
            this.f40819a.n = (int) motionEvent.getRawX();
            this.f40819a.o = (int) motionEvent.getRawY();
            this.f40819a.p = (int) motionEvent.getX();
            this.f40819a.q = (int) motionEvent.getY();
            this.f40819a.v = System.currentTimeMillis();
            i0.a(this.f40819a, view);
        } else if (action == 1) {
            this.f40819a.w = (int) motionEvent.getRawX();
            this.f40819a.x = (int) motionEvent.getRawY();
            this.f40819a.r = (int) motionEvent.getX();
            this.f40819a.s = (int) motionEvent.getY();
            this.f40819a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40819a.l);
            Math.abs(motionEvent.getY() - this.f40819a.m);
            if (System.currentTimeMillis() - this.f40819a.k < 2000) {
                i0 i0Var = this.f40819a;
                if (i0Var.j && (info = i0Var.f40838c) != null && o1.a(info, i0Var.f40843h)) {
                    this.f40819a.f40843h = System.currentTimeMillis();
                    i0 i0Var2 = this.f40819a;
                    Context context = i0Var2.f40836a;
                    String open = i0Var2.f40838c.getOpen();
                    i0 i0Var3 = this.f40819a;
                    o1.a(context, open, i0Var3.f40838c, i0Var3.f40842g, i0Var3.d().toString());
                    x0.a(this.f40819a.f40836a).a(new y0(this.f40819a.f40838c), (String) null).a("desc", this.f40819a.d().toString()).a();
                    i0 i0Var4 = this.f40819a;
                    z.a(i0Var4.f40838c, i0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f40819a.f40841f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
