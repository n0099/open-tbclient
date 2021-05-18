package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAParser;
import java.lang.reflect.Field;
import java.net.URL;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001LB\u0013\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FB\u001d\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bE\u0010GB%\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010H\u001a\u00020\u0018¢\u0006\u0004\bE\u0010IB-\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010H\u001a\u00020\u0018\u0012\u0006\u0010J\u001a\u00020\u0018¢\u0006\u0004\bE\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\bJ!\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0012\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\bJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b!\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010#R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010;\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b;\u00101\"\u0004\b<\u0010#R\"\u0010=\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006M"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/widget/ImageView;", "Landroid/util/AttributeSet;", "attrs", "", "loadAttrs", "(Landroid/util/AttributeSet;)V", "onDetachedFromWindow", "()V", "pauseAnimation", "setSoftwareLayerType", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "setVideoItem", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;)V", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "dynamicItem", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "startAnimation", "Lcom/opensource/svgaplayer/utils/SVGARange;", "range", "", "reverse", "(Lcom/opensource/svgaplayer/utils/SVGARange;Z)V", "", "frame", "andPlay", "stepToFrame", "(IZ)V", "", "percentage", "stepToPercentage", "(DZ)V", "stopAnimation", "clear", "(Z)V", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "Lcom/opensource/svgaplayer/SVGACallback;", "callback", "Lcom/opensource/svgaplayer/SVGACallback;", "getCallback", "()Lcom/opensource/svgaplayer/SVGACallback;", "setCallback", "(Lcom/opensource/svgaplayer/SVGACallback;)V", "clearsAfterStop", "Z", "getClearsAfterStop", "()Z", "setClearsAfterStop", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "fillMode", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "getFillMode", "()Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "setFillMode", "(Lcom/opensource/svgaplayer/SVGAImageView$FillMode;)V", "<set-?>", "isAnimating", "setAnimating", "loops", "I", "getLoops", "()I", "setLoops", "(I)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FillMode", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public class SVGAImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f35103e;

    /* renamed from: f  reason: collision with root package name */
    public int f35104f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35105g;

    /* renamed from: h  reason: collision with root package name */
    public FillMode f35106h;

    /* renamed from: i  reason: collision with root package name */
    public d.l.a.a f35107i;
    public ValueAnimator j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "Backward", "Forward", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes6.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    /* loaded from: classes6.dex */
    public static final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f35108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SVGAParser f35109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SVGAImageView f35110g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f35111h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f35112i;

        /* renamed from: com.opensource.svgaplayer.SVGAImageView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0406a implements SVGAParser.b {

            /* renamed from: com.opensource.svgaplayer.SVGAImageView$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public static final class RunnableC0407a implements Runnable {

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SVGAVideoEntity f35115f;

                public RunnableC0407a(SVGAVideoEntity sVGAVideoEntity) {
                    this.f35115f = sVGAVideoEntity;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f35115f.o(a.this.f35111h);
                    a.this.f35110g.setVideoItem(this.f35115f);
                    Drawable drawable = a.this.f35110g.getDrawable();
                    if (!(drawable instanceof d.l.a.b)) {
                        drawable = null;
                    }
                    d.l.a.b bVar = (d.l.a.b) drawable;
                    if (bVar != null) {
                        ImageView.ScaleType scaleType = a.this.f35110g.getScaleType();
                        Intrinsics.checkExpressionValueIsNotNull(scaleType, "scaleType");
                        bVar.e(scaleType);
                    }
                    a aVar = a.this;
                    if (aVar.f35112i) {
                        aVar.f35110g.d();
                    }
                }
            }

            public C0406a() {
            }

            @Override // com.opensource.svgaplayer.SVGAParser.b
            public void a(SVGAVideoEntity sVGAVideoEntity) {
                a.this.f35110g.post(new RunnableC0407a(sVGAVideoEntity));
            }

            @Override // com.opensource.svgaplayer.SVGAParser.b
            public void onError() {
            }
        }

        public a(String str, SVGAParser sVGAParser, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.f35108e = str;
            this.f35109f = sVGAParser;
            this.f35110g = sVGAImageView;
            this.f35111h = z;
            this.f35112i = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0406a c0406a = new C0406a();
            if (!StringsKt__StringsJVMKt.startsWith$default(this.f35108e, "http://", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(this.f35108e, "https://", false, 2, null)) {
                this.f35109f.v(this.f35108e, c0406a);
            } else {
                this.f35109f.w(new URL(this.f35108e), c0406a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f35116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SVGAImageView f35117f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b f35118g;

        public b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, d.l.a.h.b bVar, d.l.a.b bVar2, boolean z) {
            this.f35116e = valueAnimator;
            this.f35117f = sVGAImageView;
            this.f35118g = bVar2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.l.a.b bVar = this.f35118g;
            ValueAnimator animator = this.f35116e;
            Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
            Object animatedValue = animator.getAnimatedValue();
            if (animatedValue != null) {
                bVar.d(((Integer) animatedValue).intValue());
                d.l.a.a callback = this.f35117f.getCallback();
                if (callback != null) {
                    callback.b(this.f35118g.a(), (this.f35118g.a() + 1) / this.f35118g.b().d());
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f35120f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SVGAImageView f35121g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b f35122h;

        public c(int i2, int i3, SVGAImageView sVGAImageView, d.l.a.h.b bVar, d.l.a.b bVar2, boolean z) {
            this.f35119e = i2;
            this.f35120f = i3;
            this.f35121g = sVGAImageView;
            this.f35122h = bVar2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f35121g.f35103e = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f35121g.f35103e = false;
            this.f35121g.f();
            if (!this.f35121g.getClearsAfterStop()) {
                if (this.f35121g.getFillMode() == FillMode.Backward) {
                    this.f35122h.d(this.f35119e);
                } else if (this.f35121g.getFillMode() == FillMode.Forward) {
                    this.f35122h.d(this.f35120f);
                }
            }
            d.l.a.a callback = this.f35121g.getCallback();
            if (callback != null) {
                callback.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            d.l.a.a callback = this.f35121g.getCallback();
            if (callback != null) {
                callback.c();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f35121g.f35103e = true;
        }
    }

    public SVGAImageView(Context context) {
        super(context);
        this.f35105g = true;
        this.f35106h = FillMode.Forward;
        c();
    }

    private final void setAnimating(boolean z) {
    }

    public final void b(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.f35104f = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.f35105g = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (Intrinsics.areEqual(string, "0")) {
                this.f35106h = FillMode.Backward;
            } else if (Intrinsics.areEqual(string, "1")) {
                this.f35106h = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            new Thread(new a(string2, new SVGAParser(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public final void d() {
        e(null, false);
    }

    public final void e(d.l.a.h.b bVar, boolean z) {
        Field declaredField;
        g(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof d.l.a.b)) {
            drawable = null;
        }
        d.l.a.b bVar2 = (d.l.a.b) drawable;
        if (bVar2 != null) {
            bVar2.c(false);
            ImageView.ScaleType scaleType = getScaleType();
            Intrinsics.checkExpressionValueIsNotNull(scaleType, "scaleType");
            bVar2.e(scaleType);
            SVGAVideoEntity b2 = bVar2.b();
            if (bVar == null) {
                int max = Math.max(0, 0);
                int d2 = b2.d() - 1;
                if (bVar != null) {
                    bVar.b();
                    throw null;
                } else if (bVar == null) {
                    int min = Math.min(d2, (Integer.MAX_VALUE + 0) - 1);
                    ValueAnimator animator = ValueAnimator.ofInt(max, min);
                    double d3 = 1.0d;
                    try {
                        Class<?> cls = Class.forName("android.animation.ValueAnimator");
                        if (cls != null && (declaredField = cls.getDeclaredField("sDurationScale")) != null) {
                            declaredField.setAccessible(true);
                            double d4 = declaredField.getFloat(cls);
                            if (d4 == 0.0d) {
                                try {
                                    declaredField.setFloat(cls, 1.0f);
                                    Log.e("SVGAPlayer", "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                                } catch (Exception unused) {
                                }
                            }
                            d3 = d4;
                        }
                    } catch (Exception unused2) {
                    }
                    Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
                    animator.setInterpolator(new LinearInterpolator());
                    animator.setDuration((long) ((((min - max) + 1) * (1000 / b2.c())) / d3));
                    int i2 = this.f35104f;
                    animator.setRepeatCount(i2 <= 0 ? 99999 : i2 - 1);
                    animator.addUpdateListener(new b(animator, this, bVar, bVar2, z));
                    animator.addListener(new c(max, min, this, bVar, bVar2, z));
                    if (z) {
                        animator.reverse();
                    } else {
                        animator.start();
                    }
                    this.j = animator;
                    return;
                } else {
                    bVar.a();
                    throw null;
                }
            }
            bVar.b();
            throw null;
        }
    }

    public final void f() {
        g(this.f35105g);
    }

    public final void g(boolean z) {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.j;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.j;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof d.l.a.b)) {
            drawable = null;
        }
        d.l.a.b bVar = (d.l.a.b) drawable;
        if (bVar != null) {
            bVar.c(z);
        }
    }

    public final d.l.a.a getCallback() {
        return this.f35107i;
    }

    public final boolean getClearsAfterStop() {
        return this.f35105g;
    }

    public final FillMode getFillMode() {
        return this.f35106h;
    }

    public final int getLoops() {
        return this.f35104f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.j;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.j;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    public final void setCallback(d.l.a.a aVar) {
        this.f35107i = aVar;
    }

    public final void setClearsAfterStop(boolean z) {
        this.f35105g = z;
    }

    public final void setFillMode(FillMode fillMode) {
        this.f35106h = fillMode;
    }

    public final void setLoops(int i2) {
        this.f35104f = i2;
    }

    public final void setVideoItem(SVGAVideoEntity sVGAVideoEntity) {
        setVideoItem(sVGAVideoEntity, new d.l.a.c());
    }

    public final void setVideoItem(SVGAVideoEntity sVGAVideoEntity, d.l.a.c cVar) {
        if (sVGAVideoEntity == null) {
            setImageDrawable(null);
            return;
        }
        if (cVar == null) {
            cVar = new d.l.a.c();
        }
        d.l.a.b bVar = new d.l.a.b(sVGAVideoEntity, cVar);
        bVar.c(this.f35105g);
        setImageDrawable(bVar);
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35105g = true;
        this.f35106h = FillMode.Forward;
        c();
        if (attributeSet != null) {
            b(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35105g = true;
        this.f35106h = FillMode.Forward;
        c();
        if (attributeSet != null) {
            b(attributeSet);
        }
    }
}
