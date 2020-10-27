package com.kascend.chushou.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.kascend.chushou.a;
/* loaded from: classes6.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode pqs = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap b;
    private Paint d;
    private Paint e;
    private Bitmap h;
    private Bitmap i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private a pqt;
    private d pqu;
    private ViewTreeObserver.OnGlobalLayoutListener pqv;
    protected ValueAnimator pqw;
    private Animator.AnimatorListener pqx;
    private boolean q;

    /* loaded from: classes6.dex */
    public enum b {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes6.dex */
    public enum c {
        LINEAR,
        RADIAL
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        public float b;
        public float c;
        public int d;
        public int e;
        public float f;
        public float g;
        public float h;
        public c pqA;
        public b pqz;

        private a() {
        }

        public int a(int i) {
            return this.d > 0 ? this.d : (int) (i * this.g);
        }

        public int b(int i) {
            return this.e > 0 ? this.e : (int) (i * this.h);
        }

        public int[] a() {
            switch (this.pqA) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                default:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
            }
        }

        public float[] esx() {
            switch (this.pqA) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.f, 1.0f), Math.min(this.f + this.c, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.f) - this.c) / 2.0f, 0.0f), Math.max((1.0f - this.f) / 2.0f, 0.0f), Math.min((this.f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f + 1.0f) + this.c) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f4253a;
        public int b;
        public int c;
        public int d;

        private d() {
        }

        public void a(int i, int i2, int i3, int i4) {
            this.f4253a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.pqt = new a();
        this.d = new Paint();
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setFilterBitmap(true);
        this.e.setXfermode(pqs);
        a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_auto_start)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(a.k.ShimmerFrameLayout_auto_start, false));
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_base_alpha)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_base_alpha, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_duration)) {
                    setDuration(obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_duration, 0));
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_repeat_count)) {
                    setRepeatCount(obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_repeat_count, 0));
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_repeat_delay)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_repeat_delay, 0));
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_repeat_mode)) {
                    setRepeatMode(obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_repeat_mode, 0));
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_angle)) {
                    switch (obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_angle, 0)) {
                        case 90:
                            this.pqt.pqz = b.CW_90;
                            break;
                        case 180:
                            this.pqt.pqz = b.CW_180;
                            break;
                        case 270:
                            this.pqt.pqz = b.CW_270;
                            break;
                        default:
                            this.pqt.pqz = b.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.pqt.pqA = c.RADIAL;
                            break;
                        default:
                            this.pqt.pqA = c.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_dropoff)) {
                    this.pqt.c = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_fixed_width)) {
                    this.pqt.d = obtainStyledAttributes.getDimensionPixelSize(a.k.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_fixed_height)) {
                    this.pqt.e = obtainStyledAttributes.getDimensionPixelSize(a.k.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_intensity)) {
                    this.pqt.f = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_relative_width)) {
                    this.pqt.g = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_relative_height)) {
                    this.pqt.h = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_tilt)) {
                    this.pqt.b = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void a() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.pqt.pqz = b.CW_0;
        this.pqt.pqA = c.LINEAR;
        this.pqt.c = 0.5f;
        this.pqt.d = 0;
        this.pqt.e = 0;
        this.pqt.f = 0.0f;
        this.pqt.g = 1.0f;
        this.pqt.h = 1.0f;
        this.pqt.b = 20.0f;
        this.pqu = new d();
        setBaseAlpha(0.3f);
        g();
    }

    public void setAutoStart(boolean z) {
        this.j = z;
        g();
    }

    public float getBaseAlpha() {
        return this.d.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.d.setAlpha((int) (a(0.0f, 1.0f, f) * 255.0f));
        g();
    }

    public int getDuration() {
        return this.k;
    }

    public void setDuration(int i) {
        this.k = i;
        g();
    }

    public int getRepeatCount() {
        return this.l;
    }

    public void setRepeatCount(int i) {
        this.l = i;
        g();
    }

    public int getRepeatDelay() {
        return this.m;
    }

    public void setRepeatDelay(int i) {
        this.m = i;
        g();
    }

    public int getRepeatMode() {
        return this.n;
    }

    public void setRepeatMode(int i) {
        this.n = i;
        g();
    }

    public c getMaskShape() {
        return this.pqt.pqA;
    }

    public void setMaskShape(c cVar) {
        this.pqt.pqA = cVar;
        g();
    }

    public b getAngle() {
        return this.pqt.pqz;
    }

    public void setAngle(b bVar) {
        this.pqt.pqz = bVar;
        g();
    }

    public float getDropoff() {
        return this.pqt.c;
    }

    public void setDropoff(float f) {
        this.pqt.c = f;
        g();
    }

    public int getFixedWidth() {
        return this.pqt.d;
    }

    public void setFixedWidth(int i) {
        this.pqt.d = i;
        g();
    }

    public int getFixedHeight() {
        return this.pqt.e;
    }

    public void setFixedHeight(int i) {
        this.pqt.e = i;
        g();
    }

    public float getIntensity() {
        return this.pqt.f;
    }

    public void setIntensity(float f) {
        this.pqt.f = f;
        g();
    }

    public float getRelativeWidth() {
        return this.pqt.g;
    }

    public void setRelativeWidth(int i) {
        this.pqt.g = i;
        g();
    }

    public float getRelativeHeight() {
        return this.pqt.h;
    }

    public void setRelativeHeight(int i) {
        this.pqt.h = i;
        g();
    }

    public float getTilt() {
        return this.pqt.b;
    }

    public void setTilt(float f) {
        this.pqt.b = f;
        g();
    }

    public void b() {
        if (!this.q) {
            getShimmerAnimation().start();
            this.q = true;
        }
    }

    public void c() {
        if (this.pqw != null) {
            this.pqw.end();
            this.pqw.removeAllUpdateListeners();
            this.pqw.cancel();
        }
        this.pqw = null;
        this.q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.o != i) {
            this.o = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.p != i) {
            this.p = i;
            invalidate();
        }
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.pqx = animatorListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pqv == null) {
            this.pqv = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.pqv);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.ShimmerFrameLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z = ShimmerFrameLayout.this.q;
                if (ShimmerFrameLayout.this.j || z) {
                    ShimmerFrameLayout.this.g();
                    ShimmerFrameLayout.this.b();
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        g();
        if (this.pqv != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.pqv);
            this.pqv = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            as(canvas);
        }
    }

    private static float a(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean as(Canvas canvas) {
        Bitmap d2 = d();
        Bitmap esv = esv();
        if (d2 == null || esv == null) {
            return false;
        }
        b(new Canvas(d2));
        canvas.drawBitmap(d2, 0.0f, 0.0f, this.d);
        c(new Canvas(esv));
        canvas.drawBitmap(esv, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap d() {
        if (this.i == null) {
            this.i = esw();
        }
        return this.i;
    }

    private Bitmap esv() {
        if (this.h == null) {
            this.h = esw();
        }
        return this.h;
    }

    private Bitmap esw() {
        int width = getWidth();
        int height = getHeight();
        try {
            return a(width, height);
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            Log.d("ShimmerFrameLayout", sb.toString());
            return null;
        }
    }

    private void b(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void c(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.o, this.p, this.o + maskBitmap.getWidth(), this.p + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.o, this.p, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        c();
        h();
        i();
    }

    private void h() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
    }

    private void i() {
        if (this.i != null) {
            this.i.recycle();
            this.i = null;
        }
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.b != null) {
            return this.b;
        }
        int a2 = this.pqt.a(getWidth());
        int b2 = this.pqt.b(getHeight());
        this.b = a(a2, b2);
        Canvas canvas = new Canvas(this.b);
        switch (this.pqt.pqA) {
            case RADIAL:
                radialGradient = new RadialGradient(a2 / 2, b2 / 2, (float) (Math.max(a2, b2) / Math.sqrt(2.0d)), this.pqt.a(), this.pqt.esx(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.pqt.pqz) {
                    case CW_90:
                        i = b2;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = a2;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = b2;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = a2;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.pqt.a(), this.pqt.esx(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.pqt.b, a2 / 2, b2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(a2, b2))) / 2;
        canvas.drawRect(-sqrt, -sqrt, a2 + sqrt, sqrt + b2, paint);
        return this.b;
    }

    private Animator getShimmerAnimation() {
        if (this.pqw != null) {
            return this.pqw;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass4.f4250a[this.pqt.pqA.ordinal()];
        switch (this.pqt.pqz) {
            case CW_90:
                this.pqu.a(0, -height, 0, height);
                break;
            case CW_180:
                this.pqu.a(width, 0, -width, 0);
                break;
            case CW_270:
                this.pqu.a(0, height, 0, -height);
                break;
            default:
                this.pqu.a(-width, 0, width, 0);
                break;
        }
        this.pqw = ValueAnimator.ofFloat(0.0f, 1.0f + (this.m / this.k));
        this.pqw.setDuration(this.k + this.m);
        this.pqw.setRepeatCount(this.l);
        this.pqw.setRepeatMode(this.n);
        this.pqw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.widget.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.pqu.f4253a * (1.0f - max)) + (ShimmerFrameLayout.this.pqu.c * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.pqu.d) + (ShimmerFrameLayout.this.pqu.b * (1.0f - max))));
            }
        });
        if (this.pqx != null) {
            this.pqw.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.widget.ShimmerFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ShimmerFrameLayout.this.pqx != null) {
                        ShimmerFrameLayout.this.pqx.onAnimationEnd(animator);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
        }
        return this.pqw;
    }

    protected static Bitmap a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
