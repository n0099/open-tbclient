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
import com.repackage.f32;
import com.repackage.uy9;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class r32 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public az9<? super f94> c;
    public az9<? super d94> d;
    public qd4 e;
    public cf3<Exception> f;
    public z74<f94> g;
    public z74<d94> h;
    public az9<g94> i;

    /* loaded from: classes7.dex */
    public class a extends w74<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;

        public a(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z74
        /* renamed from: l */
        public String d(f94 f94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f94Var)) == null) ? this.a.Y() : (String) invokeL.objValue;
        }

        @Override // com.repackage.b84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: o */
        public void e(f94 f94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, f94Var, c94Var) == null) {
                super.e(f94Var, c94Var);
                jx1.k("UpdateCoreCallback", "onDownloadError:" + c94Var);
                this.a.e.l(f94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(13L);
                cc3Var.i(c94Var.a);
                cc3Var.d("Framework包下载失败");
                cc3Var.f(c94Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(f94Var, cc3Var));
                }
                f32.c().a(f94Var, this.a.W(), cc3Var);
                ng4.k(f94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: p */
        public void i(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var) == null) {
                super.i(f94Var);
                jx1.k("UpdateCoreCallback", "onFileDownloaded: " + f94Var.i);
                cc3 d0 = this.a.d0(f94Var);
                if (d0 == null) {
                    this.a.e.m(f94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(f94Var);
                        this.a.c.onCompleted();
                    }
                    f84.i().m(f94Var);
                    f32.c().b(f94Var, this.a.W());
                    ke3.a();
                    return;
                }
                this.a.e.l(f94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(f94Var, d0));
                }
                f32.c().a(f94Var, this.a.W(), d0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void c(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, f94Var) == null) {
                super.c(f94Var);
                jx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: r */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, f94Var) == null) {
                super.f(f94Var);
                if (r32.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.h0(f94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends w74<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;

        public b(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z74
        /* renamed from: l */
        public String d(d94 d94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.b84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: o */
        public void e(d94 d94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, d94Var, c94Var) == null) {
                super.e(d94Var, c94Var);
                jx1.k("UpdateCoreCallback", "onDownloadError:" + c94Var);
                this.a.e.l(d94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(14L);
                cc3Var.i(c94Var.a);
                cc3Var.d("Extension下载失败");
                cc3Var.f(c94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(d94Var, cc3Var));
                }
                f32.c().a(d94Var, this.a.W(), cc3Var);
                ng4.k(d94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: p */
        public void i(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d94Var) == null) {
                super.i(d94Var);
                jx1.k("UpdateCoreCallback", "onFileDownloaded: " + d94Var.i);
                cc3 c0 = this.a.c0(d94Var);
                if (c0 == null) {
                    this.a.e.m(d94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(d94Var);
                        this.a.d.onCompleted();
                    }
                    f84.i().m(d94Var);
                    f32.c().b(d94Var, this.a.W());
                    return;
                }
                this.a.e.l(d94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(d94Var, c0));
                }
                f32.c().a(d94Var, this.a.W(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void c(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, d94Var) == null) {
                super.c(d94Var);
                jx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: r */
        public void f(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, d94Var) == null) {
                super.f(d94Var);
                if (r32.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.g0(d94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f94 a;
        public final /* synthetic */ r32 b;

        public c(r32 r32Var, f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, f94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r32Var;
            this.a = f94Var;
        }

        @Override // com.repackage.f32.c
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

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, cc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d94 a;
        public final /* synthetic */ r32 b;

        public d(r32 r32Var, d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, d94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r32Var;
            this.a = d94Var;
        }

        @Override // com.repackage.f32.c
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

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, cc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements uy9.a<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;

        public e(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super f94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.c = az9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements uy9.a<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;

        public f(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super d94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.d = az9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends az9<g94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 e;

        public g(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vy9
        /* renamed from: g */
        public void onNext(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g94Var) == null) {
                jx1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + g94Var.i);
            }
        }

        @Override // com.repackage.vy9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jx1.k("UpdateCoreCallback", "包下载完成");
                this.e.f0();
            }
        }

        @Override // com.repackage.vy9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                jx1.l("UpdateCoreCallback", "OnError", th);
                this.e.e0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755401344, "Lcom/repackage/r32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755401344, "Lcom/repackage/r32;");
                return;
            }
        }
        j = tg1.a;
    }

    public r32(cf3<Exception> cf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = cf3Var;
    }

    @Override // com.repackage.d84
    public void D(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c94Var) == null) {
            super.D(c94Var);
            jx1.k("UpdateCoreCallback", "onFetchError: " + c94Var.toString());
            if (c94Var.a == 1010) {
                f0();
                return;
            }
            e0(new PMSException("UpdateCoreCallback failed by fetch error = " + c94Var, c94Var));
        }
    }

    @Override // com.repackage.d84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.d84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            jx1.k("UpdateCoreCallback", "onNoPackage:");
            f0();
        }
    }

    @Override // com.repackage.d84
    public void H(qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qd4Var) == null) {
            super.H(qd4Var);
            if (qd4Var == null) {
                return;
            }
            this.e = qd4Var;
            if (qd4Var.k()) {
                return;
            }
            a0();
        }
    }

    public abstract int V();

    public abstract PMSDownloadType W();

    public abstract String X();

    public abstract String Y();

    public final az9<g94> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (az9) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(uy9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(uy9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            uy9.i(arrayList).u(Z());
        }
    }

    public void b0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            jx1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            cf3<Exception> cf3Var = this.f;
            if (cf3Var != null) {
                cf3Var.onCallback(exc);
            }
            this.f = null;
        }
    }

    public abstract cc3 c0(d94 d94Var);

    public abstract cc3 d0(f94 f94Var);

    public void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            jx1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            jd4.d(V(), 0L);
            fk3.a(0L);
            b0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            jx1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            jd4.d(V(), currentTimeMillis);
            b0(null);
        }
    }

    public final void g0(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, d94Var) == null) {
            f32.c().d(d94Var, new d(this, d94Var));
        }
    }

    public final void h0(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, f94Var) == null) {
            f32.c().d(f94Var, new c(this, f94Var));
        }
    }

    @Override // com.repackage.d84
    public z74<d94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (z74) invokeV.objValue;
    }

    @Override // com.repackage.d84
    public z74<f94> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (z74) invokeV.objValue;
    }
}
