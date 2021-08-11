package org.aspectj.runtime.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class Conversions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Conversions() {
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

    public static Object booleanObject(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) ? new Boolean(z) : invokeZ.objValue;
    }

    public static boolean booleanValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to boolean");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.booleanValue;
    }

    public static Object byteObject(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65539, null, b2)) == null) ? new Byte(b2) : invokeB.objValue;
    }

    public static byte byteValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj == null) {
                return (byte) 0;
            }
            if (obj instanceof Number) {
                return ((Number) obj).byteValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to byte");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.byteValue;
    }

    public static Object charObject(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Character.valueOf(c2)})) == null) ? new Character(c2) : invokeCommon.objValue;
    }

    public static char charValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) {
            if (obj == null) {
                return (char) 0;
            }
            if (obj instanceof Character) {
                return ((Character) obj).charValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to char");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.charValue;
    }

    public static Object doubleObject(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2)})) == null) ? new Double(d2) : invokeCommon.objValue;
    }

    public static double doubleValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            if (obj == null) {
                return 0.0d;
            }
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to double");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.doubleValue;
    }

    public static Object floatObject(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f2)) == null) ? new Float(f2) : invokeF.objValue;
    }

    public static float floatValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) {
            if (obj == null) {
                return 0.0f;
            }
            if (obj instanceof Number) {
                return ((Number) obj).floatValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to float");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.floatValue;
    }

    public static Object intObject(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? new Integer(i2) : invokeI.objValue;
    }

    public static int intValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) {
            if (obj == null) {
                return 0;
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to int");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.intValue;
    }

    public static Object longObject(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j2)) == null) ? new Long(j2) : invokeJ.objValue;
    }

    public static long longValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, obj)) == null) {
            if (obj == null) {
                return 0L;
            }
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to long");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.longValue;
    }

    public static Object shortObject(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Short.valueOf(s)})) == null) ? new Short(s) : invokeCommon.objValue;
    }

    public static short shortValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, obj)) == null) {
            if (obj == null) {
                return (short) 0;
            }
            if (obj instanceof Number) {
                return ((Number) obj).shortValue();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(" can not be converted to short");
            throw new ClassCastException(stringBuffer.toString());
        }
        return invokeL.shortValue;
    }

    public static Object voidObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    public static Object voidValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, obj)) == null) {
            if (obj == null) {
            }
            return obj;
        }
        return invokeL.objValue;
    }
}
