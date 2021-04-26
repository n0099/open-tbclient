package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class h0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f37872a;

    /* renamed from: b  reason: collision with root package name */
    public int f37873b;

    /* renamed from: c  reason: collision with root package name */
    public long f37874c;

    /* renamed from: d  reason: collision with root package name */
    public int f37875d;

    /* renamed from: e  reason: collision with root package name */
    public int f37876e;

    /* renamed from: f  reason: collision with root package name */
    public long f37877f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f37878g;

    public h0(i0 i0Var) {
        this.f37878g = i0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f37872a));
        hashMap.put("dy", Integer.valueOf(this.f37873b));
        hashMap.put("dts", Long.valueOf(this.f37874c));
        hashMap.put("ux", Integer.valueOf(this.f37875d));
        hashMap.put("uy", Integer.valueOf(this.f37876e));
        hashMap.put("uts", Long.valueOf(this.f37877f));
        i0 i0Var = this.f37878g;
        z.a(hashMap, i0Var.p, i0Var.q, i0Var.r, i0Var.s, i0Var.t, i0Var.u);
        return hashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37872a = (int) motionEvent.getRawX();
            this.f37873b = (int) motionEvent.getRawY();
            this.f37874c = System.currentTimeMillis();
            this.f37878g.p = (int) motionEvent.getX();
            this.f37878g.q = (int) motionEvent.getY();
            i0.a(this.f37878g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f37875d = (int) motionEvent.getRawX();
            this.f37876e = (int) motionEvent.getRawY();
            this.f37877f = System.currentTimeMillis();
            this.f37878g.r = (int) motionEvent.getX();
            this.f37878g.s = (int) motionEvent.getY();
            i0 i0Var = this.f37878g;
            Info info = i0Var.f37882c;
            if (info == null || !o1.a(info, i0Var.f37887h)) {
                return false;
            }
            this.f37878g.f37887h = System.currentTimeMillis();
            i0 i0Var2 = this.f37878g;
            Context context = i0Var2.f37880a;
            String open = i0Var2.f37882c.getOpen();
            i0 i0Var3 = this.f37878g;
            o1.a(context, open, i0Var3.f37882c, i0Var3.f37886g, a().toString());
            x0.a(this.f37878g.f37880a).a(new y0(this.f37878g.f37882c), (String) null).a("desc", a().toString()).a();
            z.a(this.f37878g.f37882c, a().toString());
            PBNativeListener pBNativeListener = this.f37878g.f37885f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
