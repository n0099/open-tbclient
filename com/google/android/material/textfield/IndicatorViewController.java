package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class IndicatorViewController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    public static final int CAPTION_STATE_ERROR = 1;
    public static final int CAPTION_STATE_HELPER_TEXT = 2;
    public static final int CAPTION_STATE_NONE = 0;
    public static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    public static final int COUNTER_INDEX = 2;
    public static final int ERROR_INDEX = 0;
    public static final int HELPER_INDEX = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Animator captionAnimator;
    public FrameLayout captionArea;
    public int captionDisplayed;
    public int captionToShow;
    public final float captionTranslationYPx;
    public int captionViewsAdded;
    public final Context context;
    public boolean errorEnabled;
    @Nullable
    public CharSequence errorText;
    public int errorTextAppearance;
    @Nullable
    public TextView errorView;
    @Nullable
    public CharSequence errorViewContentDescription;
    @Nullable
    public ColorStateList errorViewTextColor;
    public CharSequence helperText;
    public boolean helperTextEnabled;
    public int helperTextTextAppearance;
    @Nullable
    public TextView helperTextView;
    @Nullable
    public ColorStateList helperTextViewTextColor;
    public LinearLayout indicatorArea;
    public int indicatorsAdded;
    @NonNull
    public final TextInputLayout textInputView;
    public Typeface typeface;

    public IndicatorViewController(@NonNull TextInputLayout textInputLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textInputLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context context = textInputLayout.getContext();
        this.context = context;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070226);
    }

    private boolean canAdjustIndicatorPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? (this.indicatorArea == null || this.textInputView.getEditText() == null) ? false : true : invokeV.booleanValue;
    }

    private void createCaptionAnimators(@NonNull List<Animator> list, boolean z, @Nullable TextView textView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{list, Boolean.valueOf(z), textView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && textView != null && z) {
            if (i == i3 || i == i2) {
                list.add(createCaptionOpacityAnimator(textView, i3 == i));
                if (i3 == i) {
                    list.add(createCaptionTranslationYAnimator(textView));
                }
            }
        }
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView textView, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, this, textView, z)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
            ofFloat.setDuration(167L);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            return ofFloat;
        }
        return (ObjectAnimator) invokeLZ.objValue;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, textView)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.captionTranslationYPx, 0.0f);
            ofFloat.setDuration(217L);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    @Nullable
    private TextView getCaptionViewFromDisplayState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return this.helperTextView;
            }
            return this.errorView;
        }
        return (TextView) invokeI.objValue;
    }

    private boolean isCaptionStateError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i)) == null) ? (i != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) ? false : true : invokeI.booleanValue;
    }

    private boolean isCaptionStateHelperText(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) ? (i != 2 || this.helperTextView == null || TextUtils.isEmpty(this.helperText)) ? false : true : invokeI.booleanValue;
    }

    private void setCaptionViewVisibilities(int i, int i2) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65547, this, i, i2) == null) || i == i2) {
            return;
        }
        if (i2 != 0 && (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i2)) != null) {
            captionViewFromDisplayState2.setVisibility(0);
            captionViewFromDisplayState2.setAlpha(1.0f);
        }
        if (i != 0 && (captionViewFromDisplayState = getCaptionViewFromDisplayState(i)) != null) {
            captionViewFromDisplayState.setVisibility(4);
            if (i == 1) {
                captionViewFromDisplayState.setText((CharSequence) null);
            }
        }
        this.captionDisplayed = i2;
    }

    private void setTextViewTypeface(@Nullable TextView textView, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, this, textView, typeface) == null) || textView == null) {
            return;
        }
        textView.setTypeface(typeface);
    }

    private void setViewGroupGoneIfEmpty(@NonNull ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65549, this, viewGroup, i) == null) && i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean shouldAnimateCaptionView(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, textView, charSequence)) == null) ? ViewCompat.isLaidOut(this.textInputView) && this.textInputView.isEnabled() && !(this.captionToShow == this.captionDisplayed && textView != null && TextUtils.equals(textView.getText(), charSequence)) : invokeLL.booleanValue;
    }

    private void updateCaptionViewsVisibility(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            createCaptionAnimators(arrayList, this.helperTextEnabled, this.helperTextView, 2, i, i2);
            createCaptionAnimators(arrayList, this.errorEnabled, this.errorView, 1, i, i2);
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            animatorSet.addListener(new AnimatorListenerAdapter(this, i2, getCaptionViewFromDisplayState(i), i, getCaptionViewFromDisplayState(i2)) { // from class: com.google.android.material.textfield.IndicatorViewController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IndicatorViewController this$0;
                public final /* synthetic */ int val$captionToHide;
                public final /* synthetic */ int val$captionToShow;
                public final /* synthetic */ TextView val$captionViewToHide;
                public final /* synthetic */ TextView val$captionViewToShow;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), r8, Integer.valueOf(i), r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$captionToShow = i2;
                    this.val$captionViewToHide = r8;
                    this.val$captionToHide = i;
                    this.val$captionViewToShow = r10;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.captionDisplayed = this.val$captionToShow;
                        this.this$0.captionAnimator = null;
                        TextView textView = this.val$captionViewToHide;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (this.val$captionToHide == 1 && this.this$0.errorView != null) {
                                this.this$0.errorView.setText((CharSequence) null);
                            }
                        }
                        TextView textView2 = this.val$captionViewToShow;
                        if (textView2 != null) {
                            textView2.setTranslationY(0.0f);
                            this.val$captionViewToShow.setAlpha(1.0f);
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    TextView textView;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (textView = this.val$captionViewToShow) == null) {
                        return;
                    }
                    textView.setVisibility(0);
                }
            });
            animatorSet.start();
        } else {
            setCaptionViewVisibilities(i, i2);
        }
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(z);
        this.textInputView.updateTextInputBoxState();
    }

    public void addIndicator(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, textView, i) == null) {
            if (this.indicatorArea == null && this.captionArea == null) {
                LinearLayout linearLayout = new LinearLayout(this.context);
                this.indicatorArea = linearLayout;
                linearLayout.setOrientation(0);
                this.textInputView.addView(this.indicatorArea, -1, -2);
                this.captionArea = new FrameLayout(this.context);
                this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
                if (this.textInputView.getEditText() != null) {
                    adjustIndicatorPadding();
                }
            }
            if (isCaptionView(i)) {
                this.captionArea.setVisibility(0);
                this.captionArea.addView(textView);
                this.captionViewsAdded++;
            } else {
                this.indicatorArea.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            }
            this.indicatorArea.setVisibility(0);
            this.indicatorsAdded++;
        }
    }

    public void adjustIndicatorPadding() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && canAdjustIndicatorPadding()) {
            ViewCompat.setPaddingRelative(this.indicatorArea, ViewCompat.getPaddingStart(this.textInputView.getEditText()), 0, ViewCompat.getPaddingEnd(this.textInputView.getEditText()), 0);
        }
    }

    public void cancelCaptionAnimator() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (animator = this.captionAnimator) == null) {
            return;
        }
        animator.cancel();
    }

    public boolean errorIsDisplayed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? isCaptionStateError(this.captionDisplayed) : invokeV.booleanValue;
    }

    public boolean errorShouldBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? isCaptionStateError(this.captionToShow) : invokeV.booleanValue;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.errorViewContentDescription : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public CharSequence getErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.errorText : (CharSequence) invokeV.objValue;
    }

    @ColorInt
    public int getErrorViewCurrentTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = this.errorView;
            if (textView != null) {
                return textView.getCurrentTextColor();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ColorStateList getErrorViewTextColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TextView textView = this.errorView;
            if (textView != null) {
                return textView.getTextColors();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public CharSequence getHelperText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.helperText : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getHelperTextViewColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TextView textView = this.helperTextView;
            if (textView != null) {
                return textView.getTextColors();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @ColorInt
    public int getHelperTextViewCurrentTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TextView textView = this.helperTextView;
            if (textView != null) {
                return textView.getCurrentTextColor();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean helperTextIsDisplayed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? isCaptionStateHelperText(this.captionDisplayed) : invokeV.booleanValue;
    }

    public boolean helperTextShouldBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? isCaptionStateHelperText(this.captionToShow) : invokeV.booleanValue;
    }

    public void hideError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.errorText = null;
            cancelCaptionAnimator();
            if (this.captionDisplayed == 1) {
                if (this.helperTextEnabled && !TextUtils.isEmpty(this.helperText)) {
                    this.captionToShow = 2;
                } else {
                    this.captionToShow = 0;
                }
            }
            updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
        }
    }

    public void hideHelperText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            cancelCaptionAnimator();
            if (this.captionDisplayed == 2) {
                this.captionToShow = 0;
            }
            updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
        }
    }

    public boolean isCaptionView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? i == 0 || i == 1 : invokeI.booleanValue;
    }

    public boolean isErrorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.errorEnabled : invokeV.booleanValue;
    }

    public boolean isHelperTextEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.helperTextEnabled : invokeV.booleanValue;
    }

    public void removeIndicator(TextView textView, int i) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, textView, i) == null) || this.indicatorArea == null) {
            return;
        }
        if (isCaptionView(i) && (frameLayout = this.captionArea) != null) {
            int i2 = this.captionViewsAdded - 1;
            this.captionViewsAdded = i2;
            setViewGroupGoneIfEmpty(frameLayout, i2);
            this.captionArea.removeView(textView);
        } else {
            this.indicatorArea.removeView(textView);
        }
        int i3 = this.indicatorsAdded - 1;
        this.indicatorsAdded = i3;
        setViewGroupGoneIfEmpty(this.indicatorArea, i3);
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, charSequence) == null) {
            this.errorViewContentDescription = charSequence;
            TextView textView = this.errorView;
            if (textView != null) {
                textView.setContentDescription(charSequence);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.errorEnabled == z) {
            return;
        }
        cancelCaptionAnimator();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.context);
            this.errorView = appCompatTextView;
            appCompatTextView.setId(R.id.obfuscated_res_0x7f091ff6);
            if (Build.VERSION.SDK_INT >= 17) {
                this.errorView.setTextAlignment(5);
            }
            Typeface typeface = this.typeface;
            if (typeface != null) {
                this.errorView.setTypeface(typeface);
            }
            setErrorTextAppearance(this.errorTextAppearance);
            setErrorViewTextColor(this.errorViewTextColor);
            setErrorContentDescription(this.errorViewContentDescription);
            this.errorView.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.errorView, 1);
            addIndicator(this.errorView, 0);
        } else {
            hideError();
            removeIndicator(this.errorView, 0);
            this.errorView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }
        this.errorEnabled = z;
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.errorTextAppearance = i;
            TextView textView = this.errorView;
            if (textView != null) {
                this.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i);
            }
        }
    }

    public void setErrorViewTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, colorStateList) == null) {
            this.errorViewTextColor = colorStateList;
            TextView textView = this.errorView;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.helperTextTextAppearance = i;
            TextView textView = this.helperTextView;
            if (textView != null) {
                TextViewCompat.setTextAppearance(textView, i);
            }
        }
    }

    public void setHelperTextEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || this.helperTextEnabled == z) {
            return;
        }
        cancelCaptionAnimator();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.context);
            this.helperTextView = appCompatTextView;
            appCompatTextView.setId(R.id.obfuscated_res_0x7f091ff7);
            if (Build.VERSION.SDK_INT >= 17) {
                this.helperTextView.setTextAlignment(5);
            }
            Typeface typeface = this.typeface;
            if (typeface != null) {
                this.helperTextView.setTypeface(typeface);
            }
            this.helperTextView.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
            setHelperTextAppearance(this.helperTextTextAppearance);
            setHelperTextViewTextColor(this.helperTextViewTextColor);
            addIndicator(this.helperTextView, 1);
        } else {
            hideHelperText();
            removeIndicator(this.helperTextView, 1);
            this.helperTextView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }
        this.helperTextEnabled = z;
    }

    public void setHelperTextViewTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, colorStateList) == null) {
            this.helperTextViewTextColor = colorStateList;
            TextView textView = this.helperTextView;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setTypefaces(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, typeface) == null) || typeface == this.typeface) {
            return;
        }
        this.typeface = typeface;
        setTextViewTypeface(this.errorView, typeface);
        setTextViewTypeface(this.helperTextView, typeface);
    }

    public void showError(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, charSequence) == null) {
            cancelCaptionAnimator();
            this.errorText = charSequence;
            this.errorView.setText(charSequence);
            if (this.captionDisplayed != 1) {
                this.captionToShow = 1;
            }
            updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, charSequence));
        }
    }

    public void showHelper(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, charSequence) == null) {
            cancelCaptionAnimator();
            this.helperText = charSequence;
            this.helperTextView.setText(charSequence);
            if (this.captionDisplayed != 2) {
                this.captionToShow = 2;
            }
            updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, charSequence));
        }
    }
}
