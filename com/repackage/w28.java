package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.AutoBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class w28 extends uw5<p28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public LinearLayout j;
    public AutoBannerView k;
    public View l;
    public os4<a28> m;

    /* loaded from: classes7.dex */
    public class a implements os4<a28> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w28 a;

        public a(w28 w28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w28Var;
        }

        @Override // com.repackage.os4
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || this.a.k == null || str == null) {
                return;
            }
            if (this.a.k.a(i)) {
                TiebaStatic.log(new StatisticItem("c13247").param("obj_locate", i).param("obj_param1", str));
            }
            this.a.k.f();
            this.a.k.b(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.os4
        /* renamed from: c */
        public void a(int i, a28 a28Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, a28Var) == null) || this.a.k == null || a28Var == null || a28Var.c() == null || !this.a.k.a(i)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13246").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i).param("obj_param1", a28Var.c()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w28(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.m = new a(this);
        View k = k();
        this.j = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f092412);
        AutoBannerView autoBannerView = (AutoBannerView) k.findViewById(R.id.obfuscated_res_0x7f0917a2);
        this.k = autoBannerView;
        autoBannerView.setMarqueenTime(3000L);
        this.k.getCoverFlowView().setCallback(this.m);
        this.l = k.findViewById(R.id.obfuscated_res_0x7f090386);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06ab : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        AutoBannerView autoBannerView = this.k;
        if (autoBannerView != null) {
            autoBannerView.e(i);
        }
        SkinManager.setBackgroundColor(k(), R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: t */
    public void l(p28 p28Var) {
        List<a28> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p28Var) == null) {
            m(this.b, TbadkCoreApplication.getInst().getSkinType());
            if (this.j == null || p28Var == null || (list = p28Var.a) == null || this.k == null || list.size() == 0) {
                return;
            }
            this.k.d(p28Var.a);
        }
    }
}
