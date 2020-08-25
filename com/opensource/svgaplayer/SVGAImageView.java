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
    private ValueAnimator fVS;
    private boolean isAnimating;
    private int odh;
    private boolean odi;
    private FillMode odj;
    private com.opensource.svgaplayer.a odk;

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
        return this.odh;
    }

    public final void setLoops(int i) {
        this.odh = i;
    }

    public final boolean getClearsAfterStop() {
        return this.odi;
    }

    public final void setClearsAfterStop(boolean z) {
        this.odi = z;
    }

    public final FillMode getFillMode() {
        return this.odj;
    }

    public final void setFillMode(FillMode fillMode) {
        q.m(fillMode, "<set-?>");
        this.odj = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.odk;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.odk = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.odi = true;
        this.odj = FillMode.Forward;
        ebe();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.odi = true;
        this.odj = FillMode.Forward;
        ebe();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.odi = true;
        this.odj = FillMode.Forward;
        ebe();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void ebe() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fVS;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fVS;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fVS;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        q.l((Object) context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.odh = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.odi = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (q.l((Object) string, (Object) "0")) {
                this.odj = FillMode.Backward;
            } else if (q.l((Object) string, (Object) "1")) {
                this.odj = FillMode.Forward;
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
        final /* synthetic */ String odl;
        final /* synthetic */ d odm;
        final /* synthetic */ SVGAImageView odn;
        final /* synthetic */ boolean odo;
        final /* synthetic */ boolean odp;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.odl = str;
            this.odm = dVar;
            this.odn = sVGAImageView;
            this.odo = z;
            this.odp = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    q.m(fVar, "videoItem");
                    a.this.odn.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.odo);
                            a.this.odn.setVideoItem(fVar);
                            Drawable drawable = a.this.odn.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.odn.getScaleType();
                                q.l((Object) scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.odp) {
                                a.this.odn.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.odl, "http://", false, 2, (Object) null) || l.a(this.odl, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.odm.b(new URL(this.odl), cVar);
            } else {
                this.odm.b(this.odl, cVar);
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
            bVar2.yC(false);
            ImageView.ScaleType scaleType = getScaleType();
            q.l((Object) scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f eaV = bVar2.eaV();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(eaV.ebl() - 1, ((bVar != null ? bVar.vS() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / eaV.getFPS())) / d));
            ofInt.setRepeatCount(this.odh <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.odh - 1);
            ofInt.addUpdateListener(new b(ofInt, this, bVar, bVar2, z));
            ofInt.addListener(new c(max, min, this, bVar, bVar2, z));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.fVS = ofInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes11.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView odn;
        final /* synthetic */ ValueAnimator ods;
        final /* synthetic */ com.opensource.svgaplayer.b.b odt;
        final /* synthetic */ com.opensource.svgaplayer.b odu;
        final /* synthetic */ boolean odv;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.ods = valueAnimator;
            this.odn = sVGAImageView;
            this.odt = bVar;
            this.odu = bVar2;
            this.odv = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.odu;
            ValueAnimator valueAnimator2 = this.ods;
            q.l((Object) valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Nz(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.odn.getCallback();
            if (callback != null) {
                callback.b(this.odu.eaU(), (this.odu.eaU() + 1) / this.odu.eaV().ebl());
            }
        }
    }

    @h
    /* loaded from: classes11.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView odn;
        final /* synthetic */ com.opensource.svgaplayer.b.b odt;
        final /* synthetic */ com.opensource.svgaplayer.b odu;
        final /* synthetic */ boolean odv;
        final /* synthetic */ int odw;
        final /* synthetic */ int odx;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.odw = i;
            this.odx = i2;
            this.odn = sVGAImageView;
            this.odt = bVar;
            this.odu = bVar2;
            this.odv = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.odn.getCallback();
            if (callback != null) {
                callback.XM();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.odn.isAnimating = false;
            this.odn.stopAnimation();
            if (!this.odn.getClearsAfterStop()) {
                if (this.odn.getFillMode() == FillMode.Backward) {
                    this.odu.Nz(this.odw);
                } else if (this.odn.getFillMode() == FillMode.Forward) {
                    this.odu.Nz(this.odx);
                }
            }
            com.opensource.svgaplayer.a callback = this.odn.getCallback();
            if (callback != null) {
                callback.XL();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.odn.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.odn.isAnimating = true;
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        com.opensource.svgaplayer.a aVar = this.odk;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.odi);
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.fVS;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.fVS;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.fVS;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.b)) {
            drawable = null;
        }
        com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
        if (bVar != null) {
            bVar.yC(z);
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
        bVar.yC(this.odi);
        setImageDrawable(bVar);
    }
}
