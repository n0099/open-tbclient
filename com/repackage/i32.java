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
import com.repackage.e32;
import com.repackage.m03;
import com.repackage.s93;
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
public abstract class i32 extends m32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public a84 A;
    public as9<e94> B;
    public String c;
    public as9<? super f94> d;
    public as9<? super g94> e;
    public as9<? super d94> f;
    public as9<? super b94> g;
    public as9<? super h94> h;
    public od4 i;
    public f94 j;
    public List<g94> k;
    public d94 l;
    public b94 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public g94 q;
    public long r;
    public final Set<r32> s;
    public final Set<bf3<PMSAppInfo>> t;
    public final le3 u;
    public x74<f94> v;
    public x74<g94> w;
    public final x74<h94> x;
    public x74<d94> y;
    public x74<b94> z;

    /* loaded from: classes6.dex */
    public class a extends u74<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        /* renamed from: com.repackage.i32$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0503a implements bf3<m03.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0503a(a aVar) {
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
            @Override // com.repackage.bf3
            /* renamed from: b */
            public void a(m03.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    c84.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        @Override // com.repackage.u74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(f94 f94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f94Var)) == null) {
                int i = f94Var.h;
                if (i == 0) {
                    return a42.g();
                }
                if (i == 1) {
                    return a42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(f94 f94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, f94Var, a94Var) == null) {
                super.e(f94Var, a94Var);
                ix1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + a94Var.toString());
                this.a.i.l(f94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(11L);
                bc3Var.i(a94Var.a);
                bc3Var.d("主包下载失败");
                bc3Var.f(a94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(f94Var, bc3Var));
                }
                e32.c().a(f94Var, this.a.k0(), bc3Var);
                kg4.k(f94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, f94Var) == null) {
                String l0 = this.a.l0();
                if (i32.C) {
                    nl2.d(l0).e().d(1);
                }
                super.i(f94Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                bc3 z0 = this.a.z0(f94Var);
                ix1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + f94Var.i);
                if (z0 == null) {
                    i32 i32Var = this.a;
                    i32Var.j = f94Var;
                    i32Var.i.m(f94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(f94Var);
                        if (i32.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    e32.c().b(f94Var, this.a.k0());
                    return;
                }
                this.a.i.l(f94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(f94Var, z0));
                }
                e32.c().a(f94Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void c(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, f94Var) == null) {
                String l0 = this.a.l0();
                if (i32.C) {
                    nl2.d(l0).e().d(1);
                }
                super.c(f94Var);
                ix1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: r */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, f94Var) == null) {
                String l0 = this.a.l0();
                if (i32.C) {
                    nl2.d(l0).e().d(1);
                }
                super.f(f94Var);
                if (i32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(f94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: s */
        public a94 h(f94 f94Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{f94Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (i32.C) {
                    nl2.d(l0).f(f94Var.toString()).d(1);
                }
                C0503a c0503a = new C0503a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                gj2 gj2Var = new gj2();
                gj2Var.u(c0503a);
                gj2Var.K(bundle);
                gj2Var.J(new fj2(f94Var, this.a));
                gj2Var.J(new dj2(f94Var.m, this.a));
                gj2Var.M(readableByteChannel);
                boolean N = gj2Var.N();
                gj2Var.o(c0503a);
                if (i32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    ix1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    kg4.L(file);
                }
                return N ? new a94(2300, "业务层处理下载流成功") : new a94(2301, "业务层处理下载流失败");
            }
            return (a94) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ bf3 b;

        public b(i32 i32Var, Collection collection, bf3 bf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, collection, bf3Var};
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
            this.b = bf3Var;
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
    public class c implements bf3<r32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf3 a;
        public final /* synthetic */ i32 b;

        public c(i32 i32Var, bf3 bf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, bf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i32Var;
            this.a = bf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r32Var) == null) {
                this.a.a(r32Var);
                i32 i32Var = this.b;
                i32Var.h0(i32Var.s, r32Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements bf3<r32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc3 a;
        public final /* synthetic */ boolean b;

        public d(i32 i32Var, bc3 bc3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, bc3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bc3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r32Var) == null) {
                r32Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements bf3<r32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(i32 i32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, pMSAppInfo};
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r32Var) == null) {
                r32Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f94 a;
        public final /* synthetic */ i32 b;

        public f(i32 i32Var, f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, f94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i32Var;
            this.a = f94Var;
        }

        @Override // com.repackage.e32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                i32 i32Var = this.b;
                f94 f94Var = this.a;
                i32Var.j = f94Var;
                i32Var.i.m(f94Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, bc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g94 a;
        public final /* synthetic */ i32 b;

        public g(i32 i32Var, g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, g94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i32Var;
            this.a = g94Var;
        }

        @Override // com.repackage.e32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                i32 i32Var = this.b;
                if (i32Var.k == null) {
                    i32Var.k = new ArrayList();
                }
                g94 g94Var = this.a;
                i32 i32Var2 = this.b;
                g94Var.o = i32Var2.o;
                i32Var2.k.add(g94Var);
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

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, bc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d94 a;
        public final /* synthetic */ i32 b;

        public h(i32 i32Var, d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, d94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i32Var;
            this.a = d94Var;
        }

        @Override // com.repackage.e32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                i32 i32Var = this.b;
                d94 d94Var = this.a;
                i32Var.l = d94Var;
                i32Var.i.m(d94Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, bc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b94 a;
        public final /* synthetic */ i32 b;

        public i(i32 i32Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, b94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i32Var;
            this.a = b94Var;
        }

        @Override // com.repackage.e32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ix1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                i32 i32Var = this.b;
                b94 b94Var = this.a;
                i32Var.m = b94Var;
                i32Var.i.m(b94Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                ix1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + bc3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends as9<e94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 e;

        public j(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vr9
        /* renamed from: g */
        public void onNext(e94 e94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e94Var) == null) {
                ix1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + e94Var.i);
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ix1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                ix1.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ur9.a<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public k(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super f94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.d = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ur9.a<g94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public l(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super g94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.e = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ur9.a<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public m(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super d94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.f = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ur9.a<b94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public n(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super b94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.g = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ur9.a<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public o(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super h94> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                this.a.h = as9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends p32<i32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(i32 i32Var, i32 i32Var2) {
            super(i32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, i32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((m32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i32Var;
        }

        @Override // com.repackage.p32, com.repackage.u74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.repackage.p32
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.p32
        public void p(@NonNull g94 g94Var, @Nullable bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, g94Var, bc3Var) == null) {
                super.p(g94Var, bc3Var);
                ix1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + g94Var.i);
                i32 i32Var = this.c;
                if (i32Var.k == null) {
                    i32Var.k = new ArrayList();
                }
                i32 i32Var2 = this.c;
                g94Var.o = i32Var2.o;
                if (bc3Var == null) {
                    i32Var2.k.add(g94Var);
                    this.c.i.m(g94Var);
                    e32.c().b(g94Var, this.c.k0());
                } else {
                    i32Var2.i.l(g94Var);
                    e32.c().a(g94Var, this.c.k0(), bc3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(g94Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void e(g94 g94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, g94Var, a94Var) == null) {
                super.q(g94Var, a94Var);
                ix1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + a94Var.toString());
                this.c.i.l(g94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(12L);
                bc3Var.i(a94Var.a);
                bc3Var.d("分包下载失败");
                bc3Var.f(a94Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(g94Var, bc3Var));
                }
                e32.c().a(g94Var, this.c.k0(), bc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.p32, com.repackage.u74, com.repackage.x74
        /* renamed from: s */
        public void c(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, g94Var) == null) {
                super.c(g94Var);
                ix1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: u */
        public void f(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g94Var) == null) {
                super.f(g94Var);
                this.c.E0(g94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends n32<i32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(i32 i32Var, i32 i32Var2) {
            super(i32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, i32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((m32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i32Var;
        }

        @Override // com.repackage.u74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.repackage.n32
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.n32
        public void r(@NonNull h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, h94Var) == null) {
                this.b.i.m(h94Var);
                if (this.b.h != null) {
                    this.b.h.onNext(h94Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.n32
        public void u(h94 h94Var, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, h94Var, bc3Var) == null) {
                ix1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + bc3Var);
                this.b.i.l(h94Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(h94Var, bc3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.n32, com.repackage.u74, com.repackage.x74
        /* renamed from: v */
        public void c(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, h94Var) == null) {
                super.c(h94Var);
                ix1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.n32, com.repackage.u74, com.repackage.x74
        /* renamed from: w */
        public void f(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, h94Var) == null) {
                super.f(h94Var);
                if (i32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends u74<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public r(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        @Override // com.repackage.u74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(d94 d94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d94Var)) == null) {
                int i = d94Var.h;
                if (i == 0) {
                    return a42.h();
                }
                if (i == 1) {
                    return a42.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(d94 d94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d94Var, a94Var) == null) {
                super.e(d94Var, a94Var);
                ix1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + a94Var.toString());
                this.a.i.l(d94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(13L);
                bc3Var.i(a94Var.a);
                bc3Var.d("Framework包下载失败");
                bc3Var.f(a94Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(d94Var, bc3Var));
                }
                e32.c().a(d94Var, this.a.k0(), bc3Var);
                kg4.k(d94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, d94Var) == null) {
                super.i(d94Var);
                ix1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + d94Var.i);
                bc3 y0 = this.a.y0(d94Var);
                if (y0 == null) {
                    i32 i32Var = this.a;
                    i32Var.l = d94Var;
                    i32Var.i.m(d94Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(d94Var);
                        this.a.f.onCompleted();
                    }
                    e32.c().b(d94Var, this.a.k0());
                    return;
                }
                this.a.i.l(d94Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(d94Var, y0));
                }
                e32.c().a(d94Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void c(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, d94Var) == null) {
                super.c(d94Var);
                ix1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: r */
        public void f(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, d94Var) == null) {
                super.f(d94Var);
                if (i32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(d94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends u74<b94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public s(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        @Override // com.repackage.u74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(b94 b94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b94Var)) == null) {
                int i = b94Var.h;
                if (i == 0) {
                    return a42.d();
                }
                if (i == 1) {
                    return a42.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(b94 b94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b94Var, a94Var) == null) {
                super.e(b94Var, a94Var);
                ix1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + a94Var.toString());
                this.a.i.l(b94Var);
                bc3 bc3Var = new bc3();
                bc3Var.k(14L);
                bc3Var.i(a94Var.a);
                bc3Var.d("Extension下载失败");
                bc3Var.f(a94Var.toString());
                if (i32.C) {
                    Log.e("SwanAppPkgDownloadCallback", bc3Var.toString());
                }
                this.a.q0(b94Var);
                e32.c().a(b94Var, this.a.k0(), bc3Var);
                kg4.k(b94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, b94Var) == null) {
                super.i(b94Var);
                ix1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + b94Var.i);
                bc3 x0 = this.a.x0(b94Var);
                if (x0 != null) {
                    if (i32.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + b94Var.toString());
                    }
                    this.a.i.l(b94Var);
                    this.a.q0(b94Var);
                    e32.c().a(b94Var, this.a.k0(), x0);
                    return;
                }
                i32 i32Var = this.a;
                i32Var.m = b94Var;
                i32Var.i.m(b94Var);
                this.a.q0(b94Var);
                e32.c().b(b94Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void c(b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, b94Var) == null) {
                super.c(b94Var);
                ix1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: r */
        public void f(b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, b94Var) == null) {
                super.f(b94Var);
                if (i32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(b94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements a84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public t(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        @Override // com.repackage.a84
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (i32.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                i32 i32Var = this.a;
                i32Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    i32Var.o0(pMSAppInfo);
                    gw2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements bf3<bf3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(i32 i32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, pMSAppInfo};
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(bf3<PMSAppInfo> bf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bf3Var) == null) {
                bf3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(i32 i32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, collection, obj};
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

        public w(i32 i32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755669463, "Lcom/repackage/i32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755669463, "Lcom/repackage/i32;");
                return;
            }
        }
        C = sg1.a;
    }

    public i32(String str) {
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
        this.u = new le3();
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

    @Override // com.repackage.b84
    public x74<g94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (x74) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            bv2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b94Var) == null) {
            e32.c().d(b94Var, new i(this, b94Var));
        }
    }

    @Override // com.repackage.b84
    public void C(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a94Var) == null) {
            ix1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + a94Var);
            if (a94Var != null && a94Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d94Var) == null) {
            e32.c().d(d94Var, new h(this, d94Var));
        }
    }

    @Override // com.repackage.b84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f94Var) == null) {
            e32.c().d(f94Var, new f(this, f94Var));
        }
    }

    @Override // com.repackage.b84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g94Var) == null) {
            e32.c().d(g94Var, new g(this, g94Var));
        }
    }

    public bc3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    bc3 bc3Var = new bc3();
                    bc3Var.k(10L);
                    bc3Var.i(2903L);
                    bc3Var.d("Server未返回主包&AppInfo");
                    return bc3Var;
                }
                PMSAppInfo u2 = d84.i().u(this.o);
                if (u2 == null) {
                    bc3 bc3Var2 = new bc3();
                    bc3Var2.k(10L);
                    bc3Var2.i(2904L);
                    bc3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return bc3Var2;
                }
                this.n = u2;
                a42.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (d84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                bc3 bc3Var3 = new bc3();
                bc3Var3.k(10L);
                bc3Var3.i(2906L);
                bc3Var3.d("更新DB失败");
                return bc3Var3;
            }
            f94 f94Var = this.j;
            if (f94Var != null) {
                a42.k(pMSAppInfo, f94Var);
            } else if (b42.f(this.k)) {
                g94 g94Var = this.k.get(0);
                this.q = g94Var;
                g94Var.o = this.o;
                a42.l(this.n, g94Var);
            } else {
                PMSAppInfo u3 = d84.i().u(this.o);
                if (u3 == null) {
                    bc3 bc3Var4 = new bc3();
                    bc3Var4.k(10L);
                    bc3Var4.i(2905L);
                    bc3Var4.d("Server未返回包数据，本地也没有数据");
                    return bc3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (d84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                a42.o(this.n);
                return null;
            }
            bc3 bc3Var5 = new bc3();
            bc3Var5.k(10L);
            bc3Var5.i(2906L);
            bc3Var5.d("更新DB失败");
            return bc3Var5;
        }
        return (bc3) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public void G(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, od4Var) == null) {
            super.G(od4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (od4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + od4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = od4Var;
            if (od4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = d84.i().u(this.o);
            ix1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                f94 f94Var = this.j;
                if (f94Var != null) {
                    f94Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                d84.i().l(u2);
            }
        }
    }

    public i32 e0(bf3<PMSAppInfo> bf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bf3Var)) == null) {
            f0(this.t, bf3Var);
            return this;
        }
        return (i32) invokeL.objValue;
    }

    public final synchronized <CallbackT> i32 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (i32) invokeLL.objValue;
    }

    public synchronized i32 g0(r32 r32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, r32Var)) == null) {
            synchronized (this) {
                f0(this.s, r32Var);
            }
            return this;
        }
        return (i32) invokeL.objValue;
    }

    public final synchronized <CallbackT> i32 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (i32) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c84.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                d84.i().z(this.o, i2);
            } else {
                d84.i().z(this.o, 0);
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

    public i32 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (i32) invokeL.objValue;
    }

    @Override // com.repackage.b84
    public a84 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (a84) invokeV.objValue;
    }

    public final synchronized <CallbackT> i32 p0(@NonNull Collection<CallbackT> collection, @NonNull bf3<CallbackT> bf3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, bf3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, bf3Var));
            }
            return this;
        }
        return (i32) invokeLL.objValue;
    }

    @Override // com.repackage.b84
    public x74<h94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (x74) invokeV.objValue;
    }

    public final void q0(b94 b94Var) {
        as9<? super b94> as9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, b94Var) == null) || (as9Var = this.g) == null) {
            return;
        }
        as9Var.onNext(b94Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.b84
    public x74<b94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (x74) invokeV.objValue;
    }

    public i32 r0(@NonNull bf3<r32> bf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, bf3Var)) == null) {
            p0(this.s, new c(this, bf3Var));
            return this;
        }
        return (i32) invokeL.objValue;
    }

    @Override // com.repackage.b84
    public x74<d94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (x74) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, bc3 bc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, bc3Var) == null) {
            r0(new d(this, bc3Var, z));
        }
    }

    @Override // com.repackage.b84
    public x74<f94> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (x74) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = d84.i().u(this.o);
        if (u2 == null) {
            ix1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (d84.i().l(this.n)) {
            a42.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            ix1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public bc3 x0(b94 b94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, b94Var)) == null) {
            ob2 ob2Var = new ob2();
            ob2Var.b = b94Var.i;
            ob2Var.a = b94Var.j;
            ob2Var.c = b94Var.a;
            ob2Var.d = b94Var.m;
            if (ra2.b(b94Var.h, ob2Var) == null) {
                return null;
            }
            bc3 bc3Var = new bc3();
            bc3Var.k(14L);
            bc3Var.b(2908L);
            bc3Var.d("Extension包更新失败");
            return bc3Var;
        }
        return (bc3) invokeL.objValue;
    }

    public bc3 y0(d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, d94Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + d94Var);
            }
            s93.b c2 = s93.c(d94Var, d94Var.h);
            if (!TextUtils.isEmpty(d94Var.a)) {
                ix1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + d94Var.a);
                kg4.k(d94Var.a);
            }
            if (c2.c()) {
                return null;
            }
            bc3 bc3Var = new bc3();
            bc3Var.k(13L);
            bc3Var.b(2907L);
            bc3Var.d("Core包更新失败");
            return bc3Var;
        }
        return (bc3) invokeL.objValue;
    }

    public bc3 z0(f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, f94Var)) == null) {
            if (f94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(11L);
                bc3Var.i(2310L);
                bc3Var.f("pkg info is empty");
                fc3.a().f(bc3Var);
                return bc3Var;
            }
            return null;
        }
        return (bc3) invokeL.objValue;
    }
}
