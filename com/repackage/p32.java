package com.repackage;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d32;
import com.repackage.ur9;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class p32 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public as9<? super c94> c;
    public as9<? super a94> d;
    public nd4 e;
    public af3<Exception> f;
    public w74<c94> g;
    public w74<a94> h;
    public as9<d94> i;

    /* loaded from: classes6.dex */
    public class a extends t74<c94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p32 a;

        public a(p32 p32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(c94 c94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(c94 c94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, c94Var, z84Var) == null) {
                super.e(c94Var, z84Var);
                hx1.k("UpdateCoreCallback", "onDownloadError:" + z84Var);
                this.a.e.l(c94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(13L);
                ac3Var.i(z84Var.a);
                ac3Var.d("Framework包下载失败");
                ac3Var.f(z84Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(c94Var, ac3Var));
                }
                d32.c().a(c94Var, this.a.V(), ac3Var);
                jg4.k(c94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c94Var) == null) {
                super.i(c94Var);
                hx1.k("UpdateCoreCallback", "onFileDownloaded: " + c94Var.i);
                ac3 c0 = this.a.c0(c94Var);
                if (c0 == null) {
                    this.a.e.m(c94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(c94Var);
                        this.a.c.onCompleted();
                    }
                    c84.i().m(c94Var);
                    d32.c().b(c94Var, this.a.V());
                    ie3.a();
                    return;
                }
                this.a.e.l(c94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(c94Var, c0));
                }
                d32.c().a(c94Var, this.a.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void c(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, c94Var) == null) {
                super.c(c94Var);
                hx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, c94Var) == null) {
                super.f(c94Var);
                if (p32.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(c94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends t74<a94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p32 a;

        public b(p32 p32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(a94 a94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a94Var)) == null) ? this.a.W() : (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(a94 a94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, a94Var, z84Var) == null) {
                super.e(a94Var, z84Var);
                hx1.k("UpdateCoreCallback", "onDownloadError:" + z84Var);
                this.a.e.l(a94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(14L);
                ac3Var.i(z84Var.a);
                ac3Var.d("Extension下载失败");
                ac3Var.f(z84Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(a94Var, ac3Var));
                }
                d32.c().a(a94Var, this.a.V(), ac3Var);
                jg4.k(a94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a94Var) == null) {
                super.i(a94Var);
                hx1.k("UpdateCoreCallback", "onFileDownloaded: " + a94Var.i);
                ac3 b0 = this.a.b0(a94Var);
                if (b0 == null) {
                    this.a.e.m(a94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(a94Var);
                        this.a.d.onCompleted();
                    }
                    c84.i().m(a94Var);
                    d32.c().b(a94Var, this.a.V());
                    return;
                }
                this.a.e.l(a94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(a94Var, b0));
                }
                d32.c().a(a94Var, this.a.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void c(a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, a94Var) == null) {
                super.c(a94Var);
                hx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, a94Var) == null) {
                super.f(a94Var);
                if (p32.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(a94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c94 a;
        public final /* synthetic */ p32 b;

        public c(p32 p32Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var, c94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p32Var;
            this.a = c94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.e.m(this.a);
                if (this.b.c != null) {
                    this.b.c.onNext(this.a);
                    this.b.c.onCompleted();
                }
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, ac3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a94 a;
        public final /* synthetic */ p32 b;

        public d(p32 p32Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var, a94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p32Var;
            this.a = a94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.e.m(this.a);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ac3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ur9.a<c94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p32 a;

        public e(p32 p32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super c94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.c = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ur9.a<a94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p32 a;

        public f(p32 p32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super a94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.d = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends as9<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p32 e;

        public g(p32 p32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vr9
        /* renamed from: g */
        public void onNext(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d94Var) == null) {
                hx1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + d94Var.i);
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hx1.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                hx1.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755460926, "Lcom/repackage/p32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755460926, "Lcom/repackage/p32;");
                return;
            }
        }
        j = rg1.a;
    }

    public p32(af3<Exception> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = af3Var;
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z84Var) == null) {
            super.C(z84Var);
            hx1.k("UpdateCoreCallback", "onFetchError: " + z84Var.toString());
            if (z84Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + z84Var, z84Var));
        }
    }

    @Override // com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.a84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            hx1.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nd4Var) == null) {
            super.G(nd4Var);
            if (nd4Var == null) {
                return;
            }
            this.e = nd4Var;
            if (nd4Var.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final as9<d94> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (as9) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(ur9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(ur9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ur9.i(arrayList).u(Y());
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            hx1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            af3<Exception> af3Var = this.f;
            if (af3Var != null) {
                af3Var.a(exc);
            }
            this.f = null;
        }
    }

    public abstract ac3 b0(a94 a94Var);

    public abstract ac3 c0(c94 c94Var);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            hx1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            gd4.d(U(), 0L);
            dk3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            hx1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            gd4.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, a94Var) == null) {
            d32.c().d(a94Var, new d(this, a94Var));
        }
    }

    public final void g0(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, c94Var) == null) {
            d32.c().d(c94Var, new c(this, c94Var));
        }
    }

    @Override // com.repackage.a84
    public w74<a94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (w74) invokeV.objValue;
    }

    @Override // com.repackage.a84
    public w74<c94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (w74) invokeV.objValue;
    }
}
