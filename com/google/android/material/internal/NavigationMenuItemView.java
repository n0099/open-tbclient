package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] CHECKED_STATE_SET;
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityDelegateCompat accessibilityDelegate;
    public FrameLayout actionArea;
    public boolean checkable;
    public Drawable emptyDrawable;
    public boolean hasIconTintList;
    public int iconSize;
    public ColorStateList iconTintList;
    public MenuItemImpl itemData;
    public boolean needsEmptyIcon;
    public final CheckedTextView textView;

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Character.valueOf(c)}) == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1930637782, "Lcom/google/android/material/internal/NavigationMenuItemView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1930637782, "Lcom/google/android/material/internal/NavigationMenuItemView;");
                return;
            }
        }
        CHECKED_STATE_SET = new int[]{16842912};
    }

    private boolean shouldExpandActionArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.itemData;
        }
        return (MenuItemImpl) invokeV.objValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            this.textView.setCompoundDrawables(null, null, null, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationMenuItemView(@NonNull Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.accessibilityDelegate = new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NavigationMenuItemView this$0;

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

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, accessibilityNodeInfoCompat) == null) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setCheckable(this.this$0.checkable);
                }
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0222, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020c));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.obfuscated_res_0x7f0907c1);
        this.textView = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.textView, this.accessibilityDelegate);
    }

    private void adjustAppearance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (shouldExpandActionArea()) {
                this.textView.setVisibility(8);
                FrameLayout frameLayout = this.actionArea;
                if (frameLayout != null) {
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                    this.actionArea.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.textView.setVisibility(0);
            FrameLayout frameLayout2 = this.actionArea;
            if (frameLayout2 != null) {
                LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
                this.actionArea.setLayoutParams(layoutParams2);
            }
        }
    }

    @Nullable
    private StateListDrawable createDefaultBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.obfuscated_res_0x7f04016f, typedValue, true)) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
                return stateListDrawable;
            }
            return null;
        }
        return (StateListDrawable) invokeV.objValue;
    }

    private void setActionView(@Nullable View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, view2) == null) && view2 != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0907c0)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
            MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
                ViewGroup.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            refreshDrawableState();
            if (this.checkable != z) {
                this.checkable = z;
                this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            refreshDrawableState();
            this.textView.setChecked(z);
        }
    }

    public void setHorizontalPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            setPadding(i, 0, i, 0);
        }
    }

    public void setIconPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.textView.setCompoundDrawablePadding(i);
        }
    }

    public void setIconSize(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.iconSize = i;
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, colorStateList) == null) {
            this.iconTintList = colorStateList;
            if (colorStateList != null) {
                z = true;
            } else {
                z = false;
            }
            this.hasIconTintList = z;
            MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null) {
                setIcon(menuItemImpl.getIcon());
            }
        }
    }

    public void setMaxLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.textView.setMaxLines(i);
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.needsEmptyIcon = z;
        }
    }

    public void setTextAppearance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            TextViewCompat.setTextAppearance(this.textView, i);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, colorStateList) == null) {
            this.textView.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, charSequence) == null) {
            this.textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItemImpl, i) == null) {
            this.itemData = menuItemImpl;
            if (menuItemImpl.getItemId() > 0) {
                setId(menuItemImpl.getItemId());
            }
            if (menuItemImpl.isVisible()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            setVisibility(i2);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, createDefaultBackground());
            }
            setCheckable(menuItemImpl.isCheckable());
            setChecked(menuItemImpl.isChecked());
            setEnabled(menuItemImpl.isEnabled());
            setTitle(menuItemImpl.getTitle());
            setIcon(menuItemImpl.getIcon());
            setActionView(menuItemImpl.getActionView());
            setContentDescription(menuItemImpl.getContentDescription());
            TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
            adjustAppearance();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            if (drawable != null) {
                if (this.hasIconTintList) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        drawable = constantState.newDrawable();
                    }
                    drawable = DrawableCompat.wrap(drawable).mutate();
                    DrawableCompat.setTintList(drawable, this.iconTintList);
                }
                int i = this.iconSize;
                drawable.setBounds(0, 0, i, i);
            } else if (this.needsEmptyIcon) {
                if (this.emptyDrawable == null) {
                    Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080e75, getContext().getTheme());
                    this.emptyDrawable = drawable2;
                    if (drawable2 != null) {
                        int i2 = this.iconSize;
                        drawable2.setBounds(0, 0, i2, i2);
                    }
                }
                drawable = this.emptyDrawable;
            }
            TextViewCompat.setCompoundDrawablesRelative(this.textView, drawable, null, null, null);
        }
    }
}
