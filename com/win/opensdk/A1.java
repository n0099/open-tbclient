package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class A1 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f39616a;

    /* renamed from: b  reason: collision with root package name */
    public int f39617b;

    /* renamed from: c  reason: collision with root package name */
    public long f39618c;

    /* renamed from: d  reason: collision with root package name */
    public int f39619d;

    /* renamed from: e  reason: collision with root package name */
    public int f39620e;

    /* renamed from: f  reason: collision with root package name */
    public long f39621f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ B1 f39622g;

    public A1(B1 b1) {
        this.f39622g = b1;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f39616a));
        hashMap.put("dy", Integer.valueOf(this.f39617b));
        hashMap.put("dts", Long.valueOf(this.f39618c));
        hashMap.put("ux", Integer.valueOf(this.f39619d));
        hashMap.put("uy", Integer.valueOf(this.f39620e));
        hashMap.put("uts", Long.valueOf(this.f39621f));
        B1 b1 = this.f39622g;
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
            this.f39616a = (int) motionEvent.getRawX();
            this.f39617b = (int) motionEvent.getRawY();
            this.f39618c = System.currentTimeMillis();
            this.f39622g.p = (int) motionEvent.getX();
            this.f39622g.q = (int) motionEvent.getY();
            B1.a(this.f39622g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f39619d = (int) motionEvent.getRawX();
            this.f39620e = (int) motionEvent.getRawY();
            this.f39621f = System.currentTimeMillis();
            this.f39622g.r = (int) motionEvent.getX();
            this.f39622g.s = (int) motionEvent.getY();
            B1 b1 = this.f39622g;
            Info info = b1.f39627c;
            if (info == null || !R1.a(info, b1.f39632h)) {
                return false;
            }
            this.f39622g.f39632h = System.currentTimeMillis();
            B1 b12 = this.f39622g;
            Context context = b12.f39625a;
            String open = b12.f39627c.getOpen();
            B1 b13 = this.f39622g;
            R1.a(context, open, b13.f39627c, b13.f39631g, a().toString());
            a1.a(this.f39622g.f39625a).a(new b1(this.f39622g.f39627c), (String) null).a("desc", a().toString()).a();
            G.a(this.f39622g.f39627c, a().toString());
            r rVar = this.f39622g.f39630f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
