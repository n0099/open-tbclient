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
    private static final Class<?> paF = a.class;
    private static final b pik = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a phC;
    @Nullable
    private com.facebook.fresco.animation.d.b pil;
    private long pim;
    private long pio;
    private int pip;
    private long piq;
    private long pir;
    private int pis;
    private volatile b pit;
    @Nullable
    private volatile InterfaceC0996a piu;
    private final Runnable piv;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0996a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.piq = 8L;
        this.pir = 0L;
        this.pit = pik;
        this.piu = null;
        this.piv = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.piv);
                a.this.invalidateSelf();
            }
        };
        this.phC = aVar;
        this.pil = a(this.phC);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.phC == null ? super.getIntrinsicWidth() : this.phC.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.phC == null ? super.getIntrinsicHeight() : this.phC.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.phC != null && this.phC.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pio = this.mStartTimeMs;
            this.pim = -1L;
            this.pip = -1;
            invalidateSelf();
            this.pit.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pio = this.mStartTimeMs;
            this.pim = -1L;
            this.pip = -1;
            unscheduleSelf(this.piv);
            this.pit.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.phC != null) {
            this.phC.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.phC != null && this.pil != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pir : Math.max(this.pim, 0L);
            int K = this.pil.K(max, this.pim);
            if (K == -1) {
                K = this.phC.getFrameCount() - 1;
                this.pit.a(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.pip != -1 && now >= this.pio) {
                this.pit.b(this);
            }
            boolean a2 = this.phC.a(this, canvas, K);
            if (a2) {
                this.pit.a(this, K);
                this.pip = K;
            }
            if (!a2) {
                esA();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.pil.iv(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.piq;
                    iu(j2);
                }
            }
            InterfaceC0996a interfaceC0996a = this.piu;
            if (interfaceC0996a != null) {
                interfaceC0996a.a(this, this.pil, K, a2, this.mIsRunning, this.mStartTimeMs, max, this.pim, now, now2, j, j2);
            }
            this.pim = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.phC != null) {
            this.phC.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.phC != null) {
            this.phC.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.phC == null) {
            return 0;
        }
        return this.phC.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = pik;
        }
        this.pit = bVar;
    }

    private void iu(long j) {
        this.pio = this.mStartTimeMs + j;
        scheduleSelf(this.piv, this.pio);
    }

    private void esA() {
        this.pis++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(paF, "Dropped a frame. Count: %s", Integer.valueOf(this.pis));
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
        if (this.mIsRunning || this.pim == i) {
            return false;
        }
        this.pim = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void eqC() {
        if (this.phC != null) {
            this.phC.clear();
        }
    }
}
