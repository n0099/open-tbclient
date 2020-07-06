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
/* loaded from: classes6.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private boolean AH;
    private boolean AJ;
    @Nullable
    private String Af;
    private d composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b nFh;
    @Nullable
    private b nFi;
    @Nullable
    private com.tb.airbnb.lottie.b.a nFj;
    @Nullable
    com.tb.airbnb.lottie.a nFk;
    @Nullable
    p nFl;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b nFm;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c nFg = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> AA = new HashSet();
    private final ArrayList<a> AB = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.nFg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.nFm != null) {
                    f.this.nFm.setProgress(f.this.nFg.ju());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.nFm != null && this.nFm.hasMasks();
    }

    public boolean hasMatte() {
        return this.nFm != null && this.nFm.hasMatte();
    }

    public boolean hd() {
        return this.AH;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.AH != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.AH = z;
            if (this.composition != null) {
                he();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.AH;
    }

    public void aZ(@Nullable String str) {
        this.Af = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.Af;
    }

    public void recycleBitmaps() {
        if (this.nFh != null) {
            this.nFh.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        he();
        this.nFg.setComposition(dVar);
        setProgress(this.nFg.getAnimatedFraction());
        setScale(this.scale);
        hh();
        Iterator it = new ArrayList(this.AB).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.AB.clear();
        dVar.setPerformanceTrackingEnabled(this.AJ);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.AJ = z;
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

    private void he() {
        this.nFm = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.gX(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.nFg.isRunning()) {
            this.nFg.cancel();
        }
        this.composition = null;
        this.nFm = null;
        this.nFh = null;
        this.nFg.clearComposition();
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
        if (this.nFm != null) {
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
                float width = this.composition.gS().width() / 2.0f;
                float height = this.composition.gS().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.nFm.a(canvas, this.matrix, this.alpha);
            c.aW("Drawable#draw");
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
        if (this.nFm == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.nFg.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.AB.clear();
        this.nFg.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.nFm == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.nFg.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.nFg.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.nFg.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.8
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.nFg.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.nFg.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.10
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.nFg.i(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.12
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.nFg.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.nFg.setSpeed(f);
    }

    public float getSpeed() {
        return this.nFg.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nFg.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nFg.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.nFg.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.nFg.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.nFg.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.nFg.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.nFg.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.nFg.jv();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.nFg.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.nFg.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.nFg.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.nFg.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.nFg.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        hh();
    }

    public void setImageAssetDelegate(b bVar) {
        this.nFi = bVar;
        if (this.nFh != null) {
            this.nFh.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.nFk = aVar;
        if (this.nFj != null) {
            this.nFj.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.nFl = pVar;
    }

    @Nullable
    public p dNt() {
        return this.nFl;
    }

    public boolean hg() {
        return this.nFl == null && this.composition.gY().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.composition;
    }

    private void hh() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.gS().width() * scale), (int) (scale * this.composition.gS().height()));
        }
    }

    public void cancelAnimation() {
        this.AB.clear();
        this.nFg.cancel();
    }

    public void pauseAnimation() {
        this.AB.clear();
        this.nFg.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.nFg.ju();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gS().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gS().height() * getScale());
    }

    public List<com.tb.airbnb.lottie.model.e> resolveKeyPath(com.tb.airbnb.lottie.model.e eVar) {
        if (this.nFm == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.nFm.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.nFm == null) {
            this.AB.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.dNE() != null) {
            eVar.dNE().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).dNE().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.Bu) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b dNu = dNu();
        if (dNu == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = dNu.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap ba(String str) {
        com.tb.airbnb.lottie.b.b dNu = dNu();
        if (dNu != null) {
            return dNu.be(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b dNu() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nFh != null && !this.nFh.D(getContext())) {
            this.nFh.recycleBitmaps();
            this.nFh = null;
        }
        if (this.nFh == null) {
            this.nFh = new com.tb.airbnb.lottie.b.b(getCallback(), this.Af, this.nFi, this.composition.ha());
        }
        return this.nFh;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.tb.airbnb.lottie.b.a dNv = dNv();
        if (dNv != null) {
            return dNv.n(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a dNv() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nFj == null) {
            this.nFj = new com.tb.airbnb.lottie.b.a(getCallback(), this.nFk);
        }
        return this.nFj;
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
        return Math.min(canvas.getWidth() / this.composition.gS().width(), canvas.getHeight() / this.composition.gS().height());
    }
}
