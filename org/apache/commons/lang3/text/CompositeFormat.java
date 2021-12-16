package org.apache.commons.lang3.text;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
/* loaded from: classes4.dex */
public class CompositeFormat extends Format {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4329119827877627683L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Format formatter;
    public final Format parser;

    public CompositeFormat(Format format, Format format2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {format, format2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parser = format;
        this.formatter = format2;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, stringBuffer, fieldPosition)) == null) ? this.formatter.format(obj, stringBuffer, fieldPosition) : (StringBuffer) invokeLLL.objValue;
    }

    public Format getFormatter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.formatter : (Format) invokeV.objValue;
    }

    public Format getParser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.parser : (Format) invokeV.objValue;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, parsePosition)) == null) ? this.parser.parseObject(str, parsePosition) : invokeLL.objValue;
    }

    public String reformat(String str) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? format(parseObject(str)) : (String) invokeL.objValue;
    }
}
