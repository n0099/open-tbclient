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
    private d composition;
    @Nullable
    private String dT;
    private boolean eB;
    private boolean ez;
    @Nullable
    private com.tb.airbnb.lottie.b.b npB;
    @Nullable
    private b npC;
    @Nullable
    private com.tb.airbnb.lottie.b.a npD;
    @Nullable
    com.tb.airbnb.lottie.a npE;
    @Nullable
    p npF;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b npG;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c npA = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> ep = new HashSet();
    private final ArrayList<a> er = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.npA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.npG != null) {
                    f.this.npG.setProgress(f.this.npA.dF());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.npG != null && this.npG.hasMasks();
    }

    public boolean hasMatte() {
        return this.npG != null && this.npG.hasMatte();
    }

    public boolean bq() {
        return this.ez;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.ez != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.ez = z;
            if (this.composition != null) {
                br();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.ez;
    }

    public void I(@Nullable String str) {
        this.dT = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dT;
    }

    public void recycleBitmaps() {
        if (this.npB != null) {
            this.npB.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        br();
        this.npA.setComposition(dVar);
        setProgress(this.npA.getAnimatedFraction());
        setScale(this.scale);
        bu();
        Iterator it = new ArrayList(this.er).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.er.clear();
        dVar.setPerformanceTrackingEnabled(this.eB);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.eB = z;
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

    private void br() {
        this.npG = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.bk(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.npA.isRunning()) {
            this.npA.cancel();
        }
        this.composition = null;
        this.npG = null;
        this.npB = null;
        this.npA.clearComposition();
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
        if (this.npG != null) {
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
                float width = this.composition.bf().width() / 2.0f;
                float height = this.composition.bf().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.npG.a(canvas, this.matrix, this.alpha);
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
        if (this.npG == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.npA.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.er.clear();
        this.npA.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.npG == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.npA.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.npA.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.npA.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.8
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.npA.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.npA.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.10
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.npA.f(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.12
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f), (int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.npA.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.npA.setSpeed(f);
    }

    public float getSpeed() {
        return this.npA.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.npA.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.npA.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.npA.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.npA.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.npA.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.npA.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.npA.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.npA.dG();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.3
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.tb.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.npA.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.npA.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.npA.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.npA.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.npA.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        bu();
    }

    public void setImageAssetDelegate(b bVar) {
        this.npC = bVar;
        if (this.npB != null) {
            this.npB.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.npE = aVar;
        if (this.npD != null) {
            this.npD.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.npF = pVar;
    }

    @Nullable
    public p dGD() {
        return this.npF;
    }

    public boolean bt() {
        return this.npF == null && this.composition.bl().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.composition;
    }

    private void bu() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.bf().width() * scale), (int) (scale * this.composition.bf().height()));
        }
    }

    public void cancelAnimation() {
        this.er.clear();
        this.npA.cancel();
    }

    public void pauseAnimation() {
        this.er.clear();
        this.npA.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.npA.dF();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.bf().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.bf().height() * getScale());
    }

    public List<com.tb.airbnb.lottie.model.e> resolveKeyPath(com.tb.airbnb.lottie.model.e eVar) {
        if (this.npG == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.npG.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.npG == null) {
            this.er.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.dGO() != null) {
            eVar.dGO().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).dGO().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.fo) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b dGE = dGE();
        if (dGE == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = dGE.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap J(String str) {
        com.tb.airbnb.lottie.b.b dGE = dGE();
        if (dGE != null) {
            return dGE.N(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b dGE() {
        if (getCallback() == null) {
            return null;
        }
        if (this.npB != null && !this.npB.Q(getContext())) {
            this.npB.recycleBitmaps();
            this.npB = null;
        }
        if (this.npB == null) {
            this.npB = new com.tb.airbnb.lottie.b.b(getCallback(), this.dT, this.npC, this.composition.bn());
        }
        return this.npB;
    }

    @Nullable
    public Typeface j(String str, String str2) {
        com.tb.airbnb.lottie.b.a dGF = dGF();
        if (dGF != null) {
            return dGF.j(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a dGF() {
        if (getCallback() == null) {
            return null;
        }
        if (this.npD == null) {
            this.npD = new com.tb.airbnb.lottie.b.a(getCallback(), this.npE);
        }
        return this.npD;
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
        return Math.min(canvas.getWidth() / this.composition.bf().width(), canvas.getHeight() / this.composition.bf().height());
    }
}
