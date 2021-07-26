package d.a.q0.u0.t1.b;

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
import d.a.q0.a0.b0;
import d.a.q0.a0.m;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.a<d.a.q0.g0.b, CardViewHolder<d.a.q0.a0.e>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public d.a.q0.a0.e n;
    public b0 o;
    public String p;

    /* loaded from: classes8.dex */
    public class a extends b0<d.a.q0.g0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f64461b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64461b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.g0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 3).param("fid", this.f64461b.p));
                this.f64461b.g0(view, bVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.a.q0.g0.b.f56829f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        this.p = str;
    }

    public final void g0(View view, d.a.q0.g0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, bVar) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(bVar.getThreadData(), null, m.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bVar.getThreadData().R()));
            createFromThreadCfg.setForumName(bVar.getThreadData().X());
            createFromThreadCfg.setStartFrom(0);
            m.a(bVar.getThreadData().o1());
            this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            b0 b0Var = this.o;
            if (b0Var != null) {
                b0Var.a(view, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.a.q0.a0.e> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.n = new d.a.q0.a0.e(this.m);
            return new CardViewHolder<>(this.n);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.g0.b bVar, CardViewHolder<d.a.q0.a0.e> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            cardViewHolder.b().l(bVar);
            cardViewHolder.b().m(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.b().n(new a(this));
            return cardViewHolder.b().k();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b0Var) == null) {
            this.o = b0Var;
        }
    }
}
