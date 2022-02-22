package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.ObjectUtils;
/* loaded from: classes5.dex */
public class ToStringBuilder implements Builder<String> {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ToStringStyle defaultStyle;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuffer buffer;
    public final Object object;
    public final ToStringStyle style;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1454572133, "Lorg/apache/commons/lang3/builder/ToStringBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1454572133, "Lorg/apache/commons/lang3/builder/ToStringBuilder;");
                return;
            }
        }
        defaultStyle = ToStringStyle.DEFAULT_STYLE;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToStringBuilder(Object obj) {
        this(obj, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], (ToStringStyle) objArr2[1], (StringBuffer) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static ToStringStyle getDefaultStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? defaultStyle : (ToStringStyle) invokeV.objValue;
    }

    public static String reflectionToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? ReflectionToStringBuilder.toString(obj) : (String) invokeL.objValue;
    }

    public static void setDefaultStyle(ToStringStyle toStringStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, toStringStyle) == null) {
            if (toStringStyle != null) {
                defaultStyle = toStringStyle;
                return;
            }
            throw new IllegalArgumentException("The style must not be null");
        }
    }

    public ToStringBuilder append(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            this.style.append(this.buffer, (String) null, z);
            return this;
        }
        return (ToStringBuilder) invokeZ.objValue;
    }

    public ToStringBuilder appendAsObjectToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, obj)) == null) {
            ObjectUtils.identityToString(getStringBuffer(), obj);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder appendSuper(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            if (str != null) {
                this.style.appendSuper(this.buffer, str);
            }
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder appendToString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            if (str != null) {
                this.style.appendToString(this.buffer, str);
            }
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public Object getObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.object : invokeV.objValue;
    }

    public StringBuffer getStringBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.buffer : (StringBuffer) invokeV.objValue;
    }

    public ToStringStyle getStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.style : (ToStringStyle) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (getObject() == null) {
                getStringBuffer().append(getStyle().getNullText());
            } else {
                this.style.appendEnd(getStringBuffer(), getObject());
            }
            return getStringBuffer().toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        this(obj, toStringStyle, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, toStringStyle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], (ToStringStyle) objArr2[1], (StringBuffer) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, toStringStyle)) == null) ? ReflectionToStringBuilder.toString(obj, toStringStyle) : (String) invokeLL.objValue;
    }

    public ToStringBuilder append(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, zArr)) == null) {
            this.style.append(this.buffer, (String) null, zArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.builder.Builder
    public String build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? toString() : (String) invokeV.objValue;
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, toStringStyle, stringBuffer};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        toStringStyle = toStringStyle == null ? getDefaultStyle() : toStringStyle;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.buffer = stringBuffer;
        this.style = toStringStyle;
        this.object = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, obj, toStringStyle, z)) == null) ? ReflectionToStringBuilder.toString(obj, toStringStyle, z, false, null) : (String) invokeLLZ.objValue;
    }

    public ToStringBuilder append(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b2)) == null) {
            this.style.append(this.buffer, (String) null, b2);
            return this;
        }
        return (ToStringBuilder) invokeB.objValue;
    }

    public static <T> String reflectionToString(T t, ToStringStyle toStringStyle, boolean z, Class<? super T> cls) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{t, toStringStyle, Boolean.valueOf(z), cls})) == null) ? ReflectionToStringBuilder.toString(t, toStringStyle, z, false, cls) : (String) invokeCommon.objValue;
    }

    public ToStringBuilder append(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, bArr)) == null) {
            this.style.append(this.buffer, (String) null, bArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.style.append(this.buffer, (String) null, c2);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, cArr)) == null) {
            this.style.append(this.buffer, (String) null, cArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            this.style.append(this.buffer, (String) null, d2);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, dArr)) == null) {
            this.style.append(this.buffer, (String) null, dArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            this.style.append(this.buffer, (String) null, f2);
            return this;
        }
        return (ToStringBuilder) invokeF.objValue;
    }

    public ToStringBuilder append(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, fArr)) == null) {
            this.style.append(this.buffer, (String) null, fArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.style.append(this.buffer, (String) null, i2);
            return this;
        }
        return (ToStringBuilder) invokeI.objValue;
    }

    public ToStringBuilder append(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, iArr)) == null) {
            this.style.append(this.buffer, (String) null, iArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            this.style.append(this.buffer, (String) null, j2);
            return this;
        }
        return (ToStringBuilder) invokeJ.objValue;
    }

    public ToStringBuilder append(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, jArr)) == null) {
            this.style.append(this.buffer, (String) null, jArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            this.style.append(this.buffer, (String) null, obj, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, objArr)) == null) {
            this.style.append(this.buffer, (String) null, objArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Short.valueOf(s)})) == null) {
            this.style.append(this.buffer, (String) null, s);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(short[] sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, sArr)) == null) {
            this.style.append(this.buffer, (String) null, sArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeL.objValue;
    }

    public ToStringBuilder append(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            this.style.append(this.buffer, str, z);
            return this;
        }
        return (ToStringBuilder) invokeLZ.objValue;
    }

    public ToStringBuilder append(String str, boolean[] zArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, zArr)) == null) {
            this.style.append(this.buffer, str, zArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, boolean[] zArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048610, this, str, zArr, z)) == null) {
            this.style.append(this.buffer, str, zArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Byte.valueOf(b2)})) == null) {
            this.style.append(this.buffer, str, b2);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, bArr)) == null) {
            this.style.append(this.buffer, str, bArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, byte[] bArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048594, this, str, bArr, z)) == null) {
            this.style.append(this.buffer, str, bArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Character.valueOf(c2)})) == null) {
            this.style.append(this.buffer, str, c2);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(String str, char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, cArr)) == null) {
            this.style.append(this.buffer, str, cArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, char[] cArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048596, this, str, cArr, z)) == null) {
            this.style.append(this.buffer, str, cArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            this.style.append(this.buffer, str, d2);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(String str, double[] dArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, dArr)) == null) {
            this.style.append(this.buffer, str, dArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, double[] dArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048598, this, str, dArr, z)) == null) {
            this.style.append(this.buffer, str, dArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048586, this, str, f2)) == null) {
            this.style.append(this.buffer, str, f2);
            return this;
        }
        return (ToStringBuilder) invokeLF.objValue;
    }

    public ToStringBuilder append(String str, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, fArr)) == null) {
            this.style.append(this.buffer, str, fArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, float[] fArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048600, this, str, fArr, z)) == null) {
            this.style.append(this.buffer, str, fArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i2)) == null) {
            this.style.append(this.buffer, str, i2);
            return this;
        }
        return (ToStringBuilder) invokeLI.objValue;
    }

    public ToStringBuilder append(String str, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, iArr)) == null) {
            this.style.append(this.buffer, str, iArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, int[] iArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048602, this, str, iArr, z)) == null) {
            this.style.append(this.buffer, str, iArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048588, this, str, j2)) == null) {
            this.style.append(this.buffer, str, j2);
            return this;
        }
        return (ToStringBuilder) invokeLJ.objValue;
    }

    public ToStringBuilder append(String str, long[] jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, jArr)) == null) {
            this.style.append(this.buffer, str, jArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, long[] jArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048604, this, str, jArr, z)) == null) {
            this.style.append(this.buffer, str, jArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, obj)) == null) {
            this.style.append(this.buffer, str, obj, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, Object obj, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048590, this, str, obj, z)) == null) {
            this.style.append(this.buffer, str, obj, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, objArr)) == null) {
            this.style.append(this.buffer, str, objArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, Object[] objArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048606, this, str, objArr, z)) == null) {
            this.style.append(this.buffer, str, objArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }

    public ToStringBuilder append(String str, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{str, Short.valueOf(s)})) == null) {
            this.style.append(this.buffer, str, s);
            return this;
        }
        return (ToStringBuilder) invokeCommon.objValue;
    }

    public ToStringBuilder append(String str, short[] sArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, str, sArr)) == null) {
            this.style.append(this.buffer, str, sArr, (Boolean) null);
            return this;
        }
        return (ToStringBuilder) invokeLL.objValue;
    }

    public ToStringBuilder append(String str, short[] sArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048608, this, str, sArr, z)) == null) {
            this.style.append(this.buffer, str, sArr, Boolean.valueOf(z));
            return this;
        }
        return (ToStringBuilder) invokeLLZ.objValue;
    }
}
