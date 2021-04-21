package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class A1 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40000a;

    /* renamed from: b  reason: collision with root package name */
    public int f40001b;

    /* renamed from: c  reason: collision with root package name */
    public long f40002c;

    /* renamed from: d  reason: collision with root package name */
    public int f40003d;

    /* renamed from: e  reason: collision with root package name */
    public int f40004e;

    /* renamed from: f  reason: collision with root package name */
    public long f40005f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ B1 f40006g;

    public A1(B1 b1) {
        this.f40006g = b1;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40000a));
        hashMap.put("dy", Integer.valueOf(this.f40001b));
        hashMap.put("dts", Long.valueOf(this.f40002c));
        hashMap.put("ux", Integer.valueOf(this.f40003d));
        hashMap.put("uy", Integer.valueOf(this.f40004e));
        hashMap.put("uts", Long.valueOf(this.f40005f));
        B1 b1 = this.f40006g;
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
            this.f40000a = (int) motionEvent.getRawX();
            this.f40001b = (int) motionEvent.getRawY();
            this.f40002c = System.currentTimeMillis();
            this.f40006g.p = (int) motionEvent.getX();
            this.f40006g.q = (int) motionEvent.getY();
            B1.a(this.f40006g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40003d = (int) motionEvent.getRawX();
            this.f40004e = (int) motionEvent.getRawY();
            this.f40005f = System.currentTimeMillis();
            this.f40006g.r = (int) motionEvent.getX();
            this.f40006g.s = (int) motionEvent.getY();
            B1 b1 = this.f40006g;
            Info info = b1.f40011c;
            if (info == null || !R1.a(info, b1.f40016h)) {
                return false;
            }
            this.f40006g.f40016h = System.currentTimeMillis();
            B1 b12 = this.f40006g;
            Context context = b12.f40009a;
            String open = b12.f40011c.getOpen();
            B1 b13 = this.f40006g;
            R1.a(context, open, b13.f40011c, b13.f40015g, a().toString());
            a1.a(this.f40006g.f40009a).a(new b1(this.f40006g.f40011c), (String) null).a("desc", a().toString()).a();
            G.a(this.f40006g.f40011c, a().toString());
            r rVar = this.f40006g.f40014f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
