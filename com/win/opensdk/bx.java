package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class bx implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f13731a;

    /* renamed from: a  reason: collision with other field name */
    private long f32a;

    /* renamed from: b  reason: collision with root package name */
    private int f13732b;

    /* renamed from: case  reason: not valid java name */
    private int f33case;
    private int java;
    private long pZK;
    private Info pZd;
    private final a qaI;
    private float qaJ;
    private float qaK;
    private boolean pYL = false;
    private long pZe = 0;

    /* loaded from: classes3.dex */
    public interface a {
        boolean aaC(String str);

        void aaD(String str);
    }

    public bx(Info info, a aVar) {
        this.qaI = aVar;
        this.pZd = info;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pYL = true;
                this.pZe = System.currentTimeMillis();
                this.qaJ = motionEvent.getX();
                this.qaK = motionEvent.getY();
                this.java = (int) motionEvent.getRawX();
                this.f33case = (int) motionEvent.getRawY();
                this.pZK = System.currentTimeMillis();
                return false;
            case 1:
                this.f13731a = (int) motionEvent.getRawX();
                this.f13732b = (int) motionEvent.getRawY();
                this.f32a = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.qaJ) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.qaK) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.pZe < 2000;
                if (z && z2 && z3 && this.pYL) {
                    String str = null;
                    try {
                        str = eGM().toString();
                        this.qaI.aaD(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.qaI.aaC(str);
                } else if (this.qaI != null) {
                    try {
                        this.qaI.aaD(eGM().toString());
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

    private HashMap<String, Object> eGM() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dx", Integer.valueOf(this.java));
        hashMap.put("dy", Integer.valueOf(this.f33case));
        hashMap.put("dts", Long.valueOf(this.pZK));
        hashMap.put("ux", Integer.valueOf(this.f13731a));
        hashMap.put("uy", Integer.valueOf(this.f13732b));
        hashMap.put("uts", Long.valueOf(this.f32a));
        return hashMap;
    }
}
