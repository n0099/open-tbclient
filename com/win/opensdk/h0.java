package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class h0 implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f37117a;

    /* renamed from: b  reason: collision with root package name */
    public int f37118b;

    /* renamed from: c  reason: collision with root package name */
    public long f37119c;

    /* renamed from: d  reason: collision with root package name */
    public int f37120d;

    /* renamed from: e  reason: collision with root package name */
    public int f37121e;

    /* renamed from: f  reason: collision with root package name */
    public long f37122f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f37123g;

    public h0(i0 i0Var) {
        this.f37123g = i0Var;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f37117a));
        hashMap.put("dy", Integer.valueOf(this.f37118b));
        hashMap.put("dts", Long.valueOf(this.f37119c));
        hashMap.put("ux", Integer.valueOf(this.f37120d));
        hashMap.put("uy", Integer.valueOf(this.f37121e));
        hashMap.put("uts", Long.valueOf(this.f37122f));
        i0 i0Var = this.f37123g;
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
            this.f37117a = (int) motionEvent.getRawX();
            this.f37118b = (int) motionEvent.getRawY();
            this.f37119c = System.currentTimeMillis();
            this.f37123g.p = (int) motionEvent.getX();
            this.f37123g.q = (int) motionEvent.getY();
            i0.a(this.f37123g, view);
            return false;
        } else if (action != 1) {
            return false;
        } else {
            this.f37120d = (int) motionEvent.getRawX();
            this.f37121e = (int) motionEvent.getRawY();
            this.f37122f = System.currentTimeMillis();
            this.f37123g.r = (int) motionEvent.getX();
            this.f37123g.s = (int) motionEvent.getY();
            i0 i0Var = this.f37123g;
            Info info = i0Var.f37127c;
            if (info == null || !o1.a(info, i0Var.f37132h)) {
                return false;
            }
            this.f37123g.f37132h = System.currentTimeMillis();
            i0 i0Var2 = this.f37123g;
            Context context = i0Var2.f37125a;
            String open = i0Var2.f37127c.getOpen();
            i0 i0Var3 = this.f37123g;
            o1.a(context, open, i0Var3.f37127c, i0Var3.f37131g, a().toString());
            x0.a(this.f37123g.f37125a).a(new y0(this.f37123g.f37127c), (String) null).a("desc", a().toString()).a();
            z.a(this.f37123g.f37127c, a().toString());
            PBNativeListener pBNativeListener = this.f37123g.f37130f;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
                return false;
            }
            return false;
        }
    }
}
