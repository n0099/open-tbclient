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
import com.repackage.ea3;
import com.repackage.q32;
import com.repackage.wx9;
import com.repackage.y03;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class u32 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public m84 A;
    public cy9<q94> B;
    public String c;
    public cy9<? super r94> d;
    public cy9<? super s94> e;
    public cy9<? super p94> f;
    public cy9<? super n94> g;
    public cy9<? super t94> h;
    public ae4 i;
    public r94 j;
    public List<s94> k;
    public p94 l;
    public n94 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public s94 q;
    public long r;
    public final Set<d42> s;
    public final Set<nf3<PMSAppInfo>> t;
    public final xe3 u;
    public j84<r94> v;
    public j84<s94> w;
    public final j84<t94> x;
    public j84<p94> y;
    public j84<n94> z;

    /* loaded from: classes7.dex */
    public class a extends g84<r94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        /* renamed from: com.repackage.u32$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0527a implements nf3<y03.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0527a(a aVar) {
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
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(y03.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    o84.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        @Override // com.repackage.g84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(r94 r94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, r94Var)) == null) {
                int i = r94Var.h;
                if (i == 0) {
                    return m42.g();
                }
                if (i == 1) {
                    return m42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(r94 r94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, r94Var, m94Var) == null) {
                super.e(r94Var, m94Var);
                ux1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + m94Var.toString());
                this.a.i.l(r94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(11L);
                nc3Var.i(m94Var.a);
                nc3Var.d("主包下载失败");
                nc3Var.f(m94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(r94Var, nc3Var));
                }
                q32.c().a(r94Var, this.a.l0(), nc3Var);
                xg4.k(r94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, r94Var) == null) {
                String m0 = this.a.m0();
                if (u32.C) {
                    zl2.d(m0).e().d(1);
                }
                super.i(r94Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                nc3 A0 = this.a.A0(r94Var);
                ux1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + r94Var.i);
                if (A0 == null) {
                    u32 u32Var = this.a;
                    u32Var.j = r94Var;
                    u32Var.i.m(r94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(r94Var);
                        if (u32.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.j0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    q32.c().b(r94Var, this.a.l0());
                    return;
                }
                this.a.i.l(r94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(r94Var, A0));
                }
                q32.c().a(r94Var, this.a.l0(), A0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void c(r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, r94Var) == null) {
                String m0 = this.a.m0();
                if (u32.C) {
                    zl2.d(m0).e().d(1);
                }
                super.c(r94Var);
                ux1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void f(r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, r94Var) == null) {
                String m0 = this.a.m0();
                if (u32.C) {
                    zl2.d(m0).e().d(1);
                }
                super.f(r94Var);
                if (u32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": main onDownloading");
                }
                this.a.E0(r94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: s */
        public m94 h(r94 r94Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{r94Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String m0 = this.a.m0();
                if (u32.C) {
                    zl2.d(m0).f(r94Var.toString()).d(1);
                }
                C0527a c0527a = new C0527a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                sj2 sj2Var = new sj2();
                sj2Var.v(c0527a);
                sj2Var.J(bundle);
                sj2Var.I(new rj2(r94Var, this.a));
                sj2Var.I(new pj2(r94Var.m, this.a));
                sj2Var.L(readableByteChannel);
                boolean M = sj2Var.M();
                sj2Var.p(c0527a);
                if (u32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": onProcessStream: installOk=" + M);
                }
                if (M) {
                    ux1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    xg4.L(file);
                }
                return M ? new m94(2300, "业务层处理下载流成功") : new m94(2301, "业务层处理下载流失败");
            }
            return (m94) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ nf3 b;

        public b(u32 u32Var, Collection collection, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, collection, nf3Var};
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
            this.b = nf3Var;
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

    /* loaded from: classes7.dex */
    public class c implements nf3<d42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;
        public final /* synthetic */ u32 b;

        public c(u32 u32Var, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u32Var;
            this.a = nf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(d42 d42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d42Var) == null) {
                this.a.onCallback(d42Var);
                u32 u32Var = this.b;
                u32Var.i0(u32Var.s, d42Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nf3<d42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc3 a;
        public final /* synthetic */ boolean b;

        public d(u32 u32Var, nc3 nc3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, nc3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nc3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(d42 d42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d42Var) == null) {
                d42Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nf3<d42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(u32 u32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, pMSAppInfo};
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
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(d42 d42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d42Var) == null) {
                d42Var.b(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r94 a;
        public final /* synthetic */ u32 b;

        public f(u32 u32Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, r94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u32Var;
            this.a = r94Var;
        }

        @Override // com.repackage.q32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                u32 u32Var = this.b;
                r94 r94Var = this.a;
                u32Var.j = r94Var;
                u32Var.i.m(r94Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, nc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s94 a;
        public final /* synthetic */ u32 b;

        public g(u32 u32Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, s94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u32Var;
            this.a = s94Var;
        }

        @Override // com.repackage.q32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                u32 u32Var = this.b;
                if (u32Var.k == null) {
                    u32Var.k = new ArrayList();
                }
                s94 s94Var = this.a;
                u32 u32Var2 = this.b;
                s94Var.o = u32Var2.o;
                u32Var2.k.add(s94Var);
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

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, nc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p94 a;
        public final /* synthetic */ u32 b;

        public h(u32 u32Var, p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, p94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u32Var;
            this.a = p94Var;
        }

        @Override // com.repackage.q32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                u32 u32Var = this.b;
                p94 p94Var = this.a;
                u32Var.l = p94Var;
                u32Var.i.m(p94Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, nc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n94 a;
        public final /* synthetic */ u32 b;

        public i(u32 u32Var, n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, n94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u32Var;
            this.a = n94Var;
        }

        @Override // com.repackage.q32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ux1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                u32 u32Var = this.b;
                n94 n94Var = this.a;
                u32Var.m = n94Var;
                u32Var.i.m(n94Var);
                this.b.r0(this.a);
            }
        }

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                ux1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + nc3Var.toString());
                this.b.i.l(this.a);
                this.b.r0(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends cy9<q94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 e;

        public j(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xx9
        /* renamed from: g */
        public void onNext(q94 q94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q94Var) == null) {
                ux1.k("SwanAppPkgDownloadCallback", this.e.l0() + " : 单个包下载、业务层处理完成：" + q94Var.i);
            }
        }

        @Override // com.repackage.xx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ux1.k("SwanAppPkgDownloadCallback", this.e.l0() + " : 包下载onCompleted");
                this.e.w0();
            }
        }

        @Override // com.repackage.xx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                ux1.l("SwanAppPkgDownloadCallback", this.e.l0() + " : 包下载OnError", th);
                this.e.x0(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements wx9.a<r94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public k(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super r94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.d = cy9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements wx9.a<s94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public l(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super s94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.e = cy9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements wx9.a<p94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public m(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super p94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.f = cy9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements wx9.a<n94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public n(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super n94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.g = cy9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements wx9.a<t94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public o(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super t94> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                this.a.h = cy9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends b42<u32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(u32 u32Var, u32 u32Var2) {
            super(u32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, u32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u32Var;
        }

        @Override // com.repackage.b42, com.repackage.g84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.k0() : invokeV.intValue;
        }

        @Override // com.repackage.b42
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.b42
        public void p(@NonNull s94 s94Var, @Nullable nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, s94Var, nc3Var) == null) {
                super.p(s94Var, nc3Var);
                ux1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + s94Var.i);
                u32 u32Var = this.c;
                if (u32Var.k == null) {
                    u32Var.k = new ArrayList();
                }
                u32 u32Var2 = this.c;
                s94Var.o = u32Var2.o;
                if (nc3Var == null) {
                    u32Var2.k.add(s94Var);
                    this.c.i.m(s94Var);
                    q32.c().b(s94Var, this.c.l0());
                } else {
                    u32Var2.i.l(s94Var);
                    q32.c().a(s94Var, this.c.l0(), nc3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(s94Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void e(s94 s94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, s94Var, m94Var) == null) {
                super.q(s94Var, m94Var);
                ux1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + m94Var.toString());
                this.c.i.l(s94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(12L);
                nc3Var.i(m94Var.a);
                nc3Var.d("分包下载失败");
                nc3Var.f(m94Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(s94Var, nc3Var));
                }
                q32.c().a(s94Var, this.c.l0(), nc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b42, com.repackage.g84, com.repackage.j84
        /* renamed from: s */
        public void c(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, s94Var) == null) {
                super.c(s94Var);
                ux1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: u */
        public void f(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s94Var) == null) {
                super.f(s94Var);
                this.c.F0(s94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends z32<u32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(u32 u32Var, u32 u32Var2) {
            super(u32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, u32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u32Var;
        }

        @Override // com.repackage.g84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.k0() : invokeV.intValue;
        }

        @Override // com.repackage.z32
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.l0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.z32
        public void r(@NonNull t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t94Var) == null) {
                this.b.i.m(t94Var);
                if (this.b.h != null) {
                    this.b.h.onNext(t94Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.z32
        public void u(t94 t94Var, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, t94Var, nc3Var) == null) {
                ux1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + nc3Var);
                this.b.i.l(t94Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(t94Var, nc3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z32, com.repackage.g84, com.repackage.j84
        /* renamed from: v */
        public void c(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t94Var) == null) {
                super.c(t94Var);
                ux1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z32, com.repackage.g84, com.repackage.j84
        /* renamed from: w */
        public void f(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t94Var) == null) {
                super.f(t94Var);
                if (u32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.j0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends g84<p94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public r(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        @Override // com.repackage.g84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(p94 p94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, p94Var)) == null) {
                int i = p94Var.h;
                if (i == 0) {
                    return m42.h();
                }
                if (i == 1) {
                    return m42.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(p94 p94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p94Var, m94Var) == null) {
                super.e(p94Var, m94Var);
                ux1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + m94Var.toString());
                this.a.i.l(p94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(13L);
                nc3Var.i(m94Var.a);
                nc3Var.d("Framework包下载失败");
                nc3Var.f(m94Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(p94Var, nc3Var));
                }
                q32.c().a(p94Var, this.a.l0(), nc3Var);
                xg4.k(p94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, p94Var) == null) {
                super.i(p94Var);
                ux1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + p94Var.i);
                nc3 z0 = this.a.z0(p94Var);
                if (z0 == null) {
                    u32 u32Var = this.a;
                    u32Var.l = p94Var;
                    u32Var.i.m(p94Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(p94Var);
                        this.a.f.onCompleted();
                    }
                    q32.c().b(p94Var, this.a.l0());
                    return;
                }
                this.a.i.l(p94Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(p94Var, z0));
                }
                q32.c().a(p94Var, this.a.l0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void c(p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, p94Var) == null) {
                super.c(p94Var);
                ux1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void f(p94 p94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, p94Var) == null) {
                super.f(p94Var);
                if (u32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": framework onDownloading");
                }
                this.a.D0(p94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends g84<n94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public s(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        @Override // com.repackage.g84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(n94 n94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, n94Var)) == null) {
                int i = n94Var.h;
                if (i == 0) {
                    return m42.d();
                }
                if (i == 1) {
                    return m42.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(n94 n94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n94Var, m94Var) == null) {
                super.e(n94Var, m94Var);
                ux1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + m94Var.toString());
                this.a.i.l(n94Var);
                nc3 nc3Var = new nc3();
                nc3Var.k(14L);
                nc3Var.i(m94Var.a);
                nc3Var.d("Extension下载失败");
                nc3Var.f(m94Var.toString());
                if (u32.C) {
                    Log.e("SwanAppPkgDownloadCallback", nc3Var.toString());
                }
                this.a.r0(n94Var);
                q32.c().a(n94Var, this.a.l0(), nc3Var);
                xg4.k(n94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, n94Var) == null) {
                super.i(n94Var);
                ux1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + n94Var.i);
                nc3 y0 = this.a.y0(n94Var);
                if (y0 != null) {
                    if (u32.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + n94Var.toString());
                    }
                    this.a.i.l(n94Var);
                    this.a.r0(n94Var);
                    q32.c().a(n94Var, this.a.l0(), y0);
                    return;
                }
                u32 u32Var = this.a;
                u32Var.m = n94Var;
                u32Var.i.m(n94Var);
                this.a.r0(n94Var);
                q32.c().b(n94Var, this.a.l0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void c(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, n94Var) == null) {
                super.c(n94Var);
                ux1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void f(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, n94Var) == null) {
                super.f(n94Var);
                if (u32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": extension onDownloading");
                }
                this.a.C0(n94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements m84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u32 a;

        public t(u32 u32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u32Var;
        }

        @Override // com.repackage.m84
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (u32.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.j0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                u32 u32Var = this.a;
                u32Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    u32Var.p0(pMSAppInfo);
                    sw2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements nf3<nf3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(u32 u32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, pMSAppInfo};
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
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(nf3<PMSAppInfo> nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nf3Var) == null) {
                nf3Var.onCallback(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(u32 u32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, collection, obj};
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

        public w(u32 u32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u32Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755311971, "Lcom/repackage/u32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755311971, "Lcom/repackage/u32;");
                return;
            }
        }
        C = eh1.a;
    }

    public u32(String str) {
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
        this.u = new xe3();
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

    public nc3 A0(r94 r94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r94Var)) == null) {
            if (r94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(11L);
                nc3Var.i(2310L);
                nc3Var.f("pkg info is empty");
                rc3.a().f(nc3Var);
                return nc3Var;
            }
            return null;
        }
        return (nc3) invokeL.objValue;
    }

    @Override // com.repackage.n84
    public j84<s94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w : (j84) invokeV.objValue;
    }

    public void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            nv2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void C0(n94 n94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n94Var) == null) {
            q32.c().d(n94Var, new i(this, n94Var));
        }
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, m94Var) == null) {
            ux1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + m94Var);
            if (m94Var != null && m94Var.a == 1010) {
                H0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0(p94 p94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p94Var) == null) {
            q32.c().d(p94Var, new h(this, p94Var));
        }
    }

    @Override // com.repackage.n84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void E0(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, r94Var) == null) {
            q32.c().d(r94Var, new f(this, r94Var));
        }
    }

    @Override // com.repackage.n84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void F0(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, s94Var) == null) {
            q32.c().d(s94Var, new g(this, s94Var));
        }
    }

    public nc3 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    nc3 nc3Var = new nc3();
                    nc3Var.k(10L);
                    nc3Var.i(2903L);
                    nc3Var.d("Server未返回主包&AppInfo");
                    return nc3Var;
                }
                PMSAppInfo u2 = p84.i().u(this.o);
                if (u2 == null) {
                    nc3 nc3Var2 = new nc3();
                    nc3Var2.k(10L);
                    nc3Var2.i(2904L);
                    nc3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return nc3Var2;
                }
                this.n = u2;
                m42.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(K());
                if (p84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                nc3 nc3Var3 = new nc3();
                nc3Var3.k(10L);
                nc3Var3.i(2906L);
                nc3Var3.d("更新DB失败");
                return nc3Var3;
            }
            r94 r94Var = this.j;
            if (r94Var != null) {
                m42.k(pMSAppInfo, r94Var);
            } else if (n42.f(this.k)) {
                s94 s94Var = this.k.get(0);
                this.q = s94Var;
                s94Var.o = this.o;
                m42.l(this.n, s94Var);
            } else {
                PMSAppInfo u3 = p84.i().u(this.o);
                if (u3 == null) {
                    nc3 nc3Var4 = new nc3();
                    nc3Var4.k(10L);
                    nc3Var4.i(2905L);
                    nc3Var4.d("Server未返回包数据，本地也没有数据");
                    return nc3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(K());
            if (p84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                m42.o(this.n);
                return null;
            }
            nc3 nc3Var5 = new nc3();
            nc3Var5.k(10L);
            nc3Var5.i(2906L);
            nc3Var5.d("更新DB失败");
            return nc3Var5;
        }
        return (nc3) invokeV.objValue;
    }

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ae4Var) == null) {
            super.H(ae4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (ae4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", j0() + ": onPrepareDownload: countSet=" + ae4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = ae4Var;
            if (ae4Var.k()) {
                return;
            }
            o0();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PMSAppInfo u2 = p84.i().u(this.o);
            ux1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(K());
                r94 r94Var = this.j;
                if (r94Var != null) {
                    r94Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(K());
                }
                p84.i().l(u2);
            }
        }
    }

    public u32 f0(nf3<PMSAppInfo> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, nf3Var)) == null) {
            g0(this.t, nf3Var);
            return this;
        }
        return (u32) invokeL.objValue;
    }

    public final synchronized <CallbackT> u32 g0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (u32) invokeLL.objValue;
    }

    public synchronized u32 h0(d42 d42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, d42Var)) == null) {
            synchronized (this) {
                g0(this.s, d42Var);
            }
            return this;
        }
        return (u32) invokeL.objValue;
    }

    public final synchronized <CallbackT> u32 i0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (u32) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? o84.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 1013) {
                p84.i().z(this.o, i2);
            } else {
                p84.i().z(this.o, 0);
            }
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(wx9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(wx9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(wx9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(wx9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(wx9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            wx9.i(arrayList).u(this.B);
        }
    }

    public u32 p0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pMSAppInfo)) == null) {
            q0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (u32) invokeL.objValue;
    }

    @Override // com.repackage.n84
    public m84 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.A : (m84) invokeV.objValue;
    }

    public final synchronized <CallbackT> u32 q0(@NonNull Collection<CallbackT> collection, @NonNull nf3<CallbackT> nf3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, collection, nf3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, nf3Var));
            }
            return this;
        }
        return (u32) invokeLL.objValue;
    }

    @Override // com.repackage.n84
    public j84<t94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.x : (j84) invokeV.objValue;
    }

    public final void r0(n94 n94Var) {
        cy9<? super n94> cy9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, n94Var) == null) || (cy9Var = this.g) == null) {
            return;
        }
        cy9Var.onNext(n94Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.n84
    public j84<n94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z : (j84) invokeV.objValue;
    }

    public u32 s0(@NonNull nf3<d42> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, nf3Var)) == null) {
            q0(this.s, new c(this, nf3Var));
            return this;
        }
        return (u32) invokeL.objValue;
    }

    @Override // com.repackage.n84
    public j84<p94> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.y : (j84) invokeV.objValue;
    }

    public void t0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pMSAppInfo) == null) {
            s0(new e(this, pMSAppInfo));
        }
    }

    public void u0(boolean z, nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, nc3Var) == null) {
            s0(new d(this, nc3Var, z));
        }
    }

    @Override // com.repackage.n84
    public j84<r94> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v : (j84) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = p84.i().u(this.o);
        if (u2 == null) {
            ux1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(K());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (p84.i().l(this.n)) {
            m42.o(this.n);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            ux1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void x0(Throwable th);

    public nc3 y0(n94 n94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, n94Var)) == null) {
            ac2 ac2Var = new ac2();
            ac2Var.b = n94Var.i;
            ac2Var.a = n94Var.j;
            ac2Var.c = n94Var.a;
            ac2Var.d = n94Var.m;
            if (db2.b(n94Var.h, ac2Var) == null) {
                return null;
            }
            nc3 nc3Var = new nc3();
            nc3Var.k(14L);
            nc3Var.b(2908L);
            nc3Var.d("Extension包更新失败");
            return nc3Var;
        }
        return (nc3) invokeL.objValue;
    }

    public nc3 z0(p94 p94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, p94Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + p94Var);
            }
            ea3.b c2 = ea3.c(p94Var, p94Var.h);
            if (!TextUtils.isEmpty(p94Var.a)) {
                ux1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + p94Var.a);
                xg4.k(p94Var.a);
            }
            if (c2.c()) {
                return null;
            }
            nc3 nc3Var = new nc3();
            nc3Var.k(13L);
            nc3Var.b(2907L);
            nc3Var.d("Core包更新失败");
            return nc3Var;
        }
        return (nc3) invokeL.objValue;
    }
}
