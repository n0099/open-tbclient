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
    private ValueAnimator gKa;
    private boolean isAnimating;
    private int pyE;
    private boolean pyF;
    private FillMode pyG;
    private com.opensource.svgaplayer.a pyH;

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
        return this.pyE;
    }

    public final void setLoops(int i) {
        this.pyE = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pyF;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pyF = z;
    }

    public final FillMode getFillMode() {
        return this.pyG;
    }

    public final void setFillMode(FillMode fillMode) {
        p.o(fillMode, "<set-?>");
        this.pyG = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pyH;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pyH = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pyF = true;
        this.pyG = FillMode.Forward;
        ezK();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pyF = true;
        this.pyG = FillMode.Forward;
        ezK();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pyF = true;
        this.pyG = FillMode.Forward;
        ezK();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void ezK() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.gKa;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gKa;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gKa;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        p.n(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pyE = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pyF = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (p.l(string, "0")) {
                this.pyG = FillMode.Backward;
            } else if (p.l(string, "1")) {
                this.pyG = FillMode.Forward;
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
        final /* synthetic */ String pyI;
        final /* synthetic */ d pyJ;
        final /* synthetic */ SVGAImageView pyK;
        final /* synthetic */ boolean pyL;
        final /* synthetic */ boolean pyM;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pyI = str;
            this.pyJ = dVar;
            this.pyK = sVGAImageView;
            this.pyL = z;
            this.pyM = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    p.o(fVar, "videoItem");
                    a.this.pyK.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pyL);
                            a.this.pyK.setVideoItem(fVar);
                            Drawable drawable = a.this.pyK.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pyK.getScaleType();
                                p.n(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pyM) {
                                a.this.pyK.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pyI, "http://", false, 2, (Object) null) || l.a(this.pyI, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pyJ.b(new URL(this.pyI), cVar);
            } else {
                this.pyJ.b(this.pyI, cVar);
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
            f ezB = bVar2.ezB();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(ezB.ezR() - 1, ((bVar != null ? bVar.wg() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / ezB.getFPS())) / d));
            ofInt.setRepeatCount(this.pyE <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pyE - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.gKa = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView pyK;
        final /* synthetic */ ValueAnimator pyP;
        final /* synthetic */ com.opensource.svgaplayer.b.b pyQ;
        final /* synthetic */ com.opensource.svgaplayer.b pyR;
        final /* synthetic */ boolean pyS;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pyP = valueAnimator;
            this.pyK = sVGAImageView;
            this.pyQ = bVar;
            this.pyR = bVar2;
            this.pyS = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pyR;
            ValueAnimator valueAnimator2 = this.pyP;
            p.n(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.RB(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pyK.getCallback();
            if (callback != null) {
                callback.b(this.pyR.ezA(), (this.pyR.ezA() + 1) / this.pyR.ezB().ezR());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView pyK;
        final /* synthetic */ com.opensource.svgaplayer.b.b pyQ;
        final /* synthetic */ com.opensource.svgaplayer.b pyR;
        final /* synthetic */ boolean pyS;
        final /* synthetic */ int pyT;
        final /* synthetic */ int pyU;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pyT = i;
            this.pyU = i2;
            this.pyK = sVGAImageView;
            this.pyQ = bVar;
            this.pyR = bVar2;
            this.pyS = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pyK.getCallback();
            if (callback != null) {
                callback.aib();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pyK.isAnimating = false;
            this.pyK.stopAnimation();
            if (!this.pyK.getClearsAfterStop()) {
                if (this.pyK.getFillMode() == FillMode.Backward) {
                    this.pyR.RB(this.pyT);
                } else if (this.pyK.getFillMode() == FillMode.Forward) {
                    this.pyR.RB(this.pyU);
                }
            }
            com.opensource.svgaplayer.a callback = this.pyK.getCallback();
            if (callback != null) {
                callback.aia();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pyK.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pyK.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.pyH;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.pyF);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.gKa;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gKa;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gKa;
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
        bVar.Bh(this.pyF);
        setImageDrawable(bVar);
    }
}
