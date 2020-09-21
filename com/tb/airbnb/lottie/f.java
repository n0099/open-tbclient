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
/* loaded from: classes17.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    @Nullable
    private String AM;
    private boolean Bq;
    private boolean Bs;
    private d composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b orN;
    @Nullable
    private b orO;
    @Nullable
    private com.tb.airbnb.lottie.b.a orP;
    @Nullable
    com.tb.airbnb.lottie.a orQ;
    @Nullable
    p orR;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b orS;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c orM = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> Bj = new HashSet();
    private final ArrayList<a> Bk = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.orM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.orS != null) {
                    f.this.orS.setProgress(f.this.orM.kU());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.orS != null && this.orS.hasMasks();
    }

    public boolean hasMatte() {
        return this.orS != null && this.orS.hasMatte();
    }

    public boolean iF() {
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
                iG();
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
        if (this.orN != null) {
            this.orN.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        iG();
        this.orM.setComposition(dVar);
        setProgress(this.orM.getAnimatedFraction());
        setScale(this.scale);
        iJ();
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

    private void iG() {
        this.orS = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.iy(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.orM.isRunning()) {
            this.orM.cancel();
        }
        this.composition = null;
        this.orS = null;
        this.orN = null;
        this.orM.clearComposition();
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
        if (this.orS != null) {
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
            this.orS.a(canvas, this.matrix, this.alpha);
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
        if (this.orS == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.orM.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Bk.clear();
        this.orM.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.orS == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.orM.resumeAnimation();
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
            this.orM.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.orM.getMinFrame();
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
            this.orM.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.orM.getMaxFrame();
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
            this.orM.k(i, i2);
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
        this.orM.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.orM.setSpeed(f);
    }

    public float getSpeed() {
        return this.orM.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.orM.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.orM.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.orM.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.orM.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.orM.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.orM.removeAllListeners();
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
            this.orM.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.orM.kV();
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
        this.orM.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.orM.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.orM.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.orM.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.orM.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        iJ();
    }

    public void setImageAssetDelegate(b bVar) {
        this.orO = bVar;
        if (this.orN != null) {
            this.orN.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.orQ = aVar;
        if (this.orP != null) {
            this.orP.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.orR = pVar;
    }

    @Nullable
    public p egY() {
        return this.orR;
    }

    public boolean iI() {
        return this.orR == null && this.composition.iz().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.composition;
    }

    private void iJ() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.it().width() * scale), (int) (scale * this.composition.it().height()));
        }
    }

    public void cancelAnimation() {
        this.Bk.clear();
        this.orM.cancel();
    }

    public void pauseAnimation() {
        this.Bk.clear();
        this.orM.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.orM.kU();
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
        if (this.orS == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.orS.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.orS == null) {
            this.Bk.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.ehj() != null) {
            eVar.ehj().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).ehj().a(t, cVar);
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
        com.tb.airbnb.lottie.b.b egZ = egZ();
        if (egZ == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = egZ.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.tb.airbnb.lottie.b.b egZ = egZ();
        if (egZ != null) {
            return egZ.bj(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b egZ() {
        if (getCallback() == null) {
            return null;
        }
        if (this.orN != null && !this.orN.F(getContext())) {
            this.orN.recycleBitmaps();
            this.orN = null;
        }
        if (this.orN == null) {
            this.orN = new com.tb.airbnb.lottie.b.b(getCallback(), this.AM, this.orO, this.composition.iB());
        }
        return this.orN;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.tb.airbnb.lottie.b.a eha = eha();
        if (eha != null) {
            return eha.q(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a eha() {
        if (getCallback() == null) {
            return null;
        }
        if (this.orP == null) {
            this.orP = new com.tb.airbnb.lottie.b.a(getCallback(), this.orQ);
        }
        return this.orP;
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
