package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String STATE_ADAPTER = "android:menu:adapter";
    public static final String STATE_HEADER = "android:menu:header";
    public static final String STATE_HIERARCHY = "android:menu:list";
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationMenuAdapter adapter;
    public MenuPresenter.Callback callback;
    public boolean hasCustomItemIconSize;
    public LinearLayout headerLayout;
    public ColorStateList iconTintList;
    public int id;
    public boolean isBehindStatusBar;
    public Drawable itemBackground;
    public int itemHorizontalPadding;
    public int itemIconPadding;
    public int itemIconSize;
    public int itemMaxLines;
    public LayoutInflater layoutInflater;
    public MenuBuilder menu;
    public NavigationMenuView menuView;
    public final View.OnClickListener onClickListener;
    public int overScrollMode;
    public int paddingSeparator;
    public int paddingTopDefault;
    public int textAppearance;
    public boolean textAppearanceSet;
    public ColorStateList textColor;

    /* loaded from: classes5.dex */
    public static class HeaderViewHolder extends ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
        }
    }

    /* loaded from: classes5.dex */
    public class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        public static final String STATE_CHECKED_ITEM = "android:menu:checked";
        public static final int VIEW_TYPE_HEADER = 3;
        public static final int VIEW_TYPE_NORMAL = 0;
        public static final int VIEW_TYPE_SEPARATOR = 2;
        public static final int VIEW_TYPE_SUBHEADER = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public MenuItemImpl checkedItem;
        public final ArrayList<NavigationMenuItem> items;
        public final /* synthetic */ NavigationMenuPresenter this$0;
        public boolean updateSuspended;

        public NavigationMenuAdapter(NavigationMenuPresenter navigationMenuPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationMenuPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = navigationMenuPresenter;
            this.items = new ArrayList<>();
            prepareMenuItems();
        }

        private void appendTransparentIconIfMissing(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65537, this, i, i2) == null) {
                while (i < i2) {
                    ((NavigationMenuTextItem) this.items.get(i)).needsEmptyIcon = true;
                    i++;
                }
            }
        }

        private void prepareMenuItems() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.updateSuspended) {
                return;
            }
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new NavigationMenuHeaderItem());
            int i = -1;
            int size = this.this$0.menu.getVisibleItems().size();
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = this.this$0.menu.getVisibleItems().get(i3);
                if (menuItemImpl.isChecked()) {
                    setCheckedItem(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.items.add(new NavigationMenuSeparatorItem(this.this$0.paddingSeparator, 0));
                        }
                        this.items.add(new NavigationMenuTextItem(menuItemImpl));
                        int size2 = this.items.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i4 = 0; i4 < size3; i4++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i4);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    setCheckedItem(menuItemImpl);
                                }
                                this.items.add(new NavigationMenuTextItem(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            appendTransparentIconIfMissing(size2, this.items.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i) {
                        i2 = this.items.size();
                        z = menuItemImpl.getIcon() != null;
                        if (i3 != 0) {
                            i2++;
                            ArrayList<NavigationMenuItem> arrayList = this.items;
                            int i5 = this.this$0.paddingSeparator;
                            arrayList.add(new NavigationMenuSeparatorItem(i5, i5));
                        }
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        appendTransparentIconIfMissing(i2, this.items.size());
                        z = true;
                    }
                    NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem.needsEmptyIcon = z;
                    this.items.add(navigationMenuTextItem);
                    i = groupId;
                }
            }
            this.updateSuspended = false;
        }

        @NonNull
        public Bundle createInstanceState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Bundle bundle = new Bundle();
                MenuItemImpl menuItemImpl = this.checkedItem;
                if (menuItemImpl != null) {
                    bundle.putInt(STATE_CHECKED_ITEM, menuItemImpl.getItemId());
                }
                SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
                int size = this.items.size();
                for (int i = 0; i < size; i++) {
                    NavigationMenuItem navigationMenuItem = this.items.get(i);
                    if (navigationMenuItem instanceof NavigationMenuTextItem) {
                        MenuItemImpl menuItem = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                        View actionView = menuItem != null ? menuItem.getActionView() : null;
                        if (actionView != null) {
                            ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                            actionView.saveHierarchyState(parcelableSparseArray);
                            sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                        }
                    }
                }
                bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }

        public MenuItemImpl getCheckedItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.checkedItem : (MenuItemImpl) invokeV.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.items.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                NavigationMenuItem navigationMenuItem = this.items.get(i);
                if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                    return 2;
                }
                if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                    return 3;
                }
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    return ((NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu() ? 1 : 0;
                }
                throw new RuntimeException("Unknown item type.");
            }
            return invokeI.intValue;
        }

        public int getRowCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i = this.this$0.headerLayout.getChildCount() == 0 ? 0 : 1;
                for (int i2 = 0; i2 < this.this$0.adapter.getItemCount(); i2++) {
                    if (this.this$0.adapter.getItemViewType(i2) == 0) {
                        i++;
                    }
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void restoreInstanceState(@NonNull Bundle bundle) {
            MenuItemImpl menuItem;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItem2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
                int i = bundle.getInt(STATE_CHECKED_ITEM, 0);
                if (i != 0) {
                    this.updateSuspended = true;
                    int size = this.items.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        NavigationMenuItem navigationMenuItem = this.items.get(i2);
                        if ((navigationMenuItem instanceof NavigationMenuTextItem) && (menuItem2 = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i) {
                            setCheckedItem(menuItem2);
                            break;
                        }
                        i2++;
                    }
                    this.updateSuspended = false;
                    prepareMenuItems();
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS);
                if (sparseParcelableArray != null) {
                    int size2 = this.items.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        NavigationMenuItem navigationMenuItem2 = this.items.get(i3);
                        if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (menuItem = ((NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) != null && (actionView = menuItem.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
        }

        public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, menuItemImpl) == null) && this.checkedItem != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.checkedItem;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.checkedItem = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void setUpdateSuspended(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                this.updateSuspended = z;
            }
        }

        public void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                prepareMenuItems();
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, viewHolder, i) == null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        ((TextView) viewHolder.itemView).setText(((NavigationMenuTextItem) this.items.get(i)).getMenuItem().getTitle());
                        return;
                    } else if (itemViewType != 2) {
                        return;
                    } else {
                        NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.items.get(i);
                        viewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.getPaddingTop(), 0, navigationMenuSeparatorItem.getPaddingBottom());
                        return;
                    }
                }
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                navigationMenuItemView.setIconTintList(this.this$0.iconTintList);
                NavigationMenuPresenter navigationMenuPresenter = this.this$0;
                if (navigationMenuPresenter.textAppearanceSet) {
                    navigationMenuItemView.setTextAppearance(navigationMenuPresenter.textAppearance);
                }
                ColorStateList colorStateList = this.this$0.textColor;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = this.this$0.itemBackground;
                ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.items.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
                navigationMenuItemView.setHorizontalPadding(this.this$0.itemHorizontalPadding);
                navigationMenuItemView.setIconPadding(this.this$0.itemIconPadding);
                NavigationMenuPresenter navigationMenuPresenter2 = this.this$0;
                if (navigationMenuPresenter2.hasCustomItemIconSize) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
                }
                navigationMenuItemView.setMaxLines(this.this$0.itemMaxLines);
                navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), 0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i)) == null) {
                if (i == 0) {
                    NavigationMenuPresenter navigationMenuPresenter = this.this$0;
                    return new NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
                } else if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return new HeaderViewHolder(this.this$0.headerLayout);
                    }
                    return new SeparatorViewHolder(this.this$0.layoutInflater, viewGroup);
                } else {
                    return new SubheaderViewHolder(this.this$0.layoutInflater, viewGroup);
                }
            }
            return (ViewHolder) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, viewHolder) == null) && (viewHolder instanceof NormalViewHolder)) {
                ((NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NavigationMenuHeaderItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface NavigationMenuItem {
    }

    /* loaded from: classes5.dex */
    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int paddingBottom;
        public final int paddingTop;

        public NavigationMenuSeparatorItem(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.paddingTop = i;
            this.paddingBottom = i2;
        }

        public int getPaddingBottom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.paddingBottom : invokeV.intValue;
        }

        public int getPaddingTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.paddingTop : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class NavigationMenuTextItem implements NavigationMenuItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MenuItemImpl menuItem;
        public boolean needsEmptyIcon;

        public NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {menuItemImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.menuItem = menuItemImpl;
        }

        public MenuItemImpl getMenuItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.menuItem : (MenuItemImpl) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationMenuPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigationMenuViewAccessibilityDelegate(@NonNull NavigationMenuPresenter navigationMenuPresenter, RecyclerView recyclerView) {
            super(recyclerView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationMenuPresenter, recyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((RecyclerView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = navigationMenuPresenter;
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.this$0.adapter.getRowCount(), 0, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class NormalViewHolder extends ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0216, viewGroup, false));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutInflater, viewGroup, onClickListener};
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
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes5.dex */
    public static class SeparatorViewHolder extends ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SeparatorViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0218, viewGroup, false));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutInflater, viewGroup};
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
        }
    }

    /* loaded from: classes5.dex */
    public static class SubheaderViewHolder extends ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubheaderViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0219, viewGroup, false));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutInflater, viewGroup};
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
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
        }
    }

    public NavigationMenuPresenter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isBehindStatusBar = true;
        this.overScrollMode = -1;
        this.onClickListener = new View.OnClickListener(this) { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NavigationMenuPresenter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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
                    boolean z = true;
                    this.this$0.setUpdateSuspended(true);
                    MenuItemImpl itemData = ((NavigationMenuItemView) view2).getItemData();
                    NavigationMenuPresenter navigationMenuPresenter = this.this$0;
                    boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
                    if (itemData != null && itemData.isCheckable() && performItemAction) {
                        this.this$0.adapter.setCheckedItem(itemData);
                    } else {
                        z = false;
                    }
                    this.this$0.setUpdateSuspended(false);
                    if (z) {
                        this.this$0.updateMenuView(false);
                    }
                }
            }
        };
    }

    private void updateTopPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int i = (this.headerLayout.getChildCount() == 0 && this.isBehindStatusBar) ? this.paddingTopDefault : 0;
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void addHeaderView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.headerLayout.addView(view2);
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder, menuItemImpl)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, windowInsetsCompat) == null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            if (this.paddingTopDefault != systemWindowInsetTop) {
                this.paddingTopDefault = systemWindowInsetTop;
                updateTopPadding();
            }
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
            ViewCompat.dispatchApplyWindowInsets(this.headerLayout, windowInsetsCompat);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, menuBuilder, menuItemImpl)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.adapter.getCheckedItem() : (MenuItemImpl) invokeV.objValue;
    }

    public int getHeaderCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.headerLayout.getChildCount() : invokeV.intValue;
    }

    public View getHeaderView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? this.headerLayout.getChildAt(i) : (View) invokeI.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.id : invokeV.intValue;
    }

    @Nullable
    public Drawable getItemBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.itemBackground : (Drawable) invokeV.objValue;
    }

    public int getItemHorizontalPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.itemHorizontalPadding : invokeV.intValue;
    }

    public int getItemIconPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.itemIconPadding : invokeV.intValue;
    }

    public int getItemMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.itemMaxLines : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.textColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.iconTintList : (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            if (this.menuView == null) {
                NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d021a, viewGroup, false);
                this.menuView = navigationMenuView;
                navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this, this.menuView));
                if (this.adapter == null) {
                    this.adapter = new NavigationMenuAdapter(this);
                }
                int i = this.overScrollMode;
                if (i != -1) {
                    this.menuView.setOverScrollMode(i);
                }
                this.headerLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0217, (ViewGroup) this.menuView, false);
                this.menuView.setAdapter(this.adapter);
            }
            return this.menuView;
        }
        return (MenuView) invokeL.objValue;
    }

    public View inflateHeaderView(@LayoutRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            View inflate = this.layoutInflater.inflate(i, (ViewGroup) this.headerLayout, false);
            addHeaderView(inflate);
            return inflate;
        }
        return (View) invokeI.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, menuBuilder) == null) {
            this.layoutInflater = LayoutInflater.from(context);
            this.menu = menuBuilder;
            this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070212);
        }
    }

    public boolean isBehindStatusBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.isBehindStatusBar : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048595, this, menuBuilder, z) == null) || (callback = this.callback) == null) {
            return;
        }
        callback.onCloseMenu(menuBuilder, z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, parcelable) == null) && (parcelable instanceof Bundle)) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Bundle bundle = new Bundle();
            if (this.menuView != null) {
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                this.menuView.saveHierarchyState(sparseArray);
                bundle.putSparseParcelableArray("android:menu:list", sparseArray);
            }
            NavigationMenuAdapter navigationMenuAdapter = this.adapter;
            if (navigationMenuAdapter != null) {
                bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
            }
            if (this.headerLayout != null) {
                SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
                this.headerLayout.saveHierarchyState(sparseArray2);
                bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
            }
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, subMenuBuilder)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void removeHeaderView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            this.headerLayout.removeView(view2);
            if (this.headerLayout.getChildCount() == 0) {
                NavigationMenuView navigationMenuView = this.menuView;
                navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
            }
        }
    }

    public void setBehindStatusBar(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.isBehindStatusBar == z) {
            return;
        }
        this.isBehindStatusBar = z;
        updateTopPadding();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, callback) == null) {
            this.callback = callback;
        }
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, menuItemImpl) == null) {
            this.adapter.setCheckedItem(menuItemImpl);
        }
    }

    public void setId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.id = i;
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, drawable) == null) {
            this.itemBackground = drawable;
            updateMenuView(false);
        }
    }

    public void setItemHorizontalPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.itemHorizontalPadding = i;
            updateMenuView(false);
        }
    }

    public void setItemIconPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.itemIconPadding = i;
            updateMenuView(false);
        }
    }

    public void setItemIconSize(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i) == null) || this.itemIconSize == i) {
            return;
        }
        this.itemIconSize = i;
        this.hasCustomItemIconSize = true;
        updateMenuView(false);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, colorStateList) == null) {
            this.iconTintList = colorStateList;
            updateMenuView(false);
        }
    }

    public void setItemMaxLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.itemMaxLines = i;
            updateMenuView(false);
        }
    }

    public void setItemTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.textAppearance = i;
            this.textAppearanceSet = true;
            updateMenuView(false);
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, colorStateList) == null) {
            this.textColor = colorStateList;
            updateMenuView(false);
        }
    }

    public void setOverScrollMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.overScrollMode = i;
            NavigationMenuView navigationMenuView = this.menuView;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setUpdateSuspended(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || (navigationMenuAdapter = this.adapter) == null) {
            return;
        }
        navigationMenuAdapter.setUpdateSuspended(z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || (navigationMenuAdapter = this.adapter) == null) {
            return;
        }
        navigationMenuAdapter.update();
    }
}
