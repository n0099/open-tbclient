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
@kotlin.e
/* loaded from: classes5.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator animator;
    private boolean isAnimating;
    private int pZK;
    private boolean pZL;
    private FillMode pZM;
    private com.opensource.svgaplayer.a pZN;

    @kotlin.e
    /* loaded from: classes5.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.pZK;
    }

    public final void setLoops(int i) {
        this.pZK = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pZL;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pZL = z;
    }

    public final FillMode getFillMode() {
        return this.pZM;
    }

    public final void setFillMode(FillMode fillMode) {
        p.p(fillMode, "<set-?>");
        this.pZM = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pZN;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pZN = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pZL = true;
        this.pZM = FillMode.Forward;
        eCT();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pZL = true;
        this.pZM = FillMode.Forward;
        eCT();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pZL = true;
        this.pZM = FillMode.Forward;
        eCT();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void eCT() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        p.o(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pZK = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pZL = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (p.l(string, "0")) {
                this.pZM = FillMode.Backward;
            } else if (p.l(string, "1")) {
                this.pZM = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            p.o(context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String pZO;
        final /* synthetic */ d pZP;
        final /* synthetic */ SVGAImageView pZQ;
        final /* synthetic */ boolean pZR;
        final /* synthetic */ boolean pZS;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pZO = str;
            this.pZP = dVar;
            this.pZQ = sVGAImageView;
            this.pZR = z;
            this.pZS = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    p.p(fVar, "videoItem");
                    a.this.pZQ.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pZR);
                            a.this.pZQ.setVideoItem(fVar);
                            Drawable drawable = a.this.pZQ.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pZQ.getScaleType();
                                p.o(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pZS) {
                                a.this.pZQ.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pZO, "http://", false, 2, (Object) null) || l.a(this.pZO, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pZP.b(new URL(this.pZO), cVar);
            } else {
                this.pZP.b(this.pZO, cVar);
            }
        }
    }

    public final void startAnimation() {
        a((com.opensource.svgaplayer.b.b) null, false);
    }

    public final void a(com.opensource.svgaplayer.b.b bVar, boolean z) {
        Field declaredField;
        BG(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar2 = (com.opensource.svgaplayer.b) drawable;
        if (bVar2 != null) {
            bVar2.BE(false);
            ImageView.ScaleType scaleType = getScaleType();
            p.o(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f eCK = bVar2.eCK();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(eCK.eDa() - 1, ((bVar != null ? bVar.eDI() : Integer.MAX_VALUE) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            p.o(ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / eCK.getFPS())) / d));
            ofInt.setRepeatCount(this.pZK <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pZK - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.animator = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView pZQ;
        final /* synthetic */ ValueAnimator pZV;
        final /* synthetic */ com.opensource.svgaplayer.b.b pZW;
        final /* synthetic */ com.opensource.svgaplayer.b pZX;
        final /* synthetic */ boolean pZY;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pZV = valueAnimator;
            this.pZQ = sVGAImageView;
            this.pZW = bVar;
            this.pZX = bVar2;
            this.pZY = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pZX;
            ValueAnimator valueAnimator2 = this.pZV;
            p.o(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.QH(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pZQ.getCallback();
            if (callback != null) {
                callback.d(this.pZX.eCJ(), (this.pZX.eCJ() + 1) / this.pZX.eCK().eDa());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView pZQ;
        final /* synthetic */ com.opensource.svgaplayer.b.b pZW;
        final /* synthetic */ com.opensource.svgaplayer.b pZX;
        final /* synthetic */ boolean pZY;
        final /* synthetic */ int pZZ;
        final /* synthetic */ int qaa;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pZZ = i;
            this.qaa = i2;
            this.pZQ = sVGAImageView;
            this.pZW = bVar;
            this.pZX = bVar2;
            this.pZY = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pZQ.getCallback();
            if (callback != null) {
                callback.eCI();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pZQ.isAnimating = false;
            this.pZQ.stopAnimation();
            if (!this.pZQ.getClearsAfterStop()) {
                if (this.pZQ.getFillMode() == FillMode.Backward) {
                    this.pZX.QH(this.pZZ);
                } else if (this.pZQ.getFillMode() == FillMode.Forward) {
                    this.pZX.QH(this.qaa);
                }
            }
            com.opensource.svgaplayer.a callback = this.pZQ.getCallback();
            if (callback != null) {
                callback.ciG();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pZQ.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pZQ.isAnimating = true;
        }
    }

    public final void stopAnimation() {
        BG(this.pZL);
    }

    public final void BG(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.BE(z);
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
        bVar.BE(this.pZL);
        setImageDrawable(bVar);
    }
}
