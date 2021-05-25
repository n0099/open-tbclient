package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class h0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f37046a;

    /* renamed from: b  reason: collision with root package name */
    public int f37047b;

    /* renamed from: c  reason: collision with root package name */
    public long f37048c;

    /* renamed from: d  reason: collision with root package name */
    public int f37049d;

    /* renamed from: e  reason: collision with root package name */
    public int f37050e;

    /* renamed from: f  reason: collision with root package name */
    public long f37051f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f37052g;

    public h0(i0 i0Var) {
        this.f37052g = i0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f37046a));
        hashMap.put("dy", Integer.valueOf(this.f37047b));
        hashMap.put("dts", Long.valueOf(this.f37048c));
        hashMap.put("ux", Integer.valueOf(this.f37049d));
        hashMap.put("uy", Integer.valueOf(this.f37050e));
        hashMap.put("uts", Long.valueOf(this.f37051f));
        i0 i0Var = this.f37052g;
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
            this.f37046a = (int) motionEvent.getRawX();
            this.f37047b = (int) motionEvent.getRawY();
            this.f37048c = System.currentTimeMillis();
            this.f37052g.p = (int) motionEvent.getX();
            this.f37052g.q = (int) motionEvent.getY();
            i0.a(this.f37052g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f37049d = (int) motionEvent.getRawX();
            this.f37050e = (int) motionEvent.getRawY();
            this.f37051f = System.currentTimeMillis();
            this.f37052g.r = (int) motionEvent.getX();
            this.f37052g.s = (int) motionEvent.getY();
            i0 i0Var = this.f37052g;
            Info info = i0Var.f37056c;
            if (info == null || !o1.a(info, i0Var.f37061h)) {
                return false;
            }
            this.f37052g.f37061h = System.currentTimeMillis();
            i0 i0Var2 = this.f37052g;
            Context context = i0Var2.f37054a;
            String open = i0Var2.f37056c.getOpen();
            i0 i0Var3 = this.f37052g;
            o1.a(context, open, i0Var3.f37056c, i0Var3.f37060g, a().toString());
            x0.a(this.f37052g.f37054a).a(new y0(this.f37052g.f37056c), (String) null).a("desc", a().toString()).a();
            z.a(this.f37052g.f37056c, a().toString());
            PBNativeListener pBNativeListener = this.f37052g.f37059f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
