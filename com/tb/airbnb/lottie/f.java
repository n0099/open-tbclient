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
/* loaded from: classes5.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private d composition;
    @Nullable
    private String dS;
    private boolean ev;
    private boolean ey;
    @Nullable
    private com.tb.airbnb.lottie.b.b noM;
    @Nullable
    private b noN;
    @Nullable
    private com.tb.airbnb.lottie.b.a noO;
    @Nullable
    com.tb.airbnb.lottie.a noP;
    @Nullable
    p noQ;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b noR;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c noL = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> en = new HashSet();
    private final ArrayList<a> eo = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.noL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.noR != null) {
                    f.this.noR.setProgress(f.this.noL.dE());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.noR != null && this.noR.hasMasks();
    }

    public boolean hasMatte() {
        return this.noR != null && this.noR.hasMatte();
    }

    public boolean bp() {
        return this.ev;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.ev != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.ev = z;
            if (this.composition != null) {
                bq();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.ev;
    }

    public void I(@Nullable String str) {
        this.dS = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dS;
    }

    public void recycleBitmaps() {
        if (this.noM != null) {
            this.noM.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        bq();
        this.noL.setComposition(dVar);
        setProgress(this.noL.getAnimatedFraction());
        setScale(this.scale);
        bt();
        Iterator it = new ArrayList(this.eo).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.eo.clear();
        dVar.setPerformanceTrackingEnabled(this.ey);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.ey = z;
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

    private void bq() {
        this.noR = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.bj(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.noL.isRunning()) {
            this.noL.cancel();
        }
        this.composition = null;
        this.noR = null;
        this.noM = null;
        this.noL.clearComposition();
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
        if (this.noR != null) {
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
            this.noR.a(canvas, this.matrix, this.alpha);
            c.F("Drawable#draw");
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
        if (this.noR == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.noL.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.eo.clear();
        this.noL.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.noR == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.noL.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.noL.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.noL.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.8
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.noL.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.noL.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.10
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.noL.e(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.12
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.noL.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.noL.setSpeed(f);
    }

    public float getSpeed() {
        return this.noL.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.noL.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.noL.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.noL.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.noL.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.noL.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.noL.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.noL.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.noL.dF();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.noL.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.noL.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.noL.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.noL.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.noL.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        bt();
    }

    public void setImageAssetDelegate(b bVar) {
        this.noN = bVar;
        if (this.noM != null) {
            this.noM.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.noP = aVar;
        if (this.noO != null) {
            this.noO.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.noQ = pVar;
    }

    @Nullable
    public p dFt() {
        return this.noQ;
    }

    public boolean bs() {
        return this.noQ == null && this.composition.bk().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.composition;
    }

    private void bt() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.be().width() * scale), (int) (scale * this.composition.be().height()));
        }
    }

    public void cancelAnimation() {
        this.eo.clear();
        this.noL.cancel();
    }

    public void pauseAnimation() {
        this.eo.clear();
        this.noL.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.noL.dE();
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

    public List<com.tb.airbnb.lottie.model.e> resolveKeyPath(com.tb.airbnb.lottie.model.e eVar) {
        if (this.noR == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.noR.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.noR == null) {
            this.eo.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.dFE() != null) {
            eVar.dFE().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).dFE().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.fi) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b dFu = dFu();
        if (dFu == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = dFu.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap J(String str) {
        com.tb.airbnb.lottie.b.b dFu = dFu();
        if (dFu != null) {
            return dFu.N(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b dFu() {
        if (getCallback() == null) {
            return null;
        }
        if (this.noM != null && !this.noM.Q(getContext())) {
            this.noM.recycleBitmaps();
            this.noM = null;
        }
        if (this.noM == null) {
            this.noM = new com.tb.airbnb.lottie.b.b(getCallback(), this.dS, this.noN, this.composition.bm());
        }
        return this.noM;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.tb.airbnb.lottie.b.a dFv = dFv();
        if (dFv != null) {
            return dFv.g(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a dFv() {
        if (getCallback() == null) {
            return null;
        }
        if (this.noO == null) {
            this.noO = new com.tb.airbnb.lottie.b.a(getCallback(), this.noP);
        }
        return this.noO;
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
}
