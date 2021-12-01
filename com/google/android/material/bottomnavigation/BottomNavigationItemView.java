package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] CHECKED_STATE_SET;
    public static final int INVALID_ITEM_POSITION = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BadgeDrawable badgeDrawable;
    public final int defaultMargin;
    public ImageView icon;
    @Nullable
    public ColorStateList iconTint;
    public boolean isShifting;
    @Nullable
    public MenuItemImpl itemData;
    public int itemPosition;
    public int labelVisibilityMode;
    public final TextView largeLabel;
    @Nullable
    public Drawable originalIconDrawable;
    public float scaleDownFactor;
    public float scaleUpFactor;
    public float shiftAmount;
    public final TextView smallLabel;
    @Nullable
    public Drawable wrappedIconDrawable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1246177632, "Lcom/google/android/material/bottomnavigation/BottomNavigationItemView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1246177632, "Lcom/google/android/material/bottomnavigation/BottomNavigationItemView;");
                return;
            }
        }
        CHECKED_STATE_SET = new int[]{16842912};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomNavigationItemView(@NonNull Context context) {
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

    private void calculateTextScaleFactors(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.shiftAmount = f2 - f3;
            this.scaleUpFactor = (f3 * 1.0f) / f2;
            this.scaleDownFactor = (f2 * 1.0f) / f3;
        }
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, view)) == null) {
            ImageView imageView = this.icon;
            if (view == imageView && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) imageView.getParent();
            }
            return null;
        }
        return (FrameLayout) invokeL.objValue;
    }

    private boolean hasBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.badgeDrawable != null : invokeV.booleanValue;
    }

    private void setViewLayoutParams(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, this, view, i2, i3) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i2;
            layoutParams.gravity = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    private void setViewValues(@NonNull View view, float f2, float f3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)}) == null) {
            view.setScaleX(f2);
            view.setScaleY(f3);
            view.setVisibility(i2);
        }
    }

    private void tryAttachBadgeToAnchor(@Nullable View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, view) == null) && hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, view) == null) && hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
            this.badgeDrawable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, view) == null) && hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    @Nullable
    public BadgeDrawable getBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.badgeDrawable : (BadgeDrawable) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.itemData : (MenuItemImpl) invokeV.objValue;
    }

    public int getItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.itemPosition : invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        CharSequence title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, menuItemImpl, i2) == null) {
            this.itemData = menuItemImpl;
            setCheckable(menuItemImpl.isCheckable());
            setChecked(menuItemImpl.isChecked());
            setEnabled(menuItemImpl.isEnabled());
            setIcon(menuItemImpl.getIcon());
            setTitle(menuItemImpl.getTitle());
            setId(menuItemImpl.getItemId());
            if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
                setContentDescription(menuItemImpl.getContentDescription());
            }
            if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
                title = menuItemImpl.getTooltipText();
            } else {
                title = menuItemImpl.getTitle();
            }
            TooltipCompat.setTooltipText(this, title);
            setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
            MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
                FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence title = this.itemData.getTitle();
                if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                    title = this.itemData.getContentDescription();
                }
                accessibilityNodeInfo.setContentDescription(((Object) title) + StringUtil.ARRAY_ELEMENT_SEPARATOR + ((Object) this.badgeDrawable.getContentDescription()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void removeBadge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            tryRemoveBadgeFromAnchor(this.icon);
        }
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, badgeDrawable) == null) {
            this.badgeDrawable = badgeDrawable;
            ImageView imageView = this.icon;
            if (imageView != null) {
                tryAttachBadgeToAnchor(imageView);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            refreshDrawableState();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            TextView textView = this.largeLabel;
            textView.setPivotX(textView.getWidth() / 2);
            TextView textView2 = this.largeLabel;
            textView2.setPivotY(textView2.getBaseline());
            TextView textView3 = this.smallLabel;
            textView3.setPivotX(textView3.getWidth() / 2);
            TextView textView4 = this.smallLabel;
            textView4.setPivotY(textView4.getBaseline());
            int i2 = this.labelVisibilityMode;
            if (i2 != -1) {
                if (i2 == 0) {
                    if (z) {
                        setViewLayoutParams(this.icon, this.defaultMargin, 49);
                        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                    } else {
                        setViewLayoutParams(this.icon, this.defaultMargin, 17);
                        setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
                    }
                    this.smallLabel.setVisibility(4);
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        setViewLayoutParams(this.icon, this.defaultMargin, 17);
                        this.largeLabel.setVisibility(8);
                        this.smallLabel.setVisibility(8);
                    }
                } else if (z) {
                    setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                    setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                    TextView textView5 = this.smallLabel;
                    float f2 = this.scaleUpFactor;
                    setViewValues(textView5, f2, f2, 4);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    TextView textView6 = this.largeLabel;
                    float f3 = this.scaleDownFactor;
                    setViewValues(textView6, f3, f3, 4);
                    setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else if (this.isShifting) {
                if (z) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
                }
                this.smallLabel.setVisibility(4);
            } else if (z) {
                setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView7 = this.smallLabel;
                float f4 = this.scaleUpFactor;
                setViewValues(textView7, f4, f4, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                TextView textView8 = this.largeLabel;
                float f5 = this.scaleDownFactor;
                setViewValues(textView8, f5, f5, 4);
                setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
            refreshDrawableState();
            setSelected(z);
        }
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            this.smallLabel.setEnabled(z);
            this.largeLabel.setEnabled(z);
            this.icon.setEnabled(z);
            if (z) {
                ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
            } else {
                ViewCompat.setPointerIcon(this, null);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) || drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.icon.setLayoutParams(layoutParams);
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, colorStateList) == null) {
            this.iconTint = colorStateList;
            if (this.itemData == null || (drawable = this.wrappedIconDrawable) == null) {
                return;
            }
            DrawableCompat.setTintList(drawable, colorStateList);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
        }
    }

    public void setItemPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.itemPosition = i2;
        }
    }

    public void setLabelVisibilityMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || this.labelVisibilityMode == i2) {
            return;
        }
        this.labelVisibilityMode = i2;
        if (this.itemData != null) {
            setChecked(this.itemData.isChecked());
        }
    }

    public void setShifting(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.isShifting == z) {
            return;
        }
        this.isShifting = z;
        if (this.itemData != null) {
            setChecked(this.itemData.isChecked());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Character.valueOf(c2)}) == null) {
        }
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            TextViewCompat.setTextAppearance(this.largeLabel, i2);
            calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        }
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            TextViewCompat.setTextAppearance(this.smallLabel, i2);
            calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        }
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, colorStateList) == null) || colorStateList == null) {
            return;
        }
        this.smallLabel.setTextColor(colorStateList);
        this.largeLabel.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, charSequence) == null) {
            this.smallLabel.setText(charSequence);
            this.largeLabel.setText(charSequence);
            MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
                setContentDescription(charSequence);
            }
            MenuItemImpl menuItemImpl2 = this.itemData;
            if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
                charSequence = this.itemData.getTooltipText();
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
        this.itemPosition = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(R.id.icon);
        this.smallLabel = (TextView) findViewById(R.id.smallLabel);
        this.largeLabel = (TextView) findViewById(R.id.largeLabel);
        ViewCompat.setImportantForAccessibility(this.smallLabel, 2);
        ViewCompat.setImportantForAccessibility(this.largeLabel, 2);
        setFocusable(true);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) { // from class: com.google.android.material.bottomnavigation.BottomNavigationItemView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomNavigationItemView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)}) == null) && this.this$0.icon.getVisibility() == 0) {
                        BottomNavigationItemView bottomNavigationItemView = this.this$0;
                        bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
                    }
                }
            });
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, drawable) == null) {
            if (drawable != null && drawable.getConstantState() != null) {
                drawable = drawable.getConstantState().newDrawable().mutate();
            }
            ViewCompat.setBackground(this, drawable);
        }
    }
}
