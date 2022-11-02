package org.aspectj.runtime.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class Conversions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public Conversions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object booleanObject(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            return new Boolean(z);
        }
        return invokeZ.objValue;
    }

    public static Object byteObject(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65539, null, b)) == null) {
            return new Byte(b);
        }
        return invokeB.objValue;
    }

    public static Object charObject(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c)})) == null) {
            return new Character(c);
        }
        return invokeCommon.objValue;
    }

    public static Object doubleObject(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d)})) == null) {
            return new Double(d);
        }
        return invokeCommon.objValue;
    }

    public static Object floatObject(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f)) == null) {
            return new Float(f);
        }
        return invokeF.objValue;
    }

    public static Object intObject(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            return new Integer(i);
        }
        return invokeI.objValue;
    }

    public static Object longObject(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j)) == null) {
            return new Long(j);
        }
        return invokeJ.objValue;
    }

    public static Object shortObject(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Short.valueOf(s)})) == null) {
            return new Short(s);
        }
        return invokeCommon.objValue;
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

    public static char charValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
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
}
