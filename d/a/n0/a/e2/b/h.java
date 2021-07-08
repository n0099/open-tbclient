package d.a.n0.a.e2.b;

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
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.j2.k;
import d.a.n0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44253f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44254g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f44255h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44256i;
        public final /* synthetic */ h j;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, d.a.n0.a.a2.e eVar, JSONArray jSONArray) {
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
            this.f44252e = callbackHandler;
            this.f44253f = str;
            this.f44254g = context;
            this.f44255h = eVar;
            this.f44256i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.n0.a.e2.c.d.h(iVar)) {
                    this.j.x((Activity) this.f44254g, this.f44255h, this.f44252e, this.f44256i, this.f44253f);
                } else {
                    d.a.n0.a.e2.c.d.p(iVar, this.f44252e, this.f44253f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44257a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44258b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44259c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f44260d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f44262f;

        /* loaded from: classes7.dex */
        public class a implements d.a.n0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.e2.c.f f44263e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44264f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f44265g;

            /* renamed from: d.a.n0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0683a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f44266e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f44267f;

                public RunnableC0683a(a aVar, Boolean bool) {
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
                    this.f44267f = aVar;
                    this.f44266e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f44267f;
                        h hVar = aVar.f44265g.f44262f;
                        d.a.n0.a.e2.c.f fVar = aVar.f44263e;
                        List list = aVar.f44264f;
                        boolean booleanValue = this.f44266e.booleanValue();
                        b bVar = this.f44267f.f44265g;
                        hVar.P(fVar, list, booleanValue, bVar.f44261e, bVar.f44260d, bVar.f44257a, bVar.f44258b);
                    }
                }
            }

            public a(b bVar, d.a.n0.a.e2.c.f fVar, List list) {
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
                this.f44265g = bVar;
                this.f44263e = fVar;
                this.f44264f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.n0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f44265g;
                    bVar.f44262f.O(bVar.f44261e, this.f44263e, bool);
                    q0.X(new RunnableC0683a(this, bool));
                }
            }
        }

        /* renamed from: d.a.n0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0684b implements d.a.n0.a.v2.e1.b<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.e2.c.f f44268e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44269f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f44270g;

            /* renamed from: d.a.n0.a.e2.b.h$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0684b f44271e;

                public a(C0684b c0684b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0684b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f44271e = c0684b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0684b c0684b = this.f44271e;
                        b bVar = c0684b.f44270g;
                        bVar.f44262f.P(c0684b.f44268e, c0684b.f44269f, false, bVar.f44261e, bVar.f44260d, bVar.f44257a, bVar.f44258b);
                    }
                }
            }

            public C0684b(b bVar, d.a.n0.a.e2.c.f fVar, List list) {
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
                this.f44270g = bVar;
                this.f44268e = fVar;
                this.f44269f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.n0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f44270g;
                    bVar.f44262f.N(bVar.f44261e, this.f44268e, str);
                    q0.X(new a(this));
                }
            }
        }

        public b(h hVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.n0.a.a2.e eVar, Activity activity) {
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
            this.f44262f = hVar;
            this.f44257a = callbackHandler;
            this.f44258b = str;
            this.f44259c = jSONArray;
            this.f44260d = eVar;
            this.f44261e = activity;
        }

        @Override // d.a.n0.a.n1.q.b.a
        public void a() {
            Map<String, d.a.n0.a.e2.c.f> g2;
            d.a.n0.a.e2.c.f y;
            List<d.a.n0.a.e2.c.f> w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f44262f.y((g2 = d.a.n0.a.n1.q.c.a.g(true)), this.f44257a, this.f44258b)) == null || (w = this.f44262f.w(g2, this.f44259c, this.f44257a, this.f44258b)) == null) {
                return;
            }
            y.g(w);
            if (this.f44260d.j().e(this.f44261e)) {
                this.f44262f.z(new C0684b(this, y, w));
            } else {
                d.a.n0.a.c1.a.T().a(this.f44261e, new a(this, y, w));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44272a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44273b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44274c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f44275d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44277f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f44278g;

        public c(h hVar, CallbackHandler callbackHandler, String str, boolean z, d.a.n0.a.a2.e eVar, Activity activity, List list) {
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
            this.f44278g = hVar;
            this.f44272a = callbackHandler;
            this.f44273b = str;
            this.f44274c = z;
            this.f44275d = eVar;
            this.f44276e = activity;
            this.f44277f = list;
        }

        @Override // d.a.n0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.n0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    d.a.n0.a.e2.c.d.n(10003, this.f44272a, this.f44273b);
                    return;
                }
                boolean z2 = this.f44274c;
                if (this.f44275d.j().e(this.f44276e)) {
                    this.f44278g.H(this.f44277f, this.f44276e, this.f44272a, this.f44273b);
                } else if (z2) {
                    this.f44278g.K(this.f44277f, this.f44276e, this.f44272a, this.f44273b);
                } else {
                    this.f44278g.G(this.f44277f, this.f44276e, this.f44272a, this.f44273b, this.f44275d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f44279a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f44280b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44281c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44282d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f44283e;

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
            this.f44283e = hVar;
            this.f44279a = list;
            this.f44280b = activity;
            this.f44281c = callbackHandler;
            this.f44282d = str;
        }

        @Override // d.a.n0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                d.a.n0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
                if (z) {
                    this.f44283e.H(this.f44279a, this.f44280b, this.f44281c, this.f44282d);
                } else {
                    d.a.n0.a.e2.c.d.n(10004, this.f44281c, this.f44282d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.n0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44284e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44285f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44286g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44287h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f44288i;

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
            this.f44288i = hVar;
            this.f44284e = list;
            this.f44285f = activity;
            this.f44286g = callbackHandler;
            this.f44287h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f44288i.I(TextUtils.equals(str, "1"), this.f44284e, this.f44285f, this.f44286g, this.f44287h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.n0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44290f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44291g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44292h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f44293i;

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
            this.f44293i = hVar;
            this.f44289e = activity;
            this.f44290f = list;
            this.f44291g = callbackHandler;
            this.f44292h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f44293i.J(this.f44289e, this.f44290f, this.f44291g, this.f44292h);
                } else {
                    d.a.n0.a.e2.c.d.n(10003, this.f44291g, this.f44292h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.n0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44295f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44296g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44297h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f44298i;

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
            this.f44298i = hVar;
            this.f44294e = list;
            this.f44295f = activity;
            this.f44296g = callbackHandler;
            this.f44297h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    this.f44298i.H(this.f44294e, this.f44295f, this.f44296g, this.f44297h);
                } else {
                    d.a.n0.a.e2.c.d.n(10003, this.f44296g, this.f44297h);
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0685h implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44300f;

        public C0685h(h hVar, CallbackHandler callbackHandler, String str) {
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
            this.f44299e = callbackHandler;
            this.f44300f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    d.a.n0.a.e2.c.d.n(10001, this.f44299e, this.f44300f);
                    k.p(10001, null);
                    return;
                }
                int b2 = iVar.b();
                d.a.n0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f44368a);
                if (b2 != 0) {
                    d.a.n0.a.e2.c.d.n(b2, this.f44299e, this.f44300f);
                } else {
                    this.f44299e.handleSchemeDispatchCallback(this.f44300f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f44301e;

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
            this.f44301e = jVar;
        }

        @Override // d.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f44301e.a(false, i2);
                } else {
                    this.f44301e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.n0.a.c2.e eVar) {
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

    public final boolean A(List<d.a.n0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (d.a.n0.a.e2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(d.a.n0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f44327b, "mapp_location") || TextUtils.equals(fVar.f44327b, "mapp_images") || TextUtils.equals(fVar.f44327b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f44327b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f44327b, "ppcert") || TextUtils.equals(fVar.f44327b, "mapp_i_face_verify") || TextUtils.equals(fVar.f44327b, "snsapi_userinfo") || TextUtils.equals(fVar.f44327b, "mapp_choose_address") || TextUtils.equals(fVar.f44327b, "mobile") || TextUtils.equals(fVar.f44327b, "mapp_choose_invoice") : invokeL.booleanValue;
    }

    public final boolean C(d.a.n0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f44327b, "ppcert") || TextUtils.equals(fVar.f44327b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<d.a.n0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (d.a.n0.a.e2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(d.a.n0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f44327b, "mapp_location") || TextUtils.equals(fVar.f44327b, "mapp_images") || TextUtils.equals(fVar.f44327b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f44327b, PermissionProxy.SCOPE_ID_CAMERA) : invokeL.booleanValue;
    }

    public final boolean F(List<d.a.n0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (d.a.n0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<d.a.n0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.n0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                L(eVar, activity, new d(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void H(List<d.a.n0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                z(new e(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void I(boolean z, List<d.a.n0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                d.a.n0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            d.a.n0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.n0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f44327b;
            }
            d.a.n0.a.e2.c.j.b d2 = d.a.n0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
            d2.p(new C0685h(this, callbackHandler, str));
            d2.a();
        }
    }

    public final void K(List<d.a.n0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            d.a.n0.a.c1.a.T().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull d.a.n0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(d.a.n0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            d.a.n0.a.c1.a.T().b(false, bVar);
        }
    }

    public final void N(@NonNull Activity activity, d.a.n0.a.e2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String O = d.a.n0.a.a2.d.g().r().O();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(d.a.n0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, d.a.n0.a.e2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String O = d.a.n0.a.a2.d.g().r().O();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(d.a.n0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(d.a.n0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.n0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(d.a.n0.a.e2.c.f fVar, List<d.a.n0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull d.a.n0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            d.a.n0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
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

    public final void v(@NonNull d.a.n0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.j().f(activity, null, new i(this, jVar));
        }
    }

    public final List<d.a.n0.a.e2.c.f> w(Map<String, d.a.n0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        d.a.n0.a.e2.c.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                    if (!B(fVar)) {
                        d.a.n0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else if (fVar.f44329d) {
                        d.a.n0.a.e2.c.d.n(10005, callbackHandler, str);
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
            d.a.n0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.n0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            d.a.n0.a.n1.q.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final d.a.n0.a.e2.c.f y(Map<String, d.a.n0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            d.a.n0.a.e2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                d.a.n0.a.e2.c.d.n(10001, callbackHandler, str);
                k.p(10001, null);
                return null;
            } else if (fVar.f44329d) {
                d.a.n0.a.e2.c.d.n(10005, callbackHandler, str);
                k.p(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (d.a.n0.a.e2.c.f) invokeLLL.objValue;
    }

    public final void z(d.a.n0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            d.a.n0.a.c1.a.T().c(d.a.n0.a.c1.a.b(), bVar);
        }
    }
}
