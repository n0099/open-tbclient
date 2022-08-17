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
public class f17 extends rw<fo4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageAlaRecommendLayout f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f17(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.repackage.rw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.ix
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

    public t06 p(fo4 fo4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fo4Var)) == null) {
            if (fo4Var instanceof k07) {
                k07 k07Var = (k07) fo4Var;
                return new t06(k07Var.getType(), k07Var.c(), "recommend");
            } else if (fo4Var instanceof sv6) {
                sv6 sv6Var = (sv6) fo4Var;
                return new t06(sv6Var.getType(), sv6Var.c(), ImageViewerConfig.FROM_CONCERN);
            } else {
                return new t06();
            }
        }
        return (t06) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hx
    /* renamed from: q */
    public void a(fo4 fo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fo4Var) == null) {
            this.f.setData(p(fo4Var));
        }
    }
}
