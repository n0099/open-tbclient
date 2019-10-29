package com.tb.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mapapi.map.WeightedLatLng;
import com.tb.airbnb.lottie.e;
import com.tb.airbnb.lottie.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LottieAnimationView extends ImageView {
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay;
    @Nullable
    private e composition;
    @Nullable
    private a compositionLoader;
    private CacheStrategy defaultCacheStrategy;
    private final h loadedListener;
    private final f lottieDrawable;
    private boolean useHardwareLayer;
    private boolean wasAnimatingWhenDetached;
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private static final SparseArray<e> RAW_RES_STRONG_REF_CACHE = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> RAW_RES_WEAK_REF_CACHE = new SparseArray<>();
    private static final Map<String, e> ASSET_STRONG_REF_CACHE = new HashMap();
    private static final Map<String, WeakReference<e>> ASSET_WEAK_REF_CACHE = new HashMap();

    /* loaded from: classes6.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new h() { // from class: com.tb.airbnb.lottie.LottieAnimationView.1
            @Override // com.tb.airbnb.lottie.h
            public void onCompositionLoaded(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.compositionLoader = null;
            }
        };
        this.lottieDrawable = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new h() { // from class: com.tb.airbnb.lottie.LottieAnimationView.1
            @Override // com.tb.airbnb.lottie.h
            public void onCompositionLoaded(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.compositionLoader = null;
            }
        };
        this.lottieDrawable = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new h() { // from class: com.tb.airbnb.lottie.LottieAnimationView.1
            @Override // com.tb.airbnb.lottie.h
            public void onCompositionLoaded(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.compositionLoader = null;
            }
        };
        this.lottieDrawable = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.TbLottieAnimationView);
        this.defaultCacheStrategy = CacheStrategy.values()[obtainStyledAttributes.getInt(1, CacheStrategy.Weak.ordinal())];
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(8);
            boolean hasValue2 = obtainStyledAttributes.hasValue(4);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(8, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2 && (string = obtainStyledAttributes.getString(4)) != null) {
                setAnimation(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(0, false)) {
            this.lottieDrawable.playAnimation();
            this.autoPlay = true;
        }
        this.lottieDrawable.loop(obtainStyledAttributes.getBoolean(6, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(5));
        setProgress(obtainStyledAttributes.getFloat(7, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(3, false));
        if (obtainStyledAttributes.hasValue(2)) {
            addColorFilter(new k(obtainStyledAttributes.getColor(2, 0)));
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(9, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.tb.airbnb.lottie.c.f.Q(getContext()) == 0.0f) {
            this.lottieDrawable.bg();
        }
        enableOrDisableHardwareLayer();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.lottieDrawable) {
            recycleBitmaps();
        }
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void addColorFilterToContent(String str, String str2, @Nullable ColorFilter colorFilter) {
        this.lottieDrawable.addColorFilterToContent(str, str2, colorFilter);
    }

    public void addColorFilterToLayer(String str, @Nullable ColorFilter colorFilter) {
        this.lottieDrawable.addColorFilterToLayer(str, colorFilter);
    }

    public void addColorFilter(@Nullable ColorFilter colorFilter) {
        this.lottieDrawable.addColorFilter(colorFilter);
    }

    public void clearColorFilters() {
        this.lottieDrawable.clearColorFilters();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.lottieDrawable) {
            super.invalidateDrawable(this.lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.dr = this.lottieDrawable.isAnimating();
        savedState.ds = this.lottieDrawable.isLooping();
        savedState.dt = this.lottieDrawable.getImageAssetsFolder();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.animationName;
        if (!TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.animationResId;
        if (this.animationResId != 0) {
            setAnimation(this.animationResId);
        }
        setProgress(savedState.progress);
        loop(savedState.ds);
        if (savedState.dr) {
            playAnimation();
        }
        this.lottieDrawable.G(savedState.dt);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        recycleBitmaps();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void recycleBitmaps() {
        if (this.lottieDrawable != null) {
            this.lottieDrawable.recycleBitmaps();
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration(boolean z) {
        useHardwareAcceleration(z);
    }

    public void useHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public void useHardwareAcceleration(boolean z) {
        this.useHardwareLayer = z;
        enableOrDisableHardwareLayer();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.defaultCacheStrategy);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.animationResId = i;
        this.animationName = null;
        if (RAW_RES_WEAK_REF_CACHE.indexOfKey(i) > 0) {
            e eVar = RAW_RES_WEAK_REF_CACHE.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (RAW_RES_STRONG_REF_CACHE.indexOfKey(i) > 0) {
            setComposition(RAW_RES_STRONG_REF_CACHE.get(i));
            return;
        }
        this.lottieDrawable.cancelAnimation();
        cancelLoaderTask();
        this.compositionLoader = e.a.a(getContext(), i, new h() { // from class: com.tb.airbnb.lottie.LottieAnimationView.2
            @Override // com.tb.airbnb.lottie.h
            public void onCompositionLoaded(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.RAW_RES_STRONG_REF_CACHE.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.RAW_RES_WEAK_REF_CACHE.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.defaultCacheStrategy);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.animationName = str;
        this.animationResId = 0;
        if (ASSET_WEAK_REF_CACHE.containsKey(str)) {
            e eVar = ASSET_WEAK_REF_CACHE.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (ASSET_STRONG_REF_CACHE.containsKey(str)) {
            setComposition(ASSET_STRONG_REF_CACHE.get(str));
            return;
        }
        this.lottieDrawable.cancelAnimation();
        cancelLoaderTask();
        this.compositionLoader = e.a.a(getContext(), str, new h() { // from class: com.tb.airbnb.lottie.LottieAnimationView.3
            @Override // com.tb.airbnb.lottie.h
            public void onCompositionLoaded(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.ASSET_STRONG_REF_CACHE.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.ASSET_WEAK_REF_CACHE.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        cancelLoaderTask();
        this.compositionLoader = e.a.a(getResources(), jSONObject, this.loadedListener);
    }

    private void cancelLoaderTask() {
        if (this.compositionLoader != null) {
            this.compositionLoader.cancel();
            this.compositionLoader = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.lottieDrawable.setCallback(this);
        boolean g = this.lottieDrawable.g(eVar);
        enableOrDisableHardwareLayer();
        if (g) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            this.composition = eVar;
            requestLayout();
        }
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void playAnimation() {
        this.lottieDrawable.playAnimation();
        enableOrDisableHardwareLayer();
    }

    public void resumeAnimation() {
        this.lottieDrawable.resumeAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.a(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public void loop(boolean z) {
        this.lottieDrawable.loop(z);
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public void setImageAssetDelegate(c cVar) {
        this.lottieDrawable.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.lottieDrawable.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.lottieDrawable.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.lottieDrawable.setScale(f);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public void cancelAnimation() {
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieDrawable.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        if (this.composition != null) {
            return this.composition.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void enableOrDisableHardwareLayer() {
        setLayerType(this.useHardwareLayer && this.lottieDrawable.isAnimating() ? 2 : 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() { // from class: com.tb.airbnb.lottie.LottieAnimationView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ab */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Dd */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        int animationResId;
        boolean dr;
        boolean ds;
        String dt;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.dr = parcel.readInt() == 1;
            this.ds = parcel.readInt() == 1;
            this.dt = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.dr ? 1 : 0);
            parcel.writeInt(this.ds ? 1 : 0);
            parcel.writeString(this.dt);
        }
    }
}
