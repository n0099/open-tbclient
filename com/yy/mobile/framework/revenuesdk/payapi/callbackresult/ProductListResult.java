package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Keep
/* loaded from: classes8.dex */
public class ProductListResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String currencyName;
    public int currencyType;
    public int defaultCid;
    public List<PayWayInfo> payWayInfoList;
    public PaysSettingInfo paysSettingInfo;
    public List<ProductInfo> productInfoList;

    public ProductListResult(int i2, String str, PaysSettingInfo paysSettingInfo, List<ProductInfo> list, List<PayWayInfo> list2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, paysSettingInfo, list, list2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currencyType = i2;
        this.productInfoList = list;
        this.payWayInfoList = list2;
        this.currencyName = str;
        this.paysSettingInfo = paysSettingInfo;
        this.defaultCid = i3;
    }

    public String getCurrencyName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.currencyName : (String) invokeV.objValue;
    }

    public int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.currencyType : invokeV.intValue;
    }

    public List<PayWayInfo> getPayWayInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.payWayInfoList : (List) invokeV.objValue;
    }

    public PaysSettingInfo getPaysSettingInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.paysSettingInfo : (PaysSettingInfo) invokeV.objValue;
    }

    public List<ProductInfo> getProductInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.productInfoList : (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "ProductListResult{currencyType=" + this.currencyType + ", productInfoList=" + this.productInfoList + ", payWayInfoList=" + this.payWayInfoList + ", currencyName=" + this.currencyName + ", paysSettingInfo=" + this.paysSettingInfo + ", defaultCid=" + this.defaultCid + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
