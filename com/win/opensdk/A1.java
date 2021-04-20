package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class A1 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f39905a;

    /* renamed from: b  reason: collision with root package name */
    public int f39906b;

    /* renamed from: c  reason: collision with root package name */
    public long f39907c;

    /* renamed from: d  reason: collision with root package name */
    public int f39908d;

    /* renamed from: e  reason: collision with root package name */
    public int f39909e;

    /* renamed from: f  reason: collision with root package name */
    public long f39910f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ B1 f39911g;

    public A1(B1 b1) {
        this.f39911g = b1;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f39905a));
        hashMap.put("dy", Integer.valueOf(this.f39906b));
        hashMap.put("dts", Long.valueOf(this.f39907c));
        hashMap.put("ux", Integer.valueOf(this.f39908d));
        hashMap.put("uy", Integer.valueOf(this.f39909e));
        hashMap.put("uts", Long.valueOf(this.f39910f));
        B1 b1 = this.f39911g;
        G.a(hashMap, b1.p, b1.q, b1.r, b1.s, b1.t, b1.u);
        return hashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39905a = (int) motionEvent.getRawX();
            this.f39906b = (int) motionEvent.getRawY();
            this.f39907c = System.currentTimeMillis();
            this.f39911g.p = (int) motionEvent.getX();
            this.f39911g.q = (int) motionEvent.getY();
            B1.a(this.f39911g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f39908d = (int) motionEvent.getRawX();
            this.f39909e = (int) motionEvent.getRawY();
            this.f39910f = System.currentTimeMillis();
            this.f39911g.r = (int) motionEvent.getX();
            this.f39911g.s = (int) motionEvent.getY();
            B1 b1 = this.f39911g;
            Info info = b1.f39916c;
            if (info == null || !R1.a(info, b1.f39921h)) {
                return false;
            }
            this.f39911g.f39921h = System.currentTimeMillis();
            B1 b12 = this.f39911g;
            Context context = b12.f39914a;
            String open = b12.f39916c.getOpen();
            B1 b13 = this.f39911g;
            R1.a(context, open, b13.f39916c, b13.f39920g, a().toString());
            a1.a(this.f39911g.f39914a).a(new b1(this.f39911g.f39916c), (String) null).a("desc", a().toString()).a();
            G.a(this.f39911g.f39916c, a().toString());
            r rVar = this.f39911g.f39919f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
