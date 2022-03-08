package com.dxmpay.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import java.util.List;
/* loaded from: classes7.dex */
public class BdContextMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mMenuLoaded;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMenuItem f52440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BdContextMenuView f52441f;

        public a(BdContextMenuView bdContextMenuView, BdMenuItem bdMenuItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdContextMenuView, bdMenuItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52441f = bdContextMenuView;
            this.f52440e = bdMenuItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdMenuItem.OnItemClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f52440e.getOnClickListener()) == null) {
                return;
            }
            onClickListener.onClick(this.f52440e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        b();
    }

    public final View a(BdMenuItem bdMenuItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdMenuItem, str)) == null) {
            Context context = getContext();
            TextView textView = (TextView) LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), getMenuItemViewLayoutId()), (ViewGroup) this, false);
            textView.setText(bdMenuItem.getTitle());
            textView.setTextColor(getResources().getColor(ResUtils.color(getContext(), "dxm_wallet_base_font_text1Color")));
            textView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_menu_item_bg_selector"));
            Drawable icon = bdMenuItem.getIcon();
            if (icon != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setOnClickListener(new a(this, bdMenuItem));
            if (!TextUtils.isEmpty(str)) {
                int paddingBottom = textView.getPaddingBottom();
                int paddingTop = textView.getPaddingTop();
                int paddingRight = textView.getPaddingRight();
                int paddingLeft = textView.getPaddingLeft();
                textView.setBackgroundResource(ResUtils.drawable(context, str));
                textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            return textView;
        }
        return (View) invokeLL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
            setGravity(17);
            setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    public View createSeparator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            View view = new View(context);
            view.setBackgroundResource(ResUtils.color(context, getSeparatorResId()));
            return view;
        }
        return (View) invokeL.objValue;
    }

    public String getBackgroundResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "dxm_wallet_base_menu_bg_white_corner" : (String) invokeV.objValue;
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            return null;
        }
        return (String) invokeII.objValue;
    }

    public String getMenuItemViewLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "dxm_wallet_base_menu_item_view" : (String) invokeV.objValue;
    }

    public String getSeparatorResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "dxm_wallet_base_menu_item_separateColor" : (String) invokeV.objValue;
    }

    public void layoutMenu(List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || this.mMenuLoaded) {
            return;
        }
        removeAllViews();
        int size = list.size();
        if (size <= 0) {
            return;
        }
        Context context = getContext();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(ResUtils.dimen(getContext(), "dxm_wallet_menu_item_width")), 2);
        for (int i2 = 0; i2 < size; i2++) {
            addView(a(list.get(i2), getMenuItemBackgroudResId(i2, size)));
            if (i2 < size - 1) {
                addView(createSeparator(context), layoutParams);
            }
        }
        this.mMenuLoaded = true;
    }

    @Override // com.dxmpay.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdMenuItem) == null) {
        }
    }

    @Override // com.dxmpay.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mMenuLoaded = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        b();
    }
}
