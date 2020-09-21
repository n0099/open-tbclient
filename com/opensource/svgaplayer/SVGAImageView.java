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
/* loaded from: classes16.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator fZj;
    private boolean isAnimating;
    private int onl;
    private boolean onm;
    private FillMode onn;
    private com.opensource.svgaplayer.a ono;

    @h
    /* loaded from: classes16.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.onl;
    }

    public final void setLoops(int i) {
        this.onl = i;
    }

    public final boolean getClearsAfterStop() {
        return this.onm;
    }

    public final void setClearsAfterStop(boolean z) {
        this.onm = z;
    }

    public final FillMode getFillMode() {
        return this.onn;
    }

    public final void setFillMode(FillMode fillMode) {
        q.m(fillMode, "<set-?>");
        this.onn = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.ono;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.ono = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.onm = true;
        this.onn = FillMode.Forward;
        efl();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onm = true;
        this.onn = FillMode.Forward;
        efl();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onm = true;
        this.onn = FillMode.Forward;
        efl();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void efl() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fZj;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fZj;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fZj;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.l((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.onl = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.onm = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l((Object) string, (Object) "0")) {
                this.onn = FillMode.Backward;
            } else if (q.l((Object) string, (Object) "1")) {
                this.onn = FillMode.Forward;
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
    /* loaded from: classes16.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String onp;
        final /* synthetic */ d onq;
        final /* synthetic */ SVGAImageView onr;
        final /* synthetic */ boolean ons;
        final /* synthetic */ boolean ont;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.onp = str;
            this.onq = dVar;
            this.onr = sVGAImageView;
            this.ons = z;
            this.ont = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.m(fVar, "videoItem");
                    a.this.onr.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.ons);
                            a.this.onr.setVideoItem(fVar);
                            Drawable drawable = a.this.onr.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.onr.getScaleType();
                                q.l((Object) scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.ont) {
                                a.this.onr.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.onp, "http://", false, 2, (Object) null) || l.a(this.onp, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.onq.b(new URL(this.onp), cVar);
            } else {
                this.onq.b(this.onp, cVar);
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
            bVar2.yM(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.l((Object) scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f efc = bVar2.efc();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(efc.efs() - 1, ((bVar != null ? bVar.wg() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / efc.getFPS())) / d));
            ofInt.setRepeatCount(this.onl <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.onl - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.fZj = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes16.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView onr;
        final /* synthetic */ ValueAnimator onw;
        final /* synthetic */ com.opensource.svgaplayer.b.b onx;
        final /* synthetic */ com.opensource.svgaplayer.b ony;
        final /* synthetic */ boolean onz;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.onw = valueAnimator;
            this.onr = sVGAImageView;
            this.onx = bVar;
            this.ony = bVar2;
            this.onz = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.ony;
            ValueAnimator valueAnimator2 = this.onw;
            q.l((Object) valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Oe(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.onr.getCallback();
            if (callback != null) {
                callback.b(this.ony.efb(), (this.ony.efb() + 1) / this.ony.efc().efs());
            }
        }
    }

    @h
    /* loaded from: classes16.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ int onA;
        final /* synthetic */ int onB;
        final /* synthetic */ SVGAImageView onr;
        final /* synthetic */ com.opensource.svgaplayer.b.b onx;
        final /* synthetic */ com.opensource.svgaplayer.b ony;
        final /* synthetic */ boolean onz;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.onA = i;
            this.onB = i2;
            this.onr = sVGAImageView;
            this.onx = bVar;
            this.ony = bVar2;
            this.onz = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.onr.getCallback();
            if (callback != null) {
                callback.Yv();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.onr.isAnimating = false;
            this.onr.stopAnimation();
            if (!this.onr.getClearsAfterStop()) {
                if (this.onr.getFillMode() == FillMode.Backward) {
                    this.ony.Oe(this.onA);
                } else if (this.onr.getFillMode() == FillMode.Forward) {
                    this.ony.Oe(this.onB);
                }
            }
            com.opensource.svgaplayer.a callback = this.onr.getCallback();
            if (callback != null) {
                callback.Yu();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.onr.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.onr.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.ono;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.onm);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.fZj;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fZj;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fZj;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.yM(z);
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
        bVar.yM(this.onm);
        setImageDrawable(bVar);
    }
}
