package com.tb.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.baidu.mapapi.map.WeightedLatLng;
import com.tb.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class f extends Drawable implements Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private e composition;
    @Nullable
    private String dT;
    private boolean ew;
    private boolean ez;
    @Nullable
    private com.tb.airbnb.lottie.b.b mMG;
    @Nullable
    private c mMH;
    @Nullable
    private com.tb.airbnb.lottie.b.a mMI;
    @Nullable
    com.tb.airbnb.lottie.b mMJ;
    @Nullable
    l mMK;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b mML;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.c.c mMF = new com.tb.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> eo = new HashSet();
    private final ArrayList<b> ep = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void h(e eVar);
    }

    public f() {
        this.mMF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.mML != null) {
                    f.this.mML.setProgress(f.this.mMF.dCs());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.mML != null && this.mML.hasMasks();
    }

    public boolean hasMatte() {
        return this.mML != null && this.mML.hasMatte();
    }

    public boolean bp() {
        return this.ew;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.ew = z;
        if (this.composition != null) {
            bq();
        }
    }

    public void I(@Nullable String str) {
        this.dT = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dT;
    }

    public void recycleBitmaps() {
        if (this.mMG != null) {
            this.mMG.recycleBitmaps();
        }
    }

    public boolean g(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        bq();
        this.mMF.gR(eVar.getDuration());
        setProgress(this.mMF.dCs());
        setScale(this.scale);
        bt();
        dBa();
        Iterator it = new ArrayList(this.ep).iterator();
        while (it.hasNext()) {
            ((b) it.next()).h(eVar);
            it.remove();
        }
        this.ep.clear();
        eVar.setPerformanceTrackingEnabled(this.ez);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.ez = z;
        if (this.composition != null) {
            this.composition.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.composition != null) {
            return this.composition.getPerformanceTracker();
        }
        return null;
    }

    private void bq() {
        this.mML = new com.tb.airbnb.lottie.model.layer.b(this, Layer.a.j(this.composition), this.composition.bj(), this.composition);
    }

    private void dBa() {
        if (this.mML != null) {
            for (a aVar : this.eo) {
                this.mML.b(aVar.jn, aVar.mMN, aVar.mMO);
            }
        }
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.mMF.isRunning()) {
            this.mMF.cancel();
        }
        this.composition = null;
        this.mML = null;
        this.mMG = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.alpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void addColorFilterToContent(String str, String str2, @Nullable ColorFilter colorFilter) {
        a(str, str2, colorFilter);
    }

    public void addColorFilterToLayer(String str, @Nullable ColorFilter colorFilter) {
        a(str, null, colorFilter);
    }

    public void addColorFilter(ColorFilter colorFilter) {
        a(null, null, colorFilter);
    }

    public void clearColorFilters() {
        this.eo.clear();
        a(null, null, null);
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        a aVar = new a(str, str2, colorFilter);
        if (colorFilter == null && this.eo.contains(aVar)) {
            this.eo.remove(aVar);
        } else {
            this.eo.add(new a(str, str2, colorFilter));
        }
        if (this.mML != null) {
            this.mML.b(str, str2, colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        d.beginSection("Drawable#draw");
        if (this.mML != null) {
            float f2 = this.scale;
            float d = d(canvas);
            if (f2 > d) {
                f = this.scale / d;
            } else {
                d = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = this.composition.be().width() / 2.0f;
                float height = this.composition.be().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.mML.a(canvas, this.matrix, this.alpha);
            d.F("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void playAnimation() {
        if (this.mML == null) {
            this.ep.add(new b() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.mMF.playAnimation();
        }
    }

    public void resumeAnimation() {
        if (this.mML == null) {
            this.ep.add(new b() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.mMF.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new b() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.composition.bn());
        }
    }

    public void setMinProgress(float f) {
        this.mMF.bH(f);
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new b() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.composition.bn());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mMF.bI(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.ep.add(new b() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.mMF.F(i / this.composition.bn(), i2 / this.composition.bn());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mMF.F(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.mMF.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.mMF.setSpeed(f);
    }

    public float getSpeed() {
        return this.mMF.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mMF.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mMF.removeUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mMF.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mMF.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new b() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.composition.bn());
        }
    }

    public int getFrame() {
        if (this.composition == null) {
            return 0;
        }
        return (int) (getProgress() * this.composition.bn());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mMF.bG(f);
        if (this.mML != null) {
            this.mML.setProgress(f);
        }
    }

    public void loop(boolean z) {
        this.mMF.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.mMF.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.mMF.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dBb() {
        this.mMF.dBb();
    }

    public void setScale(float f) {
        this.scale = f;
        bt();
    }

    public void setImageAssetDelegate(c cVar) {
        this.mMH = cVar;
        if (this.mMG != null) {
            this.mMG.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.b bVar) {
        this.mMJ = bVar;
        if (this.mMI != null) {
            this.mMI.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.mMK = lVar;
    }

    @Nullable
    public l dBc() {
        return this.mMK;
    }

    public boolean bs() {
        return this.mMK == null && this.composition.bk().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e dBd() {
        return this.composition;
    }

    private void bt() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.be().width() * scale), (int) (scale * this.composition.be().height()));
        }
    }

    public void cancelAnimation() {
        this.ep.clear();
        this.mMF.cancel();
    }

    public void pauseAnimation() {
        this.ep.clear();
        this.mMF.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.mMF.dCs();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.be().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.be().height() * getScale());
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b dBe = dBe();
        if (dBe == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = dBe.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap J(String str) {
        com.tb.airbnb.lottie.b.b dBe = dBe();
        if (dBe != null) {
            return dBe.N(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b dBe() {
        if (getCallback() == null) {
            return null;
        }
        if (this.mMG != null && !this.mMG.Q(getContext())) {
            this.mMG.recycleBitmaps();
            this.mMG = null;
        }
        if (this.mMG == null) {
            this.mMG = new com.tb.airbnb.lottie.b.b(getCallback(), this.dT, this.mMH, this.composition.bm());
        }
        return this.mMG;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.tb.airbnb.lottie.b.a dBf = dBf();
        if (dBf != null) {
            return dBf.g(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a dBf() {
        if (getCallback() == null) {
            return null;
        }
        if (this.mMI == null) {
            this.mMI = new com.tb.airbnb.lottie.b.a(getCallback(), this.mMJ);
        }
        return this.mMI;
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private float d(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.composition.be().width(), canvas.getHeight() / this.composition.be().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String jn;
        @Nullable
        final String mMN;
        @Nullable
        final ColorFilter mMO;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.jn = str;
            this.mMN = str2;
            this.mMO = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.jn != null) {
                i = this.jn.hashCode() * 527;
            }
            if (this.mMN != null) {
                return i * 31 * this.mMN.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.mMO == aVar.mMO;
            }
            return false;
        }
    }
}
