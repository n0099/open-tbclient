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
    private long qjP;
    private Info qji;
    private final a qkN;
    private float qkO;
    private float qkP;
    private boolean qiQ = false;
    private long qjj = 0;

    /* loaded from: classes3.dex */
    public interface a {
        boolean abE(String str);

        void abF(String str);
    }

    public bx(Info info, a aVar) {
        this.qkN = aVar;
        this.qji = info;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qiQ = true;
                this.qjj = System.currentTimeMillis();
                this.qkO = motionEvent.getX();
                this.qkP = motionEvent.getY();
                this.java = (int) motionEvent.getRawX();
                this.f33case = (int) motionEvent.getRawY();
                this.qjP = System.currentTimeMillis();
                return false;
            case 1:
                this.f13733a = (int) motionEvent.getRawX();
                this.f13734b = (int) motionEvent.getRawY();
                this.f32a = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.qkO) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.qkP) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.qjj < 2000;
                if (z && z2 && z3 && this.qiQ) {
                    String str = null;
                    try {
                        str = eJc().toString();
                        this.qkN.abF(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.qkN.abE(str);
                } else if (this.qkN != null) {
                    try {
                        this.qkN.abF(eJc().toString());
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

    private HashMap<String, Object> eJc() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dx", Integer.valueOf(this.java));
        hashMap.put("dy", Integer.valueOf(this.f33case));
        hashMap.put("dts", Long.valueOf(this.qjP));
        hashMap.put("ux", Integer.valueOf(this.f13733a));
        hashMap.put("uy", Integer.valueOf(this.f13734b));
        hashMap.put("uts", Long.valueOf(this.f32a));
        return hashMap;
    }
}
