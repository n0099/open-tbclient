package com.caverock.androidsvg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PreserveAspectRatio {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final PreserveAspectRatio f54797c;

    /* renamed from: d  reason: collision with root package name */
    public static final PreserveAspectRatio f54798d;
    public transient /* synthetic */ FieldHolder $fh;
    public Alignment a;

    /* renamed from: b  reason: collision with root package name */
    public Scale f54799b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class Alignment {
        public static final /* synthetic */ Alignment[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Alignment None;
        public static final Alignment XMaxYMax;
        public static final Alignment XMaxYMid;
        public static final Alignment XMaxYMin;
        public static final Alignment XMidYMax;
        public static final Alignment XMidYMid;
        public static final Alignment XMidYMin;
        public static final Alignment XMinYMax;
        public static final Alignment XMinYMid;
        public static final Alignment XMinYMin;
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
            None = new Alignment("None", 0);
            XMinYMin = new Alignment("XMinYMin", 1);
            XMidYMin = new Alignment("XMidYMin", 2);
            XMaxYMin = new Alignment("XMaxYMin", 3);
            XMinYMid = new Alignment("XMinYMid", 4);
            XMidYMid = new Alignment("XMidYMid", 5);
            XMaxYMid = new Alignment("XMaxYMid", 6);
            XMinYMax = new Alignment("XMinYMax", 7);
            XMidYMax = new Alignment("XMidYMax", 8);
            Alignment alignment = new Alignment("XMaxYMax", 9);
            XMaxYMax = alignment;
            $VALUES = new Alignment[]{None, XMinYMin, XMidYMin, XMaxYMin, XMinYMid, XMidYMid, XMaxYMid, XMinYMax, XMidYMax, alignment};
        }

        public Alignment(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Alignment) Enum.valueOf(Alignment.class, str) : (Alignment) invokeL.objValue;
        }

        public static Alignment[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Alignment[]) $VALUES.clone() : (Alignment[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class Scale {
        public static final /* synthetic */ Scale[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Scale Meet;
        public static final Scale Slice;
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
            Meet = new Scale("Meet", 0);
            Scale scale = new Scale("Slice", 1);
            Slice = scale;
            $VALUES = new Scale[]{Meet, scale};
        }

        public Scale(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Scale) Enum.valueOf(Scale.class, str) : (Scale) invokeL.objValue;
        }

        public static Scale[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Scale[]) $VALUES.clone() : (Scale[]) invokeV.objValue;
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
        f54797c = new PreserveAspectRatio(Alignment.None, null);
        f54798d = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
        Alignment alignment = Alignment.XMinYMin;
        Scale scale = Scale.Meet;
        Alignment alignment2 = Alignment.XMaxYMax;
        Scale scale2 = Scale.Meet;
        Alignment alignment3 = Alignment.XMidYMin;
        Scale scale3 = Scale.Meet;
        Alignment alignment4 = Alignment.XMidYMax;
        Scale scale4 = Scale.Meet;
        Alignment alignment5 = Alignment.XMidYMid;
        Scale scale5 = Scale.Slice;
        Alignment alignment6 = Alignment.XMinYMin;
        Scale scale6 = Scale.Slice;
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alignment, scale};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = alignment;
        this.f54799b = scale;
    }

    public Alignment a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Alignment) invokeV.objValue;
    }

    public Scale b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54799b : (Scale) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PreserveAspectRatio.class == obj.getClass()) {
                PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
                return this.a == preserveAspectRatio.a && this.f54799b == preserveAspectRatio.f54799b;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
