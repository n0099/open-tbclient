package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import java.util.List;
/* loaded from: classes8.dex */
public class ProductListResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bubbleActMsg;
    public String currencyName;
    public int currencyType;
    public int defaultCid;
    public List payWayInfoList;
    public PaysSettingInfo paysSettingInfo;
    public List productInfoList;

    public ProductListResult(int i, String str, PaysSettingInfo paysSettingInfo, List list, List list2, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, paysSettingInfo, list, list2, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currencyType = i;
        this.productInfoList = list;
        this.payWayInfoList = list2;
        this.currencyName = str;
        this.paysSettingInfo = paysSettingInfo;
        this.defaultCid = i2;
        this.bubbleActMsg = str2;
    }

    public String getBubbleActMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bubbleActMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrencyName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.currencyName;
        }
        return (String) invokeV.objValue;
    }

    public int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.currencyType;
        }
        return invokeV.intValue;
    }

    public List getPayWayInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.payWayInfoList;
        }
        return (List) invokeV.objValue;
    }

    public PaysSettingInfo getPaysSettingInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.paysSettingInfo;
        }
        return (PaysSettingInfo) invokeV.objValue;
    }

    public List getProductInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.productInfoList;
        }
        return (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "ProductListResult{currencyType=" + this.currencyType + ", productInfoList=" + this.productInfoList + ", payWayInfoList=" + this.payWayInfoList + ", currencyName=" + this.currencyName + ", paysSettingInfo=" + this.paysSettingInfo + ", defaultCid=" + this.defaultCid + ", bubbleActMsg=" + this.bubbleActMsg + '}';
        }
        return (String) invokeV.objValue;
    }
}
