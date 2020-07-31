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
    private boolean AJ;
    private boolean AM;
    @Nullable
    private String Ah;
    private d composition;
    @Nullable
    private com.tb.airbnb.lottie.b.b nNP;
    @Nullable
    private b nNQ;
    @Nullable
    private com.tb.airbnb.lottie.b.a nNR;
    @Nullable
    com.tb.airbnb.lottie.a nNS;
    @Nullable
    p nNT;
    @Nullable
    private com.tb.airbnb.lottie.model.layer.b nNU;
    private final Matrix matrix = new Matrix();
    private final com.tb.airbnb.lottie.d.c nNO = new com.tb.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> AC = new HashSet();
    private final ArrayList<a> AD = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void b(d dVar);
    }

    public f() {
        this.nNO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tb.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.nNU != null) {
                    f.this.nNU.setProgress(f.this.nNO.ju());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.nNU != null && this.nNU.hasMasks();
    }

    public boolean hasMatte() {
        return this.nNU != null && this.nNU.hasMatte();
    }

    public boolean hd() {
        return this.AJ;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.AJ != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.AJ = z;
            if (this.composition != null) {
                he();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.AJ;
    }

    public void aZ(@Nullable String str) {
        this.Ah = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.Ah;
    }

    public void recycleBitmaps() {
        if (this.nNP != null) {
            this.nNP.recycleBitmaps();
        }
    }

    public boolean a(d dVar) {
        if (this.composition == dVar) {
            return false;
        }
        clearComposition();
        this.composition = dVar;
        he();
        this.nNO.setComposition(dVar);
        setProgress(this.nNO.getAnimatedFraction());
        setScale(this.scale);
        hh();
        Iterator it = new ArrayList(this.AD).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(dVar);
            it.remove();
        }
        this.AD.clear();
        dVar.setPerformanceTrackingEnabled(this.AM);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.AM = z;
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
        this.nNU = new com.tb.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.gX(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.nNO.isRunning()) {
            this.nNO.cancel();
        }
        this.composition = null;
        this.nNU = null;
        this.nNP = null;
        this.nNO.clearComposition();
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
        if (this.nNU != null) {
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
            this.nNU.a(canvas, this.matrix, this.alpha);
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
        if (this.nNU == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.5
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.nNO.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.AD.clear();
        this.nNO.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.nNU == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.6
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.nNO.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.7
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.nNO.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.nNO.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.8
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
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.9
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.nNO.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.nNO.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.10
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
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.11
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.nNO.i(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.12
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
        this.nNO.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.nNO.setSpeed(f);
    }

    public float getSpeed() {
        return this.nNO.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nNO.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nNO.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.nNO.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.nNO.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.nNO.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.nNO.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.2
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.nNO.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.nNO.jv();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.3
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
        this.nNO.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.nNO.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.nNO.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.nNO.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.nNO.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        hh();
    }

    public void setImageAssetDelegate(b bVar) {
        this.nNQ = bVar;
        if (this.nNP != null) {
            this.nNP.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.tb.airbnb.lottie.a aVar) {
        this.nNS = aVar;
        if (this.nNR != null) {
            this.nNR.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.nNT = pVar;
    }

    @Nullable
    public p dQP() {
        return this.nNT;
    }

    public boolean hg() {
        return this.nNT == null && this.composition.gY().size() > 0;
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
        this.AD.clear();
        this.nNO.cancel();
    }

    public void pauseAnimation() {
        this.AD.clear();
        this.nNO.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.nNO.ju();
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
        if (this.nNU == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.nNU.a(eVar, 0, arrayList, new com.tb.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.tb.airbnb.lottie.model.e eVar, final T t, final com.tb.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.nNU == null) {
            this.AD.add(new a() { // from class: com.tb.airbnb.lottie.f.4
                @Override // com.tb.airbnb.lottie.f.a
                public void b(d dVar) {
                    f.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.dRa() != null) {
            eVar.dRa().a(t, cVar);
        } else {
            List<com.tb.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).dRa().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.Bw) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.tb.airbnb.lottie.b.b dQQ = dQQ();
        if (dQQ == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = dQQ.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap ba(String str) {
        com.tb.airbnb.lottie.b.b dQQ = dQQ();
        if (dQQ != null) {
            return dQQ.be(str);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.b dQQ() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nNP != null && !this.nNP.D(getContext())) {
            this.nNP.recycleBitmaps();
            this.nNP = null;
        }
        if (this.nNP == null) {
            this.nNP = new com.tb.airbnb.lottie.b.b(getCallback(), this.Ah, this.nNQ, this.composition.ha());
        }
        return this.nNP;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.tb.airbnb.lottie.b.a dQR = dQR();
        if (dQR != null) {
            return dQR.n(str, str2);
        }
        return null;
    }

    private com.tb.airbnb.lottie.b.a dQR() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nNR == null) {
            this.nNR = new com.tb.airbnb.lottie.b.a(getCallback(), this.nNS);
        }
        return this.nNR;
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
