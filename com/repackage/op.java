package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad7;
import java.util.Map;
/* loaded from: classes6.dex */
public class op extends BaseCardInfo implements ad7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pp a;
    public ICardInfo b;
    public rp c;
    public AdvertAppInfo d;

    public op() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BdUniqueId.gen();
    }

    public pp e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (pp) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            rp rpVar = this.c;
            if (rpVar != null) {
                return rpVar.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ad7
    public ad7.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ICardInfo iCardInfo = this.b;
            if (iCardInfo == null || !(iCardInfo instanceof ad7)) {
                return null;
            }
            return ((ad7) iCardInfo).getParallelCharge();
        }
        return (ad7.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.uo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (i() != null) {
                return np.b;
            }
            return np.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public ICardInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (ICardInfo) invokeV.objValue;
    }

    public AdvertAppInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.d == null) {
                this.d = new AdvertAppInfo();
                rp rpVar = this.c;
                if (rpVar != null) {
                    Map<String, String> c = rpVar.c();
                    this.d.g = String.valueOf(this.c.a());
                    this.d.tid = c != null ? c.get("thread_id") : "";
                    this.d.setFid(c != null ? Long.valueOf(c.get("forum_id")).longValue() : 0L);
                }
                AdvertAppInfo advertAppInfo = this.d;
                pp ppVar = this.a;
                advertAppInfo.h = ppVar != null ? ppVar.a : "";
                this.d.k = "VIDEO_LIST";
            }
            return this.d;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }
}
