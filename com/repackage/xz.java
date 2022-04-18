package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xz extends xy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().m instanceof SingleLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().m.getParent() == null) {
            this.h = (SingleLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().m;
        } else {
            this.h = new SingleLinkCardView(context);
        }
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // com.repackage.qy
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.repackage.gz
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }

    public final boolean s(pn4 pn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pn4Var)) == null) ? (pn4Var == null || pn4Var.getThreadData() == null || !pn4Var.getThreadData().isVideoThreadType() || pn4Var.getThreadData().getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean t(pn4 pn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pn4Var)) == null) ? (pn4Var == null || pn4Var.getThreadData() == null || pn4Var.getThreadData().getPollData() == null || pn4Var.getThreadData().getPollData().getOptions() == null || pn4Var.getThreadData().getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fz
    /* renamed from: u */
    public void a(pn4 pn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pn4Var) == null) {
            if (!t(pn4Var) && pn4Var != null && pn4Var.getThreadData() != null && !s(pn4Var) && ((!ListUtils.isEmpty(pn4Var.getThreadData().getLinkDataList()) || ListUtils.getCount(pn4Var.getThreadData().getGoodsDataList()) == 1) && ((!ListUtils.isEmpty(pn4Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(pn4Var.getThreadData().getLinkDataList()) == 1) && ListUtils.getCount(pn4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(pn4Var.getThreadData().getGoodsDataList()) == 1))) {
                if (pn4Var.getThreadData().getLinkDataList().size() >= 1) {
                    this.h.a((yx5) ListUtils.getItem(pn4Var.getThreadData().getLinkDataList(), 0));
                } else if (pn4Var.getThreadData().getGoodsDataList().size() >= 1) {
                    this.h.a((yx5) ListUtils.getItem(pn4Var.getThreadData().getGoodsDataList(), 0));
                }
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
