package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class f0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37037a;

    public f0(i0 i0Var) {
        this.f37037a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37037a.j = true;
            this.f37037a.k = System.currentTimeMillis();
            this.f37037a.l = motionEvent.getX();
            this.f37037a.m = motionEvent.getY();
            this.f37037a.n = (int) motionEvent.getRawX();
            this.f37037a.o = (int) motionEvent.getRawY();
            this.f37037a.p = (int) motionEvent.getX();
            this.f37037a.q = (int) motionEvent.getY();
            this.f37037a.v = System.currentTimeMillis();
            i0.a(this.f37037a, view);
        } else if (action == 1) {
            this.f37037a.w = (int) motionEvent.getRawX();
            this.f37037a.x = (int) motionEvent.getRawY();
            this.f37037a.r = (int) motionEvent.getX();
            this.f37037a.s = (int) motionEvent.getY();
            this.f37037a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f37037a.l);
            Math.abs(motionEvent.getY() - this.f37037a.m);
            if (System.currentTimeMillis() - this.f37037a.k < 2000) {
                i0 i0Var = this.f37037a;
                if (i0Var.j && (info = i0Var.f37056c) != null && o1.a(info, i0Var.f37061h)) {
                    this.f37037a.f37061h = System.currentTimeMillis();
                    i0 i0Var2 = this.f37037a;
                    Context context = i0Var2.f37054a;
                    String open = i0Var2.f37056c.getOpen();
                    i0 i0Var3 = this.f37037a;
                    o1.a(context, open, i0Var3.f37056c, i0Var3.f37060g, i0Var3.d().toString());
                    x0.a(this.f37037a.f37054a).a(new y0(this.f37037a.f37056c), (String) null).a("desc", this.f37037a.d().toString()).a();
                    i0 i0Var4 = this.f37037a;
                    z.a(i0Var4.f37056c, i0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f37037a.f37059f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
