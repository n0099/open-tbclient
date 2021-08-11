package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class VINParsedResult extends ParsedResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String countryCode;
    public final int modelYear;
    public final char plantCode;
    public final String sequentialNumber;
    public final String vehicleAttributes;
    public final String vehicleDescriptorSection;
    public final String vehicleIdentifierSection;
    public final String vin;
    public final String worldManufacturerID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VINParsedResult(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(ParsedResultType.VIN);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, Integer.valueOf(i2), Character.valueOf(c2), str7};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((ParsedResultType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i2;
        this.plantCode = c2;
        this.sequentialNumber = str7;
    }

    public String getCountryCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.countryCode : (String) invokeV.objValue;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder(50);
            sb.append(this.worldManufacturerID);
            sb.append(' ');
            sb.append(this.vehicleDescriptorSection);
            sb.append(' ');
            sb.append(this.vehicleIdentifierSection);
            sb.append('\n');
            String str = this.countryCode;
            if (str != null) {
                sb.append(str);
                sb.append(' ');
            }
            sb.append(this.modelYear);
            sb.append(' ');
            sb.append(this.plantCode);
            sb.append(' ');
            sb.append(this.sequentialNumber);
            sb.append('\n');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int getModelYear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.modelYear : invokeV.intValue;
    }

    public char getPlantCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.plantCode : invokeV.charValue;
    }

    public String getSequentialNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sequentialNumber : (String) invokeV.objValue;
    }

    public String getVIN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.vin : (String) invokeV.objValue;
    }

    public String getVehicleAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.vehicleAttributes : (String) invokeV.objValue;
    }

    public String getVehicleDescriptorSection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.vehicleDescriptorSection : (String) invokeV.objValue;
    }

    public String getVehicleIdentifierSection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.vehicleIdentifierSection : (String) invokeV.objValue;
    }

    public String getWorldManufacturerID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.worldManufacturerID : (String) invokeV.objValue;
    }
}
