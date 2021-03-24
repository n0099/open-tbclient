package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.internal.TextScale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    public static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public final int activeItemMaxWidth;
    public final int activeItemMinWidth;
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

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.itemPool.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    private boolean isShifting(int i, int i2) {
        if (i == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i == 0) {
            return true;
        }
        return false;
    }

    public void buildMenuView() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.itemPool.release(bottomNavigationItemView);
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
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
            addView(newItem);
        }
        int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        this.menu.getItem(min).setChecked(true);
    }

    public ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                int i2 = typedValue.data;
                int defaultColor = colorStateList.getDefaultColor();
                return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
            }
            return null;
        }
        return null;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null && bottomNavigationItemViewArr.length > 0) {
            return bottomNavigationItemViewArr[0].getBackground();
        }
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.menu.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        if (isShifting(this.labelVisibilityMode, size2) && this.itemHorizontalTranslationEnabled) {
            View childAt = getChildAt(this.selectedItemPosition);
            int i3 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i3 = Math.max(i3, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.inactiveItemMinWidth * i4), Math.min(i3, this.activeItemMaxWidth));
            int i5 = size - min;
            int min2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.inactiveItemMaxWidth);
            int i6 = i5 - (i4 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.tempChildWidths[i7] = i7 == this.selectedItemPosition ? min : min2;
                    if (i6 > 0) {
                        int[] iArr = this.tempChildWidths;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.tempChildWidths[i7] = 0;
                }
                i7++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.activeItemMaxWidth);
            int i8 = size - (size2 * min3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.tempChildWidths;
                    iArr2[i9] = min3;
                    if (i8 > 0) {
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.tempChildWidths[i9] = 0;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.itemBackgroundRes = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.itemHorizontalTranslationEnabled = z;
    }

    public void setItemIconSize(@Dimension int i) {
        this.itemIconSize = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i) {
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

    public void setItemTextAppearanceInactive(@StyleRes int i) {
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

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.labelVisibilityMode = i;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.presenter = bottomNavigationPresenter;
    }

    public void tryRestoreSelectedItemId(int i) {
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

    public void updateMenuView() {
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null || this.buttons == null) {
            return;
        }
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

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
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
        this.onClickListener = new View.OnClickListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (BottomNavigationMenuView.this.menu.performItemAction(itemData, BottomNavigationMenuView.this.presenter, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        this.tempChildWidths = new int[5];
    }
}
