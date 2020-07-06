package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> mHr = a.class;
    private static final b mPo = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    @Nullable
    private com.facebook.fresco.animation.a.a mOG;
    @Nullable
    private com.facebook.fresco.animation.d.b mPp;
    private long mPq;
    private long mPr;
    private int mPs;
    private long mPt;
    private long mPu;
    private int mPv;
    private volatile b mPw;
    @Nullable
    private volatile InterfaceC0804a mPx;
    private final Runnable mPy;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0804a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.mPt = 8L;
        this.mPu = 0L;
        this.mPw = mPo;
        this.mPx = null;
        this.mPy = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.mPy);
                a.this.invalidateSelf();
            }
        };
        this.mOG = aVar;
        this.mPp = a(this.mOG);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mOG == null ? super.getIntrinsicWidth() : this.mOG.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mOG == null ? super.getIntrinsicHeight() : this.mOG.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.mOG != null && this.mOG.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mPr = this.mStartTimeMs;
            this.mPq = -1L;
            this.mPs = -1;
            invalidateSelf();
            this.mPw.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mPr = this.mStartTimeMs;
            this.mPq = -1L;
            this.mPs = -1;
            unscheduleSelf(this.mPy);
            this.mPw.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mOG != null) {
            this.mOG.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mOG != null && this.mPp != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.mPu : Math.max(this.mPq, 0L);
            int K = this.mPp.K(max, this.mPq);
            if (K == -1) {
                K = this.mOG.getFrameCount() - 1;
                this.mPw.c(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.mPs != -1 && now >= this.mPr) {
                this.mPw.d(this);
            }
            boolean a = this.mOG.a(this, canvas, K);
            if (a) {
                this.mPw.a(this, K);
                this.mPs = K;
            }
            if (!a) {
                dBZ();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.mPp.fT(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.mPt;
                    fS(j2);
                }
            }
            InterfaceC0804a interfaceC0804a = this.mPx;
            if (interfaceC0804a != null) {
                interfaceC0804a.a(this, this.mPp, K, a, this.mIsRunning, this.mStartTimeMs, max, this.mPq, now, now2, j, j2);
            }
            this.mPq = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.mOG != null) {
            this.mOG.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mOG != null) {
            this.mOG.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fS(long j) {
        this.mPr = this.mStartTimeMs + j;
        scheduleSelf(this.mPy, this.mPr);
    }

    private void dBZ() {
        this.mPv++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mHr, "Dropped a frame. Count: %s", Integer.valueOf(this.mPv));
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
        if (this.mIsRunning || this.mPq == i) {
            return false;
        }
        this.mPq = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dzW() {
        if (this.mOG != null) {
            this.mOG.clear();
        }
    }
}
