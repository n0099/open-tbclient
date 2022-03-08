package com.facebook.imagepipeline.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes7.dex */
public class BytesRange {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
    @Nullable
    public static Pattern sHeaderParsingRegEx;
    public transient /* synthetic */ FieldHolder $fh;
    public final int from;
    public final int to;

    public BytesRange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.from = i2;
        this.to = i3;
    }

    public static BytesRange from(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Preconditions.checkArgument(i2 >= 0);
            return new BytesRange(i2, Integer.MAX_VALUE);
        }
        return (BytesRange) invokeI.objValue;
    }

    @Nullable
    public static BytesRange fromContentRangeHeader(@Nullable String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (sHeaderParsingRegEx == null) {
                sHeaderParsingRegEx = Pattern.compile("[-/ ]");
            }
            try {
                String[] split = sHeaderParsingRegEx.split(str);
                Preconditions.checkArgument(split.length == 4);
                Preconditions.checkArgument(split[0].equals("bytes"));
                int parseInt = Integer.parseInt(split[1]);
                int parseInt2 = Integer.parseInt(split[2]);
                int parseInt3 = Integer.parseInt(split[3]);
                Preconditions.checkArgument(parseInt2 > parseInt);
                Preconditions.checkArgument(parseInt3 > parseInt2);
                if (parseInt2 < parseInt3 - 1) {
                    return new BytesRange(parseInt, parseInt2);
                }
                return new BytesRange(parseInt, Integer.MAX_VALUE);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException(String.format(null, "Invalid Content-Range header value: \"%s\"", str), e2);
            }
        }
        return (BytesRange) invokeL.objValue;
    }

    public static BytesRange toMax(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            Preconditions.checkArgument(i2 > 0);
            return new BytesRange(0, i2);
        }
        return (BytesRange) invokeI.objValue;
    }

    public static String valueOrEmpty(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == Integer.MAX_VALUE ? "" : Integer.toString(i2) : (String) invokeI.objValue;
    }

    public boolean contains(@Nullable BytesRange bytesRange) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bytesRange)) == null) ? bytesRange != null && this.from <= bytesRange.from && this.to >= bytesRange.to : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof BytesRange) {
                BytesRange bytesRange = (BytesRange) obj;
                return this.from == bytesRange.from && this.to == bytesRange.to;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? HashCodeUtil.hashCode(this.from, this.to) : invokeV.intValue;
    }

    public String toHttpRangeHeaderValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? String.format(null, "bytes=%s-%s", valueOrEmpty(this.from), valueOrEmpty(this.to)) : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.format(null, "%s-%s", valueOrEmpty(this.from), valueOrEmpty(this.to)) : (String) invokeV.objValue;
    }
}
