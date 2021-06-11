package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class X0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40653a;

    /* renamed from: b  reason: collision with root package name */
    public int f40654b;

    /* renamed from: c  reason: collision with root package name */
    public long f40655c;

    /* renamed from: d  reason: collision with root package name */
    public int f40656d;

    /* renamed from: e  reason: collision with root package name */
    public int f40657e;

    /* renamed from: f  reason: collision with root package name */
    public long f40658f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f40659g;

    public X0(Y0 y0) {
        this.f40659g = y0;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40653a));
        hashMap.put("dy", Integer.valueOf(this.f40654b));
        hashMap.put("dts", Long.valueOf(this.f40655c));
        hashMap.put("ux", Integer.valueOf(this.f40656d));
        hashMap.put("uy", Integer.valueOf(this.f40657e));
        hashMap.put("uts", Long.valueOf(this.f40658f));
        Y0 y0 = this.f40659g;
        z.a(hashMap, y0.p, y0.q, y0.r, y0.s, y0.t, y0.u);
        return hashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40653a = (int) motionEvent.getRawX();
            this.f40654b = (int) motionEvent.getRawY();
            this.f40655c = System.currentTimeMillis();
            this.f40659g.p = (int) motionEvent.getX();
            this.f40659g.q = (int) motionEvent.getY();
            Y0.a(this.f40659g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40656d = (int) motionEvent.getRawX();
            this.f40657e = (int) motionEvent.getRawY();
            this.f40658f = System.currentTimeMillis();
            this.f40659g.r = (int) motionEvent.getX();
            this.f40659g.s = (int) motionEvent.getY();
            Y0 y0 = this.f40659g;
            Info info = y0.f40662c;
            if (info == null || !o1.a(info, y0.f40667h)) {
                return false;
            }
            this.f40659g.f40667h = System.currentTimeMillis();
            Y0 y02 = this.f40659g;
            Context context = y02.f40660a;
            String open = y02.f40662c.getOpen();
            Y0 y03 = this.f40659g;
            o1.a(context, open, y03.f40662c, y03.f40666g, a().toString());
            x0.a(this.f40659g.f40660a).a(new y0(this.f40659g.f40662c), (String) null).a("desc", a().toString()).a();
            z.a(this.f40659g.f40662c, a().toString());
            r rVar = this.f40659g.f40665f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
