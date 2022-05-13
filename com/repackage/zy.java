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
/* loaded from: classes7.dex */
public class zy extends gy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zy(Context context) {
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

    @Override // com.repackage.zx
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }

    public final boolean s(zn4 zn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zn4Var)) == null) ? (zn4Var == null || zn4Var.getThreadData() == null || !zn4Var.getThreadData().isVideoThreadType() || zn4Var.getThreadData().getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean t(zn4 zn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zn4Var)) == null) ? (zn4Var == null || zn4Var.getThreadData() == null || zn4Var.getThreadData().getPollData() == null || zn4Var.getThreadData().getPollData().getOptions() == null || zn4Var.getThreadData().getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: u */
    public void a(zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zn4Var) == null) {
            if (!t(zn4Var) && !s(zn4Var) && zn4Var != null && zn4Var.getThreadData() != null && ((!ListUtils.isEmpty(zn4Var.getThreadData().getLinkDataList()) || ListUtils.getCount(zn4Var.getThreadData().getGoodsDataList()) > 1) && ((!ListUtils.isEmpty(zn4Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(zn4Var.getThreadData().getLinkDataList()) > 1) && ListUtils.getCount(zn4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(zn4Var.getThreadData().getGoodsDataList()) > 1))) {
                this.h.a(zn4Var.getThreadData().getLinkDataList(), zn4Var.getThreadData().getGoodsDataList());
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
