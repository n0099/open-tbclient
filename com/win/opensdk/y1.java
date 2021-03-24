package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40113a;

    public y1(B1 b1) {
        this.f40113a = b1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40113a.j = true;
            this.f40113a.k = System.currentTimeMillis();
            this.f40113a.l = motionEvent.getX();
            this.f40113a.m = motionEvent.getY();
            this.f40113a.n = (int) motionEvent.getRawX();
            this.f40113a.o = (int) motionEvent.getRawY();
            this.f40113a.v = System.currentTimeMillis();
            this.f40113a.p = (int) motionEvent.getX();
            this.f40113a.q = (int) motionEvent.getY();
            B1.a(this.f40113a, view);
        } else if (action == 1) {
            this.f40113a.w = (int) motionEvent.getRawX();
            this.f40113a.x = (int) motionEvent.getRawY();
            this.f40113a.r = (int) motionEvent.getX();
            this.f40113a.s = (int) motionEvent.getY();
            this.f40113a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40113a.l);
            Math.abs(motionEvent.getY() - this.f40113a.m);
            if (System.currentTimeMillis() - this.f40113a.k < 2000) {
                B1 b1 = this.f40113a;
                if (b1.j && (info = b1.f39626c) != null && R1.a(info, b1.f39631h)) {
                    this.f40113a.f39631h = System.currentTimeMillis();
                    B1 b12 = this.f40113a;
                    Context context = b12.f39624a;
                    String open = b12.f39626c.getOpen();
                    B1 b13 = this.f40113a;
                    R1.a(context, open, b13.f39626c, b13.f39630g, b13.d().toString());
                    a1.a(this.f40113a.f39624a).a(new b1(this.f40113a.f39626c), (String) null).a("desc", this.f40113a.d().toString()).a();
                    B1 b14 = this.f40113a;
                    G.a(b14.f39626c, b14.d().toString());
                    r rVar = this.f40113a.f39629f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
