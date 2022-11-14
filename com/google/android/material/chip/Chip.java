package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes7.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    public static final int[] CHECKABLE_STATE_SET;
    public static final int CHIP_BODY_VIRTUAL_ID = 0;
    public static final int CLOSE_ICON_VIRTUAL_ID = 1;
    public static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    public static final int DEF_STYLE_RES = 2131755869;
    public static final Rect EMPTY_BOUNDS;
    public static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    public static final int MIN_TOUCH_TARGET_DP = 48;
    public static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    public static final int[] SELECTED_STATE;
    public static final String TAG = "Chip";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ChipDrawable chipDrawable;
    public boolean closeIconFocused;
    public boolean closeIconHovered;
    public boolean closeIconPressed;
    public boolean deferredCheckedValue;
    public boolean ensureMinTouchTargetSize;
    public final TextAppearanceFontCallback fontCallback;
    @Nullable
    public InsetDrawable insetBackgroundDrawable;
    public int lastLayoutDirection;
    @Dimension(unit = 1)
    public int minTouchTargetSize;
    @Nullable
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    @Nullable
    public View.OnClickListener onCloseIconClickListener;
    public final Rect rect;
    public final RectF rectF;
    @Nullable
    public RippleDrawable ripple;
    @NonNull
    public final ChipTouchHelper touchHelper;

    /* loaded from: classes7.dex */
    public class ChipTouchHelper extends ExploreByTouchHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Chip this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChipTouchHelper(Chip chip, Chip chip2) {
            super(chip2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chip, chip2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chip;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.this$0.hasCloseIcon() && this.this$0.getCloseIconTouchBounds().contains(f, f2)) {
                    return 1;
                }
                return 0;
            }
            return invokeCommon.intValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NonNull List<Integer> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                list.add(0);
                if (this.this$0.hasCloseIcon() && this.this$0.isCloseIconVisible() && this.this$0.onCloseIconClickListener != null) {
                    list.add(1);
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, bundle)) == null) {
                if (i2 == 16) {
                    if (i == 0) {
                        return this.this$0.performClick();
                    }
                    if (i == 1) {
                        return this.this$0.performCloseIconClick();
                    }
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, accessibilityNodeInfoCompat) == null) {
                accessibilityNodeInfoCompat.setCheckable(this.this$0.isCheckable());
                accessibilityNodeInfoCompat.setClickable(this.this$0.isClickable());
                if (!this.this$0.isCheckable() && !this.this$0.isClickable()) {
                    accessibilityNodeInfoCompat.setClassName("android.view.View");
                } else {
                    if (this.this$0.isCheckable()) {
                        str = Chip.COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
                    } else {
                        str = Chip.BUTTON_ACCESSIBILITY_CLASS_NAME;
                    }
                    accessibilityNodeInfoCompat.setClassName(str);
                }
                CharSequence text = this.this$0.getText();
                if (Build.VERSION.SDK_INT >= 23) {
                    accessibilityNodeInfoCompat.setText(text);
                } else {
                    accessibilityNodeInfoCompat.setContentDescription(text);
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, accessibilityNodeInfoCompat) == null) {
                String str = "";
                if (i == 1) {
                    CharSequence closeIconContentDescription = this.this$0.getCloseIconContentDescription();
                    if (closeIconContentDescription != null) {
                        accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
                    } else {
                        CharSequence text = this.this$0.getText();
                        Context context = this.this$0.getContext();
                        Object[] objArr = new Object[1];
                        if (!TextUtils.isEmpty(text)) {
                            str = text;
                        }
                        objArr[0] = str;
                        accessibilityNodeInfoCompat.setContentDescription(context.getString(R.string.obfuscated_res_0x7f0f0b37, objArr).trim());
                    }
                    accessibilityNodeInfoCompat.setBoundsInParent(this.this$0.getCloseIconTouchBoundsInt());
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                    accessibilityNodeInfoCompat.setEnabled(this.this$0.isEnabled());
                    return;
                }
                accessibilityNodeInfoCompat.setContentDescription("");
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.EMPTY_BOUNDS);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && i == 1) {
                this.this$0.closeIconFocused = z;
                this.this$0.refreshDrawableState();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-959712296, "Lcom/google/android/material/chip/Chip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-959712296, "Lcom/google/android/material/chip/Chip;");
                return;
            }
        }
        EMPTY_BOUNDS = new Rect();
        SELECTED_STATE = new int[]{16842913};
        CHECKABLE_STATE_SET = new int[]{16842911};
    }

    private void updateFrameworkRippleBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
            this.chipDrawable.setUseCompatRipple(false);
            ViewCompat.setBackground(this, this.ripple);
            updatePaddingInternal();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Chip(Context context) {
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

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10) {
                    setCloseIconHovered(false);
                }
            } else {
                setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
            }
            return super.onHoverEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f04014e);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
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
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new TextAppearanceFontCallback(this) { // from class: com.google.android.material.chip.Chip.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Chip this$0;

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(@NonNull Typeface typeface, boolean z) {
                CharSequence text;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface, z) == null) {
                    Chip chip = this.this$0;
                    if (chip.chipDrawable.shouldDrawText()) {
                        text = this.this$0.chipDrawable.getText();
                    } else {
                        text = this.this$0.getText();
                    }
                    chip.setText(text);
                    this.this$0.requestLayout();
                    this.this$0.invalidate();
                }
            }
        };
        Context context2 = getContext();
        validateAttributes(attributeSet);
        ChipDrawable createFromAttributes = ChipDrawable.createFromAttributes(context2, attributeSet, i, DEF_STYLE_RES);
        initMinTouchTarget(context2, attributeSet, i);
        setChipDrawable(createFromAttributes);
        createFromAttributes.setElevation(ViewCompat.getElevation(this));
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.Chip, i, DEF_STYLE_RES, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(MaterialResources.getColorStateList(context2, obtainStyledAttributes, 1));
        }
        boolean hasValue = obtainStyledAttributes.hasValue(36);
        obtainStyledAttributes.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        updateAccessibilityDelegate();
        if (!hasValue) {
            initOutlineProvider();
        }
        setChecked(this.deferredCheckedValue);
        setText(createFromAttributes.getText());
        setEllipsize(createFromAttributes.getEllipsize());
        updateTextPaintDrawState();
        if (!this.chipDrawable.shouldDrawText()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize()) {
            setMinHeight(this.minTouchTargetSize);
        }
        this.lastLayoutDirection = ViewCompat.getLayoutDirection(this);
    }

    private void applyChipDrawable(@NonNull ChipDrawable chipDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, chipDrawable) == null) {
            chipDrawable.setDelegate(this);
        }
    }

    private void setCloseIconHovered(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65559, this, z) == null) && this.closeIconHovered != z) {
            this.closeIconHovered = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65560, this, z) == null) && this.closeIconPressed != z) {
            this.closeIconPressed = z;
            refreshDrawableState();
        }
    }

    private void unapplyChipDrawable(@Nullable ChipDrawable chipDrawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, this, chipDrawable) == null) && chipDrawable != null) {
            chipDrawable.setDelegate(null);
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (!handleAccessibilityExit(motionEvent) && !this.touchHelper.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            if (this.touchHelper.dispatchKeyEvent(keyEvent) && this.touchHelper.getKeyboardFocusedVirtualViewId() != Integer.MIN_VALUE) {
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, rect) == null) {
            if (this.touchHelper.getKeyboardFocusedVirtualViewId() != 1 && this.touchHelper.getAccessibilityFocusedVirtualViewId() != 1) {
                super.getFocusedRect(rect);
            } else {
                rect.set(getCloseIconTouchBoundsInt());
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
            if (isChecked()) {
                CheckBox.mergeDrawableStates(onCreateDrawableState, SELECTED_STATE);
            }
            if (isCheckable()) {
                CheckBox.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            super.onRtlPropertiesChanged(i);
            if (this.lastLayoutDirection != i) {
                this.lastLayoutDirection = i;
                updatePaddingInternal();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, drawable) == null) {
            if (drawable != getBackgroundDrawable() && drawable != this.ripple) {
                Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
            } else {
                super.setBackground(drawable);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, drawable) == null) {
            if (drawable != getBackgroundDrawable() && drawable != this.ripple) {
                Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
            } else {
                super.setBackgroundDrawable(drawable);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, colorStateList) == null) {
            Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, mode) == null) {
            Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
        }
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048634, this, z) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckable(z);
        }
    }

    public void setCheckableResource(@BoolRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048635, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckableResource(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable == null) {
                this.deferredCheckedValue = z;
            } else if (chipDrawable.isCheckable()) {
                boolean isChecked = isChecked();
                super.setChecked(z);
                if (isChecked != z && (onCheckedChangeListener = this.onCheckedChangeListenerInternal) != null) {
                    onCheckedChangeListener.onCheckedChanged(this, z);
                }
            }
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, drawable) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            setCheckedIconVisible(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            setCheckedIconVisible(i);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048640, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckedIconResource(i);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048641, this, colorStateList) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckedIconTint(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048642, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckedIconTintResource(i);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048643, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckedIconVisible(i);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048645, this, colorStateList) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipBackgroundColor(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048646, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipBackgroundColorResource(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048647, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipCornerRadius(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048648, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipCornerRadiusResource(i);
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048649, this, chipDrawable) == null) && (chipDrawable2 = this.chipDrawable) != chipDrawable) {
            unapplyChipDrawable(chipDrawable2);
            this.chipDrawable = chipDrawable;
            chipDrawable.setShouldDrawText(false);
            applyChipDrawable(this.chipDrawable);
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
    }

    public void setChipEndPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048650, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipEndPadding(f);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048651, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipEndPaddingResource(i);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048652, this, drawable) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            setChipIconVisible(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i) == null) {
            setChipIconVisible(i);
        }
    }

    public void setChipIconResource(@DrawableRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048655, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconResource(i);
        }
    }

    public void setChipIconSize(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048656, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconSize(f);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048657, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconSizeResource(i);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048658, this, colorStateList) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048659, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconTintResource(i);
        }
    }

    public void setChipIconVisible(@BoolRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048660, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconVisible(i);
        }
    }

    public void setChipMinHeight(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048662, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipMinHeight(f);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048663, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipMinHeightResource(i);
        }
    }

    public void setChipStartPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048664, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipStartPadding(f);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048665, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipStartPaddingResource(i);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, colorStateList) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048667, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipStrokeColorResource(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048668, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipStrokeWidth(f);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048669, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipStrokeWidthResource(i);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, charSequence) == null) {
            setText(charSequence);
        }
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i) == null) {
            setText(getResources().getString(i));
        }
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, drawable) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setCloseIcon(drawable);
            }
            updateAccessibilityDelegate();
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048673, this, charSequence) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconContentDescription(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            setCloseIconVisible(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i) == null) {
            setCloseIconVisible(i);
        }
    }

    public void setCloseIconEndPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048676, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconEndPadding(f);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048677, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconEndPaddingResource(i);
        }
    }

    public void setCloseIconResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setCloseIconResource(i);
            }
            updateAccessibilityDelegate();
        }
    }

    public void setCloseIconSize(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048679, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconSize(f);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048680, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconSizeResource(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048681, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconStartPadding(f);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048682, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconStartPaddingResource(i);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, colorStateList) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048684, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCloseIconTintResource(i);
        }
    }

    public void setCloseIconVisible(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            setCloseIconVisible(getResources().getBoolean(i));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048693, this, f) == null) {
            super.setElevation(f);
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setElevation(f);
            }
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048694, this, truncateAt) != null) || this.chipDrawable == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setEllipsize(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            this.ensureMinTouchTargetSize = z;
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            if (i != 8388627) {
                Log.w(TAG, "Chip text must be vertically center and start aligned");
            } else {
                super.setGravity(i);
            }
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048697, this, motionSpec) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setHideMotionSpec(motionSpec);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048698, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setHideMotionSpecResource(i);
        }
    }

    public void setIconEndPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048699, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setIconEndPadding(f);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048700, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setIconEndPaddingResource(i);
        }
    }

    public void setIconStartPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048701, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setIconStartPadding(f);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048702, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setIconStartPaddingResource(i);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048703, this, i) == null) && this.chipDrawable != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i) == null) {
            if (i <= 1) {
                super.setLines(i);
                return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i) == null) {
            if (i <= 1) {
                super.setMaxLines(i);
                return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i) == null) {
            super.setMaxWidth(i);
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setMaxWidth(i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i) == null) {
            if (i <= 1) {
                super.setMinLines(i);
                return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, onCheckedChangeListener) == null) {
            this.onCheckedChangeListenerInternal = onCheckedChangeListener;
        }
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, onClickListener) == null) {
            this.onCloseIconClickListener = onClickListener;
            updateAccessibilityDelegate();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, colorStateList) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setRippleColor(colorStateList);
            }
            if (!this.chipDrawable.getUseCompatRipple()) {
                updateFrameworkRippleBackground();
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048711, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setRippleColorResource(i);
            if (!this.chipDrawable.getUseCompatRipple()) {
                updateFrameworkRippleBackground();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, shapeAppearanceModel) == null) {
            this.chipDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048713, this, motionSpec) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setShowMotionSpec(motionSpec);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048714, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setShowMotionSpecResource(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z) == null) {
            if (z) {
                super.setSingleLine(z);
                return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048717, this, i) == null) {
            super.setTextAppearance(i);
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setTextAppearanceResource(i);
            }
            updateTextPaintDrawState();
        }
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i) == null) {
            setTextAppearance(getContext(), i);
        }
    }

    public void setTextEndPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048721, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setTextEndPadding(f);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048722, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setTextEndPaddingResource(i);
        }
    }

    public void setTextStartPadding(float f) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048723, this, f) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setTextStartPadding(f);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048724, this, i) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setTextStartPaddingResource(i);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048716, this, charSequence, bufferType) != null) || this.chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.chipDrawable.shouldDrawText()) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setText(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048718, this, context, i) == null) {
            super.setTextAppearance(context, i);
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setTextAppearanceResource(i);
            }
            updateTextPaintDrawState();
        }
    }

    private void ensureChipDrawableHasCallback() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && getBackgroundDrawable() == this.insetBackgroundDrawable && this.chipDrawable.getCallback() == null) {
            this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            this.rectF.setEmpty();
            if (hasCloseIcon()) {
                this.chipDrawable.getCloseIconTouchBounds(this.rectF);
            }
            return this.rectF;
        }
        return (RectF) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            RectF closeIconTouchBounds = getCloseIconTouchBounds();
            this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
            return this.rect;
        }
        return (Rect) invokeV.objValue;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getTextAppearance();
            }
            return null;
        }
        return (TextAppearance) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasCloseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.getCloseIcon() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void initOutlineProvider() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.google.android.material.chip.Chip.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Chip this$0;

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

                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view2, @NonNull Outline outline) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, outline) == null) {
                        if (this.this$0.chipDrawable != null) {
                            this.this$0.chipDrawable.getOutline(outline);
                        } else {
                            outline.setAlpha(0.0f);
                        }
                    }
                }
            });
        }
    }

    private void removeBackgroundInset() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            updateBackgroundDrawable();
        }
    }

    private void updateAccessibilityDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (hasCloseIcon() && isCloseIconVisible() && this.onCloseIconClickListener != null) {
                ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
            } else {
                ViewCompat.setAccessibilityDelegate(this, null);
            }
        }
    }

    private void updateBackgroundDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkRippleBackground();
                return;
            }
            this.chipDrawable.setUseCompatRipple(true);
            ViewCompat.setBackground(this, getBackgroundDrawable());
            updatePaddingInternal();
            ensureChipDrawableHasCallback();
        }
    }

    private void updateTextPaintDrawState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            TextPaint paint = getPaint();
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                paint.drawableState = chipDrawable.getState();
            }
            TextAppearance textAppearance = getTextAppearance();
            if (textAppearance != null) {
                textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.drawableStateChanged();
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.isCloseIconStateful()) {
                z = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
            } else {
                z = false;
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            InsetDrawable insetDrawable = this.insetBackgroundDrawable;
            if (insetDrawable == null) {
                return this.chipDrawable;
            }
            return insetDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCheckedIcon();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCheckedIconTint();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipBackgroundColor();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getChipCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable == null) {
                return 0.0f;
            }
            return Math.max(0.0f, chipDrawable.getChipCornerRadius());
        }
        return invokeV.floatValue;
    }

    public Drawable getChipDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.chipDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public float getChipEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipEndPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public Drawable getChipIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipIcon();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public float getChipIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipIconSize();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipIconTint();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getChipMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipMinHeight();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getChipStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipStartPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipStrokeColor();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getChipStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getChipStrokeWidth();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Deprecated
    public CharSequence getChipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getText();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Drawable getCloseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCloseIcon();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCloseIconContentDescription();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public float getCloseIconEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCloseIconEndPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getCloseIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCloseIconSize();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getCloseIconStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCloseIconStartPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getCloseIconTint();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getEllipsize();
            }
            return null;
        }
        return (TextUtils.TruncateAt) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getHideMotionSpec();
            }
            return null;
        }
        return (MotionSpec) invokeV.objValue;
    }

    public float getIconEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getIconEndPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getIconStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getIconStartPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getRippleColor();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.chipDrawable.getShapeAppearanceModel();
        }
        return (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getShowMotionSpec();
            }
            return null;
        }
        return (MotionSpec) invokeV.objValue;
    }

    public float getTextEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getTextEndPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getTextStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                return chipDrawable.getTextStartPadding();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.isCheckable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return isCheckedIconVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isCheckedIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.isCheckedIconVisible()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return isChipIconVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isChipIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.isChipIconVisible()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return isCloseIconVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isCloseIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null && chipDrawable.isCloseIconVisible()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onAttachedToWindow();
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
        }
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
            requestLayout();
            if (Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }
    }

    @CallSuper
    public boolean performCloseIconClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            boolean z = false;
            playSoundEffect(0);
            View.OnClickListener onClickListener = this.onCloseIconClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this);
                z = true;
            }
            this.touchHelper.sendEventForVirtualView(1, 1);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.ensureMinTouchTargetSize;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    private int[] createCloseIconDrawableState() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            int i2 = 0;
            if (isEnabled()) {
                i = 1;
            } else {
                i = 0;
            }
            if (this.closeIconFocused) {
                i++;
            }
            if (this.closeIconHovered) {
                i++;
            }
            if (this.closeIconPressed) {
                i++;
            }
            if (isChecked()) {
                i++;
            }
            int[] iArr = new int[i];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            }
            if (this.closeIconFocused) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.closeIconHovered) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.closeIconPressed) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    private void updatePaddingInternal() {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && !TextUtils.isEmpty(getText()) && (chipDrawable = this.chipDrawable) != null) {
            int chipEndPadding = (int) (chipDrawable.getChipEndPadding() + this.chipDrawable.getTextEndPadding() + this.chipDrawable.calculateCloseIconWidth());
            int chipStartPadding = (int) (this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.calculateChipIconWidth());
            if (this.insetBackgroundDrawable != null) {
                Rect rect = new Rect();
                this.insetBackgroundDrawable.getPadding(rect);
                chipStartPadding += rect.left;
                chipEndPadding += rect.right;
            }
            ViewCompat.setPaddingRelative(this, chipStartPadding, getPaddingTop(), chipEndPadding, getPaddingBottom());
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean handleAccessibilityExit(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 10) {
                try {
                    Field declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                    declaredField.setAccessible(true);
                    if (((Integer) declaredField.get(this.touchHelper)).intValue() != Integer.MIN_VALUE) {
                        Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(this.touchHelper, Integer.MIN_VALUE);
                        return true;
                    }
                } catch (IllegalAccessException e) {
                    Log.e(TAG, "Unable to send Accessibility Exit event", e);
                } catch (NoSuchFieldException e2) {
                    Log.e(TAG, "Unable to send Accessibility Exit event", e2);
                } catch (NoSuchMethodException e3) {
                    Log.e(TAG, "Unable to send Accessibility Exit event", e3);
                } catch (InvocationTargetException e4) {
                    Log.e(TAG, "Unable to send Accessibility Exit event", e4);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (!isCheckable() && !isClickable()) {
                accessibilityNodeInfo.setClassName("android.view.View");
            } else {
                if (isCheckable()) {
                    str = COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
                } else {
                    str = BUTTON_ACCESSIBILITY_CLASS_NAME;
                }
                accessibilityNodeInfo.setClassName(str);
            }
            accessibilityNodeInfo.setCheckable(isCheckable());
            accessibilityNodeInfo.setClickable(isClickable());
            if (getParent() instanceof ChipGroup) {
                ChipGroup chipGroup = (ChipGroup) getParent();
                AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
                if (chipGroup.isSingleLine()) {
                    i = chipGroup.getIndexOfChip(this);
                } else {
                    i = -1;
                }
                wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.getRowIndex(this), 1, i, 1, false, isChecked()));
            }
        }
    }

    private void initMinTouchTarget(Context context, @Nullable AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.Chip, i, DEF_STYLE_RES, new int[0]);
            this.ensureMinTouchTargetSize = obtainStyledAttributes.getBoolean(31, false);
            this.minTouchTargetSize = (int) Math.ceil(obtainStyledAttributes.getDimension(19, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
            obtainStyledAttributes.recycle();
        }
    }

    private void insetChipBackgroundDrawable(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65557, this, i, i2, i3, i4) == null) {
            this.insetBackgroundDrawable = new InsetDrawable((Drawable) this.chipDrawable, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048687, this, drawable, drawable2, drawable3, drawable4) == null) {
            if (drawable == null) {
                if (drawable3 == null) {
                    super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048688, this, drawable, drawable2, drawable3, drawable4) == null) {
            if (drawable == null) {
                if (drawable3 == null) {
                    super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048689, this, i, i2, i3, i4) == null) {
            if (i == 0) {
                if (i3 == 0) {
                    super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
                    return;
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048691, this, i, i2, i3, i4) == null) {
            if (i == 0) {
                if (i3 == 0) {
                    super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
                    return;
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
    }

    private void validateAttributes(@Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65567, this, attributeSet) != null) || attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", NotificationCompat.WearableExtender.KEY_BACKGROUND) != null) {
            Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", NotificationCompat.WearableExtender.KEY_GRAVITY, 8388627) != 8388627) {
                                Log.w(TAG, "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    public boolean ensureAccessibleTouchTarget(@Dimension int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.minTouchTargetSize = i;
            int i3 = 0;
            if (!shouldEnsureMinTouchTargetSize()) {
                if (this.insetBackgroundDrawable != null) {
                    removeBackgroundInset();
                } else {
                    updateBackgroundDrawable();
                }
                return false;
            }
            int max = Math.max(0, i - this.chipDrawable.getIntrinsicHeight());
            int max2 = Math.max(0, i - this.chipDrawable.getIntrinsicWidth());
            if (max2 <= 0 && max <= 0) {
                if (this.insetBackgroundDrawable != null) {
                    removeBackgroundInset();
                } else {
                    updateBackgroundDrawable();
                }
                return false;
            }
            if (max2 > 0) {
                i2 = max2 / 2;
            } else {
                i2 = 0;
            }
            if (max > 0) {
                i3 = max / 2;
            }
            if (this.insetBackgroundDrawable != null) {
                Rect rect = new Rect();
                this.insetBackgroundDrawable.getPadding(rect);
                if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                    updateBackgroundDrawable();
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (getMinHeight() != i) {
                    setMinHeight(i);
                }
                if (getMinWidth() != i) {
                    setMinWidth(i);
                }
            } else {
                setMinHeight(i);
                setMinWidth(i);
            }
            insetChipBackgroundDrawable(i2, i3, i2, i3);
            updateBackgroundDrawable();
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
            super.onFocusChanged(z, i, rect);
            this.touchHelper.onFocusChanged(z, i, rect);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048624, this, motionEvent, i)) == null) {
            if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
                return PointerIcon.getSystemIcon(getContext(), 1002);
            }
            return null;
        }
        return (PointerIcon) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0 != 3) goto L18;
     */
    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (this.closeIconPressed) {
                            if (!contains) {
                                setCloseIconPressed(false);
                            }
                            z = true;
                        }
                    }
                    z = false;
                } else if (this.closeIconPressed) {
                    performCloseIconClick();
                    z = true;
                    setCloseIconPressed(false);
                }
                z = false;
                setCloseIconPressed(false);
            } else {
                if (contains) {
                    setCloseIconPressed(true);
                    z = true;
                }
                z = false;
            }
            if (!z && !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048644, this, z) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setCheckedIconVisible(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048661, this, z) == null) && (chipDrawable = this.chipDrawable) != null) {
            chipDrawable.setChipIconVisible(z);
        }
    }

    public void setCloseIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setCloseIconVisible(z);
            }
            updateAccessibilityDelegate();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, textAppearance) == null) {
            ChipDrawable chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                chipDrawable.setTextAppearance(textAppearance);
            }
            updateTextPaintDrawState();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048690, this, drawable, drawable2, drawable3, drawable4) == null) {
            if (drawable == null) {
                if (drawable3 == null) {
                    super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048692, this, drawable, drawable2, drawable3, drawable4) == null) {
            if (drawable == null) {
                if (drawable3 == null) {
                    super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
    }
}
