package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class f0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f40716a;

    public f0(i0 i0Var) {
        this.f40716a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40716a.j = true;
            this.f40716a.k = System.currentTimeMillis();
            this.f40716a.l = motionEvent.getX();
            this.f40716a.m = motionEvent.getY();
            this.f40716a.n = (int) motionEvent.getRawX();
            this.f40716a.o = (int) motionEvent.getRawY();
            this.f40716a.p = (int) motionEvent.getX();
            this.f40716a.q = (int) motionEvent.getY();
            this.f40716a.v = System.currentTimeMillis();
            i0.a(this.f40716a, view);
        } else if (action == 1) {
            this.f40716a.w = (int) motionEvent.getRawX();
            this.f40716a.x = (int) motionEvent.getRawY();
            this.f40716a.r = (int) motionEvent.getX();
            this.f40716a.s = (int) motionEvent.getY();
            this.f40716a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40716a.l);
            Math.abs(motionEvent.getY() - this.f40716a.m);
            if (System.currentTimeMillis() - this.f40716a.k < 2000) {
                i0 i0Var = this.f40716a;
                if (i0Var.j && (info = i0Var.f40735c) != null && o1.a(info, i0Var.f40740h)) {
                    this.f40716a.f40740h = System.currentTimeMillis();
                    i0 i0Var2 = this.f40716a;
                    Context context = i0Var2.f40733a;
                    String open = i0Var2.f40735c.getOpen();
                    i0 i0Var3 = this.f40716a;
                    o1.a(context, open, i0Var3.f40735c, i0Var3.f40739g, i0Var3.d().toString());
                    x0.a(this.f40716a.f40733a).a(new y0(this.f40716a.f40735c), (String) null).a("desc", this.f40716a.d().toString()).a();
                    i0 i0Var4 = this.f40716a;
                    z.a(i0Var4.f40735c, i0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f40716a.f40738f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
