package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes7.dex */
public class TextInputLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    public static final int DEF_STYLE_RES = 2131755834;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    public static final int INVALID_MAX_LENGTH = -1;
    public static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    public static final String LOG_TAG = "TextInputLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator animator;
    @Nullable
    public MaterialShapeDrawable boxBackground;
    @ColorInt
    public int boxBackgroundColor;
    public int boxBackgroundMode;
    public final int boxCollapsedPaddingTopPx;
    public final int boxLabelCutoutPaddingPx;
    @ColorInt
    public int boxStrokeColor;
    public int boxStrokeWidthDefaultPx;
    public int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    @Nullable
    public MaterialShapeDrawable boxUnderline;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    public int counterMaxLength;
    public int counterOverflowTextAppearance;
    @Nullable
    public ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public int counterTextAppearance;
    @Nullable
    public ColorStateList counterTextColor;
    @Nullable
    public TextView counterView;
    @ColorInt
    public int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    @ColorInt
    public int defaultStrokeColor;
    @ColorInt
    public int disabledColor;
    @ColorInt
    public int disabledFilledBackgroundColor;
    public EditText editText;
    public final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    @Nullable
    public Drawable endDummyDrawable;
    public int endDummyDrawableWidth;
    public final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    public final SparseArray<EndIconDelegate> endIconDelegates;
    @NonNull
    public final FrameLayout endIconFrame;
    public int endIconMode;
    public View.OnLongClickListener endIconOnLongClickListener;
    public ColorStateList endIconTintList;
    public PorterDuff.Mode endIconTintMode;
    @NonNull
    public final CheckableImageButton endIconView;
    @NonNull
    public final LinearLayout endLayout;
    public View.OnLongClickListener errorIconOnLongClickListener;
    public ColorStateList errorIconTintList;
    @NonNull
    public final CheckableImageButton errorIconView;
    @ColorInt
    public int focusedFilledBackgroundColor;
    @ColorInt
    public int focusedStrokeColor;
    public ColorStateList focusedTextColor;
    public boolean hasEndIconTintList;
    public boolean hasEndIconTintMode;
    public boolean hasStartIconTintList;
    public boolean hasStartIconTintMode;
    public CharSequence hint;
    public boolean hintAnimationEnabled;
    public boolean hintEnabled;
    public boolean hintExpanded;
    @ColorInt
    public int hoveredFilledBackgroundColor;
    @ColorInt
    public int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final IndicatorViewController indicatorViewController;
    @NonNull
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public Drawable originalEditTextEndDrawable;
    public CharSequence originalHint;
    public boolean placeholderEnabled;
    public CharSequence placeholderText;
    public int placeholderTextAppearance;
    @Nullable
    public ColorStateList placeholderTextColor;
    public TextView placeholderTextView;
    @Nullable
    public CharSequence prefixText;
    @NonNull
    public final TextView prefixTextView;
    public boolean restoringSavedState;
    @NonNull
    public ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    public Drawable startDummyDrawable;
    public int startDummyDrawableWidth;
    public View.OnLongClickListener startIconOnLongClickListener;
    public ColorStateList startIconTintList;
    public PorterDuff.Mode startIconTintMode;
    @NonNull
    public final CheckableImageButton startIconView;
    @NonNull
    public final LinearLayout startLayout;
    public ColorStateList strokeErrorColor;
    @Nullable
    public CharSequence suffixText;
    @NonNull
    public final TextView suffixTextView;
    public final Rect tmpBoundsRect;
    public final Rect tmpRect;
    public final RectF tmpRectF;
    public Typeface typeface;

    /* loaded from: classes7.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
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
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                EditText editText = this.layout.getEditText();
                CharSequence text = editText != null ? editText.getText() : null;
                CharSequence hint = this.layout.getHint();
                CharSequence helperText = this.layout.getHelperText();
                CharSequence error = this.layout.getError();
                int counterMaxLength = this.layout.getCounterMaxLength();
                CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
                boolean z = !TextUtils.isEmpty(text);
                boolean z2 = !TextUtils.isEmpty(hint);
                boolean z3 = !TextUtils.isEmpty(helperText);
                boolean z4 = !TextUtils.isEmpty(error);
                boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
                String charSequence = z2 ? hint.toString() : "";
                StringBuilder sb = new StringBuilder();
                sb.append(charSequence);
                sb.append(((z4 || z3) && !TextUtils.isEmpty(charSequence)) ? StringUtil.ARRAY_ELEMENT_SEPARATOR : "");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                if (z4) {
                    helperText = error;
                } else if (!z3) {
                    helperText = "";
                }
                sb3.append((Object) helperText);
                String sb4 = sb3.toString();
                if (z) {
                    accessibilityNodeInfoCompat.setText(text);
                } else if (!TextUtils.isEmpty(sb4)) {
                    accessibilityNodeInfoCompat.setText(sb4);
                }
                if (!TextUtils.isEmpty(sb4)) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        accessibilityNodeInfoCompat.setHintText(sb4);
                    } else {
                        if (z) {
                            sb4 = ((Object) text) + StringUtil.ARRAY_ELEMENT_SEPARATOR + sb4;
                        }
                        accessibilityNodeInfoCompat.setText(sb4);
                    }
                    accessibilityNodeInfoCompat.setShowingHintText(!z);
                }
                accessibilityNodeInfoCompat.setMaxTextLength((text == null || text.length() != counterMaxLength) ? -1 : -1);
                if (z5) {
                    if (!z4) {
                        error = counterOverflowDescription;
                    }
                    accessibilityNodeInfoCompat.setError(error);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes7.dex */
    public @interface EndIconMode {
    }

    /* loaded from: classes7.dex */
    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes7.dex */
    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i);
    }

    /* loaded from: classes7.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public CharSequence error;
        public boolean isEndIconChecked;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(619141446, "Lcom/google/android/material/textfield/TextInputLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(619141446, "Lcom/google/android/material/textfield/TextInputLayout$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                TextUtils.writeToParcel(this.error, parcel, i);
                parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1020361470, "Lcom/google/android/material/textfield/TextInputLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1020361470, "Lcom/google/android/material/textfield/TextInputLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addPlaceholderTextView() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (textView = this.placeholderTextView) == null) {
            return;
        }
        this.inputFrame.addView(textView);
        this.placeholderTextView.setVisibility(0);
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (materialShapeDrawable = this.boxBackground) == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke()) {
            this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
        }
        int calculateBoxBackgroundColor = calculateBoxBackgroundColor();
        this.boxBackgroundColor = calculateBoxBackgroundColor;
        this.boxBackground.setFillColor(ColorStateList.valueOf(calculateBoxBackgroundColor));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.boxUnderline == null) {
            return;
        }
        if (canDrawStroke()) {
            this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
        }
        invalidate();
    }

    private void applyCutoutPadding(@NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, rectF) == null) {
            float f = rectF.left;
            int i = this.boxLabelCutoutPaddingPx;
            rectF.left = f - i;
            rectF.top -= i;
            rectF.right += i;
            rectF.bottom += i;
        }
    }

    private void applyEndIconTint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
        }
    }

    private void applyIconTint(@NonNull CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{checkableImageButton, Boolean.valueOf(z), colorStateList, Boolean.valueOf(z2), mode}) == null) {
            Drawable drawable = checkableImageButton.getDrawable();
            if (drawable != null && (z || z2)) {
                drawable = DrawableCompat.wrap(drawable).mutate();
                if (z) {
                    DrawableCompat.setTintList(drawable, colorStateList);
                }
                if (z2) {
                    DrawableCompat.setTintMode(drawable, mode);
                }
            }
            if (checkableImageButton.getDrawable() != drawable) {
                checkableImageButton.setImageDrawable(drawable);
            }
        }
    }

    private void applyStartIconTint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
        }
    }

    private void assignBoxBackgroundByMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int i = this.boxBackgroundMode;
            if (i == 0) {
                this.boxBackground = null;
                this.boxUnderline = null;
            } else if (i == 1) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
                this.boxUnderline = new MaterialShapeDrawable();
            } else if (i == 2) {
                if (this.hintEnabled && !(this.boxBackground instanceof CutoutDrawable)) {
                    this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
                } else {
                    this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
                }
                this.boxUnderline = null;
            } else {
                throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
        }
    }

    private int calculateBoxBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            return this.boxBackgroundMode == 1 ? MaterialColors.layer(MaterialColors.getColor(this, (int) R.attr.obfuscated_res_0x7f04017e, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
        }
        return invokeV.intValue;
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, rect)) == null) {
            if (this.editText != null) {
                Rect rect2 = this.tmpBoundsRect;
                boolean z = ViewCompat.getLayoutDirection(this) == 1;
                rect2.bottom = rect.bottom;
                int i = this.boxBackgroundMode;
                if (i == 1) {
                    rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
                    rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                    rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
                    return rect2;
                } else if (i != 2) {
                    rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
                    rect2.top = getPaddingTop();
                    rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
                    return rect2;
                } else {
                    rect2.left = rect.left + this.editText.getPaddingLeft();
                    rect2.top = rect.top - calculateLabelMarginTop();
                    rect2.right = rect.right - this.editText.getPaddingRight();
                    return rect2;
                }
            }
            throw new IllegalStateException();
        }
        return (Rect) invokeL.objValue;
    }

    private int calculateExpandedLabelBottom(@NonNull Rect rect, @NonNull Rect rect2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{rect, rect2, Float.valueOf(f)})) == null) {
            if (isSingleLineFilledTextField()) {
                return (int) (rect2.top + f);
            }
            return rect.bottom - this.editText.getCompoundPaddingBottom();
        }
        return invokeCommon.intValue;
    }

    private int calculateExpandedLabelTop(@NonNull Rect rect, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65555, this, rect, f)) == null) {
            if (isSingleLineFilledTextField()) {
                return (int) (rect.centerY() - (f / 2.0f));
            }
            return rect.top + this.editText.getCompoundPaddingTop();
        }
        return invokeLF.intValue;
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, rect)) == null) {
            if (this.editText != null) {
                Rect rect2 = this.tmpBoundsRect;
                float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
                rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
                rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
                rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
                return rect2;
            }
            throw new IllegalStateException();
        }
        return (Rect) invokeL.objValue;
    }

    private int calculateLabelMarginTop() {
        InterceptResult invokeV;
        float collapsedTextHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (this.hintEnabled) {
                int i = this.boxBackgroundMode;
                if (i == 0 || i == 1) {
                    collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
                } else if (i != 2) {
                    return 0;
                } else {
                    collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
                }
                return (int) collapsedTextHeight;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private boolean canDrawOutlineStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? this.boxBackgroundMode == 2 && canDrawStroke() : invokeV.booleanValue;
    }

    private boolean canDrawStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0 : invokeV.booleanValue;
    }

    private void closeCutout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, this) == null) && cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.animator.cancel();
            }
            if (z && this.hintAnimationEnabled) {
                animateToExpansionFraction(1.0f);
            } else {
                this.collapsingTextHelper.setExpansionFraction(1.0f);
            }
            this.hintExpanded = false;
            if (cutoutEnabled()) {
                openCutout();
            }
            updatePlaceholderText();
            updatePrefixTextVisibility();
            updateSuffixTextVisibility();
        }
    }

    private boolean cutoutEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) ? this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable) : invokeV.booleanValue;
    }

    private void dispatchOnEditTextAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEditTextAttached(this);
            }
        }
    }

    private void dispatchOnEndIconChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, this, i) == null) {
            Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEndIconChanged(this, i);
            }
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65565, this, canvas) == null) || (materialShapeDrawable = this.boxUnderline) == null) {
            return;
        }
        Rect bounds = materialShapeDrawable.getBounds();
        bounds.top = bounds.bottom - this.boxStrokeWidthPx;
        this.boxUnderline.draw(canvas);
    }

    private void drawHint(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65566, this, canvas) == null) && this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65567, this, z) == null) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.animator.cancel();
            }
            if (z && this.hintAnimationEnabled) {
                animateToExpansionFraction(0.0f);
            } else {
                this.collapsingTextHelper.setExpansionFraction(0.0f);
            }
            if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
                closeCutout();
            }
            this.hintExpanded = true;
            hidePlaceholderText();
            updatePrefixTextVisibility();
            updateSuffixTextVisibility();
        }
    }

    private EndIconDelegate getEndIconDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
            return endIconDelegate != null ? endIconDelegate : this.endIconDelegates.get(0);
        }
        return (EndIconDelegate) invokeV.objValue;
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            if (this.errorIconView.getVisibility() == 0) {
                return this.errorIconView;
            }
            if (hasEndIcon() && isEndIconVisible()) {
                return this.endIconView;
            }
            return null;
        }
        return (CheckableImageButton) invokeV.objValue;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int compoundPaddingLeft = i + this.editText.getCompoundPaddingLeft();
            return (this.prefixText == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
        }
        return invokeCommon.intValue;
    }

    private int getLabelRightBoundAlignedWithSuffix(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65571, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int compoundPaddingRight = i - this.editText.getCompoundPaddingRight();
            return (this.prefixText == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
        }
        return invokeCommon.intValue;
    }

    private boolean hasEndIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) ? this.endIconMode != 0 : invokeV.booleanValue;
    }

    private void hidePlaceholderText() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65573, this) == null) && (textView = this.placeholderTextView) != null && this.placeholderEnabled) {
            textView.setText((CharSequence) null);
            this.placeholderTextView.setVisibility(4);
        }
    }

    private boolean isErrorIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) ? this.errorIconView.getVisibility() == 0 : invokeV.booleanValue;
    }

    private boolean isSingleLineFilledTextField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) ? this.boxBackgroundMode == 1 && (Build.VERSION.SDK_INT < 16 || this.editText.getMinLines() <= 1) : invokeV.booleanValue;
    }

    private void onApplyBoxBackgroundMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            assignBoxBackgroundByMode();
            setEditTextBoxBackground();
            updateTextInputBoxState();
            if (this.boxBackgroundMode != 0) {
                updateInputLayoutMargins();
            }
        }
    }

    private void openCutout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65577, this) == null) && cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    public static void recursiveSetEnabled(@NonNull ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65578, null, viewGroup, z) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setEnabled(z);
                if (childAt instanceof ViewGroup) {
                    recursiveSetEnabled((ViewGroup) childAt, z);
                }
            }
        }
    }

    private void removePlaceholderTextView() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65579, this) == null) || (textView = this.placeholderTextView) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    private void setEditText(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, this, editText) == null) {
            if (this.editText == null) {
                if (this.endIconMode != 3 && !(editText instanceof TextInputEditText)) {
                    Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
                }
                this.editText = editText;
                onApplyBoxBackgroundMode();
                setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
                this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.editText.addTextChangedListener(new TextWatcher(this) { // from class: com.google.android.material.textfield.TextInputLayout.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TextInputLayout this$0;

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

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(@NonNull Editable editable) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                            TextInputLayout textInputLayout = this.this$0;
                            textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
                            TextInputLayout textInputLayout2 = this.this$0;
                            if (textInputLayout2.counterEnabled) {
                                textInputLayout2.updateCounter(editable.length());
                            }
                            if (this.this$0.placeholderEnabled) {
                                this.this$0.updatePlaceholderText(editable.length());
                            }
                        }
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                        }
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                        }
                    }
                });
                if (this.defaultHintTextColor == null) {
                    this.defaultHintTextColor = this.editText.getHintTextColors();
                }
                if (this.hintEnabled) {
                    if (TextUtils.isEmpty(this.hint)) {
                        CharSequence hint = this.editText.getHint();
                        this.originalHint = hint;
                        setHint(hint);
                        this.editText.setHint((CharSequence) null);
                    }
                    this.isProvidingHint = true;
                }
                if (this.counterView != null) {
                    updateCounter(this.editText.getText().length());
                }
                updateEditTextBackground();
                this.indicatorViewController.adjustIndicatorPadding();
                this.startLayout.bringToFront();
                this.endLayout.bringToFront();
                this.endIconFrame.bringToFront();
                this.errorIconView.bringToFront();
                dispatchOnEditTextAttached();
                updatePrefixTextViewPadding();
                updateSuffixTextViewPadding();
                if (!isEnabled()) {
                    editText.setEnabled(false);
                }
                updateLabelState(false, true);
                return;
            }
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
    }

    private void setEditTextBoxBackground() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65581, this) == null) && shouldUseEditTextBackgroundForBoxBackground()) {
            ViewCompat.setBackground(this.editText, this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65582, this, z) == null) {
            this.errorIconView.setVisibility(z ? 0 : 8);
            this.endIconFrame.setVisibility(z ? 8 : 0);
            updateSuffixTextViewPadding();
            if (hasEndIcon()) {
                return;
            }
            updateDummyDrawables();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65583, this, charSequence) == null) || TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.setText(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    public static void setIconClickable(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, checkableImageButton, onLongClickListener) == null) {
            boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
            boolean z = false;
            boolean z2 = onLongClickListener != null;
            z = (hasOnClickListeners || z2) ? true : true;
            checkableImageButton.setFocusable(z);
            checkableImageButton.setClickable(hasOnClickListeners);
            checkableImageButton.setPressable(hasOnClickListeners);
            checkableImageButton.setLongClickable(z2);
            ViewCompat.setImportantForAccessibility(checkableImageButton, z ? 1 : 2);
        }
    }

    public static void setIconOnClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65585, null, checkableImageButton, onClickListener, onLongClickListener) == null) {
            checkableImageButton.setOnClickListener(onClickListener);
            setIconClickable(checkableImageButton, onLongClickListener);
        }
    }

    public static void setIconOnLongClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, checkableImageButton, onLongClickListener) == null) {
            checkableImageButton.setOnLongClickListener(onLongClickListener);
            setIconClickable(checkableImageButton, onLongClickListener);
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65587, this, z) == null) || this.placeholderEnabled == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.id.obfuscated_res_0x7f09214a);
            ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            addPlaceholderTextView();
        } else {
            removePlaceholderTextView();
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) ? (this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0 : invokeV.booleanValue;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) ? !(getStartIconDrawable() == null && this.prefixText == null) && this.startLayout.getMeasuredWidth() > 0 : invokeV.booleanValue;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, this)) == null) {
            EditText editText = this.editText;
            return (editText == null || this.boxBackground == null || editText.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void showPlaceholderText() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65591, this) == null) && (textView = this.placeholderTextView) != null && this.placeholderEnabled) {
            textView.setText(this.placeholderText);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
        }
    }

    private void tintEndIconOnError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65592, this, z) == null) {
            if (z && getEndIconDrawable() != null) {
                Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
                DrawableCompat.setTint(mutate, this.indicatorViewController.getErrorViewCurrentTextColor());
                this.endIconView.setImageDrawable(mutate);
                return;
            }
            applyEndIconTint();
        }
    }

    private void updateBoxUnderlineBounds(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65593, this, rect) == null) || (materialShapeDrawable = this.boxUnderline) == null) {
            return;
        }
        int i = rect.bottom;
        materialShapeDrawable.setBounds(rect.left, i - this.boxStrokeWidthFocusedPx, rect.right, i);
    }

    private void updateCounter() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65594, this) == null) || this.counterView == null) {
            return;
        }
        EditText editText = this.editText;
        updateCounter(editText == null ? 0 : editText.getText().length());
    }

    public static void updateCounterContentDescription(@NonNull Context context, @NonNull TextView textView, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65595, null, new Object[]{context, textView, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            textView.setContentDescription(context.getString(z ? R.string.obfuscated_res_0x7f0f03a6 : R.string.obfuscated_res_0x7f0f03a5, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    private void updateCounterTextAppearanceAndColor() {
        TextView textView;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65596, this) == null) || (textView = this.counterView) == null) {
            return;
        }
        setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
        if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
            this.counterView.setTextColor(colorStateList2);
        }
        if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
            return;
        }
        this.counterView.setTextColor(colorStateList);
    }

    private boolean updateDummyDrawables() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, this)) == null) {
            if (this.editText == null) {
                return false;
            }
            boolean z2 = true;
            if (shouldUpdateStartDummyDrawable()) {
                int measuredWidth = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
                if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                    ColorDrawable colorDrawable = new ColorDrawable();
                    this.startDummyDrawable = colorDrawable;
                    this.startDummyDrawableWidth = measuredWidth;
                    colorDrawable.setBounds(0, 0, measuredWidth, 1);
                }
                Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.editText);
                Drawable drawable = compoundDrawablesRelative[0];
                Drawable drawable2 = this.startDummyDrawable;
                if (drawable != drawable2) {
                    TextViewCompat.setCompoundDrawablesRelative(this.editText, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                    z = true;
                }
                z = false;
            } else {
                if (this.startDummyDrawable != null) {
                    Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
                    TextViewCompat.setCompoundDrawablesRelative(this.editText, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                    this.startDummyDrawable = null;
                    z = true;
                }
                z = false;
            }
            if (shouldUpdateEndDummyDrawable()) {
                int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
                CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable != null) {
                    measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
                }
                Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
                Drawable drawable3 = this.endDummyDrawable;
                if (drawable3 != null && this.endDummyDrawableWidth != measuredWidth2) {
                    this.endDummyDrawableWidth = measuredWidth2;
                    drawable3.setBounds(0, 0, measuredWidth2, 1);
                    TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.endDummyDrawable, compoundDrawablesRelative3[3]);
                } else {
                    if (this.endDummyDrawable == null) {
                        ColorDrawable colorDrawable2 = new ColorDrawable();
                        this.endDummyDrawable = colorDrawable2;
                        this.endDummyDrawableWidth = measuredWidth2;
                        colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                    }
                    Drawable drawable4 = compoundDrawablesRelative3[2];
                    Drawable drawable5 = this.endDummyDrawable;
                    if (drawable4 != drawable5) {
                        this.originalEditTextEndDrawable = compoundDrawablesRelative3[2];
                        TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                    } else {
                        z2 = z;
                    }
                }
            } else if (this.endDummyDrawable == null) {
                return z;
            } else {
                Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
                if (compoundDrawablesRelative4[2] == this.endDummyDrawable) {
                    TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.originalEditTextEndDrawable, compoundDrawablesRelative4[3]);
                } else {
                    z2 = z;
                }
                this.endDummyDrawable = null;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, this)) == null) {
            if (this.editText != null && this.editText.getMeasuredHeight() < (max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
                this.editText.setMinimumHeight(max);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void updateIconColorOnState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65599, this, checkableImageButton, colorStateList) == null) {
            Drawable drawable = checkableImageButton.getDrawable();
            if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private void updateInputLayoutMargins() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65600, this) == null) || this.boxBackgroundMode == 1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int calculateLabelMarginTop = calculateLabelMarginTop();
        if (calculateLabelMarginTop != layoutParams.topMargin) {
            layoutParams.topMargin = calculateLabelMarginTop;
            this.inputFrame.requestLayout();
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65602, this) == null) || this.placeholderTextView == null || (editText = this.editText) == null) {
            return;
        }
        this.placeholderTextView.setGravity(editText.getGravity());
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    private void updatePlaceholderText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
            EditText editText = this.editText;
            updatePlaceholderText(editText == null ? 0 : editText.getText().length());
        }
    }

    private void updatePrefixTextViewPadding() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65605, this) == null) || this.editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.prefixTextView, isStartIconVisible() ? 0 : ViewCompat.getPaddingStart(this.editText), this.editText.getCompoundPaddingTop(), 0, this.editText.getCompoundPaddingBottom());
    }

    private void updatePrefixTextVisibility() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            this.prefixTextView.setVisibility((this.prefixText == null || isHintExpanded()) ? 8 : 0);
            updateDummyDrawables();
        }
    }

    private void updateStrokeErrorColor(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int defaultColor = this.strokeErrorColor.getDefaultColor();
            int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
            int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
            if (z) {
                this.boxStrokeColor = colorForState2;
            } else if (z2) {
                this.boxStrokeColor = colorForState;
            } else {
                this.boxStrokeColor = defaultColor;
            }
        }
    }

    private void updateSuffixTextViewPadding() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65608, this) == null) || this.editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.suffixTextView, 0, this.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : ViewCompat.getPaddingEnd(this.editText), this.editText.getPaddingBottom());
    }

    private void updateSuffixTextVisibility() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65609, this) == null) {
            int visibility = this.suffixTextView.getVisibility();
            boolean z = (this.suffixText == null || isHintExpanded()) ? false : true;
            this.suffixTextView.setVisibility(z ? 0 : 8);
            if (visibility != this.suffixTextView.getVisibility()) {
                getEndIconDelegate().onSuffixVisibilityChanged(z);
            }
            updateDummyDrawables();
        }
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onEditTextAttachedListener) == null) {
            this.editTextAttachedListeners.add(onEditTextAttachedListener);
            if (this.editText != null) {
                onEditTextAttachedListener.onEditTextAttached(this);
            }
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onEndIconChangedListener) == null) {
            this.endIconChangedListeners.add(onEndIconChangedListener);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view2, int i, @NonNull ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, layoutParams) == null) {
            if (view2 instanceof EditText) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
                layoutParams2.gravity = (layoutParams2.gravity & OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR) | 16;
                this.inputFrame.addView(view2, layoutParams2);
                this.inputFrame.setLayoutParams(layoutParams);
                updateInputLayoutMargins();
                setEditText((EditText) view2);
                return;
            }
            super.addView(view2, i, layoutParams);
        }
    }

    @VisibleForTesting
    public void animateToExpansionFraction(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f) == null) || this.collapsingTextHelper.getExpansionFraction() == f) {
            return;
        }
        if (this.animator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.TextInputLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TextInputLayout this$0;

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
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.this$0.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                }
            });
        }
        this.animator.setFloatValues(this.collapsingTextHelper.getExpansionFraction(), f);
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.editTextAttachedListeners.clear();
        }
    }

    public void clearOnEndIconChangedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.endIconChangedListeners.clear();
        }
    }

    @VisibleForTesting
    public boolean cutoutIsOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, viewStructure, i) == null) {
            if (this.originalHint != null && (editText = this.editText) != null) {
                boolean z = this.isProvidingHint;
                this.isProvidingHint = false;
                CharSequence hint = editText.getHint();
                this.editText.setHint(this.originalHint);
                try {
                    super.dispatchProvideAutofillStructure(viewStructure, i);
                    return;
                } finally {
                    this.editText.setHint(hint);
                    this.isProvidingHint = z;
                }
            }
            super.dispatchProvideAutofillStructure(viewStructure, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sparseArray) == null) {
            this.restoringSavedState = true;
            super.dispatchRestoreInstanceState(sparseArray);
            this.restoringSavedState = false;
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.draw(canvas);
            drawHint(canvas);
            drawBoxUnderline(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.inDrawableStateChanged) {
            return;
        }
        boolean z = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        boolean state = collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) | false : false;
        if (this.editText != null) {
            updateLabelState((ViewCompat.isLaidOut(this) && isEnabled()) ? false : false);
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (state) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            EditText editText = this.editText;
            if (editText != null) {
                return editText.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
            }
            return super.getBaseline();
        }
        return invokeV.intValue;
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.boxBackgroundMode;
            if (i != 1 && i != 2) {
                throw new IllegalStateException();
            }
            return this.boxBackground;
        }
        return (MaterialShapeDrawable) invokeV.objValue;
    }

    public int getBoxBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.boxBackgroundColor : invokeV.intValue;
    }

    public int getBoxBackgroundMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.boxBackgroundMode : invokeV.intValue;
    }

    public float getBoxCornerRadiusBottomEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.boxBackground.getBottomLeftCornerResolvedSize() : invokeV.floatValue;
    }

    public float getBoxCornerRadiusBottomStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.boxBackground.getBottomRightCornerResolvedSize() : invokeV.floatValue;
    }

    public float getBoxCornerRadiusTopEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.boxBackground.getTopRightCornerResolvedSize() : invokeV.floatValue;
    }

    public float getBoxCornerRadiusTopStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.boxBackground.getTopLeftCornerResolvedSize() : invokeV.floatValue;
    }

    public int getBoxStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.focusedStrokeColor : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.strokeErrorColor : (ColorStateList) invokeV.objValue;
    }

    public int getBoxStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.boxStrokeWidthDefaultPx : invokeV.intValue;
    }

    public int getBoxStrokeWidthFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.boxStrokeWidthFocusedPx : invokeV.intValue;
    }

    public int getCounterMaxLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.counterMaxLength : invokeV.intValue;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
                return textView.getContentDescription();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.counterTextColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.counterTextColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.defaultHintTextColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public EditText getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.editText : (EditText) invokeV.objValue;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.endIconView.getContentDescription() : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.endIconView.getDrawable() : (Drawable) invokeV.objValue;
    }

    public int getEndIconMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.endIconMode : invokeV.intValue;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.endIconView : (CheckableImageButton) invokeV.objValue;
    }

    @Nullable
    public CharSequence getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.indicatorViewController.isErrorEnabled()) {
                return this.indicatorViewController.getErrorText();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.indicatorViewController.getErrorContentDescription() : (CharSequence) invokeV.objValue;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.indicatorViewController.getErrorViewCurrentTextColor() : invokeV.intValue;
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.errorIconView.getDrawable() : (Drawable) invokeV.objValue;
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.indicatorViewController.getErrorViewCurrentTextColor() : invokeV.intValue;
    }

    @Nullable
    public CharSequence getHelperText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.indicatorViewController.isHelperTextEnabled()) {
                return this.indicatorViewController.getHelperText();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.indicatorViewController.getHelperTextViewCurrentTextColor() : invokeV.intValue;
    }

    @Nullable
    public CharSequence getHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.hintEnabled) {
                return this.hint;
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.collapsingTextHelper.getCollapsedTextHeight() : invokeV.floatValue;
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.collapsingTextHelper.getCurrentCollapsedTextColor() : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.focusedTextColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.endIconView.getContentDescription() : (CharSequence) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.endIconView.getDrawable() : (Drawable) invokeV.objValue;
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.placeholderEnabled) {
                return this.placeholderText;
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.placeholderTextAppearance : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.placeholderTextColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public CharSequence getPrefixText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.prefixText : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.prefixTextView.getTextColors() : (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public TextView getPrefixTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.prefixTextView : (TextView) invokeV.objValue;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.startIconView.getContentDescription() : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.startIconView.getDrawable() : (Drawable) invokeV.objValue;
    }

    @Nullable
    public CharSequence getSuffixText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.suffixText : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.suffixTextView.getTextColors() : (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public TextView getSuffixTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.suffixTextView : (TextView) invokeV.objValue;
    }

    @Nullable
    public Typeface getTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.typeface : (Typeface) invokeV.objValue;
    }

    public boolean isCounterEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.counterEnabled : invokeV.booleanValue;
    }

    public boolean isEndIconCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.endIconView.isCheckable() : invokeV.booleanValue;
    }

    public boolean isEndIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isErrorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.indicatorViewController.isErrorEnabled() : invokeV.booleanValue;
    }

    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.indicatorViewController.helperTextIsDisplayed() : invokeV.booleanValue;
    }

    public boolean isHelperTextEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.indicatorViewController.isHelperTextEnabled() : invokeV.booleanValue;
    }

    public boolean isHintAnimationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.hintAnimationEnabled : invokeV.booleanValue;
    }

    public boolean isHintEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.hintEnabled : invokeV.booleanValue;
    }

    @VisibleForTesting
    public final boolean isHintExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.hintExpanded : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.endIconMode == 1 : invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.isProvidingHint : invokeV.booleanValue;
    }

    public boolean isStartIconCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.startIconView.isCheckable() : invokeV.booleanValue;
    }

    public boolean isStartIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.startIconView.getVisibility() == 0 : invokeV.booleanValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            EditText editText = this.editText;
            if (editText != null) {
                Rect rect = this.tmpRect;
                DescendantOffsetUtils.getDescendantRect(this, editText, rect);
                updateBoxUnderlineBounds(rect);
                if (this.hintEnabled) {
                    this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                    int gravity = this.editText.getGravity();
                    this.collapsingTextHelper.setCollapsedTextGravity((gravity & OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR) | 48);
                    this.collapsingTextHelper.setExpandedTextGravity(gravity);
                    this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                    this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                    this.collapsingTextHelper.recalculate();
                    if (!cutoutEnabled() || this.hintExpanded) {
                        return;
                    }
                    openCutout();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048648, this, i, i2) == null) {
            super.onMeasure(i, i2);
            boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
            boolean updateDummyDrawables = updateDummyDrawables();
            if (updateEditTextHeightBasedOnIcon || updateDummyDrawables) {
                this.editText.post(new Runnable(this) { // from class: com.google.android.material.textfield.TextInputLayout.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TextInputLayout this$0;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.editText.requestLayout();
                        }
                    }
                });
            }
            updatePlaceholderMeasurementsBasedOnEditText();
            updatePrefixTextViewPadding();
            updateSuffixTextViewPadding();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setError(savedState.error);
            if (savedState.isEndIconChecked) {
                this.endIconView.post(new Runnable(this) { // from class: com.google.android.material.textfield.TextInputLayout.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TextInputLayout this$0;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.endIconView.performClick();
                            this.this$0.endIconView.jumpDrawablesToCurrentState();
                        }
                    }
                });
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            if (this.indicatorViewController.errorShouldBeShown()) {
                savedState.error = getError();
            }
            savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048651, this, z) == null) && this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, onEditTextAttachedListener) == null) {
            this.editTextAttachedListeners.remove(onEditTextAttachedListener);
        }
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, onEndIconChangedListener) == null) {
            this.endIconChangedListeners.remove(onEndIconChangedListener);
        }
    }

    public void setBoxBackgroundColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048654, this, i) == null) || this.boxBackgroundColor == i) {
            return;
        }
        this.boxBackgroundColor = i;
        this.defaultFilledBackgroundColor = i;
        this.focusedFilledBackgroundColor = i;
        this.hoveredFilledBackgroundColor = i;
        applyBoxAttributes();
    }

    public void setBoxBackgroundColorResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i) == null) {
            setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
        }
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, colorStateList) == null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
            this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundMode(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048657, this, i) == null) || i == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
            if (materialShapeDrawable != null && materialShapeDrawable.getTopLeftCornerResolvedSize() == f && this.boxBackground.getTopRightCornerResolvedSize() == f2 && this.boxBackground.getBottomRightCornerResolvedSize() == f4 && this.boxBackground.getBottomLeftCornerResolvedSize() == f3) {
                return;
            }
            this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f).setTopRightCornerSize(f2).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f3).build();
            applyBoxAttributes();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i, @DimenRes int i2, @DimenRes int i3, @DimenRes int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048659, this, i, i2, i3, i4) == null) {
            setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
        }
    }

    public void setBoxStrokeColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048660, this, i) == null) || this.focusedStrokeColor == i) {
            return;
        }
        this.focusedStrokeColor = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, colorStateList) == null) {
            if (colorStateList.isStateful()) {
                this.defaultStrokeColor = colorStateList.getDefaultColor();
                this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
                this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
            } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
                this.focusedStrokeColor = colorStateList.getDefaultColor();
            }
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, colorStateList) == null) || this.strokeErrorColor == colorStateList) {
            return;
        }
        this.strokeErrorColor = colorStateList;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i) == null) {
            this.boxStrokeWidthDefaultPx = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidthFocused(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.boxStrokeWidthFocusedPx = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i) == null) {
            setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
        }
    }

    public void setBoxStrokeWidthResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i) == null) {
            setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCounterEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048667, this, z) == null) || this.counterEnabled == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.counterView = appCompatTextView;
            appCompatTextView.setId(R.id.obfuscated_res_0x7f092147);
            Typeface typeface = this.typeface;
            if (typeface != null) {
                this.counterView.setTypeface(typeface);
            }
            this.counterView.setMaxLines(1);
            this.indicatorViewController.addIndicator(this.counterView, 2);
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704da));
            updateCounterTextAppearanceAndColor();
            updateCounter();
        } else {
            this.indicatorViewController.removeIndicator(this.counterView, 2);
            this.counterView = null;
        }
        this.counterEnabled = z;
    }

    public void setCounterMaxLength(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048668, this, i) == null) || this.counterMaxLength == i) {
            return;
        }
        if (i > 0) {
            this.counterMaxLength = i;
        } else {
            this.counterMaxLength = -1;
        }
        if (this.counterEnabled) {
            updateCounter();
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048669, this, i) == null) || this.counterOverflowTextAppearance == i) {
            return;
        }
        this.counterOverflowTextAppearance = i;
        updateCounterTextAppearanceAndColor();
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, colorStateList) == null) || this.counterOverflowTextColor == colorStateList) {
            return;
        }
        this.counterOverflowTextColor = colorStateList;
        updateCounterTextAppearanceAndColor();
    }

    public void setCounterTextAppearance(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048671, this, i) == null) || this.counterTextAppearance == i) {
            return;
        }
        this.counterTextAppearance = i;
        updateCounterTextAppearanceAndColor();
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, colorStateList) == null) || this.counterTextColor == colorStateList) {
            return;
        }
        this.counterTextColor = colorStateList;
        updateCounterTextAppearanceAndColor();
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, colorStateList) == null) {
            this.defaultHintTextColor = colorStateList;
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            recursiveSetEnabled(this, z);
            super.setEnabled(z);
        }
    }

    public void setEndIconActivated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.endIconView.setActivated(z);
        }
    }

    public void setEndIconCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
            this.endIconView.setCheckable(z);
        }
    }

    public void setEndIconContentDescription(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i) == null) {
            setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        }
    }

    public void setEndIconMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i) == null) {
            int i2 = this.endIconMode;
            this.endIconMode = i;
            dispatchOnEndIconChanged(i2);
            setEndIconVisible(i != 0);
            if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
                getEndIconDelegate().initialize();
                applyEndIconTint();
                return;
            }
            throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
        }
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, onClickListener) == null) {
            setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
        }
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, onLongClickListener) == null) {
            this.endIconOnLongClickListener = onLongClickListener;
            setIconOnLongClickListener(this.endIconView, onLongClickListener);
        }
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048684, this, colorStateList) == null) || this.endIconTintList == colorStateList) {
            return;
        }
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048685, this, mode) == null) || this.endIconTintMode == mode) {
            return;
        }
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setEndIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048686, this, z) == null) || isEndIconVisible() == z) {
            return;
        }
        this.endIconView.setVisibility(z ? 0 : 8);
        updateSuffixTextViewPadding();
        updateDummyDrawables();
    }

    public void setError(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, charSequence) == null) {
            if (!this.indicatorViewController.isErrorEnabled()) {
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                setErrorEnabled(true);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                this.indicatorViewController.showError(charSequence);
            } else {
                this.indicatorViewController.hideError();
            }
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, charSequence) == null) {
            this.indicatorViewController.setErrorContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z) == null) {
            this.indicatorViewController.setErrorEnabled(z);
        }
    }

    public void setErrorIconDrawable(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i) == null) {
            setErrorIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        }
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, onClickListener) == null) {
            setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
        }
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, onLongClickListener) == null) {
            this.errorIconOnLongClickListener = onLongClickListener;
            setIconOnLongClickListener(this.errorIconView, onLongClickListener);
        }
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, colorStateList) == null) {
            this.errorIconTintList = colorStateList;
            Drawable drawable = this.errorIconView.getDrawable();
            if (drawable != null) {
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (this.errorIconView.getDrawable() != drawable) {
                this.errorIconView.setImageDrawable(drawable);
            }
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, mode) == null) {
            Drawable drawable = this.errorIconView.getDrawable();
            if (drawable != null) {
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintMode(drawable, mode);
            }
            if (this.errorIconView.getDrawable() != drawable) {
                this.errorIconView.setImageDrawable(drawable);
            }
        }
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.indicatorViewController.setErrorTextAppearance(i);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, colorStateList) == null) {
            this.indicatorViewController.setErrorViewTextColor(colorStateList);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, charSequence) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                if (isHelperTextEnabled()) {
                    setHelperTextEnabled(false);
                    return;
                }
                return;
            }
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, colorStateList) == null) {
            this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z) == null) {
            this.indicatorViewController.setHelperTextEnabled(z);
        }
    }

    public void setHelperTextTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i) == null) {
            this.indicatorViewController.setHelperTextAppearance(i);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, charSequence) == null) && this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z) == null) {
            this.hintAnimationEnabled = z;
        }
    }

    public void setHintEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048704, this, z) == null) || z == this.hintEnabled) {
            return;
        }
        this.hintEnabled = z;
        if (!z) {
            this.isProvidingHint = false;
            if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                this.editText.setHint(this.hint);
            }
            setHintInternal(null);
        } else {
            CharSequence hint = this.editText.getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.hint)) {
                    setHint(hint);
                }
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.editText != null) {
            updateInputLayoutMargins();
        }
    }

    public void setHintTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i) == null) {
            this.collapsingTextHelper.setCollapsedTextAppearance(i);
            this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
            if (this.editText != null) {
                updateLabelState(false);
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048706, this, colorStateList) == null) || this.focusedTextColor == colorStateList) {
            return;
        }
        if (this.defaultHintTextColor == null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i) == null) {
            setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i) == null) {
            setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z) == null) {
            if (z && this.endIconMode != 1) {
                setEndIconMode(1);
            } else if (z) {
            } else {
                setEndIconMode(0);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, colorStateList) == null) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, mode) == null) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, charSequence) == null) {
            if (this.placeholderEnabled && TextUtils.isEmpty(charSequence)) {
                setPlaceholderTextEnabled(false);
            } else {
                if (!this.placeholderEnabled) {
                    setPlaceholderTextEnabled(true);
                }
                this.placeholderText = charSequence;
            }
            updatePlaceholderText();
        }
    }

    public void setPlaceholderTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i) == null) {
            this.placeholderTextAppearance = i;
            TextView textView = this.placeholderTextView;
            if (textView != null) {
                TextViewCompat.setTextAppearance(textView, i);
            }
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048716, this, colorStateList) == null) || this.placeholderTextColor == colorStateList) {
            return;
        }
        this.placeholderTextColor = colorStateList;
        TextView textView = this.placeholderTextView;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, charSequence) == null) {
            this.prefixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
            this.prefixTextView.setText(charSequence);
            updatePrefixTextVisibility();
        }
    }

    public void setPrefixTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i) == null) {
            TextViewCompat.setTextAppearance(this.prefixTextView, i);
        }
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, colorStateList) == null) {
            this.prefixTextView.setTextColor(colorStateList);
        }
    }

    public void setStartIconCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z) == null) {
            this.startIconView.setCheckable(z);
        }
    }

    public void setStartIconContentDescription(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i) == null) {
            setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
        }
    }

    public void setStartIconDrawable(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048723, this, i) == null) {
            setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        }
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, onClickListener) == null) {
            setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
        }
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, onLongClickListener) == null) {
            this.startIconOnLongClickListener = onLongClickListener;
            setIconOnLongClickListener(this.startIconView, onLongClickListener);
        }
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, colorStateList) == null) || this.startIconTintList == colorStateList) {
            return;
        }
        this.startIconTintList = colorStateList;
        this.hasStartIconTintList = true;
        applyStartIconTint();
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048728, this, mode) == null) || this.startIconTintMode == mode) {
            return;
        }
        this.startIconTintMode = mode;
        this.hasStartIconTintMode = true;
        applyStartIconTint();
    }

    public void setStartIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048729, this, z) == null) || isStartIconVisible() == z) {
            return;
        }
        this.startIconView.setVisibility(z ? 0 : 8);
        updatePrefixTextViewPadding();
        updateDummyDrawables();
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, charSequence) == null) {
            this.suffixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
            this.suffixTextView.setText(charSequence);
            updateSuffixTextVisibility();
        }
    }

    public void setSuffixTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i) == null) {
            TextViewCompat.setTextAppearance(this.suffixTextView, i);
        }
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, colorStateList) == null) {
            this.suffixTextView.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r5.getTextColors().getDefaultColor() == (-65281)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView textView, @StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048733, this, textView, i) == null) {
            boolean z = true;
            try {
                TextViewCompat.setTextAppearance(textView, i);
                if (Build.VERSION.SDK_INT >= 23) {
                }
                z = false;
            } catch (Exception unused) {
            }
            if (z) {
                TextViewCompat.setTextAppearance(textView, R.style.obfuscated_res_0x7f1001bf);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f06071b));
            }
        }
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048734, this, accessibilityDelegate) == null) || (editText = this.editText) == null) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048735, this, typeface) == null) || typeface == this.typeface) {
            return;
        }
        this.typeface = typeface;
        this.collapsingTextHelper.setTypefaces(typeface);
        this.indicatorViewController.setTypefaces(typeface);
        TextView textView = this.counterView;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void updateEditTextBackground() {
        EditText editText;
        Drawable background;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || (editText = this.editText) == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.errorShouldBeShown()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.editText.refreshDrawableState();
        }
    }

    public void updateLabelState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z) == null) {
            updateLabelState(z, false);
        }
    }

    public void updateTextInputBoxState() {
        TextView textView;
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048739, this) == null) || this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        if (!isEnabled()) {
            this.boxStrokeColor = this.disabledColor;
        } else if (this.indicatorViewController.errorShouldBeShown()) {
            if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z2, z3);
            } else {
                this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
            }
        } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
            if (z2) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z3) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
        } else if (this.strokeErrorColor != null) {
            updateStrokeErrorColor(z2, z3);
        } else {
            this.boxStrokeColor = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.indicatorViewController.isErrorEnabled() && this.indicatorViewController.errorShouldBeShown()) {
            z = true;
        }
        setErrorIconVisible(z);
        updateIconColorOnState(this.errorIconView, this.errorIconTintList);
        updateIconColorOnState(this.startIconView, this.startIconTintList);
        updateIconColorOnState(this.endIconView, this.endIconTintList);
        if (getEndIconDelegate().shouldTintIconOnError()) {
            tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
        }
        if (z2 && isEnabled()) {
            this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
            this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z3 && !z2) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else if (z2) {
                this.boxBackgroundColor = this.focusedFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0406ed);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean isEnabled = isEnabled();
            EditText editText = this.editText;
            boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
            EditText editText2 = this.editText;
            boolean z4 = editText2 != null && editText2.hasFocus();
            boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
            ColorStateList colorStateList2 = this.defaultHintTextColor;
            if (colorStateList2 != null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
                this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
            }
            if (!isEnabled) {
                ColorStateList colorStateList3 = this.defaultHintTextColor;
                int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
                this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
                this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(colorForState));
            } else if (errorShouldBeShown) {
                this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
            } else if (this.counterOverflowed && (textView = this.counterView) != null) {
                this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
            } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            if (!z3 && (!isEnabled() || (!z4 && !errorShouldBeShown))) {
                if (z2 || !this.hintExpanded) {
                    expandHint(z);
                }
            } else if (z2 || this.hintExpanded) {
                collapseHint(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholderText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65604, this, i) == null) {
            if (i == 0 && !this.hintExpanded) {
                showPlaceholderText();
            } else {
                hidePlaceholderText();
            }
        }
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048678, this, charSequence) == null) || getEndIconContentDescription() == charSequence) {
            return;
        }
        this.endIconView.setContentDescription(charSequence);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, drawable) == null) {
            this.endIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, drawable) == null) {
            this.errorIconView.setImageDrawable(drawable);
            setErrorIconVisible(drawable != null && this.indicatorViewController.isErrorEnabled());
        }
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048722, this, charSequence) == null) || getStartIconContentDescription() == charSequence) {
            return;
        }
        this.startIconView.setContentDescription(charSequence);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, drawable) == null) {
            this.startIconView.setImageDrawable(drawable);
            if (drawable != null) {
                setStartIconVisible(true);
                applyStartIconTint();
                return;
            }
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet<>();
        this.endIconMode = 0;
        this.endIconDelegates = new SparseArray<>();
        this.endIconChangedListeners = new LinkedHashSet<>();
        this.collapsingTextHelper = new CollapsingTextHelper(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.startLayout = linearLayout;
        linearLayout.setOrientation(0);
        this.startLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        this.inputFrame.addView(this.startLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.endLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        this.endLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.inputFrame.addView(this.endLayout);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setCollapsedTextGravity(BadgeDrawable.TOP_START);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.TextInputLayout, i, DEF_STYLE_RES, 18, 16, 31, 35, 39);
        this.hintEnabled = obtainTintedStyledAttributes.getBoolean(38, true);
        setHint(obtainTintedStyledAttributes.getText(2));
        this.hintAnimationEnabled = obtainTintedStyledAttributes.getBoolean(37, true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704d6);
        this.boxCollapsedPaddingTopPx = obtainTintedStyledAttributes.getDimensionPixelOffset(5, 0);
        this.boxStrokeWidthDefaultPx = obtainTintedStyledAttributes.getDimensionPixelSize(12, context2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704d7));
        this.boxStrokeWidthFocusedPx = obtainTintedStyledAttributes.getDimensionPixelSize(13, context2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704d8));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = obtainTintedStyledAttributes.getDimension(9, -1.0f);
        float dimension2 = obtainTintedStyledAttributes.getDimension(8, -1.0f);
        float dimension3 = obtainTintedStyledAttributes.getDimension(6, -1.0f);
        float dimension4 = obtainTintedStyledAttributes.getDimension(7, -1.0f);
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (dimension >= 0.0f) {
            builder.setTopLeftCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.setTopRightCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.setBottomRightCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.setBottomLeftCornerSize(dimension4);
        }
        this.shapeAppearanceModel = builder.build();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 3);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList colorStateList2 = AppCompatResources.getColorStateList(context2, R.color.obfuscated_res_0x7f0607fb);
                this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (obtainTintedStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList3 = obtainTintedStyledAttributes.getColorStateList(1);
            this.focusedTextColor = colorStateList3;
            this.defaultHintTextColor = colorStateList3;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 10);
        this.focusedStrokeColor = obtainTintedStyledAttributes.getColor(10, 0);
        this.defaultStrokeColor = ContextCompat.getColor(context2, R.color.obfuscated_res_0x7f06080d);
        this.disabledColor = ContextCompat.getColor(context2, R.color.obfuscated_res_0x7f06080e);
        this.hoveredStrokeColor = ContextCompat.getColor(context2, R.color.obfuscated_res_0x7f060811);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        if (obtainTintedStyledAttributes.hasValue(11)) {
            setBoxStrokeErrorColor(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 11));
        }
        if (obtainTintedStyledAttributes.getResourceId(39, -1) != -1) {
            setHintTextAppearance(obtainTintedStyledAttributes.getResourceId(39, 0));
        }
        int resourceId = obtainTintedStyledAttributes.getResourceId(31, 0);
        CharSequence text = obtainTintedStyledAttributes.getText(26);
        boolean z = obtainTintedStyledAttributes.getBoolean(27, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0221, (ViewGroup) this.endLayout, false);
        this.errorIconView = checkableImageButton;
        checkableImageButton.setVisibility(8);
        if (obtainTintedStyledAttributes.hasValue(28)) {
            setErrorIconDrawable(obtainTintedStyledAttributes.getDrawable(28));
        }
        if (obtainTintedStyledAttributes.hasValue(29)) {
            setErrorIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 29));
        }
        if (obtainTintedStyledAttributes.hasValue(30)) {
            setErrorIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(30, -1), null));
        }
        this.errorIconView.setContentDescription(getResources().getText(R.string.obfuscated_res_0x7f0f05b7));
        ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
        int resourceId2 = obtainTintedStyledAttributes.getResourceId(35, 0);
        boolean z2 = obtainTintedStyledAttributes.getBoolean(34, false);
        CharSequence text2 = obtainTintedStyledAttributes.getText(33);
        int resourceId3 = obtainTintedStyledAttributes.getResourceId(47, 0);
        CharSequence text3 = obtainTintedStyledAttributes.getText(46);
        int resourceId4 = obtainTintedStyledAttributes.getResourceId(50, 0);
        CharSequence text4 = obtainTintedStyledAttributes.getText(49);
        int resourceId5 = obtainTintedStyledAttributes.getResourceId(60, 0);
        CharSequence text5 = obtainTintedStyledAttributes.getText(59);
        boolean z3 = obtainTintedStyledAttributes.getBoolean(14, false);
        setCounterMaxLength(obtainTintedStyledAttributes.getInt(15, -1));
        this.counterTextAppearance = obtainTintedStyledAttributes.getResourceId(18, 0);
        this.counterOverflowTextAppearance = obtainTintedStyledAttributes.getResourceId(16, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0222, (ViewGroup) this.startLayout, false);
        this.startIconView = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (obtainTintedStyledAttributes.hasValue(56)) {
            setStartIconDrawable(obtainTintedStyledAttributes.getDrawable(56));
            if (obtainTintedStyledAttributes.hasValue(55)) {
                setStartIconContentDescription(obtainTintedStyledAttributes.getText(55));
            }
            setStartIconCheckable(obtainTintedStyledAttributes.getBoolean(54, true));
        }
        if (obtainTintedStyledAttributes.hasValue(57)) {
            setStartIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 57));
        }
        if (obtainTintedStyledAttributes.hasValue(58)) {
            setStartIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(58, -1), null));
        }
        setBoxBackgroundMode(obtainTintedStyledAttributes.getInt(4, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0221, (ViewGroup) this.endIconFrame, false);
        this.endIconView = checkableImageButton3;
        this.endIconFrame.addView(checkableImageButton3);
        this.endIconView.setVisibility(8);
        this.endIconDelegates.append(-1, new CustomEndIconDelegate(this));
        this.endIconDelegates.append(0, new NoEndIconDelegate(this));
        this.endIconDelegates.append(1, new PasswordToggleEndIconDelegate(this));
        this.endIconDelegates.append(2, new ClearTextEndIconDelegate(this));
        this.endIconDelegates.append(3, new DropdownMenuEndIconDelegate(this));
        if (obtainTintedStyledAttributes.hasValue(23)) {
            setEndIconMode(obtainTintedStyledAttributes.getInt(23, 0));
            if (obtainTintedStyledAttributes.hasValue(22)) {
                setEndIconDrawable(obtainTintedStyledAttributes.getDrawable(22));
            }
            if (obtainTintedStyledAttributes.hasValue(21)) {
                setEndIconContentDescription(obtainTintedStyledAttributes.getText(21));
            }
            setEndIconCheckable(obtainTintedStyledAttributes.getBoolean(20, true));
        } else if (obtainTintedStyledAttributes.hasValue(43)) {
            setEndIconMode(obtainTintedStyledAttributes.getBoolean(43, false) ? 1 : 0);
            setEndIconDrawable(obtainTintedStyledAttributes.getDrawable(42));
            setEndIconContentDescription(obtainTintedStyledAttributes.getText(41));
            if (obtainTintedStyledAttributes.hasValue(44)) {
                setEndIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 44));
            }
            if (obtainTintedStyledAttributes.hasValue(45)) {
                setEndIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(45, -1), null));
            }
        }
        if (!obtainTintedStyledAttributes.hasValue(43)) {
            if (obtainTintedStyledAttributes.hasValue(24)) {
                setEndIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 24));
            }
            if (obtainTintedStyledAttributes.hasValue(25)) {
                setEndIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(25, -1), null));
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.prefixTextView = appCompatTextView;
        appCompatTextView.setId(R.id.obfuscated_res_0x7f09214b);
        this.prefixTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.prefixTextView, 1);
        this.startLayout.addView(this.startIconView);
        this.startLayout.addView(this.prefixTextView);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
        this.suffixTextView = appCompatTextView2;
        appCompatTextView2.setId(R.id.obfuscated_res_0x7f09214c);
        this.suffixTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(this.suffixTextView, 1);
        this.endLayout.addView(this.suffixTextView);
        this.endLayout.addView(this.errorIconView);
        this.endLayout.addView(this.endIconFrame);
        setHelperTextEnabled(z2);
        setHelperText(text2);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z);
        setErrorTextAppearance(resourceId);
        setErrorContentDescription(text);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setPrefixText(text4);
        setPrefixTextAppearance(resourceId4);
        setSuffixText(text5);
        setSuffixTextAppearance(resourceId5);
        if (obtainTintedStyledAttributes.hasValue(32)) {
            setErrorTextColor(obtainTintedStyledAttributes.getColorStateList(32));
        }
        if (obtainTintedStyledAttributes.hasValue(36)) {
            setHelperTextColor(obtainTintedStyledAttributes.getColorStateList(36));
        }
        if (obtainTintedStyledAttributes.hasValue(40)) {
            setHintTextColor(obtainTintedStyledAttributes.getColorStateList(40));
        }
        if (obtainTintedStyledAttributes.hasValue(19)) {
            setCounterTextColor(obtainTintedStyledAttributes.getColorStateList(19));
        }
        if (obtainTintedStyledAttributes.hasValue(17)) {
            setCounterOverflowTextColor(obtainTintedStyledAttributes.getColorStateList(17));
        }
        if (obtainTintedStyledAttributes.hasValue(48)) {
            setPlaceholderTextColor(obtainTintedStyledAttributes.getColorStateList(48));
        }
        if (obtainTintedStyledAttributes.hasValue(51)) {
            setPrefixTextColor(obtainTintedStyledAttributes.getColorStateList(51));
        }
        if (obtainTintedStyledAttributes.hasValue(61)) {
            setSuffixTextColor(obtainTintedStyledAttributes.getColorStateList(61));
        }
        setCounterEnabled(z3);
        setEnabled(obtainTintedStyledAttributes.getBoolean(0, true));
        obtainTintedStyledAttributes.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, charSequence) == null) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, drawable) == null) {
            this.endIconView.setImageDrawable(drawable);
        }
    }

    public void updateCounter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048736, this, i) == null) {
            boolean z = this.counterOverflowed;
            int i2 = this.counterMaxLength;
            if (i2 == -1) {
                this.counterView.setText(String.valueOf(i));
                this.counterView.setContentDescription(null);
                this.counterOverflowed = false;
            } else {
                this.counterOverflowed = i > i2;
                updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
                if (z != this.counterOverflowed) {
                    updateCounterTextAppearanceAndColor();
                }
                this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.obfuscated_res_0x7f0f03a7, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength))));
            }
            if (this.editText == null || z == this.counterOverflowed) {
                return;
            }
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }
}
