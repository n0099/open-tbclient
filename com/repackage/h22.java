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
import com.repackage.d22;
import com.repackage.lz2;
import com.repackage.qu9;
import com.repackage.r83;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class h22 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public z64 A;
    public wu9<d84> B;
    public String c;
    public wu9<? super e84> d;
    public wu9<? super f84> e;
    public wu9<? super c84> f;
    public wu9<? super a84> g;
    public wu9<? super g84> h;
    public nc4 i;
    public e84 j;
    public List<f84> k;
    public c84 l;
    public a84 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public f84 q;
    public long r;
    public final Set<q22> s;
    public final Set<ae3<PMSAppInfo>> t;
    public final kd3 u;
    public w64<e84> v;
    public w64<f84> w;
    public final w64<g84> x;
    public w64<c84> y;
    public w64<a84> z;

    /* loaded from: classes6.dex */
    public class a extends t64<e84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        /* renamed from: com.repackage.h22$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0438a implements ae3<lz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0438a(a aVar) {
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
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(lz2.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    b74.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        @Override // com.repackage.t64
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(e84 e84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e84Var)) == null) {
                int i = e84Var.h;
                if (i == 0) {
                    return z22.g();
                }
                if (i == 1) {
                    return z22.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(e84 e84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, e84Var, z74Var) == null) {
                super.e(e84Var, z74Var);
                hw1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + z74Var.toString());
                this.a.i.l(e84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(11L);
                ab3Var.i(z74Var.a);
                ab3Var.d("主包下载失败");
                ab3Var.f(z74Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(e84Var, ab3Var));
                }
                d22.c().a(e84Var, this.a.l0(), ab3Var);
                kf4.k(e84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(e84 e84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, e84Var) == null) {
                String m0 = this.a.m0();
                if (h22.C) {
                    mk2.d(m0).e().d(1);
                }
                super.i(e84Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                ab3 A0 = this.a.A0(e84Var);
                hw1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + e84Var.i);
                if (A0 == null) {
                    h22 h22Var = this.a;
                    h22Var.j = e84Var;
                    h22Var.i.m(e84Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(e84Var);
                        if (h22.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.j0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    d22.c().b(e84Var, this.a.l0());
                    return;
                }
                this.a.i.l(e84Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(e84Var, A0));
                }
                d22.c().a(e84Var, this.a.l0(), A0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void c(e84 e84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, e84Var) == null) {
                String m0 = this.a.m0();
                if (h22.C) {
                    mk2.d(m0).e().d(1);
                }
                super.c(e84Var);
                hw1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(e84 e84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, e84Var) == null) {
                String m0 = this.a.m0();
                if (h22.C) {
                    mk2.d(m0).e().d(1);
                }
                super.f(e84Var);
                if (h22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": main onDownloading");
                }
                this.a.E0(e84Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: s */
        public z74 h(e84 e84Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{e84Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String m0 = this.a.m0();
                if (h22.C) {
                    mk2.d(m0).f(e84Var.toString()).d(1);
                }
                C0438a c0438a = new C0438a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                fi2 fi2Var = new fi2();
                fi2Var.v(c0438a);
                fi2Var.J(bundle);
                fi2Var.I(new ei2(e84Var, this.a));
                fi2Var.I(new ci2(e84Var.m, this.a));
                fi2Var.L(readableByteChannel);
                boolean M = fi2Var.M();
                fi2Var.p(c0438a);
                if (h22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": onProcessStream: installOk=" + M);
                }
                if (M) {
                    hw1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    kf4.L(file);
                }
                return M ? new z74(2300, "业务层处理下载流成功") : new z74(2301, "业务层处理下载流失败");
            }
            return (z74) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ ae3 b;

        public b(h22 h22Var, Collection collection, ae3 ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, collection, ae3Var};
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
            this.b = ae3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.a) {
                    this.b.onCallback(obj);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ae3<q22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ h22 b;

        public c(h22 h22Var, ae3 ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, ae3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
            this.a = ae3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(q22 q22Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q22Var) == null) {
                this.a.onCallback(q22Var);
                h22 h22Var = this.b;
                h22Var.i0(h22Var.s, q22Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ae3<q22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ab3 a;
        public final /* synthetic */ boolean b;

        public d(h22 h22Var, ab3 ab3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, ab3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ab3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(q22 q22Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q22Var) == null) {
                q22Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ae3<q22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(h22 h22Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, pMSAppInfo};
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(q22 q22Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q22Var) == null) {
                q22Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e84 a;
        public final /* synthetic */ h22 b;

        public f(h22 h22Var, e84 e84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, e84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
            this.a = e84Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h22 h22Var = this.b;
                e84 e84Var = this.a;
                h22Var.j = e84Var;
                h22Var.i.m(e84Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ab3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f84 a;
        public final /* synthetic */ h22 b;

        public g(h22 h22Var, f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, f84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
            this.a = f84Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h22 h22Var = this.b;
                if (h22Var.k == null) {
                    h22Var.k = new ArrayList();
                }
                f84 f84Var = this.a;
                h22 h22Var2 = this.b;
                f84Var.o = h22Var2.o;
                h22Var2.k.add(f84Var);
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

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, ab3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c84 a;
        public final /* synthetic */ h22 b;

        public h(h22 h22Var, c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, c84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
            this.a = c84Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h22 h22Var = this.b;
                c84 c84Var = this.a;
                h22Var.l = c84Var;
                h22Var.i.m(c84Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, ab3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a84 a;
        public final /* synthetic */ h22 b;

        public i(h22 h22Var, a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, a84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
            this.a = a84Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                hw1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                h22 h22Var = this.b;
                a84 a84Var = this.a;
                h22Var.m = a84Var;
                h22Var.i.m(a84Var);
                this.b.r0(this.a);
            }
        }

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                hw1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + ab3Var.toString());
                this.b.i.l(this.a);
                this.b.r0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends wu9<d84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 e;

        public j(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9
        /* renamed from: g */
        public void onNext(d84 d84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d84Var) == null) {
                hw1.k("SwanAppPkgDownloadCallback", this.e.l0() + " : 单个包下载、业务层处理完成：" + d84Var.i);
            }
        }

        @Override // com.repackage.ru9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hw1.k("SwanAppPkgDownloadCallback", this.e.l0() + " : 包下载onCompleted");
                this.e.w0();
            }
        }

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                hw1.l("SwanAppPkgDownloadCallback", this.e.l0() + " : 包下载OnError", th);
                this.e.x0(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements qu9.a<e84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public k(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super e84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.d = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements qu9.a<f84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public l(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super f84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.e = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements qu9.a<c84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public m(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super c84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.f = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements qu9.a<a84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public n(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super a84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.g = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements qu9.a<g84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public o(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super g84> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                this.a.h = wu9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends o22<h22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(h22 h22Var, h22 h22Var2) {
            super(h22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, h22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h22Var;
        }

        @Override // com.repackage.o22, com.repackage.t64
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.k0() : invokeV.intValue;
        }

        @Override // com.repackage.o22
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.o22
        public void p(@NonNull f84 f84Var, @Nullable ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, f84Var, ab3Var) == null) {
                super.p(f84Var, ab3Var);
                hw1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + f84Var.i);
                h22 h22Var = this.c;
                if (h22Var.k == null) {
                    h22Var.k = new ArrayList();
                }
                h22 h22Var2 = this.c;
                f84Var.o = h22Var2.o;
                if (ab3Var == null) {
                    h22Var2.k.add(f84Var);
                    this.c.i.m(f84Var);
                    d22.c().b(f84Var, this.c.l0());
                } else {
                    h22Var2.i.l(f84Var);
                    d22.c().a(f84Var, this.c.l0(), ab3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(f84Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void e(f84 f84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, f84Var, z74Var) == null) {
                super.q(f84Var, z74Var);
                hw1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + z74Var.toString());
                this.c.i.l(f84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(12L);
                ab3Var.i(z74Var.a);
                ab3Var.d("分包下载失败");
                ab3Var.f(z74Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(f84Var, ab3Var));
                }
                d22.c().a(f84Var, this.c.l0(), ab3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o22, com.repackage.t64, com.repackage.w64
        /* renamed from: s */
        public void c(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, f84Var) == null) {
                super.c(f84Var);
                hw1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: u */
        public void f(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f84Var) == null) {
                super.f(f84Var);
                this.c.F0(f84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends m22<h22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(h22 h22Var, h22 h22Var2) {
            super(h22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, h22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
        }

        @Override // com.repackage.t64
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.k0() : invokeV.intValue;
        }

        @Override // com.repackage.m22
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.l0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.m22
        public void r(@NonNull g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, g84Var) == null) {
                this.b.i.m(g84Var);
                if (this.b.h != null) {
                    this.b.h.onNext(g84Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.m22
        public void u(g84 g84Var, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, g84Var, ab3Var) == null) {
                hw1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + ab3Var);
                this.b.i.l(g84Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(g84Var, ab3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m22, com.repackage.t64, com.repackage.w64
        /* renamed from: v */
        public void c(g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, g84Var) == null) {
                super.c(g84Var);
                hw1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m22, com.repackage.t64, com.repackage.w64
        /* renamed from: w */
        public void f(g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, g84Var) == null) {
                super.f(g84Var);
                if (h22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.j0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends t64<c84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public r(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        @Override // com.repackage.t64
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(c84 c84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c84Var)) == null) {
                int i = c84Var.h;
                if (i == 0) {
                    return z22.h();
                }
                if (i == 1) {
                    return z22.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(c84 c84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c84Var, z74Var) == null) {
                super.e(c84Var, z74Var);
                hw1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + z74Var.toString());
                this.a.i.l(c84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(13L);
                ab3Var.i(z74Var.a);
                ab3Var.d("Framework包下载失败");
                ab3Var.f(z74Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(c84Var, ab3Var));
                }
                d22.c().a(c84Var, this.a.l0(), ab3Var);
                kf4.k(c84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, c84Var) == null) {
                super.i(c84Var);
                hw1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + c84Var.i);
                ab3 z0 = this.a.z0(c84Var);
                if (z0 == null) {
                    h22 h22Var = this.a;
                    h22Var.l = c84Var;
                    h22Var.i.m(c84Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(c84Var);
                        this.a.f.onCompleted();
                    }
                    d22.c().b(c84Var, this.a.l0());
                    return;
                }
                this.a.i.l(c84Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(c84Var, z0));
                }
                d22.c().a(c84Var, this.a.l0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void c(c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, c84Var) == null) {
                super.c(c84Var);
                hw1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(c84 c84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, c84Var) == null) {
                super.f(c84Var);
                if (h22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": framework onDownloading");
                }
                this.a.D0(c84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends t64<a84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public s(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        @Override // com.repackage.t64
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(a84 a84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, a84Var)) == null) {
                int i = a84Var.h;
                if (i == 0) {
                    return z22.d();
                }
                if (i == 1) {
                    return z22.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(a84 a84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a84Var, z74Var) == null) {
                super.e(a84Var, z74Var);
                hw1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + z74Var.toString());
                this.a.i.l(a84Var);
                ab3 ab3Var = new ab3();
                ab3Var.k(14L);
                ab3Var.i(z74Var.a);
                ab3Var.d("Extension下载失败");
                ab3Var.f(z74Var.toString());
                if (h22.C) {
                    Log.e("SwanAppPkgDownloadCallback", ab3Var.toString());
                }
                this.a.r0(a84Var);
                d22.c().a(a84Var, this.a.l0(), ab3Var);
                kf4.k(a84Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, a84Var) == null) {
                super.i(a84Var);
                hw1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + a84Var.i);
                ab3 y0 = this.a.y0(a84Var);
                if (y0 != null) {
                    if (h22.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + a84Var.toString());
                    }
                    this.a.i.l(a84Var);
                    this.a.r0(a84Var);
                    d22.c().a(a84Var, this.a.l0(), y0);
                    return;
                }
                h22 h22Var = this.a;
                h22Var.m = a84Var;
                h22Var.i.m(a84Var);
                this.a.r0(a84Var);
                d22.c().b(a84Var, this.a.l0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void c(a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, a84Var) == null) {
                super.c(a84Var);
                hw1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(a84 a84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, a84Var) == null) {
                super.f(a84Var);
                if (h22.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": extension onDownloading");
                }
                this.a.C0(a84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements z64 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public t(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        @Override // com.repackage.z64
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (h22.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.j0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                h22 h22Var = this.a;
                h22Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    h22Var.p0(pMSAppInfo);
                    fv2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements ae3<ae3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(h22 h22Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, pMSAppInfo};
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(ae3<PMSAppInfo> ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ae3Var) == null) {
                ae3Var.onCallback(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(h22 h22Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, collection, obj};
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

        public w(h22 h22Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755700215, "Lcom/repackage/h22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755700215, "Lcom/repackage/h22;");
                return;
            }
        }
        C = rf1.a;
    }

    public h22(String str) {
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
        this.u = new kd3();
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

    public ab3 A0(e84 e84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e84Var)) == null) {
            if (e84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(11L);
                ab3Var.i(2310L);
                ab3Var.f("pkg info is empty");
                eb3.a().f(ab3Var);
                return ab3Var;
            }
            return null;
        }
        return (ab3) invokeL.objValue;
    }

    @Override // com.repackage.a74
    public w64<f84> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w : (w64) invokeV.objValue;
    }

    public void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            au2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void C0(a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a84Var) == null) {
            d22.c().d(a84Var, new i(this, a84Var));
        }
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, z74Var) == null) {
            hw1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + z74Var);
            if (z74Var != null && z74Var.a == 1010) {
                H0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0(c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c84Var) == null) {
            d22.c().d(c84Var, new h(this, c84Var));
        }
    }

    @Override // com.repackage.a74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void E0(e84 e84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e84Var) == null) {
            d22.c().d(e84Var, new f(this, e84Var));
        }
    }

    @Override // com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void F0(f84 f84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, f84Var) == null) {
            d22.c().d(f84Var, new g(this, f84Var));
        }
    }

    public ab3 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    ab3 ab3Var = new ab3();
                    ab3Var.k(10L);
                    ab3Var.i(2903L);
                    ab3Var.d("Server未返回主包&AppInfo");
                    return ab3Var;
                }
                PMSAppInfo u2 = c74.i().u(this.o);
                if (u2 == null) {
                    ab3 ab3Var2 = new ab3();
                    ab3Var2.k(10L);
                    ab3Var2.i(2904L);
                    ab3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return ab3Var2;
                }
                this.n = u2;
                z22.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(K());
                if (c74.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                ab3 ab3Var3 = new ab3();
                ab3Var3.k(10L);
                ab3Var3.i(2906L);
                ab3Var3.d("更新DB失败");
                return ab3Var3;
            }
            e84 e84Var = this.j;
            if (e84Var != null) {
                z22.k(pMSAppInfo, e84Var);
            } else if (a32.f(this.k)) {
                f84 f84Var = this.k.get(0);
                this.q = f84Var;
                f84Var.o = this.o;
                z22.l(this.n, f84Var);
            } else {
                PMSAppInfo u3 = c74.i().u(this.o);
                if (u3 == null) {
                    ab3 ab3Var4 = new ab3();
                    ab3Var4.k(10L);
                    ab3Var4.i(2905L);
                    ab3Var4.d("Server未返回包数据，本地也没有数据");
                    return ab3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(K());
            if (c74.i().b(this.j, this.k, this.l, this.m, this.n)) {
                z22.o(this.n);
                return null;
            }
            ab3 ab3Var5 = new ab3();
            ab3Var5.k(10L);
            ab3Var5.i(2906L);
            ab3Var5.d("更新DB失败");
            return ab3Var5;
        }
        return (ab3) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, nc4Var) == null) {
            super.H(nc4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (nc4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", j0() + ": onPrepareDownload: countSet=" + nc4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = nc4Var;
            if (nc4Var.k()) {
                return;
            }
            o0();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PMSAppInfo u2 = c74.i().u(this.o);
            hw1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(K());
                e84 e84Var = this.j;
                if (e84Var != null) {
                    e84Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(K());
                }
                c74.i().l(u2);
            }
        }
    }

    public h22 f0(ae3<PMSAppInfo> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ae3Var)) == null) {
            g0(this.t, ae3Var);
            return this;
        }
        return (h22) invokeL.objValue;
    }

    public final synchronized <CallbackT> h22 g0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (h22) invokeLL.objValue;
    }

    public synchronized h22 h0(q22 q22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, q22Var)) == null) {
            synchronized (this) {
                g0(this.s, q22Var);
            }
            return this;
        }
        return (h22) invokeL.objValue;
    }

    public final synchronized <CallbackT> h22 i0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new w(this, collection, callbackt));
                }
            }
            return this;
        }
        return (h22) invokeLL.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = getClass().toString();
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType l0();

    public final String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? b74.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 1013) {
                c74.i().z(this.o, i2);
            } else {
                c74.i().z(this.o, 0);
            }
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(qu9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(qu9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(qu9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(qu9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(qu9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            qu9.i(arrayList).u(this.B);
        }
    }

    public h22 p0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pMSAppInfo)) == null) {
            q0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (h22) invokeL.objValue;
    }

    @Override // com.repackage.a74
    public z64 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.A : (z64) invokeV.objValue;
    }

    public final synchronized <CallbackT> h22 q0(@NonNull Collection<CallbackT> collection, @NonNull ae3<CallbackT> ae3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, collection, ae3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, ae3Var));
            }
            return this;
        }
        return (h22) invokeLL.objValue;
    }

    @Override // com.repackage.a74
    public w64<g84> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.x : (w64) invokeV.objValue;
    }

    public final void r0(a84 a84Var) {
        wu9<? super a84> wu9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, a84Var) == null) || (wu9Var = this.g) == null) {
            return;
        }
        wu9Var.onNext(a84Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.a74
    public w64<a84> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z : (w64) invokeV.objValue;
    }

    public h22 s0(@NonNull ae3<q22> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, ae3Var)) == null) {
            q0(this.s, new c(this, ae3Var));
            return this;
        }
        return (h22) invokeL.objValue;
    }

    @Override // com.repackage.a74
    public w64<c84> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.y : (w64) invokeV.objValue;
    }

    public void t0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pMSAppInfo) == null) {
            s0(new e(this, pMSAppInfo));
        }
    }

    public void u0(boolean z, ab3 ab3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, ab3Var) == null) {
            s0(new d(this, ab3Var, z));
        }
    }

    @Override // com.repackage.a74
    public w64<e84> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v : (w64) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = c74.i().u(this.o);
        if (u2 == null) {
            hw1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(K());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (c74.i().l(this.n)) {
            z22.o(this.n);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            hw1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void x0(Throwable th);

    public ab3 y0(a84 a84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, a84Var)) == null) {
            na2 na2Var = new na2();
            na2Var.b = a84Var.i;
            na2Var.a = a84Var.j;
            na2Var.c = a84Var.a;
            na2Var.d = a84Var.m;
            if (q92.b(a84Var.h, na2Var) == null) {
                return null;
            }
            ab3 ab3Var = new ab3();
            ab3Var.k(14L);
            ab3Var.b(2908L);
            ab3Var.d("Extension包更新失败");
            return ab3Var;
        }
        return (ab3) invokeL.objValue;
    }

    public ab3 z0(c84 c84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, c84Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + c84Var);
            }
            r83.b c2 = r83.c(c84Var, c84Var.h);
            if (!TextUtils.isEmpty(c84Var.a)) {
                hw1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + c84Var.a);
                kf4.k(c84Var.a);
            }
            if (c2.c()) {
                return null;
            }
            ab3 ab3Var = new ab3();
            ab3Var.k(13L);
            ab3Var.b(2907L);
            ab3Var.d("Core包更新失败");
            return ab3Var;
        }
        return (ab3) invokeL.objValue;
    }
}
