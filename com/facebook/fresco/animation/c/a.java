package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> paD = a.class;
    private static final b pii = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a phA;
    @Nullable
    private com.facebook.fresco.animation.d.b pij;
    private long pik;
    private long pil;
    private int pim;
    private long pio;
    private long pip;
    private int piq;
    private volatile b pir;
    @Nullable
    private volatile InterfaceC0996a pis;
    private final Runnable pit;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0996a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pio = 8L;
        this.pip = 0L;
        this.pir = pii;
        this.pis = null;
        this.pit = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pit);
                a.this.invalidateSelf();
            }
        };
        this.phA = aVar;
        this.pij = a(this.phA);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.phA == null ? super.getIntrinsicWidth() : this.phA.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.phA == null ? super.getIntrinsicHeight() : this.phA.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.phA != null && this.phA.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pil = this.mStartTimeMs;
            this.pik = -1L;
            this.pim = -1;
            invalidateSelf();
            this.pir.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pil = this.mStartTimeMs;
            this.pik = -1L;
            this.pim = -1;
            unscheduleSelf(this.pit);
            this.pir.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.phA != null) {
            this.phA.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.phA != null && this.pij != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pip : Math.max(this.pik, 0L);
            int K = this.pij.K(max, this.pik);
            if (K == -1) {
                K = this.phA.getFrameCount() - 1;
                this.pir.a(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.pim != -1 && now >= this.pil) {
                this.pir.b(this);
            }
            boolean a2 = this.phA.a(this, canvas, K);
            if (a2) {
                this.pir.a(this, K);
                this.pim = K;
            }
            if (!a2) {
                esz();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.pij.iv(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pio;
                    iu(j2);
                }
            }
            InterfaceC0996a interfaceC0996a = this.pis;
            if (interfaceC0996a != null) {
                interfaceC0996a.a(this, this.pij, K, a2, this.mIsRunning, this.mStartTimeMs, max, this.pik, now, now2, j, j2);
            }
            this.pik = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.phA != null) {
            this.phA.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.phA != null) {
            this.phA.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.phA == null) {
            return 0;
        }
        return this.phA.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = pii;
        }
        this.pir = bVar;
    }

    private void iu(long j) {
        this.pil = this.mStartTimeMs + j;
        scheduleSelf(this.pit, this.pil);
    }

    private void esz() {
        this.piq++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paD, "Dropped a frame. Count: %s", Integer.valueOf(this.piq));
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
        if (this.mIsRunning || this.pik == i) {
            return false;
        }
        this.pik = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void eqB() {
        if (this.phA != null) {
            this.phA.clear();
        }
    }
}
