package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40498a;

    public y1(B1 b1) {
        this.f40498a = b1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40498a.j = true;
            this.f40498a.k = System.currentTimeMillis();
            this.f40498a.l = motionEvent.getX();
            this.f40498a.m = motionEvent.getY();
            this.f40498a.n = (int) motionEvent.getRawX();
            this.f40498a.o = (int) motionEvent.getRawY();
            this.f40498a.v = System.currentTimeMillis();
            this.f40498a.p = (int) motionEvent.getX();
            this.f40498a.q = (int) motionEvent.getY();
            B1.a(this.f40498a, view);
        } else if (action == 1) {
            this.f40498a.w = (int) motionEvent.getRawX();
            this.f40498a.x = (int) motionEvent.getRawY();
            this.f40498a.r = (int) motionEvent.getX();
            this.f40498a.s = (int) motionEvent.getY();
            this.f40498a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40498a.l);
            Math.abs(motionEvent.getY() - this.f40498a.m);
            if (System.currentTimeMillis() - this.f40498a.k < 2000) {
                B1 b1 = this.f40498a;
                if (b1.j && (info = b1.f40011c) != null && R1.a(info, b1.f40016h)) {
                    this.f40498a.f40016h = System.currentTimeMillis();
                    B1 b12 = this.f40498a;
                    Context context = b12.f40009a;
                    String open = b12.f40011c.getOpen();
                    B1 b13 = this.f40498a;
                    R1.a(context, open, b13.f40011c, b13.f40015g, b13.d().toString());
                    a1.a(this.f40498a.f40009a).a(new b1(this.f40498a.f40011c), (String) null).a("desc", this.f40498a.d().toString()).a();
                    B1 b14 = this.f40498a;
                    G.a(b14.f40011c, b14.d().toString());
                    r rVar = this.f40498a.f40014f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
