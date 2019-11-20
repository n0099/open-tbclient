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
/* loaded from: classes6.dex */
public class f extends Drawable implements Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    @Nullable
    private String cQ;
    private e composition;
    private boolean dt;
    private boolean dv;
    @Nullable
    private com.tb.airbnb.lottie.b.b krU;
    @Nullable
    private c krV;
    @Nullable
    private com.tb.airbnb.lottie.b.a krW;
    @Nullable
    com.tb.airbnb.lottie.b krX;
    @Nullable
    l krY;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b krZ;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.c.c krT = new com.tb.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> dk = new HashSet();
    private final ArrayList<b> dl = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface b {
        void h(e eVar);
    }

    public f() {
        this.krT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.krZ != null) {
                    f.this.krZ.setProgress(f.this.krT.dq());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.krZ != null && this.krZ.hasMasks();
    }

    public boolean hasMatte() {
        return this.krZ != null && this.krZ.hasMatte();
    }

    public boolean bc() {
        return this.dt;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.dt = z;
        if (this.composition != null) {
            bd();
        }
    }

    public void G(@Nullable String str) {
        this.cQ = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.cQ;
    }

    public void recycleBitmaps() {
        if (this.krU != null) {
            this.krU.recycleBitmaps();
        }
    }

    public boolean g(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        bf();
        this.composition = eVar;
        bd();
        this.krT.g(eVar.getDuration());
        setProgress(this.krT.dq());
        setScale(this.scale);
        bk();
        be();
        Iterator it = new ArrayList(this.dl).iterator();
        while (it.hasNext()) {
            ((b) it.next()).h(eVar);
            it.remove();
        }
        this.dl.clear();
        eVar.setPerformanceTrackingEnabled(this.dv);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.dv = z;
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

    private void bd() {
        this.krZ = new com.tb.airbnb.lottie.model.layer.b(this, Layer.a.j(this.composition), this.composition.aW(), this.composition);
    }

    private void be() {
        if (this.krZ != null) {
            for (a aVar : this.dk) {
                this.krZ.b(aVar.dA, aVar.dB, aVar.dC);
            }
        }
    }

    public void bf() {
        recycleBitmaps();
        if (this.krT.isRunning()) {
            this.krT.cancel();
        }
        this.composition = null;
        this.krZ = null;
        this.krU = null;
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
        this.dk.clear();
        a(null, null, null);
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        a aVar = new a(str, str2, colorFilter);
        if (colorFilter == null && this.dk.contains(aVar)) {
            this.dk.remove(aVar);
        } else {
            this.dk.add(new a(str, str2, colorFilter));
        }
        if (this.krZ != null) {
            this.krZ.b(str, str2, colorFilter);
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
        if (this.krZ != null) {
            float f2 = this.scale;
            float c = c(canvas);
            if (f2 > c) {
                f = this.scale / c;
            } else {
                c = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = this.composition.aS().width() / 2.0f;
                float height = this.composition.aS().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.krZ.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void playAnimation() {
        if (this.krZ == null) {
            this.dl.add(new b() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.krT.playAnimation();
        }
    }

    public void resumeAnimation() {
        if (this.krZ == null) {
            this.dl.add(new b() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.krT.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.dl.add(new b() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.composition.ba());
        }
    }

    public void setMinProgress(float f) {
        this.krT.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.dl.add(new b() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.composition.ba());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.krT.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.dl.add(new b() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.krT.j(i / this.composition.ba(), i2 / this.composition.ba());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.krT.j(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.krT.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.krT.setSpeed(f);
    }

    public float getSpeed() {
        return this.krT.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.krT.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.krT.removeUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.krT.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.krT.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.dl.add(new b() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.b
                public void h(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.composition.ba());
        }
    }

    public int getFrame() {
        if (this.composition == null) {
            return 0;
        }
        return (int) (getProgress() * this.composition.ba());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.krT.l(f);
        if (this.krZ != null) {
            this.krZ.setProgress(f);
        }
    }

    public void loop(boolean z) {
        this.krT.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.krT.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.krT.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg() {
        this.krT.bg();
    }

    public void setScale(float f) {
        this.scale = f;
        bk();
    }

    public void setImageAssetDelegate(c cVar) {
        this.krV = cVar;
        if (this.krU != null) {
            this.krU.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.b bVar) {
        this.krX = bVar;
        if (this.krW != null) {
            this.krW.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.krY = lVar;
    }

    @Nullable
    public l cKZ() {
        return this.krY;
    }

    public boolean bi() {
        return this.krY == null && this.composition.aX().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e cLa() {
        return this.composition;
    }

    private void bk() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.aS().width() * scale), (int) (scale * this.composition.aS().height()));
        }
    }

    public void cancelAnimation() {
        this.dl.clear();
        this.krT.cancel();
    }

    public void pauseAnimation() {
        this.dl.clear();
        this.krT.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.krT.dq();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.aS().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.aS().height() * getScale());
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b cLb = cLb();
        if (cLb == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = cLb.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap H(String str) {
        com.tb.airbnb.lottie.b.b cLb = cLb();
        if (cLb != null) {
            return cLb.L(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b cLb() {
        if (getCallback() == null) {
            return null;
        }
        if (this.krU != null && !this.krU.P(getContext())) {
            this.krU.recycleBitmaps();
            this.krU = null;
        }
        if (this.krU == null) {
            this.krU = new com.tb.airbnb.lottie.b.b(getCallback(), this.cQ, this.krV, this.composition.aZ());
        }
        return this.krU;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.tb.airbnb.lottie.b.a cLc = cLc();
        if (cLc != null) {
            return cLc.g(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a cLc() {
        if (getCallback() == null) {
            return null;
        }
        if (this.krW == null) {
            this.krW = new com.tb.airbnb.lottie.b.a(getCallback(), this.krX);
        }
        return this.krW;
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

    private float c(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.composition.aS().width(), canvas.getHeight() / this.composition.aS().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        final String dA;
        @Nullable
        final String dB;
        @Nullable
        final ColorFilter dC;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.dA = str;
            this.dB = str2;
            this.dC = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.dA != null) {
                i = this.dA.hashCode() * 527;
            }
            if (this.dB != null) {
                return i * 31 * this.dB.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.dC == aVar.dC;
            }
            return false;
        }
    }
}
