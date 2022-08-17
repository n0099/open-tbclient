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
import com.repackage.ru9;
import com.repackage.v32;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class h42 extends d42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public xu9<? super u94> c;
    public xu9<? super s94> d;
    public fe4 e;
    public sf3<Exception> f;
    public o84<u94> g;
    public o84<s94> h;
    public xu9<v94> i;

    /* loaded from: classes6.dex */
    public class a extends l84<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h42 a;

        public a(h42 h42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(u94 u94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, u94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(u94 u94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, u94Var, r94Var) == null) {
                super.e(u94Var, r94Var);
                zx1.k("UpdateCoreCallback", "onDownloadError:" + r94Var);
                this.a.e.l(u94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(13L);
                sc3Var.i(r94Var.a);
                sc3Var.d("Framework包下载失败");
                sc3Var.f(r94Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(u94Var, sc3Var));
                }
                v32.c().a(u94Var, this.a.V(), sc3Var);
                bh4.k(u94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u94Var) == null) {
                super.i(u94Var);
                zx1.k("UpdateCoreCallback", "onFileDownloaded: " + u94Var.i);
                sc3 c0 = this.a.c0(u94Var);
                if (c0 == null) {
                    this.a.e.m(u94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(u94Var);
                        this.a.c.onCompleted();
                    }
                    u84.i().m(u94Var);
                    v32.c().b(u94Var, this.a.V());
                    af3.a();
                    return;
                }
                this.a.e.l(u94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(u94Var, c0));
                }
                v32.c().a(u94Var, this.a.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void c(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, u94Var) == null) {
                super.c(u94Var);
                zx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void f(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, u94Var) == null) {
                super.f(u94Var);
                if (h42.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(u94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends l84<s94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h42 a;

        public b(h42 h42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(s94 s94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, s94Var)) == null) ? this.a.W() : (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(s94 s94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, s94Var, r94Var) == null) {
                super.e(s94Var, r94Var);
                zx1.k("UpdateCoreCallback", "onDownloadError:" + r94Var);
                this.a.e.l(s94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(14L);
                sc3Var.i(r94Var.a);
                sc3Var.d("Extension下载失败");
                sc3Var.f(r94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(s94Var, sc3Var));
                }
                v32.c().a(s94Var, this.a.V(), sc3Var);
                bh4.k(s94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s94Var) == null) {
                super.i(s94Var);
                zx1.k("UpdateCoreCallback", "onFileDownloaded: " + s94Var.i);
                sc3 b0 = this.a.b0(s94Var);
                if (b0 == null) {
                    this.a.e.m(s94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(s94Var);
                        this.a.d.onCompleted();
                    }
                    u84.i().m(s94Var);
                    v32.c().b(s94Var, this.a.V());
                    return;
                }
                this.a.e.l(s94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(s94Var, b0));
                }
                v32.c().a(s94Var, this.a.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void c(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, s94Var) == null) {
                super.c(s94Var);
                zx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void f(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, s94Var) == null) {
                super.f(s94Var);
                if (h42.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(s94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u94 a;
        public final /* synthetic */ h42 b;

        public c(h42 h42Var, u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var, u94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h42Var;
            this.a = u94Var;
        }

        @Override // com.repackage.v32.c
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

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, sc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s94 a;
        public final /* synthetic */ h42 b;

        public d(h42 h42Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var, s94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h42Var;
            this.a = s94Var;
        }

        @Override // com.repackage.v32.c
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

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, sc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ru9.a<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h42 a;

        public e(h42 h42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super u94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.c = xu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ru9.a<s94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h42 a;

        public f(h42 h42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super s94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.d = xu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends xu9<v94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h42 e;

        public g(h42 h42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.su9
        /* renamed from: g */
        public void onNext(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v94Var) == null) {
                zx1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + v94Var.i);
            }
        }

        @Override // com.repackage.su9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zx1.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }

        @Override // com.repackage.su9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                zx1.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755698293, "Lcom/repackage/h42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755698293, "Lcom/repackage/h42;");
                return;
            }
        }
        j = jh1.a;
    }

    public h42(sf3<Exception> sf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = sf3Var;
    }

    @Override // com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r94Var) == null) {
            super.C(r94Var);
            zx1.k("UpdateCoreCallback", "onFetchError: " + r94Var.toString());
            if (r94Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + r94Var, r94Var));
        }
    }

    @Override // com.repackage.s84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.s84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            zx1.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // com.repackage.s84
    public void G(fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fe4Var) == null) {
            super.G(fe4Var);
            if (fe4Var == null) {
                return;
            }
            this.e = fe4Var;
            if (fe4Var.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final xu9<v94> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (xu9) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(ru9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(ru9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ru9.i(arrayList).u(Y());
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            zx1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            sf3<Exception> sf3Var = this.f;
            if (sf3Var != null) {
                sf3Var.a(exc);
            }
            this.f = null;
        }
    }

    public abstract sc3 b0(s94 s94Var);

    public abstract sc3 c0(u94 u94Var);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            zx1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            yd4.d(U(), 0L);
            vk3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            zx1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            yd4.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, s94Var) == null) {
            v32.c().d(s94Var, new d(this, s94Var));
        }
    }

    public final void g0(u94 u94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, u94Var) == null) {
            v32.c().d(u94Var, new c(this, u94Var));
        }
    }

    @Override // com.repackage.s84
    public o84<s94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (o84) invokeV.objValue;
    }

    @Override // com.repackage.s84
    public o84<u94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (o84) invokeV.objValue;
    }
}
