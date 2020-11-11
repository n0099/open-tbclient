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
    private static final PorterDuffXfermode pzN = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
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
    private a pzO;
    private d pzP;
    private ViewTreeObserver.OnGlobalLayoutListener pzQ;
    protected ValueAnimator pzR;
    private Animator.AnimatorListener pzS;
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
        public b pzU;
        public c pzV;

        private a() {
        }

        public int a(int i) {
            return this.d > 0 ? this.d : (int) (i * this.g);
        }

        public int b(int i) {
            return this.e > 0 ? this.e : (int) (i * this.h);
        }

        public int[] a() {
            switch (this.pzV) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                default:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
            }
        }

        public float[] ewm() {
            switch (this.pzV) {
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
        public int f4255a;
        public int b;
        public int c;
        public int d;

        private d() {
        }

        public void a(int i, int i2, int i3, int i4) {
            this.f4255a = i;
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
        this.pzO = new a();
        this.d = new Paint();
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setFilterBitmap(true);
        this.e.setXfermode(pzN);
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
                            this.pzO.pzU = b.CW_90;
                            break;
                        case 180:
                            this.pzO.pzU = b.CW_180;
                            break;
                        case 270:
                            this.pzO.pzU = b.CW_270;
                            break;
                        default:
                            this.pzO.pzU = b.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.k.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.pzO.pzV = c.RADIAL;
                            break;
                        default:
                            this.pzO.pzV = c.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_dropoff)) {
                    this.pzO.c = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_fixed_width)) {
                    this.pzO.d = obtainStyledAttributes.getDimensionPixelSize(a.k.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_fixed_height)) {
                    this.pzO.e = obtainStyledAttributes.getDimensionPixelSize(a.k.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_intensity)) {
                    this.pzO.f = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_relative_width)) {
                    this.pzO.g = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_relative_height)) {
                    this.pzO.h = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.k.ShimmerFrameLayout_tilt)) {
                    this.pzO.b = obtainStyledAttributes.getFloat(a.k.ShimmerFrameLayout_tilt, 0.0f);
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
        this.pzO.pzU = b.CW_0;
        this.pzO.pzV = c.LINEAR;
        this.pzO.c = 0.5f;
        this.pzO.d = 0;
        this.pzO.e = 0;
        this.pzO.f = 0.0f;
        this.pzO.g = 1.0f;
        this.pzO.h = 1.0f;
        this.pzO.b = 20.0f;
        this.pzP = new d();
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
        return this.pzO.pzV;
    }

    public void setMaskShape(c cVar) {
        this.pzO.pzV = cVar;
        g();
    }

    public b getAngle() {
        return this.pzO.pzU;
    }

    public void setAngle(b bVar) {
        this.pzO.pzU = bVar;
        g();
    }

    public float getDropoff() {
        return this.pzO.c;
    }

    public void setDropoff(float f) {
        this.pzO.c = f;
        g();
    }

    public int getFixedWidth() {
        return this.pzO.d;
    }

    public void setFixedWidth(int i) {
        this.pzO.d = i;
        g();
    }

    public int getFixedHeight() {
        return this.pzO.e;
    }

    public void setFixedHeight(int i) {
        this.pzO.e = i;
        g();
    }

    public float getIntensity() {
        return this.pzO.f;
    }

    public void setIntensity(float f) {
        this.pzO.f = f;
        g();
    }

    public float getRelativeWidth() {
        return this.pzO.g;
    }

    public void setRelativeWidth(int i) {
        this.pzO.g = i;
        g();
    }

    public float getRelativeHeight() {
        return this.pzO.h;
    }

    public void setRelativeHeight(int i) {
        this.pzO.h = i;
        g();
    }

    public float getTilt() {
        return this.pzO.b;
    }

    public void setTilt(float f) {
        this.pzO.b = f;
        g();
    }

    public void b() {
        if (!this.q) {
            getShimmerAnimation().start();
            this.q = true;
        }
    }

    public void c() {
        if (this.pzR != null) {
            this.pzR.end();
            this.pzR.removeAllUpdateListeners();
            this.pzR.cancel();
        }
        this.pzR = null;
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
        this.pzS = animatorListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pzQ == null) {
            this.pzQ = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.pzQ);
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
        if (this.pzQ != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.pzQ);
            this.pzQ = null;
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
        Bitmap ewk = ewk();
        if (d2 == null || ewk == null) {
            return false;
        }
        b(new Canvas(d2));
        canvas.drawBitmap(d2, 0.0f, 0.0f, this.d);
        c(new Canvas(ewk));
        canvas.drawBitmap(ewk, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap d() {
        if (this.i == null) {
            this.i = ewl();
        }
        return this.i;
    }

    private Bitmap ewk() {
        if (this.h == null) {
            this.h = ewl();
        }
        return this.h;
    }

    private Bitmap ewl() {
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
        int a2 = this.pzO.a(getWidth());
        int b2 = this.pzO.b(getHeight());
        this.b = a(a2, b2);
        Canvas canvas = new Canvas(this.b);
        switch (this.pzO.pzV) {
            case RADIAL:
                radialGradient = new RadialGradient(a2 / 2, b2 / 2, (float) (Math.max(a2, b2) / Math.sqrt(2.0d)), this.pzO.a(), this.pzO.ewm(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.pzO.pzU) {
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
                radialGradient = new LinearGradient(i4, i3, i2, i, this.pzO.a(), this.pzO.ewm(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.pzO.b, a2 / 2, b2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(a2, b2))) / 2;
        canvas.drawRect(-sqrt, -sqrt, a2 + sqrt, sqrt + b2, paint);
        return this.b;
    }

    private Animator getShimmerAnimation() {
        if (this.pzR != null) {
            return this.pzR;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass4.f4252a[this.pzO.pzV.ordinal()];
        switch (this.pzO.pzU) {
            case CW_90:
                this.pzP.a(0, -height, 0, height);
                break;
            case CW_180:
                this.pzP.a(width, 0, -width, 0);
                break;
            case CW_270:
                this.pzP.a(0, height, 0, -height);
                break;
            default:
                this.pzP.a(-width, 0, width, 0);
                break;
        }
        this.pzR = ValueAnimator.ofFloat(0.0f, 1.0f + (this.m / this.k));
        this.pzR.setDuration(this.k + this.m);
        this.pzR.setRepeatCount(this.l);
        this.pzR.setRepeatMode(this.n);
        this.pzR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.widget.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.pzP.f4255a * (1.0f - max)) + (ShimmerFrameLayout.this.pzP.c * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.pzP.d) + (ShimmerFrameLayout.this.pzP.b * (1.0f - max))));
            }
        });
        if (this.pzS != null) {
            this.pzR.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.widget.ShimmerFrameLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ShimmerFrameLayout.this.pzS != null) {
                        ShimmerFrameLayout.this.pzS.onAnimationEnd(animator);
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
        return this.pzR;
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
