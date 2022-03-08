package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class StandardToStringStyle extends ToStringStyle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public StandardToStringStyle() {
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

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getArrayEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.getArrayEnd() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getArraySeparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.getArraySeparator() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getArrayStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.getArrayStart() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getContentEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.getContentEnd() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getContentStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getContentStart() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getFieldNameValueSeparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.getFieldNameValueSeparator() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getFieldSeparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.getFieldSeparator() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getNullText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.getNullText() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getSizeEndText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.getSizeEndText() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getSizeStartText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? super.getSizeStartText() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getSummaryObjectEndText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? super.getSummaryObjectEndText() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public String getSummaryObjectStartText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? super.getSummaryObjectStartText() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isArrayContentDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? super.isArrayContentDetail() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isDefaultFullDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? super.isDefaultFullDetail() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isFieldSeparatorAtEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? super.isFieldSeparatorAtEnd() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isFieldSeparatorAtStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.isFieldSeparatorAtStart() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isUseClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? super.isUseClassName() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isUseFieldNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? super.isUseFieldNames() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isUseIdentityHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? super.isUseIdentityHashCode() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public boolean isUseShortClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? super.isUseShortClassName() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setArrayContentDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.setArrayContentDetail(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setArrayEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            super.setArrayEnd(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setArraySeparator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            super.setArraySeparator(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setArrayStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            super.setArrayStart(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setContentEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            super.setContentEnd(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setContentStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            super.setContentStart(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setDefaultFullDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            super.setDefaultFullDetail(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setFieldNameValueSeparator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            super.setFieldNameValueSeparator(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setFieldSeparator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            super.setFieldSeparator(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setFieldSeparatorAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            super.setFieldSeparatorAtEnd(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setFieldSeparatorAtStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            super.setFieldSeparatorAtStart(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setNullText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            super.setNullText(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setSizeEndText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            super.setSizeEndText(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setSizeStartText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            super.setSizeStartText(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setSummaryObjectEndText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            super.setSummaryObjectEndText(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setSummaryObjectStartText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            super.setSummaryObjectStartText(str);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setUseClassName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            super.setUseClassName(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setUseFieldNames(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.setUseFieldNames(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setUseIdentityHashCode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.setUseIdentityHashCode(z);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void setUseShortClassName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            super.setUseShortClassName(z);
        }
    }
}
