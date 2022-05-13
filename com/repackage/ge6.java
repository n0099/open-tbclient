package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ge6 implements sd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ge6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.sd6
    public eo<? extends br4, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, tbPageContext, bdUniqueId, z)) == null) ? new jh6(tbPageContext, ThreadData.TYPE_STAR_INTERVIEW, bdUniqueId, z) : (eo) invokeLLZ.objValue;
    }

    @Override // com.repackage.sd6
    public pc6<ICardInfo, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, bdUniqueId2)) == null) ? new wl6(tbPageContext, bdUniqueId, bdUniqueId2) : (pc6) invokeLLL.objValue;
    }

    @Override // com.repackage.sd6
    public eo<? extends ThreadData, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)})) == null) {
            if (bdUniqueId == bj8.d) {
                return new lg6(tbPageContext, bdUniqueId, z);
            }
            if (bdUniqueId == ThreadData.TYPE_STAR_INTERVIEW) {
                return new kh6(tbPageContext, bdUniqueId, bdUniqueId2, z);
            }
            throw new IllegalArgumentException("Unsupported adapter type.");
        }
        return (eo) invokeCommon.objValue;
    }

    @Override // com.repackage.sd6
    public eo<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, tbPageContext, bdUniqueId, bdUniqueId2)) == null) {
            if (bdUniqueId == ThreadData.TYPE_LOTTERY) {
                return new ng6(tbPageContext, bdUniqueId, bdUniqueId2);
            }
            throw new IllegalArgumentException("Unsupported adapter type.");
        }
        return (eo) invokeLLL.objValue;
    }
}
