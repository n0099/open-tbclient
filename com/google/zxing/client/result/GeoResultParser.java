package com.google.zxing.client.result;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class GeoResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern GEO_URL_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1460536099, "Lcom/google/zxing/client/result/GeoResultParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1460536099, "Lcom/google/zxing/client/result/GeoResultParser;");
                return;
            }
        }
        GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
    }

    public GeoResultParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public GeoParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            Matcher matcher = GEO_URL_PATTERN.matcher(ResultParser.getMassagedText(result));
            if (matcher.matches()) {
                String group = matcher.group(4);
                try {
                    double parseDouble = Double.parseDouble(matcher.group(1));
                    if (parseDouble <= 90.0d && parseDouble >= -90.0d) {
                        double parseDouble2 = Double.parseDouble(matcher.group(2));
                        if (parseDouble2 <= 180.0d && parseDouble2 >= -180.0d) {
                            double d = 0.0d;
                            if (matcher.group(3) != null) {
                                double parseDouble3 = Double.parseDouble(matcher.group(3));
                                if (parseDouble3 < 0.0d) {
                                    return null;
                                }
                                d = parseDouble3;
                            }
                            return new GeoParsedResult(parseDouble, parseDouble2, d, group);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                return null;
            }
            return null;
        }
        return (GeoParsedResult) invokeL.objValue;
    }
}
