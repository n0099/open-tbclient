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
    private com.tb.airbnb.lottie.b.b oid;
    @Nullable
    private b oie;
    @Nullable
    private com.tb.airbnb.lottie.b.a oif;
    @Nullable
    com.tb.airbnb.lottie.a oig;
    @Nullable
    p oih;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b oii;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c oic = new com.tb.airbnb.lottie.d.c();
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
        this.oic.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.oii != null) {
                    f.this.oii.setProgress(f.this.oic.kT());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.oii != null && this.oii.hasMasks();
    }

    public boolean hasMatte() {
        return this.oii != null && this.oii.hasMatte();
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
        if (this.oid != null) {
            this.oid.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        iF();
        this.oic.setComposition(dVar);
        setProgress(this.oic.getAnimatedFraction());
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
        this.oii = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.iy(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.oic.isRunning()) {
            this.oic.cancel();
        }
        this.composition = null;
        this.oii = null;
        this.oid = null;
        this.oic.clearComposition();
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
        if (this.oii != null) {
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
            this.oii.a(canvas, this.matrix, this.alpha);
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
        if (this.oii == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.oic.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Bk.clear();
        this.oic.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.oii == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.oic.resumeAnimation();
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
            this.oic.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.oic.getMinFrame();
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
            this.oic.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.oic.getMaxFrame();
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
            this.oic.k(i, i2);
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
        this.oic.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.oic.setSpeed(f);
    }

    public float getSpeed() {
        return this.oic.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.oic.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.oic.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.oic.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.oic.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.oic.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.oic.removeAllListeners();
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
            this.oic.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.oic.kU();
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
        this.oic.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.oic.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.oic.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.oic.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.oic.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        iI();
    }

    public void setImageAssetDelegate(b bVar) {
        this.oie = bVar;
        if (this.oid != null) {
            this.oid.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.oig = aVar;
        if (this.oif != null) {
            this.oif.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.oih = pVar;
    }

    @Nullable
    public p edb() {
        return this.oih;
    }

    public boolean iH() {
        return this.oih == null && this.composition.iz().size() > 0;
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
        this.oic.cancel();
    }

    public void pauseAnimation() {
        this.Bk.clear();
        this.oic.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.oic.kT();
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
        if (this.oii == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.oii.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.oii == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.edm() != null) {
            eVar.edm().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).edm().a(t, cVar);
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
        com.tb.airbnb.lottie.b.b edc = edc();
        if (edc == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = edc.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.tb.airbnb.lottie.b.b edc = edc();
        if (edc != null) {
            return edc.bj(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b edc() {
        if (getCallback() == null) {
            return null;
        }
        if (this.oid != null && !this.oid.F(getContext())) {
            this.oid.recycleBitmaps();
            this.oid = null;
        }
        if (this.oid == null) {
            this.oid = new com.tb.airbnb.lottie.b.b(getCallback(), this.AM, this.oie, this.composition.iB());
        }
        return this.oid;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.tb.airbnb.lottie.b.a edd = edd();
        if (edd != null) {
            return edd.q(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a edd() {
        if (getCallback() == null) {
            return null;
        }
        if (this.oif == null) {
            this.oif = new com.tb.airbnb.lottie.b.a(getCallback(), this.oig);
        }
        return this.oif;
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
