package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private d pCN;
    @Nullable
    private com.facebook.fresco.animation.a.a pEZ;
    @Nullable
    private com.facebook.fresco.animation.d.b pFG;
    private long pFH;
    private long pFI;
    private int pFJ;
    private long pFK;
    private long pFL;
    private int pFM;
    private volatile b pFN;
    @Nullable
    private volatile InterfaceC1052a pFO;
    private final Runnable pFP;
    private static final Class<?> pyc = a.class;
    private static final b pFF = new c();

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1052a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pFK = 8L;
        this.pFL = 0L;
        this.pFN = pFF;
        this.pFO = null;
        this.pFP = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pFP);
                a.this.invalidateSelf();
            }
        };
        this.pEZ = aVar;
        this.pFG = a(this.pEZ);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pEZ == null ? super.getIntrinsicWidth() : this.pEZ.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pEZ == null ? super.getIntrinsicHeight() : this.pEZ.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.pEZ != null && this.pEZ.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pFI = this.mStartTimeMs;
            this.pFH = -1L;
            this.pFJ = -1;
            invalidateSelf();
            this.pFN.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pFI = this.mStartTimeMs;
            this.pFH = -1L;
            this.pFJ = -1;
            unscheduleSelf(this.pFP);
            this.pFN.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.pEZ != null) {
            this.pEZ.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pEZ != null && this.pFG != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pFL : Math.max(this.pFH, 0L);
            int S = this.pFG.S(max, this.pFH);
            if (S == -1) {
                S = this.pEZ.getFrameCount() - 1;
                this.pFN.a(this);
                this.mIsRunning = false;
            } else if (S == 0 && this.pFJ != -1 && now >= this.pFI) {
                this.pFN.b(this);
            }
            boolean a2 = this.pEZ.a(this, canvas, S);
            if (a2) {
                this.pFN.a(this, S);
                this.pFJ = S;
            }
            if (!a2) {
                evs();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.pFG.iM(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pFK;
                    iL(j2);
                }
            }
            InterfaceC1052a interfaceC1052a = this.pFO;
            if (interfaceC1052a != null) {
                interfaceC1052a.a(this, this.pFG, S, a2, this.mIsRunning, this.mStartTimeMs, max, this.pFH, now, now2, j, j2);
            }
            this.pFH = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.pCN == null) {
            this.pCN = new d();
        }
        this.pCN.setAlpha(i);
        if (this.pEZ != null) {
            this.pEZ.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pCN == null) {
            this.pCN = new d();
        }
        this.pCN.setColorFilter(colorFilter);
        if (this.pEZ != null) {
            this.pEZ.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.pEZ == null) {
            return 0;
        }
        return this.pEZ.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = pFF;
        }
        this.pFN = bVar;
    }

    private void iL(long j) {
        this.pFI = this.mStartTimeMs + j;
        scheduleSelf(this.pFP, this.pFI);
    }

    private void evs() {
        this.pFM++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(pyc, "Dropped a frame. Count: %s", Integer.valueOf(this.pFM));
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
        if (this.mIsRunning || this.pFH == i) {
            return false;
        }
        this.pFH = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void ets() {
        if (this.pEZ != null) {
            this.pEZ.clear();
        }
    }
}
