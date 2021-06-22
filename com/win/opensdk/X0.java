package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class X0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f40756a;

    /* renamed from: b  reason: collision with root package name */
    public int f40757b;

    /* renamed from: c  reason: collision with root package name */
    public long f40758c;

    /* renamed from: d  reason: collision with root package name */
    public int f40759d;

    /* renamed from: e  reason: collision with root package name */
    public int f40760e;

    /* renamed from: f  reason: collision with root package name */
    public long f40761f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f40762g;

    public X0(Y0 y0) {
        this.f40762g = y0;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40756a));
        hashMap.put("dy", Integer.valueOf(this.f40757b));
        hashMap.put("dts", Long.valueOf(this.f40758c));
        hashMap.put("ux", Integer.valueOf(this.f40759d));
        hashMap.put("uy", Integer.valueOf(this.f40760e));
        hashMap.put("uts", Long.valueOf(this.f40761f));
        Y0 y0 = this.f40762g;
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
            this.f40756a = (int) motionEvent.getRawX();
            this.f40757b = (int) motionEvent.getRawY();
            this.f40758c = System.currentTimeMillis();
            this.f40762g.p = (int) motionEvent.getX();
            this.f40762g.q = (int) motionEvent.getY();
            Y0.a(this.f40762g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f40759d = (int) motionEvent.getRawX();
            this.f40760e = (int) motionEvent.getRawY();
            this.f40761f = System.currentTimeMillis();
            this.f40762g.r = (int) motionEvent.getX();
            this.f40762g.s = (int) motionEvent.getY();
            Y0 y0 = this.f40762g;
            Info info = y0.f40765c;
            if (info == null || !o1.a(info, y0.f40770h)) {
                return false;
            }
            this.f40762g.f40770h = System.currentTimeMillis();
            Y0 y02 = this.f40762g;
            Context context = y02.f40763a;
            String open = y02.f40765c.getOpen();
            Y0 y03 = this.f40762g;
            o1.a(context, open, y03.f40765c, y03.f40769g, a().toString());
            x0.a(this.f40762g.f40763a).a(new y0(this.f40762g.f40765c), (String) null).a("desc", a().toString()).a();
            z.a(this.f40762g.f40765c, a().toString());
            r rVar = this.f40762g.f40768f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
