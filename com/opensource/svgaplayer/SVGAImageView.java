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
/* loaded from: classes11.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator fVW;
    private boolean isAnimating;
    private boolean odA;
    private FillMode odB;
    private com.opensource.svgaplayer.a odC;
    private int odz;

    @h
    /* loaded from: classes11.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.odz;
    }

    public final void setLoops(int i) {
        this.odz = i;
    }

    public final boolean getClearsAfterStop() {
        return this.odA;
    }

    public final void setClearsAfterStop(boolean z) {
        this.odA = z;
    }

    public final FillMode getFillMode() {
        return this.odB;
    }

    public final void setFillMode(FillMode fillMode) {
        q.m(fillMode, "<set-?>");
        this.odB = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.odC;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.odC = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.odA = true;
        this.odB = FillMode.Forward;
        ebn();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.odA = true;
        this.odB = FillMode.Forward;
        ebn();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.odA = true;
        this.odB = FillMode.Forward;
        ebn();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void ebn() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fVW;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fVW;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fVW;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.l((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.odz = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.odA = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l((Object) string, (Object) "0")) {
                this.odB = FillMode.Backward;
            } else if (q.l((Object) string, (Object) "1")) {
                this.odB = FillMode.Forward;
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
    /* loaded from: classes11.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String odD;
        final /* synthetic */ d odE;
        final /* synthetic */ SVGAImageView odF;
        final /* synthetic */ boolean odG;
        final /* synthetic */ boolean odH;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.odD = str;
            this.odE = dVar;
            this.odF = sVGAImageView;
            this.odG = z;
            this.odH = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.m(fVar, "videoItem");
                    a.this.odF.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.odG);
                            a.this.odF.setVideoItem(fVar);
                            Drawable drawable = a.this.odF.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.odF.getScaleType();
                                q.l((Object) scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.odH) {
                                a.this.odF.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.odD, "http://", false, 2, (Object) null) || l.a(this.odD, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.odE.b(new URL(this.odD), cVar);
            } else {
                this.odE.b(this.odD, cVar);
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
            bVar2.yE(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.l((Object) scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f ebe = bVar2.ebe();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(ebe.ebu() - 1, ((bVar != null ? bVar.vS() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / ebe.getFPS())) / d));
            ofInt.setRepeatCount(this.odz <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.odz - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.fVW = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes11.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView odF;
        final /* synthetic */ ValueAnimator odK;
        final /* synthetic */ com.opensource.svgaplayer.b.b odL;
        final /* synthetic */ com.opensource.svgaplayer.b odM;
        final /* synthetic */ boolean odN;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.odK = valueAnimator;
            this.odF = sVGAImageView;
            this.odL = bVar;
            this.odM = bVar2;
            this.odN = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.odM;
            ValueAnimator valueAnimator2 = this.odK;
            q.l((Object) valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Nz(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.odF.getCallback();
            if (callback != null) {
                callback.b(this.odM.ebd(), (this.odM.ebd() + 1) / this.odM.ebe().ebu());
            }
        }
    }

    @h
    /* loaded from: classes11.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView odF;
        final /* synthetic */ com.opensource.svgaplayer.b.b odL;
        final /* synthetic */ com.opensource.svgaplayer.b odM;
        final /* synthetic */ boolean odN;
        final /* synthetic */ int odO;
        final /* synthetic */ int odP;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.odO = i;
            this.odP = i2;
            this.odF = sVGAImageView;
            this.odL = bVar;
            this.odM = bVar2;
            this.odN = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.odF.getCallback();
            if (callback != null) {
                callback.XM();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.odF.isAnimating = false;
            this.odF.stopAnimation();
            if (!this.odF.getClearsAfterStop()) {
                if (this.odF.getFillMode() == FillMode.Backward) {
                    this.odM.Nz(this.odO);
                } else if (this.odF.getFillMode() == FillMode.Forward) {
                    this.odM.Nz(this.odP);
                }
            }
            com.opensource.svgaplayer.a callback = this.odF.getCallback();
            if (callback != null) {
                callback.XL();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.odF.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.odF.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.odC;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.odA);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.fVW;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fVW;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fVW;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.yE(z);
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
        bVar.yE(this.odA);
        setImageDrawable(bVar);
    }
}
