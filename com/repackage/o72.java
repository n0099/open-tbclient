package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import com.kwad.v8.NodeJS;
import com.repackage.b62;
import com.repackage.c73;
import com.repackage.qj2;
import com.repackage.y52;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class o72 implements jm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public static volatile o72 B;
    public static int C;
    public static boolean D;
    public static PreloadState E;
    public static boolean F;
    public static final boolean G;
    public static int H;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion a;
    @Nullable
    public ExtensionCore b;
    public wz1 c;
    public List<s> d;
    public final List<iz1> e;
    public x22<w22> f;
    public q22 g;
    public boolean h;
    public an1<?> i;
    public an1<?> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final HashMap<String, cn1> o;
    public LinkedList<ua2> p;
    public final Object q;
    public final Object r;
    public final String s;
    public String t;
    public s u;
    public vm1 v;
    public gn1 w;
    public volatile boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public static class a extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.o72$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0478a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0478a(a aVar) {
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
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    o72.N0(false);
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.o72.s
        public void b(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o72Var) == null) {
                boolean z = !TextUtils.isEmpty(t03.J().getAppId());
                ux1.k("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (z) {
                    return;
                }
                t03.J().z().X(15);
                oe3.e0(new RunnableC0478a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements z22<w22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public b(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z22
        /* renamed from: b */
        public void a(boolean z, w22 w22Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, w22Var) == null) {
                this.a.y = z;
                if (z) {
                    zt2.p(NodeJS.STARTUP_SCRIPT_NAME).D("prefetch_env", "1");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements f32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public c(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        @Override // com.repackage.f32
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends iz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public d(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        @Override // com.repackage.iz1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ux1.k("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends iz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public e(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        @Override // com.repackage.iz1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ux1.k("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.a.k = true;
                this.a.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends iz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public f(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        @Override // com.repackage.iz1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this.a.r) {
                    this.a.l = true;
                }
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
                for (iz1 iz1Var : this.a.e) {
                    iz1Var.a(str);
                }
                this.a.e.clear();
                ux1.k("SwanAppCoreRuntime", "prepareNaSlave finished");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends iz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 a;
        public final /* synthetic */ rl2 b;
        public final /* synthetic */ qj2.g c;
        public final /* synthetic */ o72 d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.a;
                    q22 q22Var = gVar.a;
                    an1 an1Var = gVar.d.j;
                    g gVar2 = this.a;
                    f43.i(q22Var, an1Var, gVar2.b, gVar2.c);
                    o72 o72Var = this.a.d;
                    o72Var.M0(o72Var.i);
                }
            }
        }

        public g(o72 o72Var, q22 q22Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, q22Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o72Var;
            this.a = q22Var;
            this.b = rl2Var;
            this.c = gVar;
        }

        @Override // com.repackage.iz1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this.d.r) {
                    this.d.l = true;
                }
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
                ux1.k("SwanAppCoreRuntime", "prepareNaSlave finished");
                oe3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements nf3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public h(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.T0(u.h(bool));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;

        public i(o72 o72Var, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a = bk2.u0().a();
                if (o72.A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a);
                }
                nf3 nf3Var = this.a;
                if (nf3Var != null) {
                    nf3Var.onCallback(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hd3.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o72 a;

            public a(k kVar, o72 o72Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, o72Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = o72Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.e1();
                }
            }
        }

        public k(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        @Override // com.repackage.o72.s
        public void b(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o72Var) == null) {
                if (o72.A) {
                    sf4.b().e();
                    m03 f = m03.f(o72.getContext(), R.string.obfuscated_res_0x7f0f01a5);
                    f.l(1);
                    f.G();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                oe3.a0(new a(this, o72Var));
                if (o72.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                px2.P().X(14);
                if (e72.f() || e72.g()) {
                    this.a.F0();
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "prepare " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o72 a;

        public l(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o72Var;
        }

        @Override // com.repackage.o72.s
        public void b(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o72Var) == null) {
                if (e72.f() || e72.g()) {
                    this.a.F0();
                }
                if (o72.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;
        public final /* synthetic */ qj2.g b;
        public final /* synthetic */ o72 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o72 a;
            public final /* synthetic */ m b;

            public a(m mVar, o72 o72Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, o72Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = o72Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m) {
                    return;
                }
                zt2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_pre_load_ok"));
                u63.d().i("na_pre_load_ok");
                zt2.h("preload", NodeJS.STARTUP_SCRIPT_NAME);
                m mVar = this.b;
                mVar.c.t0(this.a, mVar.a, mVar.b);
                zt2.j(this.b.a, false);
            }
        }

        public m(o72 o72Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o72Var;
            this.a = rl2Var;
            this.b = gVar;
        }

        @Override // com.repackage.o72.s
        public void b(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o72Var) == null) {
                oe3.e0(new a(this, o72Var));
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "startFirstPage " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public n(o72 o72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f43.k(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f43.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u03 a;
        public final /* synthetic */ o72 b;

        public p(o72 o72Var, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o72Var;
            this.a = u03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e72.d() && TextUtils.isEmpty(hm2.U().z()) && !e72.h(this.a)) {
                    if (o72.A) {
                        Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                        return;
                    }
                    return;
                }
                String d = f43.d(hm2.U(), this.a.X(), this.a.P());
                int c = e72.c(d);
                if (!this.b.O(c)) {
                    j72.c(11);
                    return;
                }
                an1 an1Var = null;
                if (b62.a.b()) {
                    equals = true;
                } else {
                    SwanAppConfigData P = this.a.P();
                    String h = P != null ? P.h(d) : null;
                    equals = "main".equals(h);
                    int i = 0;
                    if (h == null) {
                        i = 12;
                    } else if (!equals) {
                        i = 13;
                    }
                    if (i != 0) {
                        j72.c(i);
                    }
                }
                if (c != 0 || this.b.i == null) {
                    if (c == 1 && this.b.j != null) {
                        an1Var = this.b.j;
                    }
                } else {
                    an1Var = this.b.i;
                }
                an1 an1Var2 = an1Var;
                if (an1Var2 == null) {
                    return;
                }
                if (equals && this.a.P() != null) {
                    c62.c().b(o72.G ? ((w22) this.b.f.e(this.a.V().f0())).i() : this.b.g, an1Var2, this.a.X(), this.a.P(), null, true);
                } else if (this.a.P() == null) {
                    j72.c(15);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements wz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ o72 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (o72.A) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.a.b.m);
                    }
                    if (this.a.b.m) {
                        if (o72.A) {
                            Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                            return;
                        }
                        return;
                    }
                    this.a.b.g1();
                    this.a.b.f1();
                    if (this.a.b.a == null) {
                        PreloadState unused = o72.E = PreloadState.LOAD_FAILED;
                        this.a.b.h0();
                        return;
                    }
                    q qVar = this.a;
                    qVar.b.E0(qVar.a);
                    this.a.b.L0();
                }
            }
        }

        public q(o72 o72Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o72Var;
            this.a = z;
        }

        @Override // com.repackage.wz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (o72.A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                }
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                oe3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-173430439, "Lcom/repackage/o72$r;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-173430439, "Lcom/repackage/o72$r;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                bk2.g0().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (o72.A) {
                    Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
                }
                return 6000;
            }
            return invokeV.intValue;
        }

        public static int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                bk2.g0().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (o72.A) {
                    Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (a < 0) {
                    bk2.g0().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    a = 0;
                }
                return a;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                bk2.g0().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (o72.A) {
                    Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                boolean z = c() > 0;
                ux1.k("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class s implements nf3<o72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o72Var) == null) {
                b(o72Var);
            }
        }

        public abstract void b(o72 o72Var);
    }

    /* loaded from: classes6.dex */
    public static class t extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hasMessages(1002) : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasMessages(1001) : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                removeCallbacksAndMessages(null);
                removeCallbacks(u.f);
                removeCallbacks(u.g);
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                sendEmptyMessageDelayed(1001, i);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                int i = message.what;
                if (i == 1001) {
                    u.f.run();
                } else if (i == 1002) {
                    u.g.run();
                }
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                sendEmptyMessageDelayed(1002, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public static final int a;
        public static final int b;
        public static int c;
        public static int d;
        public static t e;
        public static final Runnable f;
        public static final Runnable g;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || t03.J().r().x0()) {
                    return;
                }
                if (!o72.B.m0()) {
                    boolean z = true;
                    if (u.d < 1) {
                        if (!((u.e == null || !u.e.a()) ? false : false)) {
                            if (u.e == null) {
                                t unused = u.e = new t(t03.J().getMainLooper());
                            }
                            u.e.e(r.d());
                        }
                        ux1.k("SwanAppCoreRuntime", "start retry runtime.");
                        o72.P0();
                        nc3 nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(49L);
                        nc3Var.f("start retry");
                        u.j(nc3Var);
                        return;
                    }
                    ux1.k("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                ux1.k("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
            }
        }

        /* loaded from: classes6.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || t03.J().r().x0()) {
                    return;
                }
                if (!o72.B.m0()) {
                    if (u.d >= 1) {
                        ux1.k("SwanAppCoreRuntime", "isMasterReady:" + o72.B.k0() + ",isSlaveReady:" + o72.B.n0());
                        nc3 nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(49L);
                        nc3Var.f("retry timeout");
                        u.j(nc3Var);
                        if (im2.a().b()) {
                            ol2.e(o72.getContext(), nc3Var, 0, t03.J().getAppId());
                            e73.m(t03.J().r().V(), 0, nc3Var);
                            bk2.p0().flush(false);
                        }
                        dd3.j(t03.J().x());
                        return;
                    }
                    return;
                }
                ux1.k("SwanAppCoreRuntime", "Retry: successfully.");
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-173430346, "Lcom/repackage/o72$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-173430346, "Lcom/repackage/o72$u;");
                    return;
                }
            }
            a = r.b();
            b = r.a();
            c = 0;
            d = 0;
            f = new a();
            g = new b();
        }

        public static CopyOnWriteArrayList<s> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new CopyOnWriteArrayList<>(o72.B.d) : (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static int h(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) ? bool.booleanValue() ? a : b : invokeL.intValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                d++;
                ux1.k("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + d);
            }
        }

        public static void j(nc3 nc3Var) {
            u03 r;
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65546, null, nc3Var) == null) && (r = t03.J().r()) != null && (l = r.l()) == 0) {
                v73 v73Var = new v73();
                v73Var.p(nc3Var);
                v73Var.r(r.X());
                v73Var.q(n73.n(l));
                v73Var.m(u03.f0());
                n73.R(v73Var);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                d = c;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public static boolean b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-173430315, "Lcom/repackage/o72$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-173430315, "Lcom/repackage/o72$v;");
                    return;
                }
            }
            boolean y = bk2.g0().y();
            a = y;
            b = y;
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB") : (String) invokeV.objValue;
        }

        public static String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 ? "V8" : i == 0 ? WebView.LOGTAG : "AB" : (String) invokeI.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (o72.A) {
                    String a2 = a();
                    char c = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != -1406842887) {
                        if (hashCode != 2081) {
                            if (hashCode == 2722 && a2.equals("V8")) {
                                c = 0;
                            }
                        } else if (a2.equals("AB")) {
                            c = 2;
                        }
                    } else if (a2.equals(WebView.LOGTAG)) {
                        c = 1;
                    }
                    if (c == 0) {
                        return true;
                    }
                    if (c == 1) {
                        return false;
                    }
                }
                return b;
            }
            return invokeV.booleanValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                String a2 = a();
                if (a2.equals("V8")) {
                    return true;
                }
                if (a2.equals("AB")) {
                    return bk2.g0().y();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
                PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
            }
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, null) == null) {
                b = a;
            }
        }

        public static void g(Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, null, intent) == null) && intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                a = intent.getBooleanExtra("bundle_key_v8_ab", a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755486873, "Lcom/repackage/o72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755486873, "Lcom/repackage/o72;");
                return;
            }
        }
        A = eh1.a;
        C = 10150;
        D = false;
        E = PreloadState.UNKNOWN;
        F = false;
        G = u42.h();
        H = -1;
    }

    public o72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.p = new LinkedList<>();
        this.q = new Object();
        this.r = new Object();
        this.s = UUID.randomUUID().toString();
        this.x = false;
        this.z = false;
        km2.e(this);
        this.o = new HashMap<>();
        this.v = bk2.F0();
        this.w = kn1.a().b().a();
        if (G) {
            this.f = new i32();
        }
    }

    public static int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0().statsCode(F) : invokeV.intValue;
    }

    public static PreloadState C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? E : (PreloadState) invokeV.objValue;
    }

    public static synchronized void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            synchronized (o72.class) {
                ux1.k("SwanAppCoreRuntime", "release");
                O0(z, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.repackage.o72 */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void O0(boolean z, boolean z2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (o72.class) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "release");
                }
                if (B == null) {
                    return;
                }
                E = PreloadState.UNKNOWN;
                B.m = true;
                B.u = null;
                D = false;
                if (z2) {
                    u.i();
                    copyOnWriteArrayList = u.g();
                } else {
                    copyOnWriteArrayList = null;
                }
                if (B.c != null) {
                    B.w.a(B.c);
                }
                es1.f();
                aa3.c();
                S0();
                km2.f(B);
                B = null;
                c62.c().d();
                F = z;
                U().A0(null, copyOnWriteArrayList);
            }
        }
    }

    public static synchronized void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (o72.class) {
                ux1.k("SwanAppCoreRuntime", "releaseAndRetry");
                O0(false, true);
            }
        }
    }

    public static synchronized void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            synchronized (o72.class) {
                ux1.k("SwanAppCoreRuntime", "releaseForCoreUpdate");
                if (A) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (B != null && !B.k0()) {
                    if (B.u == null) {
                        B.u = new a();
                    }
                    B.H0(B.u);
                    return;
                }
                t03.J().z().X(15);
                N0(false);
            }
        }
    }

    public static void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            if (G) {
                if (B.f != null) {
                    B.f.reset();
                }
            } else if (B.g != null) {
                if (B.g instanceof u22) {
                    B.g.destroy();
                }
                B.g = null;
            }
        }
    }

    public static void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            if (B.o != null) {
                for (cn1 cn1Var : ((HashMap) B.o.clone()).values()) {
                    if (cn1Var != null) {
                        cn1Var.destroy();
                    }
                }
            }
            R0();
            if (B.i != null) {
                B.i = null;
            }
            if (B.j != null) {
                B.j = null;
            }
        }
    }

    public static o72 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (B == null) {
                synchronized (o72.class) {
                    if (B == null) {
                        B = new o72();
                    }
                }
            }
            return B;
        }
        return (o72) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public final void A0(Intent intent, CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, copyOnWriteArrayList) == null) {
            if (t03.J().r().x0()) {
                ux1.i("SwanAppCoreRuntime", "swan/web, preloadCoreRuntime: " + t03.J().r().N());
                return;
            }
            iu2.c().f();
            nu2.e().f();
            if (m0()) {
                ux1.k("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z = true;
            D = true;
            ux1.k("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            R("event_preload_start");
            if (intent == null) {
                swanCoreVersion = z93.g(0);
                extensionCore = db2.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                bk2.g().g(intent.getIntExtra("bundle_key_preload_switch", C));
                H = intent.getIntExtra("bundle_key_main_pid", H);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                R("event_preload_error");
                ux1.l("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            Y0(swanCoreVersion);
            if (extensionCore == null) {
                ux1.k("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            X0(extensionCore);
            v.f();
            od3.k(new j(this), "prepare ab description");
            if (N()) {
                p63 c2 = n63.c();
                if (!c2.b() && !c2.a()) {
                    R("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                I0();
            } else {
                J0(copyOnWriteArrayList);
            }
            ux1.k("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public q22 D0(boolean z, iz1 iz1Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, iz1Var)) == null) {
            q22 h2 = this.v.h(getContext(), z ? 1 : 0);
            zt2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
            h2.loadUrl(X());
            h2.d(iz1Var);
            return h2;
        }
        return (q22) invokeZL.objValue;
    }

    public final void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.q) {
                boolean f2 = G ? this.f.f() : this.g != null;
                if (!this.h && !f2) {
                    ux1.k("SwanAppCoreRuntime", "prepareMaster start.");
                    zt2.p("preload").F(new UbcFlowEvent("na_pre_load_master_start"));
                    if (G) {
                        this.f.j(z, new c(this));
                        return;
                    }
                    this.g = this.v.h(getContext(), z ? 1 : 0);
                    zt2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
                    this.g.loadUrl(X());
                    this.g.d(new d(this));
                }
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && e72.d() && !l0() && this.j == null) {
            zt2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = K0(getContext(), 1, new f(this));
            i0();
        }
    }

    public void G0(q22 q22Var, rl2 rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, q22Var, rl2Var, gVar) == null) {
            boolean l0 = l0();
            zt2.o().D("preload", l0 ? "1" : "0");
            ux1.k("SwanAppCoreRuntime", "prepareNaSlave preload = " + l0);
            if (l0) {
                f43.i(q22Var, this.j, rl2Var, gVar);
                M0(this.i);
                return;
            }
            g gVar2 = new g(this, q22Var, rl2Var, gVar);
            if (this.j != null) {
                K(gVar2);
                return;
            }
            zt2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = K0(getContext(), 1, gVar2);
            i0();
        }
    }

    public void H0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            if (t03.J().r().x0()) {
                ux1.i("SwanAppCoreRuntime", "swan/web, prepareRuntime: " + t03.J().r().N());
                return;
            }
            iu2.c().f();
            nu2.e().f();
            if (sVar != null && !this.d.contains(sVar)) {
                this.d.add(sVar);
            }
            boolean m0 = m0();
            zt2.o().D("preload", m0 ? "1" : "0");
            ux1.k("SwanAppCoreRuntime", "prepareRuntime preload = " + m0);
            if (m0) {
                u0();
                return;
            }
            E = PreloadState.LOADING;
            zt2.p("preload").F(new UbcFlowEvent("na_pre_load_start"));
            g1();
            boolean N = N();
            this.z = N;
            if (N) {
                p63 c2 = n63.c();
                if (!c2.b() && c2.a()) {
                    this.z = false;
                }
            }
            boolean z = this.z;
            ux1.k("SwanAppCoreRuntime", "mIsUseV8Master:" + this.z);
            if (this.z) {
                E0(true);
            }
            if (this.c == null) {
                this.c = new q(this, z);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
                }
                this.w.b(this.c);
            }
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H0(new k(this));
        }
    }

    public final void J0(CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, copyOnWriteArrayList) == null) {
            if (this.d == null) {
                this.d = new CopyOnWriteArrayList();
            }
            Iterator<s> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!this.d.contains(next)) {
                    this.d.add(next);
                }
            }
            H0(new l(this));
        }
    }

    public void K(@NonNull iz1 iz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iz1Var) == null) {
            this.e.add(iz1Var);
        }
    }

    public an1 K0(Context context, int i2, iz1 iz1Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, context, i2, iz1Var)) == null) {
            long currentTimeMillis = A ? System.currentTimeMillis() : 0L;
            try {
                an1 e2 = this.v.e(context, i2);
                if (i2 == 1) {
                    zt2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_created"));
                } else {
                    zt2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_created"));
                }
                e2.d(iz1Var);
                String b0 = b0();
                if (i2 == 1) {
                    b0 = Z();
                }
                if (b0 != null) {
                    u03 a0 = u03.a0();
                    if (a0 != null && !TextUtils.isEmpty(a0.N())) {
                        String builder = Uri.parse(b0).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, qj2.v(a0.N(), a0.j0(), false, null, null).getAbsolutePath()).toString();
                        if (!builder.endsWith(File.separator)) {
                            builder = builder + File.separator;
                        }
                        b0 = builder;
                    }
                    e2.loadUrl(b0);
                }
                ux1.k("SwanAppCoreRuntime", "prepareSlave loadUrl " + b0);
                if (A) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prepareSlave cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
                return e2;
            } catch (NullPointerException e3) {
                hz1.e(context);
                throw e3;
            }
        }
        return (an1) invokeLIL.objValue;
    }

    public final String L(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            String str2 = z ? "slave" : "master";
            if (!TextUtils.isEmpty(str)) {
                hz1.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.k && this.i == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            zt2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_start"));
            this.i = K0(getContext(), 0, new e(this));
            i0();
        }
    }

    public final void M() {
        x22<w22> x22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (x22Var = this.f) == null || E == PreloadState.LOADED) {
            return;
        }
        x22Var.c(new b(this));
    }

    public final void M0(an1<?> an1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, an1Var) == null) {
            if (an1Var != null) {
                z62.p(an1Var);
            }
            this.i = null;
            this.j = null;
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (ly1.d() || bk2.o().N() || ja2.d.w() || !s0()) {
                return false;
            }
            return v.c() && new File(Y()).exists();
        }
        return invokeV.booleanValue;
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 0 && m0() && this.i != null) {
                return true;
            }
            return i2 == 1 && l0() && this.j != null;
        }
        return invokeI.booleanValue;
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && r.e()) {
            if (!t03.J().r().v0() && !t03.J().r().x0()) {
                boolean z2 = u.e != null && u.e.b();
                if (!z && z2) {
                    if (A) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z + ", return.");
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + z2 + ", return.");
                    }
                } else if (m0()) {
                    if (A) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                    }
                } else {
                    S(new h(this));
                }
            } else if (A) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame or web, return.");
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.p.isEmpty()) {
            return;
        }
        Iterator<ua2> it = this.p.iterator();
        while (it.hasNext()) {
            ua2 next = it.next();
            if (A) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.a);
            }
            U0(next);
        }
        this.p.clear();
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", E.statsCode(F));
            t03.J().w(str, bundle);
        }
    }

    public final void S(nf3<Boolean> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nf3Var) == null) {
            od3.k(new i(this, nf3Var), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    @Nullable
    public ExtensionCore T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.b : (ExtensionCore) invokeV.objValue;
    }

    public final void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            ux1.k("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (u.e == null) {
                t unused = u.e = new t(t03.J().getMainLooper());
            }
            u.e.c();
            u.e.d(i2);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void U0(ua2 ua2Var) {
        sz1 h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ua2Var) == null) {
            if (ua2Var == null) {
                if (A) {
                    throw new IllegalArgumentException("message must be non-null.");
                }
                return;
            }
            synchronized (this.q) {
                if (!this.h) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + ua2Var.a)));
                    }
                    this.p.add(ua2Var);
                    return;
                }
                if (G) {
                    if (!this.f.g()) {
                        this.f.d(ua2Var);
                        return;
                    } else if (this.f.a() == 0) {
                        return;
                    } else {
                        h2 = ((w22) this.f.a()).i().h();
                    }
                } else {
                    q22 q22Var = this.g;
                    if (q22Var == null) {
                        return;
                    }
                    h2 = q22Var.h();
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + ua2Var.a);
                }
                qa2.a(h2, ua2Var);
            }
        }
    }

    @NonNull
    public HashMap<String, cn1> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : (HashMap) invokeV.objValue;
    }

    public void V0(String str, ua2 ua2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, ua2Var) == null) {
            if (a32.a(str)) {
                U0(ua2Var);
            } else if (k22.a(str)) {
                qa2.a(fy1.k().l(), ua2Var);
            } else {
                cn1 cn1Var = this.o.get(str);
                if (cn1Var == null) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + ua2Var);
                        return;
                    }
                    return;
                }
                qa2.a(cn1Var.u(), ua2Var);
            }
        }
    }

    public q22 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (G) {
                if (this.f.g()) {
                    return ((w22) this.f.a()).i();
                }
                return null;
            }
            return this.g;
        }
        return (q22) invokeV.objValue;
    }

    public void W0(@NonNull u03 u03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, u03Var) == null) {
            oe3.e0(new p(this, u03Var));
        }
    }

    public String X() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            g1();
            if (r0()) {
                str = Y();
            } else {
                str = this.a.swanCorePath + File.separator + "master/master.html";
            }
            if (hz1.d()) {
                L(str, false);
            } else if (ly1.d()) {
                ky1.k();
                ky1.g().h("loadmaster");
                return ly1.a();
            } else {
                hz1.g(str);
            }
            return me3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void X0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.b);
                }
                this.b = extensionCore;
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.b);
                }
            } else if (A) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore extensionCore is invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                Log.w("SwanAppCoreRuntime", sb.toString());
            }
        }
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (TextUtils.isEmpty(c0())) {
                return "";
            }
            return c0() + "runtime/index.js";
        }
        return (String) invokeV.objValue;
    }

    public void Y0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, swanCoreVersion) == null) {
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.a);
                }
                this.a = swanCoreVersion;
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.a);
                }
            } else if (A) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
                Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
            }
        }
    }

    @Nullable
    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            g1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slave-talos/index.js";
            if (hz1.d()) {
                L(str, true);
            } else if (ly1.d()) {
                return ly1.b();
            } else {
                hz1.g(str);
            }
            return me3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void Z0(rl2 rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, rl2Var, gVar) == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.a);
                Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + rl2Var.j0());
            }
            d1(rl2Var);
            c1(rl2Var);
            zt2.o().F(new UbcFlowEvent("na_pre_load_check"));
            u63.d().i("na_pre_load_check");
            H0(new m(this, rl2Var, gVar));
        }
    }

    @Override // com.repackage.jm2
    public void a(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cn1Var) == null) {
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            oe3.e0(new o(this));
        }
    }

    @Override // com.repackage.jm2
    public void b(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, cn1Var) == null) {
            String c2 = cn1Var.c();
            this.o.remove(c2);
            if (cn1Var instanceof an1) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
                U0(new wa2(hashMap));
                ux1.i("SwanApp", "onUnload");
            }
            c03.a();
        }
    }

    @Nullable
    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            g1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slaves/slaves.html";
            if (hz1.d()) {
                L(str, true);
            } else if (ly1.d()) {
                return ly1.b();
            } else {
                hz1.g(str);
            }
            return me3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            oe3.e0(new n(this, str));
        }
    }

    @Override // com.repackage.jm2
    public void c(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, cn1Var) == null) {
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.a == null) {
                return "";
            }
            return this.a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public void c1(rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, rl2Var) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null) {
                rl2Var.C0(extensionCore);
            } else {
                this.b = rl2Var.O();
            }
        }
    }

    @Override // com.repackage.jm2
    public void d(cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, cn1Var) == null) {
            this.o.put(cn1Var.c(), cn1Var);
        }
    }

    public SwanCoreVersion d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.a : (SwanCoreVersion) invokeV.objValue;
    }

    public void d1(rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, rl2Var) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null) {
                rl2Var.Z0(swanCoreVersion);
            } else {
                this.a = rl2Var.j0();
            }
        }
    }

    public cn1 e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (this.o.isEmpty() || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.o.get(str);
        }
        return (cn1) invokeL.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.x) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                    return;
                }
                return;
            }
            boolean z = true;
            this.x = true;
            t03 J = t03.J();
            z = (J == null || !J.D()) ? false : false;
            boolean w = bk2.g0().w();
            if (!z && w) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
                }
                z62.n(getContext());
            } else if (A) {
                Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + w);
            }
        }
    }

    public vm1 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.v : (vm1) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                ux1.k("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                X0(db2.c(0));
            }
        }
    }

    @Nullable
    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            i0();
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                ux1.k("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.a)));
                Y0(z93.g(0));
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            synchronized (this.q) {
                this.h = false;
                if (G) {
                    this.f.reset();
                } else {
                    this.g = null;
                }
            }
            this.k = false;
            this.l = false;
            this.i = null;
            this.j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swanjs version", ea3.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", r0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = z93.g(0);
                jSONObject.put("swan app core", g2 == null ? StringUtil.NULL_STRING : Long.valueOf(g2.swanCoreVersionCode));
                SwanCoreVersion g3 = z93.g(1);
                jSONObject.put("swan game core", g3 == null ? StringUtil.NULL_STRING : Long.valueOf(g3.swanCoreVersionCode));
            } catch (JSONException e2) {
                if (A) {
                    e2.printStackTrace();
                }
            }
            c73.b bVar = new c73.b(10001);
            bVar.h(u03.L() == null ? "null appKey" : u03.L().N());
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.n = z;
        }
    }

    public final void i0() {
        an1<?> an1Var;
        an1<?> an1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (TextUtils.isEmpty(this.t) && (an1Var2 = this.i) != null) {
                this.t = an1Var2.a();
            }
            if (TextUtils.isEmpty(this.t) && (an1Var = this.j) != null) {
                this.t = an1Var.a();
            }
            if (TextUtils.isEmpty(this.t)) {
                return;
            }
            ux1.k("SwanAppCoreRuntime", "initWebViewUa ua: " + this.t);
        }
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            synchronized (this.q) {
                z = this.h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            synchronized (this.r) {
                z = this.l;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            synchronized (this.q) {
                z = this.h && this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            synchronized (this.q) {
                z = this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            long currentTimeMillis = A ? System.currentTimeMillis() : 0L;
            SwanCoreVersion swanCoreVersion = this.a;
            boolean z = swanCoreVersion != null && swanCoreVersion.isAvailable();
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
                z &= extensionCore.isAvailable();
            }
            if (A) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "isSwanAvailable cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (G) {
                return this.f.i();
            }
            return this.g instanceof u22;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (bk2.w0().d() || n63.a() == null) {
                return true;
            }
            boolean exists = new File(n63.a()).exists();
            if (A) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            return exists;
        }
        return invokeV.booleanValue;
    }

    public final void t0(o72 o72Var, rl2 rl2Var, qj2.g gVar) {
        q22 q22Var;
        an1<?> an1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, o72Var, rl2Var, gVar) == null) {
            if (G) {
                x22<w22> x22Var = o72Var.f;
                q22Var = x22Var.h() ? ((w22) x22Var.e(rl2Var.f0())).i() : null;
            } else {
                q22Var = o72Var.g;
            }
            if (q22Var != null) {
                String d2 = f43.d(hm2.U(), rl2Var, gVar.b);
                int c2 = e72.c(d2);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "launchFirstPage: " + d2 + " salveType:" + c2);
                }
                if ((c2 == 0 || !e72.d()) && (an1Var = o72Var.i) != null) {
                    f43.i(q22Var, an1Var, rl2Var, gVar);
                    M0(o72Var.j);
                } else if (c2 == 1) {
                    G0(q22Var, rl2Var, gVar);
                }
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage mMasterManager=" + o72Var.g + " mSlaveManager=" + o72Var.i + " mNASlaveManager=" + o72Var.j);
            }
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || this.d.isEmpty()) {
            return;
        }
        M();
        E = PreloadState.LOADED;
        u.k();
        R("event_preload_finish");
        zt2.p("preload").F(new UbcFlowEvent("na_pre_load_end"));
        j32.i().q();
        for (s sVar : this.d) {
            if (sVar != null) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "onReady result: " + sVar.toString());
                }
                sVar.onCallback(this);
            }
        }
        this.d.clear();
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && !this.d.isEmpty() && m0()) {
            u0();
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            boolean f2 = G ? this.f.f() : this.g != null;
            if (z && !this.h && f2) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
                }
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.q) {
                    this.h = true;
                    Q();
                    v0();
                }
            } else if (z || this.i == null || this.k) {
            } else {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
                }
                zt2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.k = true;
                v0();
            }
        }
    }

    public void x0(String str, PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048644, this, str, prefetchEvent, pMSAppInfo) == null) && G) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (m0() && o0()) {
                    an1<?> an1Var = this.i;
                    if (an1Var != null) {
                        prefetchEvent.isT7Available = an1Var.M();
                    } else {
                        prefetchEvent.isT7Available = p0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    x52 d2 = x52.d();
                    y52.b a2 = y52.a();
                    a2.h(RecordType.PREFETCH_EVENT);
                    a2.f(createMessage.a);
                    d2.f(str, a2.e());
                    String str2 = prefetchEvent.pageUrl;
                    Map<String, String> t2 = createMessage.t();
                    String str3 = t2 != null ? t2.get("pageRoutePath") : null;
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    if (!qj2.C(prefetchEvent.appPath, str2)) {
                        if (A) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str2 + " not exit");
                        }
                        ux1.k("SwanAppCoreRuntime", "page path not exist - " + str2);
                        return;
                    }
                    if (createMessage.u()) {
                        tx1.d();
                        ux1.i(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f.b(str, createMessage, pMSAppInfo);
                    y0(str, prefetchEvent);
                    if (A) {
                        String str4 = this.a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str4);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                    if (e72.e() || e72.g()) {
                        if (TextUtils.isEmpty(hm2.U().z()) && !e72.h(u03.a0())) {
                            if (A) {
                                Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                                return;
                            }
                            return;
                        } else if (e72.c(str2) == 1) {
                            F0();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                ux1.k("SwanAppCoreRuntime", "Runtime is not ready or swanJs is not available");
            } else if (A) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }

    public final void y0(String str, PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048645, this, str, prefetchEvent) == null) && u42.o()) {
            an1<?> an1Var = this.i;
            if (an1Var != null && n0()) {
                ux1.i(PrefetchEvent.MODULE, "start prefetch slave");
                long j2 = 0;
                if (A) {
                    j2 = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave start");
                }
                u03 r2 = t03.J().r();
                if (r2 == null) {
                    return;
                }
                t52 a2 = t52.a(an1Var, prefetchEvent, r2);
                if (oe3.S(an1Var, a2.k)) {
                    V0(an1Var.c(), a2.b());
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "prefetch slave end");
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
                }
                ux1.i(PrefetchEvent.MODULE, "prefetch slave finish");
            } else if (A) {
                Log.d("SwanAppCoreRuntime", "slave is not ready can not prefetch");
            }
        }
    }

    public void z0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, intent) == null) {
            A0(intent, null);
        }
    }
}
