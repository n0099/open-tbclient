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
    private int nke;
    private boolean nkf;
    private FillMode nkg;
    private com.opensource.svgaplayer.a nkh;

    /* loaded from: classes.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.dR = z;
    }

    public final int getLoops() {
        return this.nke;
    }

    public final void setLoops(int i) {
        this.nke = i;
    }

    public final boolean getClearsAfterStop() {
        return this.nkf;
    }

    public final void setClearsAfterStop(boolean z) {
        this.nkf = z;
    }

    public final FillMode getFillMode() {
        return this.nkg;
    }

    public final void setFillMode(FillMode fillMode) {
        q.j(fillMode, "<set-?>");
        this.nkg = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.nkh;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.nkh = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.nkf = true;
        this.nkg = FillMode.Forward;
        dhL();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nkf = true;
        this.nkg = FillMode.Forward;
        dhL();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nkf = true;
        this.nkg = FillMode.Forward;
        dhL();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dhL() {
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
        this.nke = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.nkf = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.h(string, "0")) {
                this.nkg = FillMode.Backward;
            } else if (q.h(string, "1")) {
                this.nkg = FillMode.Forward;
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
        final /* synthetic */ String nki;
        final /* synthetic */ d nkj;
        final /* synthetic */ SVGAImageView nkk;
        final /* synthetic */ boolean nkl;
        final /* synthetic */ boolean nkm;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.nki = str;
            this.nkj = dVar;
            this.nkk = sVGAImageView;
            this.nkl = z;
            this.nkm = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.j(fVar, "videoItem");
                    a.this.nkk.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.nkl);
                            a.this.nkk.setVideoItem(fVar);
                            Drawable drawable = a.this.nkk.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.nkk.getScaleType();
                                q.i(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.nkm) {
                                a.this.nkk.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.nki, "http://", false, 2, (Object) null) || l.a(this.nki, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.nkj.b(new URL(this.nki), cVar);
            } else {
                this.nkj.b(this.nki, cVar);
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
            f dDv = bVar2.dDv();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dDv.dDK() - 1, ((bVar != null ? bVar.bRx() : Integer.MAX_VALUE) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dDv.getFPS())) / d));
            ofInt.setRepeatCount(this.nke <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.nke - 1);
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
        final /* synthetic */ SVGAImageView nkk;
        final /* synthetic */ ValueAnimator nkp;
        final /* synthetic */ com.opensource.svgaplayer.b.b nkq;
        final /* synthetic */ com.opensource.svgaplayer.b nkr;
        final /* synthetic */ boolean nks;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nkp = valueAnimator;
            this.nkk = sVGAImageView;
            this.nkq = bVar;
            this.nkr = bVar2;
            this.nks = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.nkr;
            ValueAnimator valueAnimator2 = this.nkp;
            q.i(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Ne(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.nkk.getCallback();
            if (callback != null) {
                callback.b(this.nkr.dDu(), (this.nkr.dDu() + 1) / this.nkr.dDv().dDK());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView nkk;
        final /* synthetic */ com.opensource.svgaplayer.b.b nkq;
        final /* synthetic */ com.opensource.svgaplayer.b nkr;
        final /* synthetic */ boolean nks;
        final /* synthetic */ int nkt;
        final /* synthetic */ int nku;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nkt = i;
            this.nku = i2;
            this.nkk = sVGAImageView;
            this.nkq = bVar;
            this.nkr = bVar2;
            this.nks = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.nkk.getCallback();
            if (callback != null) {
                callback.Ea();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.nkk.dR = false;
            this.nkk.stopAnimation();
            if (!this.nkk.getClearsAfterStop()) {
                if (this.nkk.getFillMode() == FillMode.Backward) {
                    this.nkr.Ne(this.nkt);
                } else if (this.nkk.getFillMode() == FillMode.Forward) {
                    this.nkr.Ne(this.nku);
                }
            }
            com.opensource.svgaplayer.a callback = this.nkk.getCallback();
            if (callback != null) {
                callback.onFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.nkk.dR = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.nkk.dR = true;
        }
    }

    public final void pauseAnimation() {
        ws(false);
        com.opensource.svgaplayer.a aVar = this.nkh;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        ws(this.nkf);
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
        bVar.wq(this.nkf);
        setImageDrawable(bVar);
    }
}
