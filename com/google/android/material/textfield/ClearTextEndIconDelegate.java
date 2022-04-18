package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes5.dex */
public class ClearTextEndIconDelegate extends EndIconDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_FADE_DURATION = 100;
    public static final int ANIMATION_SCALE_DURATION = 150;
    public static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextWatcher clearTextEndIconTextWatcher;
    public final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    public final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    public AnimatorSet iconInAnim;
    public ValueAnimator iconOutAnim;
    public final View.OnFocusChangeListener onFocusChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textInputLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TextInputLayout) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.clearTextEndIconTextWatcher = new TextWatcher(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@NonNull Editable editable) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) && this.this$0.textInputLayout.getSuffixText() == null) {
                    this.this$0.animateIcon(ClearTextEndIconDelegate.hasText(editable));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i3, i4, i5) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i3, i4, i5) == null) {
                }
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                    boolean z2 = true;
                    this.this$0.animateIcon(((TextUtils.isEmpty(((EditText) view2).getText()) ^ true) && z) ? false : false);
                }
            }
        };
        this.clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, textInputLayout2) == null) {
                    EditText editText = textInputLayout2.getEditText();
                    textInputLayout2.setEndIconVisible(editText.hasFocus() && ClearTextEndIconDelegate.hasText(editText.getText()));
                    textInputLayout2.setEndIconCheckable(false);
                    editText.setOnFocusChangeListener(this.this$0.onFocusChangeListener);
                    editText.removeTextChangedListener(this.this$0.clearTextEndIconTextWatcher);
                    editText.addTextChangedListener(this.this$0.clearTextEndIconTextWatcher);
                }
            }
        };
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i3) {
                EditText editText;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, textInputLayout2, i3) == null) && (editText = textInputLayout2.getEditText()) != null && i3 == 2) {
                    editText.removeTextChangedListener(this.this$0.clearTextEndIconTextWatcher);
                    if (editText.getOnFocusChangeListener() == this.this$0.onFocusChangeListener) {
                        editText.setOnFocusChangeListener(null);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            boolean z2 = this.textInputLayout.isEndIconVisible() == z;
            if (z) {
                this.iconOutAnim.cancel();
                this.iconInAnim.start();
                if (z2) {
                    this.iconInAnim.end();
                    return;
                }
                return;
            }
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if (z2) {
                this.iconOutAnim.end();
            }
        }
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, fArr)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            ofFloat.setDuration(100L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ClearTextEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.this$0.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            });
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    private ValueAnimator getScaleAnimator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ClearTextEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.this$0.endIconView.setScaleX(floatValue);
                        this.this$0.endIconView.setScaleY(floatValue);
                    }
                }
            });
            return ofFloat;
        }
        return (ValueAnimator) invokeV.objValue;
    }

    public static boolean hasText(@NonNull Editable editable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, editable)) == null) ? editable.length() > 0 : invokeL.booleanValue;
    }

    private void initAnimators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ValueAnimator scaleAnimator = getScaleAnimator();
            ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.iconInAnim = animatorSet;
            animatorSet.playTogether(scaleAnimator, alphaAnimator);
            this.iconInAnim.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ClearTextEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.textInputLayout.setEndIconVisible(true);
                    }
                }
            });
            ValueAnimator alphaAnimator2 = getAlphaAnimator(1.0f, 0.0f);
            this.iconOutAnim = alphaAnimator2;
            alphaAnimator2.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ClearTextEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.textInputLayout.setEndIconVisible(false);
                    }
                }
            });
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.obfuscated_res_0x7f080d6e));
            TextInputLayout textInputLayout = this.textInputLayout;
            textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.obfuscated_res_0x7f0f03d6));
            this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ClearTextEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Editable text;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || (text = this.this$0.textInputLayout.getEditText().getText()) == null) {
                        return;
                    }
                    text.clear();
                }
            });
            this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
            this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
            initAnimators();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z);
    }
}
