package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class bx implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f14030a;

    /* renamed from: a  reason: collision with other field name */
    private long f32a;

    /* renamed from: b  reason: collision with root package name */
    private int f14031b;

    /* renamed from: case  reason: not valid java name */
    private int f33case;
    private int java;
    private Info qbW;
    private long qcD;
    private final a qdB;
    private float qdC;
    private float qdD;
    private boolean qbE = false;
    private long qbX = 0;

    /* loaded from: classes4.dex */
    public interface a {
        boolean abJ(String str);

        void abK(String str);
    }

    public bx(Info info, a aVar) {
        this.qdB = aVar;
        this.qbW = info;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qbE = true;
                this.qbX = System.currentTimeMillis();
                this.qdC = motionEvent.getX();
                this.qdD = motionEvent.getY();
                this.java = (int) motionEvent.getRawX();
                this.f33case = (int) motionEvent.getRawY();
                this.qcD = System.currentTimeMillis();
                return false;
            case 1:
                this.f14030a = (int) motionEvent.getRawX();
                this.f14031b = (int) motionEvent.getRawY();
                this.f32a = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.qdC) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.qdD) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.qbX < 2000;
                if (z && z2 && z3 && this.qbE) {
                    String str = null;
                    try {
                        str = eJY().toString();
                        this.qdB.abK(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.qdB.abJ(str);
                } else if (this.qdB != null) {
                    try {
                        this.qdB.abK(eJY().toString());
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

    private HashMap<String, Object> eJY() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dx", Integer.valueOf(this.java));
        hashMap.put("dy", Integer.valueOf(this.f33case));
        hashMap.put("dts", Long.valueOf(this.qcD));
        hashMap.put("ux", Integer.valueOf(this.f14030a));
        hashMap.put("uy", Integer.valueOf(this.f14031b));
        hashMap.put("uts", Long.valueOf(this.f32a));
        return hashMap;
    }
}
