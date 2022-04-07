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
import com.repackage.f32;
import com.repackage.n03;
import com.repackage.t93;
import com.repackage.uy9;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class j32 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public c84 A;
    public az9<g94> B;
    public String c;
    public az9<? super h94> d;
    public az9<? super i94> e;
    public az9<? super f94> f;
    public az9<? super d94> g;
    public az9<? super j94> h;
    public qd4 i;
    public h94 j;
    public List<i94> k;
    public f94 l;
    public d94 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public i94 q;
    public long r;
    public final Set<s32> s;
    public final Set<cf3<PMSAppInfo>> t;
    public final me3 u;
    public z74<h94> v;
    public z74<i94> w;
    public final z74<j94> x;
    public z74<f94> y;
    public z74<d94> z;

    /* loaded from: classes6.dex */
    public class a extends w74<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        /* renamed from: com.repackage.j32$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0448a implements cf3<n03.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0448a(a aVar) {
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
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(n03.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    e84.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // com.repackage.w74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z74
        /* renamed from: l */
        public String d(h94 h94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, h94Var)) == null) {
                int i = h94Var.h;
                if (i == 0) {
                    return b42.g();
                }
                if (i == 1) {
                    return b42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.b84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: o */
        public void e(h94 h94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, h94Var, c94Var) == null) {
                super.e(h94Var, c94Var);
                jx1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + c94Var.toString());
                this.a.i.l(h94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(11L);
                cc3Var.i(c94Var.a);
                cc3Var.d("主包下载失败");
                cc3Var.f(c94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(h94Var, cc3Var));
                }
                f32.c().a(h94Var, this.a.l0(), cc3Var);
                ng4.k(h94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: p */
        public void i(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, h94Var) == null) {
                String m0 = this.a.m0();
                if (j32.C) {
                    ol2.d(m0).e().d(1);
                }
                super.i(h94Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                cc3 A0 = this.a.A0(h94Var);
                jx1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + h94Var.i);
                if (A0 == null) {
                    j32 j32Var = this.a;
                    j32Var.j = h94Var;
                    j32Var.i.m(h94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(h94Var);
                        if (j32.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.j0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    f32.c().b(h94Var, this.a.l0());
                    return;
                }
                this.a.i.l(h94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(h94Var, A0));
                }
                f32.c().a(h94Var, this.a.l0(), A0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void c(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, h94Var) == null) {
                String m0 = this.a.m0();
                if (j32.C) {
                    ol2.d(m0).e().d(1);
                }
                super.c(h94Var);
                jx1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: r */
        public void f(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, h94Var) == null) {
                String m0 = this.a.m0();
                if (j32.C) {
                    ol2.d(m0).e().d(1);
                }
                super.f(h94Var);
                if (j32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": main onDownloading");
                }
                this.a.E0(h94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: s */
        public c94 h(h94 h94Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{h94Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String m0 = this.a.m0();
                if (j32.C) {
                    ol2.d(m0).f(h94Var.toString()).d(1);
                }
                C0448a c0448a = new C0448a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                hj2 hj2Var = new hj2();
                hj2Var.v(c0448a);
                hj2Var.J(bundle);
                hj2Var.I(new gj2(h94Var, this.a));
                hj2Var.I(new ej2(h94Var.m, this.a));
                hj2Var.L(readableByteChannel);
                boolean M = hj2Var.M();
                hj2Var.p(c0448a);
                if (j32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": onProcessStream: installOk=" + M);
                }
                if (M) {
                    jx1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    ng4.L(file);
                }
                return M ? new c94(2300, "业务层处理下载流成功") : new c94(2301, "业务层处理下载流失败");
            }
            return (c94) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ cf3 b;

        public b(j32 j32Var, Collection collection, cf3 cf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, collection, cf3Var};
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
            this.b = cf3Var;
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
    public class c implements cf3<s32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf3 a;
        public final /* synthetic */ j32 b;

        public c(j32 j32Var, cf3 cf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, cf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = cf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s32Var) == null) {
                this.a.onCallback(s32Var);
                j32 j32Var = this.b;
                j32Var.i0(j32Var.s, s32Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements cf3<s32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc3 a;
        public final /* synthetic */ boolean b;

        public d(j32 j32Var, cc3 cc3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, cc3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cc3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s32Var) == null) {
                s32Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements cf3<s32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(j32 j32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, pMSAppInfo};
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
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s32Var) == null) {
                s32Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h94 a;
        public final /* synthetic */ j32 b;

        public f(j32 j32Var, h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, h94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = h94Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j32 j32Var = this.b;
                h94 h94Var = this.a;
                j32Var.j = h94Var;
                j32Var.i.m(h94Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, cc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i94 a;
        public final /* synthetic */ j32 b;

        public g(j32 j32Var, i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, i94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = i94Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j32 j32Var = this.b;
                if (j32Var.k == null) {
                    j32Var.k = new ArrayList();
                }
                i94 i94Var = this.a;
                j32 j32Var2 = this.b;
                i94Var.o = j32Var2.o;
                j32Var2.k.add(i94Var);
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

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, cc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f94 a;
        public final /* synthetic */ j32 b;

        public h(j32 j32Var, f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, f94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = f94Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j32 j32Var = this.b;
                f94 f94Var = this.a;
                j32Var.l = f94Var;
                j32Var.i.m(f94Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, cc3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d94 a;
        public final /* synthetic */ j32 b;

        public i(j32 j32Var, d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, d94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = d94Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                jx1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                j32 j32Var = this.b;
                d94 d94Var = this.a;
                j32Var.m = d94Var;
                j32Var.i.m(d94Var);
                this.b.r0(this.a);
            }
        }

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                jx1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + cc3Var.toString());
                this.b.i.l(this.a);
                this.b.r0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends az9<g94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 e;

        public j(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vy9
        /* renamed from: g */
        public void onNext(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g94Var) == null) {
                jx1.k("SwanAppPkgDownloadCallback", this.e.l0() + " : 单个包下载、业务层处理完成：" + g94Var.i);
            }
        }

        @Override // com.repackage.vy9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jx1.k("SwanAppPkgDownloadCallback", this.e.l0() + " : 包下载onCompleted");
                this.e.w0();
            }
        }

        @Override // com.repackage.vy9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                jx1.l("SwanAppPkgDownloadCallback", this.e.l0() + " : 包下载OnError", th);
                this.e.x0(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements uy9.a<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public k(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super h94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.d = az9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements uy9.a<i94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public l(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super i94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.e = az9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements uy9.a<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public m(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super f94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.f = az9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements uy9.a<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public n(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super d94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.g = az9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements uy9.a<j94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public o(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uy9.a, com.repackage.iz9
        public void call(az9<? super j94> az9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
                this.a.h = az9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends q32<j32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(j32 j32Var, j32 j32Var2) {
            super(j32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, j32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j32Var;
        }

        @Override // com.repackage.q32, com.repackage.w74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.k0() : invokeV.intValue;
        }

        @Override // com.repackage.q32
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.q32
        public void p(@NonNull i94 i94Var, @Nullable cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, i94Var, cc3Var) == null) {
                super.p(i94Var, cc3Var);
                jx1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + i94Var.i);
                j32 j32Var = this.c;
                if (j32Var.k == null) {
                    j32Var.k = new ArrayList();
                }
                j32 j32Var2 = this.c;
                i94Var.o = j32Var2.o;
                if (cc3Var == null) {
                    j32Var2.k.add(i94Var);
                    this.c.i.m(i94Var);
                    f32.c().b(i94Var, this.c.l0());
                } else {
                    j32Var2.i.l(i94Var);
                    f32.c().a(i94Var, this.c.l0(), cc3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(i94Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void e(i94 i94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, i94Var, c94Var) == null) {
                super.q(i94Var, c94Var);
                jx1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + c94Var.toString());
                this.c.i.l(i94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(c94Var.a);
                cc3Var.d("分包下载失败");
                cc3Var.f(c94Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(i94Var, cc3Var));
                }
                f32.c().a(i94Var, this.c.l0(), cc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q32, com.repackage.w74, com.repackage.z74
        /* renamed from: s */
        public void c(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, i94Var) == null) {
                super.c(i94Var);
                jx1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: u */
        public void f(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i94Var) == null) {
                super.f(i94Var);
                this.c.F0(i94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends o32<j32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(j32 j32Var, j32 j32Var2) {
            super(j32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, j32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
        }

        @Override // com.repackage.w74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.k0() : invokeV.intValue;
        }

        @Override // com.repackage.o32
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.l0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.o32
        public void r(@NonNull j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, j94Var) == null) {
                this.b.i.m(j94Var);
                if (this.b.h != null) {
                    this.b.h.onNext(j94Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.o32
        public void u(j94 j94Var, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, j94Var, cc3Var) == null) {
                jx1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + cc3Var);
                this.b.i.l(j94Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(j94Var, cc3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o32, com.repackage.w74, com.repackage.z74
        /* renamed from: v */
        public void c(j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, j94Var) == null) {
                super.c(j94Var);
                jx1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o32, com.repackage.w74, com.repackage.z74
        /* renamed from: w */
        public void f(j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, j94Var) == null) {
                super.f(j94Var);
                if (j32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.j0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends w74<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public r(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // com.repackage.w74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z74
        /* renamed from: l */
        public String d(f94 f94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f94Var)) == null) {
                int i = f94Var.h;
                if (i == 0) {
                    return b42.h();
                }
                if (i == 1) {
                    return b42.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.b84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: o */
        public void e(f94 f94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var, c94Var) == null) {
                super.e(f94Var, c94Var);
                jx1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + c94Var.toString());
                this.a.i.l(f94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(13L);
                cc3Var.i(c94Var.a);
                cc3Var.d("Framework包下载失败");
                cc3Var.f(c94Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(f94Var, cc3Var));
                }
                f32.c().a(f94Var, this.a.l0(), cc3Var);
                ng4.k(f94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: p */
        public void i(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, f94Var) == null) {
                super.i(f94Var);
                jx1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + f94Var.i);
                cc3 z0 = this.a.z0(f94Var);
                if (z0 == null) {
                    j32 j32Var = this.a;
                    j32Var.l = f94Var;
                    j32Var.i.m(f94Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(f94Var);
                        this.a.f.onCompleted();
                    }
                    f32.c().b(f94Var, this.a.l0());
                    return;
                }
                this.a.i.l(f94Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(f94Var, z0));
                }
                f32.c().a(f94Var, this.a.l0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void c(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, f94Var) == null) {
                super.c(f94Var);
                jx1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: r */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, f94Var) == null) {
                super.f(f94Var);
                if (j32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": framework onDownloading");
                }
                this.a.D0(f94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends w74<d94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public s(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // com.repackage.w74
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z74
        /* renamed from: l */
        public String d(d94 d94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d94Var)) == null) {
                int i = d94Var.h;
                if (i == 0) {
                    return b42.d();
                }
                if (i == 1) {
                    return b42.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.b84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: o */
        public void e(d94 d94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d94Var, c94Var) == null) {
                super.e(d94Var, c94Var);
                jx1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + c94Var.toString());
                this.a.i.l(d94Var);
                cc3 cc3Var = new cc3();
                cc3Var.k(14L);
                cc3Var.i(c94Var.a);
                cc3Var.d("Extension下载失败");
                cc3Var.f(c94Var.toString());
                if (j32.C) {
                    Log.e("SwanAppPkgDownloadCallback", cc3Var.toString());
                }
                this.a.r0(d94Var);
                f32.c().a(d94Var, this.a.l0(), cc3Var);
                ng4.k(d94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: p */
        public void i(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, d94Var) == null) {
                super.i(d94Var);
                jx1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + d94Var.i);
                cc3 y0 = this.a.y0(d94Var);
                if (y0 != null) {
                    if (j32.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + d94Var.toString());
                    }
                    this.a.i.l(d94Var);
                    this.a.r0(d94Var);
                    f32.c().a(d94Var, this.a.l0(), y0);
                    return;
                }
                j32 j32Var = this.a;
                j32Var.m = d94Var;
                j32Var.i.m(d94Var);
                this.a.r0(d94Var);
                f32.c().b(d94Var, this.a.l0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void c(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, d94Var) == null) {
                super.c(d94Var);
                jx1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: r */
        public void f(d94 d94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, d94Var) == null) {
                super.f(d94Var);
                if (j32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": extension onDownloading");
                }
                this.a.C0(d94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements c84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public t(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // com.repackage.c84
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (j32.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.j0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                j32 j32Var = this.a;
                j32Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    j32Var.p0(pMSAppInfo);
                    hw2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements cf3<cf3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(j32 j32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, pMSAppInfo};
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
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(cf3<PMSAppInfo> cf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cf3Var) == null) {
                cf3Var.onCallback(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(j32 j32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, collection, obj};
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

        public w(j32 j32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755639672, "Lcom/repackage/j32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755639672, "Lcom/repackage/j32;");
                return;
            }
        }
        C = tg1.a;
    }

    public j32(String str) {
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
        this.u = new me3();
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

    public cc3 A0(h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h94Var)) == null) {
            if (h94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(11L);
                cc3Var.i(2310L);
                cc3Var.f("pkg info is empty");
                gc3.a().f(cc3Var);
                return cc3Var;
            }
            return null;
        }
        return (cc3) invokeL.objValue;
    }

    @Override // com.repackage.d84
    public z74<i94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w : (z74) invokeV.objValue;
    }

    public void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            cv2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void C0(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d94Var) == null) {
            f32.c().d(d94Var, new i(this, d94Var));
        }
    }

    @Override // com.repackage.d84
    public void D(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c94Var) == null) {
            jx1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + c94Var);
            if (c94Var != null && c94Var.a == 1010) {
                H0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f94Var) == null) {
            f32.c().d(f94Var, new h(this, f94Var));
        }
    }

    @Override // com.repackage.d84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void E0(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h94Var) == null) {
            f32.c().d(h94Var, new f(this, h94Var));
        }
    }

    @Override // com.repackage.d84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void F0(i94 i94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, i94Var) == null) {
            f32.c().d(i94Var, new g(this, i94Var));
        }
    }

    public cc3 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    cc3 cc3Var = new cc3();
                    cc3Var.k(10L);
                    cc3Var.i(2903L);
                    cc3Var.d("Server未返回主包&AppInfo");
                    return cc3Var;
                }
                PMSAppInfo u2 = f84.i().u(this.o);
                if (u2 == null) {
                    cc3 cc3Var2 = new cc3();
                    cc3Var2.k(10L);
                    cc3Var2.i(2904L);
                    cc3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return cc3Var2;
                }
                this.n = u2;
                b42.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(K());
                if (f84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                cc3 cc3Var3 = new cc3();
                cc3Var3.k(10L);
                cc3Var3.i(2906L);
                cc3Var3.d("更新DB失败");
                return cc3Var3;
            }
            h94 h94Var = this.j;
            if (h94Var != null) {
                b42.k(pMSAppInfo, h94Var);
            } else if (c42.f(this.k)) {
                i94 i94Var = this.k.get(0);
                this.q = i94Var;
                i94Var.o = this.o;
                b42.l(this.n, i94Var);
            } else {
                PMSAppInfo u3 = f84.i().u(this.o);
                if (u3 == null) {
                    cc3 cc3Var4 = new cc3();
                    cc3Var4.k(10L);
                    cc3Var4.i(2905L);
                    cc3Var4.d("Server未返回包数据，本地也没有数据");
                    return cc3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(K());
            if (f84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                b42.o(this.n);
                return null;
            }
            cc3 cc3Var5 = new cc3();
            cc3Var5.k(10L);
            cc3Var5.i(2906L);
            cc3Var5.d("更新DB失败");
            return cc3Var5;
        }
        return (cc3) invokeV.objValue;
    }

    @Override // com.repackage.d84
    public void H(qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qd4Var) == null) {
            super.H(qd4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (qd4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", j0() + ": onPrepareDownload: countSet=" + qd4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = qd4Var;
            if (qd4Var.k()) {
                return;
            }
            o0();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PMSAppInfo u2 = f84.i().u(this.o);
            jx1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(K());
                h94 h94Var = this.j;
                if (h94Var != null) {
                    h94Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(K());
                }
                f84.i().l(u2);
            }
        }
    }

    public j32 f0(cf3<PMSAppInfo> cf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cf3Var)) == null) {
            g0(this.t, cf3Var);
            return this;
        }
        return (j32) invokeL.objValue;
    }

    public final synchronized <CallbackT> j32 g0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (j32) invokeLL.objValue;
    }

    public synchronized j32 h0(s32 s32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, s32Var)) == null) {
            synchronized (this) {
                g0(this.s, s32Var);
            }
            return this;
        }
        return (j32) invokeL.objValue;
    }

    public final synchronized <CallbackT> j32 i0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (j32) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? e84.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 1013) {
                f84.i().z(this.o, i2);
            } else {
                f84.i().z(this.o, 0);
            }
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(uy9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(uy9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(uy9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(uy9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(uy9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            uy9.i(arrayList).u(this.B);
        }
    }

    public j32 p0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pMSAppInfo)) == null) {
            q0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (j32) invokeL.objValue;
    }

    @Override // com.repackage.d84
    public c84 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.A : (c84) invokeV.objValue;
    }

    public final synchronized <CallbackT> j32 q0(@NonNull Collection<CallbackT> collection, @NonNull cf3<CallbackT> cf3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, collection, cf3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, cf3Var));
            }
            return this;
        }
        return (j32) invokeLL.objValue;
    }

    @Override // com.repackage.d84
    public z74<j94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.x : (z74) invokeV.objValue;
    }

    public final void r0(d94 d94Var) {
        az9<? super d94> az9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, d94Var) == null) || (az9Var = this.g) == null) {
            return;
        }
        az9Var.onNext(d94Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.d84
    public z74<d94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z : (z74) invokeV.objValue;
    }

    public j32 s0(@NonNull cf3<s32> cf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cf3Var)) == null) {
            q0(this.s, new c(this, cf3Var));
            return this;
        }
        return (j32) invokeL.objValue;
    }

    @Override // com.repackage.d84
    public z74<f94> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.y : (z74) invokeV.objValue;
    }

    public void t0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pMSAppInfo) == null) {
            s0(new e(this, pMSAppInfo));
        }
    }

    public void u0(boolean z, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, cc3Var) == null) {
            s0(new d(this, cc3Var, z));
        }
    }

    @Override // com.repackage.d84
    public z74<h94> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v : (z74) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = f84.i().u(this.o);
        if (u2 == null) {
            jx1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(K());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (f84.i().l(this.n)) {
            b42.o(this.n);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            jx1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void x0(Throwable th);

    public cc3 y0(d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, d94Var)) == null) {
            pb2 pb2Var = new pb2();
            pb2Var.b = d94Var.i;
            pb2Var.a = d94Var.j;
            pb2Var.c = d94Var.a;
            pb2Var.d = d94Var.m;
            if (sa2.b(d94Var.h, pb2Var) == null) {
                return null;
            }
            cc3 cc3Var = new cc3();
            cc3Var.k(14L);
            cc3Var.b(2908L);
            cc3Var.d("Extension包更新失败");
            return cc3Var;
        }
        return (cc3) invokeL.objValue;
    }

    public cc3 z0(f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, f94Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + f94Var);
            }
            t93.b c2 = t93.c(f94Var, f94Var.h);
            if (!TextUtils.isEmpty(f94Var.a)) {
                jx1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + f94Var.a);
                ng4.k(f94Var.a);
            }
            if (c2.c()) {
                return null;
            }
            cc3 cc3Var = new cc3();
            cc3Var.k(13L);
            cc3Var.b(2907L);
            cc3Var.d("Core包更新失败");
            return cc3Var;
        }
        return (cc3) invokeL.objValue;
    }
}
