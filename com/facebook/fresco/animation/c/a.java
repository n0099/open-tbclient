package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private d pCn;
    @Nullable
    private com.facebook.fresco.animation.a.a pEz;
    @Nullable
    private com.facebook.fresco.animation.d.b pFg;
    private long pFh;
    private long pFi;
    private int pFj;
    private long pFk;
    private long pFl;
    private int pFm;
    private volatile b pFn;
    @Nullable
    private volatile InterfaceC1050a pFo;
    private final Runnable pFp;
    private static final Class<?> pxC = a.class;
    private static final b pFf = new c();

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1050a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.pFk = 8L;
        this.pFl = 0L;
        this.pFn = pFf;
        this.pFo = null;
        this.pFp = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.pFp);
                a.this.invalidateSelf();
            }
        };
        this.pEz = aVar;
        this.pFg = a(this.pEz);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pEz == null ? super.getIntrinsicWidth() : this.pEz.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pEz == null ? super.getIntrinsicHeight() : this.pEz.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.pEz != null && this.pEz.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.pFi = this.mStartTimeMs;
            this.pFh = -1L;
            this.pFj = -1;
            invalidateSelf();
            this.pFn.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.pFi = this.mStartTimeMs;
            this.pFh = -1L;
            this.pFj = -1;
            unscheduleSelf(this.pFp);
            this.pFn.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.pEz != null) {
            this.pEz.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pEz != null && this.pFg != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.pFl : Math.max(this.pFh, 0L);
            int S = this.pFg.S(max, this.pFh);
            if (S == -1) {
                S = this.pEz.getFrameCount() - 1;
                this.pFn.a(this);
                this.mIsRunning = false;
            } else if (S == 0 && this.pFj != -1 && now >= this.pFi) {
                this.pFn.b(this);
            }
            boolean a2 = this.pEz.a(this, canvas, S);
            if (a2) {
                this.pFn.a(this, S);
                this.pFj = S;
            }
            if (!a2) {
                evk();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.pFg.iM(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.pFk;
                    iL(j2);
                }
            }
            InterfaceC1050a interfaceC1050a = this.pFo;
            if (interfaceC1050a != null) {
                interfaceC1050a.a(this, this.pFg, S, a2, this.mIsRunning, this.mStartTimeMs, max, this.pFh, now, now2, j, j2);
            }
            this.pFh = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.pCn == null) {
            this.pCn = new d();
        }
        this.pCn.setAlpha(i);
        if (this.pEz != null) {
            this.pEz.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pCn == null) {
            this.pCn = new d();
        }
        this.pCn.setColorFilter(colorFilter);
        if (this.pEz != null) {
            this.pEz.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.pEz == null) {
            return 0;
        }
        return this.pEz.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = pFf;
        }
        this.pFn = bVar;
    }

    private void iL(long j) {
        this.pFi = this.mStartTimeMs + j;
        scheduleSelf(this.pFp, this.pFi);
    }

    private void evk() {
        this.pFm++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.c(pxC, "Dropped a frame. Count: %s", Integer.valueOf(this.pFm));
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
        if (this.mIsRunning || this.pFh == i) {
            return false;
        }
        this.pFh = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void etk() {
        if (this.pEz != null) {
            this.pEz.clear();
        }
    }
}
