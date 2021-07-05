package com.ksad.lottie.model.content;

import android.graphics.PointF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.a.m;
/* loaded from: classes7.dex */
public class PolystarShape implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33878a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f33879b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33880c;

    /* renamed from: d  reason: collision with root package name */
    public final m<PointF, PointF> f33881d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33882e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33883f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33884g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33885h;

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33886i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type Polygon;
        public static final Type Star;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1060425090, "Lcom/ksad/lottie/model/content/PolystarShape$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1060425090, "Lcom/ksad/lottie/model/content/PolystarShape$Type;");
                    return;
                }
            }
            Star = new Type("Star", 0, 1);
            Type type = new Type("Polygon", 1, 2);
            Polygon = type;
            $VALUES = new Type[]{Star, type};
        }

        public Type(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static Type forValue(int i2) {
            InterceptResult invokeI;
            Type[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (Type type : values()) {
                    if (type.value == i2) {
                        return type;
                    }
                }
                return null;
            }
            return (Type) invokeI.objValue;
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    public PolystarShape(String str, Type type, com.ksad.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.ksad.lottie.model.a.b bVar2, com.ksad.lottie.model.a.b bVar3, com.ksad.lottie.model.a.b bVar4, com.ksad.lottie.model.a.b bVar5, com.ksad.lottie.model.a.b bVar6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33878a = str;
        this.f33879b = type;
        this.f33880c = bVar;
        this.f33881d = mVar;
        this.f33882e = bVar2;
        this.f33883f = bVar3;
        this.f33884g = bVar4;
        this.f33885h = bVar5;
        this.f33886i = bVar6;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new com.ksad.lottie.a.a.m(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33878a : (String) invokeV.objValue;
    }

    public Type b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33879b : (Type) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33880c : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public m<PointF, PointF> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33881d : (m) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33882e : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33883f : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33884g : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33885h : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33886i : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }
}
