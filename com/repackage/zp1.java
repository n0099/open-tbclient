package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uk2;
import com.repackage.yp1;
/* loaded from: classes7.dex */
public class zp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zp1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* loaded from: classes7.dex */
    public class a implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp1.c a;
        public final /* synthetic */ zp1 b;

        public a(zp1 zp1Var, yp1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zp1Var;
            this.a = cVar;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.c(this.a);
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ux1.c("GetLocationHelper", str);
                a83.b("getLocation", 5002, "user no permission", 10005, str);
                this.b.a.f(this.a, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements uk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yp1.c a;
        public final /* synthetic */ zp1 b;

        public b(zp1 zp1Var, yp1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zp1Var;
            this.a = cVar;
        }

        @Override // com.repackage.uk2.a
        public void a(t33 t33Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t33Var) == null) {
                this.b.a.g(this.a, t33Var);
            }
        }

        @Override // com.repackage.uk2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                a83.b("getLocation", 4000, "sdk's errCode is " + i, 1001, String.valueOf(i));
                this.b.a.b(this.a, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void b(yp1.c cVar, int i);

        void f(yp1.c cVar, String str);

        void g(yp1.c cVar, t33 t33Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755104426, "Lcom/repackage/zp1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755104426, "Lcom/repackage/zp1;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public zp1() {
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

    public static zp1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (zp1.class) {
                    if (b == null) {
                        b = new zp1();
                    }
                }
            }
            return b;
        }
        return (zp1) invokeV.objValue;
    }

    public final void c(yp1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.a, "gcj02")) {
                str = TextUtils.equals(cVar.a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
            }
            bk2.I().b(str, false, cVar.b, new b(this, cVar));
        }
    }

    public void e(@NonNull yp1.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.a = cVar2;
            if (oe3.M()) {
                c(cVar);
            } else if (z) {
                a83.b("getLocation", 1002, "GetLocation does not supported when app is invisible", 10005, "GetLocation does not supported when app is invisible");
                this.a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                a aVar = new a(this, cVar);
                wv2.g(t03.J().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
            }
        }
    }
}
