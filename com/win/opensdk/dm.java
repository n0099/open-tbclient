package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class dm implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dv f8153a;

    public dm(dv dvVar) {
        this.f8153a = dvVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Info info;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8153a.j = true;
            this.f8153a.k = System.currentTimeMillis();
            this.f8153a.l = motionEvent.getX();
            this.f8153a.m = motionEvent.getY();
            this.f8153a.n = (int) motionEvent.getRawX();
            this.f8153a.o = (int) motionEvent.getRawY();
            this.f8153a.p = (int) motionEvent.getX();
            this.f8153a.q = (int) motionEvent.getY();
            this.f8153a.v = System.currentTimeMillis();
            dv.a(this.f8153a, view);
        } else if (action == 1) {
            this.f8153a.w = (int) motionEvent.getRawX();
            this.f8153a.x = (int) motionEvent.getRawY();
            this.f8153a.r = (int) motionEvent.getX();
            this.f8153a.s = (int) motionEvent.getY();
            this.f8153a.y = System.currentTimeMillis();
            Math.abs(motionEvent.getX() - this.f8153a.l);
            Math.abs(motionEvent.getY() - this.f8153a.m);
            if (System.currentTimeMillis() - this.f8153a.k < 2000) {
                dv dvVar = this.f8153a;
                if (dvVar.j && (info = dvVar.qkh) != null && bf.a(info, dvVar.h)) {
                    this.f8153a.h = System.currentTimeMillis();
                    dv dvVar2 = this.f8153a;
                    Context context = dvVar2.f8159a;
                    String open = dvVar2.qkh.getOpen();
                    dv dvVar3 = this.f8153a;
                    bf.a(context, open, dvVar3.qkh, dvVar3.qlY, dvVar3.d().toString());
                    ca.iT(this.f8153a.f8159a).a(new cd(this.f8153a.qkh), (String) null).hD("desc", this.f8153a.d().toString()).a();
                    dv dvVar4 = this.f8153a;
                    v.a(dvVar4.qkh, dvVar4.d().toString());
                    PBNativeListener pBNativeListener = this.f8153a.qlX;
                    if (pBNativeListener != null) {
                        pBNativeListener.onClicked();
                    }
                }
            }
        }
        return true;
    }
}
