package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class V0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f36968a;

    public V0(Y0 y0) {
        this.f36968a = y0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f36968a.j = true;
            this.f36968a.k = System.currentTimeMillis();
            this.f36968a.l = motionEvent.getX();
            this.f36968a.m = motionEvent.getY();
            this.f36968a.n = (int) motionEvent.getRawX();
            this.f36968a.o = (int) motionEvent.getRawY();
            this.f36968a.v = System.currentTimeMillis();
            this.f36968a.p = (int) motionEvent.getX();
            this.f36968a.q = (int) motionEvent.getY();
            Y0.a(this.f36968a, view);
        } else if (action == 1) {
            this.f36968a.w = (int) motionEvent.getRawX();
            this.f36968a.x = (int) motionEvent.getRawY();
            this.f36968a.r = (int) motionEvent.getX();
            this.f36968a.s = (int) motionEvent.getY();
            this.f36968a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f36968a.l);
            Math.abs(motionEvent.getY() - this.f36968a.m);
            if (System.currentTimeMillis() - this.f36968a.k < 2000) {
                Y0 y0 = this.f36968a;
                if (y0.j && (info = y0.f36983c) != null && o1.a(info, y0.f36988h)) {
                    this.f36968a.f36988h = System.currentTimeMillis();
                    Y0 y02 = this.f36968a;
                    Context context = y02.f36981a;
                    String open = y02.f36983c.getOpen();
                    Y0 y03 = this.f36968a;
                    o1.a(context, open, y03.f36983c, y03.f36987g, y03.d().toString());
                    x0.a(this.f36968a.f36981a).a(new y0(this.f36968a.f36983c), (String) null).a("desc", this.f36968a.d().toString()).a();
                    Y0 y04 = this.f36968a;
                    z.a(y04.f36983c, y04.d().toString());
                    r rVar = this.f36968a.f36986f;
                    if (rVar != null) {
                        rVar.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
