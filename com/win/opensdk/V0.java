package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class V0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f37794a;

    public V0(Y0 y0) {
        this.f37794a = y0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37794a.j = true;
            this.f37794a.k = System.currentTimeMillis();
            this.f37794a.l = motionEvent.getX();
            this.f37794a.m = motionEvent.getY();
            this.f37794a.n = (int) motionEvent.getRawX();
            this.f37794a.o = (int) motionEvent.getRawY();
            this.f37794a.v = System.currentTimeMillis();
            this.f37794a.p = (int) motionEvent.getX();
            this.f37794a.q = (int) motionEvent.getY();
            Y0.a(this.f37794a, view);
        } else if (action == 1) {
            this.f37794a.w = (int) motionEvent.getRawX();
            this.f37794a.x = (int) motionEvent.getRawY();
            this.f37794a.r = (int) motionEvent.getX();
            this.f37794a.s = (int) motionEvent.getY();
            this.f37794a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f37794a.l);
            Math.abs(motionEvent.getY() - this.f37794a.m);
            if (System.currentTimeMillis() - this.f37794a.k < 2000) {
                Y0 y0 = this.f37794a;
                if (y0.j && (info = y0.f37809c) != null && o1.a(info, y0.f37814h)) {
                    this.f37794a.f37814h = System.currentTimeMillis();
                    Y0 y02 = this.f37794a;
                    Context context = y02.f37807a;
                    String open = y02.f37809c.getOpen();
                    Y0 y03 = this.f37794a;
                    o1.a(context, open, y03.f37809c, y03.f37813g, y03.d().toString());
                    x0.a(this.f37794a.f37807a).a(new y0(this.f37794a.f37809c), (String) null).a("desc", this.f37794a.d().toString()).a();
                    Y0 y04 = this.f37794a;
                    z.a(y04.f37809c, y04.d().toString());
                    r rVar = this.f37794a.f37812f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
