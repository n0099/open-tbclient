package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class f0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37108a;

    public f0(i0 i0Var) {
        this.f37108a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37108a.j = true;
            this.f37108a.k = System.currentTimeMillis();
            this.f37108a.l = motionEvent.getX();
            this.f37108a.m = motionEvent.getY();
            this.f37108a.n = (int) motionEvent.getRawX();
            this.f37108a.o = (int) motionEvent.getRawY();
            this.f37108a.p = (int) motionEvent.getX();
            this.f37108a.q = (int) motionEvent.getY();
            this.f37108a.v = System.currentTimeMillis();
            i0.a(this.f37108a, view);
        } else if (action == 1) {
            this.f37108a.w = (int) motionEvent.getRawX();
            this.f37108a.x = (int) motionEvent.getRawY();
            this.f37108a.r = (int) motionEvent.getX();
            this.f37108a.s = (int) motionEvent.getY();
            this.f37108a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f37108a.l);
            Math.abs(motionEvent.getY() - this.f37108a.m);
            if (System.currentTimeMillis() - this.f37108a.k < 2000) {
                i0 i0Var = this.f37108a;
                if (i0Var.j && (info = i0Var.f37127c) != null && o1.a(info, i0Var.f37132h)) {
                    this.f37108a.f37132h = System.currentTimeMillis();
                    i0 i0Var2 = this.f37108a;
                    Context context = i0Var2.f37125a;
                    String open = i0Var2.f37127c.getOpen();
                    i0 i0Var3 = this.f37108a;
                    o1.a(context, open, i0Var3.f37127c, i0Var3.f37131g, i0Var3.d().toString());
                    x0.a(this.f37108a.f37125a).a(new y0(this.f37108a.f37127c), (String) null).a("desc", this.f37108a.d().toString()).a();
                    i0 i0Var4 = this.f37108a;
                    z.a(i0Var4.f37127c, i0Var4.d().toString());
                    PBNativeListener pBNativeListener = this.f37108a.f37130f;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
