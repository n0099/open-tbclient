package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BdMenu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mDismissOnClick;
    public List<BdMenuItem> mItems;
    public View.OnKeyListener mKeyClickListener;
    public View mMenu;
    public BdMenuItem.OnItemClickListener mMenuItemClickListener;
    public PopupWindow mPopupWindow;
    public Resources mResources;
    public OnMenuStateChangeListener mStateChangeListener;
    public final View mViewToAttach;

    /* loaded from: classes2.dex */
    public interface OnMenuSetChangedListener {
        void onMenuItemUpdated(BdMenuItem bdMenuItem);

        void onMenuSetChanged();
    }

    /* loaded from: classes2.dex */
    public interface OnMenuStateChangeListener {
        void onDismissMenu();

        void onShowMenu();
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMenu f55863e;

        public a(BdMenu bdMenu) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMenu};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55863e = bdMenu;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i2 == 4 || i2 == 82) {
                        this.f55863e.dismiss();
                        if (this.f55863e.mKeyClickListener != null) {
                            this.f55863e.mKeyClickListener.onKey(view, i2, keyEvent);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BdMenuItem.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdMenu a;

        public b(BdMenu bdMenu) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMenu};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdMenu;
        }

        @Override // com.dxmpay.wallet.base.widget.BdMenuItem.OnItemClickListener
        public void onClick(BdMenuItem bdMenuItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdMenuItem) == null) {
                this.a.dismiss();
                if (this.a.mMenuItemClickListener != null) {
                    this.a.mMenuItemClickListener.onClick(bdMenuItem);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements BdMenuItem.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdMenu a;

        public c(BdMenu bdMenu) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMenu};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdMenu;
        }

        @Override // com.dxmpay.wallet.base.widget.BdMenuItem.OnItemClickListener
        public void onClick(BdMenuItem bdMenuItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdMenuItem) == null) {
                this.a.dismiss();
                if (this.a.mMenuItemClickListener != null) {
                    this.a.mMenuItemClickListener.onClick(bdMenuItem);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMenu f55864e;

        public d(BdMenu bdMenu) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMenu};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55864e = bdMenu;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55864e.mStateChangeListener == null) {
                return;
            }
            this.f55864e.mStateChangeListener.onDismissMenu();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMenu f55865e;

        public e(BdMenu bdMenu) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMenu};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55865e = bdMenu;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f55865e.showMenu(this.f55865e.mPopupWindow);
                } catch (Exception unused) {
                }
            }
        }
    }

    public BdMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDismissOnClick = true;
        this.mViewToAttach = view;
        this.mContext = view.getContext();
        this.mResources = this.mViewToAttach.getResources();
        this.mItems = new ArrayList();
        prepareMenuView(this.mContext);
    }

    private BdMenuItem addInternal(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65541, this, i2, charSequence, drawable)) == null) {
            BdMenuItem bdMenuItem = new BdMenuItem(this.mContext, i2, charSequence, drawable);
            bdMenuItem.setMenu(this);
            if (this.mDismissOnClick) {
                bdMenuItem.setOnClickListener(new b(this));
            } else {
                bdMenuItem.setOnClickListener(this.mMenuItemClickListener);
            }
            this.mItems.add(bdMenuItem);
            return bdMenuItem;
        }
        return (BdMenuItem) invokeILL.objValue;
    }

    private BdMenuItem addInternal1(int i2, CharSequence charSequence, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65542, this, i2, charSequence, str)) == null) {
            BdMenuItem bdMenuItem = new BdMenuItem(this.mContext, i2, charSequence, str);
            bdMenuItem.setMenu(this);
            if (this.mDismissOnClick) {
                bdMenuItem.setOnClickListener(new c(this));
            } else {
                bdMenuItem.setOnClickListener(this.mMenuItemClickListener);
            }
            this.mItems.add(bdMenuItem);
            return bdMenuItem;
        }
        return (BdMenuItem) invokeILL.objValue;
    }

    private void prepareMenuView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            View menuView = getMenuView(context);
            this.mMenu = menuView;
            if (menuView instanceof OnMenuSetChangedListener) {
                menuView.setOnKeyListener(new a(this));
                return;
            }
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
    }

    public BdMenuItem add(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, charSequence)) == null) ? addInternal(i2, charSequence, null) : (BdMenuItem) invokeIL.objValue;
    }

    public void dismiss() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.mPopupWindow) != null && popupWindow.isShowing()) {
            try {
                this.mPopupWindow.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public abstract void ensureMenuLoaded(View view, List<BdMenuItem> list);

    public BdMenuItem findItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int findItemIndex = findItemIndex(i2);
            if (findItemIndex > -1) {
                return this.mItems.get(findItemIndex);
            }
            return null;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public int findItemIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int size = this.mItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.mItems.get(i3).getItemId() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public abstract View getMenuView(Context context);

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mMenu : (View) invokeV.objValue;
    }

    public void notifyMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdMenuItem) == null) {
            ((OnMenuSetChangedListener) this.mMenu).onMenuItemUpdated(bdMenuItem);
        }
    }

    public void notifyMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ((OnMenuSetChangedListener) this.mMenu).onMenuSetChanged();
        }
    }

    public void removeAllItem() {
        List<BdMenuItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (list = this.mItems) == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            removeItemAt(size);
        }
    }

    public void removeItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            removeItemAt(findItemIndex(i2));
        }
    }

    public void removeItemAt(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 < 0 || i2 >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(i2);
    }

    public void setDismissOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mDismissOnClick = z;
        }
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onItemClickListener) == null) {
            this.mMenuItemClickListener = onItemClickListener;
        }
    }

    public void setMenuStateChangeListener(OnMenuStateChangeListener onMenuStateChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onMenuStateChangeListener) == null) {
            this.mStateChangeListener = onMenuStateChangeListener;
        }
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onKeyListener) == null) {
            this.mKeyClickListener = onKeyListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            OnMenuStateChangeListener onMenuStateChangeListener = this.mStateChangeListener;
            if (onMenuStateChangeListener != null) {
                onMenuStateChangeListener.onShowMenu();
            }
            ensureMenuLoaded(this.mMenu, this.mItems);
            dismiss();
            if (this.mPopupWindow == null) {
                PopupWindow popupWindow = new PopupWindow(this.mMenu, -2, -2, true);
                this.mPopupWindow = popupWindow;
                popupWindow.setBackgroundDrawable(this.mResources.getDrawable(ResUtils.drawable(this.mContext, "dxm_wallet_base_service_squared_item_bg")));
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(new d(this));
            }
            View view = this.mViewToAttach;
            if (view == null) {
                OnMenuStateChangeListener onMenuStateChangeListener2 = this.mStateChangeListener;
                if (onMenuStateChangeListener2 != null) {
                    onMenuStateChangeListener2.onDismissMenu();
                    return;
                }
                return;
            }
            view.post(new e(this));
            this.mMenu.postInvalidate();
        }
    }

    public abstract void showMenu(PopupWindow popupWindow);

    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null && popupWindow.isShowing()) {
                dismiss();
            } else {
                show();
            }
        }
    }

    public BdMenuItem add(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? addInternal(i2, this.mResources.getString(i3), null) : (BdMenuItem) invokeII.objValue;
    }

    public BdMenuItem add(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, charSequence, drawable)) == null) ? addInternal(i2, charSequence, drawable) : (BdMenuItem) invokeILL.objValue;
    }

    public BdMenuItem add(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4)) == null) ? addInternal(i2, this.mResources.getString(i3), this.mResources.getDrawable(i4)) : (BdMenuItem) invokeIII.objValue;
    }

    public BdMenuItem add(int i2, CharSequence charSequence, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, charSequence, str)) == null) ? addInternal1(i2, charSequence, str) : (BdMenuItem) invokeILL.objValue;
    }
}
