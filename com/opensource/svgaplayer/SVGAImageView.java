package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes18.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator gJY;
    private boolean isAnimating;
    private int pyC;
    private boolean pyD;
    private FillMode pyE;
    private com.opensource.svgaplayer.a pyF;

    @kotlin.e
    /* loaded from: classes18.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.pyC;
    }

    public final void setLoops(int i) {
        this.pyC = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pyD;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pyD = z;
    }

    public final FillMode getFillMode() {
        return this.pyE;
    }

    public final void setFillMode(FillMode fillMode) {
        p.o(fillMode, "<set-?>");
        this.pyE = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pyF;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pyF = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pyD = true;
        this.pyE = FillMode.Forward;
        ezJ();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pyD = true;
        this.pyE = FillMode.Forward;
        ezJ();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pyD = true;
        this.pyE = FillMode.Forward;
        ezJ();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void ezJ() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.gJY;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gJY;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gJY;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        p.n(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pyC = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pyD = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (p.l(string, "0")) {
                this.pyE = FillMode.Backward;
            } else if (p.l(string, "1")) {
                this.pyE = FillMode.Forward;
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
    /* loaded from: classes18.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String pyG;
        final /* synthetic */ d pyH;
        final /* synthetic */ SVGAImageView pyI;
        final /* synthetic */ boolean pyJ;
        final /* synthetic */ boolean pyK;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pyG = str;
            this.pyH = dVar;
            this.pyI = sVGAImageView;
            this.pyJ = z;
            this.pyK = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    p.o(fVar, "videoItem");
                    a.this.pyI.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pyJ);
                            a.this.pyI.setVideoItem(fVar);
                            Drawable drawable = a.this.pyI.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pyI.getScaleType();
                                p.n(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pyK) {
                                a.this.pyI.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pyG, "http://", false, 2, (Object) null) || l.a(this.pyG, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pyH.b(new URL(this.pyG), cVar);
            } else {
                this.pyH.b(this.pyG, cVar);
            }
        }
    }

    public final void startAnimation() {
        a((com.opensource.svgaplayer.b.b) null, false);
    }

    public final void a(com.opensource.svgaplayer.b.b bVar, boolean z) {
        Field declaredField;
        stopAnimation(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar2 = (com.opensource.svgaplayer.b) drawable;
        if (bVar2 != null) {
            bVar2.Bh(false);
            ImageView.ScaleType scaleType = getScaleType();
            p.n(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f ezA = bVar2.ezA();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(ezA.ezQ() - 1, ((bVar != null ? bVar.wg() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / ezA.getFPS())) / d));
            ofInt.setRepeatCount(this.pyC <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pyC - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.gJY = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView pyI;
        final /* synthetic */ ValueAnimator pyN;
        final /* synthetic */ com.opensource.svgaplayer.b.b pyO;
        final /* synthetic */ com.opensource.svgaplayer.b pyP;
        final /* synthetic */ boolean pyQ;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pyN = valueAnimator;
            this.pyI = sVGAImageView;
            this.pyO = bVar;
            this.pyP = bVar2;
            this.pyQ = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pyP;
            ValueAnimator valueAnimator2 = this.pyN;
            p.n(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.RB(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pyI.getCallback();
            if (callback != null) {
                callback.b(this.pyP.ezz(), (this.pyP.ezz() + 1) / this.pyP.ezA().ezQ());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView pyI;
        final /* synthetic */ com.opensource.svgaplayer.b.b pyO;
        final /* synthetic */ com.opensource.svgaplayer.b pyP;
        final /* synthetic */ boolean pyQ;
        final /* synthetic */ int pyR;
        final /* synthetic */ int pyS;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pyR = i;
            this.pyS = i2;
            this.pyI = sVGAImageView;
            this.pyO = bVar;
            this.pyP = bVar2;
            this.pyQ = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pyI.getCallback();
            if (callback != null) {
                callback.aib();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pyI.isAnimating = false;
            this.pyI.stopAnimation();
            if (!this.pyI.getClearsAfterStop()) {
                if (this.pyI.getFillMode() == FillMode.Backward) {
                    this.pyP.RB(this.pyR);
                } else if (this.pyI.getFillMode() == FillMode.Forward) {
                    this.pyP.RB(this.pyS);
                }
            }
            com.opensource.svgaplayer.a callback = this.pyI.getCallback();
            if (callback != null) {
                callback.aia();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pyI.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pyI.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.pyF;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.pyD);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.gJY;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gJY;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gJY;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.Bh(z);
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
        bVar.Bh(this.pyD);
        setImageDrawable(bVar);
    }
}
