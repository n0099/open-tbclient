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
/* loaded from: classes5.dex */
public class bk6 extends an<z26, CardViewHolder<mx5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public mx5 j;
    public jy5 k;
    public String l;

    /* loaded from: classes5.dex */
    public class a extends jy5<z26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk6 b;

        public a(bk6 bk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, z26 z26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z26Var) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 3).param("fid", this.b.l));
                this.b.b0(view2, z26Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk6(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), z26.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.i = tbPageContext;
        this.l = str;
    }

    public final void b0(View view2, z26 z26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, z26Var) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.i.getPageActivity()).createFromThreadCfg(z26Var.getThreadData(), null, ux5.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(z26Var.getThreadData().getFid()));
            createFromThreadCfg.setForumName(z26Var.getThreadData().getForum_name());
            createFromThreadCfg.setStartFrom(0);
            ux5.a(z26Var.getThreadData().getTid());
            this.i.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            jy5 jy5Var = this.k;
            if (jy5Var != null) {
                jy5Var.a(view2, z26Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public CardViewHolder<mx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.j = new mx5(this.i);
            return new CardViewHolder<>(this.j);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, z26 z26Var, CardViewHolder<mx5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z26Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            cardViewHolder.c().i(z26Var);
            cardViewHolder.c().j(this.i, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.c().n(new a(this));
            return cardViewHolder.c().h();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(jy5 jy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jy5Var) == null) {
            this.k = jy5Var;
        }
    }
}
