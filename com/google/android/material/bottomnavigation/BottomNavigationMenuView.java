package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    public static final int[] CHECKED_STATE_SET;
    public static final int[] DISABLED_STATE_SET;
    public static final int ITEM_POOL_SIZE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final int activeItemMaxWidth;
    public final int activeItemMinWidth;
    @NonNull
    public SparseArray<BadgeDrawable> badgeDrawables;
    @Nullable
    public BottomNavigationItemView[] buttons;
    public final int inactiveItemMaxWidth;
    public final int inactiveItemMinWidth;
    public Drawable itemBackground;
    public int itemBackgroundRes;
    public final int itemHeight;
    public boolean itemHorizontalTranslationEnabled;
    @Dimension
    public int itemIconSize;
    public ColorStateList itemIconTint;
    public final Pools.Pool<BottomNavigationItemView> itemPool;
    @StyleRes
    public int itemTextAppearanceActive;
    @StyleRes
    public int itemTextAppearanceInactive;
    @Nullable
    public final ColorStateList itemTextColorDefault;
    public ColorStateList itemTextColorFromUser;
    public int labelVisibilityMode;
    public MenuBuilder menu;
    @NonNull
    public final View.OnClickListener onClickListener;
    public BottomNavigationPresenter presenter;
    public int selectedItemId;
    public int selectedItemPosition;
    @NonNull
    public final TransitionSet set;
    public int[] tempChildWidths;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1860574868, "Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1860574868, "Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;");
                return;
            }
        }
        CHECKED_STATE_SET = new int[]{16842912};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomNavigationMenuView(Context context) {
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

    private BottomNavigationItemView getNewItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            BottomNavigationItemView acquire = this.itemPool.acquire();
            return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
        }
        return (BottomNavigationItemView) invokeV.objValue;
    }

    private boolean isShifting(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i2, i3)) == null) {
            if (i2 == -1) {
                if (i3 > 3) {
                    return true;
                }
            } else if (i2 == 0) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    private boolean isValidId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) ? i2 != -1 : invokeI.booleanValue;
    }

    private void removeUnusedBadges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < this.menu.size(); i2++) {
                hashSet.add(Integer.valueOf(this.menu.getItem(i2).getItemId()));
            }
            for (int i3 = 0; i3 < this.badgeDrawables.size(); i3++) {
                int keyAt = this.badgeDrawables.keyAt(i3);
                if (!hashSet.contains(Integer.valueOf(keyAt))) {
                    this.badgeDrawables.delete(keyAt);
                }
            }
        }
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bottomNavigationItemView) == null) {
            int id = bottomNavigationItemView.getId();
            if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
                bottomNavigationItemView.setBadge(badgeDrawable);
            }
        }
    }

    private void validateMenuItemId(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, this, i2) == null) || isValidId(i2)) {
            return;
        }
        throw new IllegalArgumentException(i2 + " is not a valid view id");
    }

    public void buildMenuView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    if (bottomNavigationItemView != null) {
                        this.itemPool.release(bottomNavigationItemView);
                        bottomNavigationItemView.removeBadge();
                    }
                }
            }
            if (this.menu.size() == 0) {
                this.selectedItemId = 0;
                this.selectedItemPosition = 0;
                this.buttons = null;
                return;
            }
            removeUnusedBadges();
            this.buttons = new BottomNavigationItemView[this.menu.size()];
            boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
            for (int i2 = 0; i2 < this.menu.size(); i2++) {
                this.presenter.setUpdateSuspended(true);
                this.menu.getItem(i2).setCheckable(true);
                this.presenter.setUpdateSuspended(false);
                BottomNavigationItemView newItem = getNewItem();
                this.buttons[i2] = newItem;
                newItem.setIconTintList(this.itemIconTint);
                newItem.setIconSize(this.itemIconSize);
                newItem.setTextColor(this.itemTextColorDefault);
                newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
                newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
                newItem.setTextColor(this.itemTextColorFromUser);
                Drawable drawable = this.itemBackground;
                if (drawable != null) {
                    newItem.setItemBackground(drawable);
                } else {
                    newItem.setItemBackground(this.itemBackgroundRes);
                }
                newItem.setShifting(isShifting);
                newItem.setLabelVisibilityMode(this.labelVisibilityMode);
                newItem.initialize((MenuItemImpl) this.menu.getItem(i2), 0);
                newItem.setItemPosition(i2);
                newItem.setOnClickListener(this.onClickListener);
                if (this.selectedItemId != 0 && this.menu.getItem(i2).getItemId() == this.selectedItemId) {
                    this.selectedItemPosition = i2;
                }
                setBadgeIfNeeded(newItem);
                addView(newItem);
            }
            int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
            this.selectedItemPosition = min;
            this.menu.getItem(min).setChecked(true);
        }
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
                ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
                if (getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                    int i3 = typedValue.data;
                    int defaultColor = colorStateList.getDefaultColor();
                    return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i3, defaultColor});
                }
                return null;
            }
            return null;
        }
        return (ColorStateList) invokeI.objValue;
    }

    @Nullable
    @VisibleForTesting
    public BottomNavigationItemView findItemView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            validateMenuItemId(i2);
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    if (bottomNavigationItemView.getId() == i2) {
                        return bottomNavigationItemView;
                    }
                }
                return null;
            }
            return null;
        }
        return (BottomNavigationItemView) invokeI.objValue;
    }

    @Nullable
    public BadgeDrawable getBadge(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.badgeDrawables.get(i2) : (BadgeDrawable) invokeI.objValue;
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.badgeDrawables : (SparseArray) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.itemIconTint : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public Drawable getItemBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null && bottomNavigationItemViewArr.length > 0) {
                return bottomNavigationItemViewArr[0].getBackground();
            }
            return this.itemBackground;
        }
        return (Drawable) invokeV.objValue;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.itemBackgroundRes : invokeV.intValue;
    }

    @Dimension
    public int getItemIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.itemIconSize : invokeV.intValue;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.itemTextAppearanceActive : invokeV.intValue;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.itemTextAppearanceInactive : invokeV.intValue;
    }

    public ColorStateList getItemTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.itemTextColorFromUser : (ColorStateList) invokeV.objValue;
    }

    public int getLabelVisibilityMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.labelVisibilityMode : invokeV.intValue;
    }

    public BadgeDrawable getOrCreateBadge(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            validateMenuItemId(i2);
            BadgeDrawable badgeDrawable = this.badgeDrawables.get(i2);
            if (badgeDrawable == null) {
                badgeDrawable = BadgeDrawable.create(getContext());
                this.badgeDrawables.put(i2, badgeDrawable);
            }
            BottomNavigationItemView findItemView = findItemView(i2);
            if (findItemView != null) {
                findItemView.setBadge(badgeDrawable);
            }
            return badgeDrawable;
        }
        return (BadgeDrawable) invokeI.objValue;
    }

    public int getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.selectedItemId : invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, menuBuilder) == null) {
            this.menu = menuBuilder;
        }
    }

    public boolean isItemHorizontalTranslationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.itemHorizontalTranslationEnabled : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            int i8 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    if (ViewCompat.getLayoutDirection(this) == 1) {
                        int i10 = i6 - i8;
                        childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                    } else {
                        childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                    }
                    i8 += childAt.getMeasuredWidth();
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = this.menu.getVisibleItems().size();
            int childCount = getChildCount();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
            if (isShifting(this.labelVisibilityMode, size2) && this.itemHorizontalTranslationEnabled) {
                View childAt = getChildAt(this.selectedItemPosition);
                int i4 = this.activeItemMinWidth;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                    i4 = Math.max(i4, childAt.getMeasuredWidth());
                }
                int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
                int min = Math.min(size - (this.inactiveItemMinWidth * i5), Math.min(i4, this.activeItemMaxWidth));
                int i6 = size - min;
                int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.inactiveItemMaxWidth);
                int i7 = i6 - (i5 * min2);
                int i8 = 0;
                while (i8 < childCount) {
                    if (getChildAt(i8).getVisibility() != 8) {
                        this.tempChildWidths[i8] = i8 == this.selectedItemPosition ? min : min2;
                        if (i7 > 0) {
                            int[] iArr = this.tempChildWidths;
                            iArr[i8] = iArr[i8] + 1;
                            i7--;
                        }
                    } else {
                        this.tempChildWidths[i8] = 0;
                    }
                    i8++;
                }
            } else {
                int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.activeItemMaxWidth);
                int i9 = size - (size2 * min3);
                for (int i10 = 0; i10 < childCount; i10++) {
                    if (getChildAt(i10).getVisibility() != 8) {
                        int[] iArr2 = this.tempChildWidths;
                        iArr2[i10] = min3;
                        if (i9 > 0) {
                            iArr2[i10] = iArr2[i10] + 1;
                            i9--;
                        }
                    } else {
                        this.tempChildWidths[i10] = 0;
                    }
                }
            }
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i12], 1073741824), makeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    i11 += childAt2.getMeasuredWidth();
                }
            }
            setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
        }
    }

    public void removeBadge(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            validateMenuItemId(i2);
            BadgeDrawable badgeDrawable = this.badgeDrawables.get(i2);
            BottomNavigationItemView findItemView = findItemView(i2);
            if (findItemView != null) {
                findItemView.removeBadge();
            }
            if (badgeDrawable != null) {
                this.badgeDrawables.remove(i2);
            }
        }
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sparseArray) == null) {
            this.badgeDrawables = sparseArray;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
                }
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, colorStateList) == null) {
            this.itemIconTint = colorStateList;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            this.itemBackground = drawable;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.itemBackgroundRes = i2;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setItemBackground(i2);
                }
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.itemHorizontalTranslationEnabled = z;
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.itemIconSize = i2;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setIconSize(i2);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.itemTextAppearanceActive = i2;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setTextAppearanceActive(i2);
                    ColorStateList colorStateList = this.itemTextColorFromUser;
                    if (colorStateList != null) {
                        bottomNavigationItemView.setTextColor(colorStateList);
                    }
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.itemTextAppearanceInactive = i2;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setTextAppearanceInactive(i2);
                    ColorStateList colorStateList = this.itemTextColorFromUser;
                    if (colorStateList != null) {
                        bottomNavigationItemView.setTextColor(colorStateList);
                    }
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, colorStateList) == null) {
            this.itemTextColorFromUser = colorStateList;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.labelVisibilityMode = i2;
        }
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bottomNavigationPresenter) == null) {
            this.presenter = bottomNavigationPresenter;
        }
    }

    public void tryRestoreSelectedItemId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            int size = this.menu.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = this.menu.getItem(i3);
                if (i2 == item.getItemId()) {
                    this.selectedItemId = i2;
                    this.selectedItemPosition = i3;
                    item.setChecked(true);
                    return;
                }
            }
        }
    }

    public void updateMenuView() {
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (menuBuilder = this.menu) == null || this.buttons == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.buttons.length) {
            buildMenuView();
            return;
        }
        int i2 = this.selectedItemId;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.menu.getItem(i3);
            if (item.isChecked()) {
                this.selectedItemId = item.getItemId();
                this.selectedItemPosition = i3;
            }
        }
        if (i2 != this.selectedItemId) {
            TransitionManager.beginDelayedTransition(this, this.set);
        }
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i4].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[i4].setShifting(isShifting);
            this.buttons[i4].initialize((MenuItemImpl) this.menu.getItem(i4), 0);
            this.presenter.setUpdateSuspended(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.itemPool = new Pools.SynchronizedPool(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray<>(5);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = createDefaultColorStateList(16842808);
        AutoTransition autoTransition = new AutoTransition();
        this.set = autoTransition;
        autoTransition.setOrdering(0);
        this.set.setDuration(115L);
        this.set.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        this.set.addTransition(new TextScale());
        this.onClickListener = new View.OnClickListener(this) { // from class: com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomNavigationMenuView this$0;

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

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                    if (this.this$0.menu.performItemAction(itemData, this.this$0.presenter, 0)) {
                        return;
                    }
                    itemData.setChecked(true);
                }
            }
        };
        this.tempChildWidths = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
