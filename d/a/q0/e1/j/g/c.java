package d.a.q0.e1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.a<d.a.q0.a0.e0.j, CardViewHolder<d.a.q0.a0.k>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.q0.a0.k p;
    public NEGFeedBackView.b q;
    public b0<d.a.q0.a0.e0.j> r;

    /* loaded from: classes8.dex */
    public class a extends b0<d.a.q0.a0.e0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f56231b;

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
            this.f56231b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                int i2 = 2;
                if (this.f56231b.p.x == view) {
                    i2 = 1;
                } else if (view == this.f56231b.p.p.getCommentContainer()) {
                    i2 = 5;
                } else if (view == this.f56231b.p.q.getCommentContainer() || ((this.f56231b.p.K() == null || view.getId() != this.f56231b.p.K().getId()) && (this.f56231b.p.L() == null || view.getId() != this.f56231b.p.L().getId()))) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    d.a.q0.e1.h.m.a.c(jVar.f54338e, this.f56231b.m, jVar.o(), i2);
                }
                d.a.q0.e1.j.c.d(view, jVar, this.f56231b.o);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.q = null;
        this.r = new a(this);
        this.n = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.q0.a0.k> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            d.a.q0.a0.k kVar = new d.a.q0.a0.k(this.n, this.m);
            this.p = kVar;
            kVar.z(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.p.T(bdUniqueId);
            }
            return new CardViewHolder<>(this.p);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.j jVar, CardViewHolder<d.a.q0.a0.k> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            jVar.I(jVar.position + 1);
            jVar.f54338e.P1 = jVar.o();
            d.a.q0.a0.k b2 = cardViewHolder.b();
            b2.V(i2 + 1);
            b2.l(jVar);
            b2.n(this.r);
            b2.y(this.q);
            d.a.q0.e1.h.m.a.f(jVar.f54338e, this.m, jVar.o());
            d.a.q0.e1.j.c.e(jVar, this.o);
            return cardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
