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
/* loaded from: classes15.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator glB;
    private boolean isAnimating;
    private int oCD;
    private boolean oCE;
    private FillMode oCF;
    private com.opensource.svgaplayer.a oCG;

    @h
    /* loaded from: classes15.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.oCD;
    }

    public final void setLoops(int i) {
        this.oCD = i;
    }

    public final boolean getClearsAfterStop() {
        return this.oCE;
    }

    public final void setClearsAfterStop(boolean z) {
        this.oCE = z;
    }

    public final FillMode getFillMode() {
        return this.oCF;
    }

    public final void setFillMode(FillMode fillMode) {
        q.n(fillMode, "<set-?>");
        this.oCF = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.oCG;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.oCG = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.oCE = true;
        this.oCF = FillMode.Forward;
        eiW();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oCE = true;
        this.oCF = FillMode.Forward;
        eiW();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oCE = true;
        this.oCF = FillMode.Forward;
        eiW();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void eiW() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.glB;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.glB;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.glB;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.m(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.oCD = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.oCE = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l(string, "0")) {
                this.oCF = FillMode.Backward;
            } else if (q.l(string, "1")) {
                this.oCF = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            q.m(context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes15.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String oCH;
        final /* synthetic */ d oCI;
        final /* synthetic */ SVGAImageView oCJ;
        final /* synthetic */ boolean oCK;
        final /* synthetic */ boolean oCL;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.oCH = str;
            this.oCI = dVar;
            this.oCJ = sVGAImageView;
            this.oCK = z;
            this.oCL = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.n(fVar, "videoItem");
                    a.this.oCJ.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.oCK);
                            a.this.oCJ.setVideoItem(fVar);
                            Drawable drawable = a.this.oCJ.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.oCJ.getScaleType();
                                q.m(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.oCL) {
                                a.this.oCJ.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.oCH, "http://", false, 2, (Object) null) || l.a(this.oCH, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.oCI.b(new URL(this.oCH), cVar);
            } else {
                this.oCI.b(this.oCH, cVar);
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
            bVar2.zt(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.m(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f eiN = bVar2.eiN();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(eiN.ejd() - 1, ((bVar != null ? bVar.wp() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            q.m(ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / eiN.getFPS())) / d));
            ofInt.setRepeatCount(this.oCD <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.oCD - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.glB = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes15.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView oCJ;
        final /* synthetic */ ValueAnimator oCO;
        final /* synthetic */ com.opensource.svgaplayer.b.b oCP;
        final /* synthetic */ com.opensource.svgaplayer.b oCQ;
        final /* synthetic */ boolean oCR;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.oCO = valueAnimator;
            this.oCJ = sVGAImageView;
            this.oCP = bVar;
            this.oCQ = bVar2;
            this.oCR = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.oCQ;
            ValueAnimator valueAnimator2 = this.oCO;
            q.m(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.OK(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.oCJ.getCallback();
            if (callback != null) {
                callback.b(this.oCQ.eiM(), (this.oCQ.eiM() + 1) / this.oCQ.eiN().ejd());
            }
        }
    }

    @h
    /* loaded from: classes15.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView oCJ;
        final /* synthetic */ com.opensource.svgaplayer.b.b oCP;
        final /* synthetic */ com.opensource.svgaplayer.b oCQ;
        final /* synthetic */ boolean oCR;
        final /* synthetic */ int oCS;
        final /* synthetic */ int oCT;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.oCS = i;
            this.oCT = i2;
            this.oCJ = sVGAImageView;
            this.oCP = bVar;
            this.oCQ = bVar2;
            this.oCR = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.oCJ.getCallback();
            if (callback != null) {
                callback.abh();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.oCJ.isAnimating = false;
            this.oCJ.stopAnimation();
            if (!this.oCJ.getClearsAfterStop()) {
                if (this.oCJ.getFillMode() == FillMode.Backward) {
                    this.oCQ.OK(this.oCS);
                } else if (this.oCJ.getFillMode() == FillMode.Forward) {
                    this.oCQ.OK(this.oCT);
                }
            }
            com.opensource.svgaplayer.a callback = this.oCJ.getCallback();
            if (callback != null) {
                callback.abg();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.oCJ.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.oCJ.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.oCG;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.oCE);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.glB;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.glB;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.glB;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.zt(z);
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
        bVar.zt(this.oCE);
        setImageDrawable(bVar);
    }
}
