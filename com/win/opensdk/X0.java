package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class X0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f37800a;

    /* renamed from: b  reason: collision with root package name */
    public int f37801b;

    /* renamed from: c  reason: collision with root package name */
    public long f37802c;

    /* renamed from: d  reason: collision with root package name */
    public int f37803d;

    /* renamed from: e  reason: collision with root package name */
    public int f37804e;

    /* renamed from: f  reason: collision with root package name */
    public long f37805f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f37806g;

    public X0(Y0 y0) {
        this.f37806g = y0;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f37800a));
        hashMap.put("dy", Integer.valueOf(this.f37801b));
        hashMap.put("dts", Long.valueOf(this.f37802c));
        hashMap.put("ux", Integer.valueOf(this.f37803d));
        hashMap.put("uy", Integer.valueOf(this.f37804e));
        hashMap.put("uts", Long.valueOf(this.f37805f));
        Y0 y0 = this.f37806g;
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
            this.f37800a = (int) motionEvent.getRawX();
            this.f37801b = (int) motionEvent.getRawY();
            this.f37802c = System.currentTimeMillis();
            this.f37806g.p = (int) motionEvent.getX();
            this.f37806g.q = (int) motionEvent.getY();
            Y0.a(this.f37806g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f37803d = (int) motionEvent.getRawX();
            this.f37804e = (int) motionEvent.getRawY();
            this.f37805f = System.currentTimeMillis();
            this.f37806g.r = (int) motionEvent.getX();
            this.f37806g.s = (int) motionEvent.getY();
            Y0 y0 = this.f37806g;
            Info info = y0.f37809c;
            if (info == null || !o1.a(info, y0.f37814h)) {
                return false;
            }
            this.f37806g.f37814h = System.currentTimeMillis();
            Y0 y02 = this.f37806g;
            Context context = y02.f37807a;
            String open = y02.f37809c.getOpen();
            Y0 y03 = this.f37806g;
            o1.a(context, open, y03.f37809c, y03.f37813g, a().toString());
            x0.a(this.f37806g.f37807a).a(new y0(this.f37806g.f37809c), (String) null).a("desc", a().toString()).a();
            z.a(this.f37806g.f37809c, a().toString());
            r rVar = this.f37806g.f37812f;
            if (rVar != null) {
                rVar.onClicked();
                return false;
            }
            return false;
        }
    }
}
