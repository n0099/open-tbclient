package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c93;
import com.repackage.o22;
import com.repackage.wz2;
import com.repackage.xu9;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class s22 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public k74 A;
    public dv9<o84> B;
    public String c;
    public dv9<? super p84> d;
    public dv9<? super q84> e;
    public dv9<? super n84> f;
    public dv9<? super l84> g;
    public dv9<? super r84> h;
    public yc4 i;
    public p84 j;
    public List<q84> k;
    public n84 l;
    public l84 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public q84 q;
    public long r;
    public final Set<b32> s;
    public final Set<le3<PMSAppInfo>> t;
    public final vd3 u;
    public h74<p84> v;
    public h74<q84> w;
    public final h74<r84> x;
    public h74<n84> y;
    public h74<l84> z;

    /* loaded from: classes7.dex */
    public class a extends e74<p84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        /* renamed from: com.repackage.s22$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0520a implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0520a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    m74.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        @Override // com.repackage.e74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(p84 p84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, p84Var)) == null) {
                int i = p84Var.h;
                if (i == 0) {
                    return k32.g();
                }
                if (i == 1) {
                    return k32.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(p84 p84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, p84Var, k84Var) == null) {
                super.e(p84Var, k84Var);
                sw1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + k84Var.toString());
                this.a.i.l(p84Var);
                lb3 lb3Var = new lb3();
                lb3Var.k(11L);
                lb3Var.i(k84Var.a);
                lb3Var.d("主包下载失败");
                lb3Var.f(k84Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(p84Var, lb3Var));
                }
                o22.c().a(p84Var, this.a.k0(), lb3Var);
                uf4.k(p84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(p84 p84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, p84Var) == null) {
                String l0 = this.a.l0();
                if (s22.C) {
                    xk2.d(l0).e().d(1);
                }
                super.i(p84Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                lb3 z0 = this.a.z0(p84Var);
                sw1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + p84Var.i);
                if (z0 == null) {
                    s22 s22Var = this.a;
                    s22Var.j = p84Var;
                    s22Var.i.m(p84Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(p84Var);
                        if (s22.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    o22.c().b(p84Var, this.a.k0());
                    return;
                }
                this.a.i.l(p84Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(p84Var, z0));
                }
                o22.c().a(p84Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void c(p84 p84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, p84Var) == null) {
                String l0 = this.a.l0();
                if (s22.C) {
                    xk2.d(l0).e().d(1);
                }
                super.c(p84Var);
                sw1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void f(p84 p84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, p84Var) == null) {
                String l0 = this.a.l0();
                if (s22.C) {
                    xk2.d(l0).e().d(1);
                }
                super.f(p84Var);
                if (s22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(p84Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: s */
        public k84 h(p84 p84Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{p84Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (s22.C) {
                    xk2.d(l0).f(p84Var.toString()).d(1);
                }
                C0520a c0520a = new C0520a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                qi2 qi2Var = new qi2();
                qi2Var.v(c0520a);
                qi2Var.K(bundle);
                qi2Var.J(new pi2(p84Var, this.a));
                qi2Var.J(new ni2(p84Var.m, this.a));
                qi2Var.M(readableByteChannel);
                boolean N = qi2Var.N();
                qi2Var.p(c0520a);
                if (s22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    sw1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    uf4.L(file);
                }
                return N ? new k84(2300, "业务层处理下载流成功") : new k84(2301, "业务层处理下载流失败");
            }
            return (k84) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ le3 b;

        public b(s22 s22Var, Collection collection, le3 le3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, collection, le3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = le3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.a) {
                    this.b.a(obj);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements le3<b32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le3 a;
        public final /* synthetic */ s22 b;

        public c(s22 s22Var, le3 le3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, le3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s22Var;
            this.a = le3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(b32 b32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b32Var) == null) {
                this.a.a(b32Var);
                s22 s22Var = this.b;
                s22Var.h0(s22Var.s, b32Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements le3<b32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb3 a;
        public final /* synthetic */ boolean b;

        public d(s22 s22Var, lb3 lb3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, lb3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(b32 b32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b32Var) == null) {
                b32Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements le3<b32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(s22 s22Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(b32 b32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b32Var) == null) {
                b32Var.b(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p84 a;
        public final /* synthetic */ s22 b;

        public f(s22 s22Var, p84 p84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, p84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s22Var;
            this.a = p84Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                s22 s22Var = this.b;
                p84 p84Var = this.a;
                s22Var.j = p84Var;
                s22Var.i.m(p84Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, lb3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q84 a;
        public final /* synthetic */ s22 b;

        public g(s22 s22Var, q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, q84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s22Var;
            this.a = q84Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                s22 s22Var = this.b;
                if (s22Var.k == null) {
                    s22Var.k = new ArrayList();
                }
                q84 q84Var = this.a;
                s22 s22Var2 = this.b;
                q84Var.o = s22Var2.o;
                s22Var2.k.add(q84Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (this.b.i.i()) {
                        return;
                    }
                    this.b.e.onCompleted();
                }
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, lb3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n84 a;
        public final /* synthetic */ s22 b;

        public h(s22 s22Var, n84 n84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, n84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s22Var;
            this.a = n84Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                s22 s22Var = this.b;
                n84 n84Var = this.a;
                s22Var.l = n84Var;
                s22Var.i.m(n84Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, lb3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l84 a;
        public final /* synthetic */ s22 b;

        public i(s22 s22Var, l84 l84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, l84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s22Var;
            this.a = l84Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                sw1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                s22 s22Var = this.b;
                l84 l84Var = this.a;
                s22Var.m = l84Var;
                s22Var.i.m(l84Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                sw1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + lb3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends dv9<o84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 e;

        public j(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.yu9
        /* renamed from: g */
        public void onNext(o84 o84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o84Var) == null) {
                sw1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + o84Var.i);
            }
        }

        @Override // com.repackage.yu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                sw1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.repackage.yu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                sw1.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements xu9.a<p84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public k(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xu9.a, com.repackage.lv9
        public void call(dv9<? super p84> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                this.a.d = dv9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements xu9.a<q84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public l(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xu9.a, com.repackage.lv9
        public void call(dv9<? super q84> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                this.a.e = dv9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements xu9.a<n84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public m(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xu9.a, com.repackage.lv9
        public void call(dv9<? super n84> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                this.a.f = dv9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements xu9.a<l84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public n(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xu9.a, com.repackage.lv9
        public void call(dv9<? super l84> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                this.a.g = dv9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements xu9.a<r84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public o(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xu9.a, com.repackage.lv9
        public void call(dv9<? super r84> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                this.a.h = dv9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends z22<s22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(s22 s22Var, s22 s22Var2) {
            super(s22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, s22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((w22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s22Var;
        }

        @Override // com.repackage.z22, com.repackage.e74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.repackage.z22
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.z22
        public void p(@NonNull q84 q84Var, @Nullable lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, q84Var, lb3Var) == null) {
                super.p(q84Var, lb3Var);
                sw1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + q84Var.i);
                s22 s22Var = this.c;
                if (s22Var.k == null) {
                    s22Var.k = new ArrayList();
                }
                s22 s22Var2 = this.c;
                q84Var.o = s22Var2.o;
                if (lb3Var == null) {
                    s22Var2.k.add(q84Var);
                    this.c.i.m(q84Var);
                    o22.c().b(q84Var, this.c.k0());
                } else {
                    s22Var2.i.l(q84Var);
                    o22.c().a(q84Var, this.c.k0(), lb3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(q84Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void e(q84 q84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, q84Var, k84Var) == null) {
                super.q(q84Var, k84Var);
                sw1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + k84Var.toString());
                this.c.i.l(q84Var);
                lb3 lb3Var = new lb3();
                lb3Var.k(12L);
                lb3Var.i(k84Var.a);
                lb3Var.d("分包下载失败");
                lb3Var.f(k84Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(q84Var, lb3Var));
                }
                o22.c().a(q84Var, this.c.k0(), lb3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z22, com.repackage.e74, com.repackage.h74
        /* renamed from: s */
        public void c(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, q84Var) == null) {
                super.c(q84Var);
                sw1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: u */
        public void f(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q84Var) == null) {
                super.f(q84Var);
                this.c.E0(q84Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends x22<s22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(s22 s22Var, s22 s22Var2) {
            super(s22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, s22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((w22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s22Var;
        }

        @Override // com.repackage.e74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.repackage.x22
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.x22
        public void r(@NonNull r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, r84Var) == null) {
                this.b.i.m(r84Var);
                if (this.b.h != null) {
                    this.b.h.onNext(r84Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.x22
        public void u(r84 r84Var, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, r84Var, lb3Var) == null) {
                sw1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + lb3Var);
                this.b.i.l(r84Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(r84Var, lb3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x22, com.repackage.e74, com.repackage.h74
        /* renamed from: v */
        public void c(r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, r84Var) == null) {
                super.c(r84Var);
                sw1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x22, com.repackage.e74, com.repackage.h74
        /* renamed from: w */
        public void f(r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, r84Var) == null) {
                super.f(r84Var);
                if (s22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends e74<n84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public r(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        @Override // com.repackage.e74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(n84 n84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, n84Var)) == null) {
                int i = n84Var.h;
                if (i == 0) {
                    return k32.h();
                }
                if (i == 1) {
                    return k32.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(n84 n84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n84Var, k84Var) == null) {
                super.e(n84Var, k84Var);
                sw1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + k84Var.toString());
                this.a.i.l(n84Var);
                lb3 lb3Var = new lb3();
                lb3Var.k(13L);
                lb3Var.i(k84Var.a);
                lb3Var.d("Framework包下载失败");
                lb3Var.f(k84Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(n84Var, lb3Var));
                }
                o22.c().a(n84Var, this.a.k0(), lb3Var);
                uf4.k(n84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(n84 n84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, n84Var) == null) {
                super.i(n84Var);
                sw1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + n84Var.i);
                lb3 y0 = this.a.y0(n84Var);
                if (y0 == null) {
                    s22 s22Var = this.a;
                    s22Var.l = n84Var;
                    s22Var.i.m(n84Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(n84Var);
                        this.a.f.onCompleted();
                    }
                    o22.c().b(n84Var, this.a.k0());
                    return;
                }
                this.a.i.l(n84Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(n84Var, y0));
                }
                o22.c().a(n84Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void c(n84 n84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, n84Var) == null) {
                super.c(n84Var);
                sw1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void f(n84 n84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, n84Var) == null) {
                super.f(n84Var);
                if (s22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(n84Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends e74<l84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public s(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        @Override // com.repackage.e74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(l84 l84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, l84Var)) == null) {
                int i = l84Var.h;
                if (i == 0) {
                    return k32.d();
                }
                if (i == 1) {
                    return k32.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(l84 l84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l84Var, k84Var) == null) {
                super.e(l84Var, k84Var);
                sw1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + k84Var.toString());
                this.a.i.l(l84Var);
                lb3 lb3Var = new lb3();
                lb3Var.k(14L);
                lb3Var.i(k84Var.a);
                lb3Var.d("Extension下载失败");
                lb3Var.f(k84Var.toString());
                if (s22.C) {
                    Log.e("SwanAppPkgDownloadCallback", lb3Var.toString());
                }
                this.a.q0(l84Var);
                o22.c().a(l84Var, this.a.k0(), lb3Var);
                uf4.k(l84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(l84 l84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, l84Var) == null) {
                super.i(l84Var);
                sw1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + l84Var.i);
                lb3 x0 = this.a.x0(l84Var);
                if (x0 != null) {
                    if (s22.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + l84Var.toString());
                    }
                    this.a.i.l(l84Var);
                    this.a.q0(l84Var);
                    o22.c().a(l84Var, this.a.k0(), x0);
                    return;
                }
                s22 s22Var = this.a;
                s22Var.m = l84Var;
                s22Var.i.m(l84Var);
                this.a.q0(l84Var);
                o22.c().b(l84Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void c(l84 l84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, l84Var) == null) {
                super.c(l84Var);
                sw1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void f(l84 l84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, l84Var) == null) {
                super.f(l84Var);
                if (s22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(l84Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements k74 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;

        public t(s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s22Var;
        }

        @Override // com.repackage.k74
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (s22.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                s22 s22Var = this.a;
                s22Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    s22Var.o0(pMSAppInfo);
                    qv2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements le3<le3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(s22 s22Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(le3<PMSAppInfo> le3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le3Var) == null) {
                le3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(s22 s22Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.add(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(s22 s22Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s22Var, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755372514, "Lcom/repackage/s22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755372514, "Lcom/repackage/s22;");
                return;
            }
        }
        C = cg1.a;
    }

    public s22(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.r = -1L;
        this.s = new HashSet();
        this.t = new HashSet();
        this.u = new vd3();
        this.v = new a(this);
        this.w = new p(this, this);
        this.x = new q(this, this);
        this.y = new r(this);
        this.z = new s(this);
        this.A = new t(this);
        this.B = new j(this);
        this.o = str;
        this.p = new ArrayList();
    }

    @Override // com.repackage.l74
    public h74<q84> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (h74) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            lu2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(l84 l84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l84Var) == null) {
            o22.c().d(l84Var, new i(this, l84Var));
        }
    }

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k84Var) == null) {
            sw1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + k84Var);
            if (k84Var != null && k84Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, n84Var) == null) {
            o22.c().d(n84Var, new h(this, n84Var));
        }
    }

    @Override // com.repackage.l74
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(p84 p84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, p84Var) == null) {
            o22.c().d(p84Var, new f(this, p84Var));
        }
    }

    @Override // com.repackage.l74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(q84 q84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q84Var) == null) {
            o22.c().d(q84Var, new g(this, q84Var));
        }
    }

    public lb3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    lb3 lb3Var = new lb3();
                    lb3Var.k(10L);
                    lb3Var.i(2903L);
                    lb3Var.d("Server未返回主包&AppInfo");
                    return lb3Var;
                }
                PMSAppInfo u2 = n74.i().u(this.o);
                if (u2 == null) {
                    lb3 lb3Var2 = new lb3();
                    lb3Var2.k(10L);
                    lb3Var2.i(2904L);
                    lb3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return lb3Var2;
                }
                this.n = u2;
                k32.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (n74.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                lb3 lb3Var3 = new lb3();
                lb3Var3.k(10L);
                lb3Var3.i(2906L);
                lb3Var3.d("更新DB失败");
                return lb3Var3;
            }
            p84 p84Var = this.j;
            if (p84Var != null) {
                k32.k(pMSAppInfo, p84Var);
            } else if (l32.f(this.k)) {
                q84 q84Var = this.k.get(0);
                this.q = q84Var;
                q84Var.o = this.o;
                k32.l(this.n, q84Var);
            } else {
                PMSAppInfo u3 = n74.i().u(this.o);
                if (u3 == null) {
                    lb3 lb3Var4 = new lb3();
                    lb3Var4.k(10L);
                    lb3Var4.i(2905L);
                    lb3Var4.d("Server未返回包数据，本地也没有数据");
                    return lb3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (n74.i().b(this.j, this.k, this.l, this.m, this.n)) {
                k32.o(this.n);
                return null;
            }
            lb3 lb3Var5 = new lb3();
            lb3Var5.k(10L);
            lb3Var5.i(2906L);
            lb3Var5.d("更新DB失败");
            return lb3Var5;
        }
        return (lb3) invokeV.objValue;
    }

    @Override // com.repackage.l74
    public void G(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yc4Var) == null) {
            super.G(yc4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (yc4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + yc4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = yc4Var;
            if (yc4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = n74.i().u(this.o);
            sw1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                p84 p84Var = this.j;
                if (p84Var != null) {
                    p84Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                n74.i().l(u2);
            }
        }
    }

    public s22 e0(le3<PMSAppInfo> le3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, le3Var)) == null) {
            f0(this.t, le3Var);
            return this;
        }
        return (s22) invokeL.objValue;
    }

    public final synchronized <CallbackT> s22 f0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (s22) invokeLL.objValue;
    }

    public synchronized s22 g0(b32 b32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, b32Var)) == null) {
            synchronized (this) {
                f0(this.s, b32Var);
            }
            return this;
        }
        return (s22) invokeL.objValue;
    }

    public final synchronized <CallbackT> s22 h0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new w(this, collection, callbackt));
                }
            }
            return this;
        }
        return (s22) invokeLL.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = getClass().toString();
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType k0();

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? m74.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                n74.i().z(this.o, i2);
            } else {
                n74.i().z(this.o, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(xu9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(xu9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(xu9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(xu9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(xu9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            xu9.i(arrayList).u(this.B);
        }
    }

    public s22 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (s22) invokeL.objValue;
    }

    @Override // com.repackage.l74
    public k74 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (k74) invokeV.objValue;
    }

    public final synchronized <CallbackT> s22 p0(@NonNull Collection<CallbackT> collection, @NonNull le3<CallbackT> le3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, le3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, le3Var));
            }
            return this;
        }
        return (s22) invokeLL.objValue;
    }

    @Override // com.repackage.l74
    public h74<r84> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (h74) invokeV.objValue;
    }

    public final void q0(l84 l84Var) {
        dv9<? super l84> dv9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, l84Var) == null) || (dv9Var = this.g) == null) {
            return;
        }
        dv9Var.onNext(l84Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.l74
    public h74<l84> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (h74) invokeV.objValue;
    }

    public s22 r0(@NonNull le3<b32> le3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, le3Var)) == null) {
            p0(this.s, new c(this, le3Var));
            return this;
        }
        return (s22) invokeL.objValue;
    }

    @Override // com.repackage.l74
    public h74<n84> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (h74) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, lb3 lb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, lb3Var) == null) {
            r0(new d(this, lb3Var, z));
        }
    }

    @Override // com.repackage.l74
    public h74<p84> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (h74) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = n74.i().u(this.o);
        if (u2 == null) {
            sw1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (n74.i().l(this.n)) {
            k32.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            sw1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public lb3 x0(l84 l84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, l84Var)) == null) {
            ya2 ya2Var = new ya2();
            ya2Var.b = l84Var.i;
            ya2Var.a = l84Var.j;
            ya2Var.c = l84Var.a;
            ya2Var.d = l84Var.m;
            if (ba2.b(l84Var.h, ya2Var) == null) {
                return null;
            }
            lb3 lb3Var = new lb3();
            lb3Var.k(14L);
            lb3Var.b(2908L);
            lb3Var.d("Extension包更新失败");
            return lb3Var;
        }
        return (lb3) invokeL.objValue;
    }

    public lb3 y0(n84 n84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, n84Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + n84Var);
            }
            c93.b c2 = c93.c(n84Var, n84Var.h);
            if (!TextUtils.isEmpty(n84Var.a)) {
                sw1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + n84Var.a);
                uf4.k(n84Var.a);
            }
            if (c2.c()) {
                return null;
            }
            lb3 lb3Var = new lb3();
            lb3Var.k(13L);
            lb3Var.b(2907L);
            lb3Var.d("Core包更新失败");
            return lb3Var;
        }
        return (lb3) invokeL.objValue;
    }

    public lb3 z0(p84 p84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, p84Var)) == null) {
            if (p84Var == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(11L);
                lb3Var.i(2310L);
                lb3Var.f("pkg info is empty");
                pb3.a().f(lb3Var);
                return lb3Var;
            }
            return null;
        }
        return (lb3) invokeL.objValue;
    }
}
