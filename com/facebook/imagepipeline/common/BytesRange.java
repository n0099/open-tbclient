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
/* loaded from: classes7.dex */
public class BytesRange {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
    @Nullable
    public static Pattern sHeaderParsingRegEx;
    public transient /* synthetic */ FieldHolder $fh;
    public final int from;
    public final int to;

    public BytesRange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.from = i;
        this.to = i2;
    }

    public static BytesRange from(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            return new BytesRange(i, Integer.MAX_VALUE);
        }
        return (BytesRange) invokeI.objValue;
    }

    public static BytesRange toMax(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            return new BytesRange(0, i);
        }
        return (BytesRange) invokeI.objValue;
    }

    public static String valueOrEmpty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return "";
            }
            return Integer.toString(i);
        }
        return (String) invokeI.objValue;
    }

    public boolean contains(@Nullable BytesRange bytesRange) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bytesRange)) == null) {
            if (bytesRange == null || this.from > bytesRange.from || this.to < bytesRange.to) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BytesRange)) {
                return false;
            }
            BytesRange bytesRange = (BytesRange) obj;
            if (this.from == bytesRange.from && this.to == bytesRange.to) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static BytesRange fromContentRangeHeader(@Nullable String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
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
                if (split.length == 4) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                Preconditions.checkArgument(split[0].equals("bytes"));
                int parseInt = Integer.parseInt(split[1]);
                int parseInt2 = Integer.parseInt(split[2]);
                int parseInt3 = Integer.parseInt(split[3]);
                if (parseInt2 > parseInt) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2);
                if (parseInt3 > parseInt2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3);
                if (parseInt2 < parseInt3 - 1) {
                    return new BytesRange(parseInt, parseInt2);
                }
                return new BytesRange(parseInt, Integer.MAX_VALUE);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format(null, "Invalid Content-Range header value: \"%s\"", str), e);
            }
        }
        return (BytesRange) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return HashCodeUtil.hashCode(this.from, this.to);
        }
        return invokeV.intValue;
    }

    public String toHttpRangeHeaderValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return String.format(null, "bytes=%s-%s", valueOrEmpty(this.from), valueOrEmpty(this.to));
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return String.format(null, "%s-%s", valueOrEmpty(this.from), valueOrEmpty(this.to));
        }
        return (String) invokeV.objValue;
    }
}
