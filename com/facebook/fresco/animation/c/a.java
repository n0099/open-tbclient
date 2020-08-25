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
    private static final Class<?> nju = a.class;
    private static final b nrn = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a nqH;
    @Nullable
    private com.facebook.fresco.animation.d.b nro;
    private long nrp;
    private long nrq;
    private int nrr;
    private long nrs;
    private long nrt;
    private int nru;
    private volatile b nrv;
    @Nullable
    private volatile InterfaceC0871a nrw;
    private final Runnable nrx;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0871a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.nrs = 8L;
        this.nrt = 0L;
        this.nrv = nrn;
        this.nrw = null;
        this.nrx = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.nrx);
                a.this.invalidateSelf();
            }
        };
        this.nqH = aVar;
        this.nro = a(this.nqH);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.nqH == null ? super.getIntrinsicWidth() : this.nqH.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.nqH == null ? super.getIntrinsicHeight() : this.nqH.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.nqH != null && this.nqH.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.nrq = this.mStartTimeMs;
            this.nrp = -1L;
            this.nrr = -1;
            invalidateSelf();
            this.nrv.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.nrq = this.mStartTimeMs;
            this.nrp = -1L;
            this.nrr = -1;
            unscheduleSelf(this.nrx);
            this.nrv.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.nqH != null) {
            this.nqH.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nqH != null && this.nro != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.nrt : Math.max(this.nrp, 0L);
            int M = this.nro.M(max, this.nrp);
            if (M == -1) {
                M = this.nqH.getFrameCount() - 1;
                this.nrv.c(this);
                this.mIsRunning = false;
            } else if (M == 0 && this.nrr != -1 && now >= this.nrq) {
                this.nrv.d(this);
            }
            boolean a = this.nqH.a(this, canvas, M);
            if (a) {
                this.nrv.a(this, M);
                this.nrr = M;
            }
            if (!a) {
                dRl();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.nro.gt(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.nrs;
                    gs(j2);
                }
            }
            InterfaceC0871a interfaceC0871a = this.nrw;
            if (interfaceC0871a != null) {
                interfaceC0871a.a(this, this.nro, M, a, this.mIsRunning, this.mStartTimeMs, max, this.nrp, now, now2, j, j2);
            }
            this.nrp = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.nqH != null) {
            this.nqH.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.nqH != null) {
            this.nqH.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void gs(long j) {
        this.nrq = this.mStartTimeMs + j;
        scheduleSelf(this.nrx, this.nrq);
    }

    private void dRl() {
        this.nru++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(nju, "Dropped a frame. Count: %s", Integer.valueOf(this.nru));
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
        if (this.mIsRunning || this.nrp == i) {
            return false;
        }
        this.nrp = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dPj() {
        if (this.nqH != null) {
            this.nqH.clear();
        }
    }
}
