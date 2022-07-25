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
import com.repackage.e32;
import com.repackage.ur9;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class q32 extends m32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public as9<? super d94> c;
    public as9<? super b94> d;
    public od4 e;
    public bf3<Exception> f;
    public x74<d94> g;
    public x74<b94> h;
    public as9<e94> i;

    /* loaded from: classes7.dex */
    public class a extends u74<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q32 a;

        public a(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(d94 d94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(d94 d94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, d94Var, a94Var) == null) {
                super.e(d94Var, a94Var);
                ix1.k("UpdateCoreCallback", "onDownloadError:" + a94Var);
                this.a.e.l(d94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(13L);
                bc3Var.i(a94Var.a);
                bc3Var.d("Framework包下载失败");
                bc3Var.f(a94Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(d94Var, bc3Var));
                }
                e32.c().a(d94Var, this.a.V(), bc3Var);
                kg4.k(d94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d94Var) == null) {
                super.i(d94Var);
                ix1.k("UpdateCoreCallback", "onFileDownloaded: " + d94Var.i);
                bc3 c0 = this.a.c0(d94Var);
                if (c0 == null) {
                    this.a.e.m(d94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(d94Var);
                        this.a.c.onCompleted();
                    }
                    d84.i().m(d94Var);
                    e32.c().b(d94Var, this.a.V());
                    je3.a();
                    return;
                }
                this.a.e.l(d94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(d94Var, c0));
                }
                e32.c().a(d94Var, this.a.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void c(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, d94Var) == null) {
                super.c(d94Var);
                ix1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: r */
        public void f(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, d94Var) == null) {
                super.f(d94Var);
                if (q32.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(d94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends u74<b94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q32 a;

        public b(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(b94 b94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, b94Var)) == null) ? this.a.W() : (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(b94 b94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, b94Var, a94Var) == null) {
                super.e(b94Var, a94Var);
                ix1.k("UpdateCoreCallback", "onDownloadError:" + a94Var);
                this.a.e.l(b94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(14L);
                bc3Var.i(a94Var.a);
                bc3Var.d("Extension下载失败");
                bc3Var.f(a94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(b94Var, bc3Var));
                }
                e32.c().a(b94Var, this.a.V(), bc3Var);
                kg4.k(b94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b94Var) == null) {
                super.i(b94Var);
                ix1.k("UpdateCoreCallback", "onFileDownloaded: " + b94Var.i);
                bc3 b0 = this.a.b0(b94Var);
                if (b0 == null) {
                    this.a.e.m(b94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(b94Var);
                        this.a.d.onCompleted();
                    }
                    d84.i().m(b94Var);
                    e32.c().b(b94Var, this.a.V());
                    return;
                }
                this.a.e.l(b94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(b94Var, b0));
                }
                e32.c().a(b94Var, this.a.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void c(b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, b94Var) == null) {
                super.c(b94Var);
                ix1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: r */
        public void f(b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, b94Var) == null) {
                super.f(b94Var);
                if (q32.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(b94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d94 a;
        public final /* synthetic */ q32 b;

        public c(q32 q32Var, d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, d94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q32Var;
            this.a = d94Var;
        }

        @Override // com.repackage.e32.c
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

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, bc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b94 a;
        public final /* synthetic */ q32 b;

        public d(q32 q32Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, b94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q32Var;
            this.a = b94Var;
        }

        @Override // com.repackage.e32.c
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

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, bc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ur9.a<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q32 a;

        public e(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super d94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.c = as9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ur9.a<b94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q32 a;

        public f(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super b94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.d = as9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends as9<e94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q32 e;

        public g(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vr9
        /* renamed from: g */
        public void onNext(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e94Var) == null) {
                ix1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + e94Var.i);
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ix1.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                ix1.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755431135, "Lcom/repackage/q32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755431135, "Lcom/repackage/q32;");
                return;
            }
        }
        j = sg1.a;
    }

    public q32(bf3<Exception> bf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = bf3Var;
    }

    @Override // com.repackage.b84
    public void C(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a94Var) == null) {
            super.C(a94Var);
            ix1.k("UpdateCoreCallback", "onFetchError: " + a94Var.toString());
            if (a94Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + a94Var, a94Var));
        }
    }

    @Override // com.repackage.b84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.b84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ix1.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // com.repackage.b84
    public void G(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, od4Var) == null) {
            super.G(od4Var);
            if (od4Var == null) {
                return;
            }
            this.e = od4Var;
            if (od4Var.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final as9<e94> Y() {
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
            ix1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            bf3<Exception> bf3Var = this.f;
            if (bf3Var != null) {
                bf3Var.a(exc);
            }
            this.f = null;
        }
    }

    public abstract bc3 b0(b94 b94Var);

    public abstract bc3 c0(d94 d94Var);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            ix1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            hd4.d(U(), 0L);
            ek3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ix1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            hd4.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b94Var) == null) {
            e32.c().d(b94Var, new d(this, b94Var));
        }
    }

    public final void g0(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d94Var) == null) {
            e32.c().d(d94Var, new c(this, d94Var));
        }
    }

    @Override // com.repackage.b84
    public x74<b94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (x74) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public x74<d94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (x74) invokeV.objValue;
    }
}
