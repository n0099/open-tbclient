package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class V0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f40750a;

    public V0(Y0 y0) {
        this.f40750a = y0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40750a.j = true;
            this.f40750a.k = System.currentTimeMillis();
            this.f40750a.l = motionEvent.getX();
            this.f40750a.m = motionEvent.getY();
            this.f40750a.n = (int) motionEvent.getRawX();
            this.f40750a.o = (int) motionEvent.getRawY();
            this.f40750a.v = System.currentTimeMillis();
            this.f40750a.p = (int) motionEvent.getX();
            this.f40750a.q = (int) motionEvent.getY();
            Y0.a(this.f40750a, view);
        } else if (action == 1) {
            this.f40750a.w = (int) motionEvent.getRawX();
            this.f40750a.x = (int) motionEvent.getRawY();
            this.f40750a.r = (int) motionEvent.getX();
            this.f40750a.s = (int) motionEvent.getY();
            this.f40750a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40750a.l);
            Math.abs(motionEvent.getY() - this.f40750a.m);
            if (System.currentTimeMillis() - this.f40750a.k < 2000) {
                Y0 y0 = this.f40750a;
                if (y0.j && (info = y0.f40765c) != null && o1.a(info, y0.f40770h)) {
                    this.f40750a.f40770h = System.currentTimeMillis();
                    Y0 y02 = this.f40750a;
                    Context context = y02.f40763a;
                    String open = y02.f40765c.getOpen();
                    Y0 y03 = this.f40750a;
                    o1.a(context, open, y03.f40765c, y03.f40769g, y03.d().toString());
                    x0.a(this.f40750a.f40763a).a(new y0(this.f40750a.f40765c), (String) null).a("desc", this.f40750a.d().toString()).a();
                    Y0 y04 = this.f40750a;
                    z.a(y04.f40765c, y04.d().toString());
                    r rVar = this.f40750a.f40768f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
