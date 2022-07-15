package com.repackage;

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
/* loaded from: classes6.dex */
public class m83 implements k83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l83 a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229735956, "Lcom/repackage/m83$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-229735956, "Lcom/repackage/m83$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public m83() {
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

    @Override // com.repackage.k83
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            h03 b0 = h03.b0();
            return b0 == null ? str : p73.H(str, b0);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.k83
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? p73.G(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.k83
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            h03 b0 = h03.b0();
            return b0 == null ? "" : p73.n(b0.b, str, null);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.k83
    @NonNull
    public synchronized l83 d() {
        InterceptResult invokeV;
        l83 l83Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new n83();
                }
                l83Var = this.a;
            }
            return l83Var;
        }
        return (l83) invokeV.objValue;
    }

    @Override // com.repackage.k83
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                return null;
            }
            return p73.L(str, b0, b0.k0());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.k83
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h03 b0 = h03.b0();
            return b0 == null ? "" : p73.z(b0.b);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.k83
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            h03 b0 = h03.b0();
            return b0 == null ? str : p73.I(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.k83
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String t = jg4.t(str);
            if (TextUtils.isEmpty(t)) {
                return g(str);
            }
            return g(str) + "." + t;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.k83
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                return null;
            }
            return p73.M(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.k83
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PathType s = p73.s(str);
            if (z) {
                s = o(str, s);
            }
            return s != PathType.ERROR;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.repackage.k83
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            h03 b0 = h03.b0();
            return b0 == null ? "" : p73.x(b0.b);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.k83
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? p73.F(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.k83
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? p73.K(str) : (String) invokeL.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf("../");
            if (indexOf != 0) {
                return indexOf > 0;
            }
            String substring = str.substring(3);
            return !TextUtils.isEmpty(substring) && substring.contains("../");
        }
        return invokeL.booleanValue;
    }

    public final PathType o(String str, PathType pathType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, pathType)) == null) {
            int i = a.a[pathType.ordinal()];
            if (i == 1) {
                return n(str) ? PathType.ERROR : pathType;
            } else if (i != 2) {
                return i != 3 ? PathType.ERROR : pathType;
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
