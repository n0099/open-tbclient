package com.ksad.lottie.model.layer;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Text;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.a.j;
import com.ksad.lottie.model.a.k;
import com.ksad.lottie.model.a.l;
import com.ksad.lottie.model.content.Mask;
import com.yy.hiidostatis.inner.util.log.ActLog;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class Layer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.model.content.b> f33958a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.d f33959b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33960c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33961d;

    /* renamed from: e  reason: collision with root package name */
    public final LayerType f33962e;

    /* renamed from: f  reason: collision with root package name */
    public final long f33963f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f33964g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Mask> f33965h;

    /* renamed from: i  reason: collision with root package name */
    public final l f33966i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;
    @Nullable
    public final j q;
    @Nullable
    public final k r;
    @Nullable
    public final com.ksad.lottie.model.a.b s;
    public final List<com.ksad.lottie.e.a<Float>> t;
    public final MatteType u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class LayerType {
        public static final /* synthetic */ LayerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LayerType Image;
        public static final LayerType Null;
        public static final LayerType PreComp;
        public static final LayerType Shape;
        public static final LayerType Solid;
        public static final LayerType Text;
        public static final LayerType Unknown;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1338076019, "Lcom/ksad/lottie/model/layer/Layer$LayerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1338076019, "Lcom/ksad/lottie/model/layer/Layer$LayerType;");
                    return;
                }
            }
            PreComp = new LayerType("PreComp", 0);
            Solid = new LayerType("Solid", 1);
            Image = new LayerType("Image", 2);
            Null = new LayerType("Null", 3);
            Shape = new LayerType("Shape", 4);
            Text = new LayerType(Text.k, 5);
            LayerType layerType = new LayerType("Unknown", 6);
            Unknown = layerType;
            $VALUES = new LayerType[]{PreComp, Solid, Image, Null, Shape, Text, layerType};
        }

        public LayerType(String str, int i2) {
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

        public static LayerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LayerType) Enum.valueOf(LayerType.class, str) : (LayerType) invokeL.objValue;
        }

        public static LayerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LayerType[]) $VALUES.clone() : (LayerType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MatteType {
        public static final /* synthetic */ MatteType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MatteType Add;
        public static final MatteType Invert;
        public static final MatteType None;
        public static final MatteType Unknown;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1603232243, "Lcom/ksad/lottie/model/layer/Layer$MatteType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1603232243, "Lcom/ksad/lottie/model/layer/Layer$MatteType;");
                    return;
                }
            }
            None = new MatteType("None", 0);
            Add = new MatteType(ActLog.TYPE_ADD, 1);
            Invert = new MatteType("Invert", 2);
            MatteType matteType = new MatteType("Unknown", 3);
            Unknown = matteType;
            $VALUES = new MatteType[]{None, Add, Invert, matteType};
        }

        public MatteType(String str, int i2) {
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

        public static MatteType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MatteType) Enum.valueOf(MatteType.class, str) : (MatteType) invokeL.objValue;
        }

        public static MatteType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MatteType[]) $VALUES.clone() : (MatteType[]) invokeV.objValue;
        }
    }

    public Layer(List<com.ksad.lottie.model.content.b> list, com.ksad.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable j jVar, @Nullable k kVar, List<com.ksad.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.ksad.lottie.model.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, dVar, str, Long.valueOf(j), layerType, Long.valueOf(j2), str2, list2, lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i5), Integer.valueOf(i6), jVar, kVar, list3, matteType, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33958a = list;
        this.f33959b = dVar;
        this.f33960c = str;
        this.f33961d = j;
        this.f33962e = layerType;
        this.f33963f = j2;
        this.f33964g = str2;
        this.f33965h = list2;
        this.f33966i = lVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
    }

    public com.ksad.lottie.d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33959b : (com.ksad.lottie.d) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(f());
            sb.append("\n");
            Layer a2 = this.f33959b.a(m());
            if (a2 != null) {
                String str2 = "\t\tParents: ";
                while (true) {
                    sb.append(str2);
                    sb.append(a2.f());
                    a2 = this.f33959b.a(a2.m());
                    if (a2 == null) {
                        break;
                    }
                    str2 = "->";
                }
                sb.append(str);
                sb.append("\n");
            }
            if (!j().isEmpty()) {
                sb.append(str);
                sb.append("\tMasks: ");
                sb.append(j().size());
                sb.append("\n");
            }
            if (r() != 0 && q() != 0) {
                sb.append(str);
                sb.append("\tBackground: ");
                sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
            }
            if (!this.f33958a.isEmpty()) {
                sb.append(str);
                sb.append("\tShapes:\n");
                for (com.ksad.lottie.model.content.b bVar : this.f33958a) {
                    sb.append(str);
                    sb.append("\t\t");
                    sb.append(bVar);
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n / this.f33959b.k() : invokeV.floatValue;
    }

    public List<com.ksad.lottie.e.a<Float>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33961d : invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33960c : (String) invokeV.objValue;
    }

    @Nullable
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33964g : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.o : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.intValue;
    }

    public List<Mask> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33965h : (List) invokeV.objValue;
    }

    public LayerType k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f33962e : (LayerType) invokeV.objValue;
    }

    public MatteType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u : (MatteType) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f33963f : invokeV.longValue;
    }

    public List<com.ksad.lottie.model.content.b> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33958a : (List) invokeV.objValue;
    }

    public l o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f33966i : (l) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.j : invokeV.intValue;
    }

    @Nullable
    public j s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : (j) invokeV.objValue;
    }

    @Nullable
    public k t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.r : (k) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? a("") : (String) invokeV.objValue;
    }

    @Nullable
    public com.ksad.lottie.model.a.b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.s : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }
}
