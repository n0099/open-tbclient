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
    private ValueAnimator fgf;
    private com.opensource.svgaplayer.a mJA;
    private int mJx;
    private boolean mJy;
    private FillMode mJz;
    private boolean zD;

    @h
    /* loaded from: classes.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.zD = z;
    }

    public final int getLoops() {
        return this.mJx;
    }

    public final void setLoops(int i) {
        this.mJx = i;
    }

    public final boolean getClearsAfterStop() {
        return this.mJy;
    }

    public final void setClearsAfterStop(boolean z) {
        this.mJy = z;
    }

    public final FillMode getFillMode() {
        return this.mJz;
    }

    public final void setFillMode(FillMode fillMode) {
        q.j(fillMode, "<set-?>");
        this.mJz = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.mJA;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.mJA = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.mJy = true;
        this.mJz = FillMode.Forward;
        dzp();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mJy = true;
        this.mJz = FillMode.Forward;
        dzp();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mJy = true;
        this.mJz = FillMode.Forward;
        dzp();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dzp() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fgf;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fgf;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fgf;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.i(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.mJx = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.mJy = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.k(string, "0")) {
                this.mJz = FillMode.Backward;
            } else if (q.k(string, "1")) {
                this.mJz = FillMode.Forward;
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
        final /* synthetic */ String mJB;
        final /* synthetic */ d mJC;
        final /* synthetic */ SVGAImageView mJD;
        final /* synthetic */ boolean mJE;
        final /* synthetic */ boolean mJF;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.mJB = str;
            this.mJC = dVar;
            this.mJD = sVGAImageView;
            this.mJE = z;
            this.mJF = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.j(fVar, "videoItem");
                    a.this.mJD.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.mJE);
                            a.this.mJD.setVideoItem(fVar);
                            Drawable drawable = a.this.mJD.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.mJD.getScaleType();
                                q.i(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.mJF) {
                                a.this.mJD.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.mJB, "http://", false, 2, (Object) null) || l.a(this.mJB, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.mJC.b(new URL(this.mJB), cVar);
            } else {
                this.mJC.b(this.mJB, cVar);
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
            bVar2.wk(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.i(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dzg = bVar2.dzg();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dzg.dzw() - 1, ((bVar != null ? bVar.cdS() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dzg.getFPS())) / d));
            ofInt.setRepeatCount(this.mJx <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.mJx - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.fgf = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView mJD;
        final /* synthetic */ ValueAnimator mJI;
        final /* synthetic */ com.opensource.svgaplayer.b.b mJJ;
        final /* synthetic */ com.opensource.svgaplayer.b mJK;
        final /* synthetic */ boolean mJL;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.mJI = valueAnimator;
            this.mJD = sVGAImageView;
            this.mJJ = bVar;
            this.mJK = bVar2;
            this.mJL = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.mJK;
            ValueAnimator valueAnimator2 = this.mJI;
            q.i(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.IH(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.mJD.getCallback();
            if (callback != null) {
                callback.b(this.mJK.dzf(), (this.mJK.dzf() + 1) / this.mJK.dzg().dzw());
            }
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView mJD;
        final /* synthetic */ com.opensource.svgaplayer.b.b mJJ;
        final /* synthetic */ com.opensource.svgaplayer.b mJK;
        final /* synthetic */ boolean mJL;
        final /* synthetic */ int mJM;
        final /* synthetic */ int mJN;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.mJM = i;
            this.mJN = i2;
            this.mJD = sVGAImageView;
            this.mJJ = bVar;
            this.mJK = bVar2;
            this.mJL = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.mJD.getCallback();
            if (callback != null) {
                callback.Oi();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.mJD.zD = false;
            this.mJD.stopAnimation();
            if (!this.mJD.getClearsAfterStop()) {
                if (this.mJD.getFillMode() == FillMode.Backward) {
                    this.mJK.IH(this.mJM);
                } else if (this.mJD.getFillMode() == FillMode.Forward) {
                    this.mJK.IH(this.mJN);
                }
            }
            com.opensource.svgaplayer.a callback = this.mJD.getCallback();
            if (callback != null) {
                callback.onFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mJD.zD = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.mJD.zD = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.mJA;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.mJy);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.fgf;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fgf;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fgf;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.wk(z);
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
        bVar.wk(this.mJy);
        setImageDrawable(bVar);
    }
}
