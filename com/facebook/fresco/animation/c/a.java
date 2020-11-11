package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> oJR = a.class;
    private static final b oRH = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.d.b oRI;
    private long oRJ;
    private long oRK;
    private int oRL;
    private long oRM;
    private long oRN;
    private int oRO;
    private volatile b oRP;
    @Nullable
    private volatile InterfaceC0977a oRQ;
    private final Runnable oRR;
    @Nullable
    private com.facebook.fresco.animation.a.a oRb;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0977a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.oRM = 8L;
        this.oRN = 0L;
        this.oRP = oRH;
        this.oRQ = null;
        this.oRR = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.oRR);
                a.this.invalidateSelf();
            }
        };
        this.oRb = aVar;
        this.oRI = a(this.oRb);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.oRb == null ? super.getIntrinsicWidth() : this.oRb.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.oRb == null ? super.getIntrinsicHeight() : this.oRb.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.oRb != null && this.oRb.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.oRK = this.mStartTimeMs;
            this.oRJ = -1L;
            this.oRL = -1;
            invalidateSelf();
            this.oRP.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.oRK = this.mStartTimeMs;
            this.oRJ = -1L;
            this.oRL = -1;
            unscheduleSelf(this.oRR);
            this.oRP.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.oRb != null) {
            this.oRb.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.oRb != null && this.oRI != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.oRN : Math.max(this.oRJ, 0L);
            int L = this.oRI.L(max, this.oRJ);
            if (L == -1) {
                L = this.oRb.getFrameCount() - 1;
                this.oRP.a(this);
                this.mIsRunning = false;
            } else if (L == 0 && this.oRL != -1 && now >= this.oRK) {
                this.oRP.b(this);
            }
            boolean a2 = this.oRb.a(this, canvas, L);
            if (a2) {
                this.oRP.a(this, L);
                this.oRL = L;
            }
            if (!a2) {
                emQ();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.oRI.hN(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.oRM;
                    hM(j2);
                }
            }
            InterfaceC0977a interfaceC0977a = this.oRQ;
            if (interfaceC0977a != null) {
                interfaceC0977a.a(this, this.oRI, L, a2, this.mIsRunning, this.mStartTimeMs, max, this.oRJ, now, now2, j, j2);
            }
            this.oRJ = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.oRb != null) {
            this.oRb.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.oRb != null) {
            this.oRb.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.oRb == null) {
            return 0;
        }
        return this.oRb.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = oRH;
        }
        this.oRP = bVar;
    }

    private void hM(long j) {
        this.oRK = this.mStartTimeMs + j;
        scheduleSelf(this.oRR, this.oRK);
    }

    private void emQ() {
        this.oRO++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oJR, "Dropped a frame. Count: %s", Integer.valueOf(this.oRO));
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
        if (this.mIsRunning || this.oRJ == i) {
            return false;
        }
        this.oRJ = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void ekO() {
        if (this.oRb != null) {
            this.oRb.clear();
        }
    }
}
