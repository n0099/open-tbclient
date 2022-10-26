package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ExpandedProductParsedResult extends ParsedResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KILOGRAM = "KG";
    public static final String POUND = "LB";
    public transient /* synthetic */ FieldHolder $fh;
    public final String bestBeforeDate;
    public final String expirationDate;
    public final String lotNumber;
    public final String packagingDate;
    public final String price;
    public final String priceCurrency;
    public final String priceIncrement;
    public final String productID;
    public final String productionDate;
    public final String rawText;
    public final String sscc;
    public final Map uncommonAIs;
    public final String weight;
    public final String weightIncrement;
    public final String weightType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandedProductParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map map) {
        super(ParsedResultType.PRODUCT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ParsedResultType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rawText = str;
        this.productID = str2;
        this.sscc = str3;
        this.lotNumber = str4;
        this.productionDate = str5;
        this.packagingDate = str6;
        this.bestBeforeDate = str7;
        this.expirationDate = str8;
        this.weight = str9;
        this.weightType = str10;
        this.weightIncrement = str11;
        this.price = str12;
        this.priceIncrement = str13;
        this.priceCurrency = str14;
        this.uncommonAIs = map;
    }

    public static boolean equalsOrNull(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, obj2)) == null) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    public static int hashNotNull(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof ExpandedProductParsedResult)) {
                return false;
            }
            ExpandedProductParsedResult expandedProductParsedResult = (ExpandedProductParsedResult) obj;
            if (!equalsOrNull(this.productID, expandedProductParsedResult.productID) || !equalsOrNull(this.sscc, expandedProductParsedResult.sscc) || !equalsOrNull(this.lotNumber, expandedProductParsedResult.lotNumber) || !equalsOrNull(this.productionDate, expandedProductParsedResult.productionDate) || !equalsOrNull(this.bestBeforeDate, expandedProductParsedResult.bestBeforeDate) || !equalsOrNull(this.expirationDate, expandedProductParsedResult.expirationDate) || !equalsOrNull(this.weight, expandedProductParsedResult.weight) || !equalsOrNull(this.weightType, expandedProductParsedResult.weightType) || !equalsOrNull(this.weightIncrement, expandedProductParsedResult.weightIncrement) || !equalsOrNull(this.price, expandedProductParsedResult.price) || !equalsOrNull(this.priceIncrement, expandedProductParsedResult.priceIncrement) || !equalsOrNull(this.priceCurrency, expandedProductParsedResult.priceCurrency) || !equalsOrNull(this.uncommonAIs, expandedProductParsedResult.uncommonAIs)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String getBestBeforeDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bestBeforeDate;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return String.valueOf(this.rawText);
        }
        return (String) invokeV.objValue;
    }

    public String getExpirationDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.expirationDate;
        }
        return (String) invokeV.objValue;
    }

    public String getLotNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.lotNumber;
        }
        return (String) invokeV.objValue;
    }

    public String getPackagingDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.packagingDate;
        }
        return (String) invokeV.objValue;
    }

    public String getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.price;
        }
        return (String) invokeV.objValue;
    }

    public String getPriceCurrency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.priceCurrency;
        }
        return (String) invokeV.objValue;
    }

    public String getPriceIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.priceIncrement;
        }
        return (String) invokeV.objValue;
    }

    public String getProductID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.productID;
        }
        return (String) invokeV.objValue;
    }

    public String getProductionDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.productionDate;
        }
        return (String) invokeV.objValue;
    }

    public String getRawText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.rawText;
        }
        return (String) invokeV.objValue;
    }

    public String getSscc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.sscc;
        }
        return (String) invokeV.objValue;
    }

    public Map getUncommonAIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.uncommonAIs;
        }
        return (Map) invokeV.objValue;
    }

    public String getWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.weight;
        }
        return (String) invokeV.objValue;
    }

    public String getWeightIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.weightIncrement;
        }
        return (String) invokeV.objValue;
    }

    public String getWeightType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.weightType;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ((((((((((((hashNotNull(this.productID) ^ 0) ^ hashNotNull(this.sscc)) ^ hashNotNull(this.lotNumber)) ^ hashNotNull(this.productionDate)) ^ hashNotNull(this.bestBeforeDate)) ^ hashNotNull(this.expirationDate)) ^ hashNotNull(this.weight)) ^ hashNotNull(this.weightType)) ^ hashNotNull(this.weightIncrement)) ^ hashNotNull(this.price)) ^ hashNotNull(this.priceIncrement)) ^ hashNotNull(this.priceCurrency)) ^ hashNotNull(this.uncommonAIs);
        }
        return invokeV.intValue;
    }
}
