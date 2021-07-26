package d.a.o0.a.e2.b;

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
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.j2.k;
import d.a.o0.a.v2.q0;
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
    public class a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44757f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44758g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44759h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44760i;
        public final /* synthetic */ h j;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, d.a.o0.a.a2.e eVar, JSONArray jSONArray) {
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
            this.f44756e = callbackHandler;
            this.f44757f = str;
            this.f44758g = context;
            this.f44759h = eVar;
            this.f44760i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.j.x((Activity) this.f44758g, this.f44759h, this.f44756e, this.f44760i, this.f44757f);
                } else {
                    d.a.o0.a.e2.c.d.p(iVar, this.f44756e, this.f44757f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44761a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44762b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44763c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44764d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f44766f;

        /* loaded from: classes7.dex */
        public class a implements d.a.o0.a.v2.e1.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.e2.c.f f44767e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44768f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f44769g;

            /* renamed from: d.a.o0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0692a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f44770e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f44771f;

                public RunnableC0692a(a aVar, Boolean bool) {
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
                    this.f44771f = aVar;
                    this.f44770e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f44771f;
                        h hVar = aVar.f44769g.f44766f;
                        d.a.o0.a.e2.c.f fVar = aVar.f44767e;
                        List list = aVar.f44768f;
                        boolean booleanValue = this.f44770e.booleanValue();
                        b bVar = this.f44771f.f44769g;
                        hVar.P(fVar, list, booleanValue, bVar.f44765e, bVar.f44764d, bVar.f44761a, bVar.f44762b);
                    }
                }
            }

            public a(b bVar, d.a.o0.a.e2.c.f fVar, List list) {
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
                this.f44769g = bVar;
                this.f44767e = fVar;
                this.f44768f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    b bVar = this.f44769g;
                    bVar.f44766f.O(bVar.f44765e, this.f44767e, bool);
                    q0.X(new RunnableC0692a(this, bool));
                }
            }
        }

        /* renamed from: d.a.o0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0693b implements d.a.o0.a.v2.e1.b<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.e2.c.f f44772e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44773f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f44774g;

            /* renamed from: d.a.o0.a.e2.b.h$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0693b f44775e;

                public a(C0693b c0693b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0693b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f44775e = c0693b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0693b c0693b = this.f44775e;
                        b bVar = c0693b.f44774g;
                        bVar.f44766f.P(c0693b.f44772e, c0693b.f44773f, false, bVar.f44765e, bVar.f44764d, bVar.f44761a, bVar.f44762b);
                    }
                }
            }

            public C0693b(b bVar, d.a.o0.a.e2.c.f fVar, List list) {
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
                this.f44774g = bVar;
                this.f44772e = fVar;
                this.f44773f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b bVar = this.f44774g;
                    bVar.f44766f.N(bVar.f44765e, this.f44772e, str);
                    q0.X(new a(this));
                }
            }
        }

        public b(h hVar, CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.o0.a.a2.e eVar, Activity activity) {
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
            this.f44766f = hVar;
            this.f44761a = callbackHandler;
            this.f44762b = str;
            this.f44763c = jSONArray;
            this.f44764d = eVar;
            this.f44765e = activity;
        }

        @Override // d.a.o0.a.n1.q.b.a
        public void a() {
            Map<String, d.a.o0.a.e2.c.f> g2;
            d.a.o0.a.e2.c.f y;
            List<d.a.o0.a.e2.c.f> w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f44766f.y((g2 = d.a.o0.a.n1.q.c.a.g(true)), this.f44761a, this.f44762b)) == null || (w = this.f44766f.w(g2, this.f44763c, this.f44761a, this.f44762b)) == null) {
                return;
            }
            y.g(w);
            if (this.f44764d.j().e(this.f44765e)) {
                this.f44766f.z(new C0693b(this, y, w));
            } else {
                d.a.o0.a.c1.a.T().a(this.f44765e, new a(this, y, w));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44776a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44777b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44778c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44779d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44781f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f44782g;

        public c(h hVar, CallbackHandler callbackHandler, String str, boolean z, d.a.o0.a.a2.e eVar, Activity activity, List list) {
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
            this.f44782g = hVar;
            this.f44776a = callbackHandler;
            this.f44777b = str;
            this.f44778c = z;
            this.f44779d = eVar;
            this.f44780e = activity;
            this.f44781f = list;
        }

        @Override // d.a.o0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.o0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    d.a.o0.a.e2.c.d.n(10003, this.f44776a, this.f44777b);
                    return;
                }
                boolean z2 = this.f44778c;
                if (this.f44779d.j().e(this.f44780e)) {
                    this.f44782g.H(this.f44781f, this.f44780e, this.f44776a, this.f44777b);
                } else if (z2) {
                    this.f44782g.K(this.f44781f, this.f44780e, this.f44776a, this.f44777b);
                } else {
                    this.f44782g.G(this.f44781f, this.f44780e, this.f44776a, this.f44777b, this.f44779d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f44783a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f44784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44785c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44786d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f44787e;

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
            this.f44787e = hVar;
            this.f44783a = list;
            this.f44784b = activity;
            this.f44785c = callbackHandler;
            this.f44786d = str;
        }

        @Override // d.a.o0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                d.a.o0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
                if (z) {
                    this.f44787e.H(this.f44783a, this.f44784b, this.f44785c, this.f44786d);
                } else {
                    d.a.o0.a.e2.c.d.n(10004, this.f44785c, this.f44786d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44788e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44789f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44790g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44791h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f44792i;

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
            this.f44792i = hVar;
            this.f44788e = list;
            this.f44789f = activity;
            this.f44790g = callbackHandler;
            this.f44791h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f44792i.I(TextUtils.equals(str, "1"), this.f44788e, this.f44789f, this.f44790g, this.f44791h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44794f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44795g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44796h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f44797i;

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
            this.f44797i = hVar;
            this.f44793e = activity;
            this.f44794f = list;
            this.f44795g = callbackHandler;
            this.f44796h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f44797i.J(this.f44793e, this.f44794f, this.f44795g, this.f44796h);
                } else {
                    d.a.o0.a.e2.c.d.n(10003, this.f44795g, this.f44796h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.o0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44800g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44801h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f44802i;

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
            this.f44802i = hVar;
            this.f44798e = list;
            this.f44799f = activity;
            this.f44800g = callbackHandler;
            this.f44801h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 0) {
                    this.f44802i.H(this.f44798e, this.f44799f, this.f44800g, this.f44801h);
                } else {
                    d.a.o0.a.e2.c.d.n(10003, this.f44800g, this.f44801h);
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0694h implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44804f;

        public C0694h(h hVar, CallbackHandler callbackHandler, String str) {
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
            this.f44803e = callbackHandler;
            this.f44804f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null) {
                    d.a.o0.a.e2.c.d.n(10001, this.f44803e, this.f44804f);
                    k.p(10001, null);
                    return;
                }
                int b2 = iVar.b();
                d.a.o0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f44872a);
                if (b2 != 0) {
                    d.a.o0.a.e2.c.d.n(b2, this.f44803e, this.f44804f);
                } else {
                    this.f44803e.handleSchemeDispatchCallback(this.f44804f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f44805e;

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
            this.f44805e = jVar;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    this.f44805e.a(false, i2);
                } else {
                    this.f44805e.a(true, i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.o0.a.c2.e eVar) {
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

    public final boolean A(List<d.a.o0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (d.a.o0.a.e2.c.f fVar : list) {
                    if (fVar != null && C(fVar)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(d.a.o0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) ? TextUtils.equals(fVar.f44831b, "mapp_location") || TextUtils.equals(fVar.f44831b, "mapp_images") || TextUtils.equals(fVar.f44831b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f44831b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f44831b, "ppcert") || TextUtils.equals(fVar.f44831b, "mapp_i_face_verify") || TextUtils.equals(fVar.f44831b, "snsapi_userinfo") || TextUtils.equals(fVar.f44831b, "mapp_choose_address") || TextUtils.equals(fVar.f44831b, "mobile") || TextUtils.equals(fVar.f44831b, "mapp_choose_invoice") : invokeL.booleanValue;
    }

    public final boolean C(d.a.o0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) ? TextUtils.equals(fVar.f44831b, "ppcert") || TextUtils.equals(fVar.f44831b, "mapp_i_face_verify") : invokeL.booleanValue;
    }

    public final boolean D(List<d.a.o0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (d.a.o0.a.e2.c.f fVar : list) {
                if (fVar != null && !E(fVar)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(d.a.o0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) ? TextUtils.equals(fVar.f44831b, "mapp_location") || TextUtils.equals(fVar.f44831b, "mapp_images") || TextUtils.equals(fVar.f44831b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f44831b, PermissionProxy.SCOPE_ID_CAMERA) : invokeL.booleanValue;
    }

    public final boolean F(List<d.a.o0.a.e2.c.f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (d.a.o0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(List<d.a.o0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, eVar) == null) {
            if (D(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                L(eVar, activity, new d(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void H(List<d.a.o0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                J(activity, list, callbackHandler, str);
            } else {
                z(new e(this, list, activity, callbackHandler, str));
            }
        }
    }

    public final void I(boolean z, List<d.a.o0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                d.a.o0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            d.a.o0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.o0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).f44831b;
            }
            d.a.o0.a.e2.c.j.b d2 = d.a.o0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
            d2.p(new C0694h(this, callbackHandler, str));
            d2.a();
        }
    }

    public final void K(List<d.a.o0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            d.a.o0.a.c1.a.T().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void L(@NonNull d.a.o0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, eVar, activity, jVar) == null) {
            v(eVar, activity, jVar);
        }
    }

    public final void M(d.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            d.a.o0.a.c1.a.T().b(false, bVar);
        }
    }

    public final void N(@NonNull Activity activity, d.a.o0.a.e2.c.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fVar, str) == null) {
            String O = d.a.o0.a.a2.d.g().r().O();
            boolean equals = TextUtils.equals(str, "1");
            if (!A(fVar.s)) {
                fVar.r = activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_end);
            } else if (equals) {
                fVar.r = activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(d.a.o0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void O(@NonNull Activity activity, d.a.o0.a.e2.c.f fVar, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, fVar, bool) == null) {
            String O = d.a.o0.a.a2.d.g().r().O();
            boolean D = D(fVar.s);
            boolean A = A(fVar.s);
            if (!bool.booleanValue() && !D) {
                fVar.r = activity.getString(d.a.o0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_end);
            } else if (A) {
                fVar.r = activity.getString(d.a.o0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_end);
            } else {
                fVar.r = activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.o0.a.h.swanapp_multi_auth_default_name_end);
            }
        }
    }

    public final void P(d.a.o0.a.e2.c.f fVar, List<d.a.o0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull d.a.o0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, list, Boolean.valueOf(z), activity, eVar, callbackHandler, str}) == null) {
            d.a.o0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(this, callbackHandler, str, z, eVar, activity, list));
        }
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
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

    public final void v(@NonNull d.a.o0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, eVar, activity, jVar) == null) {
            eVar.j().f(activity, null, new i(this, jVar));
        }
    }

    public final List<d.a.o0.a.e2.c.f> w(Map<String, d.a.o0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        d.a.o0.a.e2.c.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                    if (!B(fVar)) {
                        d.a.o0.a.e2.c.d.n(10005, callbackHandler, str);
                        k.p(10005, fVar);
                        return null;
                    } else if (fVar.f44833d) {
                        d.a.o0.a.e2.c.d.n(10005, callbackHandler, str);
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
            d.a.o0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.o0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, eVar, callbackHandler, jSONArray, str) == null) {
            d.a.o0.a.n1.q.a.g().z(new b(this, callbackHandler, str, jSONArray, eVar, activity));
        }
    }

    public final d.a.o0.a.e2.c.f y(Map<String, d.a.o0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            d.a.o0.a.e2.c.f fVar = map.get("scope_multi_authorize");
            if (fVar == null) {
                d.a.o0.a.e2.c.d.n(10001, callbackHandler, str);
                k.p(10001, null);
                return null;
            } else if (fVar.f44833d) {
                d.a.o0.a.e2.c.d.n(10005, callbackHandler, str);
                k.p(10005, fVar);
                return null;
            } else {
                return fVar;
            }
        }
        return (d.a.o0.a.e2.c.f) invokeLLL.objValue;
    }

    public final void z(d.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            d.a.o0.a.c1.a.T().c(d.a.o0.a.c1.a.b(), bVar);
        }
    }
}
