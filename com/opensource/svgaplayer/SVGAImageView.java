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
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes.dex */
public class SVGAImageView extends ImageView {
    private boolean Ae;
    private ValueAnimator fFg;
    private int nAE;
    private boolean nAF;
    private FillMode nAG;
    private com.opensource.svgaplayer.a nAH;

    @h
    /* loaded from: classes.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.Ae = z;
    }

    public final int getLoops() {
        return this.nAE;
    }

    public final void setLoops(int i) {
        this.nAE = i;
    }

    public final boolean getClearsAfterStop() {
        return this.nAF;
    }

    public final void setClearsAfterStop(boolean z) {
        this.nAF = z;
    }

    public final FillMode getFillMode() {
        return this.nAG;
    }

    public final void setFillMode(FillMode fillMode) {
        q.m(fillMode, "<set-?>");
        this.nAG = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.nAH;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.nAH = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.nAF = true;
        this.nAG = FillMode.Forward;
        dLG();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nAF = true;
        this.nAG = FillMode.Forward;
        dLG();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nAF = true;
        this.nAG = FillMode.Forward;
        dLG();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dLG() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fFg;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fFg;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fFg;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.l((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.nAE = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.nAF = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l((Object) string, (Object) "0")) {
                this.nAG = FillMode.Backward;
            } else if (q.l((Object) string, (Object) "1")) {
                this.nAG = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            q.l((Object) context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String nAI;
        final /* synthetic */ d nAJ;
        final /* synthetic */ SVGAImageView nAK;
        final /* synthetic */ boolean nAL;
        final /* synthetic */ boolean nAM;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.nAI = str;
            this.nAJ = dVar;
            this.nAK = sVGAImageView;
            this.nAL = z;
            this.nAM = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.m(fVar, "videoItem");
                    a.this.nAK.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.nAL);
                            a.this.nAK.setVideoItem(fVar);
                            Drawable drawable = a.this.nAK.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.nAK.getScaleType();
                                q.l((Object) scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.nAM) {
                                a.this.nAK.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.nAI, "http://", false, 2, (Object) null) || l.a(this.nAI, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.nAJ.b(new URL(this.nAI), cVar);
            } else {
                this.nAJ.b(this.nAI, cVar);
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
            bVar2.xf(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.l((Object) scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dLx = bVar2.dLx();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dLx.dLN() - 1, ((bVar != null ? bVar.cop() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            q.l((Object) ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dLx.getFPS())) / d));
            ofInt.setRepeatCount(this.nAE <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.nAE - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.fFg = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView nAK;
        final /* synthetic */ ValueAnimator nAP;
        final /* synthetic */ com.opensource.svgaplayer.b.b nAQ;
        final /* synthetic */ com.opensource.svgaplayer.b nAR;
        final /* synthetic */ boolean nAS;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nAP = valueAnimator;
            this.nAK = sVGAImageView;
            this.nAQ = bVar;
            this.nAR = bVar2;
            this.nAS = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.nAR;
            ValueAnimator valueAnimator2 = this.nAP;
            q.l((Object) valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.KB(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.nAK.getCallback();
            if (callback != null) {
                callback.b(this.nAR.dLw(), (this.nAR.dLw() + 1) / this.nAR.dLx().dLN());
            }
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView nAK;
        final /* synthetic */ com.opensource.svgaplayer.b.b nAQ;
        final /* synthetic */ com.opensource.svgaplayer.b nAR;
        final /* synthetic */ boolean nAS;
        final /* synthetic */ int nAT;
        final /* synthetic */ int nAU;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nAT = i;
            this.nAU = i2;
            this.nAK = sVGAImageView;
            this.nAQ = bVar;
            this.nAR = bVar2;
            this.nAS = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.nAK.getCallback();
            if (callback != null) {
                callback.RC();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.nAK.Ae = false;
            this.nAK.stopAnimation();
            if (!this.nAK.getClearsAfterStop()) {
                if (this.nAK.getFillMode() == FillMode.Backward) {
                    this.nAR.KB(this.nAT);
                } else if (this.nAK.getFillMode() == FillMode.Forward) {
                    this.nAR.KB(this.nAU);
                }
            }
            com.opensource.svgaplayer.a callback = this.nAK.getCallback();
            if (callback != null) {
                callback.RB();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.nAK.Ae = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.nAK.Ae = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.nAH;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.nAF);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.fFg;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fFg;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fFg;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.xf(z);
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
        bVar.xf(this.nAF);
        setImageDrawable(bVar);
    }
}
