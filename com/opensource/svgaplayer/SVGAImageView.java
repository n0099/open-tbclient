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
import kotlin.jvm.internal.q;
import kotlin.text.l;
/* loaded from: classes.dex */
public class SVGAImageView extends ImageView {
    private boolean dR;
    private ValueAnimator ewN;
    private int nkj;
    private boolean nkk;
    private FillMode nkl;
    private com.opensource.svgaplayer.a nkm;

    /* loaded from: classes.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.dR = z;
    }

    public final int getLoops() {
        return this.nkj;
    }

    public final void setLoops(int i) {
        this.nkj = i;
    }

    public final boolean getClearsAfterStop() {
        return this.nkk;
    }

    public final void setClearsAfterStop(boolean z) {
        this.nkk = z;
    }

    public final FillMode getFillMode() {
        return this.nkl;
    }

    public final void setFillMode(FillMode fillMode) {
        q.j(fillMode, "<set-?>");
        this.nkl = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.nkm;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.nkm = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.nkk = true;
        this.nkl = FillMode.Forward;
        dhN();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nkk = true;
        this.nkl = FillMode.Forward;
        dhN();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nkk = true;
        this.nkl = FillMode.Forward;
        dhN();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dhN() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.ewN;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.ewN;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.ewN;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.i(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.nkj = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.nkk = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.h(string, "0")) {
                this.nkl = FillMode.Backward;
            } else if (q.h(string, "1")) {
                this.nkl = FillMode.Forward;
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
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String nkn;
        final /* synthetic */ d nko;
        final /* synthetic */ SVGAImageView nkp;
        final /* synthetic */ boolean nkq;
        final /* synthetic */ boolean nkr;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.nkn = str;
            this.nko = dVar;
            this.nkp = sVGAImageView;
            this.nkq = z;
            this.nkr = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.j(fVar, "videoItem");
                    a.this.nkp.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.nkq);
                            a.this.nkp.setVideoItem(fVar);
                            Drawable drawable = a.this.nkp.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.nkp.getScaleType();
                                q.i(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.nkr) {
                                a.this.nkp.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.nkn, "http://", false, 2, (Object) null) || l.a(this.nkn, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.nko.b(new URL(this.nkn), cVar);
            } else {
                this.nko.b(this.nkn, cVar);
            }
        }
    }

    public final void startAnimation() {
        a((com.opensource.svgaplayer.b.b) null, false);
    }

    public final void a(com.opensource.svgaplayer.b.b bVar, boolean z) {
        Field declaredField;
        ws(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar2 = (com.opensource.svgaplayer.b) drawable;
        if (bVar2 != null) {
            bVar2.wq(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.i(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dDx = bVar2.dDx();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dDx.dDM() - 1, ((bVar != null ? bVar.bRx() : Integer.MAX_VALUE) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dDx.getFPS())) / d));
            ofInt.setRepeatCount(this.nkj <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.nkj - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.ewN = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView nkp;
        final /* synthetic */ ValueAnimator nku;
        final /* synthetic */ com.opensource.svgaplayer.b.b nkv;
        final /* synthetic */ com.opensource.svgaplayer.b nkw;
        final /* synthetic */ boolean nkx;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nku = valueAnimator;
            this.nkp = sVGAImageView;
            this.nkv = bVar;
            this.nkw = bVar2;
            this.nkx = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.nkw;
            ValueAnimator valueAnimator2 = this.nku;
            q.i(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Ne(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.nkp.getCallback();
            if (callback != null) {
                callback.b(this.nkw.dDw(), (this.nkw.dDw() + 1) / this.nkw.dDx().dDM());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView nkp;
        final /* synthetic */ com.opensource.svgaplayer.b.b nkv;
        final /* synthetic */ com.opensource.svgaplayer.b nkw;
        final /* synthetic */ boolean nkx;
        final /* synthetic */ int nky;
        final /* synthetic */ int nkz;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nky = i;
            this.nkz = i2;
            this.nkp = sVGAImageView;
            this.nkv = bVar;
            this.nkw = bVar2;
            this.nkx = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.nkp.getCallback();
            if (callback != null) {
                callback.Ea();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.nkp.dR = false;
            this.nkp.stopAnimation();
            if (!this.nkp.getClearsAfterStop()) {
                if (this.nkp.getFillMode() == FillMode.Backward) {
                    this.nkw.Ne(this.nky);
                } else if (this.nkp.getFillMode() == FillMode.Forward) {
                    this.nkw.Ne(this.nkz);
                }
            }
            com.opensource.svgaplayer.a callback = this.nkp.getCallback();
            if (callback != null) {
                callback.onFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.nkp.dR = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.nkp.dR = true;
        }
    }

    public final void pauseAnimation() {
        ws(false);
        com.opensource.svgaplayer.a aVar = this.nkm;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        ws(this.nkk);
    }

    public final void ws(boolean z) {
        ValueAnimator valueAnimator = this.ewN;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.ewN;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.ewN;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.wq(z);
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
        bVar.wq(this.nkk);
        setImageDrawable(bVar);
    }
}
