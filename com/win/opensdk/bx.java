package com.win.opensdk;

import android.view.MotionEvent;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class bx implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f14031a;

    /* renamed from: a  reason: collision with other field name */
    private long f33a;

    /* renamed from: b  reason: collision with root package name */
    private int f14032b;

    /* renamed from: case  reason: not valid java name */
    private int f34case;
    private int java;
    private Info qdE;
    private long qel;
    private final a qfj;
    private float qfk;
    private float qfl;
    private boolean qdm = false;
    private long qdF = 0;

    /* loaded from: classes4.dex */
    public interface a {
        boolean abK(String str);

        void abL(String str);
    }

    public bx(Info info, a aVar) {
        this.qfj = aVar;
        this.qdE = info;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qdm = true;
                this.qdF = System.currentTimeMillis();
                this.qfk = motionEvent.getX();
                this.qfl = motionEvent.getY();
                this.java = (int) motionEvent.getRawX();
                this.f34case = (int) motionEvent.getRawY();
                this.qel = System.currentTimeMillis();
                return false;
            case 1:
                this.f14031a = (int) motionEvent.getRawX();
                this.f14032b = (int) motionEvent.getRawY();
                this.f33a = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.qfk) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.qfl) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.qdF < 2000;
                if (z && z2 && z3 && this.qdm) {
                    String str = null;
                    try {
                        str = eKC().toString();
                        this.qfj.abL(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return this.qfj.abK(str);
                } else if (this.qfj != null) {
                    try {
                        this.qfj.abL(eKC().toString());
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

    private HashMap<String, Object> eKC() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dx", Integer.valueOf(this.java));
        hashMap.put("dy", Integer.valueOf(this.f34case));
        hashMap.put("dts", Long.valueOf(this.qel));
        hashMap.put("ux", Integer.valueOf(this.f14031a));
        hashMap.put("uy", Integer.valueOf(this.f14032b));
        hashMap.put("uts", Long.valueOf(this.f33a));
        return hashMap;
    }
}
