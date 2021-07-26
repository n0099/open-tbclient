package d.a.o0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class f implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f46375a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46376a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1653028270, "Ld/a/o0/a/k2/f/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1653028270, "Ld/a/o0/a/k2/f/f$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            f46376a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46376a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46376a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f() {
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

    @Override // d.a.o0.a.k2.f.d
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            return Q == null ? str : d.a.o0.a.k2.b.H(str, Q);
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? d.a.o0.a.k2.b.G(str) : invokeL.booleanValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            return Q == null ? "" : d.a.o0.a.k2.b.n(Q.f43885f, str, null);
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    @NonNull
    public synchronized e d() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.f46375a == null) {
                    this.f46375a = new g();
                }
                eVar = this.f46375a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            return d.a.o0.a.k2.b.L(str, Q, Q.Z());
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            return Q == null ? "" : d.a.o0.a.k2.b.z(Q.f43885f);
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            return Q == null ? str : d.a.o0.a.k2.b.I(str, Q.f43885f);
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String s = d.a.o0.t.d.s(str);
            if (TextUtils.isEmpty(s)) {
                return g(str);
            }
            return g(str) + "." + s;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            return d.a.o0.a.k2.b.M(str, Q.f43885f);
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PathType s = d.a.o0.a.k2.b.s(str);
            if (z) {
                s = o(str, s);
            }
            return s != PathType.ERROR;
        }
        return invokeLZ.booleanValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            return Q == null ? "" : d.a.o0.a.k2.b.x(Q.f43885f);
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? d.a.o0.a.k2.b.F(str) : invokeL.booleanValue;
    }

    @Override // d.a.o0.a.k2.f.d
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? d.a.o0.a.k2.b.K(str) : (String) invokeL.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf(com.baidu.android.imsdk.retrieve.Constants.PATH_PARENT);
            if (indexOf != 0) {
                return indexOf > 0;
            }
            String substring = str.substring(3);
            return !TextUtils.isEmpty(substring) && substring.contains(com.baidu.android.imsdk.retrieve.Constants.PATH_PARENT);
        }
        return invokeL.booleanValue;
    }

    public final PathType o(String str, PathType pathType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, pathType)) == null) {
            int i2 = a.f46376a[pathType.ordinal()];
            if (i2 == 1) {
                return n(str) ? PathType.ERROR : pathType;
            } else if (i2 != 2) {
                return i2 != 3 ? PathType.ERROR : pathType;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("bdfile://code");
                sb.append(File.separator);
                return (str.startsWith(sb.toString()) || "bdfile://code".equals(str)) ? PathType.RELATIVE : pathType;
            }
        }
        return (PathType) invokeLL.objValue;
    }
}
