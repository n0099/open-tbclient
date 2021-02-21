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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.utils.SapiUtils;
import com.opensource.svgaplayer.d;
import java.lang.reflect.Field;
import java.net.URL;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
import kotlin.text.l;
@kotlin.e
/* loaded from: classes6.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator animator;
    private boolean isAnimating;
    private int pYW;
    private boolean pYX;
    private FillMode pYY;
    private com.opensource.svgaplayer.a pYZ;

    @kotlin.e
    /* loaded from: classes6.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.pYW;
    }

    public final void setLoops(int i) {
        this.pYW = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pYX;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pYX = z;
    }

    public final FillMode getFillMode() {
        return this.pYY;
    }

    public final void setFillMode(FillMode fillMode) {
        p.o(fillMode, "<set-?>");
        this.pYY = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pYZ;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pYZ = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pYX = true;
        this.pYY = FillMode.Forward;
        eCN();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pYX = true;
        this.pYY = FillMode.Forward;
        eCN();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pYX = true;
        this.pYY = FillMode.Forward;
        eCN();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void eCN() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        p.n(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pYW = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pYX = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (p.l(string, "0")) {
                this.pYY = FillMode.Backward;
            } else if (p.l(string, "1")) {
                this.pYY = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            p.n(context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String pZa;
        final /* synthetic */ d pZb;
        final /* synthetic */ SVGAImageView pZc;
        final /* synthetic */ boolean pZd;
        final /* synthetic */ boolean pZe;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pZa = str;
            this.pZb = dVar;
            this.pZc = sVGAImageView;
            this.pZd = z;
            this.pZe = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    p.o(fVar, "videoItem");
                    a.this.pZc.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pZd);
                            a.this.pZc.setVideoItem(fVar);
                            Drawable drawable = a.this.pZc.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pZc.getScaleType();
                                p.n(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pZe) {
                                a.this.pZc.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pZa, "http://", false, 2, (Object) null) || l.a(this.pZa, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pZb.b(new URL(this.pZa), cVar);
            } else {
                this.pZb.b(this.pZa, cVar);
            }
        }
    }

    public final void startAnimation() {
        a((com.opensource.svgaplayer.b.b) null, false);
    }

    public final void a(com.opensource.svgaplayer.b.b bVar, boolean z) {
        Field declaredField;
        BI(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar2 = (com.opensource.svgaplayer.b) drawable;
        if (bVar2 != null) {
            bVar2.BG(false);
            ImageView.ScaleType scaleType = getScaleType();
            p.n(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f eCE = bVar2.eCE();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(eCE.eCU() - 1, ((bVar != null ? bVar.eDC() : Integer.MAX_VALUE) + (bVar != null ? bVar.getLocation() : 0)) - 1);
            ValueAnimator ofInt = ValueAnimator.ofInt(max, min);
            try {
                Class<?> cls = Class.forName("android.animation.ValueAnimator");
                if (cls != null && (declaredField = cls.getDeclaredField("sDurationScale")) != null) {
                    declaredField.setAccessible(true);
                    d = declaredField.getFloat(cls);
                    if (d == 0.0d) {
                        declaredField.setFloat(cls, 1.0f);
                        d = 1.0d;
                        Log.e("SVGAPlayer", "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                    }
                }
            } catch (Exception e) {
            }
            p.n(ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / eCE.getFPS())) / d));
            ofInt.setRepeatCount(this.pYW <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pYW - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.animator = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView pZc;
        final /* synthetic */ ValueAnimator pZh;
        final /* synthetic */ com.opensource.svgaplayer.b.b pZi;
        final /* synthetic */ com.opensource.svgaplayer.b pZj;
        final /* synthetic */ boolean pZk;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pZh = valueAnimator;
            this.pZc = sVGAImageView;
            this.pZi = bVar;
            this.pZj = bVar2;
            this.pZk = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pZj;
            ValueAnimator valueAnimator2 = this.pZh;
            p.n(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.QD(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pZc.getCallback();
            if (callback != null) {
                callback.d(this.pZj.eCD(), (this.pZj.eCD() + 1) / this.pZj.eCE().eCU());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView pZc;
        final /* synthetic */ com.opensource.svgaplayer.b.b pZi;
        final /* synthetic */ com.opensource.svgaplayer.b pZj;
        final /* synthetic */ boolean pZk;
        final /* synthetic */ int pZl;
        final /* synthetic */ int pZm;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pZl = i;
            this.pZm = i2;
            this.pZc = sVGAImageView;
            this.pZi = bVar;
            this.pZj = bVar2;
            this.pZk = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pZc.getCallback();
            if (callback != null) {
                callback.eCC();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pZc.isAnimating = false;
            this.pZc.stopAnimation();
            if (!this.pZc.getClearsAfterStop()) {
                if (this.pZc.getFillMode() == FillMode.Backward) {
                    this.pZj.QD(this.pZl);
                } else if (this.pZc.getFillMode() == FillMode.Forward) {
                    this.pZj.QD(this.pZm);
                }
            }
            com.opensource.svgaplayer.a callback = this.pZc.getCallback();
            if (callback != null) {
                callback.ciA();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pZc.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pZc.isAnimating = true;
        }
    }

    public final void stopAnimation() {
        BI(this.pYX);
    }

    public final void BI(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.BG(z);
        }
    }

    public final void setVideoItem(f fVar) {
        setVideoItem(fVar, new com.opensource.svgaplayer.c());
    }

    public final void setVideoItem(f fVar, com.opensource.svgaplayer.c cVar) {
        if (fVar == null) {
            setImageDrawable(null);
            return;
        }
        if (cVar == null) {
            cVar = new com.opensource.svgaplayer.c();
        }
        com.opensource.svgaplayer.b bVar = new com.opensource.svgaplayer.b(fVar, cVar);
        bVar.BG(this.pYX);
        setImageDrawable(bVar);
    }
}
