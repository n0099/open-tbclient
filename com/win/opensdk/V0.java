package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class V0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f40647a;

    public V0(Y0 y0) {
        this.f40647a = y0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40647a.j = true;
            this.f40647a.k = System.currentTimeMillis();
            this.f40647a.l = motionEvent.getX();
            this.f40647a.m = motionEvent.getY();
            this.f40647a.n = (int) motionEvent.getRawX();
            this.f40647a.o = (int) motionEvent.getRawY();
            this.f40647a.v = System.currentTimeMillis();
            this.f40647a.p = (int) motionEvent.getX();
            this.f40647a.q = (int) motionEvent.getY();
            Y0.a(this.f40647a, view);
        } else if (action == 1) {
            this.f40647a.w = (int) motionEvent.getRawX();
            this.f40647a.x = (int) motionEvent.getRawY();
            this.f40647a.r = (int) motionEvent.getX();
            this.f40647a.s = (int) motionEvent.getY();
            this.f40647a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f40647a.l);
            Math.abs(motionEvent.getY() - this.f40647a.m);
            if (System.currentTimeMillis() - this.f40647a.k < 2000) {
                Y0 y0 = this.f40647a;
                if (y0.j && (info = y0.f40662c) != null && o1.a(info, y0.f40667h)) {
                    this.f40647a.f40667h = System.currentTimeMillis();
                    Y0 y02 = this.f40647a;
                    Context context = y02.f40660a;
                    String open = y02.f40662c.getOpen();
                    Y0 y03 = this.f40647a;
                    o1.a(context, open, y03.f40662c, y03.f40666g, y03.d().toString());
                    x0.a(this.f40647a.f40660a).a(new y0(this.f40647a.f40662c), (String) null).a("desc", this.f40647a.d().toString()).a();
                    Y0 y04 = this.f40647a;
                    z.a(y04.f40662c, y04.d().toString());
                    r rVar = this.f40647a.f40665f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
