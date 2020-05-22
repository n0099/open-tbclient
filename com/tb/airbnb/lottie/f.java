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
    private boolean Ah;
    private boolean Aj;
    private d composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b nif;
    @Nullable
    private b nig;
    @Nullable
    private com.tb.airbnb.lottie.b.a nih;
    @Nullable
    com.tb.airbnb.lottie.a nii;
    @Nullable
    p nij;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b nik;
    @Nullable
    private String zE;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c nie = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> zZ = new HashSet();
    private final ArrayList<a> Aa = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.nie.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.nik != null) {
                    f.this.nik.setProgress(f.this.nie.je());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.nik != null && this.nik.hasMasks();
    }

    public boolean hasMatte() {
        return this.nik != null && this.nik.hasMatte();
    }

    public boolean gN() {
        return this.Ah;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Ah != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Ah = z;
            if (this.composition != null) {
                gO();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.Ah;
    }

    public void aY(@Nullable String str) {
        this.zE = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.zE;
    }

    public void recycleBitmaps() {
        if (this.nif != null) {
            this.nif.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        gO();
        this.nie.setComposition(dVar);
        setProgress(this.nie.getAnimatedFraction());
        setScale(this.scale);
        gR();
        Iterator it = new ArrayList(this.Aa).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.Aa.clear();
        dVar.setPerformanceTrackingEnabled(this.Aj);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Aj = z;
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

    private void gO() {
        this.nik = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.gH(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.nie.isRunning()) {
            this.nie.cancel();
        }
        this.composition = null;
        this.nik = null;
        this.nif = null;
        this.nie.clearComposition();
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
        if (this.nik != null) {
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
                float width = this.composition.gC().width() / 2.0f;
                float height = this.composition.gC().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.nik.a(canvas, this.matrix, this.alpha);
            c.aV("Drawable#draw");
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
        if (this.nik == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.nie.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Aa.clear();
        this.nie.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.nik == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.nie.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.nie.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.nie.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.8
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.nie.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.nie.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.10
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.nie.h(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.12
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.nie.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.nie.setSpeed(f);
    }

    public float getSpeed() {
        return this.nie.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nie.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nie.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.nie.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.nie.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.nie.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.nie.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.nie.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.nie.jf();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.nie.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.nie.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.nie.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.nie.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.nie.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        gR();
    }

    public void setImageAssetDelegate(b bVar) {
        this.nig = bVar;
        if (this.nif != null) {
            this.nif.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.nii = aVar;
        if (this.nih != null) {
            this.nih.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.nij = pVar;
    }

    @Nullable
    public p dIv() {
        return this.nij;
    }

    public boolean gQ() {
        return this.nij == null && this.composition.gI().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.composition;
    }

    private void gR() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.gC().width() * scale), (int) (scale * this.composition.gC().height()));
        }
    }

    public void cancelAnimation() {
        this.Aa.clear();
        this.nie.cancel();
    }

    public void pauseAnimation() {
        this.Aa.clear();
        this.nie.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.nie.je();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gC().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gC().height() * getScale());
    }

    public List<com.tb.airbnb.lottie.model.e> resolveKeyPath(com.tb.airbnb.lottie.model.e eVar) {
        if (this.nik == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.nik.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.nik == null) {
            this.Aa.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.dIG() != null) {
            eVar.dIG().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).dIG().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.AU) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b dIw = dIw();
        if (dIw == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = dIw.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap aZ(String str) {
        com.tb.airbnb.lottie.b.b dIw = dIw();
        if (dIw != null) {
            return dIw.bd(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b dIw() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nif != null && !this.nif.D(getContext())) {
            this.nif.recycleBitmaps();
            this.nif = null;
        }
        if (this.nif == null) {
            this.nif = new com.tb.airbnb.lottie.b.b(getCallback(), this.zE, this.nig, this.composition.gK());
        }
        return this.nif;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.tb.airbnb.lottie.b.a dIx = dIx();
        if (dIx != null) {
            return dIx.n(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a dIx() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nih == null) {
            this.nih = new com.tb.airbnb.lottie.b.a(getCallback(), this.nii);
        }
        return this.nih;
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
        return Math.min(canvas.getWidth() / this.composition.gC().width(), canvas.getHeight() / this.composition.gC().height());
    }
}
