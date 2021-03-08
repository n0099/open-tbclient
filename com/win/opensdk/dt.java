package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class dt implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f8158a;
    public int b;
    public long c;
    public int d;
    public int e;
    public long f;
    public final /* synthetic */ dv qlW;

    public dt(dv dvVar) {
        this.qlW = dvVar;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f8158a));
        hashMap.put("dy", Integer.valueOf(this.b));
        hashMap.put("dts", Long.valueOf(this.c));
        hashMap.put("ux", Integer.valueOf(this.d));
        hashMap.put("uy", Integer.valueOf(this.e));
        hashMap.put("uts", Long.valueOf(this.f));
        dv dvVar = this.qlW;
        v.a(hashMap, dvVar.p, dvVar.q, dvVar.r, dvVar.s, dvVar.t, dvVar.u);
        return hashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8158a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
            this.c = System.currentTimeMillis();
            this.qlW.p = (int) motionEvent.getX();
            this.qlW.q = (int) motionEvent.getY();
            dv.a(this.qlW, view);
            return false;
        } else if (action == 1) {
            this.d = (int) motionEvent.getRawX();
            this.e = (int) motionEvent.getRawY();
            this.f = System.currentTimeMillis();
            this.qlW.r = (int) motionEvent.getX();
            this.qlW.s = (int) motionEvent.getY();
            dv dvVar = this.qlW;
            Info info = dvVar.qkh;
            if (info != null && bf.a(info, dvVar.h)) {
                this.qlW.h = System.currentTimeMillis();
                dv dvVar2 = this.qlW;
                Context context = dvVar2.f8159a;
                String open = dvVar2.qkh.getOpen();
                dv dvVar3 = this.qlW;
                bf.a(context, open, dvVar3.qkh, dvVar3.qlY, a().toString());
                ca.iT(this.qlW.f8159a).a(new cd(this.qlW.qkh), (String) null).hD("desc", a().toString()).a();
                v.a(this.qlW.qkh, a().toString());
                PBNativeListener pBNativeListener = this.qlW.qlX;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                    return false;
                }
                return false;
            }
            return false;
        } else {
            return false;
        }
    }
}
