package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class L implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final I f36866a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36867b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f36868c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f36869d;

    /* renamed from: e  reason: collision with root package name */
    public float f36870e;

    /* renamed from: f  reason: collision with root package name */
    public int f36871f;

    /* renamed from: g  reason: collision with root package name */
    public int f36872g;

    /* renamed from: h  reason: collision with root package name */
    public int f36873h;

    /* renamed from: i  reason: collision with root package name */
    public int f36874i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public L(Info info, I i2) {
        this.f36866a = i2;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f36871f));
        hashMap.put("dy", Integer.valueOf(this.f36872g));
        hashMap.put("dts", Long.valueOf(this.n));
        hashMap.put("ux", Integer.valueOf(this.o));
        hashMap.put("uy", Integer.valueOf(this.p));
        hashMap.put("uts", Long.valueOf(this.q));
        z.a(hashMap, this.f36873h, this.f36874i, this.j, this.k, this.l, this.m);
        return hashMap;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f36867b = true;
            this.f36868c = System.currentTimeMillis();
            this.f36869d = motionEvent.getX();
            this.f36870e = motionEvent.getY();
            this.f36873h = (int) motionEvent.getX();
            this.f36874i = (int) motionEvent.getY();
            this.f36871f = (int) motionEvent.getRawX();
            this.f36872g = (int) motionEvent.getRawY();
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
            boolean z = Math.abs(motionEvent.getX() - this.f36869d) < 51.0f;
            boolean z2 = Math.abs(motionEvent.getY() - this.f36870e) < 51.0f;
            boolean z3 = System.currentTimeMillis() - this.f36868c < 2000;
            if (z && z2 && z3 && this.f36867b) {
                String str = null;
                try {
                    str = a().toString();
                    V1 v1 = this.f36866a.f36832a.f36850b;
                    if (v1 != null) {
                        v1.a(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                I i2 = this.f36866a;
                i2.f36832a.f36852d = true;
                i2.f36832a.f36853e = str;
                return false;
            } else if (this.f36866a != null) {
                try {
                    String hashMap = a().toString();
                    V1 v12 = this.f36866a.f36832a.f36850b;
                    if (v12 != null) {
                        v12.a(hashMap);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return false;
    }
}
