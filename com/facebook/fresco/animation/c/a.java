package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> lGr = a.class;
    private static final b lNY = new c();
    private long aGp;
    @Nullable
    private com.facebook.fresco.animation.d.b lNZ;
    @Nullable
    private com.facebook.fresco.animation.a.a lNs;
    private long lOa;
    private long lOb;
    private int lOc;
    private long lOd;
    private long lOe;
    private int lOf;
    private volatile b lOg;
    @Nullable
    private volatile InterfaceC0655a lOh;
    private final Runnable lOi;
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0655a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.lOd = 8L;
        this.lOe = 0L;
        this.lOg = lNY;
        this.lOh = null;
        this.lOi = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lOi);
                a.this.invalidateSelf();
            }
        };
        this.lNs = aVar;
        this.lNZ = a(this.lNs);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lNs == null ? super.getIntrinsicWidth() : this.lNs.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lNs == null ? super.getIntrinsicHeight() : this.lNs.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lNs != null && this.lNs.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.aGp = now();
            this.lOb = this.aGp;
            this.lOa = -1L;
            this.lOc = -1;
            invalidateSelf();
            this.lOg.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.aGp = 0L;
            this.lOb = this.aGp;
            this.lOa = -1L;
            this.lOc = -1;
            unscheduleSelf(this.lOi);
            this.lOg.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lNs != null) {
            this.lNs.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lNs != null && this.lNZ != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.aGp) + this.lOe : Math.max(this.lOa, 0L);
            int L = this.lNZ.L(max, this.lOa);
            if (L == -1) {
                L = this.lNs.getFrameCount() - 1;
                this.lOg.c(this);
                this.mIsRunning = false;
            } else if (L == 0 && this.lOc != -1 && now >= this.lOb) {
                this.lOg.d(this);
            }
            boolean a = this.lNs.a(this, canvas, L);
            if (a) {
                this.lOg.a(this, L);
                this.lOc = L;
            }
            if (!a) {
                dmf();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lNZ.fj(now2 - this.aGp);
                if (j != -1) {
                    j2 = j + this.lOd;
                    fi(j2);
                }
            }
            InterfaceC0655a interfaceC0655a = this.lOh;
            if (interfaceC0655a != null) {
                interfaceC0655a.a(this, this.lNZ, L, a, this.mIsRunning, this.aGp, max, this.lOa, now, now2, j, j2);
            }
            this.lOa = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lNs != null) {
            this.lNs.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lNs != null) {
            this.lNs.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fi(long j) {
        this.lOb = this.aGp + j;
        scheduleSelf(this.lOi, this.lOb);
    }

    private void dmf() {
        this.lOf++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGr, "Dropped a frame. Count: %s", Integer.valueOf(this.lOf));
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
        if (this.mIsRunning || this.lOa == i) {
            return false;
        }
        this.lOa = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dkd() {
        if (this.lNs != null) {
            this.lNs.clear();
        }
    }
}
