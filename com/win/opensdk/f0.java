package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class f0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37863a;

    public f0(i0 i0Var) {
        this.f37863a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37863a.j = true;
            this.f37863a.k = System.currentTimeMillis();
            this.f37863a.l = motionEvent.getX();
            this.f37863a.m = motionEvent.getY();
            this.f37863a.n = (int) motionEvent.getRawX();
            this.f37863a.o = (int) motionEvent.getRawY();
            this.f37863a.p = (int) motionEvent.getX();
            this.f37863a.q = (int) motionEvent.getY();
            this.f37863a.v = System.currentTimeMillis();
            i0.a(this.f37863a, view);
        } else if (action == 1) {
            this.f37863a.w = (int) motionEvent.getRawX();
            this.f37863a.x = (int) motionEvent.getRawY();
            this.f37863a.r = (int) motionEvent.getX();
            this.f37863a.s = (int) motionEvent.getY();
            this.f37863a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f37863a.l);
            Math.abs(motionEvent.getY() - this.f37863a.m);
            if (System.currentTimeMillis() - this.f37863a.k < 2000) {
                i0 i0Var = this.f37863a;
                if (i0Var.j && (info = i0Var.f37882c) != null && o1.a(info, i0Var.f37887h)) {
                    this.f37863a.f37887h = System.currentTimeMillis();
                    i0 i0Var2 = this.f37863a;
                    Context context = i0Var2.f37880a;
                    String open = i0Var2.f37882c.getOpen();
                    i0 i0Var3 = this.f37863a;
                    o1.a(context, open, i0Var3.f37882c, i0Var3.f37886g, i0Var3.d().toString());
                    x0.a(this.f37863a.f37880a).a(new y0(this.f37863a.f37882c), (String) null).a("desc", this.f37863a.d().toString()).a();
                    i0 i0Var4 = this.f37863a;
                    z.a(i0Var4.f37882c, i0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f37863a.f37885f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
