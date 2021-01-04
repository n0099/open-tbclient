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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.utils.SapiUtils;
import com.opensource.svgaplayer.d;
import java.lang.reflect.Field;
import java.net.URL;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
import kotlin.text.l;
@kotlin.e
/* loaded from: classes6.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator animator;
    private boolean isAnimating;
    private int pRj;
    private boolean pRk;
    private FillMode pRl;
    private com.opensource.svgaplayer.a pRm;

    @kotlin.e
    /* loaded from: classes6.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final int getLoops() {
        return this.pRj;
    }

    public final void setLoops(int i) {
        this.pRj = i;
    }

    public final boolean getClearsAfterStop() {
        return this.pRk;
    }

    public final void setClearsAfterStop(boolean z) {
        this.pRk = z;
    }

    public final FillMode getFillMode() {
        return this.pRl;
    }

    public final void setFillMode(FillMode fillMode) {
        p.o(fillMode, "<set-?>");
        this.pRl = fillMode;
    }

    public final com.opensource.svgaplayer.a getCallback() {
        return this.pRm;
    }

    public final void setCallback(com.opensource.svgaplayer.a aVar) {
        this.pRm = aVar;
    }

    public SVGAImageView(Context context) {
        super(context);
        this.pRk = true;
        this.pRl = FillMode.Forward;
        eDC();
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pRk = true;
        this.pRl = FillMode.Forward;
        eDC();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pRk = true;
        this.pRl = FillMode.Forward;
        eDC();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    private final void eDC() {
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
        p.n(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.pRj = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.pRk = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (p.l(string, "0")) {
                this.pRl = FillMode.Backward;
            } else if (p.l(string, "1")) {
                this.pRl = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context2 = getContext();
            p.n(context2, "context");
            new Thread(new a(string2, new d(context2), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        final /* synthetic */ String pRn;
        final /* synthetic */ d pRo;
        final /* synthetic */ SVGAImageView pRp;
        final /* synthetic */ boolean pRq;
        final /* synthetic */ boolean pRr;

        a(String str, d dVar, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            this.pRn = str;
            this.pRo = dVar;
            this.pRp = sVGAImageView;
            this.pRq = z;
            this.pRr = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c cVar = new d.c() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1
                @Override // com.opensource.svgaplayer.d.c
                public void a(final f fVar) {
                    p.o(fVar, "videoItem");
                    a.this.pRp.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            fVar.setAntiAlias(a.this.pRq);
                            a.this.pRp.setVideoItem(fVar);
                            Drawable drawable = a.this.pRp.getDrawable();
                            if (!(drawable instanceof com.opensource.svgaplayer.b)) {
                                drawable = null;
                            }
                            com.opensource.svgaplayer.b bVar = (com.opensource.svgaplayer.b) drawable;
                            if (bVar != null) {
                                ImageView.ScaleType scaleType = a.this.pRp.getScaleType();
                                p.n(scaleType, "scaleType");
                                bVar.setScaleType(scaleType);
                            }
                            if (a.this.pRr) {
                                a.this.pRp.startAnimation();
                            }
                        }
                    });
                }

                @Override // com.opensource.svgaplayer.d.c
                public void onError() {
                }
            };
            if (l.a(this.pRn, "http://", false, 2, (Object) null) || l.a(this.pRn, SapiUtils.COOKIE_HTTPS_URL_PREFIX, false, 2, (Object) null)) {
                this.pRo.b(new URL(this.pRn), cVar);
            } else {
                this.pRo.b(this.pRn, cVar);
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
            bVar2.Br(false);
            ImageView.ScaleType scaleType = getScaleType();
            p.n(scaleType, "scaleType");
            bVar2.setScaleType(scaleType);
            f eDt = bVar2.eDt();
            double d = 1.0d;
            int max = Math.max(0, bVar != null ? bVar.getLocation() : 0);
            int min = Math.min(eDt.eDJ() - 1, ((bVar != null ? bVar.vx() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + (bVar != null ? bVar.getLocation() : 0)) - 1);
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
            p.n(ofInt, "animator");
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) ((((min - max) + 1) * (1000 / eDt.getFPS())) / d));
            ofInt.setRepeatCount(this.pRj <= 0 ? BdStatsConstant.ErrorCode.ERR_LOG_FAST : this.pRj - 1);
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
    /* loaded from: classes6.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ SVGAImageView pRp;
        final /* synthetic */ ValueAnimator pRu;
        final /* synthetic */ com.opensource.svgaplayer.b.b pRv;
        final /* synthetic */ com.opensource.svgaplayer.b pRw;
        final /* synthetic */ boolean pRx;

        b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pRu = valueAnimator;
            this.pRp = sVGAImageView;
            this.pRv = bVar;
            this.pRw = bVar2;
            this.pRx = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.opensource.svgaplayer.b bVar = this.pRw;
            ValueAnimator valueAnimator2 = this.pRu;
            p.n(valueAnimator2, "animator");
            Object animatedValue = valueAnimator2.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            bVar.Ry(((Integer) animatedValue).intValue());
            com.opensource.svgaplayer.a callback = this.pRp.getCallback();
            if (callback != null) {
                callback.d(this.pRw.eDs(), (this.pRw.eDs() + 1) / this.pRw.eDt().eDJ());
            }
        }
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ SVGAImageView pRp;
        final /* synthetic */ com.opensource.svgaplayer.b.b pRv;
        final /* synthetic */ com.opensource.svgaplayer.b pRw;
        final /* synthetic */ boolean pRx;
        final /* synthetic */ int pRy;
        final /* synthetic */ int pRz;

        c(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, com.opensource.svgaplayer.b bVar2, boolean z) {
            this.pRy = i;
            this.pRz = i2;
            this.pRp = sVGAImageView;
            this.pRv = bVar;
            this.pRw = bVar2;
            this.pRx = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            com.opensource.svgaplayer.a callback = this.pRp.getCallback();
            if (callback != null) {
                callback.eDr();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.pRp.isAnimating = false;
            this.pRp.stopAnimation();
            if (!this.pRp.getClearsAfterStop()) {
                if (this.pRp.getFillMode() == FillMode.Backward) {
                    this.pRw.Ry(this.pRy);
                } else if (this.pRp.getFillMode() == FillMode.Forward) {
                    this.pRw.Ry(this.pRz);
                }
            }
            com.opensource.svgaplayer.a callback = this.pRp.getCallback();
            if (callback != null) {
                callback.clr();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.pRp.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.pRp.isAnimating = true;
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.pRk);
    }

    public final void stopAnimation(boolean z) {
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
            bVar.Br(z);
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
        bVar.Br(this.pRk);
        setImageDrawable(bVar);
    }
}
