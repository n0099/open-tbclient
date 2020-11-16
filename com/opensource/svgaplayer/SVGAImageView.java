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
/* loaded from: classes17.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator gBb;
    private boolean isAnimating;
    private int pEW;
    private boolean pEX;
    private FillMode pEY;
    private com.opensource.svgaplayer.a pEZ;

    @h
    /* loaded from: classes17.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.pEW;
    }

    public final void setLoops(int i) {
        this.pEW = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pEX;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pEX = z;
    }

    public final FillMode getFillMode() {
        return this.pEY;
    }

    public final void setFillMode(FillMode fillMode) {
        q.n(fillMode, "<set-?>");
        this.pEY = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pEZ;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pEZ = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pEX = true;
        this.pEY = FillMode.Forward;
        ewM();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pEX = true;
        this.pEY = FillMode.Forward;
        ewM();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pEX = true;
        this.pEY = FillMode.Forward;
        ewM();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void ewM() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.gBb;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gBb;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gBb;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.m(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pEW = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pEX = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l(string, "0")) {
                this.pEY = FillMode.Backward;
            } else if (q.l(string, "1")) {
                this.pEY = FillMode.Forward;
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
    /* loaded from: classes17.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String pFa;
        final /* synthetic */ d pFb;
        final /* synthetic */ SVGAImageView pFc;
        final /* synthetic */ boolean pFd;
        final /* synthetic */ boolean pFe;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pFa = str;
            this.pFb = dVar;
            this.pFc = sVGAImageView;
            this.pFd = z;
            this.pFe = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.n(fVar, "videoItem");
                    a.this.pFc.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pFd);
                            a.this.pFc.setVideoItem(fVar);
                            Drawable drawable = a.this.pFc.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pFc.getScaleType();
                                q.m(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pFe) {
                                a.this.pFc.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pFa, "http://", false, 2, (Object) null) || l.a(this.pFa, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pFb.b(new URL(this.pFa), cVar);
            } else {
                this.pFb.b(this.pFa, cVar);
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
            bVar2.AT(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.m(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f ewD = bVar2.ewD();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(ewD.ewT() - 1, ((bVar != null ? bVar.wo() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / ewD.getFPS())) / d));
            ofInt.setRepeatCount(this.pEW <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pEW - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.gBb = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes17.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView pFc;
        final /* synthetic */ ValueAnimator pFh;
        final /* synthetic */ com.opensource.svgaplayer.b.b pFi;
        final /* synthetic */ com.opensource.svgaplayer.b pFj;
        final /* synthetic */ boolean pFk;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pFh = valueAnimator;
            this.pFc = sVGAImageView;
            this.pFi = bVar;
            this.pFj = bVar2;
            this.pFk = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pFj;
            ValueAnimator valueAnimator2 = this.pFh;
            q.m(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Rz(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pFc.getCallback();
            if (callback != null) {
                callback.b(this.pFj.ewC(), (this.pFj.ewC() + 1) / this.pFj.ewD().ewT());
            }
        }
    }

    @h
    /* loaded from: classes17.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView pFc;
        final /* synthetic */ com.opensource.svgaplayer.b.b pFi;
        final /* synthetic */ com.opensource.svgaplayer.b pFj;
        final /* synthetic */ boolean pFk;
        final /* synthetic */ int pFl;
        final /* synthetic */ int pFm;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pFl = i;
            this.pFm = i2;
            this.pFc = sVGAImageView;
            this.pFi = bVar;
            this.pFj = bVar2;
            this.pFk = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pFc.getCallback();
            if (callback != null) {
                callback.aeT();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pFc.isAnimating = false;
            this.pFc.stopAnimation();
            if (!this.pFc.getClearsAfterStop()) {
                if (this.pFc.getFillMode() == FillMode.Backward) {
                    this.pFj.Rz(this.pFl);
                } else if (this.pFc.getFillMode() == FillMode.Forward) {
                    this.pFj.Rz(this.pFm);
                }
            }
            com.opensource.svgaplayer.a callback = this.pFc.getCallback();
            if (callback != null) {
                callback.aeS();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pFc.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pFc.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.pEZ;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.pEX);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.gBb;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gBb;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gBb;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.AT(z);
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
        bVar.AT(this.pEX);
        setImageDrawable(bVar);
    }
}
