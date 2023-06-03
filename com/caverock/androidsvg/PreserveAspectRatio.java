package com.caverock.androidsvg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PreserveAspectRatio {
    public static /* synthetic */ Interceptable $ic;
    public static final PreserveAspectRatio c;
    public static final PreserveAspectRatio d;
    public transient /* synthetic */ FieldHolder $fh;
    public Alignment a;
    public Scale b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Alignment {
        public static final /* synthetic */ Alignment[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Alignment none;
        public static final Alignment xMaxYMax;
        public static final Alignment xMaxYMid;
        public static final Alignment xMaxYMin;
        public static final Alignment xMidYMax;
        public static final Alignment xMidYMid;
        public static final Alignment xMidYMin;
        public static final Alignment xMinYMax;
        public static final Alignment xMinYMid;
        public static final Alignment xMinYMin;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1110438924, "Lcom/caverock/androidsvg/PreserveAspectRatio$Alignment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1110438924, "Lcom/caverock/androidsvg/PreserveAspectRatio$Alignment;");
                    return;
                }
            }
            none = new Alignment("none", 0);
            xMinYMin = new Alignment("xMinYMin", 1);
            xMidYMin = new Alignment("xMidYMin", 2);
            xMaxYMin = new Alignment("xMaxYMin", 3);
            xMinYMid = new Alignment("xMinYMid", 4);
            xMidYMid = new Alignment("xMidYMid", 5);
            xMaxYMid = new Alignment("xMaxYMid", 6);
            xMinYMax = new Alignment("xMinYMax", 7);
            xMidYMax = new Alignment("xMidYMax", 8);
            Alignment alignment = new Alignment("xMaxYMax", 9);
            xMaxYMax = alignment;
            $VALUES = new Alignment[]{none, xMinYMin, xMidYMin, xMaxYMin, xMinYMid, xMidYMid, xMaxYMid, xMinYMax, xMidYMax, alignment};
        }

        public Alignment(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Alignment valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Alignment) Enum.valueOf(Alignment.class, str);
            }
            return (Alignment) invokeL.objValue;
        }

        public static Alignment[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Alignment[]) $VALUES.clone();
            }
            return (Alignment[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Scale {
        public static final /* synthetic */ Scale[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Scale meet;
        public static final Scale slice;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(35865477, "Lcom/caverock/androidsvg/PreserveAspectRatio$Scale;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(35865477, "Lcom/caverock/androidsvg/PreserveAspectRatio$Scale;");
                    return;
                }
            }
            meet = new Scale("meet", 0);
            Scale scale = new Scale("slice", 1);
            slice = scale;
            $VALUES = new Scale[]{meet, scale};
        }

        public Scale(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Scale valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Scale) Enum.valueOf(Scale.class, str);
            }
            return (Scale) invokeL.objValue;
        }

        public static Scale[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Scale[]) $VALUES.clone();
            }
            return (Scale[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1280749131, "Lcom/caverock/androidsvg/PreserveAspectRatio;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1280749131, "Lcom/caverock/androidsvg/PreserveAspectRatio;");
                return;
            }
        }
        c = new PreserveAspectRatio(Alignment.none, null);
        d = new PreserveAspectRatio(Alignment.xMidYMid, Scale.meet);
        Alignment alignment = Alignment.xMinYMin;
        Scale scale = Scale.meet;
        Alignment alignment2 = Alignment.xMaxYMax;
        Scale scale2 = Scale.meet;
        Alignment alignment3 = Alignment.xMidYMin;
        Scale scale3 = Scale.meet;
        Alignment alignment4 = Alignment.xMidYMax;
        Scale scale4 = Scale.meet;
        Alignment alignment5 = Alignment.xMidYMid;
        Scale scale5 = Scale.slice;
        Alignment alignment6 = Alignment.xMinYMin;
        Scale scale6 = Scale.slice;
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alignment, scale};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = alignment;
        this.b = scale;
    }

    public Alignment a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (Alignment) invokeV.objValue;
    }

    public Scale b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (Scale) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a + " " + this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PreserveAspectRatio.class != obj.getClass()) {
                return false;
            }
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            if (this.a == preserveAspectRatio.a && this.b == preserveAspectRatio.b) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
