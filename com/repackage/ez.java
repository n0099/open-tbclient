package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ez extends gy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendInfoLayout h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez(Context context) {
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
        int f = mi.f(context, R.dimen.M_H_X003);
        int f2 = mi.f(context, HomeGroupUbsUIHelper.handleDimen(R.dimen.tbds21, R.dimen.tbds0));
        r(f);
        q(f2);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().s instanceof RecommendInfoLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().s.getParent() == null) {
            this.h = (RecommendInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().s;
        } else {
            this.h = new RecommendInfoLayout(context);
        }
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

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (UbsABTestHelper.showNewUI()) {
                int f = mi.f(this.b, R.dimen.M_H_X003);
                int f2 = mi.f(this.b, HomeGroupUbsUIHelper.handleDimen(R.dimen.tbds21, R.dimen.tbds0));
                r(f);
                q(f2);
                return;
            }
            int f3 = mi.f(this.b, R.dimen.tbds10);
            r(f3);
            q(0);
            u(this.h, f3, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: t */
    public void a(zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zn4Var) == null) {
            this.h.setData(zn4Var);
        }
    }

    public void u(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048581, this, view2, i, i2) == null) && view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin == i && marginLayoutParams.bottomMargin == i2) {
                return;
            }
            marginLayoutParams.topMargin = i;
            marginLayoutParams.bottomMargin = i2;
            view2.setLayoutParams(marginLayoutParams);
        }
    }
}
