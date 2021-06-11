package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class L implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final I f40545a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40546b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f40547c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f40548d;

    /* renamed from: e  reason: collision with root package name */
    public float f40549e;

    /* renamed from: f  reason: collision with root package name */
    public int f40550f;

    /* renamed from: g  reason: collision with root package name */
    public int f40551g;

    /* renamed from: h  reason: collision with root package name */
    public int f40552h;

    /* renamed from: i  reason: collision with root package name */
    public int f40553i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public L(Info info, I i2) {
        this.f40545a = i2;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40550f));
        hashMap.put("dy", Integer.valueOf(this.f40551g));
        hashMap.put("dts", Long.valueOf(this.n));
        hashMap.put("ux", Integer.valueOf(this.o));
        hashMap.put("uy", Integer.valueOf(this.p));
        hashMap.put("uts", Long.valueOf(this.q));
        z.a(hashMap, this.f40552h, this.f40553i, this.j, this.k, this.l, this.m);
        return hashMap;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40546b = true;
            this.f40547c = System.currentTimeMillis();
            this.f40548d = motionEvent.getX();
            this.f40549e = motionEvent.getY();
            this.f40552h = (int) motionEvent.getX();
            this.f40553i = (int) motionEvent.getY();
            this.f40550f = (int) motionEvent.getRawX();
            this.f40551g = (int) motionEvent.getRawY();
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
            boolean z = Math.abs(motionEvent.getX() - this.f40548d) < 51.0f;
            boolean z2 = Math.abs(motionEvent.getY() - this.f40549e) < 51.0f;
            boolean z3 = System.currentTimeMillis() - this.f40547c < 2000;
            if (z && z2 && z3 && this.f40546b) {
                String str = null;
                try {
                    str = a().toString();
                    V1 v1 = this.f40545a.f40511a.f40529b;
                    if (v1 != null) {
                        v1.a(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                I i2 = this.f40545a;
                i2.f40511a.f40531d = true;
                i2.f40511a.f40532e = str;
                return false;
            } else if (this.f40545a != null) {
                try {
                    String hashMap = a().toString();
                    V1 v12 = this.f40545a.f40511a.f40529b;
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
