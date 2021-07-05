package d.a.q0.a.e2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.e2.c.j.f;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.j2.k;
import d.a.q0.a.u.e.a.c;
import d.a.q0.a.v2.q0;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.a2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47496g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.k2.g.g f47497a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47498b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47499c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f47500d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.q0.a.e2.c.j.b> f47501e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.q0.a.v2.d1.c f47502f;

    /* renamed from: d.a.q0.a.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0729a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f47503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47504f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f47505g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47506h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f47507i;

        /* renamed from: d.a.q0.a.e2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0730a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0729a f47508e;

            public C0730a(C0729a c0729a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0729a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47508e = c0729a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0729a c0729a = this.f47508e;
                    c0729a.f47507i.u(c0729a.f47503e, iVar);
                }
            }
        }

        public C0729a(a aVar, d.a.q0.a.v2.e1.b bVar, String str, boolean z, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str, Boolean.valueOf(z), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47507i = aVar;
            this.f47503e = bVar;
            this.f47504f = str;
            this.f47505g = z;
            this.f47506h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.a.q0.a.e2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [d.a.q0.a.e2.c.j.b$e, ResultDataT] */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                d.a.q0.a.e2.c.i iVar = new d.a.q0.a.e2.c.i();
                if (a.f47496g && d.a.q0.a.u1.a.a.m()) {
                    iVar.e();
                    iVar.f47670a = new b.e(true, null);
                    this.f47507i.u(this.f47503e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                d.a.q0.a.e0.d.h("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f47504f);
                if (!z2 && !fVar.f47631d) {
                    if (!this.f47505g ? fVar.j == 0 : fVar.j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f47507i.c(this.f47506h, this.f47504f, this.f47505g, new C0730a(this));
                        return;
                    }
                    if (fVar.j > 0) {
                        iVar.e();
                        iVar.f47670a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f47507i.u(this.f47503e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f47507i.u(this.f47503e, iVar);
                d.a.q0.a.e0.d.i("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                k.p(10005, fVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f47509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47510f;

        public b(a aVar, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47510f = aVar;
            this.f47509e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f47510f.u(this.f47509e, fVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47512f;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47512f = aVar;
            this.f47511e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f47512f.f47501e.remove(this.f47511e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.q0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e2.c.j.b f47513f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47514g;

        /* renamed from: d.a.q0.a.e2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0731a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f47515e;

            public C0731a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47515e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f47515e.a();
                }
            }
        }

        public d(a aVar, d.a.q0.a.e2.c.j.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47513f = bVar;
            this.f47514g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e2.c.j.b bVar = this.f47513f;
                bVar.r(d.a.q0.a.j2.f.a(this.f47514g));
                bVar.p(new C0731a(this));
                this.f47513f.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends i<d.a.q0.a.v2.e1.b<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f47516a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C0729a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47516a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.e2.a.i
        /* renamed from: b */
        public void a(d.a.q0.a.v2.e1.b<ResulT> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                bVar.onCallback(this.f47516a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f47517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f47518f;

        public f(a aVar, i iVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, iVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47517e = iVar;
            this.f47518f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47517e.a(this.f47518f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends i<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C0729a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.e2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends d.a.q0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47519f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.C0951c f47520g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f47521h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f47522i;
        public final /* synthetic */ d.a.q0.a.v2.e1.b j;

        /* renamed from: d.a.q0.a.e2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0732a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f47523e;

            public C0732a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47523e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.q0.a.e2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f47523e.a();
                }
            }
        }

        public h(a aVar, Activity activity, c.C0951c c0951c, Bundle bundle, String str, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0951c, bundle, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47519f = activity;
            this.f47520g = c0951c;
            this.f47521h = bundle;
            this.f47522i = str;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e2.c.j.f b2 = d.a.q0.a.a2.d.g().y().a().b().b(this.f47519f, this.f47520g, this.f47521h);
                b2.r(this.f47522i);
                b2.p(this.j);
                b2.p(new C0732a(this));
                b2.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class i<CallBackT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0729a c0729a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(114223875, "Ld/a/q0/a/e2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(114223875, "Ld/a/q0/a/e2/a;");
                return;
            }
        }
        f47496g = d.a.q0.a.k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.a2.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.a2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47500d = new HashSet();
        this.f47501e = new HashMap();
        this.f47502f = new d.a.q0.a.v2.d1.c();
        this.f47498b = d.a.q0.a.k2.b.t(eVar);
        this.f47499c = "aiapp_setting_" + this.f47498b;
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, runnable) == null) {
            if (d.a.q0.a.r1.l.e.g()) {
                q0.b0(runnable);
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    public void A(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            o().putLong(str, j2);
        }
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            o().putString(str, str2);
        }
    }

    public synchronized void C(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            synchronized (this) {
                this.f47500d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f47497a.remove(str);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                d.a.q0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.q0.a.h.aiapps_open_fragment_failed_toast).F();
                return false;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(d.a.q0.a.h0.g.g.f48010g, d.a.q0.a.h0.g.g.f48012i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f47500d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            d(context, str, z, true, false, bVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            y(context, str, z, z2, z3, bVar);
        }
    }

    public void e(String str, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(bVar, null);
            } else {
                d.a.q0.a.n1.q.c.a.i(str, new b(this, bVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f47496g && d.a.q0.a.u1.a.a.m()) {
                return true;
            }
            d.a.q0.a.e2.c.f k = d.a.q0.a.n1.q.c.a.k(str);
            return (k == null || k.f47631d || !k.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, bVar) == null) {
            h(context, str, false, bVar);
        }
    }

    public void h(Context context, String str, boolean z, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            e(str, new C0729a(this, bVar, str, z, context));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o().edit().clear().apply();
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f47501e.clear();
                this.f47502f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f47500d.clear();
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            o().edit().clear().commit();
        }
    }

    public boolean m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) ? o().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public long n(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j2)) == null) ? o().getLong(str, j2) : invokeLJ.longValue;
    }

    public final d.a.q0.a.k2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f47497a == null) {
                this.f47497a = new d.a.q0.a.k2.g.g(this.f47499c, false);
            }
            return this.f47497a;
        }
        return (d.a.q0.a.k2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f47499c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, c.C0951c c0951c, Bundle bundle, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<f.d>> bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0951c, bundle, bVar, str) == null) {
            this.f47502f.d(new h(this, activity, c0951c, bundle, str, bVar));
        }
    }

    public synchronized <CallBackT> void s(CallBackT callbackt, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, callbackt, iVar) == null) {
            synchronized (this) {
                x(new f(this, iVar, callbackt));
            }
        }
    }

    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, collection, iVar) == null) {
            synchronized (this) {
                for (CallBackT callbackt : collection) {
                    s(callbackt, iVar);
                }
            }
        }
    }

    public final <ResulT> void u(d.a.q0.a.v2.e1.b<ResulT> bVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, result) == null) {
            s(bVar, new e(this, result));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            t(this.f47500d, new g(this));
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            d.a.q0.a.e2.c.j.b bVar2 = this.f47501e.get(str2);
            if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
                bVar2.p(bVar);
                return;
            }
            d.a.q0.a.e2.c.j.b d2 = d.a.q0.a.a2.d.g().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f47501e.put(str2, d2);
            d2.p(bVar);
            d2.p(new c(this, str2));
            k.N(d.a.q0.a.j2.f.a(str), "requestModifyScope");
            this.f47502f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
