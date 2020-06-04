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
    private static final Class<?> mls = a.class;
    private static final b mtm = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a msG;
    @Nullable
    private com.facebook.fresco.animation.d.b mtn;
    private long mto;
    private long mtp;
    private int mtq;
    private long mtr;
    private long mts;
    private int mtt;
    private volatile b mtu;
    @Nullable
    private volatile InterfaceC0784a mtv;
    private final Runnable mtw;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0784a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.mtr = 8L;
        this.mts = 0L;
        this.mtu = mtm;
        this.mtv = null;
        this.mtw = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.mtw);
                a.this.invalidateSelf();
            }
        };
        this.msG = aVar;
        this.mtn = a(this.msG);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.msG == null ? super.getIntrinsicWidth() : this.msG.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.msG == null ? super.getIntrinsicHeight() : this.msG.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.msG != null && this.msG.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mtp = this.mStartTimeMs;
            this.mto = -1L;
            this.mtq = -1;
            invalidateSelf();
            this.mtu.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mtp = this.mStartTimeMs;
            this.mto = -1L;
            this.mtq = -1;
            unscheduleSelf(this.mtw);
            this.mtu.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.msG != null) {
            this.msG.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.msG != null && this.mtn != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.mts : Math.max(this.mto, 0L);
            int J = this.mtn.J(max, this.mto);
            if (J == -1) {
                J = this.msG.getFrameCount() - 1;
                this.mtu.c(this);
                this.mIsRunning = false;
            } else if (J == 0 && this.mtq != -1 && now >= this.mtp) {
                this.mtu.d(this);
            }
            boolean a = this.msG.a(this, canvas, J);
            if (a) {
                this.mtu.a(this, J);
                this.mtq = J;
            }
            if (!a) {
                dxt();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.mtn.fO(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.mtr;
                    fN(j2);
                }
            }
            InterfaceC0784a interfaceC0784a = this.mtv;
            if (interfaceC0784a != null) {
                interfaceC0784a.a(this, this.mtn, J, a, this.mIsRunning, this.mStartTimeMs, max, this.mto, now, now2, j, j2);
            }
            this.mto = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.msG != null) {
            this.msG.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.msG != null) {
            this.msG.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fN(long j) {
        this.mtp = this.mStartTimeMs + j;
        scheduleSelf(this.mtw, this.mtp);
    }

    private void dxt() {
        this.mtt++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mls, "Dropped a frame. Count: %s", Integer.valueOf(this.mtt));
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
        if (this.mIsRunning || this.mto == i) {
            return false;
        }
        this.mto = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dvp() {
        if (this.msG != null) {
            this.msG.clear();
        }
    }
}
