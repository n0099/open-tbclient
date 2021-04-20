package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40403a;

    public y1(B1 b1) {
        this.f40403a = b1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40403a.j = true;
            this.f40403a.k = System.currentTimeMillis();
            this.f40403a.l = motionEvent.getX();
            this.f40403a.m = motionEvent.getY();
            this.f40403a.n = (int) motionEvent.getRawX();
            this.f40403a.o = (int) motionEvent.getRawY();
            this.f40403a.v = System.currentTimeMillis();
            this.f40403a.p = (int) motionEvent.getX();
            this.f40403a.q = (int) motionEvent.getY();
            B1.a(this.f40403a, view);
        } else if (action == 1) {
            this.f40403a.w = (int) motionEvent.getRawX();
            this.f40403a.x = (int) motionEvent.getRawY();
            this.f40403a.r = (int) motionEvent.getX();
            this.f40403a.s = (int) motionEvent.getY();
            this.f40403a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40403a.l);
            Math.abs(motionEvent.getY() - this.f40403a.m);
            if (System.currentTimeMillis() - this.f40403a.k < 2000) {
                B1 b1 = this.f40403a;
                if (b1.j && (info = b1.f39916c) != null && R1.a(info, b1.f39921h)) {
                    this.f40403a.f39921h = System.currentTimeMillis();
                    B1 b12 = this.f40403a;
                    Context context = b12.f39914a;
                    String open = b12.f39916c.getOpen();
                    B1 b13 = this.f40403a;
                    R1.a(context, open, b13.f39916c, b13.f39920g, b13.d().toString());
                    a1.a(this.f40403a.f39914a).a(new b1(this.f40403a.f39916c), (String) null).a("desc", this.f40403a.d().toString()).a();
                    B1 b14 = this.f40403a;
                    G.a(b14.f39916c, b14.d().toString());
                    r rVar = this.f40403a.f39919f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
