package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.baidu.tieba.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes9.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    public static final int DEFAULT_DISTANCE = -1;
    @Px
    public int slideDistance = -1;
    public int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes9.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        this.slideEdge = i;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i = this.slideDistance;
        if (i != -1) {
            return i;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070647);
    }

    public static boolean isRtl(View view2) {
        if (ViewCompat.getLayoutDirection(view2) == 1) {
            return true;
        }
        return false;
    }

    public void setSlideDistance(@Px int i) {
        if (i >= 0) {
            this.slideDistance = i;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i) {
        this.slideEdge = i;
    }

    public static Animator createTranslationAppearAnimator(View view2, View view3, int i, @Px int i2) {
        float f;
        float f2;
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i != 8388611) {
                            if (i == 8388613) {
                                if (isRtl(view2)) {
                                    f2 = -i2;
                                } else {
                                    f2 = i2;
                                }
                                return createTranslationXAnimator(view3, f2, 0.0f);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i);
                        }
                        if (isRtl(view2)) {
                            f = i2;
                        } else {
                            f = -i2;
                        }
                        return createTranslationXAnimator(view3, f, 0.0f);
                    }
                    return createTranslationYAnimator(view3, i2, 0.0f);
                }
                return createTranslationYAnimator(view3, -i2, 0.0f);
            }
            return createTranslationXAnimator(view3, -i2, 0.0f);
        }
        return createTranslationXAnimator(view3, i2, 0.0f);
    }

    public static Animator createTranslationDisappearAnimator(View view2, View view3, int i, @Px int i2) {
        float f;
        float f2;
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i != 8388611) {
                            if (i == 8388613) {
                                if (isRtl(view2)) {
                                    f2 = i2;
                                } else {
                                    f2 = -i2;
                                }
                                return createTranslationXAnimator(view3, 0.0f, f2);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i);
                        }
                        if (isRtl(view2)) {
                            f = -i2;
                        } else {
                            f = i2;
                        }
                        return createTranslationXAnimator(view3, 0.0f, f);
                    }
                    return createTranslationYAnimator(view3, 0.0f, -i2);
                }
                return createTranslationYAnimator(view3, 0.0f, i2);
            }
            return createTranslationXAnimator(view3, 0.0f, i2);
        }
        return createTranslationXAnimator(view3, 0.0f, -i2);
    }

    public static Animator createTranslationXAnimator(View view2, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f, f2));
    }

    public static Animator createTranslationYAnimator(View view2, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f, f2));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        return createTranslationAppearAnimator(viewGroup, view2, this.slideEdge, getSlideDistanceOrDefault(view2.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        return createTranslationDisappearAnimator(viewGroup, view2, this.slideEdge, getSlideDistanceOrDefault(view2.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }
}
