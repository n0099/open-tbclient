package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class A1 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f39615a;

    /* renamed from: b  reason: collision with root package name */
    public int f39616b;

    /* renamed from: c  reason: collision with root package name */
    public long f39617c;

    /* renamed from: d  reason: collision with root package name */
    public int f39618d;

    /* renamed from: e  reason: collision with root package name */
    public int f39619e;

    /* renamed from: f  reason: collision with root package name */
    public long f39620f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ B1 f39621g;

    public A1(B1 b1) {
        this.f39621g = b1;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f39615a));
        hashMap.put("dy", Integer.valueOf(this.f39616b));
        hashMap.put("dts", Long.valueOf(this.f39617c));
        hashMap.put("ux", Integer.valueOf(this.f39618d));
        hashMap.put("uy", Integer.valueOf(this.f39619e));
        hashMap.put("uts", Long.valueOf(this.f39620f));
        B1 b1 = this.f39621g;
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
            this.f39615a = (int) motionEvent.getRawX();
            this.f39616b = (int) motionEvent.getRawY();
            this.f39617c = System.currentTimeMillis();
            this.f39621g.p = (int) motionEvent.getX();
            this.f39621g.q = (int) motionEvent.getY();
            B1.a(this.f39621g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f39618d = (int) motionEvent.getRawX();
            this.f39619e = (int) motionEvent.getRawY();
            this.f39620f = System.currentTimeMillis();
            this.f39621g.r = (int) motionEvent.getX();
            this.f39621g.s = (int) motionEvent.getY();
            B1 b1 = this.f39621g;
            Info info = b1.f39626c;
            if (info == null || !R1.a(info, b1.f39631h)) {
                return false;
            }
            this.f39621g.f39631h = System.currentTimeMillis();
            B1 b12 = this.f39621g;
            Context context = b12.f39624a;
            String open = b12.f39626c.getOpen();
            B1 b13 = this.f39621g;
            R1.a(context, open, b13.f39626c, b13.f39630g, a().toString());
            a1.a(this.f39621g.f39624a).a(new b1(this.f39621g.f39626c), (String) null).a("desc", a().toString()).a();
            G.a(this.f39621g.f39626c, a().toString());
            r rVar = this.f39621g.f39629f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
