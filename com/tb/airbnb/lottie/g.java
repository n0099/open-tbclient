package com.tb.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.baidu.mapapi.map.WeightedLatLng;
import com.tb.airbnb.lottie.c.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes16.dex */
public class g extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = g.class.getSimpleName();
    private boolean BH;
    private boolean BJ;
    @Nullable
    private String Bf;
    private e composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b pHU;
    @Nullable
    private c pHV;
    @Nullable
    private com.tb.airbnb.lottie.b.a pHW;
    @Nullable
    b pHX;
    @Nullable
    r pHY;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b pHZ;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c pHT = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> BA = new HashSet();
    private final ArrayList<a> BB = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public interface a {
        void c(e eVar);
    }

    public g() {
        this.pHT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.pHZ != null) {
                    g.this.pHZ.setProgress(g.this.pHT.kV());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.pHZ != null && this.pHZ.hasMasks();
    }

    public boolean hasMatte() {
        return this.pHZ != null && this.pHZ.hasMatte();
    }

    public boolean iG() {
        return this.BH;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.BH != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.BH = z;
            if (this.composition != null) {
                iH();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.BH;
    }

    public void be(@Nullable String str) {
        this.Bf = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.Bf;
    }

    public void recycleBitmaps() {
        if (this.pHU != null) {
            this.pHU.recycleBitmaps();
        }
    }

    public boolean b(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        iH();
        this.pHT.setComposition(eVar);
        setProgress(this.pHT.getAnimatedFraction());
        setScale(this.scale);
        iK();
        Iterator it = new ArrayList(this.BB).iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(eVar);
            it.remove();
        }
        this.BB.clear();
        eVar.setPerformanceTrackingEnabled(this.BJ);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.BJ = z;
        if (this.composition != null) {
            this.composition.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public o getPerformanceTracker() {
        if (this.composition != null) {
            return this.composition.getPerformanceTracker();
        }
        return null;
    }

    private void iH() {
        this.pHZ = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.iz(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.pHT.isRunning()) {
            this.pHT.cancel();
        }
        this.composition = null;
        this.pHZ = null;
        this.pHU = null;
        this.pHT.clearComposition();
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

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        d.beginSection("Drawable#draw");
        if (this.pHZ != null) {
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
                float width = this.composition.iu().width() / 2.0f;
                float height = this.composition.iu().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.pHZ.a(canvas, this.matrix, this.alpha);
            d.bb("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    @MainThread
    public void playAnimation() {
        if (this.pHZ == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.5
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.playAnimation();
                }
            });
        } else {
            this.pHT.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.BB.clear();
        this.pHT.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.pHZ == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.6
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.resumeAnimation();
                }
            });
        } else {
            this.pHT.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.7
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.pHT.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.pHT.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.8
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.9
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.pHT.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.pHT.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.10
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.11
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.pHT.k(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.12
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.pHT.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.pHT.setSpeed(f);
    }

    public float getSpeed() {
        return this.pHT.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pHT.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pHT.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.pHT.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.pHT.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.pHT.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.pHT.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.2
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.pHT.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.pHT.kW();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.3
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.pHT.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.pHT.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.pHT.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.pHT.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.pHT.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        iK();
    }

    public void setImageAssetDelegate(c cVar) {
        this.pHV = cVar;
        if (this.pHU != null) {
            this.pHU.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.pHX = bVar;
        if (this.pHW != null) {
            this.pHW.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.pHY = rVar;
    }

    @Nullable
    public r eyy() {
        return this.pHY;
    }

    public boolean iJ() {
        return this.pHY == null && this.composition.iA().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void iK() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.iu().width() * scale), (int) (scale * this.composition.iu().height()));
        }
    }

    public void cancelAnimation() {
        this.BB.clear();
        this.pHT.cancel();
    }

    public void pauseAnimation() {
        this.BB.clear();
        this.pHT.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.pHT.kV();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.iu().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.iu().height() * getScale());
    }

    public List<com.tb.airbnb.lottie.model.e> resolveKeyPath(com.tb.airbnb.lottie.model.e eVar) {
        if (this.pHZ == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.pHZ.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.pHZ == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.g.4
                @Override // com.tb.airbnb.lottie.g.a
                public void c(e eVar2) {
                    g.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.eyJ() != null) {
            eVar.eyJ().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).eyJ().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == k.Cr) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b eyz = eyz();
        if (eyz == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = eyz.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.tb.airbnb.lottie.b.b eyz = eyz();
        if (eyz != null) {
            return eyz.bj(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b eyz() {
        if (getCallback() == null) {
            return null;
        }
        if (this.pHU != null && !this.pHU.F(getContext())) {
            this.pHU.recycleBitmaps();
            this.pHU = null;
        }
        if (this.pHU == null) {
            this.pHU = new com.tb.airbnb.lottie.b.b(getCallback(), this.Bf, this.pHV, this.composition.iC());
        }
        return this.pHU;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.tb.airbnb.lottie.b.a eyA = eyA();
        if (eyA != null) {
            return eyA.q(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a eyA() {
        if (getCallback() == null) {
            return null;
        }
        if (this.pHW == null) {
            this.pHW = new com.tb.airbnb.lottie.b.a(getCallback(), this.pHX);
        }
        return this.pHW;
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
        return Math.min(canvas.getWidth() / this.composition.iu().width(), canvas.getHeight() / this.composition.iu().height());
    }
}
