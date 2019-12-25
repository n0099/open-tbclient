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
/* loaded from: classes4.dex */
public class SVGAImageView extends ImageView {
    private boolean dS;
    private ValueAnimator evC;
    private int mKC;
    private boolean mKD;
    private FillMode mKE;
    private com.opensource.svgaplayer.a mKF;

    /* loaded from: classes4.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.dS = z;
    }

    public final int getLoops() {
        return this.mKC;
    }

    public final void setLoops(int i) {
        this.mKC = i;
    }

    public final boolean getClearsAfterStop() {
        return this.mKD;
    }

    public final void setClearsAfterStop(boolean z) {
        this.mKD = z;
    }

    public final FillMode getFillMode() {
        return this.mKE;
    }

    public final void setFillMode(FillMode fillMode) {
        p.j(fillMode, "<set-?>");
        this.mKE = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.mKF;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.mKF = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.mKD = true;
        this.mKE = FillMode.Forward;
        dgJ();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKD = true;
        this.mKE = FillMode.Forward;
        dgJ();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKD = true;
        this.mKE = FillMode.Forward;
        dgJ();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dgJ() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.evC;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.evC;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.evC;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        p.i(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.mKC = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.mKD = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (p.h(string, "0")) {
                this.mKE = FillMode.Backward;
            } else if (p.h(string, "1")) {
                this.mKE = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            p.i(context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String mKG;
        final /* synthetic */ d mKH;
        final /* synthetic */ SVGAImageView mKI;
        final /* synthetic */ boolean mKJ;
        final /* synthetic */ boolean mKK;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.mKG = str;
            this.mKH = dVar;
            this.mKI = sVGAImageView;
            this.mKJ = z;
            this.mKK = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    p.j(fVar, "videoItem");
                    a.this.mKI.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.mKJ);
                            a.this.mKI.setVideoItem(fVar);
                            Drawable drawable = a.this.mKI.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.mKI.getScaleType();
                                p.i(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.mKK) {
                                a.this.mKI.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.mKG, "http://", false, 2, (Object) null) || l.a(this.mKG, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.mKH.b(new URL(this.mKG), cVar);
            } else {
                this.mKH.b(this.mKG, cVar);
            }
        }
    }

    public final void startAnimation() {
        a((com.opensource.svgaplayer.b.b) null, false);
    }

    public final void a(com.opensource.svgaplayer.b.b bVar, boolean z) {
        Field declaredField;
        vT(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar2 = (com.opensource.svgaplayer.b) drawable;
        if (bVar2 != null) {
            bVar2.vR(false);
            ImageView.ScaleType scaleType = getScaleType();
            p.i(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dzC = bVar2.dzC();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dzC.dzR() - 1, ((bVar != null ? bVar.bQo() : Integer.MAX_VALUE) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            p.i(ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dzC.getFPS())) / d));
            ofInt.setRepeatCount(this.mKC <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.mKC - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.evC = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView mKI;
        final /* synthetic */ ValueAnimator mKN;
        final /* synthetic */ com.opensource.svgaplayer.b.b mKO;
        final /* synthetic */ com.opensource.svgaplayer.b mKP;
        final /* synthetic */ boolean mKQ;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.mKN = valueAnimator;
            this.mKI = sVGAImageView;
            this.mKO = bVar;
            this.mKP = bVar2;
            this.mKQ = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.mKP;
            ValueAnimator valueAnimator2 = this.mKN;
            p.i(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Mu(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.mKI.getCallback();
            if (callback != null) {
                callback.b(this.mKP.dzB(), (this.mKP.dzB() + 1) / this.mKP.dzC().dzR());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView mKI;
        final /* synthetic */ com.opensource.svgaplayer.b.b mKO;
        final /* synthetic */ com.opensource.svgaplayer.b mKP;
        final /* synthetic */ boolean mKQ;
        final /* synthetic */ int mKR;
        final /* synthetic */ int mKS;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.mKR = i;
            this.mKS = i2;
            this.mKI = sVGAImageView;
            this.mKO = bVar;
            this.mKP = bVar2;
            this.mKQ = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.mKI.getCallback();
            if (callback != null) {
                callback.DE();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.mKI.dS = false;
            this.mKI.stopAnimation();
            if (!this.mKI.getClearsAfterStop()) {
                if (this.mKI.getFillMode() == FillMode.Backward) {
                    this.mKP.Mu(this.mKR);
                } else if (this.mKI.getFillMode() == FillMode.Forward) {
                    this.mKP.Mu(this.mKS);
                }
            }
            com.opensource.svgaplayer.a callback = this.mKI.getCallback();
            if (callback != null) {
                callback.onFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mKI.dS = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.mKI.dS = true;
        }
    }

    public final void pauseAnimation() {
        vT(false);
        com.opensource.svgaplayer.a aVar = this.mKF;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        vT(this.mKD);
    }

    public final void vT(boolean z) {
        ValueAnimator valueAnimator = this.evC;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.evC;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.evC;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.vR(z);
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
        bVar.vR(this.mKD);
        setImageDrawable(bVar);
    }
}
