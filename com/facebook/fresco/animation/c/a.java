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
    private static final Class<?> mki = a.class;
    private static final b msb = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a mrv;
    @Nullable
    private com.facebook.fresco.animation.d.b msc;
    private long msd;
    private long mse;
    private int msf;
    private long msh;
    private long msi;
    private int msj;
    private volatile b msk;
    @Nullable
    private volatile InterfaceC0783a msl;
    private final Runnable msm;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0783a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.msh = 8L;
        this.msi = 0L;
        this.msk = msb;
        this.msl = null;
        this.msm = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.msm);
                a.this.invalidateSelf();
            }
        };
        this.mrv = aVar;
        this.msc = a(this.mrv);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mrv == null ? super.getIntrinsicWidth() : this.mrv.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mrv == null ? super.getIntrinsicHeight() : this.mrv.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.mrv != null && this.mrv.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mse = this.mStartTimeMs;
            this.msd = -1L;
            this.msf = -1;
            invalidateSelf();
            this.msk.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mse = this.mStartTimeMs;
            this.msd = -1L;
            this.msf = -1;
            unscheduleSelf(this.msm);
            this.msk.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mrv != null) {
            this.mrv.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mrv != null && this.msc != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.msi : Math.max(this.msd, 0L);
            int J = this.msc.J(max, this.msd);
            if (J == -1) {
                J = this.mrv.getFrameCount() - 1;
                this.msk.c(this);
                this.mIsRunning = false;
            } else if (J == 0 && this.msf != -1 && now >= this.mse) {
                this.msk.d(this);
            }
            boolean a = this.mrv.a(this, canvas, J);
            if (a) {
                this.msk.a(this, J);
                this.msf = J;
            }
            if (!a) {
                dxf();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.msc.fO(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.msh;
                    fN(j2);
                }
            }
            InterfaceC0783a interfaceC0783a = this.msl;
            if (interfaceC0783a != null) {
                interfaceC0783a.a(this, this.msc, J, a, this.mIsRunning, this.mStartTimeMs, max, this.msd, now, now2, j, j2);
            }
            this.msd = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.mrv != null) {
            this.mrv.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mrv != null) {
            this.mrv.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fN(long j) {
        this.mse = this.mStartTimeMs + j;
        scheduleSelf(this.msm, this.mse);
    }

    private void dxf() {
        this.msj++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(mki, "Dropped a frame. Count: %s", Integer.valueOf(this.msj));
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
        if (this.mIsRunning || this.msd == i) {
            return false;
        }
        this.msd = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dvb() {
        if (this.mrv != null) {
            this.mrv.clear();
        }
    }
}
