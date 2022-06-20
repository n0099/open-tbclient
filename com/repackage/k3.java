package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes6.dex */
public class k3 {
    public static /* synthetic */ Interceptable $ic;
    public static final k3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964037155, "Lcom/repackage/k3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964037155, "Lcom/repackage/k3;");
                return;
            }
        }
        e = new k3(1.0f, 1.0f, 1.0f, 1.0f);
        new k3(-1077952513);
        new k3(2139062271);
        new k3(1061109759);
        new k3(0.0f, 0.0f, 0.0f, 1.0f);
        e.f();
        new k3(0.0f, 0.0f, 0.0f, 0.0f);
        new k3(0.0f, 0.0f, 1.0f, 1.0f);
        new k3(0.0f, 0.0f, 0.5f, 1.0f);
        new k3(1097458175);
        new k3(1887473919);
        new k3(-2016482305);
        new k3(0.0f, 1.0f, 1.0f, 1.0f);
        new k3(0.0f, 0.5f, 0.5f, 1.0f);
        new k3((int) GeneratedTexture.MAGENTA);
        new k3(2147418367);
        new k3(852308735);
        new k3(579543807);
        new k3(1804477439);
        new k3(-65281);
        new k3(-2686721);
        new k3(-626712321);
        new k3(-5963521);
        new k3(-1958407169);
        new k3(-759919361);
        new k3(-1306385665);
        new k3(-16776961);
        new k3(-13361921);
        new k3(-8433409);
        new k3(-92245249);
        new k3(-9849601);
        new k3(1.0f, 0.0f, 1.0f, 1.0f);
        new k3(-1608453889);
        new k3(-293409025);
        new k3(-1339006721);
    }

    public k3() {
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

    public static int b(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (((int) (f * 255.0f)) << 24) | (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f)) : invokeCommon.intValue;
    }

    public static void c(k3 k3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, k3Var, i) == null) {
            k3Var.a = (((-16777216) & i) >>> 24) / 255.0f;
            k3Var.b = ((16711680 & i) >>> 16) / 255.0f;
            k3Var.c = ((65280 & i) >>> 8) / 255.0f;
            k3Var.d = (i & 255) / 255.0f;
        }
    }

    public static k3 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            k3 k3Var = new k3();
            i(str, k3Var);
            return k3Var;
        }
        return (k3) invokeL.objValue;
    }

    public static k3 i(String str, k3 k3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, k3Var)) == null) {
            if (str.charAt(0) == '#') {
                str = str.substring(1);
            }
            k3Var.a = Integer.parseInt(str.substring(0, 2), 16) / 255.0f;
            k3Var.b = Integer.parseInt(str.substring(2, 4), 16) / 255.0f;
            k3Var.c = Integer.parseInt(str.substring(4, 6), 16) / 255.0f;
            k3Var.d = str.length() != 8 ? 1.0f : Integer.parseInt(str.substring(6, 8), 16) / 255.0f;
            return k3Var;
        }
        return (k3) invokeLL.objValue;
    }

    public k3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f = this.a;
            if (f < 0.0f) {
                this.a = 0.0f;
            } else if (f > 1.0f) {
                this.a = 1.0f;
            }
            float f2 = this.b;
            if (f2 < 0.0f) {
                this.b = 0.0f;
            } else if (f2 > 1.0f) {
                this.b = 1.0f;
            }
            float f3 = this.c;
            if (f3 < 0.0f) {
                this.c = 0.0f;
            } else if (f3 > 1.0f) {
                this.c = 1.0f;
            }
            float f4 = this.d;
            if (f4 < 0.0f) {
                this.d = 0.0f;
            } else if (f4 > 1.0f) {
                this.d = 1.0f;
            }
            return this;
        }
        return (k3) invokeV.objValue;
    }

    public k3 d(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            a();
            return this;
        }
        return (k3) invokeCommon.objValue;
    }

    public k3 e(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k3Var)) == null) {
            this.a = k3Var.a;
            this.b = k3Var.b;
            this.c = k3Var.c;
            this.d = k3Var.d;
            return this;
        }
        return (k3) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return obj != null && k3.class == obj.getClass() && g() == ((k3) obj).g();
        }
        return invokeL.booleanValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? t7.c((((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f))) : invokeV.floatValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f)) : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.a;
            int a = (f != 0.0f ? t7.a(f) : 0) * 31;
            float f2 = this.b;
            int a2 = (a + (f2 != 0.0f ? t7.a(f2) : 0)) * 31;
            float f3 = this.c;
            int a3 = (a2 + (f3 != 0.0f ? t7.a(f3) : 0)) * 31;
            float f4 = this.d;
            return a3 + (f4 != 0.0f ? t7.a(f4) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String hexString = Integer.toHexString((((int) (this.a * 255.0f)) << 24) | (((int) (this.b * 255.0f)) << 16) | (((int) (this.c * 255.0f)) << 8) | ((int) (this.d * 255.0f)));
            while (hexString.length() < 8) {
                hexString = "0" + hexString;
            }
            return hexString;
        }
        return (String) invokeV.objValue;
    }

    public k3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        c(this, i);
    }

    public k3(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        a();
    }

    public k3(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k3Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        e(k3Var);
    }
}
