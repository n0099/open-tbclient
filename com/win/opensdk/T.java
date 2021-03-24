package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class T implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final P f39791a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39792b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f39793c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f39794d;

    /* renamed from: e  reason: collision with root package name */
    public float f39795e;

    /* renamed from: f  reason: collision with root package name */
    public int f39796f;

    /* renamed from: g  reason: collision with root package name */
    public int f39797g;

    /* renamed from: h  reason: collision with root package name */
    public int f39798h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public T(Info info, P p) {
        this.f39791a = p;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f39796f));
        hashMap.put("dy", Integer.valueOf(this.f39797g));
        hashMap.put("dts", Long.valueOf(this.n));
        hashMap.put("ux", Integer.valueOf(this.o));
        hashMap.put("uy", Integer.valueOf(this.p));
        hashMap.put("uts", Long.valueOf(this.q));
        G.a(hashMap, this.f39798h, this.i, this.j, this.k, this.l, this.m);
        return hashMap;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39792b = true;
            this.f39793c = System.currentTimeMillis();
            this.f39794d = motionEvent.getX();
            this.f39795e = motionEvent.getY();
            this.f39798h = (int) motionEvent.getX();
            this.i = (int) motionEvent.getY();
            this.f39796f = (int) motionEvent.getRawX();
            this.f39797g = (int) motionEvent.getRawY();
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
            boolean z = Math.abs(motionEvent.getX() - this.f39794d) < 51.0f;
            boolean z2 = Math.abs(motionEvent.getY() - this.f39795e) < 51.0f;
            boolean z3 = System.currentTimeMillis() - this.f39793c < 2000;
            if (z && z2 && z3 && this.f39792b) {
                String str = null;
                try {
                    str = a().toString();
                    A2 a2 = this.f39791a.f39734a.f39786b;
                    if (a2 != null) {
                        a2.a(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                P p = this.f39791a;
                p.f39734a.f39788d = true;
                p.f39734a.f39789e = str;
                return false;
            } else if (this.f39791a != null) {
                try {
                    String hashMap = a().toString();
                    A2 a22 = this.f39791a.f39734a.f39786b;
                    if (a22 != null) {
                        a22.a(hashMap);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return false;
    }
}
