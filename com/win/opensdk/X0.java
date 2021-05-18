package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class X0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f37045a;

    /* renamed from: b  reason: collision with root package name */
    public int f37046b;

    /* renamed from: c  reason: collision with root package name */
    public long f37047c;

    /* renamed from: d  reason: collision with root package name */
    public int f37048d;

    /* renamed from: e  reason: collision with root package name */
    public int f37049e;

    /* renamed from: f  reason: collision with root package name */
    public long f37050f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f37051g;

    public X0(Y0 y0) {
        this.f37051g = y0;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f37045a));
        hashMap.put("dy", Integer.valueOf(this.f37046b));
        hashMap.put("dts", Long.valueOf(this.f37047c));
        hashMap.put("ux", Integer.valueOf(this.f37048d));
        hashMap.put("uy", Integer.valueOf(this.f37049e));
        hashMap.put("uts", Long.valueOf(this.f37050f));
        Y0 y0 = this.f37051g;
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
            this.f37045a = (int) motionEvent.getRawX();
            this.f37046b = (int) motionEvent.getRawY();
            this.f37047c = System.currentTimeMillis();
            this.f37051g.p = (int) motionEvent.getX();
            this.f37051g.q = (int) motionEvent.getY();
            Y0.a(this.f37051g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f37048d = (int) motionEvent.getRawX();
            this.f37049e = (int) motionEvent.getRawY();
            this.f37050f = System.currentTimeMillis();
            this.f37051g.r = (int) motionEvent.getX();
            this.f37051g.s = (int) motionEvent.getY();
            Y0 y0 = this.f37051g;
            Info info = y0.f37054c;
            if (info == null || !o1.a(info, y0.f37059h)) {
                return false;
            }
            this.f37051g.f37059h = System.currentTimeMillis();
            Y0 y02 = this.f37051g;
            Context context = y02.f37052a;
            String open = y02.f37054c.getOpen();
            Y0 y03 = this.f37051g;
            o1.a(context, open, y03.f37054c, y03.f37058g, a().toString());
            x0.a(this.f37051g.f37052a).a(new y0(this.f37051g.f37054c), (String) null).a("desc", a().toString()).a();
            z.a(this.f37051g.f37054c, a().toString());
            r rVar = this.f37051g.f37057f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
