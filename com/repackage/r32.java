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
import com.repackage.bz9;
import com.repackage.f32;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class r32 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public hz9<? super e94> c;
    public hz9<? super c94> d;
    public pd4 e;
    public cf3<Exception> f;
    public y74<e94> g;
    public y74<c94> h;
    public hz9<f94> i;

    /* loaded from: classes7.dex */
    public class a extends v74<e94> {
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
        @Override // com.repackage.y74
        /* renamed from: l */
        public String d(e94 e94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e94Var)) == null) ? this.a.Y() : (String) invokeL.objValue;
        }

        @Override // com.repackage.a84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: o */
        public void e(e94 e94Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, e94Var, b94Var) == null) {
                super.e(e94Var, b94Var);
                jx1.k("UpdateCoreCallback", "onDownloadError:" + b94Var);
                this.a.e.l(e94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(13L);
                cc3Var.i(b94Var.a);
                cc3Var.d("Framework包下载失败");
                cc3Var.f(b94Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(e94Var, cc3Var));
                }
                f32.c().a(e94Var, this.a.W(), cc3Var);
                mg4.k(e94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: p */
        public void i(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e94Var) == null) {
                super.i(e94Var);
                jx1.k("UpdateCoreCallback", "onFileDownloaded: " + e94Var.i);
                cc3 d0 = this.a.d0(e94Var);
                if (d0 == null) {
                    this.a.e.m(e94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(e94Var);
                        this.a.c.onCompleted();
                    }
                    e84.i().m(e94Var);
                    f32.c().b(e94Var, this.a.W());
                    ke3.a();
                    return;
                }
                this.a.e.l(e94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(e94Var, d0));
                }
                f32.c().a(e94Var, this.a.W(), d0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: q */
        public void c(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, e94Var) == null) {
                super.c(e94Var);
                jx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: r */
        public void f(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, e94Var) == null) {
                super.f(e94Var);
                if (r32.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.h0(e94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends v74<c94> {
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
        @Override // com.repackage.y74
        /* renamed from: l */
        public String d(c94 c94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.a84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: o */
        public void e(c94 c94Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, c94Var, b94Var) == null) {
                super.e(c94Var, b94Var);
                jx1.k("UpdateCoreCallback", "onDownloadError:" + b94Var);
                this.a.e.l(c94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(14L);
                cc3Var.i(b94Var.a);
                cc3Var.d("Extension下载失败");
                cc3Var.f(b94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(c94Var, cc3Var));
                }
                f32.c().a(c94Var, this.a.W(), cc3Var);
                mg4.k(c94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: p */
        public void i(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c94Var) == null) {
                super.i(c94Var);
                jx1.k("UpdateCoreCallback", "onFileDownloaded: " + c94Var.i);
                cc3 c0 = this.a.c0(c94Var);
                if (c0 == null) {
                    this.a.e.m(c94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(c94Var);
                        this.a.d.onCompleted();
                    }
                    e84.i().m(c94Var);
                    f32.c().b(c94Var, this.a.W());
                    return;
                }
                this.a.e.l(c94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(c94Var, c0));
                }
                f32.c().a(c94Var, this.a.W(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: q */
        public void c(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, c94Var) == null) {
                super.c(c94Var);
                jx1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: r */
        public void f(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, c94Var) == null) {
                super.f(c94Var);
                if (r32.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.g0(c94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e94 a;
        public final /* synthetic */ r32 b;

        public c(r32 r32Var, e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, e94Var};
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
            this.a = e94Var;
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
        public final /* synthetic */ c94 a;
        public final /* synthetic */ r32 b;

        public d(r32 r32Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, c94Var};
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
            this.a = c94Var;
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
    public class e implements bz9.a<e94> {
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
        @Override // com.repackage.bz9.a, com.repackage.pz9
        public void call(hz9<? super e94> hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz9Var) == null) {
                this.a.c = hz9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements bz9.a<c94> {
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
        @Override // com.repackage.bz9.a, com.repackage.pz9
        public void call(hz9<? super c94> hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz9Var) == null) {
                this.a.d = hz9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends hz9<f94> {
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
        @Override // com.repackage.cz9
        /* renamed from: g */
        public void onNext(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f94Var) == null) {
                jx1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + f94Var.i);
            }
        }

        @Override // com.repackage.cz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jx1.k("UpdateCoreCallback", "包下载完成");
                this.e.f0();
            }
        }

        @Override // com.repackage.cz9
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

    @Override // com.repackage.c84
    public void D(b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b94Var) == null) {
            super.D(b94Var);
            jx1.k("UpdateCoreCallback", "onFetchError: " + b94Var.toString());
            if (b94Var.a == 1010) {
                f0();
                return;
            }
            e0(new PMSException("UpdateCoreCallback failed by fetch error = " + b94Var, b94Var));
        }
    }

    @Override // com.repackage.c84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.c84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            jx1.k("UpdateCoreCallback", "onNoPackage:");
            f0();
        }
    }

    @Override // com.repackage.c84
    public void H(pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pd4Var) == null) {
            super.H(pd4Var);
            if (pd4Var == null) {
                return;
            }
            this.e = pd4Var;
            if (pd4Var.k()) {
                return;
            }
            a0();
        }
    }

    public abstract int V();

    public abstract PMSDownloadType W();

    public abstract String X();

    public abstract String Y();

    public final hz9<f94> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (hz9) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(bz9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(bz9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            bz9.i(arrayList).u(Z());
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

    public abstract cc3 c0(c94 c94Var);

    public abstract cc3 d0(e94 e94Var);

    public void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            jx1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            id4.d(V(), 0L);
            fk3.a(0L);
            b0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            jx1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            id4.d(V(), currentTimeMillis);
            b0(null);
        }
    }

    public final void g0(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c94Var) == null) {
            f32.c().d(c94Var, new d(this, c94Var));
        }
    }

    public final void h0(e94 e94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, e94Var) == null) {
            f32.c().d(e94Var, new c(this, e94Var));
        }
    }

    @Override // com.repackage.c84
    public y74<c94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (y74) invokeV.objValue;
    }

    @Override // com.repackage.c84
    public y74<e94> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (y74) invokeV.objValue;
    }
}
