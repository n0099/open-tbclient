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
/* loaded from: classes7.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    @Nullable
    private String AM;
    private boolean Bq;
    private boolean Bs;
    private d composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b ohL;
    @Nullable
    private b ohM;
    @Nullable
    private com.tb.airbnb.lottie.b.a ohN;
    @Nullable
    com.tb.airbnb.lottie.a ohO;
    @Nullable
    p ohP;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b ohQ;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c ohK = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> Bj = new HashSet();
    private final ArrayList<a> Bk = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.ohK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.ohQ != null) {
                    f.this.ohQ.setProgress(f.this.ohK.kT());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.ohQ != null && this.ohQ.hasMasks();
    }

    public boolean hasMatte() {
        return this.ohQ != null && this.ohQ.hasMatte();
    }

    public boolean iE() {
        return this.Bq;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Bq != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Bq = z;
            if (this.composition != null) {
                iF();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.Bq;
    }

    public void be(@Nullable String str) {
        this.AM = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.AM;
    }

    public void recycleBitmaps() {
        if (this.ohL != null) {
            this.ohL.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        iF();
        this.ohK.setComposition(dVar);
        setProgress(this.ohK.getAnimatedFraction());
        setScale(this.scale);
        iI();
        Iterator it = new ArrayList(this.Bk).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.Bk.clear();
        dVar.setPerformanceTrackingEnabled(this.Bs);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Bs = z;
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

    private void iF() {
        this.ohQ = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.iy(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.ohK.isRunning()) {
            this.ohK.cancel();
        }
        this.composition = null;
        this.ohQ = null;
        this.ohL = null;
        this.ohK.clearComposition();
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
        if (this.ohQ != null) {
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
                float width = this.composition.it().width() / 2.0f;
                float height = this.composition.it().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.ohQ.a(canvas, this.matrix, this.alpha);
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
        if (this.ohQ == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.ohK.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Bk.clear();
        this.ohK.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.ohQ == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.ohK.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.ohK.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.ohK.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.8
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.ohK.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.ohK.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.10
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.ohK.k(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.12
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.ohK.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.ohK.setSpeed(f);
    }

    public float getSpeed() {
        return this.ohK.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ohK.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ohK.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.ohK.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.ohK.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.ohK.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.ohK.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.ohK.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.ohK.kU();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.ohK.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.ohK.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.ohK.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.ohK.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.ohK.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        iI();
    }

    public void setImageAssetDelegate(b bVar) {
        this.ohM = bVar;
        if (this.ohL != null) {
            this.ohL.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.ohO = aVar;
        if (this.ohN != null) {
            this.ohN.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.ohP = pVar;
    }

    @Nullable
    public p ecS() {
        return this.ohP;
    }

    public boolean iH() {
        return this.ohP == null && this.composition.iz().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.composition;
    }

    private void iI() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.it().width() * scale), (int) (scale * this.composition.it().height()));
        }
    }

    public void cancelAnimation() {
        this.Bk.clear();
        this.ohK.cancel();
    }

    public void pauseAnimation() {
        this.Bk.clear();
        this.ohK.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.ohK.kT();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.it().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.it().height() * getScale());
    }

    public List<com.tb.airbnb.lottie.model.e> resolveKeyPath(com.tb.airbnb.lottie.model.e eVar) {
        if (this.ohQ == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.ohQ.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.ohQ == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.edd() != null) {
            eVar.edd().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).edd().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.Ca) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b ecT = ecT();
        if (ecT == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = ecT.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.tb.airbnb.lottie.b.b ecT = ecT();
        if (ecT != null) {
            return ecT.bj(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b ecT() {
        if (getCallback() == null) {
            return null;
        }
        if (this.ohL != null && !this.ohL.F(getContext())) {
            this.ohL.recycleBitmaps();
            this.ohL = null;
        }
        if (this.ohL == null) {
            this.ohL = new com.tb.airbnb.lottie.b.b(getCallback(), this.AM, this.ohM, this.composition.iB());
        }
        return this.ohL;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.tb.airbnb.lottie.b.a ecU = ecU();
        if (ecU != null) {
            return ecU.q(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a ecU() {
        if (getCallback() == null) {
            return null;
        }
        if (this.ohN == null) {
            this.ohN = new com.tb.airbnb.lottie.b.a(getCallback(), this.ohO);
        }
        return this.ohN;
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
        return Math.min(canvas.getWidth() / this.composition.it().width(), canvas.getHeight() / this.composition.it().height());
    }
}
