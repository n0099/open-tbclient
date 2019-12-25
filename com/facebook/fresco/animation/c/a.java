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
    private static final Class<?> lCO = a.class;
    private static final b lKi = new c();
    private long aFx;
    @Nullable
    private com.facebook.fresco.animation.a.a lJC;
    @Nullable
    private com.facebook.fresco.animation.d.b lKj;
    private long lKk;
    private long lKl;
    private int lKm;
    private long lKn;
    private long lKo;
    private int lKp;
    private volatile b lKq;
    @Nullable
    private volatile InterfaceC0649a lKr;
    private final Runnable lKs;
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0649a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.lKn = 8L;
        this.lKo = 0L;
        this.lKq = lKi;
        this.lKr = null;
        this.lKs = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lKs);
                a.this.invalidateSelf();
            }
        };
        this.lJC = aVar;
        this.lKj = a(this.lJC);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lJC == null ? super.getIntrinsicWidth() : this.lJC.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lJC == null ? super.getIntrinsicHeight() : this.lJC.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lJC != null && this.lJC.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.aFx = now();
            this.lKl = this.aFx;
            this.lKk = -1L;
            this.lKm = -1;
            invalidateSelf();
            this.lKq.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.aFx = 0L;
            this.lKl = this.aFx;
            this.lKk = -1L;
            this.lKm = -1;
            unscheduleSelf(this.lKs);
            this.lKq.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lJC != null) {
            this.lJC.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lJC != null && this.lKj != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.aFx) + this.lKo : Math.max(this.lKk, 0L);
            int L = this.lKj.L(max, this.lKk);
            if (L == -1) {
                L = this.lJC.getFrameCount() - 1;
                this.lKq.c(this);
                this.mIsRunning = false;
            } else if (L == 0 && this.lKm != -1 && now >= this.lKl) {
                this.lKq.d(this);
            }
            boolean a = this.lJC.a(this, canvas, L);
            if (a) {
                this.lKq.a(this, L);
                this.lKm = L;
            }
            if (!a) {
                dkY();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lKj.fe(now2 - this.aFx);
                if (j != -1) {
                    j2 = j + this.lKn;
                    fd(j2);
                }
            }
            InterfaceC0649a interfaceC0649a = this.lKr;
            if (interfaceC0649a != null) {
                interfaceC0649a.a(this, this.lKj, L, a, this.mIsRunning, this.aFx, max, this.lKk, now, now2, j, j2);
            }
            this.lKk = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lJC != null) {
            this.lJC.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lJC != null) {
            this.lJC.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fd(long j) {
        this.lKl = this.aFx + j;
        scheduleSelf(this.lKs, this.lKl);
    }

    private void dkY() {
        this.lKp++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lCO, "Dropped a frame. Count: %s", Integer.valueOf(this.lKp));
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
        if (this.mIsRunning || this.lKk == i) {
            return false;
        }
        this.lKk = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dja() {
        if (this.lJC != null) {
            this.lJC.clear();
        }
    }
}
