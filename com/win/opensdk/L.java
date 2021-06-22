package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class L implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final I f40648a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40649b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f40650c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f40651d;

    /* renamed from: e  reason: collision with root package name */
    public float f40652e;

    /* renamed from: f  reason: collision with root package name */
    public int f40653f;

    /* renamed from: g  reason: collision with root package name */
    public int f40654g;

    /* renamed from: h  reason: collision with root package name */
    public int f40655h;

    /* renamed from: i  reason: collision with root package name */
    public int f40656i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public L(Info info, I i2) {
        this.f40648a = i2;
    }

    public HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dx", Integer.valueOf(this.f40653f));
        hashMap.put("dy", Integer.valueOf(this.f40654g));
        hashMap.put("dts", Long.valueOf(this.n));
        hashMap.put("ux", Integer.valueOf(this.o));
        hashMap.put("uy", Integer.valueOf(this.p));
        hashMap.put("uts", Long.valueOf(this.q));
        z.a(hashMap, this.f40655h, this.f40656i, this.j, this.k, this.l, this.m);
        return hashMap;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f40649b = true;
            this.f40650c = System.currentTimeMillis();
            this.f40651d = motionEvent.getX();
            this.f40652e = motionEvent.getY();
            this.f40655h = (int) motionEvent.getX();
            this.f40656i = (int) motionEvent.getY();
            this.f40653f = (int) motionEvent.getRawX();
            this.f40654g = (int) motionEvent.getRawY();
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
            boolean z = Math.abs(motionEvent.getX() - this.f40651d) < 51.0f;
            boolean z2 = Math.abs(motionEvent.getY() - this.f40652e) < 51.0f;
            boolean z3 = System.currentTimeMillis() - this.f40650c < 2000;
            if (z && z2 && z3 && this.f40649b) {
                String str = null;
                try {
                    str = a().toString();
                    V1 v1 = this.f40648a.f40614a.f40632b;
                    if (v1 != null) {
                        v1.a(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                I i2 = this.f40648a;
                i2.f40614a.f40634d = true;
                i2.f40614a.f40635e = str;
                return false;
            } else if (this.f40648a != null) {
                try {
                    String hashMap = a().toString();
                    V1 v12 = this.f40648a.f40614a.f40632b;
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
