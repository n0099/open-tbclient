package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f00 extends xy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout h;
    public ItemCardView i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f00(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n(Boolean.TRUE);
    }

    @Override // com.repackage.qy
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.h == null) {
                FrameLayout frameLayout = new FrameLayout(this.b);
                this.h = frameLayout;
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0206);
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.h.removeAllViews();
            if (this.i == null) {
                ItemCardView itemCardView = new ItemCardView(this.b);
                this.i = itemCardView;
                itemCardView.setBackGroundColor(R.color.CAM_X0205);
                this.i.setIsShowRightBtn(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            layoutParams.bottomMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            this.h.addView(this.i, layoutParams);
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.gz
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0206);
            ItemCardView itemCardView = this.i;
            if (itemCardView != null) {
                itemCardView.G();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fz
    /* renamed from: s */
    public void a(pn4 pn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pn4Var) == null) {
            if (pn4Var != null && pn4Var.getThreadData() != null && pn4Var.getThreadData().originalThreadData != null && pn4Var.getThreadData().originalThreadData.C != null) {
                if (!pn4Var.getThreadData().originalThreadData.m && !pn4Var.getThreadData().shouldShowBlockedState()) {
                    this.h.setVisibility(0);
                    this.i.setData(pn4Var.getThreadData().originalThreadData.D, 13, pn4Var.getThreadData().originalThreadData.f);
                    return;
                }
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
