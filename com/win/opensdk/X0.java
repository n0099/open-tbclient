package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class X0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f36974a;

    /* renamed from: b  reason: collision with root package name */
    public int f36975b;

    /* renamed from: c  reason: collision with root package name */
    public long f36976c;

    /* renamed from: d  reason: collision with root package name */
    public int f36977d;

    /* renamed from: e  reason: collision with root package name */
    public int f36978e;

    /* renamed from: f  reason: collision with root package name */
    public long f36979f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f36980g;

    public X0(Y0 y0) {
        this.f36980g = y0;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f36974a));
        hashMap.put("dy", Integer.valueOf(this.f36975b));
        hashMap.put("dts", Long.valueOf(this.f36976c));
        hashMap.put("ux", Integer.valueOf(this.f36977d));
        hashMap.put("uy", Integer.valueOf(this.f36978e));
        hashMap.put("uts", Long.valueOf(this.f36979f));
        Y0 y0 = this.f36980g;
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
            this.f36974a = (int) motionEvent.getRawX();
            this.f36975b = (int) motionEvent.getRawY();
            this.f36976c = System.currentTimeMillis();
            this.f36980g.p = (int) motionEvent.getX();
            this.f36980g.q = (int) motionEvent.getY();
            Y0.a(this.f36980g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f36977d = (int) motionEvent.getRawX();
            this.f36978e = (int) motionEvent.getRawY();
            this.f36979f = System.currentTimeMillis();
            this.f36980g.r = (int) motionEvent.getX();
            this.f36980g.s = (int) motionEvent.getY();
            Y0 y0 = this.f36980g;
            Info info = y0.f36983c;
            if (info == null || !o1.a(info, y0.f36988h)) {
                return false;
            }
            this.f36980g.f36988h = System.currentTimeMillis();
            Y0 y02 = this.f36980g;
            Context context = y02.f36981a;
            String open = y02.f36983c.getOpen();
            Y0 y03 = this.f36980g;
            o1.a(context, open, y03.f36983c, y03.f36987g, a().toString());
            x0.a(this.f36980g.f36981a).a(new y0(this.f36980g.f36983c), (String) null).a("desc", a().toString()).a();
            z.a(this.f36980g.f36983c, a().toString());
            r rVar = this.f36980g.f36986f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
