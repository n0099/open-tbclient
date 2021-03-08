package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class bj implements View.OnTouchListener {
    public boolean b = false;
    public long c = 0;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;
    public final at qle;

    public bj(Info info, at atVar) {
        this.qle = atVar;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f));
        hashMap.put("dy", Integer.valueOf(this.g));
        hashMap.put("dts", Long.valueOf(this.n));
        hashMap.put("ux", Integer.valueOf(this.o));
        hashMap.put("uy", Integer.valueOf(this.p));
        hashMap.put("uts", Long.valueOf(this.q));
        v.a(hashMap, this.h, this.i, this.j, this.k, this.l, this.m);
        return hashMap;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = true;
            this.c = System.currentTimeMillis();
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
            this.h = (int) motionEvent.getX();
            this.i = (int) motionEvent.getY();
            this.f = (int) motionEvent.getRawX();
            this.g = (int) motionEvent.getRawY();
            if (this.l <= 0 || this.m <= 0) {
                this.m = view.getHeight();
                this.l = view.getWidth();
            }
            this.n = System.currentTimeMillis();
        } else if (action == 1) {
            this.o = (int) motionEvent.getRawX();
            this.p = (int) motionEvent.getRawY();
            this.j = (int) motionEvent.getX();
            this.k = (int) motionEvent.getY();
            this.q = System.currentTimeMillis();
            boolean z = Math.abs(motionEvent.getX() - this.d) < 51.0f;
            boolean z2 = Math.abs(motionEvent.getY() - this.e) < 51.0f;
            boolean z3 = System.currentTimeMillis() - this.c < 2000;
            if (z && z2 && z3 && this.b) {
                String str = null;
                try {
                    str = a().toString();
                    g gVar = this.qle.f8111a.qlc;
                    if (gVar != null) {
                        gVar.a(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                at atVar = this.qle;
                atVar.f8111a.d = true;
                atVar.f8111a.e = str;
            } else if (this.qle != null) {
                try {
                    String hashMap = a().toString();
                    g gVar2 = this.qle.f8111a.qlc;
                    if (gVar2 != null) {
                        gVar2.a(hashMap);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
