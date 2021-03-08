package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> pAh = a.class;
    private static final b pHK = new c();
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private d pES;
    @Nullable
    private com.facebook.fresco.animation.d.b pHL;
    private long pHM;
    private long pHN;
    private int pHO;
    private long pHP;
    private long pHQ;
    private int pHR;
    private volatile b pHS;
    @Nullable
    private volatile InterfaceC1067a pHT;
    private final Runnable pHU;
    @Nullable
    private com.facebook.fresco.animation.a.a pHe;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1067a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pHP = 8L;
        this.pHQ = 0L;
        this.pHS = pHK;
        this.pHT = null;
        this.pHU = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pHU);
                a.this.invalidateSelf();
            }
        };
        this.pHe = aVar;
        this.pHL = a(this.pHe);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pHe == null ? super.getIntrinsicWidth() : this.pHe.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pHe == null ? super.getIntrinsicHeight() : this.pHe.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.pHe != null && this.pHe.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pHN = this.mStartTimeMs;
            this.pHM = -1L;
            this.pHO = -1;
            invalidateSelf();
            this.pHS.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pHN = this.mStartTimeMs;
            this.pHM = -1L;
            this.pHO = -1;
            unscheduleSelf(this.pHU);
            this.pHS.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.pHe != null) {
            this.pHe.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pHe != null && this.pHL != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pHQ : Math.max(this.pHM, 0L);
            int S = this.pHL.S(max, this.pHM);
            if (S == -1) {
                S = this.pHe.getFrameCount() - 1;
                this.pHS.a(this);
                this.mIsRunning = false;
            } else if (S == 0 && this.pHO != -1 && now >= this.pHN) {
                this.pHS.b(this);
            }
            boolean a2 = this.pHe.a(this, canvas, S);
            if (a2) {
                this.pHS.a(this, S);
                this.pHO = S;
            }
            if (!a2) {
                evB();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.pHL.iM(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pHP;
                    iL(j2);
                }
            }
            InterfaceC1067a interfaceC1067a = this.pHT;
            if (interfaceC1067a != null) {
                interfaceC1067a.a(this, this.pHL, S, a2, this.mIsRunning, this.mStartTimeMs, max, this.pHM, now, now2, j, j2);
            }
            this.pHM = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.pES == null) {
            this.pES = new d();
        }
        this.pES.setAlpha(i);
        if (this.pHe != null) {
            this.pHe.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pES == null) {
            this.pES = new d();
        }
        this.pES.setColorFilter(colorFilter);
        if (this.pHe != null) {
            this.pHe.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.pHe == null) {
            return 0;
        }
        return this.pHe.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = pHK;
        }
        this.pHS = bVar;
    }

    private void iL(long j) {
        this.pHN = this.mStartTimeMs + j;
        scheduleSelf(this.pHU, this.pHN);
    }

    private void evB() {
        this.pHR++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(pAh, "Dropped a frame. Count: %s", Integer.valueOf(this.pHR));
        }
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    @Nullable
    private static com.facebook.fresco.animation.d.b a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.facebook.fresco.animation.d.a(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.mIsRunning || this.pHM == i) {
            return false;
        }
        this.pHM = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void etB() {
        if (this.pHe != null) {
            this.pHe.clear();
        }
    }
}
