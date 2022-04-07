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
import com.repackage.fj2;
import com.repackage.n52;
import com.repackage.q52;
import com.repackage.r63;
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
/* loaded from: classes5.dex */
public final class d72 implements yl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public static volatile d72 B;
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
    public lz1 c;
    public List<s> d;
    public final List<xy1> e;
    public m22<l22> f;
    public f22 g;
    public boolean h;
    public pm1<?> i;
    public pm1<?> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final HashMap<String, rm1> o;
    public LinkedList<ja2> p;
    public final Object q;
    public final Object r;
    public final String s;
    public String t;
    public s u;
    public km1 v;
    public vm1 w;
    public volatile boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public static class a extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.d72$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0399a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0399a(a aVar) {
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
                    d72.N0(false);
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

        @Override // com.repackage.d72.s
        public void b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d72Var) == null) {
                boolean z = !TextUtils.isEmpty(i03.J().getAppId());
                jx1.k("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (z) {
                    return;
                }
                i03.J().z().X(15);
                de3.e0(new RunnableC0399a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements o22<l22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o22
        /* renamed from: b */
        public void a(boolean z, l22 l22Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, l22Var) == null) {
                this.a.y = z;
                if (z) {
                    ot2.p(NodeJS.STARTUP_SCRIPT_NAME).D("prefetch_env", "1");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements u22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public c(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.repackage.u22
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends xy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public d(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.repackage.xy1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jx1.k("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends xy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public e(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.repackage.xy1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jx1.k("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.a.k = true;
                this.a.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends xy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public f(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.repackage.xy1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this.a.r) {
                    this.a.l = true;
                }
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
                for (xy1 xy1Var : this.a.e) {
                    xy1Var.a(str);
                }
                this.a.e.clear();
                jx1.k("SwanAppCoreRuntime", "prepareNaSlave finished");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends xy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f22 a;
        public final /* synthetic */ gl2 b;
        public final /* synthetic */ fj2.g c;
        public final /* synthetic */ d72 d;

        /* loaded from: classes5.dex */
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
                    f22 f22Var = gVar.a;
                    pm1 pm1Var = gVar.d.j;
                    g gVar2 = this.a;
                    u33.i(f22Var, pm1Var, gVar2.b, gVar2.c);
                    d72 d72Var = this.a.d;
                    d72Var.M0(d72Var.i);
                }
            }
        }

        public g(d72 d72Var, f22 f22Var, gl2 gl2Var, fj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, f22Var, gl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = d72Var;
            this.a = f22Var;
            this.b = gl2Var;
            this.c = gVar;
        }

        @Override // com.repackage.xy1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this.d.r) {
                    this.d.l = true;
                }
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
                jx1.k("SwanAppCoreRuntime", "prepareNaSlave finished");
                de3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements cf3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public h(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.T0(u.h(bool));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf3 a;

        public i(d72 d72Var, cf3 cf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, cf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a = qj2.u0().a();
                if (d72.A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a);
                }
                cf3 cf3Var = this.a;
                if (cf3Var != null) {
                    cf3Var.onCallback(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
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
                wc3.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d72 a;

            public a(k kVar, d72 d72Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, d72Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = d72Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.e1();
                }
            }
        }

        public k(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.repackage.d72.s
        public void b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d72Var) == null) {
                if (d72.A) {
                    if4.b().e();
                    b03 f = b03.f(d72.getContext(), R.string.obfuscated_res_0x7f0f01a3);
                    f.l(1);
                    f.G();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                de3.a0(new a(this, d72Var));
                if (d72.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                ex2.P().X(14);
                if (t62.f() || t62.g()) {
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

    /* loaded from: classes5.dex */
    public class l extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public l(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.repackage.d72.s
        public void b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d72Var) == null) {
                if (t62.f() || t62.g()) {
                    this.a.F0();
                }
                if (d72.A) {
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

    /* loaded from: classes5.dex */
    public class m extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ fj2.g b;
        public final /* synthetic */ d72 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d72 a;
            public final /* synthetic */ m b;

            public a(m mVar, d72 d72Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, d72Var};
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
                this.a = d72Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m) {
                    return;
                }
                ot2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_pre_load_ok"));
                j63.d().i("na_pre_load_ok");
                ot2.h("preload", NodeJS.STARTUP_SCRIPT_NAME);
                m mVar = this.b;
                mVar.c.t0(this.a, mVar.a, mVar.b);
                ot2.j(this.b.a, false);
            }
        }

        public m(d72 d72Var, gl2 gl2Var, fj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, gl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d72Var;
            this.a = gl2Var;
            this.b = gVar;
        }

        @Override // com.repackage.d72.s
        public void b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d72Var) == null) {
                de3.e0(new a(this, d72Var));
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

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public n(d72 d72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, str};
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
                u33.k(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
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
                u33.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j03 a;
        public final /* synthetic */ d72 b;

        public p(d72 d72Var, j03 j03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, j03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d72Var;
            this.a = j03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (t62.d() && TextUtils.isEmpty(wl2.U().z()) && !t62.h(this.a)) {
                    if (d72.A) {
                        Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                        return;
                    }
                    return;
                }
                String d = u33.d(wl2.U(), this.a.X(), this.a.P());
                int c = t62.c(d);
                if (!this.b.O(c)) {
                    y62.c(11);
                    return;
                }
                pm1 pm1Var = null;
                if (q52.a.b()) {
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
                        y62.c(i);
                    }
                }
                if (c != 0 || this.b.i == null) {
                    if (c == 1 && this.b.j != null) {
                        pm1Var = this.b.j;
                    }
                } else {
                    pm1Var = this.b.i;
                }
                pm1 pm1Var2 = pm1Var;
                if (pm1Var2 == null) {
                    return;
                }
                if (equals && this.a.P() != null) {
                    r52.c().b(d72.G ? ((l22) this.b.f.e(this.a.V().f0())).i() : this.b.g, pm1Var2, this.a.X(), this.a.P(), null, true);
                } else if (this.a.P() == null) {
                    y62.c(15);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements lz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ d72 b;

        /* loaded from: classes5.dex */
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
                    if (d72.A) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.a.b.m);
                    }
                    if (this.a.b.m) {
                        if (d72.A) {
                            Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                            return;
                        }
                        return;
                    }
                    this.a.b.g1();
                    this.a.b.f1();
                    if (this.a.b.a == null) {
                        PreloadState unused = d72.E = PreloadState.LOAD_FAILED;
                        this.a.b.h0();
                        return;
                    }
                    q qVar = this.a;
                    qVar.b.E0(qVar.a);
                    this.a.b.L0();
                }
            }
        }

        public q(d72 d72Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d72Var;
            this.a = z;
        }

        @Override // com.repackage.lz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d72.A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                }
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                de3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-488351100, "Lcom/repackage/d72$r;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-488351100, "Lcom/repackage/d72$r;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                qj2.g0().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (d72.A) {
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
                qj2.g0().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (d72.A) {
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
                    qj2.g0().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
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
                qj2.g0().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (d72.A) {
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
                jx1.k("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class s implements cf3<d72> {
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
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d72Var) == null) {
                b(d72Var);
            }
        }

        public abstract void b(d72 d72Var);
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || i03.J().r().x0()) {
                    return;
                }
                if (!d72.B.m0()) {
                    boolean z = true;
                    if (u.d < 1) {
                        if (!((u.e == null || !u.e.a()) ? false : false)) {
                            if (u.e == null) {
                                t unused = u.e = new t(i03.J().getMainLooper());
                            }
                            u.e.e(r.d());
                        }
                        jx1.k("SwanAppCoreRuntime", "start retry runtime.");
                        d72.P0();
                        cc3 cc3Var = new cc3();
                        cc3Var.k(5L);
                        cc3Var.i(49L);
                        cc3Var.f("start retry");
                        u.j(cc3Var);
                        return;
                    }
                    jx1.k("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                jx1.k("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
            }
        }

        /* loaded from: classes5.dex */
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || i03.J().r().x0()) {
                    return;
                }
                if (!d72.B.m0()) {
                    if (u.d >= 1) {
                        jx1.k("SwanAppCoreRuntime", "isMasterReady:" + d72.B.k0() + ",isSlaveReady:" + d72.B.n0());
                        cc3 cc3Var = new cc3();
                        cc3Var.k(5L);
                        cc3Var.i(49L);
                        cc3Var.f("retry timeout");
                        u.j(cc3Var);
                        if (xl2.a().b()) {
                            dl2.e(d72.getContext(), cc3Var, 0, i03.J().getAppId());
                            t63.m(i03.J().r().V(), 0, cc3Var);
                            qj2.p0().flush(false);
                        }
                        sc3.j(i03.J().x());
                        return;
                    }
                    return;
                }
                jx1.k("SwanAppCoreRuntime", "Retry: successfully.");
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-488351007, "Lcom/repackage/d72$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-488351007, "Lcom/repackage/d72$u;");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new CopyOnWriteArrayList<>(d72.B.d) : (CopyOnWriteArrayList) invokeV.objValue;
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
                jx1.k("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + d);
            }
        }

        public static void j(cc3 cc3Var) {
            j03 r;
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65546, null, cc3Var) == null) && (r = i03.J().r()) != null && (l = r.l()) == 0) {
                k73 k73Var = new k73();
                k73Var.p(cc3Var);
                k73Var.r(r.X());
                k73Var.q(c73.n(l));
                k73Var.m(j03.f0());
                c73.R(k73Var);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                d = c;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public static boolean b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-488350976, "Lcom/repackage/d72$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-488350976, "Lcom/repackage/d72$v;");
                    return;
                }
            }
            boolean y = qj2.g0().y();
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
                if (d72.A) {
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
                    return qj2.g0().y();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755814574, "Lcom/repackage/d72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755814574, "Lcom/repackage/d72;");
                return;
            }
        }
        A = tg1.a;
        C = 10150;
        D = false;
        E = PreloadState.UNKNOWN;
        F = false;
        G = j42.h();
        H = -1;
    }

    public d72() {
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
        zl2.e(this);
        this.o = new HashMap<>();
        this.v = qj2.F0();
        this.w = zm1.a().b().a();
        if (G) {
            this.f = new x22();
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
            synchronized (d72.class) {
                jx1.k("SwanAppCoreRuntime", "release");
                O0(z, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.repackage.d72 */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void O0(boolean z, boolean z2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (d72.class) {
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
                tr1.f();
                p93.c();
                S0();
                zl2.f(B);
                B = null;
                r52.c().d();
                F = z;
                U().A0(null, copyOnWriteArrayList);
            }
        }
    }

    public static synchronized void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (d72.class) {
                jx1.k("SwanAppCoreRuntime", "releaseAndRetry");
                O0(false, true);
            }
        }
    }

    public static synchronized void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            synchronized (d72.class) {
                jx1.k("SwanAppCoreRuntime", "releaseForCoreUpdate");
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
                i03.J().z().X(15);
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
                if (B.g instanceof j22) {
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
                for (rm1 rm1Var : ((HashMap) B.o.clone()).values()) {
                    if (rm1Var != null) {
                        rm1Var.destroy();
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

    public static d72 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (B == null) {
                synchronized (d72.class) {
                    if (B == null) {
                        B = new d72();
                    }
                }
            }
            return B;
        }
        return (d72) invokeV.objValue;
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
            if (i03.J().r().x0()) {
                jx1.i("SwanAppCoreRuntime", "swan/web, preloadCoreRuntime: " + i03.J().r().N());
                return;
            }
            xt2.c().f();
            cu2.e().f();
            if (m0()) {
                jx1.k("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z = true;
            D = true;
            jx1.k("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            R("event_preload_start");
            if (intent == null) {
                swanCoreVersion = o93.g(0);
                extensionCore = sa2.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                qj2.g().g(intent.getIntExtra("bundle_key_preload_switch", C));
                H = intent.getIntExtra("bundle_key_main_pid", H);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                R("event_preload_error");
                jx1.l("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            Y0(swanCoreVersion);
            if (extensionCore == null) {
                jx1.k("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            X0(extensionCore);
            v.f();
            dd3.k(new j(this), "prepare ab description");
            if (N()) {
                e63 c2 = c63.c();
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
            jx1.k("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public f22 D0(boolean z, xy1 xy1Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, xy1Var)) == null) {
            f22 h2 = this.v.h(getContext(), z ? 1 : 0);
            ot2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
            h2.loadUrl(X());
            h2.d(xy1Var);
            return h2;
        }
        return (f22) invokeZL.objValue;
    }

    public final void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.q) {
                boolean f2 = G ? this.f.f() : this.g != null;
                if (!this.h && !f2) {
                    jx1.k("SwanAppCoreRuntime", "prepareMaster start.");
                    ot2.p("preload").F(new UbcFlowEvent("na_pre_load_master_start"));
                    if (G) {
                        this.f.j(z, new c(this));
                        return;
                    }
                    this.g = this.v.h(getContext(), z ? 1 : 0);
                    ot2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
                    this.g.loadUrl(X());
                    this.g.d(new d(this));
                }
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && t62.d() && !l0() && this.j == null) {
            ot2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = K0(getContext(), 1, new f(this));
            i0();
        }
    }

    public void G0(f22 f22Var, gl2 gl2Var, fj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, f22Var, gl2Var, gVar) == null) {
            boolean l0 = l0();
            ot2.o().D("preload", l0 ? "1" : "0");
            jx1.k("SwanAppCoreRuntime", "prepareNaSlave preload = " + l0);
            if (l0) {
                u33.i(f22Var, this.j, gl2Var, gVar);
                M0(this.i);
                return;
            }
            g gVar2 = new g(this, f22Var, gl2Var, gVar);
            if (this.j != null) {
                K(gVar2);
                return;
            }
            ot2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = K0(getContext(), 1, gVar2);
            i0();
        }
    }

    public void H0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            if (i03.J().r().x0()) {
                jx1.i("SwanAppCoreRuntime", "swan/web, prepareRuntime: " + i03.J().r().N());
                return;
            }
            xt2.c().f();
            cu2.e().f();
            if (sVar != null && !this.d.contains(sVar)) {
                this.d.add(sVar);
            }
            boolean m0 = m0();
            ot2.o().D("preload", m0 ? "1" : "0");
            jx1.k("SwanAppCoreRuntime", "prepareRuntime preload = " + m0);
            if (m0) {
                u0();
                return;
            }
            E = PreloadState.LOADING;
            ot2.p("preload").F(new UbcFlowEvent("na_pre_load_start"));
            g1();
            boolean N = N();
            this.z = N;
            if (N) {
                e63 c2 = c63.c();
                if (!c2.b() && c2.a()) {
                    this.z = false;
                }
            }
            boolean z = this.z;
            jx1.k("SwanAppCoreRuntime", "mIsUseV8Master:" + this.z);
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

    public void K(@NonNull xy1 xy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xy1Var) == null) {
            this.e.add(xy1Var);
        }
    }

    public pm1 K0(Context context, int i2, xy1 xy1Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, context, i2, xy1Var)) == null) {
            long currentTimeMillis = A ? System.currentTimeMillis() : 0L;
            try {
                pm1 e2 = this.v.e(context, i2);
                if (i2 == 1) {
                    ot2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_created"));
                } else {
                    ot2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_created"));
                }
                e2.d(xy1Var);
                String b0 = b0();
                if (i2 == 1) {
                    b0 = Z();
                }
                if (b0 != null) {
                    j03 a0 = j03.a0();
                    if (a0 != null && !TextUtils.isEmpty(a0.N())) {
                        String builder = Uri.parse(b0).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, fj2.v(a0.N(), a0.j0(), false, null, null).getAbsolutePath()).toString();
                        if (!builder.endsWith(File.separator)) {
                            builder = builder + File.separator;
                        }
                        b0 = builder;
                    }
                    e2.loadUrl(b0);
                }
                jx1.k("SwanAppCoreRuntime", "prepareSlave loadUrl " + b0);
                if (A) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prepareSlave cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
                return e2;
            } catch (NullPointerException e3) {
                wy1.e(context);
                throw e3;
            }
        }
        return (pm1) invokeLIL.objValue;
    }

    public final String L(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            String str2 = z ? "slave" : "master";
            if (!TextUtils.isEmpty(str)) {
                wy1.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
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
            ot2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_start"));
            this.i = K0(getContext(), 0, new e(this));
            i0();
        }
    }

    public final void M() {
        m22<l22> m22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (m22Var = this.f) == null || E == PreloadState.LOADED) {
            return;
        }
        m22Var.c(new b(this));
    }

    public final void M0(pm1<?> pm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pm1Var) == null) {
            if (pm1Var != null) {
                o62.p(pm1Var);
            }
            this.i = null;
            this.j = null;
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (ay1.d() || qj2.o().N() || y92.d.w() || !s0()) {
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
            if (!i03.J().r().v0() && !i03.J().r().x0()) {
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
        Iterator<ja2> it = this.p.iterator();
        while (it.hasNext()) {
            ja2 next = it.next();
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
            i03.J().w(str, bundle);
        }
    }

    public final void S(cf3<Boolean> cf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cf3Var) == null) {
            dd3.k(new i(this, cf3Var), "SWAN_DEVICE_PERFORMANCE_CHECK");
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
            jx1.k("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (u.e == null) {
                t unused = u.e = new t(i03.J().getMainLooper());
            }
            u.e.c();
            u.e.d(i2);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void U0(ja2 ja2Var) {
        hz1 h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ja2Var) == null) {
            if (ja2Var == null) {
                if (A) {
                    throw new IllegalArgumentException("message must be non-null.");
                }
                return;
            }
            synchronized (this.q) {
                if (!this.h) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + ja2Var.a)));
                    }
                    this.p.add(ja2Var);
                    return;
                }
                if (G) {
                    if (!this.f.g()) {
                        this.f.d(ja2Var);
                        return;
                    } else if (this.f.a() == 0) {
                        return;
                    } else {
                        h2 = ((l22) this.f.a()).i().h();
                    }
                } else {
                    f22 f22Var = this.g;
                    if (f22Var == null) {
                        return;
                    }
                    h2 = f22Var.h();
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + ja2Var.a);
                }
                fa2.a(h2, ja2Var);
            }
        }
    }

    @NonNull
    public HashMap<String, rm1> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : (HashMap) invokeV.objValue;
    }

    public void V0(String str, ja2 ja2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, ja2Var) == null) {
            if (p22.a(str)) {
                U0(ja2Var);
            } else if (z12.a(str)) {
                fa2.a(ux1.k().l(), ja2Var);
            } else {
                rm1 rm1Var = this.o.get(str);
                if (rm1Var == null) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + ja2Var);
                        return;
                    }
                    return;
                }
                fa2.a(rm1Var.u(), ja2Var);
            }
        }
    }

    public f22 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (G) {
                if (this.f.g()) {
                    return ((l22) this.f.a()).i();
                }
                return null;
            }
            return this.g;
        }
        return (f22) invokeV.objValue;
    }

    public void W0(@NonNull j03 j03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, j03Var) == null) {
            de3.e0(new p(this, j03Var));
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
            if (wy1.d()) {
                L(str, false);
            } else if (ay1.d()) {
                zx1.k();
                zx1.g().h("loadmaster");
                return ay1.a();
            } else {
                wy1.g(str);
            }
            return be3.w(str);
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
            if (wy1.d()) {
                L(str, true);
            } else if (ay1.d()) {
                return ay1.b();
            } else {
                wy1.g(str);
            }
            return be3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void Z0(gl2 gl2Var, fj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, gl2Var, gVar) == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.a);
                Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + gl2Var.j0());
            }
            d1(gl2Var);
            c1(gl2Var);
            ot2.o().F(new UbcFlowEvent("na_pre_load_check"));
            j63.d().i("na_pre_load_check");
            H0(new m(this, gl2Var, gVar));
        }
    }

    @Override // com.repackage.yl2
    public void a(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, rm1Var) == null) {
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
            de3.e0(new o(this));
        }
    }

    @Override // com.repackage.yl2
    public void b(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, rm1Var) == null) {
            String c2 = rm1Var.c();
            this.o.remove(c2);
            if (rm1Var instanceof pm1) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
                U0(new la2(hashMap));
                jx1.i("SwanApp", "onUnload");
            }
            rz2.a();
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
            if (wy1.d()) {
                L(str, true);
            } else if (ay1.d()) {
                return ay1.b();
            } else {
                wy1.g(str);
            }
            return be3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            de3.e0(new n(this, str));
        }
    }

    @Override // com.repackage.yl2
    public void c(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, rm1Var) == null) {
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

    public void c1(gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, gl2Var) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null) {
                gl2Var.C0(extensionCore);
            } else {
                this.b = gl2Var.O();
            }
        }
    }

    @Override // com.repackage.yl2
    public void d(rm1 rm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, rm1Var) == null) {
            this.o.put(rm1Var.c(), rm1Var);
        }
    }

    public SwanCoreVersion d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.a : (SwanCoreVersion) invokeV.objValue;
    }

    public void d1(gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, gl2Var) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null) {
                gl2Var.Z0(swanCoreVersion);
            } else {
                this.a = gl2Var.j0();
            }
        }
    }

    public rm1 e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (this.o.isEmpty() || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.o.get(str);
        }
        return (rm1) invokeL.objValue;
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
            i03 J = i03.J();
            z = (J == null || !J.D()) ? false : false;
            boolean w = qj2.g0().w();
            if (!z && w) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
                }
                o62.n(getContext());
            } else if (A) {
                Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + w);
            }
        }
    }

    public km1 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.v : (km1) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                jx1.k("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                X0(sa2.c(0));
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
                jx1.k("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.a)));
                Y0(o93.g(0));
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
                jSONObject.put("swanjs version", t93.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", r0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = o93.g(0);
                jSONObject.put("swan app core", g2 == null ? StringUtil.NULL_STRING : Long.valueOf(g2.swanCoreVersionCode));
                SwanCoreVersion g3 = o93.g(1);
                jSONObject.put("swan game core", g3 == null ? StringUtil.NULL_STRING : Long.valueOf(g3.swanCoreVersionCode));
            } catch (JSONException e2) {
                if (A) {
                    e2.printStackTrace();
                }
            }
            r63.b bVar = new r63.b(10001);
            bVar.h(j03.L() == null ? "null appKey" : j03.L().N());
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
        pm1<?> pm1Var;
        pm1<?> pm1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (TextUtils.isEmpty(this.t) && (pm1Var2 = this.i) != null) {
                this.t = pm1Var2.a();
            }
            if (TextUtils.isEmpty(this.t) && (pm1Var = this.j) != null) {
                this.t = pm1Var.a();
            }
            if (TextUtils.isEmpty(this.t)) {
                return;
            }
            jx1.k("SwanAppCoreRuntime", "initWebViewUa ua: " + this.t);
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
            return this.g instanceof j22;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (qj2.w0().d() || c63.a() == null) {
                return true;
            }
            boolean exists = new File(c63.a()).exists();
            if (A) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            return exists;
        }
        return invokeV.booleanValue;
    }

    public final void t0(d72 d72Var, gl2 gl2Var, fj2.g gVar) {
        f22 f22Var;
        pm1<?> pm1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, d72Var, gl2Var, gVar) == null) {
            if (G) {
                m22<l22> m22Var = d72Var.f;
                f22Var = m22Var.h() ? ((l22) m22Var.e(gl2Var.f0())).i() : null;
            } else {
                f22Var = d72Var.g;
            }
            if (f22Var != null) {
                String d2 = u33.d(wl2.U(), gl2Var, gVar.b);
                int c2 = t62.c(d2);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "launchFirstPage: " + d2 + " salveType:" + c2);
                }
                if ((c2 == 0 || !t62.d()) && (pm1Var = d72Var.i) != null) {
                    u33.i(f22Var, pm1Var, gl2Var, gVar);
                    M0(d72Var.j);
                } else if (c2 == 1) {
                    G0(f22Var, gl2Var, gVar);
                }
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage mMasterManager=" + d72Var.g + " mSlaveManager=" + d72Var.i + " mNASlaveManager=" + d72Var.j);
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
        ot2.p("preload").F(new UbcFlowEvent("na_pre_load_end"));
        y22.i().q();
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
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_master_js_ok"));
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
                ot2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_js_ok"));
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
                    pm1<?> pm1Var = this.i;
                    if (pm1Var != null) {
                        prefetchEvent.isT7Available = pm1Var.M();
                    } else {
                        prefetchEvent.isT7Available = p0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    m52 d2 = m52.d();
                    n52.b a2 = n52.a();
                    a2.h(RecordType.PREFETCH_EVENT);
                    a2.f(createMessage.a);
                    d2.f(str, a2.e());
                    String str2 = prefetchEvent.pageUrl;
                    Map<String, String> t2 = createMessage.t();
                    String str3 = t2 != null ? t2.get("pageRoutePath") : null;
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    if (!fj2.C(prefetchEvent.appPath, str2)) {
                        if (A) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str2 + " not exit");
                        }
                        jx1.k("SwanAppCoreRuntime", "page path not exist - " + str2);
                        return;
                    }
                    if (createMessage.u()) {
                        ix1.d();
                        jx1.i(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f.b(str, createMessage, pMSAppInfo);
                    y0(str, prefetchEvent);
                    if (A) {
                        String str4 = this.a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str4);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                    if (t62.e() || t62.g()) {
                        if (TextUtils.isEmpty(wl2.U().z()) && !t62.h(j03.a0())) {
                            if (A) {
                                Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                                return;
                            }
                            return;
                        } else if (t62.c(str2) == 1) {
                            F0();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                jx1.k("SwanAppCoreRuntime", "Runtime is not ready or swanJs is not available");
            } else if (A) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }

    public final void y0(String str, PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048645, this, str, prefetchEvent) == null) && j42.o()) {
            pm1<?> pm1Var = this.i;
            if (pm1Var != null && n0()) {
                jx1.i(PrefetchEvent.MODULE, "start prefetch slave");
                long j2 = 0;
                if (A) {
                    j2 = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave start");
                }
                j03 r2 = i03.J().r();
                if (r2 == null) {
                    return;
                }
                i52 a2 = i52.a(pm1Var, prefetchEvent, r2);
                if (de3.S(pm1Var, a2.k)) {
                    V0(pm1Var.c(), a2.b());
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "prefetch slave end");
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
                }
                jx1.i(PrefetchEvent.MODULE, "prefetch slave finish");
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
