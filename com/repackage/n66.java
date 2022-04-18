package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n66 extends tw5<i66> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public RecommendForumItemView j;
    public RecommendForumItemView k;
    public int l;
    public LikeModel m;

    /* loaded from: classes6.dex */
    public class a implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n66 a;

        public a(n66 n66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n66Var;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(h66 h66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h66Var) == null) {
                n66 n66Var = this.a;
                n66Var.z(h66Var, n66Var.j);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(h66 h66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h66Var) == null) {
                this.a.y(h66Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n66 a;

        public b(n66 n66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n66Var;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(h66 h66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h66Var) == null) {
                n66 n66Var = this.a;
                n66Var.z(h66Var, n66Var.k);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(h66 h66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h66Var) == null) {
                this.a.y(h66Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumItemView a;
        public final /* synthetic */ n66 b;

        public c(n66 n66Var, RecommendForumItemView recommendForumItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n66Var, recommendForumItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n66Var;
            this.a = recommendForumItemView;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.b.m.getErrorCode() == 22) {
                    oi.N(this.b.i.getPageActivity(), this.b.i.getString(R.string.obfuscated_res_0x7f0f0803));
                } else if (obj == null) {
                } else {
                    if (this.b.m.getErrorCode() != 0) {
                        oi.N(this.b.i.getPageActivity(), this.b.m.getErrorString());
                        return;
                    }
                    if (this.a == this.b.j) {
                        this.b.j.e(true);
                    } else {
                        this.b.k.e(true);
                    }
                    oi.N(this.b.i.getPageActivity(), this.b.i.getString(R.string.obfuscated_res_0x7f0f02ac));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n66(TbPageContext<?> tbPageContext) {
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
        this.l = 3;
        this.i = tbPageContext;
        B();
        this.j.setForumItemClickListener(new a(this));
        this.k.setForumItemClickListener(new b(this));
    }

    public final void A(h66 h66Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, h66Var, str) == null) || h66Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(h66Var.h));
        statisticItem.param("fid", h66Var.b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View k = k();
            this.j = (RecommendForumItemView) k.findViewById(R.id.obfuscated_res_0x7f091a34);
            this.k = (RecommendForumItemView) k.findViewById(R.id.obfuscated_res_0x7f091a35);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: C */
    public void l(i66 i66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i66Var) == null) || i66Var == null) {
            return;
        }
        m(this.i, this.l);
        if (i66Var.a != null) {
            this.j.setVisibility(0);
            this.j.c(i66Var.a);
        } else {
            this.j.setVisibility(4);
        }
        if (i66Var.b != null) {
            this.k.setVisibility(0);
            this.k.c(i66Var.b);
            return;
        }
        this.k.setVisibility(4);
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d071c : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            this.l = i;
            this.j.d();
            this.k.d();
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    public final void y(h66 h66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h66Var) == null) {
            this.i.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.i.getPageActivity()).createNormalCfg(h66Var.c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
            A(h66Var, "2");
        }
    }

    public final void z(h66 h66Var, RecommendForumItemView recommendForumItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h66Var, recommendForumItemView) == null) {
            if (!oi.C()) {
                UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c17));
            } else if (h66Var == null || StringUtils.isNull(h66Var.c) || h66Var.b <= 0) {
            } else {
                if (!ViewHelper.checkUpIsLogin(getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.m == null) {
                    this.m = new LikeModel(this.i);
                }
                this.m.setLoadDataCallBack(new c(this, recommendForumItemView));
                if (ni.isForumName(h66Var.c)) {
                    this.m.P(h66Var.c, String.valueOf(h66Var.b));
                }
                A(h66Var, "1");
            }
        }
    }
}
