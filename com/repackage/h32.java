package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
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
import com.repackage.d32;
import com.repackage.l03;
import com.repackage.r93;
import com.repackage.ur9;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class h32 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public z74 A;
    public as9<d94> B;
    public String c;
    public as9<? super e94> d;
    public as9<? super f94> e;
    public as9<? super c94> f;
    public as9<? super a94> g;
    public as9<? super g94> h;
    public nd4 i;
    public e94 j;
    public List<f94> k;
    public c94 l;
    public a94 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public f94 q;
    public long r;
    public final Set<q32> s;
    public final Set<af3<PMSAppInfo>> t;
    public final ke3 u;
    public w74<e94> v;
    public w74<f94> w;
    public final w74<g94> x;
    public w74<c94> y;
    public w74<a94> z;

    /* loaded from: classes6.dex */
    public class a extends t74<e94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        /* renamed from: com.repackage.h32$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0646a implements af3<l03.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0646a(a aVar) {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(l03.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    b84.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        @Override // com.repackage.t74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(e94 e94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e94Var)) == null) {
                int i = e94Var.h;
                if (i == 0) {
                    return z32.g();
                }
                if (i == 1) {
                    return z32.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(e94 e94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, e94Var, z84Var) == null) {
                super.e(e94Var, z84Var);
                hx1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + z84Var.toString());
                this.a.i.l(e94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(11L);
                ac3Var.i(z84Var.a);
                ac3Var.d("主包下载失败");
                ac3Var.f(z84Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(e94Var, ac3Var));
                }
                d32.c().a(e94Var, this.a.k0(), ac3Var);
                jg4.k(e94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, e94Var) == null) {
                String l0 = this.a.l0();
                if (h32.C) {
                    ml2.d(l0).e().d(1);
                }
                super.i(e94Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                ac3 z0 = this.a.z0(e94Var);
                hx1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + e94Var.i);
                if (z0 == null) {
                    h32 h32Var = this.a;
                    h32Var.j = e94Var;
                    h32Var.i.m(e94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(e94Var);
                        if (h32.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    d32.c().b(e94Var, this.a.k0());
                    return;
                }
                this.a.i.l(e94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(e94Var, z0));
                }
                d32.c().a(e94Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void c(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, e94Var) == null) {
                String l0 = this.a.l0();
                if (h32.C) {
                    ml2.d(l0).e().d(1);
                }
                super.c(e94Var);
                hx1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, e94Var) == null) {
                String l0 = this.a.l0();
                if (h32.C) {
                    ml2.d(l0).e().d(1);
                }
                super.f(e94Var);
                if (h32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(e94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: s */
        public z84 h(e94 e94Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{e94Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (h32.C) {
                    ml2.d(l0).f(e94Var.toString()).d(1);
                }
                C0646a c0646a = new C0646a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                fj2 fj2Var = new fj2();
                fj2Var.u(c0646a);
                fj2Var.K(bundle);
                fj2Var.J(new ej2(e94Var, this.a));
                fj2Var.J(new cj2(e94Var.m, this.a));
                fj2Var.M(readableByteChannel);
                boolean N = fj2Var.N();
                fj2Var.o(c0646a);
                if (h32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    hx1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    jg4.L(file);
                }
                return N ? new z84(2300, "业务层处理下载流成功") : new z84(2301, "业务层处理下载流失败");
            }
            return (z84) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ af3 b;

        public b(h32 h32Var, Collection collection, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, collection, af3Var};
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
            this.b = af3Var;
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

    /* loaded from: classes6.dex */
    public class c implements af3<q32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;
        public final /* synthetic */ h32 b;

        public c(h32 h32Var, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
            this.a = af3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q32Var) == null) {
                this.a.a(q32Var);
                h32 h32Var = this.b;
                h32Var.h0(h32Var.s, q32Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements af3<q32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ac3 a;
        public final /* synthetic */ boolean b;

        public d(h32 h32Var, ac3 ac3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, ac3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ac3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q32Var) == null) {
                q32Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements af3<q32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(h32 h32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, pMSAppInfo};
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(q32 q32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q32Var) == null) {
                q32Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e94 a;
        public final /* synthetic */ h32 b;

        public f(h32 h32Var, e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, e94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
            this.a = e94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h32 h32Var = this.b;
                e94 e94Var = this.a;
                h32Var.j = e94Var;
                h32Var.i.m(e94Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ac3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f94 a;
        public final /* synthetic */ h32 b;

        public g(h32 h32Var, f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, f94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
            this.a = f94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h32 h32Var = this.b;
                if (h32Var.k == null) {
                    h32Var.k = new ArrayList();
                }
                f94 f94Var = this.a;
                h32 h32Var2 = this.b;
                f94Var.o = h32Var2.o;
                h32Var2.k.add(f94Var);
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

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, ac3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c94 a;
        public final /* synthetic */ h32 b;

        public h(h32 h32Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, c94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
            this.a = c94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h32 h32Var = this.b;
                c94 c94Var = this.a;
                h32Var.l = c94Var;
                h32Var.i.m(c94Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, ac3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a94 a;
        public final /* synthetic */ h32 b;

        public i(h32 h32Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, a94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
            this.a = a94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                hx1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                h32 h32Var = this.b;
                a94 a94Var = this.a;
                h32Var.m = a94Var;
                h32Var.i.m(a94Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                hx1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + ac3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends as9<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 e;

        public j(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vr9
        /* renamed from: g */
        public void onNext(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d94Var) == null) {
                hx1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + d94Var.i);
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hx1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                hx1.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ur9.a<e94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public k(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super e94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.d = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ur9.a<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public l(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super f94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.e = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ur9.a<c94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public m(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super c94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.f = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ur9.a<a94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public n(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super a94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.g = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ur9.a<g94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public o(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super g94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.h = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends o32<h32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(h32 h32Var, h32 h32Var2) {
            super(h32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, h32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h32Var;
        }

        @Override // com.repackage.o32, com.repackage.t74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.repackage.o32
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.o32
        public void p(@NonNull f94 f94Var, @Nullable ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, f94Var, ac3Var) == null) {
                super.p(f94Var, ac3Var);
                hx1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + f94Var.i);
                h32 h32Var = this.c;
                if (h32Var.k == null) {
                    h32Var.k = new ArrayList();
                }
                h32 h32Var2 = this.c;
                f94Var.o = h32Var2.o;
                if (ac3Var == null) {
                    h32Var2.k.add(f94Var);
                    this.c.i.m(f94Var);
                    d32.c().b(f94Var, this.c.k0());
                } else {
                    h32Var2.i.l(f94Var);
                    d32.c().a(f94Var, this.c.k0(), ac3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(f94Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void e(f94 f94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, f94Var, z84Var) == null) {
                super.q(f94Var, z84Var);
                hx1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + z84Var.toString());
                this.c.i.l(f94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(12L);
                ac3Var.i(z84Var.a);
                ac3Var.d("分包下载失败");
                ac3Var.f(z84Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(f94Var, ac3Var));
                }
                d32.c().a(f94Var, this.c.k0(), ac3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o32, com.repackage.t74, com.repackage.w74
        /* renamed from: s */
        public void c(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, f94Var) == null) {
                super.c(f94Var);
                hx1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: u */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var) == null) {
                super.f(f94Var);
                this.c.E0(f94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends m32<h32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(h32 h32Var, h32 h32Var2) {
            super(h32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, h32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
        }

        @Override // com.repackage.t74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.repackage.m32
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.m32
        public void r(@NonNull g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, g94Var) == null) {
                this.b.i.m(g94Var);
                if (this.b.h != null) {
                    this.b.h.onNext(g94Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.m32
        public void u(g94 g94Var, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, g94Var, ac3Var) == null) {
                hx1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + ac3Var);
                this.b.i.l(g94Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(g94Var, ac3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m32, com.repackage.t74, com.repackage.w74
        /* renamed from: v */
        public void c(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, g94Var) == null) {
                super.c(g94Var);
                hx1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m32, com.repackage.t74, com.repackage.w74
        /* renamed from: w */
        public void f(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, g94Var) == null) {
                super.f(g94Var);
                if (h32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends t74<c94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public r(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        @Override // com.repackage.t74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(c94 c94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c94Var)) == null) {
                int i = c94Var.h;
                if (i == 0) {
                    return z32.h();
                }
                if (i == 1) {
                    return z32.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(c94 c94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c94Var, z84Var) == null) {
                super.e(c94Var, z84Var);
                hx1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + z84Var.toString());
                this.a.i.l(c94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(13L);
                ac3Var.i(z84Var.a);
                ac3Var.d("Framework包下载失败");
                ac3Var.f(z84Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(c94Var, ac3Var));
                }
                d32.c().a(c94Var, this.a.k0(), ac3Var);
                jg4.k(c94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, c94Var) == null) {
                super.i(c94Var);
                hx1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + c94Var.i);
                ac3 y0 = this.a.y0(c94Var);
                if (y0 == null) {
                    h32 h32Var = this.a;
                    h32Var.l = c94Var;
                    h32Var.i.m(c94Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(c94Var);
                        this.a.f.onCompleted();
                    }
                    d32.c().b(c94Var, this.a.k0());
                    return;
                }
                this.a.i.l(c94Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(c94Var, y0));
                }
                d32.c().a(c94Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void c(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, c94Var) == null) {
                super.c(c94Var);
                hx1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, c94Var) == null) {
                super.f(c94Var);
                if (h32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(c94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends t74<a94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public s(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        @Override // com.repackage.t74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(a94 a94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, a94Var)) == null) {
                int i = a94Var.h;
                if (i == 0) {
                    return z32.d();
                }
                if (i == 1) {
                    return z32.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(a94 a94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a94Var, z84Var) == null) {
                super.e(a94Var, z84Var);
                hx1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + z84Var.toString());
                this.a.i.l(a94Var);
                ac3 ac3Var = new ac3();
                ac3Var.k(14L);
                ac3Var.i(z84Var.a);
                ac3Var.d("Extension下载失败");
                ac3Var.f(z84Var.toString());
                if (h32.C) {
                    Log.e("SwanAppPkgDownloadCallback", ac3Var.toString());
                }
                this.a.q0(a94Var);
                d32.c().a(a94Var, this.a.k0(), ac3Var);
                jg4.k(a94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, a94Var) == null) {
                super.i(a94Var);
                hx1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + a94Var.i);
                ac3 x0 = this.a.x0(a94Var);
                if (x0 != null) {
                    if (h32.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + a94Var.toString());
                    }
                    this.a.i.l(a94Var);
                    this.a.q0(a94Var);
                    d32.c().a(a94Var, this.a.k0(), x0);
                    return;
                }
                h32 h32Var = this.a;
                h32Var.m = a94Var;
                h32Var.i.m(a94Var);
                this.a.q0(a94Var);
                d32.c().b(a94Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void c(a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, a94Var) == null) {
                super.c(a94Var);
                hx1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, a94Var) == null) {
                super.f(a94Var);
                if (h32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(a94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements z74 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 a;

        public t(h32 h32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h32Var;
        }

        @Override // com.repackage.z74
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (h32.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                h32 h32Var = this.a;
                h32Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    h32Var.o0(pMSAppInfo);
                    fw2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements af3<af3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(h32 h32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, pMSAppInfo};
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(af3<PMSAppInfo> af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af3Var) == null) {
                af3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(h32 h32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, collection, obj};
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

    /* loaded from: classes6.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(h32 h32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755699254, "Lcom/repackage/h32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755699254, "Lcom/repackage/h32;");
                return;
            }
        }
        C = rg1.a;
    }

    public h32(String str) {
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
        this.u = new ke3();
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

    @Override // com.repackage.a84
    public w74<f94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (w74) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            av2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a94Var) == null) {
            d32.c().d(a94Var, new i(this, a94Var));
        }
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z84Var) == null) {
            hx1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + z84Var);
            if (z84Var != null && z84Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c94Var) == null) {
            d32.c().d(c94Var, new h(this, c94Var));
        }
    }

    @Override // com.repackage.a84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(e94 e94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, e94Var) == null) {
            d32.c().d(e94Var, new f(this, e94Var));
        }
    }

    @Override // com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var) == null) {
            d32.c().d(f94Var, new g(this, f94Var));
        }
    }

    public ac3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    ac3 ac3Var = new ac3();
                    ac3Var.k(10L);
                    ac3Var.i(2903L);
                    ac3Var.d("Server未返回主包&AppInfo");
                    return ac3Var;
                }
                PMSAppInfo u2 = c84.i().u(this.o);
                if (u2 == null) {
                    ac3 ac3Var2 = new ac3();
                    ac3Var2.k(10L);
                    ac3Var2.i(2904L);
                    ac3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return ac3Var2;
                }
                this.n = u2;
                z32.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (c84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                ac3 ac3Var3 = new ac3();
                ac3Var3.k(10L);
                ac3Var3.i(2906L);
                ac3Var3.d("更新DB失败");
                return ac3Var3;
            }
            e94 e94Var = this.j;
            if (e94Var != null) {
                z32.k(pMSAppInfo, e94Var);
            } else if (a42.f(this.k)) {
                f94 f94Var = this.k.get(0);
                this.q = f94Var;
                f94Var.o = this.o;
                z32.l(this.n, f94Var);
            } else {
                PMSAppInfo u3 = c84.i().u(this.o);
                if (u3 == null) {
                    ac3 ac3Var4 = new ac3();
                    ac3Var4.k(10L);
                    ac3Var4.i(2905L);
                    ac3Var4.d("Server未返回包数据，本地也没有数据");
                    return ac3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (c84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                z32.o(this.n);
                return null;
            }
            ac3 ac3Var5 = new ac3();
            ac3Var5.k(10L);
            ac3Var5.i(2906L);
            ac3Var5.d("更新DB失败");
            return ac3Var5;
        }
        return (ac3) invokeV.objValue;
    }

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nd4Var) == null) {
            super.G(nd4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (nd4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + nd4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = nd4Var;
            if (nd4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = c84.i().u(this.o);
            hx1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                e94 e94Var = this.j;
                if (e94Var != null) {
                    e94Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                c84.i().l(u2);
            }
        }
    }

    public h32 e0(af3<PMSAppInfo> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, af3Var)) == null) {
            f0(this.t, af3Var);
            return this;
        }
        return (h32) invokeL.objValue;
    }

    public final synchronized <CallbackT> h32 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (h32) invokeLL.objValue;
    }

    public synchronized h32 g0(q32 q32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, q32Var)) == null) {
            synchronized (this) {
                f0(this.s, q32Var);
            }
            return this;
        }
        return (h32) invokeL.objValue;
    }

    public final synchronized <CallbackT> h32 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (h32) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? b84.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                c84.i().z(this.o, i2);
            } else {
                c84.i().z(this.o, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(ur9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(ur9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(ur9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(ur9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(ur9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ur9.i(arrayList).u(this.B);
        }
    }

    public h32 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.repackage.a84
    public z74 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (z74) invokeV.objValue;
    }

    public final synchronized <CallbackT> h32 p0(@NonNull Collection<CallbackT> collection, @NonNull af3<CallbackT> af3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, af3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, af3Var));
            }
            return this;
        }
        return (h32) invokeLL.objValue;
    }

    @Override // com.repackage.a84
    public w74<g94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (w74) invokeV.objValue;
    }

    public final void q0(a94 a94Var) {
        as9<? super a94> as9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, a94Var) == null) || (as9Var = this.g) == null) {
            return;
        }
        as9Var.onNext(a94Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.a84
    public w74<a94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (w74) invokeV.objValue;
    }

    public h32 r0(@NonNull af3<q32> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, af3Var)) == null) {
            p0(this.s, new c(this, af3Var));
            return this;
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.repackage.a84
    public w74<c94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (w74) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, ac3Var) == null) {
            r0(new d(this, ac3Var, z));
        }
    }

    @Override // com.repackage.a84
    public w74<e94> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (w74) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = c84.i().u(this.o);
        if (u2 == null) {
            hx1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (c84.i().l(this.n)) {
            z32.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            hx1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public ac3 x0(a94 a94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, a94Var)) == null) {
            nb2 nb2Var = new nb2();
            nb2Var.b = a94Var.i;
            nb2Var.a = a94Var.j;
            nb2Var.c = a94Var.a;
            nb2Var.d = a94Var.m;
            if (qa2.b(a94Var.h, nb2Var) == null) {
                return null;
            }
            ac3 ac3Var = new ac3();
            ac3Var.k(14L);
            ac3Var.b(2908L);
            ac3Var.d("Extension包更新失败");
            return ac3Var;
        }
        return (ac3) invokeL.objValue;
    }

    public ac3 y0(c94 c94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, c94Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + c94Var);
            }
            r93.b c2 = r93.c(c94Var, c94Var.h);
            if (!TextUtils.isEmpty(c94Var.a)) {
                hx1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + c94Var.a);
                jg4.k(c94Var.a);
            }
            if (c2.c()) {
                return null;
            }
            ac3 ac3Var = new ac3();
            ac3Var.k(13L);
            ac3Var.b(2907L);
            ac3Var.d("Core包更新失败");
            return ac3Var;
        }
        return (ac3) invokeL.objValue;
    }

    public ac3 z0(e94 e94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, e94Var)) == null) {
            if (e94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(11L);
                ac3Var.i(2310L);
                ac3Var.f("pkg info is empty");
                ec3.a().f(ac3Var);
                return ac3Var;
            }
            return null;
        }
        return (ac3) invokeL.objValue;
    }
}
