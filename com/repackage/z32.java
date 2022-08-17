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
import com.repackage.d13;
import com.repackage.ja3;
import com.repackage.ru9;
import com.repackage.v32;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class z32 extends d42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public r84 A;
    public xu9<v94> B;
    public String c;
    public xu9<? super w94> d;
    public xu9<? super x94> e;
    public xu9<? super u94> f;
    public xu9<? super s94> g;
    public xu9<? super y94> h;
    public fe4 i;
    public w94 j;
    public List<x94> k;
    public u94 l;
    public s94 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public x94 q;
    public long r;
    public final Set<i42> s;
    public final Set<sf3<PMSAppInfo>> t;
    public final cf3 u;
    public o84<w94> v;
    public o84<x94> w;
    public final o84<y94> x;
    public o84<u94> y;
    public o84<s94> z;

    /* loaded from: classes7.dex */
    public class a extends l84<w94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        /* renamed from: com.repackage.z32$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0640a implements sf3<d13.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0640a(a aVar) {
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
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(d13.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    t84.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        @Override // com.repackage.l84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(w94 w94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, w94Var)) == null) {
                int i = w94Var.h;
                if (i == 0) {
                    return r42.g();
                }
                if (i == 1) {
                    return r42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(w94 w94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, w94Var, r94Var) == null) {
                super.e(w94Var, r94Var);
                zx1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + r94Var.toString());
                this.a.i.l(w94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(11L);
                sc3Var.i(r94Var.a);
                sc3Var.d("主包下载失败");
                sc3Var.f(r94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(w94Var, sc3Var));
                }
                v32.c().a(w94Var, this.a.k0(), sc3Var);
                bh4.k(w94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(w94 w94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, w94Var) == null) {
                String l0 = this.a.l0();
                if (z32.C) {
                    em2.d(l0).e().d(1);
                }
                super.i(w94Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                sc3 z0 = this.a.z0(w94Var);
                zx1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + w94Var.i);
                if (z0 == null) {
                    z32 z32Var = this.a;
                    z32Var.j = w94Var;
                    z32Var.i.m(w94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(w94Var);
                        if (z32.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    v32.c().b(w94Var, this.a.k0());
                    return;
                }
                this.a.i.l(w94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(w94Var, z0));
                }
                v32.c().a(w94Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void c(w94 w94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, w94Var) == null) {
                String l0 = this.a.l0();
                if (z32.C) {
                    em2.d(l0).e().d(1);
                }
                super.c(w94Var);
                zx1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void f(w94 w94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, w94Var) == null) {
                String l0 = this.a.l0();
                if (z32.C) {
                    em2.d(l0).e().d(1);
                }
                super.f(w94Var);
                if (z32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(w94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: s */
        public r94 h(w94 w94Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{w94Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (z32.C) {
                    em2.d(l0).f(w94Var.toString()).d(1);
                }
                C0640a c0640a = new C0640a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                xj2 xj2Var = new xj2();
                xj2Var.u(c0640a);
                xj2Var.K(bundle);
                xj2Var.J(new wj2(w94Var, this.a));
                xj2Var.J(new uj2(w94Var.m, this.a));
                xj2Var.M(readableByteChannel);
                boolean N = xj2Var.N();
                xj2Var.o(c0640a);
                if (z32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    zx1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    bh4.L(file);
                }
                return N ? new r94(2300, "业务层处理下载流成功") : new r94(2301, "业务层处理下载流失败");
            }
            return (r94) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ sf3 b;

        public b(z32 z32Var, Collection collection, sf3 sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, collection, sf3Var};
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
            this.b = sf3Var;
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
    public class c implements sf3<i42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf3 a;
        public final /* synthetic */ z32 b;

        public c(z32 z32Var, sf3 sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, sf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
            this.a = sf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i42Var) == null) {
                this.a.a(i42Var);
                z32 z32Var = this.b;
                z32Var.h0(z32Var.s, i42Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements sf3<i42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc3 a;
        public final /* synthetic */ boolean b;

        public d(z32 z32Var, sc3 sc3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, sc3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i42Var) == null) {
                i42Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements sf3<i42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(z32 z32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, pMSAppInfo};
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i42Var) == null) {
                i42Var.b(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w94 a;
        public final /* synthetic */ z32 b;

        public f(z32 z32Var, w94 w94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, w94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
            this.a = w94Var;
        }

        @Override // com.repackage.v32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                z32 z32Var = this.b;
                w94 w94Var = this.a;
                z32Var.j = w94Var;
                z32Var.i.m(w94Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, sc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x94 a;
        public final /* synthetic */ z32 b;

        public g(z32 z32Var, x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, x94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
            this.a = x94Var;
        }

        @Override // com.repackage.v32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                z32 z32Var = this.b;
                if (z32Var.k == null) {
                    z32Var.k = new ArrayList();
                }
                x94 x94Var = this.a;
                z32 z32Var2 = this.b;
                x94Var.o = z32Var2.o;
                z32Var2.k.add(x94Var);
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

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, sc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u94 a;
        public final /* synthetic */ z32 b;

        public h(z32 z32Var, u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, u94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
            this.a = u94Var;
        }

        @Override // com.repackage.v32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                z32 z32Var = this.b;
                u94 u94Var = this.a;
                z32Var.l = u94Var;
                z32Var.i.m(u94Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, sc3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s94 a;
        public final /* synthetic */ z32 b;

        public i(z32 z32Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, s94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
            this.a = s94Var;
        }

        @Override // com.repackage.v32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                zx1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                z32 z32Var = this.b;
                s94 s94Var = this.a;
                z32Var.m = s94Var;
                z32Var.i.m(s94Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                zx1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + sc3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends xu9<v94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 e;

        public j(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.su9
        /* renamed from: g */
        public void onNext(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v94Var) == null) {
                zx1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + v94Var.i);
            }
        }

        @Override // com.repackage.su9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zx1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.repackage.su9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                zx1.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements ru9.a<w94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public k(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super w94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.d = xu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements ru9.a<x94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public l(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super x94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.e = xu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements ru9.a<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public m(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super u94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.f = xu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ru9.a<s94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public n(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super s94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.g = xu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements ru9.a<y94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public o(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super y94> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                this.a.h = xu9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends g42<z32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(z32 z32Var, z32 z32Var2) {
            super(z32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, z32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z32Var;
        }

        @Override // com.repackage.g42, com.repackage.l84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.repackage.g42
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.repackage.g42
        public void p(@NonNull x94 x94Var, @Nullable sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, x94Var, sc3Var) == null) {
                super.p(x94Var, sc3Var);
                zx1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + x94Var.i);
                z32 z32Var = this.c;
                if (z32Var.k == null) {
                    z32Var.k = new ArrayList();
                }
                z32 z32Var2 = this.c;
                x94Var.o = z32Var2.o;
                if (sc3Var == null) {
                    z32Var2.k.add(x94Var);
                    this.c.i.m(x94Var);
                    v32.c().b(x94Var, this.c.k0());
                } else {
                    z32Var2.i.l(x94Var);
                    v32.c().a(x94Var, this.c.k0(), sc3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(x94Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void e(x94 x94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, x94Var, r94Var) == null) {
                super.q(x94Var, r94Var);
                zx1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + r94Var.toString());
                this.c.i.l(x94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(12L);
                sc3Var.i(r94Var.a);
                sc3Var.d("分包下载失败");
                sc3Var.f(r94Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(x94Var, sc3Var));
                }
                v32.c().a(x94Var, this.c.k0(), sc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g42, com.repackage.l84, com.repackage.o84
        /* renamed from: s */
        public void c(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, x94Var) == null) {
                super.c(x94Var);
                zx1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: u */
        public void f(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x94Var) == null) {
                super.f(x94Var);
                this.c.E0(x94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends e42<z32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(z32 z32Var, z32 z32Var2) {
            super(z32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, z32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
        }

        @Override // com.repackage.l84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.repackage.e42
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.repackage.e42
        public void r(@NonNull y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, y94Var) == null) {
                this.b.i.m(y94Var);
                if (this.b.h != null) {
                    this.b.h.onNext(y94Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.repackage.e42
        public void u(y94 y94Var, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, y94Var, sc3Var) == null) {
                zx1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + sc3Var);
                this.b.i.l(y94Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(y94Var, sc3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e42, com.repackage.l84, com.repackage.o84
        /* renamed from: v */
        public void c(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, y94Var) == null) {
                super.c(y94Var);
                zx1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e42, com.repackage.l84, com.repackage.o84
        /* renamed from: w */
        public void f(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, y94Var) == null) {
                super.f(y94Var);
                if (z32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends l84<u94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public r(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        @Override // com.repackage.l84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(u94 u94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, u94Var)) == null) {
                int i = u94Var.h;
                if (i == 0) {
                    return r42.h();
                }
                if (i == 1) {
                    return r42.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(u94 u94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u94Var, r94Var) == null) {
                super.e(u94Var, r94Var);
                zx1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + r94Var.toString());
                this.a.i.l(u94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(13L);
                sc3Var.i(r94Var.a);
                sc3Var.d("Framework包下载失败");
                sc3Var.f(r94Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(u94Var, sc3Var));
                }
                v32.c().a(u94Var, this.a.k0(), sc3Var);
                bh4.k(u94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, u94Var) == null) {
                super.i(u94Var);
                zx1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + u94Var.i);
                sc3 y0 = this.a.y0(u94Var);
                if (y0 == null) {
                    z32 z32Var = this.a;
                    z32Var.l = u94Var;
                    z32Var.i.m(u94Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(u94Var);
                        this.a.f.onCompleted();
                    }
                    v32.c().b(u94Var, this.a.k0());
                    return;
                }
                this.a.i.l(u94Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(u94Var, y0));
                }
                v32.c().a(u94Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void c(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, u94Var) == null) {
                super.c(u94Var);
                zx1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void f(u94 u94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, u94Var) == null) {
                super.f(u94Var);
                if (z32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(u94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends l84<s94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public s(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        @Override // com.repackage.l84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(s94 s94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s94Var)) == null) {
                int i = s94Var.h;
                if (i == 0) {
                    return r42.d();
                }
                if (i == 1) {
                    return r42.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(s94 s94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s94Var, r94Var) == null) {
                super.e(s94Var, r94Var);
                zx1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + r94Var.toString());
                this.a.i.l(s94Var);
                sc3 sc3Var = new sc3();
                sc3Var.k(14L);
                sc3Var.i(r94Var.a);
                sc3Var.d("Extension下载失败");
                sc3Var.f(r94Var.toString());
                if (z32.C) {
                    Log.e("SwanAppPkgDownloadCallback", sc3Var.toString());
                }
                this.a.q0(s94Var);
                v32.c().a(s94Var, this.a.k0(), sc3Var);
                bh4.k(s94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, s94Var) == null) {
                super.i(s94Var);
                zx1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + s94Var.i);
                sc3 x0 = this.a.x0(s94Var);
                if (x0 != null) {
                    if (z32.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + s94Var.toString());
                    }
                    this.a.i.l(s94Var);
                    this.a.q0(s94Var);
                    v32.c().a(s94Var, this.a.k0(), x0);
                    return;
                }
                z32 z32Var = this.a;
                z32Var.m = s94Var;
                z32Var.i.m(s94Var);
                this.a.q0(s94Var);
                v32.c().b(s94Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void c(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, s94Var) == null) {
                super.c(s94Var);
                zx1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void f(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, s94Var) == null) {
                super.f(s94Var);
                if (z32.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(s94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements r84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public t(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        @Override // com.repackage.r84
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (z32.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                z32 z32Var = this.a;
                z32Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    z32Var.o0(pMSAppInfo);
                    xw2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements sf3<sf3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(z32 z32Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, pMSAppInfo};
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(sf3<PMSAppInfo> sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sf3Var) == null) {
                sf3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(z32 z32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, collection, obj};
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

        public w(z32 z32Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755163016, "Lcom/repackage/z32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755163016, "Lcom/repackage/z32;");
                return;
            }
        }
        C = jh1.a;
    }

    public z32(String str) {
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
        this.u = new cf3();
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

    @Override // com.repackage.s84
    public o84<x94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (o84) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            sv2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s94Var) == null) {
            v32.c().d(s94Var, new i(this, s94Var));
        }
    }

    @Override // com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r94Var) == null) {
            zx1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + r94Var);
            if (r94Var != null && r94Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(u94 u94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, u94Var) == null) {
            v32.c().d(u94Var, new h(this, u94Var));
        }
    }

    @Override // com.repackage.s84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(w94 w94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, w94Var) == null) {
            v32.c().d(w94Var, new f(this, w94Var));
        }
    }

    @Override // com.repackage.s84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x94Var) == null) {
            v32.c().d(x94Var, new g(this, x94Var));
        }
    }

    public sc3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    sc3 sc3Var = new sc3();
                    sc3Var.k(10L);
                    sc3Var.i(2903L);
                    sc3Var.d("Server未返回主包&AppInfo");
                    return sc3Var;
                }
                PMSAppInfo u2 = u84.i().u(this.o);
                if (u2 == null) {
                    sc3 sc3Var2 = new sc3();
                    sc3Var2.k(10L);
                    sc3Var2.i(2904L);
                    sc3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return sc3Var2;
                }
                this.n = u2;
                r42.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (u84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                sc3 sc3Var3 = new sc3();
                sc3Var3.k(10L);
                sc3Var3.i(2906L);
                sc3Var3.d("更新DB失败");
                return sc3Var3;
            }
            w94 w94Var = this.j;
            if (w94Var != null) {
                r42.k(pMSAppInfo, w94Var);
            } else if (s42.f(this.k)) {
                x94 x94Var = this.k.get(0);
                this.q = x94Var;
                x94Var.o = this.o;
                r42.l(this.n, x94Var);
            } else {
                PMSAppInfo u3 = u84.i().u(this.o);
                if (u3 == null) {
                    sc3 sc3Var4 = new sc3();
                    sc3Var4.k(10L);
                    sc3Var4.i(2905L);
                    sc3Var4.d("Server未返回包数据，本地也没有数据");
                    return sc3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (u84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                r42.o(this.n);
                return null;
            }
            sc3 sc3Var5 = new sc3();
            sc3Var5.k(10L);
            sc3Var5.i(2906L);
            sc3Var5.d("更新DB失败");
            return sc3Var5;
        }
        return (sc3) invokeV.objValue;
    }

    @Override // com.repackage.s84
    public void G(fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fe4Var) == null) {
            super.G(fe4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (fe4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + fe4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = fe4Var;
            if (fe4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = u84.i().u(this.o);
            zx1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                w94 w94Var = this.j;
                if (w94Var != null) {
                    w94Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                u84.i().l(u2);
            }
        }
    }

    public z32 e0(sf3<PMSAppInfo> sf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, sf3Var)) == null) {
            f0(this.t, sf3Var);
            return this;
        }
        return (z32) invokeL.objValue;
    }

    public final synchronized <CallbackT> z32 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (z32) invokeLL.objValue;
    }

    public synchronized z32 g0(i42 i42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, i42Var)) == null) {
            synchronized (this) {
                f0(this.s, i42Var);
            }
            return this;
        }
        return (z32) invokeL.objValue;
    }

    public final synchronized <CallbackT> z32 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (z32) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? t84.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                u84.i().z(this.o, i2);
            } else {
                u84.i().z(this.o, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(ru9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(ru9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(ru9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(ru9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(ru9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ru9.i(arrayList).u(this.B);
        }
    }

    public z32 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (z32) invokeL.objValue;
    }

    @Override // com.repackage.s84
    public r84 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (r84) invokeV.objValue;
    }

    public final synchronized <CallbackT> z32 p0(@NonNull Collection<CallbackT> collection, @NonNull sf3<CallbackT> sf3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, sf3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, sf3Var));
            }
            return this;
        }
        return (z32) invokeLL.objValue;
    }

    @Override // com.repackage.s84
    public o84<y94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (o84) invokeV.objValue;
    }

    public final void q0(s94 s94Var) {
        xu9<? super s94> xu9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, s94Var) == null) || (xu9Var = this.g) == null) {
            return;
        }
        xu9Var.onNext(s94Var);
        this.g.onCompleted();
    }

    @Override // com.repackage.s84
    public o84<s94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (o84) invokeV.objValue;
    }

    public z32 r0(@NonNull sf3<i42> sf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, sf3Var)) == null) {
            p0(this.s, new c(this, sf3Var));
            return this;
        }
        return (z32) invokeL.objValue;
    }

    @Override // com.repackage.s84
    public o84<u94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (o84) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, sc3Var) == null) {
            r0(new d(this, sc3Var, z));
        }
    }

    @Override // com.repackage.s84
    public o84<w94> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (o84) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = u84.i().u(this.o);
        if (u2 == null) {
            zx1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (u84.i().l(this.n)) {
            r42.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            zx1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public sc3 x0(s94 s94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, s94Var)) == null) {
            fc2 fc2Var = new fc2();
            fc2Var.b = s94Var.i;
            fc2Var.a = s94Var.j;
            fc2Var.c = s94Var.a;
            fc2Var.d = s94Var.m;
            if (ib2.b(s94Var.h, fc2Var) == null) {
                return null;
            }
            sc3 sc3Var = new sc3();
            sc3Var.k(14L);
            sc3Var.b(2908L);
            sc3Var.d("Extension包更新失败");
            return sc3Var;
        }
        return (sc3) invokeL.objValue;
    }

    public sc3 y0(u94 u94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, u94Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + u94Var);
            }
            ja3.b c2 = ja3.c(u94Var, u94Var.h);
            if (!TextUtils.isEmpty(u94Var.a)) {
                zx1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + u94Var.a);
                bh4.k(u94Var.a);
            }
            if (c2.c()) {
                return null;
            }
            sc3 sc3Var = new sc3();
            sc3Var.k(13L);
            sc3Var.b(2907L);
            sc3Var.d("Core包更新失败");
            return sc3Var;
        }
        return (sc3) invokeL.objValue;
    }

    public sc3 z0(w94 w94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, w94Var)) == null) {
            if (w94Var == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(11L);
                sc3Var.i(2310L);
                sc3Var.f("pkg info is empty");
                wc3.a().f(sc3Var);
                return sc3Var;
            }
            return null;
        }
        return (sc3) invokeL.objValue;
    }
}
