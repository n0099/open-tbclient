package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class V0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f37039a;

    public V0(Y0 y0) {
        this.f37039a = y0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37039a.j = true;
            this.f37039a.k = System.currentTimeMillis();
            this.f37039a.l = motionEvent.getX();
            this.f37039a.m = motionEvent.getY();
            this.f37039a.n = (int) motionEvent.getRawX();
            this.f37039a.o = (int) motionEvent.getRawY();
            this.f37039a.v = System.currentTimeMillis();
            this.f37039a.p = (int) motionEvent.getX();
            this.f37039a.q = (int) motionEvent.getY();
            Y0.a(this.f37039a, view);
        } else if (action == 1) {
            this.f37039a.w = (int) motionEvent.getRawX();
            this.f37039a.x = (int) motionEvent.getRawY();
            this.f37039a.r = (int) motionEvent.getX();
            this.f37039a.s = (int) motionEvent.getY();
            this.f37039a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f37039a.l);
            Math.abs(motionEvent.getY() - this.f37039a.m);
            if (System.currentTimeMillis() - this.f37039a.k < 2000) {
                Y0 y0 = this.f37039a;
                if (y0.j && (info = y0.f37054c) != null && o1.a(info, y0.f37059h)) {
                    this.f37039a.f37059h = System.currentTimeMillis();
                    Y0 y02 = this.f37039a;
                    Context context = y02.f37052a;
                    String open = y02.f37054c.getOpen();
                    Y0 y03 = this.f37039a;
                    o1.a(context, open, y03.f37054c, y03.f37058g, y03.d().toString());
                    x0.a(this.f37039a.f37052a).a(new y0(this.f37039a.f37054c), (String) null).a("desc", this.f37039a.d().toString()).a();
                    Y0 y04 = this.f37039a;
                    z.a(y04.f37054c, y04.d().toString());
                    r rVar = this.f37039a.f37057f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
