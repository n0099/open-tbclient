package d.a.q0.v.j.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.a<d.a.q0.v.j.d.f, CardViewHolder<d.a.q0.v.j.h.b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.v.j.d.f f65460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f65461f;

        public a(c cVar, d.a.q0.v.j.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65461f = cVar;
            this.f65460e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65461f.f0(this.f65460e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.q0.v.j.d.f.f65507f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
    }

    public final void f0(d.a.q0.v.j.d.f fVar) {
        d.a.q0.v.j.d.c c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null || (c2 = fVar.c()) == null || c2.b() == null) {
            return;
        }
        if (!c2.c()) {
            TiebaStatic.log("c11864");
        } else {
            TiebaStatic.log("c11857");
        }
        String p = d.a.p0.s.d0.b.j().p("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
        if (p == null) {
            return;
        }
        if (p.endsWith("/")) {
            p = p.substring(0, p.length() - 1);
        }
        d.a.p0.m.a.l(this.m.getPageActivity(), p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.q0.v.j.h.b> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new CardViewHolder<>(new d.a.q0.v.j.h.b(this.m)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.v.j.d.f fVar, CardViewHolder<d.a.q0.v.j.h.b> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            cardViewHolder.b().l(fVar);
            cardViewHolder.b().m(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.b().o.setOnClickListener(new a(this, fVar));
            return cardViewHolder.b().k();
        }
        return (View) invokeCommon.objValue;
    }
}
