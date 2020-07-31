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
/* loaded from: classes8.dex */
public class SVGAImageView extends ImageView {
    private boolean Ag;
    private ValueAnimator fKB;
    private int nJm;
    private boolean nJn;
    private FillMode nJo;
    private com.opensource.svgaplayer.a nJp;

    @h
    /* loaded from: classes8.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.Ag = z;
    }

    public final int getLoops() {
        return this.nJm;
    }

    public final void setLoops(int i) {
        this.nJm = i;
    }

    public final boolean getClearsAfterStop() {
        return this.nJn;
    }

    public final void setClearsAfterStop(boolean z) {
        this.nJn = z;
    }

    public final FillMode getFillMode() {
        return this.nJo;
    }

    public final void setFillMode(FillMode fillMode) {
        q.m(fillMode, "<set-?>");
        this.nJo = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.nJp;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.nJp = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.nJn = true;
        this.nJo = FillMode.Forward;
        dPb();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJn = true;
        this.nJo = FillMode.Forward;
        dPb();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJn = true;
        this.nJo = FillMode.Forward;
        dPb();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dPb() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fKB;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fKB;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fKB;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.l((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.nJm = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.nJn = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l((Object) string, (Object) "0")) {
                this.nJo = FillMode.Backward;
            } else if (q.l((Object) string, (Object) "1")) {
                this.nJo = FillMode.Forward;
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
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String nJq;
        final /* synthetic */ d nJr;
        final /* synthetic */ SVGAImageView nJs;
        final /* synthetic */ boolean nJt;
        final /* synthetic */ boolean nJu;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.nJq = str;
            this.nJr = dVar;
            this.nJs = sVGAImageView;
            this.nJt = z;
            this.nJu = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.m(fVar, "videoItem");
                    a.this.nJs.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.nJt);
                            a.this.nJs.setVideoItem(fVar);
                            Drawable drawable = a.this.nJs.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.nJs.getScaleType();
                                q.l((Object) scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.nJu) {
                                a.this.nJs.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.nJq, "http://", false, 2, (Object) null) || l.a(this.nJq, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.nJr.b(new URL(this.nJq), cVar);
            } else {
                this.nJr.b(this.nJq, cVar);
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
            bVar2.xK(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.l((Object) scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dOS = bVar2.dOS();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dOS.dPi() - 1, ((bVar != null ? bVar.crU() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dOS.getFPS())) / d));
            ofInt.setRepeatCount(this.nJm <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.nJm - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.fKB = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes8.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ boolean nJA;
        final /* synthetic */ SVGAImageView nJs;
        final /* synthetic */ ValueAnimator nJx;
        final /* synthetic */ com.opensource.svgaplayer.b.b nJy;
        final /* synthetic */ com.opensource.svgaplayer.b nJz;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nJx = valueAnimator;
            this.nJs = sVGAImageView;
            this.nJy = bVar;
            this.nJz = bVar2;
            this.nJA = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.nJz;
            ValueAnimator valueAnimator2 = this.nJx;
            q.l((Object) valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.KV(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.nJs.getCallback();
            if (callback != null) {
                callback.b(this.nJz.dOR(), (this.nJz.dOR() + 1) / this.nJz.dOS().dPi());
            }
        }
    }

    @h
    /* loaded from: classes8.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ boolean nJA;
        final /* synthetic */ int nJB;
        final /* synthetic */ int nJC;
        final /* synthetic */ SVGAImageView nJs;
        final /* synthetic */ com.opensource.svgaplayer.b.b nJy;
        final /* synthetic */ com.opensource.svgaplayer.b nJz;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.nJB = i;
            this.nJC = i2;
            this.nJs = sVGAImageView;
            this.nJy = bVar;
            this.nJz = bVar2;
            this.nJA = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.nJs.getCallback();
            if (callback != null) {
                callback.RR();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.nJs.Ag = false;
            this.nJs.stopAnimation();
            if (!this.nJs.getClearsAfterStop()) {
                if (this.nJs.getFillMode() == FillMode.Backward) {
                    this.nJz.KV(this.nJB);
                } else if (this.nJs.getFillMode() == FillMode.Forward) {
                    this.nJz.KV(this.nJC);
                }
            }
            com.opensource.svgaplayer.a callback = this.nJs.getCallback();
            if (callback != null) {
                callback.RQ();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.nJs.Ag = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.nJs.Ag = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.nJp;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.nJn);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.fKB;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fKB;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fKB;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.xK(z);
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
        bVar.xK(this.nJn);
        setImageDrawable(bVar);
    }
}
