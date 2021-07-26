package d.a.q0.e1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.l0;
/* loaded from: classes8.dex */
public class z extends d.a.d.k.e.a<d.a.q0.e1.c.f.c, ThreadCardViewHolder<d.a.q0.e1.c.f.c>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public BdUniqueId n;
    public d.a.d.k.e.s o;
    public String p;
    public byte q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Byte.valueOf(b2)};
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
        this.q = b2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<d.a.q0.e1.c.f.c> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.m.getPageActivity(), false);
            bVar.n(new d.a.q0.e1.c.h.b(this.m, this.n, this.q));
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().g(0);
            ThreadCardViewHolder<d.a.q0.e1.c.f.c> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
            threadCardViewHolder.j(this.n);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.e1.c.f.c cVar, ThreadCardViewHolder<d.a.q0.e1.c.f.c> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, threadCardViewHolder})) == null) {
            threadCardViewHolder.f(cVar);
            if (threadCardViewHolder.b() != null) {
                threadCardViewHolder.b().q(i2);
                threadCardViewHolder.b().setPage(this.p);
                threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            }
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }

    public void g0(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
