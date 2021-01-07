package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> prR = a.class;
    private static final b pzx = new c();
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private d pwF;
    @Nullable
    private com.facebook.fresco.animation.a.a pyR;
    private long pzA;
    private int pzB;
    private long pzC;
    private long pzD;
    private int pzE;
    private volatile b pzF;
    @Nullable
    private volatile InterfaceC1063a pzG;
    private final Runnable pzH;
    @Nullable
    private com.facebook.fresco.animation.d.b pzy;
    private long pzz;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1063a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pzC = 8L;
        this.pzD = 0L;
        this.pzF = pzx;
        this.pzG = null;
        this.pzH = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pzH);
                a.this.invalidateSelf();
            }
        };
        this.pyR = aVar;
        this.pzy = a(this.pyR);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pyR == null ? super.getIntrinsicWidth() : this.pyR.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pyR == null ? super.getIntrinsicHeight() : this.pyR.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.pyR != null && this.pyR.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pzA = this.mStartTimeMs;
            this.pzz = -1L;
            this.pzB = -1;
            invalidateSelf();
            this.pzF.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pzA = this.mStartTimeMs;
            this.pzz = -1L;
            this.pzB = -1;
            unscheduleSelf(this.pzH);
            this.pzF.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.pyR != null) {
            this.pyR.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pyR != null && this.pzy != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pzD : Math.max(this.pzz, 0L);
            int O = this.pzy.O(max, this.pzz);
            if (O == -1) {
                O = this.pyR.getFrameCount() - 1;
                this.pzF.a(this);
                this.mIsRunning = false;
            } else if (O == 0 && this.pzB != -1 && now >= this.pzA) {
                this.pzF.b(this);
            }
            boolean a2 = this.pyR.a(this, canvas, O);
            if (a2) {
                this.pzF.a(this, O);
                this.pzB = O;
            }
            if (!a2) {
                ewK();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.pzy.iJ(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pzC;
                    iI(j2);
                }
            }
            InterfaceC1063a interfaceC1063a = this.pzG;
            if (interfaceC1063a != null) {
                interfaceC1063a.a(this, this.pzy, O, a2, this.mIsRunning, this.mStartTimeMs, max, this.pzz, now, now2, j, j2);
            }
            this.pzz = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.pwF == null) {
            this.pwF = new d();
        }
        this.pwF.setAlpha(i);
        if (this.pyR != null) {
            this.pyR.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pwF == null) {
            this.pwF = new d();
        }
        this.pwF.setColorFilter(colorFilter);
        if (this.pyR != null) {
            this.pyR.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.pyR == null) {
            return 0;
        }
        return this.pyR.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = pzx;
        }
        this.pzF = bVar;
    }

    private void iI(long j) {
        this.pzA = this.mStartTimeMs + j;
        scheduleSelf(this.pzH, this.pzA);
    }

    private void ewK() {
        this.pzE++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(prR, "Dropped a frame. Count: %s", Integer.valueOf(this.pzE));
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
        if (this.mIsRunning || this.pzz == i) {
            return false;
        }
        this.pzz = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void euL() {
        if (this.pyR != null) {
            this.pyR.clear();
        }
    }
}
