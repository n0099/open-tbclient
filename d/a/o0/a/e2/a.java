package d.a.o0.a.e2;

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
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.e2.c.j.f;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.j2.k;
import d.a.o0.a.u.e.a.c;
import d.a.o0.a.v2.q0;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.a2.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44698g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.k2.g.g f44699a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44700b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44701c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f44702d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.o0.a.e2.c.j.b> f44703e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.o0.a.v2.d1.c f44704f;

    /* renamed from: d.a.o0.a.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0687a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f44705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44707g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f44708h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f44709i;

        /* renamed from: d.a.o0.a.e2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0688a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0687a f44710e;

            public C0688a(C0687a c0687a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0687a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44710e = c0687a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    C0687a c0687a = this.f44710e;
                    c0687a.f44709i.u(c0687a.f44705e, iVar);
                }
            }
        }

        public C0687a(a aVar, d.a.o0.a.v2.e1.b bVar, String str, boolean z, Context context) {
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
            this.f44709i = aVar;
            this.f44705e = bVar;
            this.f44706f = str;
            this.f44707g = z;
            this.f44708h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.a.o0.a.e2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [d.a.o0.a.e2.c.j.b$e, ResultDataT] */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                d.a.o0.a.e2.c.i iVar = new d.a.o0.a.e2.c.i();
                if (a.f44698g && d.a.o0.a.u1.a.a.m()) {
                    iVar.e();
                    iVar.f44872a = new b.e(true, null);
                    this.f44709i.u(this.f44705e, iVar);
                    return;
                }
                boolean z = false;
                boolean z2 = fVar == null;
                d.a.o0.a.e0.d.h("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f44706f);
                if (!z2 && !fVar.f44833d) {
                    if (!this.f44707g ? fVar.j == 0 : fVar.j <= 0) {
                        z = true;
                    }
                    if (z) {
                        this.f44709i.c(this.f44708h, this.f44706f, this.f44707g, new C0688a(this));
                        return;
                    }
                    if (fVar.j > 0) {
                        iVar.e();
                        iVar.f44872a = new b.e(true, null);
                    } else {
                        iVar.d(new OAuthException(10003));
                    }
                    this.f44709i.u(this.f44705e, iVar);
                    return;
                }
                iVar.d(new OAuthException(10005));
                this.f44709i.u(this.f44705e, iVar);
                d.a.o0.a.e0.d.i("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                k.p(10005, fVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f44711e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f44712f;

        public b(a aVar, d.a.o0.a.v2.e1.b bVar) {
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
            this.f44712f = aVar;
            this.f44711e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f44712f.u(this.f44711e, fVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f44714f;

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
            this.f44714f = aVar;
            this.f44713e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f44714f.f44703e.remove(this.f44713e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.o0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.e2.c.j.b f44715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44716g;

        /* renamed from: d.a.o0.a.e2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0689a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f44717e;

            public C0689a(d dVar) {
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
                this.f44717e = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f44717e.a();
                }
            }
        }

        public d(a aVar, d.a.o0.a.e2.c.j.b bVar, String str) {
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
            this.f44715f = bVar;
            this.f44716g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.e2.c.j.b bVar = this.f44715f;
                bVar.r(d.a.o0.a.j2.f.a(this.f44716g));
                bVar.p(new C0689a(this));
                this.f44715f.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends i<d.a.o0.a.v2.e1.b<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f44718a;

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
                    super((a) objArr2[0], (C0687a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44718a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.e2.a.i
        /* renamed from: b */
        public void a(d.a.o0.a.v2.e1.b<ResulT> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                bVar.onCallback(this.f44718a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f44719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44720f;

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
            this.f44719e = iVar;
            this.f44720f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44719e.a(this.f44720f);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    super((a) objArr2[0], (C0687a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.e2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends d.a.o0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44721f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.C0909c f44722g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f44723h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44724i;
        public final /* synthetic */ d.a.o0.a.v2.e1.b j;

        /* renamed from: d.a.o0.a.e2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0690a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<f.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f44725e;

            public C0690a(h hVar) {
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
                this.f44725e = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.o0.a.e2.c.i<f.d> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    this.f44725e.a();
                }
            }
        }

        public h(a aVar, Activity activity, c.C0909c c0909c, Bundle bundle, String str, d.a.o0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity, c0909c, bundle, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44721f = activity;
            this.f44722g = c0909c;
            this.f44723h = bundle;
            this.f44724i = str;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.e2.c.j.f b2 = d.a.o0.a.a2.d.g().y().a().b().b(this.f44721f, this.f44722g, this.f44723h);
                b2.r(this.f44724i);
                b2.p(this.j);
                b2.p(new C0690a(this));
                b2.a();
            }
        }
    }

    /* loaded from: classes7.dex */
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

        public /* synthetic */ i(a aVar, C0687a c0687a) {
            this(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(507250885, "Ld/a/o0/a/e2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(507250885, "Ld/a/o0/a/e2/a;");
                return;
            }
        }
        f44698g = d.a.o0.a.k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.a2.e eVar) {
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
                super((d.a.o0.a.a2.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44702d = new HashSet();
        this.f44703e = new HashMap();
        this.f44704f = new d.a.o0.a.v2.d1.c();
        this.f44700b = d.a.o0.a.k2.b.t(eVar);
        this.f44701c = "aiapp_setting_" + this.f44700b;
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            if (d.a.o0.a.r1.l.e.g()) {
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
                this.f44702d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f44699a.remove(str);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.o0.a.h0.g.g W = d.a.o0.a.g1.f.V().W();
            if (W == null) {
                d.a.o0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.o0.a.h.aiapps_open_fragment_failed_toast).F();
                return false;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(d.a.o0.a.h0.g.g.f45212g, d.a.o0.a.h0.g.g.f45214i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.f44702d.remove(jVar);
            }
        }
    }

    public void c(Context context, String str, boolean z, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            d(context, str, z, true, false, bVar);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            y(context, str, z, z2, z3, bVar);
        }
    }

    public void e(String str, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str)) {
                u(bVar, null);
            } else {
                d.a.o0.a.n1.q.c.a.i(str, new b(this, bVar));
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (f44698g && d.a.o0.a.u1.a.a.m()) {
                return true;
            }
            d.a.o0.a.e2.c.f k = d.a.o0.a.n1.q.c.a.k(str);
            return (k == null || k.f44833d || !k.a()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, String str, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, bVar) == null) {
            h(context, str, false, bVar);
        }
    }

    public void h(Context context, String str, boolean z, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), bVar}) == null) {
            e(str, new C0687a(this, bVar, str, z, context));
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
                this.f44703e.clear();
                this.f44704f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f44702d.clear();
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

    public final d.a.o0.a.k2.g.g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f44699a == null) {
                this.f44699a = new d.a.o0.a.k2.g.g(this.f44701c, false);
            }
            return this.f44699a;
        }
        return (d.a.o0.a.k2.g.g) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f44701c : (String) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? o().getString(str, str2) : (String) invokeLL.objValue;
    }

    public void r(Activity activity, c.C0909c c0909c, Bundle bundle, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<f.d>> bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, c0909c, bundle, bVar, str) == null) {
            this.f44704f.d(new h(this, activity, c0909c, bundle, str, bVar));
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

    public final <ResulT> void u(d.a.o0.a.v2.e1.b<ResulT> bVar, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, result) == null) {
            s(bVar, new e(this, result));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            t(this.f44702d, new g(this));
        }
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), bVar}) == null) {
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            d.a.o0.a.e2.c.j.b bVar2 = this.f44703e.get(str2);
            if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
                bVar2.p(bVar);
                return;
            }
            d.a.o0.a.e2.c.j.b d2 = d.a.o0.a.a2.d.g().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.f44703e.put(str2, d2);
            d2.p(bVar);
            d2.p(new c(this, str2));
            k.N(d.a.o0.a.j2.f.a(str), "requestModifyScope");
            this.f44704f.d(new d(this, d2, str));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }
}
