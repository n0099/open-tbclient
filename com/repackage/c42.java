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
import com.repackage.q32;
import com.repackage.wx9;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class c42 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public cy9<? super p94> c;
    public cy9<? super n94> d;
    public ae4 e;
    public nf3<Exception> f;
    public j84<p94> g;
    public j84<n94> h;
    public cy9<q94> i;

    /* loaded from: classes5.dex */
    public class a extends g84<p94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;

        public a(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(p94 p94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, p94Var)) == null) ? this.a.Y() : (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(p94 p94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, p94Var, m94Var) == null) {
                super.e(p94Var, m94Var);
                ux1.k("UpdateCoreCallback", "onDownloadError:" + m94Var);
                this.a.e.l(p94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(13L);
                nc3Var.i(m94Var.a);
                nc3Var.d("Framework包下载失败");
                nc3Var.f(m94Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(p94Var, nc3Var));
                }
                q32.c().a(p94Var, this.a.W(), nc3Var);
                xg4.k(p94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p94Var) == null) {
                super.i(p94Var);
                ux1.k("UpdateCoreCallback", "onFileDownloaded: " + p94Var.i);
                nc3 d0 = this.a.d0(p94Var);
                if (d0 == null) {
                    this.a.e.m(p94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(p94Var);
                        this.a.c.onCompleted();
                    }
                    p84.i().m(p94Var);
                    q32.c().b(p94Var, this.a.W());
                    ve3.a();
                    return;
                }
                this.a.e.l(p94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(p94Var, d0));
                }
                q32.c().a(p94Var, this.a.W(), d0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void c(p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, p94Var) == null) {
                super.c(p94Var);
                ux1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void f(p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, p94Var) == null) {
                super.f(p94Var);
                if (c42.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.h0(p94Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends g84<n94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;

        public b(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(n94 n94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, n94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(n94 n94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, n94Var, m94Var) == null) {
                super.e(n94Var, m94Var);
                ux1.k("UpdateCoreCallback", "onDownloadError:" + m94Var);
                this.a.e.l(n94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(14L);
                nc3Var.i(m94Var.a);
                nc3Var.d("Extension下载失败");
                nc3Var.f(m94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(n94Var, nc3Var));
                }
                q32.c().a(n94Var, this.a.W(), nc3Var);
                xg4.k(n94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n94Var) == null) {
                super.i(n94Var);
                ux1.k("UpdateCoreCallback", "onFileDownloaded: " + n94Var.i);
                nc3 c0 = this.a.c0(n94Var);
                if (c0 == null) {
                    this.a.e.m(n94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(n94Var);
                        this.a.d.onCompleted();
                    }
                    p84.i().m(n94Var);
                    q32.c().b(n94Var, this.a.W());
                    return;
                }
                this.a.e.l(n94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(n94Var, c0));
                }
                q32.c().a(n94Var, this.a.W(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void c(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, n94Var) == null) {
                super.c(n94Var);
                ux1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void f(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, n94Var) == null) {
                super.f(n94Var);
                if (c42.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.g0(n94Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p94 a;
        public final /* synthetic */ c42 b;

        public c(c42 c42Var, p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var, p94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c42Var;
            this.a = p94Var;
        }

        @Override // com.repackage.q32.c
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

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, nc3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n94 a;
        public final /* synthetic */ c42 b;

        public d(c42 c42Var, n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var, n94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c42Var;
            this.a = n94Var;
        }

        @Override // com.repackage.q32.c
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

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, nc3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wx9.a<p94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;

        public e(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super p94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.c = cy9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements wx9.a<n94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;

        public f(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super n94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.d = cy9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends cy9<q94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 e;

        public g(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xx9
        /* renamed from: g */
        public void onNext(q94 q94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q94Var) == null) {
                ux1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + q94Var.i);
            }
        }

        @Override // com.repackage.xx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ux1.k("UpdateCoreCallback", "包下载完成");
                this.e.f0();
            }
        }

        @Override // com.repackage.xx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                ux1.l("UpdateCoreCallback", "OnError", th);
                this.e.e0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755847248, "Lcom/repackage/c42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755847248, "Lcom/repackage/c42;");
                return;
            }
        }
        j = eh1.a;
    }

    public c42(nf3<Exception> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = nf3Var;
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m94Var) == null) {
            super.D(m94Var);
            ux1.k("UpdateCoreCallback", "onFetchError: " + m94Var.toString());
            if (m94Var.a == 1010) {
                f0();
                return;
            }
            e0(new PMSException("UpdateCoreCallback failed by fetch error = " + m94Var, m94Var));
        }
    }

    @Override // com.repackage.n84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            ux1.k("UpdateCoreCallback", "onNoPackage:");
            f0();
        }
    }

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ae4Var) == null) {
            super.H(ae4Var);
            if (ae4Var == null) {
                return;
            }
            this.e = ae4Var;
            if (ae4Var.k()) {
                return;
            }
            a0();
        }
    }

    public abstract int V();

    public abstract PMSDownloadType W();

    public abstract String X();

    public abstract String Y();

    public final cy9<q94> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (cy9) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(wx9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(wx9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            wx9.i(arrayList).u(Z());
        }
    }

    public void b0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            ux1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            nf3<Exception> nf3Var = this.f;
            if (nf3Var != null) {
                nf3Var.onCallback(exc);
            }
            this.f = null;
        }
    }

    public abstract nc3 c0(n94 n94Var);

    public abstract nc3 d0(p94 p94Var);

    public void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            ux1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            td4.d(V(), 0L);
            qk3.a(0L);
            b0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ux1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            td4.d(V(), currentTimeMillis);
            b0(null);
        }
    }

    public final void g0(n94 n94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, n94Var) == null) {
            q32.c().d(n94Var, new d(this, n94Var));
        }
    }

    public final void h0(p94 p94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, p94Var) == null) {
            q32.c().d(p94Var, new c(this, p94Var));
        }
    }

    @Override // com.repackage.n84
    public j84<n94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (j84) invokeV.objValue;
    }

    @Override // com.repackage.n84
    public j84<p94> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (j84) invokeV.objValue;
    }
}
