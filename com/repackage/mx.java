package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mx extends tw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mx(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().n instanceof MultiLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().n.getParent() == null) {
            this.h = (MultiLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().n;
        } else {
            this.h = new MultiLinkCardView(context);
        }
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // com.repackage.mw
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }

    public final boolean s(om4 om4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, om4Var)) == null) ? (om4Var == null || om4Var.getThreadData() == null || !om4Var.getThreadData().isVideoThreadType() || om4Var.getThreadData().getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean t(om4 om4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, om4Var)) == null) ? (om4Var == null || om4Var.getThreadData() == null || om4Var.getThreadData().getPollData() == null || om4Var.getThreadData().getPollData().getOptions() == null || om4Var.getThreadData().getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bx
    /* renamed from: u */
    public void a(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, om4Var) == null) {
            if (!t(om4Var) && !s(om4Var) && om4Var != null && om4Var.getThreadData() != null && ((!ListUtils.isEmpty(om4Var.getThreadData().getLinkDataList()) || ListUtils.getCount(om4Var.getThreadData().getGoodsDataList()) > 1) && ((!ListUtils.isEmpty(om4Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(om4Var.getThreadData().getLinkDataList()) > 1) && ListUtils.getCount(om4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(om4Var.getThreadData().getGoodsDataList()) > 1))) {
                this.h.a(om4Var.getThreadData().getLinkDataList(), om4Var.getThreadData().getGoodsDataList());
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
