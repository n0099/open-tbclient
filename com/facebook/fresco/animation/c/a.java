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
    private static final Class<?> lGm = a.class;
    private static final b lNT = new c();
    private long aGp;
    @Nullable
    private com.facebook.fresco.animation.d.b lNU;
    private long lNV;
    private long lNW;
    private int lNX;
    private long lNY;
    private long lNZ;
    @Nullable
    private com.facebook.fresco.animation.a.a lNn;
    private int lOa;
    private volatile b lOb;
    @Nullable
    private volatile InterfaceC0655a lOc;
    private final Runnable lOd;
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
        this.lNY = 8L;
        this.lNZ = 0L;
        this.lOb = lNT;
        this.lOc = null;
        this.lOd = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.lOd);
                a.this.invalidateSelf();
            }
        };
        this.lNn = aVar;
        this.lNU = a(this.lNn);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lNn == null ? super.getIntrinsicWidth() : this.lNn.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lNn == null ? super.getIntrinsicHeight() : this.lNn.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.lNn != null && this.lNn.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.aGp = now();
            this.lNW = this.aGp;
            this.lNV = -1L;
            this.lNX = -1;
            invalidateSelf();
            this.lOb.b(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.aGp = 0L;
            this.lNW = this.aGp;
            this.lNV = -1L;
            this.lNX = -1;
            unscheduleSelf(this.lOd);
            this.lOb.c(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.lNn != null) {
            this.lNn.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lNn != null && this.lNU != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.aGp) + this.lNZ : Math.max(this.lNV, 0L);
            int L = this.lNU.L(max, this.lNV);
            if (L == -1) {
                L = this.lNn.getFrameCount() - 1;
                this.lOb.c(this);
                this.mIsRunning = false;
            } else if (L == 0 && this.lNX != -1 && now >= this.lNW) {
                this.lOb.d(this);
            }
            boolean a = this.lNn.a(this, canvas, L);
            if (a) {
                this.lOb.a(this, L);
                this.lNX = L;
            }
            if (!a) {
                dmd();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.lNU.fj(now2 - this.aGp);
                if (j != -1) {
                    j2 = j + this.lNY;
                    fi(j2);
                }
            }
            InterfaceC0655a interfaceC0655a = this.lOc;
            if (interfaceC0655a != null) {
                interfaceC0655a.a(this, this.lNU, L, a, this.mIsRunning, this.aGp, max, this.lNV, now, now2, j, j2);
            }
            this.lNV = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.lNn != null) {
            this.lNn.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.lNn != null) {
            this.lNn.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void fi(long j) {
        this.lNW = this.aGp + j;
        scheduleSelf(this.lOd, this.lNW);
    }

    private void dmd() {
        this.lOa++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(lGm, "Dropped a frame. Count: %s", Integer.valueOf(this.lOa));
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
        if (this.mIsRunning || this.lNV == i) {
            return false;
        }
        this.lNV = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void dkb() {
        if (this.lNn != null) {
            this.lNn.clear();
        }
    }
}
