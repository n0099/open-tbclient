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
    private ValueAnimator ftL;
    private int ndA;
    private boolean ndB;
    private FillMode ndC;
    private com.opensource.svgaplayer.a ndD;
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
        return this.ndA;
    }

    public final void setLoops(int i) {
        this.ndA = i;
    }

    public final boolean getClearsAfterStop() {
        return this.ndB;
    }

    public final void setClearsAfterStop(boolean z) {
        this.ndB = z;
    }

    public final FillMode getFillMode() {
        return this.ndC;
    }

    public final void setFillMode(FillMode fillMode) {
        q.m(fillMode, "<set-?>");
        this.ndC = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.ndD;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.ndD = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.ndB = true;
        this.ndC = FillMode.Forward;
        dGI();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ndB = true;
        this.ndC = FillMode.Forward;
        dGI();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ndB = true;
        this.ndC = FillMode.Forward;
        dGI();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void dGI() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.ftL;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.ftL;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.ftL;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.l((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.ndA = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.ndB = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l((Object) string, (Object) "0")) {
                this.ndC = FillMode.Backward;
            } else if (q.l((Object) string, (Object) "1")) {
                this.ndC = FillMode.Forward;
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
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String ndE;
        final /* synthetic */ d ndF;
        final /* synthetic */ SVGAImageView ndG;
        final /* synthetic */ boolean ndH;
        final /* synthetic */ boolean ndI;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.ndE = str;
            this.ndF = dVar;
            this.ndG = sVGAImageView;
            this.ndH = z;
            this.ndI = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.m(fVar, "videoItem");
                    a.this.ndG.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.ndH);
                            a.this.ndG.setVideoItem(fVar);
                            Drawable drawable = a.this.ndG.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.ndG.getScaleType();
                                q.l((Object) scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.ndI) {
                                a.this.ndG.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.ndE, "http://", false, 2, (Object) null) || l.a(this.ndE, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.ndF.b(new URL(this.ndE), cVar);
            } else {
                this.ndF.b(this.ndE, cVar);
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
            bVar2.wI(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.l((Object) scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f dGz = bVar2.dGz();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(dGz.dGP() - 1, ((bVar != null ? bVar.ckq() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / dGz.getFPS())) / d));
            ofInt.setRepeatCount(this.ndA <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.ndA - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.ftL = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView ndG;
        final /* synthetic */ ValueAnimator ndL;
        final /* synthetic */ com.opensource.svgaplayer.b.b ndM;
        final /* synthetic */ com.opensource.svgaplayer.b ndN;
        final /* synthetic */ boolean ndO;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.ndL = valueAnimator;
            this.ndG = sVGAImageView;
            this.ndM = bVar;
            this.ndN = bVar2;
            this.ndO = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.ndN;
            ValueAnimator valueAnimator2 = this.ndL;
            q.l((Object) valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Js(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.ndG.getCallback();
            if (callback != null) {
                callback.b(this.ndN.dGy(), (this.ndN.dGy() + 1) / this.ndN.dGz().dGP());
            }
        }
    }

    @h
    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView ndG;
        final /* synthetic */ com.opensource.svgaplayer.b.b ndM;
        final /* synthetic */ com.opensource.svgaplayer.b ndN;
        final /* synthetic */ boolean ndO;
        final /* synthetic */ int ndP;
        final /* synthetic */ int ndQ;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.ndP = i;
            this.ndQ = i2;
            this.ndG = sVGAImageView;
            this.ndM = bVar;
            this.ndN = bVar2;
            this.ndO = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.ndG.getCallback();
            if (callback != null) {
                callback.Qw();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.ndG.zD = false;
            this.ndG.stopAnimation();
            if (!this.ndG.getClearsAfterStop()) {
                if (this.ndG.getFillMode() == FillMode.Backward) {
                    this.ndN.Js(this.ndP);
                } else if (this.ndG.getFillMode() == FillMode.Forward) {
                    this.ndN.Js(this.ndQ);
                }
            }
            com.opensource.svgaplayer.a callback = this.ndG.getCallback();
            if (callback != null) {
                callback.Qv();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.ndG.zD = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.ndG.zD = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.ndD;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.ndB);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.ftL;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.ftL;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.ftL;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.wI(z);
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
        bVar.wI(this.ndB);
        setImageDrawable(bVar);
    }
}
