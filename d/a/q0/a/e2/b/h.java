package d.a.q0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.j2.k;
import d.a.q0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47555f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47556g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47557h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47558i;
        public final /* synthetic */ h j;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, d.a.q0.a.a2.e eVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, context, eVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = hVar;
            this.f47554e = callbackHandler;
            this.f47555f = str;
            this.f47556g = context;
            this.f47557h = eVar;
            this.f47558i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.j.x((Activity) this.f47556g, this.f47557h, this.f47554e, this.f47558i, this.f47555f);
                } else {
                    d.a.q0.a.e2.c.d.p(iVar, this.f47554e, this.f47555f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47560b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47561c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47562d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f47564f;

        /* loaded from: classes8.dex */
        public class a implements d.a.q0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.e2.c.f f47565e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f47566f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f47567g;

            /* renamed from: d.a.q0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0734a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f47568e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f47569f;

                public RunnableC0734a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47569f = aVar;
                    this.f47568e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f47569f;
                        h hVar = aVar.f47567g.f47564f;
                        d.a.q0.a.e2.c.f fVar = aVar.f47565e;
                        List list = aVar.f47566f;
                        boolean booleanValue = this.f47568e.booleanValue();
                        b bVar = this.f47569f.f47567g;
                        hVar.P(fVar, list, booleanValue, bVar.f47563e, bVar.f47562d, bVar.f47559a, bVar.f47560b);
                    }
                }
            }

            public a(b bVar, d.a.q0.a.e2.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47567g = bVar;
                this.f47565e = fVar;
                this.f47566f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f47567g;
                    bVar.f47564f.O(bVar.f47563e, this.f47565e, bool);
                    q0.X(new RunnableC0734a(this, bool));
                }
            }
        }

        /* renamed from: d.a.q0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0735b implements d.a.q0.a.v2.e1.b<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.e2.c.f f47570e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f47571f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f47572g;

            /* renamed from: d.a.q0.a.e2.b.h$b$b$a */
            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0735b f47573e;

                public a(C0735b c0735b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0735b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47573e = c0735b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0735b c0735b = this.f47573e;
                        b bVar = c0735b.f47572g;
                        bVar.f47564f.P(c0735b.f47570e, c0735b.f47571f, false, bVar.f47563e, bVar.f47562d, bVar.f47559a, bVar.f47560b);
                    }
                }
            }

            public C0735b(b bVar, d.a.q0.a.e2.c.f fVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47572g = bVar;
                this.f47570e = fVar;
                this.f47571f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f47572g;
                    bVar.f47564f.N(bVar.f47563e, this.f47570e, str);
                    q0.X(new a(this));
                }
            }
        }

        public b(h hVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.q0.a.a2.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, jSONArray, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47564f = hVar;
            this.f47559a = callbackHandler;
            this.f47560b = str;
            this.f47561c = jSONArray;
            this.f47562d = eVar;
            this.f47563e = activity;
        }

        @Override // d.a.q0.a.n1.q.b.a
        public void a() {
            Map<String, d.a.q0.a.e2.c.f> g2;
            d.a.q0.a.e2.c.f y;
            List<d.a.q0.a.e2.c.f> w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f47564f.y((g2 = d.a.q0.a.n1.q.c.a.g(true)), this.f47559a, this.f47560b)) == null || (w = this.f47564f.w(g2, this.f47561c, this.f47559a, this.f47560b)) == null) {
                return;
            }
            y.g(w);
            if (this.f47562d.j().e(this.f47563e)) {
                this.f47564f.z(new C0735b(this, y, w));
            } else {
                d.a.q0.a.c1.a.T().a(this.f47563e, new a(this, y, w));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47575b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f47576c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47577d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47578e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47579f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f47580g;

        public c(h hVar, CallbackHandler callbackHandler, String str, boolean z, d.a.q0.a.a2.e eVar, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, Boolean.valueOf(z), eVar, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47580g = hVar;
            this.f47574a = callbackHandler;
            this.f47575b = str;
            this.f47576c = z;
            this.f47577d = eVar;
            this.f47578e = activity;
            this.f47579f = list;
        }

        @Override // d.a.q0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.q0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    d.a.q0.a.e2.c.d.n(10003, this.f47574a, this.f47575b);
                    return;
                }
                boolean z2 = this.f47576c;
                if (this.f47577d.j().e(this.f47578e)) {
                    this.f47580g.H(this.f47579f, this.f47578e, this.f47574a, this.f47575b);
                } else if (z2) {
                    this.f47580g.K(this.f47579f, this.f47578e, this.f47574a, this.f47575b);
                } else {
                    this.f47580g.G(this.f47579f, this.f47578e, this.f47574a, this.f47575b, this.f47577d);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f47581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f47582b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47583c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47584d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f47585e;

        public d(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47585e = hVar;
            this.f47581a = list;
            this.f47582b = activity;
            this.f47583c = callbackHandler;
            this.f47584d = str;
        }

        @Override // d.a.q0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                d.a.q0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
                if (z) {
                    this.f47585e.H(this.f47581a, this.f47582b, this.f47583c, this.f47584d);
                } else {
                    d.a.q0.a.e2.c.d.n(10004, this.f47583c, this.f47584d);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47587f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47588g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47589h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f47590i;

        public e(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47590i = hVar;
            this.f47586e = list;
            this.f47587f = activity;
            this.f47588g = callbackHandler;
            this.f47589h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f47590i.I(TextUtils.equals(str, "1"), this.f47586e, this.f47587f, this.f47588g, this.f47589h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47592f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47593g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47594h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f47595i;

        public f(h hVar, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47595i = hVar;
            this.f47591e = activity;
            this.f47592f = list;
            this.f47593g = callbackHandler;
            this.f47594h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f47595i.J(this.f47591e, this.f47592f, this.f47593g, this.f47594h);
                } else {
                    d.a.q0.a.e2.c.d.n(10003, this.f47593g, this.f47594h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47598g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47599h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f47600i;

        public g(h hVar, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47600i = hVar;
            this.f47596e = list;
            this.f47597f = activity;
            this.f47598g = callbackHandler;
            this.f47599h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    this.f47600i.H(this.f47596e, this.f47597f, this.f47598g, this.f47599h);
                } else {
                    d.a.q0.a.e2.c.d.n(10003, this.f47598g, this.f47599h);
                }
            }
        }
    }

    /* renamed from: d.a.q0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0736h implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47602f;

        public C0736h(h hVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47601e = callbackHandler;
            this.f47602f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    d.a.q0.a.e2.c.d.n(10001, this.f47601e, this.f47602f);
                    k.p(10001, null);
                    return;
                }
                int b2 = iVar.b();
                d.a.q0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f47670a);
                if (b2 != 0) {
                    d.a.q0.a.e2.c.d.n(b2, this.f47601e, this.f47602f);
                } else {
                    this.f47601e.handleSchemeDispatchCallback(this.f47602f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f47603e;

        public i(h hVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47603e = jVar;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f47603e.a(false, i2);
                } else {
                    this.f47603e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<d.a.q0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (d.a.q0.a.e2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(d.a.q0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f47629b, "mapp_location") || TextUtils.equals(fVar.f47629b, "mapp_images") || TextUtils.equals(fVar.f47629b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f47629b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f47629b, "ppcert") || TextUtils.equals(fVar.f47629b, "mapp_i_face_verify") || TextUtils.equals(fVar.f47629b, "snsapi_userinfo") || TextUtils.equals(fVar.f47629b, "mapp_choose_address") || TextUtils.equals(fVar.f47629b, "mobile") || TextUtils.equals(fVar.f47629b, "mapp_choose_invoice") : invokeL.booleanValue;
    }

    public final boolean C(d.a.q0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f47629b, "ppcert") || TextUtils.equals(fVar.f47629b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<d.a.q0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (d.a.q0.a.e2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(d.a.q0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f47629b, "mapp_location") || TextUtils.equals(fVar.f47629b, "mapp_images") || TextUtils.equals(fVar.f47629b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f47629b, PermissionProxy.SCOPE_ID_CAMERA) : invokeL.booleanValue;
    }

    public final boolean F(List<d.a.q0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (d.a.q0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<d.a.q0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.q0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                L(eVar, activity, new d(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void H(List<d.a.q0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                z(new e(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void I(boolean z, List<d.a.q0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                d.a.q0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            d.a.q0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.q0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f47629b;
            }
            d.a.q0.a.e2.c.j.b d2 = d.a.q0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
            d2.p(new C0736h(this, callbackHandler, str));
            d2.a();
        }
    }

    public final void K(List<d.a.q0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            d.a.q0.a.c1.a.T().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull d.a.q0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(d.a.q0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            d.a.q0.a.c1.a.T().b(false, bVar);
        }
    }

    public final void N(@NonNull Activity activity, d.a.q0.a.e2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String O = d.a.q0.a.a2.d.g().r().O();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(d.a.q0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, d.a.q0.a.e2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String O = d.a.q0.a.a2.d.g().r().O();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(d.a.q0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(d.a.q0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.q0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(d.a.q0.a.e2.c.f fVar, List<d.a.q0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull d.a.q0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            d.a.q0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && (context instanceof Activity)) {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        eVar.T().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void v(@NonNull d.a.q0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.j().f(activity, null, new i(this, jVar));
        }
    }

    public final List<d.a.q0.a.e2.c.f> w(Map<String, d.a.q0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        d.a.q0.a.e2.c.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                    if (!B(fVar)) {
                        d.a.q0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else if (fVar.f47631d) {
                        d.a.q0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else {
                        if (!arrayList.contains(fVar) && !fVar.a()) {
                            arrayList.add(fVar);
                        }
                        if (!fVar.a()) {
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return null;
            }
            d.a.q0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.q0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            d.a.q0.a.n1.q.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final d.a.q0.a.e2.c.f y(Map<String, d.a.q0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            d.a.q0.a.e2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                d.a.q0.a.e2.c.d.n(10001, callbackHandler, str);
                k.p(10001, null);
                return null;
            } else if (fVar.f47631d) {
                d.a.q0.a.e2.c.d.n(10005, callbackHandler, str);
                k.p(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (d.a.q0.a.e2.c.f) invokeLLL.objValue;
    }

    public final void z(d.a.q0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            d.a.q0.a.c1.a.T().c(d.a.q0.a.c1.a.b(), bVar);
        }
    }
}
