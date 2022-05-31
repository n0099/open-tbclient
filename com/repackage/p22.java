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
import com.repackage.d22;
import com.repackage.qu9;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class p22 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public wu9<? super c84> c;
    public wu9<? super a84> d;
    public nc4 e;
    public ae3<Exception> f;
    public w64<c84> g;
    public w64<a84> h;
    public wu9<d84> i;

    /* loaded from: classes6.dex */
    public class a extends t64<c84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 a;

        public a(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(c84 c84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c84Var)) == null) ? this.a.Y() : (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(c84 c84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, c84Var, z74Var) == null) {
                super.e(c84Var, z74Var);
                hw1.k("UpdateCoreCallback", "onDownloadError:" + z74Var);
                this.a.e.l(c84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(13L);
                ab3Var.i(z74Var.a);
                ab3Var.d("Framework包下载失败");
                ab3Var.f(z74Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(c84Var, ab3Var));
                }
                d22.c().a(c84Var, this.a.W(), ab3Var);
                kf4.k(c84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c84Var) == null) {
                super.i(c84Var);
                hw1.k("UpdateCoreCallback", "onFileDownloaded: " + c84Var.i);
                ab3 d0 = this.a.d0(c84Var);
                if (d0 == null) {
                    this.a.e.m(c84Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(c84Var);
                        this.a.c.onCompleted();
                    }
                    c74.i().m(c84Var);
                    d22.c().b(c84Var, this.a.W());
                    id3.a();
                    return;
                }
                this.a.e.l(c84Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(c84Var, d0));
                }
                d22.c().a(c84Var, this.a.W(), d0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void c(c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, c84Var) == null) {
                super.c(c84Var);
                hw1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, c84Var) == null) {
                super.f(c84Var);
                if (p22.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.h0(c84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends t64<a84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 a;

        public b(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(a84 a84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a84Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(a84 a84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, a84Var, z74Var) == null) {
                super.e(a84Var, z74Var);
                hw1.k("UpdateCoreCallback", "onDownloadError:" + z74Var);
                this.a.e.l(a84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(14L);
                ab3Var.i(z74Var.a);
                ab3Var.d("Extension下载失败");
                ab3Var.f(z74Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(a84Var, ab3Var));
                }
                d22.c().a(a84Var, this.a.W(), ab3Var);
                kf4.k(a84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a84Var) == null) {
                super.i(a84Var);
                hw1.k("UpdateCoreCallback", "onFileDownloaded: " + a84Var.i);
                ab3 c0 = this.a.c0(a84Var);
                if (c0 == null) {
                    this.a.e.m(a84Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(a84Var);
                        this.a.d.onCompleted();
                    }
                    c74.i().m(a84Var);
                    d22.c().b(a84Var, this.a.W());
                    return;
                }
                this.a.e.l(a84Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(a84Var, c0));
                }
                d22.c().a(a84Var, this.a.W(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void c(a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, a84Var) == null) {
                super.c(a84Var);
                hw1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, a84Var) == null) {
                super.f(a84Var);
                if (p22.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.g0(a84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c84 a;
        public final /* synthetic */ p22 b;

        public c(p22 p22Var, c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var, c84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p22Var;
            this.a = c84Var;
        }

        @Override // com.repackage.d22.c
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

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, ab3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a84 a;
        public final /* synthetic */ p22 b;

        public d(p22 p22Var, a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var, a84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p22Var;
            this.a = a84Var;
        }

        @Override // com.repackage.d22.c
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

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ab3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements qu9.a<c84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 a;

        public e(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super c84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.c = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements qu9.a<a84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 a;

        public f(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super a84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.d = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends wu9<d84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 e;

        public g(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9
        /* renamed from: g */
        public void onNext(d84 d84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d84Var) == null) {
                hw1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + d84Var.i);
            }
        }

        @Override // com.repackage.ru9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hw1.k("UpdateCoreCallback", "包下载完成");
                this.e.f0();
            }
        }

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                hw1.l("UpdateCoreCallback", "OnError", th);
                this.e.e0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755461887, "Lcom/repackage/p22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755461887, "Lcom/repackage/p22;");
                return;
            }
        }
        j = rf1.a;
    }

    public p22(ae3<Exception> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ae3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = ae3Var;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z74Var) == null) {
            super.D(z74Var);
            hw1.k("UpdateCoreCallback", "onFetchError: " + z74Var.toString());
            if (z74Var.a == 1010) {
                f0();
                return;
            }
            e0(new PMSException("UpdateCoreCallback failed by fetch error = " + z74Var, z74Var));
        }
    }

    @Override // com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            hw1.k("UpdateCoreCallback", "onNoPackage:");
            f0();
        }
    }

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nc4Var) == null) {
            super.H(nc4Var);
            if (nc4Var == null) {
                return;
            }
            this.e = nc4Var;
            if (nc4Var.k()) {
                return;
            }
            a0();
        }
    }

    public abstract int V();

    public abstract PMSDownloadType W();

    public abstract String X();

    public abstract String Y();

    public final wu9<d84> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (wu9) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(qu9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(qu9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            qu9.i(arrayList).u(Z());
        }
    }

    public void b0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            hw1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            ae3<Exception> ae3Var = this.f;
            if (ae3Var != null) {
                ae3Var.onCallback(exc);
            }
            this.f = null;
        }
    }

    public abstract ab3 c0(a84 a84Var);

    public abstract ab3 d0(c84 c84Var);

    public void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            hw1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            gc4.d(V(), 0L);
            dj3.a(0L);
            b0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            hw1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            gc4.d(V(), currentTimeMillis);
            b0(null);
        }
    }

    public final void g0(a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, a84Var) == null) {
            d22.c().d(a84Var, new d(this, a84Var));
        }
    }

    public final void h0(c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, c84Var) == null) {
            d22.c().d(c84Var, new c(this, c84Var));
        }
    }

    @Override // com.repackage.a74
    public w64<a84> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (w64) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public w64<c84> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (w64) invokeV.objValue;
    }
}
