package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class bx implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f13733a;

    /* renamed from: a  reason: collision with other field name */
    private long f32a;

    /* renamed from: b  reason: collision with root package name */
    private int f13734b;

    /* renamed from: case  reason: not valid java name */
    private int f33case;
    private int java;
    private Info qjI;
    private long qkp;
    private final a qln;
    private float qlo;
    private float qlp;
    private boolean qjq = false;
    private long qjJ = 0;

    /* loaded from: classes3.dex */
    public interface a {
        boolean abQ(String str);

        void abR(String str);
    }

    public bx(Info info, a aVar) {
        this.qln = aVar;
        this.qjI = info;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qjq = true;
                this.qjJ = System.currentTimeMillis();
                this.qlo = motionEvent.getX();
                this.qlp = motionEvent.getY();
                this.java = (int) motionEvent.getRawX();
                this.f33case = (int) motionEvent.getRawY();
                this.qkp = System.currentTimeMillis();
                return false;
            case 1:
                this.f13733a = (int) motionEvent.getRawX();
                this.f13734b = (int) motionEvent.getRawY();
                this.f32a = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.qlo) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.qlp) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.qjJ < 2000;
                if (z && z2 && z3 && this.qjq) {
                    String str = null;
                    try {
                        str = eJk().toString();
                        this.qln.abR(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.qln.abQ(str);
                } else if (this.qln != null) {
                    try {
                        this.qln.abR(eJk().toString());
                        return false;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private HashMap<String, Object> eJk() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dx", Integer.valueOf(this.java));
        hashMap.put("dy", Integer.valueOf(this.f33case));
        hashMap.put("dts", Long.valueOf(this.qkp));
        hashMap.put("ux", Integer.valueOf(this.f13733a));
        hashMap.put("uy", Integer.valueOf(this.f13734b));
        hashMap.put("uts", Long.valueOf(this.f32a));
        return hashMap;
    }
}
