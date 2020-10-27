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
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private boolean BH;
    private boolean BJ;
    @Nullable
    private String Bf;
    private d composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b pyA;
    @Nullable
    private b pyB;
    @Nullable
    private com.tb.airbnb.lottie.b.a pyC;
    @Nullable
    com.tb.airbnb.lottie.a pyD;
    @Nullable
    p pyE;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b pyF;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c pyz = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> BA = new HashSet();
    private final ArrayList<a> BB = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.pyz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.pyF != null) {
                    f.this.pyF.setProgress(f.this.pyz.kV());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.pyF != null && this.pyF.hasMasks();
    }

    public boolean hasMatte() {
        return this.pyF != null && this.pyF.hasMatte();
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
        if (this.pyA != null) {
            this.pyA.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        iH();
        this.pyz.setComposition(dVar);
        setProgress(this.pyz.getAnimatedFraction());
        setScale(this.scale);
        iK();
        Iterator it = new ArrayList(this.BB).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.BB.clear();
        dVar.setPerformanceTrackingEnabled(this.BJ);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.BJ = z;
        if (this.composition != null) {
            this.composition.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public m getPerformanceTracker() {
        if (this.composition != null) {
            return this.composition.getPerformanceTracker();
        }
        return null;
    }

    private void iH() {
        this.pyF = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.iz(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.pyz.isRunning()) {
            this.pyz.cancel();
        }
        this.composition = null;
        this.pyF = null;
        this.pyA = null;
        this.pyz.clearComposition();
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
        c.beginSection("Drawable#draw");
        if (this.pyF != null) {
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
            this.pyF.a(canvas, this.matrix, this.alpha);
            c.bb("Drawable#draw");
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
        if (this.pyF == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.pyz.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.BB.clear();
        this.pyz.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.pyF == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.pyz.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.pyz.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.pyz.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.8
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.pyz.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.pyz.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.10
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.pyz.k(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.12
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.pyz.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.pyz.setSpeed(f);
    }

    public float getSpeed() {
        return this.pyz.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pyz.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pyz.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.pyz.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.pyz.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.pyz.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.pyz.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.pyz.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.pyz.kW();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iw(), this.composition.ix(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.pyz.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.pyz.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.pyz.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.pyz.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.pyz.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        iK();
    }

    public void setImageAssetDelegate(b bVar) {
        this.pyB = bVar;
        if (this.pyA != null) {
            this.pyA.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.pyD = aVar;
        if (this.pyC != null) {
            this.pyC.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.pyE = pVar;
    }

    @Nullable
    public p euJ() {
        return this.pyE;
    }

    public boolean iJ() {
        return this.pyE == null && this.composition.iA().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
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
        this.pyz.cancel();
    }

    public void pauseAnimation() {
        this.BB.clear();
        this.pyz.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.pyz.kV();
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
        if (this.pyF == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.pyF.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.pyF == null) {
            this.BB.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.euU() != null) {
            eVar.euU().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).euU().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.Cr) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b euK = euK();
        if (euK == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = euK.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.tb.airbnb.lottie.b.b euK = euK();
        if (euK != null) {
            return euK.bj(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b euK() {
        if (getCallback() == null) {
            return null;
        }
        if (this.pyA != null && !this.pyA.F(getContext())) {
            this.pyA.recycleBitmaps();
            this.pyA = null;
        }
        if (this.pyA == null) {
            this.pyA = new com.tb.airbnb.lottie.b.b(getCallback(), this.Bf, this.pyB, this.composition.iC());
        }
        return this.pyA;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.tb.airbnb.lottie.b.a euL = euL();
        if (euL != null) {
            return euL.q(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a euL() {
        if (getCallback() == null) {
            return null;
        }
        if (this.pyC == null) {
            this.pyC = new com.tb.airbnb.lottie.b.a(getCallback(), this.pyD);
        }
        return this.pyC;
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
