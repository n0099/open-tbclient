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
    private ValueAnimator gBu;
    private boolean isAnimating;
    private int pDt;
    private boolean pDu;
    private FillMode pDv;
    private com.opensource.svgaplayer.a pDw;

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
        return this.pDt;
    }

    public final void setLoops(int i) {
        this.pDt = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pDu;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pDu = z;
    }

    public final FillMode getFillMode() {
        return this.pDv;
    }

    public final void setFillMode(FillMode fillMode) {
        q.n(fillMode, "<set-?>");
        this.pDv = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pDw;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pDw = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pDu = true;
        this.pDv = FillMode.Forward;
        ewL();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pDu = true;
        this.pDv = FillMode.Forward;
        ewL();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pDu = true;
        this.pDv = FillMode.Forward;
        ewL();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void ewL() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.gBu;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gBu;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gBu;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.m(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pDt = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pDu = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l(string, "0")) {
                this.pDv = FillMode.Backward;
            } else if (q.l(string, "1")) {
                this.pDv = FillMode.Forward;
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
        final /* synthetic */ boolean pDA;
        final /* synthetic */ boolean pDB;
        final /* synthetic */ String pDx;
        final /* synthetic */ d pDy;
        final /* synthetic */ SVGAImageView pDz;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pDx = str;
            this.pDy = dVar;
            this.pDz = sVGAImageView;
            this.pDA = z;
            this.pDB = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.n(fVar, "videoItem");
                    a.this.pDz.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pDA);
                            a.this.pDz.setVideoItem(fVar);
                            Drawable drawable = a.this.pDz.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pDz.getScaleType();
                                q.m(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pDB) {
                                a.this.pDz.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pDx, "http://", false, 2, (Object) null) || l.a(this.pDx, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pDy.b(new URL(this.pDx), cVar);
            } else {
                this.pDy.b(this.pDx, cVar);
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
            bVar2.AM(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.m(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f ewC = bVar2.ewC();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(ewC.ewS() - 1, ((bVar != null ? bVar.wp() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / ewC.getFPS())) / d));
            ofInt.setRepeatCount(this.pDt <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pDt - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.gBu = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes15.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ValueAnimator pDE;
        final /* synthetic */ com.opensource.svgaplayer.b.b pDF;
        final /* synthetic */ com.opensource.svgaplayer.b pDG;
        final /* synthetic */ boolean pDH;
        final /* synthetic */ SVGAImageView pDz;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pDE = valueAnimator;
            this.pDz = sVGAImageView;
            this.pDF = bVar;
            this.pDG = bVar2;
            this.pDH = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pDG;
            ValueAnimator valueAnimator2 = this.pDE;
            q.m(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.QW(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pDz.getCallback();
            if (callback != null) {
                callback.b(this.pDG.ewB(), (this.pDG.ewB() + 1) / this.pDG.ewC().ewS());
            }
        }
    }

    @h
    /* loaded from: classes15.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ com.opensource.svgaplayer.b.b pDF;
        final /* synthetic */ com.opensource.svgaplayer.b pDG;
        final /* synthetic */ boolean pDH;
        final /* synthetic */ int pDI;
        final /* synthetic */ int pDJ;
        final /* synthetic */ SVGAImageView pDz;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pDI = i;
            this.pDJ = i2;
            this.pDz = sVGAImageView;
            this.pDF = bVar;
            this.pDG = bVar2;
            this.pDH = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pDz.getCallback();
            if (callback != null) {
                callback.afB();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pDz.isAnimating = false;
            this.pDz.stopAnimation();
            if (!this.pDz.getClearsAfterStop()) {
                if (this.pDz.getFillMode() == FillMode.Backward) {
                    this.pDG.QW(this.pDI);
                } else if (this.pDz.getFillMode() == FillMode.Forward) {
                    this.pDG.QW(this.pDJ);
                }
            }
            com.opensource.svgaplayer.a callback = this.pDz.getCallback();
            if (callback != null) {
                callback.afA();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pDz.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pDz.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.pDw;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.pDu);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.gBu;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.gBu;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.gBu;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.AM(z);
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
        bVar.AM(this.pDu);
        setImageDrawable(bVar);
    }
}
