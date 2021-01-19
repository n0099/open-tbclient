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
    private long pZL;
    private Info pZe;
    private final a qaJ;
    private float qaK;
    private float qaL;
    private boolean pYM = false;
    private long pZf = 0;

    /* loaded from: classes3.dex */
    public interface a {
        boolean aaD(String str);

        void aaE(String str);
    }

    public bx(Info info, a aVar) {
        this.qaJ = aVar;
        this.pZe = info;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pYM = true;
                this.pZf = System.currentTimeMillis();
                this.qaK = motionEvent.getX();
                this.qaL = motionEvent.getY();
                this.java = (int) motionEvent.getRawX();
                this.f33case = (int) motionEvent.getRawY();
                this.pZL = System.currentTimeMillis();
                return false;
            case 1:
                this.f13731a = (int) motionEvent.getRawX();
                this.f13732b = (int) motionEvent.getRawY();
                this.f32a = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.qaK) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.qaL) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.pZf < 2000;
                if (z && z2 && z3 && this.pYM) {
                    String str = null;
                    try {
                        str = eGM().toString();
                        this.qaJ.aaE(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.qaJ.aaD(str);
                } else if (this.qaJ != null) {
                    try {
                        this.qaJ.aaE(eGM().toString());
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
        hashMap.put("dts", Long.valueOf(this.pZL));
        hashMap.put("ux", Integer.valueOf(this.f13731a));
        hashMap.put("uy", Integer.valueOf(this.f13732b));
        hashMap.put("uts", Long.valueOf(this.f32a));
        return hashMap;
    }
}
