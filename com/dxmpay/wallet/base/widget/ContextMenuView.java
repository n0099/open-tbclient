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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import java.util.List;
/* loaded from: classes2.dex */
public class ContextMenuView extends BdContextMenuView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55882e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMenuItem f55883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContextMenuView f55884f;

        public a(ContextMenuView contextMenuView, BdMenuItem bdMenuItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contextMenuView, bdMenuItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55884f = contextMenuView;
            this.f55883e = bdMenuItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdMenuItem.OnItemClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f55883e.getOnClickListener()) == null) {
                return;
            }
            onClickListener.onClick(this.f55883e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public ContextMenuView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f55882e = 0;
    }

    public final View c(BdMenuItem bdMenuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bdMenuItem)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getMenuItemViewLayoutId()), (ViewGroup) this, false);
            TextView textView = (TextView) linearLayout.findViewById(ResUtils.id(getContext(), "title"));
            textView.setText(bdMenuItem.getTitle());
            textView.setTextColor(getResources().getColor(ResUtils.color(getContext(), "dxm_wallet_base_font_text1Color")));
            NetImageView netImageView = (NetImageView) linearLayout.findViewById(ResUtils.id(getContext(), "icon"));
            if (!TextUtils.isEmpty(bdMenuItem.getIconUrl())) {
                netImageView.setImageUrl(bdMenuItem.getIconUrl());
            } else {
                Drawable icon = bdMenuItem.getIcon();
                if (icon != null) {
                    netImageView.setImageDrawable(icon);
                }
            }
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
            linearLayout.setOnClickListener(new a(this, bdMenuItem));
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public int getMaxMenuItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55882e : invokeV.intValue;
    }

    @Override // com.dxmpay.wallet.base.widget.BdContextMenuView
    public String getMenuItemBackgroudResId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? "dxm_wallet_base_menu_bg_selector" : (String) invokeII.objValue;
    }

    @Override // com.dxmpay.wallet.base.widget.BdContextMenuView
    public String getMenuItemViewLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "dxm_wallet_base_menu_item_web_view" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.widget.BdContextMenuView
    public String getSeparatorResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "dxm_wallet_base_separateColor" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.widget.BdContextMenuView
    public void layoutMenu(List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || this.mMenuLoaded) {
            return;
        }
        removeAllViews();
        int size = list.size();
        if (size <= 0) {
            return;
        }
        Context context = getContext();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(context, 0.5f));
        for (int i2 = 0; i2 < size; i2++) {
            View c2 = c(list.get(i2));
            c2.measure(0, 0);
            if (this.f55882e < c2.getMeasuredWidth()) {
                int measuredWidth = c2.getMeasuredWidth();
                this.f55882e = measuredWidth;
                c2.setMinimumWidth(measuredWidth);
            }
            if (size == 1) {
                c2.setBackgroundDrawable(ResUtils.getDrawable(context, "dxm_wallet_base_one_menu_item_bg"));
                addView(c2);
                return;
            }
            if (i2 == 0) {
                c2.setBackgroundDrawable(ResUtils.getDrawable(context, "dxm_wallet_base_menu_first_item_bg"));
            } else if (i2 == size - 1) {
                c2.setBackgroundDrawable(ResUtils.getDrawable(context, "dxm_wallet_base_menu_last_item_bg"));
            } else {
                c2.setBackgroundDrawable(ResUtils.getDrawable(context, "wallet_base_menu_item_normal_bg"));
            }
            addView(c2);
            if (i2 < size - 1) {
                addView(createSeparator(context), layoutParams);
            }
        }
        this.mMenuLoaded = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenuView(Context context, AttributeSet attributeSet) {
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
        this.f55882e = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenuView(Context context) {
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
        this.f55882e = 0;
    }
}
