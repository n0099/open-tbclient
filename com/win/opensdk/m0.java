package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f39972a;

    public m0(p0 p0Var) {
        this.f39972a = p0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39972a.j = true;
            this.f39972a.k = System.currentTimeMillis();
            this.f39972a.l = motionEvent.getX();
            this.f39972a.m = motionEvent.getY();
            this.f39972a.n = (int) motionEvent.getRawX();
            this.f39972a.o = (int) motionEvent.getRawY();
            this.f39972a.p = (int) motionEvent.getX();
            this.f39972a.q = (int) motionEvent.getY();
            this.f39972a.v = System.currentTimeMillis();
            p0.a(this.f39972a, view);
        } else if (action == 1) {
            this.f39972a.w = (int) motionEvent.getRawX();
            this.f39972a.x = (int) motionEvent.getRawY();
            this.f39972a.r = (int) motionEvent.getX();
            this.f39972a.s = (int) motionEvent.getY();
            this.f39972a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f39972a.l);
            Math.abs(motionEvent.getY() - this.f39972a.m);
            if (System.currentTimeMillis() - this.f39972a.k < 2000) {
                p0 p0Var = this.f39972a;
                if (p0Var.j && (info = p0Var.f40006c) != null && R1.a(info, p0Var.f40011h)) {
                    this.f39972a.f40011h = System.currentTimeMillis();
                    p0 p0Var2 = this.f39972a;
                    Context context = p0Var2.f40004a;
                    String open = p0Var2.f40006c.getOpen();
                    p0 p0Var3 = this.f39972a;
                    R1.a(context, open, p0Var3.f40006c, p0Var3.f40010g, p0Var3.d().toString());
                    a1.a(this.f39972a.f40004a).a(new b1(this.f39972a.f40006c), (String) null).a("desc", this.f39972a.d().toString()).a();
                    p0 p0Var4 = this.f39972a;
                    G.a(p0Var4.f40006c, p0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f39972a.f40009f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
