package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.gamepaltform.GameRankListViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xj6 extends cd6<qr6, GameRankListViewHolder> implements go6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eo6 t;

    /* loaded from: classes7.dex */
    public class a implements GameRankHorizontalLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj6 a;

        public a(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj6Var;
        }

        @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.b
        public void a(pr6 pr6Var, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, pr6Var, i) == null) || pr6Var == null) {
                return;
            }
            if (this.a.t != null) {
                TiebaStatic.log(new StatisticItem("c12105").param("fid", this.a.t.c).param("obj_locate", i + 1));
            }
            if (StringUtils.isNull(pr6Var.c())) {
                return;
            }
            rl4.o(this.a.k.getPageActivity(), pr6Var.c());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xt4 k = xt4.k();
                k.y("game_rank_list_info", System.currentTimeMillis() + ",7");
                xt4.k().w("game_rank_list_show_times", 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921005));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new eo6();
    }

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (eo6) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: n0 */
    public GameRankListViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new GameRankListViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d036c, (ViewGroup) null)) : (GameRankListViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, qr6 qr6Var, GameRankListViewHolder gameRankListViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qr6Var, gameRankListViewHolder})) == null) {
            super.S(i, view2, viewGroup, qr6Var, gameRankListViewHolder);
            if (qr6Var == null) {
                return null;
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            if (this.t != null) {
                TiebaStatic.log(new StatisticItem("c12104").param("fid", this.t.c));
            }
            GameRankHorizontalLayout gameRankHorizontalLayout = gameRankListViewHolder.a;
            if (gameRankHorizontalLayout != null) {
                gameRankHorizontalLayout.setData(qr6Var);
                gameRankListViewHolder.a.setOnCardClickListener(new a(this));
            }
            TextView textView = gameRankListViewHolder.b;
            if (textView != null) {
                textView.setOnClickListener(new b(this));
            }
            this.k.getLayoutMode().k(this.n == 1);
            this.k.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
