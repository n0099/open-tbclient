package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] CHECKABLE_STATE_SET;
    public static final int[] CHECKED_STATE_SET;
    public static final int DEF_STYLE_RES;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final String LOG_TAG = "MaterialButton";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean broadcasting;
    public boolean checked;
    @Nullable
    public Drawable icon;
    public int iconGravity;
    @Px
    public int iconLeft;
    @Px
    public int iconPadding;
    @Px
    public int iconSize;
    @Nullable
    public ColorStateList iconTint;
    @Nullable
    public PorterDuff.Mode iconTintMode;
    @NonNull
    public final MaterialButtonHelper materialButtonHelper;
    @NonNull
    public final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    @Nullable
    public OnPressedChangeListener onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface IconGravity {
    }

    /* loaded from: classes3.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean checked;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1533276233, "Lcom/google/android/material/button/MaterialButton$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1533276233, "Lcom/google/android/material/button/MaterialButton$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
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
                @NonNull
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        private void readFromParcel(@NonNull Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, parcel) == null) {
                this.checked = parcel.readInt() == 1;
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.checked ? 1 : 0);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1378577201, "Lcom/google/android/material/button/MaterialButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1378577201, "Lcom/google/android/material/button/MaterialButton;");
                return;
            }
        }
        CHECKABLE_STATE_SET = new int[]{16842911};
        CHECKED_STATE_SET = new int[]{16842912};
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Button;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialButton(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    private String getA11yClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return (String) invokeV.objValue;
    }

    private boolean isLayoutRTL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? ViewCompat.getLayoutDirection(this) == 1 : invokeV.booleanValue;
    }

    private boolean isUsingOriginalBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            return (materialButtonHelper == null || materialButtonHelper.isBackgroundOverwritten()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void resetIconDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            if (z) {
                TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
            } else {
                TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.icon, null);
            }
        }
    }

    private void updateIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            Drawable drawable = this.icon;
            boolean z2 = false;
            if (drawable != null) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.icon = mutate;
                DrawableCompat.setTintList(mutate, this.iconTint);
                PorterDuff.Mode mode = this.iconTintMode;
                if (mode != null) {
                    DrawableCompat.setTintMode(this.icon, mode);
                }
                int i2 = this.iconSize;
                if (i2 == 0) {
                    i2 = this.icon.getIntrinsicWidth();
                }
                int i3 = this.iconSize;
                if (i3 == 0) {
                    i3 = this.icon.getIntrinsicHeight();
                }
                Drawable drawable2 = this.icon;
                int i4 = this.iconLeft;
                drawable2.setBounds(i4, 0, i2 + i4, i3);
            }
            int i5 = this.iconGravity;
            boolean z3 = i5 == 1 || i5 == 2;
            if (z) {
                resetIconDrawable(z3);
                return;
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
            Drawable drawable3 = compoundDrawablesRelative[0];
            Drawable drawable4 = compoundDrawablesRelative[2];
            if ((z3 && drawable3 != this.icon) || (!z3 && drawable4 != this.icon)) {
                z2 = true;
            }
            if (z2) {
                resetIconDrawable(z3);
            }
        }
    }

    private void updateIconPosition() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.icon == null || getLayout() == null) {
            return;
        }
        int i2 = this.iconGravity;
        if (i2 != 1 && i2 != 3) {
            TextPaint paint = getPaint();
            String charSequence = getText().toString();
            if (getTransformationMethod() != null) {
                charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
            }
            int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
            int i3 = this.iconSize;
            if (i3 == 0) {
                i3 = this.icon.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - min) - ViewCompat.getPaddingEnd(this)) - i3) - this.iconPadding) - ViewCompat.getPaddingStart(this)) / 2;
            if (isLayoutRTL() != (this.iconGravity == 4)) {
                measuredWidth = -measuredWidth;
            }
            if (this.iconLeft != measuredWidth) {
                this.iconLeft = measuredWidth;
                updateIcon(false);
                return;
            }
            return;
        }
        this.iconLeft = 0;
        updateIcon(false);
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onCheckedChangeListener) == null) {
            this.onCheckedChangeListeners.add(onCheckedChangeListener);
        }
    }

    public void clearOnCheckedChangeListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.onCheckedChangeListeners.clear();
        }
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getSupportBackgroundTintList() : (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getSupportBackgroundTintMode() : (PorterDuff.Mode) invokeV.objValue;
    }

    @Px
    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getCornerRadius();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.icon : (Drawable) invokeV.objValue;
    }

    public int getIconGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.iconGravity : invokeV.intValue;
    }

    @Px
    public int getIconPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.iconPadding : invokeV.intValue;
    }

    @Px
    public int getIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.iconSize : invokeV.intValue;
    }

    public ColorStateList getIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.iconTint : (ColorStateList) invokeV.objValue;
    }

    public PorterDuff.Mode getIconTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.iconTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getRippleColor();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getShapeAppearanceModel();
            }
            throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        }
        return (ShapeAppearanceModel) invokeV.objValue;
    }

    public ColorStateList getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getStrokeColor();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Px
    public int getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getStrokeWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getSupportBackgroundTintList();
            }
            return super.getSupportBackgroundTintList();
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (isUsingOriginalBackground()) {
                return this.materialButtonHelper.getSupportBackgroundTintMode();
            }
            return super.getSupportBackgroundTintMode();
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            return materialButtonHelper != null && materialButtonHelper.isCheckable();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.checked : invokeV.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            if (isUsingOriginalBackground()) {
                MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
            if (isCheckable()) {
                Button.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
            }
            if (isChecked()) {
                Button.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(getA11yClassName());
            accessibilityEvent.setChecked(isChecked());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(getA11yClassName());
            accessibilityNodeInfo.setCheckable(isCheckable());
            accessibilityNodeInfo.setChecked(isChecked());
            accessibilityNodeInfo.setClickable(isClickable());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        MaterialButtonHelper materialButtonHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (Build.VERSION.SDK_INT != 21 || (materialButtonHelper = this.materialButtonHelper) == null) {
                return;
            }
            materialButtonHelper.updateMaskBounds(i5 - i3, i4 - i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            updateIconPosition();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setChecked(savedState.checked);
        }
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.checked = this.checked;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048603, this, charSequence, i2, i3, i4) == null) {
            super.onTextChanged(charSequence, i2, i3, i4);
            updateIconPosition();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            toggle();
            return super.performClick();
        }
        return invokeV.booleanValue;
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onCheckedChangeListener) == null) {
            this.onCheckedChangeListeners.remove(onCheckedChangeListener);
        }
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, drawable) == null) {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            if (isUsingOriginalBackground()) {
                this.materialButtonHelper.setBackgroundColor(i2);
            } else {
                super.setBackgroundColor(i2);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) {
            if (isUsingOriginalBackground()) {
                if (drawable != getBackground()) {
                    this.materialButtonHelper.setBackgroundOverwritten();
                    super.setBackgroundDrawable(drawable);
                    return;
                }
                getBackground().setState(drawable.getState());
                return;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, colorStateList) == null) {
            setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, mode) == null) {
            setSupportBackgroundTintMode(mode);
        }
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && isCheckable() && isEnabled() && this.checked != z) {
            this.checked = z;
            refreshDrawableState();
            if (this.broadcasting) {
                return;
            }
            this.broadcasting = true;
            Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged(this, this.checked);
            }
            this.broadcasting = false;
        }
    }

    public void setCornerRadius(@Px int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i2) == null) && isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(i2);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048615, this, i2) == null) && isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f2) == null) {
            super.setElevation(f2);
            if (isUsingOriginalBackground()) {
                this.materialButtonHelper.getMaterialShapeDrawable().setElevation(f2);
            }
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, drawable) == null) || this.icon == drawable) {
            return;
        }
        this.icon = drawable;
        updateIcon(true);
    }

    public void setIconGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || this.iconGravity == i2) {
            return;
        }
        this.iconGravity = i2;
        updateIconPosition();
    }

    public void setIconPadding(@Px int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i2) == null) || this.iconPadding == i2) {
            return;
        }
        this.iconPadding = i2;
        setCompoundDrawablePadding(i2);
    }

    public void setIconResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        }
    }

    public void setIconSize(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            if (i2 >= 0) {
                if (this.iconSize != i2) {
                    this.iconSize = i2;
                    updateIcon(true);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, colorStateList) == null) || this.iconTint == colorStateList) {
            return;
        }
        this.iconTint = colorStateList;
        updateIcon(false);
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, mode) == null) || this.iconTintMode == mode) {
            return;
        }
        this.iconTintMode = mode;
        updateIcon(false);
    }

    public void setIconTintResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setInternalBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener onPressedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onPressedChangeListener) == null) {
            this.onPressedChangeListenerInternal = onPressedChangeListener;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
            if (onPressedChangeListener != null) {
                onPressedChangeListener.onPressedChanged(this, z);
            }
            super.setPressed(z);
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, colorStateList) == null) && isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i2) == null) && isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, shapeAppearanceModel) == null) {
            if (isUsingOriginalBackground()) {
                this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
                return;
            }
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(z);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, colorStateList) == null) && isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048633, this, i2) == null) && isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048634, this, i2) == null) && isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(i2);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048635, this, i2) == null) && isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, colorStateList) == null) {
            if (isUsingOriginalBackground()) {
                this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
            } else {
                super.setSupportBackgroundTintList(colorStateList);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, mode) == null) {
            if (isUsingOriginalBackground()) {
                this.materialButtonHelper.setSupportBackgroundTintMode(mode);
            } else {
                super.setSupportBackgroundTintMode(mode);
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            setChecked(!this.checked);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, DEF_STYLE_RES), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialButton, i2, DEF_STYLE_RES, new int[0]);
        this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), obtainStyledAttributes, R.styleable.MaterialButton_icon);
        this.iconGravity = obtainStyledAttributes.getInteger(R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(context2, attributeSet, i2, DEF_STYLE_RES).build());
        this.materialButtonHelper = materialButtonHelper;
        materialButtonHelper.loadFromAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
    }
}
