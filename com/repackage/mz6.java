package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mz6 extends qw<nn4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageAlaRecommendLayout f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mz6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.g = 3;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().b instanceof HomePageAlaRecommendLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().b.getParent() == null) {
            this.f = (HomePageAlaRecommendLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().b;
        } else {
            this.f = new HomePageAlaRecommendLayout(tbPageContext.getPageActivity());
        }
    }

    @Override // com.repackage.qw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.g != i) {
                this.f.c(i);
                n(this.f, 3);
            }
            this.g = i;
        }
    }

    public bz5 p(nn4 nn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nn4Var)) == null) {
            if (nn4Var instanceof ry6) {
                ry6 ry6Var = (ry6) nn4Var;
                return new bz5(ry6Var.getType(), ry6Var.c(), "recommend");
            } else if (nn4Var instanceof au6) {
                au6 au6Var = (au6) nn4Var;
                return new bz5(au6Var.getType(), au6Var.c(), ImageViewerConfig.FROM_CONCERN);
            } else {
                return new bz5();
            }
        }
        return (bz5) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: q */
    public void a(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nn4Var) == null) {
            this.f.setData(p(nn4Var));
        }
    }
}
