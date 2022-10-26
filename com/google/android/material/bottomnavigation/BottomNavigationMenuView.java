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
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    public static final int[] CHECKED_STATE_SET;
    public static final int[] DISABLED_STATE_SET;
    public static final int ITEM_POOL_SIZE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final int activeItemMaxWidth;
    public final int activeItemMinWidth;
    public SparseArray badgeDrawables;
    public BottomNavigationItemView[] buttons;
    public final int inactiveItemMaxWidth;
    public final int inactiveItemMinWidth;
    public Drawable itemBackground;
    public int itemBackgroundRes;
    public final int itemHeight;
    public boolean itemHorizontalTranslationEnabled;
    public int itemIconSize;
    public ColorStateList itemIconTint;
    public final Pools.Pool itemPool;
    public int itemTextAppearanceActive;
    public int itemTextAppearanceInactive;
    public final ColorStateList itemTextColorDefault;
    public ColorStateList itemTextColorFromUser;
    public int labelVisibilityMode;
    public MenuBuilder menu;
    public final View.OnClickListener onClickListener;
    public BottomNavigationPresenter presenter;
    public int selectedItemId;
    public int selectedItemPosition;
    public final TransitionSet set;
    public int[] tempChildWidths;

    private boolean isShifting(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i, i2)) == null) {
            if (i == -1) {
                if (i2 > 3) {
                    return true;
                }
            } else if (i == 0) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    private boolean isValidId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? i != -1 : invokeI.booleanValue;
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

    public BadgeDrawable getOrCreateBadge(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            validateMenuItemId(i);
            BadgeDrawable badgeDrawable = (BadgeDrawable) this.badgeDrawables.get(i);
            if (badgeDrawable == null) {
                badgeDrawable = BadgeDrawable.create(getContext());
                this.badgeDrawables.put(i, badgeDrawable);
            }
            BottomNavigationItemView findItemView = findItemView(i);
            if (findItemView != null) {
                findItemView.setBadge(badgeDrawable);
            }
            return badgeDrawable;
        }
        return (BadgeDrawable) invokeI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.badgeDrawables = new SparseArray(5);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f8);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701fa);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f2);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f3);
        this.itemHeight = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f6);
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    MenuItemImpl itemData = ((BottomNavigationItemView) view2).getItemData();
                    if (!this.this$0.menu.performItemAction(itemData, this.this$0.presenter, 0)) {
                        itemData.setChecked(true);
                    }
                }
            }
        };
        this.tempChildWidths = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private void setBadgeIfNeeded(BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bottomNavigationItemView) == null) {
            int id = bottomNavigationItemView.getId();
            if (isValidId(id) && (badgeDrawable = (BadgeDrawable) this.badgeDrawables.get(id)) != null) {
                bottomNavigationItemView.setBadge(badgeDrawable);
            }
        }
    }

    private void validateMenuItemId(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65546, this, i) != null) || isValidId(i)) {
            return;
        }
        throw new IllegalArgumentException(i + " is not a valid view id");
    }

    public BottomNavigationItemView findItemView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            validateMenuItemId(i);
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    if (bottomNavigationItemView.getId() == i) {
                        return bottomNavigationItemView;
                    }
                }
                return null;
            }
            return null;
        }
        return (BottomNavigationItemView) invokeI.objValue;
    }

    public BadgeDrawable getBadge(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (BadgeDrawable) this.badgeDrawables.get(i);
        }
        return (BadgeDrawable) invokeI.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, menuBuilder) == null) {
            this.menu = menuBuilder;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
        }
    }

    public void removeBadge(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            validateMenuItemId(i);
            BadgeDrawable badgeDrawable = (BadgeDrawable) this.badgeDrawables.get(i);
            BottomNavigationItemView findItemView = findItemView(i);
            if (findItemView != null) {
                findItemView.removeBadge();
            }
            if (badgeDrawable != null) {
                this.badgeDrawables.remove(i);
            }
        }
    }

    public void setBadgeDrawables(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sparseArray) == null) {
            this.badgeDrawables = sparseArray;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setBadge((BadgeDrawable) sparseArray.get(bottomNavigationItemView.getId()));
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

    public void setItemBackground(Drawable drawable) {
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

    public void setItemBackgroundRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.itemBackgroundRes = i;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setItemBackground(i);
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

    public void setItemIconSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.itemIconSize = i;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setIconSize(i);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.itemTextAppearanceActive = i;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setTextAppearanceActive(i);
                    ColorStateList colorStateList = this.itemTextColorFromUser;
                    if (colorStateList != null) {
                        bottomNavigationItemView.setTextColor(colorStateList);
                    }
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.itemTextAppearanceInactive = i;
            BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
            if (bottomNavigationItemViewArr != null) {
                for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                    bottomNavigationItemView.setTextAppearanceInactive(i);
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

    public void setLabelVisibilityMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.labelVisibilityMode = i;
        }
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bottomNavigationPresenter) == null) {
            this.presenter = bottomNavigationPresenter;
        }
    }

    public void tryRestoreSelectedItemId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            int size = this.menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = this.menu.getItem(i2);
                if (i == item.getItemId()) {
                    this.selectedItemId = i;
                    this.selectedItemPosition = i2;
                    item.setChecked(true);
                    return;
                }
            }
        }
    }

    private BottomNavigationItemView getNewItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) this.itemPool.acquire();
            if (bottomNavigationItemView == null) {
                return new BottomNavigationItemView(getContext());
            }
            return bottomNavigationItemView;
        }
        return (BottomNavigationItemView) invokeV.objValue;
    }

    public SparseArray getBadgeDrawables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.badgeDrawables;
        }
        return (SparseArray) invokeV.objValue;
    }

    public ColorStateList getIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.itemIconTint;
        }
        return (ColorStateList) invokeV.objValue;
    }

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.itemBackgroundRes;
        }
        return invokeV.intValue;
    }

    public int getItemIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.itemIconSize;
        }
        return invokeV.intValue;
    }

    public int getItemTextAppearanceActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.itemTextAppearanceActive;
        }
        return invokeV.intValue;
    }

    public int getItemTextAppearanceInactive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.itemTextAppearanceInactive;
        }
        return invokeV.intValue;
    }

    public ColorStateList getItemTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.itemTextColorFromUser;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public int getLabelVisibilityMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.labelVisibilityMode;
        }
        return invokeV.intValue;
    }

    public int getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.selectedItemId;
        }
        return invokeV.intValue;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.itemHorizontalTranslationEnabled;
        }
        return invokeV.booleanValue;
    }

    private void removeUnusedBadges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < this.menu.size(); i++) {
                hashSet.add(Integer.valueOf(this.menu.getItem(i).getItemId()));
            }
            for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
                int keyAt = this.badgeDrawables.keyAt(i2);
                if (!hashSet.contains(Integer.valueOf(keyAt))) {
                    this.badgeDrawables.delete(keyAt);
                }
            }
        }
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
            for (int i = 0; i < this.menu.size(); i++) {
                this.presenter.setUpdateSuspended(true);
                this.menu.getItem(i).setCheckable(true);
                this.presenter.setUpdateSuspended(false);
                BottomNavigationItemView newItem = getNewItem();
                this.buttons[i] = newItem;
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
                newItem.initialize((MenuItemImpl) this.menu.getItem(i), 0);
                newItem.setItemPosition(i);
                newItem.setOnClickListener(this.onClickListener);
                if (this.selectedItemId != 0 && this.menu.getItem(i).getItemId() == this.selectedItemId) {
                    this.selectedItemPosition = i;
                }
                setBadgeIfNeeded(newItem);
                addView(newItem);
            }
            int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
            this.selectedItemPosition = min;
            this.menu.getItem(min).setChecked(true);
        }
    }

    public ColorStateList createDefaultColorStateList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
                return null;
            }
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (!getContext().getTheme().resolveAttribute(R.attr.obfuscated_res_0x7f040178, typedValue, true)) {
                return null;
            }
            int i2 = typedValue.data;
            int defaultColor = colorStateList.getDefaultColor();
            return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
        }
        return (ColorStateList) invokeI.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            int i5 = i3 - i;
            int i6 = i4 - i2;
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    if (ViewCompat.getLayoutDirection(this) == 1) {
                        int i9 = i5 - i7;
                        childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                    } else {
                        childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                    }
                    i7 += childAt.getMeasuredWidth();
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.menu.getVisibleItems().size();
            int childCount = getChildCount();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
            if (isShifting(this.labelVisibilityMode, size2) && this.itemHorizontalTranslationEnabled) {
                View childAt = getChildAt(this.selectedItemPosition);
                int i7 = this.activeItemMinWidth;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                    i7 = Math.max(i7, childAt.getMeasuredWidth());
                }
                if (childAt.getVisibility() != 8) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                int i8 = size2 - i4;
                int min = Math.min(size - (this.inactiveItemMinWidth * i8), Math.min(i7, this.activeItemMaxWidth));
                int i9 = size - min;
                if (i8 == 0) {
                    i5 = 1;
                } else {
                    i5 = i8;
                }
                int min2 = Math.min(i9 / i5, this.inactiveItemMaxWidth);
                int i10 = i9 - (i8 * min2);
                for (int i11 = 0; i11 < childCount; i11++) {
                    if (getChildAt(i11).getVisibility() != 8) {
                        int[] iArr = this.tempChildWidths;
                        if (i11 == this.selectedItemPosition) {
                            i6 = min;
                        } else {
                            i6 = min2;
                        }
                        iArr[i11] = i6;
                        if (i10 > 0) {
                            int[] iArr2 = this.tempChildWidths;
                            iArr2[i11] = iArr2[i11] + 1;
                            i10--;
                        }
                    } else {
                        this.tempChildWidths[i11] = 0;
                    }
                }
            } else {
                if (size2 == 0) {
                    i3 = 1;
                } else {
                    i3 = size2;
                }
                int min3 = Math.min(size / i3, this.activeItemMaxWidth);
                int i12 = size - (size2 * min3);
                for (int i13 = 0; i13 < childCount; i13++) {
                    if (getChildAt(i13).getVisibility() != 8) {
                        int[] iArr3 = this.tempChildWidths;
                        iArr3[i13] = min3;
                        if (i12 > 0) {
                            iArr3[i13] = iArr3[i13] + 1;
                            i12--;
                        }
                    } else {
                        this.tempChildWidths[i13] = 0;
                    }
                }
            }
            int i14 = 0;
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i15], 1073741824), makeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    i14 += childAt2.getMeasuredWidth();
                }
            }
            setMeasuredDimension(View.resolveSizeAndState(i14, View.MeasureSpec.makeMeasureSpec(i14, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
        }
    }

    public void updateMenuView() {
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (menuBuilder = this.menu) != null && this.buttons != null) {
            int size = menuBuilder.size();
            if (size != this.buttons.length) {
                buildMenuView();
                return;
            }
            int i = this.selectedItemId;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = this.menu.getItem(i2);
                if (item.isChecked()) {
                    this.selectedItemId = item.getItemId();
                    this.selectedItemPosition = i2;
                }
            }
            if (i != this.selectedItemId) {
                TransitionManager.beginDelayedTransition(this, this.set);
            }
            boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
            for (int i3 = 0; i3 < size; i3++) {
                this.presenter.setUpdateSuspended(true);
                this.buttons[i3].setLabelVisibilityMode(this.labelVisibilityMode);
                this.buttons[i3].setShifting(isShifting);
                this.buttons[i3].initialize((MenuItemImpl) this.menu.getItem(i3), 0);
                this.presenter.setUpdateSuspended(false);
            }
        }
    }
}
