package com.ksad.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.a.q;
import java.util.List;
/* loaded from: classes7.dex */
public class ShapeStroke implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33887a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33888b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.ksad.lottie.model.a.b> f33889c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f33890d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f33891e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33892f;

    /* renamed from: g  reason: collision with root package name */
    public final LineCapType f33893g;

    /* renamed from: h  reason: collision with root package name */
    public final LineJoinType f33894h;

    /* renamed from: i  reason: collision with root package name */
    public final float f33895i;

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33896a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f33897b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1462782313, "Lcom/ksad/lottie/model/content/ShapeStroke$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1462782313, "Lcom/ksad/lottie/model/content/ShapeStroke$1;");
                    return;
                }
            }
            int[] iArr = new int[LineJoinType.values().length];
            f33897b = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33897b[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33897b[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f33896a = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33896a[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33896a[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class LineCapType {
        public static final /* synthetic */ LineCapType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LineCapType Butt;
        public static final LineCapType Round;
        public static final LineCapType Unknown;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1567687696, "Lcom/ksad/lottie/model/content/ShapeStroke$LineCapType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1567687696, "Lcom/ksad/lottie/model/content/ShapeStroke$LineCapType;");
                    return;
                }
            }
            Butt = new LineCapType("Butt", 0);
            Round = new LineCapType("Round", 1);
            LineCapType lineCapType = new LineCapType("Unknown", 2);
            Unknown = lineCapType;
            $VALUES = new LineCapType[]{Butt, Round, lineCapType};
        }

        public LineCapType(String str, int i2) {
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

        public static LineCapType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LineCapType) Enum.valueOf(LineCapType.class, str) : (LineCapType) invokeL.objValue;
        }

        public static LineCapType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LineCapType[]) $VALUES.clone() : (LineCapType[]) invokeV.objValue;
        }

        public Paint.Cap toPaintCap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = AnonymousClass1.f33896a[ordinal()];
                return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
            }
            return (Paint.Cap) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class LineJoinType {
        public static final /* synthetic */ LineJoinType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LineJoinType Bevel;
        public static final LineJoinType Miter;
        public static final LineJoinType Round;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(596459766, "Lcom/ksad/lottie/model/content/ShapeStroke$LineJoinType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(596459766, "Lcom/ksad/lottie/model/content/ShapeStroke$LineJoinType;");
                    return;
                }
            }
            Miter = new LineJoinType("Miter", 0);
            Round = new LineJoinType("Round", 1);
            LineJoinType lineJoinType = new LineJoinType("Bevel", 2);
            Bevel = lineJoinType;
            $VALUES = new LineJoinType[]{Miter, Round, lineJoinType};
        }

        public LineJoinType(String str, int i2) {
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

        public static LineJoinType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LineJoinType) Enum.valueOf(LineJoinType.class, str) : (LineJoinType) invokeL.objValue;
        }

        public static LineJoinType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LineJoinType[]) $VALUES.clone() : (LineJoinType[]) invokeV.objValue;
        }

        public Paint.Join toPaintJoin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = AnonymousClass1.f33897b[ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return null;
                        }
                        return Paint.Join.ROUND;
                    }
                    return Paint.Join.MITER;
                }
                return Paint.Join.BEVEL;
            }
            return (Paint.Join) invokeV.objValue;
        }
    }

    public ShapeStroke(String str, @Nullable com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.a aVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, list, aVar, dVar, bVar2, lineCapType, lineJoinType, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33887a = str;
        this.f33888b = bVar;
        this.f33889c = list;
        this.f33890d = aVar;
        this.f33891e = dVar;
        this.f33892f = bVar2;
        this.f33893g = lineCapType;
        this.f33894h = lineJoinType;
        this.f33895i = f2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new q(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33887a : (String) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33890d : (com.ksad.lottie.model.a.a) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33891e : (com.ksad.lottie.model.a.d) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33892f : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public List<com.ksad.lottie.model.a.b> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33889c : (List) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33888b : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public LineCapType g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33893g : (LineCapType) invokeV.objValue;
    }

    public LineJoinType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33894h : (LineJoinType) invokeV.objValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33895i : invokeV.floatValue;
    }
}
