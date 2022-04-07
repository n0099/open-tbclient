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
public class l66 extends rw5<g66> {
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
        public final /* synthetic */ l66 a;

        public a(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l66Var;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(f66 f66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f66Var) == null) {
                l66 l66Var = this.a;
                l66Var.z(f66Var, l66Var.j);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(f66 f66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f66Var) == null) {
                this.a.y(f66Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RecommendForumItemView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l66 a;

        public b(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l66Var;
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(f66 f66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f66Var) == null) {
                l66 l66Var = this.a;
                l66Var.z(f66Var, l66Var.k);
            }
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(f66 f66Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f66Var) == null) {
                this.a.y(f66Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendForumItemView a;
        public final /* synthetic */ l66 b;

        public c(l66 l66Var, RecommendForumItemView recommendForumItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var, recommendForumItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l66Var;
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
    public l66(TbPageContext<?> tbPageContext) {
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

    public final void A(f66 f66Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, f66Var, str) == null) || f66Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(f66Var.h));
        statisticItem.param("fid", f66Var.b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View k = k();
            this.j = (RecommendForumItemView) k.findViewById(R.id.obfuscated_res_0x7f091a33);
            this.k = (RecommendForumItemView) k.findViewById(R.id.obfuscated_res_0x7f091a34);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: C */
    public void l(g66 g66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g66Var) == null) || g66Var == null) {
            return;
        }
        m(this.i, this.l);
        if (g66Var.a != null) {
            this.j.setVisibility(0);
            this.j.c(g66Var.a);
        } else {
            this.j.setVisibility(4);
        }
        if (g66Var.b != null) {
            this.k.setVisibility(0);
            this.k.c(g66Var.b);
            return;
        }
        this.k.setVisibility(4);
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d071c : invokeV.intValue;
    }

    @Override // com.repackage.rw5
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

    public final void y(f66 f66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, f66Var) == null) {
            this.i.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.i.getPageActivity()).createNormalCfg(f66Var.c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
            A(f66Var, "2");
        }
    }

    public final void z(f66 f66Var, RecommendForumItemView recommendForumItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f66Var, recommendForumItemView) == null) {
            if (!oi.C()) {
                UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0c18));
            } else if (f66Var == null || StringUtils.isNull(f66Var.c) || f66Var.b <= 0) {
            } else {
                if (!ViewHelper.checkUpIsLogin(getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.m == null) {
                    this.m = new LikeModel(this.i);
                }
                this.m.setLoadDataCallBack(new c(this, recommendForumItemView));
                if (ni.isForumName(f66Var.c)) {
                    this.m.P(f66Var.c, String.valueOf(f66Var.b));
                }
                A(f66Var, "1");
            }
        }
    }
}
