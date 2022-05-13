package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nj6 extends eo<p26, CardViewHolder<ww5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public ww5 j;
    public String k;
    public String l;
    public ux5 m;

    /* loaded from: classes6.dex */
    public class a extends ux5<p26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nj6 b;

        public a(nj6 nj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, p26 p26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p26Var) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 2).param("fid", this.b.k));
                this.b.b0(view2, p26Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nj6(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), p26.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = str;
        this.l = str2;
        this.i = tbPageContext;
    }

    public final void b0(View view2, p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, p26Var) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.i.getPageActivity()).createFromThreadCfg(p26Var.getThreadData(), null, fx5.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(p26Var.getThreadData().getFid()));
            createFromThreadCfg.setForumName(p26Var.getThreadData().getForum_name());
            createFromThreadCfg.setStartFrom(0);
            fx5.a(p26Var.getThreadData().getTid());
            this.i.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            ux5 ux5Var = this.m;
            if (ux5Var != null) {
                ux5Var.a(view2, p26Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public CardViewHolder<ww5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.j = new ww5(this.i, this.k, this.l);
            return new CardViewHolder<>(this.j);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, p26 p26Var, CardViewHolder<ww5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p26Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            cardViewHolder.c().l(p26Var);
            cardViewHolder.c().m(this.i, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.c().n(new a(this));
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(ux5 ux5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ux5Var) == null) {
            this.m = ux5Var;
        }
    }
}
