package d.a.q0.u0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class a1 implements m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.u0.m0
    public d.a.d.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, tbPageContext, bdUniqueId, z)) == null) ? new d.a.q0.u0.m1.d.b0(tbPageContext, b2.N3, bdUniqueId, z) : (d.a.d.k.e.a) invokeLLZ.objValue;
    }

    @Override // d.a.q0.u0.m0
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, bdUniqueId2)) == null) ? new d.a.q0.u0.b2.a(tbPageContext, bdUniqueId, bdUniqueId2) : (k) invokeLLL.objValue;
    }

    @Override // d.a.q0.u0.m0
    public d.a.d.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)})) == null) {
            if (bdUniqueId == d.a.q0.h3.x.U3) {
                return new d.a.q0.u0.m1.d.d(tbPageContext, bdUniqueId, z);
            }
            if (bdUniqueId == b2.N3) {
                return new d.a.q0.u0.m1.d.c0(tbPageContext, bdUniqueId, bdUniqueId2, z);
            }
            throw new IllegalArgumentException("Unsupported adapter type.");
        }
        return (d.a.d.k.e.a) invokeCommon.objValue;
    }

    @Override // d.a.q0.u0.m0
    public d.a.d.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, tbPageContext, bdUniqueId, bdUniqueId2)) == null) {
            if (bdUniqueId == b2.O3) {
                return new d.a.q0.u0.m1.d.f(tbPageContext, bdUniqueId, bdUniqueId2);
            }
            throw new IllegalArgumentException("Unsupported adapter type.");
        }
        return (d.a.d.k.e.a) invokeLLL.objValue;
    }
}
