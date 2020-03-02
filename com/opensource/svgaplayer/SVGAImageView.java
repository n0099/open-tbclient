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
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes.dex */
public class SVGAImageView extends ImageView {
    private boolean dS;
    private ValueAnimator eAY;
    private int nkM;
    private boolean nkN;
    private FillMode nkO;
    private com.opensource.svgaplayer.a nkP;

    @h
    /* loaded from: classes.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.dS = z;
    }

    public final int getLoops() {
        return this.nkM;
    }

    public final void setLoops(int i) {
        this.nkM = i;
    }

    public final boolean getClearsAfterStop() {
        return this.nkN;
    }

    public final void setClearsAfterStop(boolean z) {
        this.nkN = z;
    }

    public final FillMode getFillMode() {
        return this.nkO;
    }

    public final void setFillMode(FillMode fillMode) {
        q.j(fillMode, "<set-?>");
        this.nkO = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.nkP;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.nkP = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.nkN = true;
        this.nkO = FillMode.Forward;
        djd();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nkN = true;
        this.nkO = FillMode.Forward;
        djd();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nkN = true;
        this.nkO = FillMode.Forward;
        djd();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void djd() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.eAY;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.eAY;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.eAY;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.i(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.nkM = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.nkN = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.h(string, "0")) {
                this.nkO = FillMode.Backward;
            } else if (q.h(string, "1")) {
                this.nkO = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            q.i(context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String nkQ;
        final /* synthetic */ d nkR;
        final /* synthetic */ SVGAImageView nkS;
        final /* synthetic */ boolean nkT;
        final /* synthetic */ boolean nkU;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.nkQ = str;
            this.nkR = dVar;
            this.nkS = sVGAImageView;
            this.nkT = z;
            this.nkU = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.j(fVar, "videoItem");
                    a.this.nkS.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.nkT);
                            a.this.nkS.setVideoItem(fVar);
                            Drawable drawable = a.this.nkS.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.nkS.getScaleType();
                                q.i(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.nkU) {
                                a.this.nkS.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.nkQ, "http://", false, 2, (Object) null) || l.a(this.nkQ, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.nkR.b(new URL(this.nkQ), cVar);
            } else {
                this.nkR.b(this.nkQ, cVar);
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
            bVar2.wu(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.i(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dEG = bVar2.dEG();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dEG.dEV() - 1, ((bVar != null ? bVar.bTa() : Integer.MAX_VALUE) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            q.i(ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dEG.getFPS())) / d));
            ofInt.setRepeatCount(this.nkM <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.nkM - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.eAY = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView nkS;
        final /* synthetic */ ValueAnimator nkX;
        final /* synthetic */ com.opensource.svgaplayer.b.b nkY;
        final /* synthetic */ com.opensource.svgaplayer.b nkZ;
        final /* synthetic */ boolean nla;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nkX = valueAnimator;
            this.nkS = sVGAImageView;
            this.nkY = bVar;
            this.nkZ = bVar2;
            this.nla = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.nkZ;
            ValueAnimator valueAnimator2 = this.nkX;
            q.i(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Nh(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.nkS.getCallback();
            if (callback != null) {
                callback.b(this.nkZ.dEF(), (this.nkZ.dEF() + 1) / this.nkZ.dEG().dEV());
            }
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView nkS;
        final /* synthetic */ com.opensource.svgaplayer.b.b nkY;
        final /* synthetic */ com.opensource.svgaplayer.b nkZ;
        final /* synthetic */ boolean nla;
        final /* synthetic */ int nlb;
        final /* synthetic */ int nlc;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nlb = i;
            this.nlc = i2;
            this.nkS = sVGAImageView;
            this.nkY = bVar;
            this.nkZ = bVar2;
            this.nla = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.nkS.getCallback();
            if (callback != null) {
                callback.Gr();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.nkS.dS = false;
            this.nkS.stopAnimation();
            if (!this.nkS.getClearsAfterStop()) {
                if (this.nkS.getFillMode() == FillMode.Backward) {
                    this.nkZ.Nh(this.nlb);
                } else if (this.nkS.getFillMode() == FillMode.Forward) {
                    this.nkZ.Nh(this.nlc);
                }
            }
            com.opensource.svgaplayer.a callback = this.nkS.getCallback();
            if (callback != null) {
                callback.onFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.nkS.dS = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.nkS.dS = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.nkP;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.nkN);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.eAY;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.eAY;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.eAY;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.wu(z);
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
        bVar.wu(this.nkN);
        setImageDrawable(bVar);
    }
}
