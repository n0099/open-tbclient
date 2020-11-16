package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> oLv = a.class;
    private static final b oTk = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a oSE;
    @Nullable
    private com.facebook.fresco.animation.d.b oTl;
    private long oTm;
    private long oTn;
    private int oTo;
    private long oTp;
    private long oTq;
    private int oTr;
    private volatile b oTs;
    @Nullable
    private volatile InterfaceC0980a oTt;
    private final Runnable oTu;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0980a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.oTp = 8L;
        this.oTq = 0L;
        this.oTs = oTk;
        this.oTt = null;
        this.oTu = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.oTu);
                a.this.invalidateSelf();
            }
        };
        this.oSE = aVar;
        this.oTl = a(this.oSE);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.oSE == null ? super.getIntrinsicWidth() : this.oSE.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.oSE == null ? super.getIntrinsicHeight() : this.oSE.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.oSE != null && this.oSE.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.oTn = this.mStartTimeMs;
            this.oTm = -1L;
            this.oTo = -1;
            invalidateSelf();
            this.oTs.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.oTn = this.mStartTimeMs;
            this.oTm = -1L;
            this.oTo = -1;
            unscheduleSelf(this.oTu);
            this.oTs.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.oSE != null) {
            this.oSE.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.oSE != null && this.oTl != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.oTq : Math.max(this.oTm, 0L);
            int L = this.oTl.L(max, this.oTm);
            if (L == -1) {
                L = this.oSE.getFrameCount() - 1;
                this.oTs.a(this);
                this.mIsRunning = false;
            } else if (L == 0 && this.oTo != -1 && now >= this.oTn) {
                this.oTs.b(this);
            }
            boolean a2 = this.oSE.a(this, canvas, L);
            if (a2) {
                this.oTs.a(this, L);
                this.oTo = L;
            }
            if (!a2) {
                emO();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.oTl.hQ(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.oTp;
                    hP(j2);
                }
            }
            InterfaceC0980a interfaceC0980a = this.oTt;
            if (interfaceC0980a != null) {
                interfaceC0980a.a(this, this.oTl, L, a2, this.mIsRunning, this.mStartTimeMs, max, this.oTm, now, now2, j, j2);
            }
            this.oTm = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.oSE != null) {
            this.oSE.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.oSE != null) {
            this.oSE.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getFrameCount() {
        if (this.oSE == null) {
            return 0;
        }
        return this.oSE.getFrameCount();
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = oTk;
        }
        this.oTs = bVar;
    }

    private void hP(long j) {
        this.oTn = this.mStartTimeMs + j;
        scheduleSelf(this.oTu, this.oTn);
    }

    private void emO() {
        this.oTr++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oLv, "Dropped a frame. Count: %s", Integer.valueOf(this.oTr));
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
        if (this.mIsRunning || this.oTm == i) {
            return false;
        }
        this.oTm = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void ekM() {
        if (this.oSE != null) {
            this.oSE.clear();
        }
    }
}
