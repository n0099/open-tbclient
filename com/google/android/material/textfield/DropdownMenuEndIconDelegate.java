package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes7.dex */
public class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_FADE_IN_DURATION = 67;
    public static final int ANIMATION_FADE_OUT_DURATION = 50;
    public static final boolean IS_LOLLIPOP;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextInputLayout.AccessibilityDelegate accessibilityDelegate;
    @Nullable
    public AccessibilityManager accessibilityManager;
    public final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    public long dropdownPopupActivatedAt;
    public boolean dropdownPopupDirty;
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    public final TextWatcher exposedDropdownEndIconTextWatcher;
    public ValueAnimator fadeInAnim;
    public ValueAnimator fadeOutAnim;
    public StateListDrawable filledPopupBackground;
    public boolean isEndIconChecked;
    public final View.OnFocusChangeListener onFocusChangeListener;
    public MaterialShapeDrawable outlinedPopupBackground;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(686932480, "Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(686932480, "Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;");
                return;
            }
        }
        IS_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textInputLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TextInputLayout) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.exposedDropdownEndIconTextWatcher = new TextWatcher(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.this$0;
                    AutoCompleteTextView castAutoCompleteTextViewOrThrow = dropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(dropdownMenuEndIconDelegate.textInputLayout.getEditText());
                    castAutoCompleteTextViewOrThrow.post(new Runnable(this, castAutoCompleteTextViewOrThrow) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ AutoCompleteTextView val$editText;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, castAutoCompleteTextViewOrThrow};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$editText = castAutoCompleteTextViewOrThrow;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                boolean isPopupShowing = this.val$editText.isPopupShowing();
                                this.this$1.this$0.setEndIconChecked(isPopupShowing);
                                this.this$1.this$0.dropdownPopupDirty = isPopupShowing;
                            }
                        }
                    });
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i4, i5, i6) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i4, i5, i6) == null) {
                }
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                    this.this$0.textInputLayout.setEndIconActivated(z);
                    if (z) {
                        return;
                    }
                    this.this$0.setEndIconChecked(false);
                    this.this$0.dropdownPopupDirty = false;
                }
            }
        };
        this.accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(this, this.textInputLayout) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((TextInputLayout) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view, accessibilityNodeInfoCompat) == null) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    if (this.this$0.textInputLayout.getEditText().getKeyListener() == null) {
                        accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
                    }
                    if (accessibilityNodeInfoCompat.isShowingHintText()) {
                        accessibilityNodeInfoCompat.setHintText(null);
                    }
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityEvent) == null) {
                    super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.this$0;
                    AutoCompleteTextView castAutoCompleteTextViewOrThrow = dropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(dropdownMenuEndIconDelegate.textInputLayout.getEditText());
                    if (accessibilityEvent.getEventType() == 1 && this.this$0.accessibilityManager.isTouchExplorationEnabled()) {
                        this.this$0.showHideDropdown(castAutoCompleteTextViewOrThrow);
                    }
                }
            }
        };
        this.dropdownMenuOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    AutoCompleteTextView castAutoCompleteTextViewOrThrow = this.this$0.castAutoCompleteTextViewOrThrow(textInputLayout2.getEditText());
                    this.this$0.setPopupBackground(castAutoCompleteTextViewOrThrow);
                    this.this$0.addRippleEffect(castAutoCompleteTextViewOrThrow);
                    this.this$0.setUpDropdownShowHideBehavior(castAutoCompleteTextViewOrThrow);
                    castAutoCompleteTextViewOrThrow.setThreshold(0);
                    castAutoCompleteTextViewOrThrow.removeTextChangedListener(this.this$0.exposedDropdownEndIconTextWatcher);
                    castAutoCompleteTextViewOrThrow.addTextChangedListener(this.this$0.exposedDropdownEndIconTextWatcher);
                    textInputLayout2.setEndIconCheckable(true);
                    textInputLayout2.setErrorIconDrawable((Drawable) null);
                    textInputLayout2.setTextInputAccessibilityDelegate(this.this$0.accessibilityDelegate);
                    textInputLayout2.setEndIconVisible(true);
                }
            }
        };
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i4) {
                AutoCompleteTextView autoCompleteTextView;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, textInputLayout2, i4) == null) && (autoCompleteTextView = (AutoCompleteTextView) textInputLayout2.getEditText()) != null && i4 == 3) {
                    autoCompleteTextView.removeTextChangedListener(this.this$0.exposedDropdownEndIconTextWatcher);
                    if (autoCompleteTextView.getOnFocusChangeListener() == this.this$0.onFocusChangeListener) {
                        autoCompleteTextView.setOnFocusChangeListener(null);
                    }
                    autoCompleteTextView.setOnTouchListener(null);
                    if (DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
                        autoCompleteTextView.setOnDismissListener(null);
                    }
                }
            }
        };
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRippleEffect(@NonNull AutoCompleteTextView autoCompleteTextView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, autoCompleteTextView) == null) && autoCompleteTextView.getKeyListener() == null) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            MaterialShapeDrawable boxBackground = this.textInputLayout.getBoxBackground();
            int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorControlHighlight);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                addRippleEffectOnOutlinedLayout(autoCompleteTextView, color, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                addRippleEffectOnFilledLayout(autoCompleteTextView, color, iArr, boxBackground);
            }
        }
    }

    private void addRippleEffectOnFilledLayout(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65555, this, autoCompleteTextView, i2, iArr, materialShapeDrawable) == null) {
            int boxBackgroundColor = this.textInputLayout.getBoxBackgroundColor();
            int[] iArr2 = {MaterialColors.layer(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
            if (IS_LOLLIPOP) {
                ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
                return;
            }
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable2.setFillColor(new ColorStateList(iArr, iArr2));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
            int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
            int paddingTop = autoCompleteTextView.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
            int paddingBottom = autoCompleteTextView.getPaddingBottom();
            ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
            ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
        }
    }

    private void addRippleEffectOnOutlinedLayout(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65556, this, autoCompleteTextView, i2, iArr, materialShapeDrawable) == null) {
            int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorSurface);
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            int layer = MaterialColors.layer(i2, color, 0.1f);
            materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
            if (IS_LOLLIPOP) {
                materialShapeDrawable2.setTint(color);
                ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color});
                MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
                materialShapeDrawable3.setTint(-1);
                layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
            } else {
                layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
            }
            ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, editText)) == null) {
            if (editText instanceof AutoCompleteTextView) {
                return (AutoCompleteTextView) editText;
            }
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        return (AutoCompleteTextView) invokeL.objValue;
    }

    private ValueAnimator getAlphaAnimator(int i2, float... fArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65558, this, i2, fArr)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            ofFloat.setDuration(i2);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
        return (ValueAnimator) invokeIL.objValue;
    }

    private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f2, float f3, float f4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)})) == null) {
            ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomLeftCornerSize(f3).setBottomRightCornerSize(f3).build();
            MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.context, f4);
            createWithElevationOverlay.setShapeAppearanceModel(build);
            createWithElevationOverlay.setPadding(0, i2, 0, i2);
            return createWithElevationOverlay;
        }
        return (MaterialShapeDrawable) invokeCommon.objValue;
    }

    private void initAnimators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.fadeInAnim = getAlphaAnimator(67, 0.0f, 1.0f);
            ValueAnimator alphaAnimator = getAlphaAnimator(50, 1.0f, 0.0f);
            this.fadeOutAnim = alphaAnimator;
            alphaAnimator.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.this$0;
                        dropdownMenuEndIconDelegate.endIconView.setChecked(dropdownMenuEndIconDelegate.isEndIconChecked);
                        this.this$0.fadeInAnim.start();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDropdownPopupActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
            return currentTimeMillis < 0 || currentTimeMillis > 300;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndIconChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65562, this, z) == null) || this.isEndIconChecked == z) {
            return;
        }
        this.isEndIconChecked = z;
        this.fadeInAnim.cancel();
        this.fadeOutAnim.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopupBackground(@NonNull AutoCompleteTextView autoCompleteTextView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, this, autoCompleteTextView) == null) && IS_LOLLIPOP) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.filledPopupBackground);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void setUpDropdownShowHideBehavior(@NonNull AutoCompleteTextView autoCompleteTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, autoCompleteTextView) == null) {
            autoCompleteTextView.setOnTouchListener(new View.OnTouchListener(this, autoCompleteTextView) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DropdownMenuEndIconDelegate this$0;
                public final /* synthetic */ AutoCompleteTextView val$editText;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, autoCompleteTextView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$editText = autoCompleteTextView;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 1) {
                            if (this.this$0.isDropdownPopupActive()) {
                                this.this$0.dropdownPopupDirty = false;
                            }
                            this.this$0.showHideDropdown(this.val$editText);
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            autoCompleteTextView.setOnFocusChangeListener(this.onFocusChangeListener);
            if (IS_LOLLIPOP) {
                autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.widget.AutoCompleteTextView.OnDismissListener
                    public void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.dropdownPopupDirty = true;
                            this.this$0.dropdownPopupActivatedAt = System.currentTimeMillis();
                            this.this$0.setEndIconChecked(false);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHideDropdown(@Nullable AutoCompleteTextView autoCompleteTextView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65565, this, autoCompleteTextView) == null) || autoCompleteTextView == null) {
            return;
        }
        if (isDropdownPopupActive()) {
            this.dropdownPopupDirty = false;
        }
        if (!this.dropdownPopupDirty) {
            if (IS_LOLLIPOP) {
                setEndIconChecked(!this.isEndIconChecked);
            } else {
                this.isEndIconChecked = !this.isEndIconChecked;
                this.endIconView.toggle();
            }
            if (this.isEndIconChecked) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            }
            autoCompleteTextView.dismissDropDown();
            return;
        }
        this.dropdownPopupDirty = false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            float dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
            float dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
            int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
            MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
            MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
            this.outlinedPopupBackground = popUpMaterialShapeDrawable;
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.filledPopupBackground = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, popUpMaterialShapeDrawable);
            this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
            this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, IS_LOLLIPOP ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
            TextInputLayout textInputLayout = this.textInputLayout;
            textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
            this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DropdownMenuEndIconDelegate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.showHideDropdown((AutoCompleteTextView) this.this$0.textInputLayout.getEditText());
                    }
                }
            });
            this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
            this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
            initAnimators();
            ViewCompat.setImportantForAccessibility(this.endIconView, 2);
            this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isBoxBackgroundModeSupported(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 != 0 : invokeI.booleanValue;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean shouldTintIconOnError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
