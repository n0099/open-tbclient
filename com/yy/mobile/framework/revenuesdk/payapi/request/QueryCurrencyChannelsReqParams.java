package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/QueryCurrencyChannelsReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "currencyType", "I", "getCurrencyType", "()I", "setCurrencyType", "(I)V", "", "usedChannelList", "Ljava/util/List;", "getUsedChannelList", "()Ljava/util/List;", "setUsedChannelList", "(Ljava/util/List;)V", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class QueryCurrencyChannelsReqParams extends RequestParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currencyType;
    public List<Integer> usedChannelList;

    public QueryCurrencyChannelsReqParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.usedChannelList = CollectionsKt__CollectionsKt.emptyList();
    }

    public final int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.currencyType : invokeV.intValue;
    }

    public final List<Integer> getUsedChannelList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.usedChannelList : (List) invokeV.objValue;
    }

    public final void setCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.currencyType = i2;
        }
    }

    public final void setUsedChannelList(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.usedChannelList = list;
        }
    }
}
