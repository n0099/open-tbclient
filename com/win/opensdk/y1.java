package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40114a;

    public y1(B1 b1) {
        this.f40114a = b1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40114a.j = true;
            this.f40114a.k = System.currentTimeMillis();
            this.f40114a.l = motionEvent.getX();
            this.f40114a.m = motionEvent.getY();
            this.f40114a.n = (int) motionEvent.getRawX();
            this.f40114a.o = (int) motionEvent.getRawY();
            this.f40114a.v = System.currentTimeMillis();
            this.f40114a.p = (int) motionEvent.getX();
            this.f40114a.q = (int) motionEvent.getY();
            B1.a(this.f40114a, view);
        } else if (action == 1) {
            this.f40114a.w = (int) motionEvent.getRawX();
            this.f40114a.x = (int) motionEvent.getRawY();
            this.f40114a.r = (int) motionEvent.getX();
            this.f40114a.s = (int) motionEvent.getY();
            this.f40114a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40114a.l);
            Math.abs(motionEvent.getY() - this.f40114a.m);
            if (System.currentTimeMillis() - this.f40114a.k < 2000) {
                B1 b1 = this.f40114a;
                if (b1.j && (info = b1.f39627c) != null && R1.a(info, b1.f39632h)) {
                    this.f40114a.f39632h = System.currentTimeMillis();
                    B1 b12 = this.f40114a;
                    Context context = b12.f39625a;
                    String open = b12.f39627c.getOpen();
                    B1 b13 = this.f40114a;
                    R1.a(context, open, b13.f39627c, b13.f39631g, b13.d().toString());
                    a1.a(this.f40114a.f39625a).a(new b1(this.f40114a.f39627c), (String) null).a("desc", this.f40114a.d().toString()).a();
                    B1 b14 = this.f40114a;
                    G.a(b14.f39627c, b14.d().toString());
                    r rVar = this.f40114a.f39630f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
