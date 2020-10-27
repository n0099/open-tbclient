package com.facebook.fresco.animation.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a extends Drawable implements Animatable, com.facebook.b.a.a {
    private static final Class<?> oAy = a.class;
    private static final b oIo = new c();
    @Nullable
    private d mDrawableProperties;
    private volatile boolean mIsRunning;
    private long mStartTimeMs;
    @Nullable
    private com.facebook.fresco.animation.a.a oHI;
    @Nullable
    private com.facebook.fresco.animation.d.b oIp;
    private long oIq;
    private long oIr;
    private int oIs;
    private long oIt;
    private long oIu;
    private int oIv;
    private volatile b oIw;
    @Nullable
    private volatile InterfaceC0958a oIx;
    private final Runnable oIy;

    /* renamed from: com.facebook.fresco.animation.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0958a {
        void a(a aVar, com.facebook.fresco.animation.d.b bVar, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public a() {
        this(null);
    }

    public a(@Nullable com.facebook.fresco.animation.a.a aVar) {
        this.oIt = 8L;
        this.oIu = 0L;
        this.oIw = oIo;
        this.oIx = null;
        this.oIy = new Runnable() { // from class: com.facebook.fresco.animation.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.unscheduleSelf(a.this.oIy);
                a.this.invalidateSelf();
            }
        };
        this.oHI = aVar;
        this.oIp = a(this.oHI);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.oHI == null ? super.getIntrinsicWidth() : this.oHI.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.oHI == null ? super.getIntrinsicHeight() : this.oHI.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.mIsRunning && this.oHI != null && this.oHI.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.oIr = this.mStartTimeMs;
            this.oIq = -1L;
            this.oIs = -1;
            invalidateSelf();
            this.oIw.d(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.oIr = this.mStartTimeMs;
            this.oIq = -1L;
            this.oIs = -1;
            unscheduleSelf(this.oIy);
            this.oIw.a(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.oHI != null) {
            this.oHI.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.oHI != null && this.oIp != null) {
            long now = now();
            long max = this.mIsRunning ? (now - this.mStartTimeMs) + this.oIu : Math.max(this.oIq, 0L);
            int K = this.oIp.K(max, this.oIq);
            if (K == -1) {
                K = this.oHI.getFrameCount() - 1;
                this.oIw.a(this);
                this.mIsRunning = false;
            } else if (K == 0 && this.oIs != -1 && now >= this.oIr) {
                this.oIw.b(this);
            }
            boolean a2 = this.oHI.a(this, canvas, K);
            if (a2) {
                this.oIw.a(this, K);
                this.oIs = K;
            }
            if (!a2) {
                ejb();
            }
            long j = -1;
            long j2 = -1;
            long now2 = now();
            if (this.mIsRunning) {
                j = this.oIp.hr(now2 - this.mStartTimeMs);
                if (j != -1) {
                    j2 = j + this.oIt;
                    hq(j2);
                }
            }
            InterfaceC0958a interfaceC0958a = this.oIx;
            if (interfaceC0958a != null) {
                interfaceC0958a.a(this, this.oIp, K, a2, this.mIsRunning, this.mStartTimeMs, max, this.oIq, now, now2, j, j2);
            }
            this.oIq = max;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.oHI != null) {
            this.oHI.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new d();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.oHI != null) {
            this.oHI.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void a(@Nullable b bVar) {
        if (bVar == null) {
            bVar = oIo;
        }
        this.oIw = bVar;
    }

    private void hq(long j) {
        this.oIr = this.mStartTimeMs + j;
        scheduleSelf(this.oIy, this.oIr);
    }

    private void ejb() {
        this.oIv++;
        if (com.facebook.common.c.a.isLoggable(2)) {
            com.facebook.common.c.a.a(oAy, "Dropped a frame. Count: %s", Integer.valueOf(this.oIv));
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
        if (this.mIsRunning || this.oIq == i) {
            return false;
        }
        this.oIq = i;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.b.a.a
    public void egZ() {
        if (this.oHI != null) {
            this.oHI.clear();
        }
    }
}
