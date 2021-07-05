package d.a.q0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import d.a.q0.a.z1.b.b.h;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f49468d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0870a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49469e;

        public RunnableC0870a(a aVar) {
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
                    return;
                }
            }
            this.f49469e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e f2 = d.a.q0.a.z1.b.f.e.f(this.f49469e.i(), d.a.q0.a.h.swan_bookshelf_insert_async);
                f2.l(10);
                f2.r(false);
                f2.y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f49470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.j.b f49471b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f49472c;

        /* renamed from: d.a.q0.a.n.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0871a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0871a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.z1.b.f.e.a();
                }
            }
        }

        /* renamed from: d.a.q0.a.n.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0872b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0872b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.z1.b.f.e.f(d.a.q0.a.c1.a.b(), d.a.q0.a.h.swan_bookshelf_insert_failed).F();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.z1.b.f.e.a();
                }
            }
        }

        public b(a aVar, boolean z, d.a.q0.a.h0.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49472c = aVar;
            this.f49470a = z;
            this.f49471b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.f49470a) {
                    q0.b0(new RunnableC0871a(this));
                }
                if (jSONObject == null) {
                    this.f49472c.H(this.f49471b, 1001, "server response fail", this.f49470a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.f49470a) {
                        q0.b0(new RunnableC0872b(this));
                    }
                    this.f49472c.H(this.f49471b, optInt, jSONObject.optString("errmsg"), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f49472c.H(this.f49471b, 0, jSONObject.optString("errmsg"), this.f49470a);
                } else {
                    this.f49472c.I(this.f49471b, optJSONObject, this.f49470a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (this.f49470a) {
                    q0.b0(new c(this));
                }
                a aVar = this.f49472c;
                d.a.q0.a.h0.j.b bVar = this.f49471b;
                aVar.H(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f49470a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49473e;

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
            this.f49473e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e.g(d.a.q0.a.c1.a.b(), this.f49473e).F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49474e;

        public d(a aVar) {
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
                    return;
                }
            }
            this.f49474e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e.f(this.f49474e.i(), d.a.q0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49475e;

        public e(a aVar) {
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
                    return;
                }
            }
            this.f49475e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e.f(this.f49475e.i(), d.a.q0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49477f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49478g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f49479h;

        /* renamed from: d.a.q0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0873a implements d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f49480a;

            public C0873a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49480a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.h0.j.b
            /* renamed from: b */
            public void a(d.a.q0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    f fVar = this.f49480a;
                    fVar.f49479h.d(fVar.f49478g, bVar);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f49481e;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49481e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.z1.b.f.e.f(this.f49481e.f49479h.i(), d.a.q0.a.h.swan_bookshelf_authorize_fail).F();
                }
            }
        }

        public f(a aVar, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49479h = aVar;
            this.f49476e = jSONArray;
            this.f49477f = str;
            this.f49478g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    int t1 = d.a.q0.a.a2.d.g().r().L().t1();
                    String u1 = d.a.q0.a.a2.d.g().r().L().u1();
                    String D = d.a.q0.a.a2.d.g().r().D();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", D);
                    hashMap.put("contentIds", this.f49476e);
                    hashMap.put("category", this.f49477f);
                    hashMap.put("pkg_type", Integer.valueOf(t1));
                    hashMap.put("version_code", u1);
                    this.f49479h.Q("INSERT", hashMap, new C0873a(this));
                    return;
                }
                this.f49479h.d(this.f49478g, new d.a.q0.a.u.h.b(iVar.b(), d.a.q0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49484g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f49485h;

        /* renamed from: d.a.q0.a.n.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0874a implements d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f49486a;

            public C0874a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49486a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.h0.j.b
            /* renamed from: b */
            public void a(d.a.q0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    g gVar = this.f49486a;
                    gVar.f49485h.d(gVar.f49484g, bVar);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f49487e;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49487e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.z1.b.f.e.f(this.f49487e.f49485h.i(), d.a.q0.a.h.swan_bookshelf_authorize_fail).F();
                }
            }
        }

        public g(a aVar, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49485h = aVar;
            this.f49482e = jSONArray;
            this.f49483f = str;
            this.f49484g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    int t1 = d.a.q0.a.a2.d.g().r().L().t1();
                    String u1 = d.a.q0.a.a2.d.g().r().L().u1();
                    String D = d.a.q0.a.a2.d.g().r().D();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", D);
                    hashMap.put("contentIds", this.f49482e);
                    hashMap.put("category", this.f49483f);
                    hashMap.put("pkg_type", Integer.valueOf(t1));
                    hashMap.put("version_code", u1);
                    this.f49485h.Q(HttpDelete.METHOD_NAME, hashMap, new C0874a(this));
                    return;
                }
                this.f49485h.d(this.f49484g, new d.a.q0.a.u.h.b(iVar.b(), d.a.q0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f49489b;

        public h(a aVar, String str) {
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
            this.f49489b = aVar;
            this.f49488a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.q0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f49489b.d(this.f49488a, bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49490a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f49491b;

        public i(a aVar, String str) {
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
            this.f49491b = aVar;
            this.f49490a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.q0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f49491b.d(this.f49490a, bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49492e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49493f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49494g;

        public j(a aVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49494g = aVar;
            this.f49492e = z;
            this.f49493f = str;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    if (!this.f49492e) {
                        d.a.q0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.f49494g.d(this.f49493f, new d.a.q0.a.u.h.b(1001, "user is not login"));
                    return;
                }
                if (!this.f49492e) {
                    d.a.q0.a.j2.k.M("success", 10, RetrieveTaskManager.KEY);
                }
                this.f49494g.M(this.f49493f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f49496f;

        public k(a aVar, String str) {
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
            this.f49496f = aVar;
            this.f49495e = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.f49496f.K(str2, this.f49495e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49498f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49499g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f49500h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f49501i;

        /* renamed from: d.a.q0.a.n.b.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnClickListenerC0875a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0875a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d.a.q0.a.a2.d.g().r().T().E();
                }
            }
        }

        public l(a aVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49501i = aVar;
            this.f49497e = str;
            this.f49498f = str2;
            this.f49499g = str3;
            this.f49500h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a aVar = new h.a(this.f49501i.i());
                aVar.V(this.f49497e);
                aVar.x(this.f49498f);
                aVar.y();
                aVar.n(new d.a.q0.a.w2.h.a());
                aVar.m(false);
                aVar.P(this.f49499g, new b(this));
                aVar.C(this.f49500h, new DialogInterface$OnClickListenerC0875a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void C(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            d.a.q0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void D(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            d.a.q0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public d.a.q0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Base", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.q0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.q0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    q0.b0(new e(this));
                    return new d.a.q0.a.u.h.b(1001, "network is not connected");
                } else if (L()) {
                    G();
                    return new d.a.q0.a.u.h.b(10003, d.a.q0.a.e2.c.d.f(10003));
                } else {
                    C(optJSONArray, optString, optString2);
                    return new d.a.q0.a.u.h.b(0);
                }
            }
            return new d.a.q0.a.u.h.b(201, "contentIds is invalid");
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String F(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            switch (str.hashCode()) {
                case -2130463047:
                    if (str.equals("INSERT")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77406376:
                    if (str.equals("QUERY")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1020968928:
                    if (str.equals("UPDATE_READ_TIME")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return null;
                        }
                        return d.a.q0.a.c1.a.n().E();
                    }
                    return d.a.q0.a.c1.a.n().w();
                }
                return d.a.q0.a.c1.a.n().h();
            }
            return d.a.q0.a.c1.a.n().u();
        }
        return (String) invokeL.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.b0(new l(this, i().getString(d.a.q0.a.h.swan_bookshelf_setting_dialog_title), i().getString(d.a.q0.a.h.swan_bookshelf_setting_dialog_content), i().getString(d.a.q0.a.h.swanapp_string_go_settings), i().getString(d.a.q0.a.h.swanapp_close)));
        }
    }

    public final void H(d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> bVar, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (bVar != null) {
                bVar.a(new d.a.q0.a.u.h.b(i2, str));
            }
            if (z) {
                q0.b0(new c(this, str));
            }
        }
    }

    public final void I(d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> bVar, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, bVar, jSONObject, z) == null) {
            if (bVar != null && jSONObject != null) {
                bVar.a(new d.a.q0.a.u.h.b(0, jSONObject));
            }
            if (z) {
                d.a.q0.a.c1.a.e0().b(i());
            }
        }
    }

    public d.a.q0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Base", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f49468d = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.q0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.q0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    q0.b0(new d(this));
                    return new d.a.q0.a.u.h.b(1001, "network is not connected");
                } else if (L()) {
                    G();
                    return new d.a.q0.a.u.h.b(10003, d.a.q0.a.e2.c.d.f(10003));
                } else {
                    D(optJSONArray, f49468d, optString2);
                    return new d.a.q0.a.u.h.b(0);
                }
            }
            return new d.a.q0.a.u.h.b(201, "contentIds is invalid");
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new d.a.q0.a.u.h.b(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    e2.printStackTrace();
                }
            }
            if (i2 == 0) {
                d(str2, new d.a.q0.a.u.h.b(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new d.a.q0.a.u.h.b(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.q0.a.e2.c.f fVar = d.a.q0.a.n1.q.c.a.g(true).get("scope_insert_bookshelf");
            if (fVar != null) {
                return fVar.j < 0 && !fVar.f47631d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            d.a.q0.a.c1.a.e0().d(new k(this, str));
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.q0.a.a2.e r = d.a.q0.a.a2.d.g().r();
            r.j().f(r.x(), null, new j(this, r.j().e(i()), str));
        }
    }

    public d.a.q0.a.u.h.b O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Base", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            f49468d = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(202, "cb is invalid");
            }
            if (!d.a.q0.a.a2.d.g().r().j().e(i())) {
                d.a.q0.a.j2.k.M("show", 10, RetrieveTaskManager.KEY);
                N(optString);
                return new d.a.q0.a.u.h.b(0);
            }
            M(optString);
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Base", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.q0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    return new d.a.q0.a.u.h.b(1001, "network is not connected");
                }
                if (!d.a.q0.a.a2.d.g().r().j().e(i())) {
                    return new d.a.q0.a.u.h.b(1001, "user is not login");
                }
                Object D = d.a.q0.a.a2.d.g().r().D();
                int t1 = d.a.q0.a.a2.d.g().r().L().t1();
                Object u1 = d.a.q0.a.a2.d.g().r().L().u1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", D);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(t1));
                hashMap.put("version_code", u1);
                Q("QUERY", hashMap, new h(this, optString));
                return new d.a.q0.a.u.h.b(0);
            }
            return new d.a.q0.a.u.h.b(201, "contentIds is invalid");
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final void Q(String str, HashMap<String, Object> hashMap, d.a.q0.a.h0.j.b<d.a.q0.a.u.h.b> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, bVar) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    e2.printStackTrace();
                }
            }
            RequestBody create = RequestBody.create(d.a.q0.a.n1.f.f49627a, jSONObject.toString());
            String F = F(str);
            if (TextUtils.isEmpty(F)) {
                H(bVar, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                q0.b0(new RunnableC0870a(this));
            }
            d.a.q0.m.d.a aVar = new d.a.q0.m.d.a(F, create, new b(this, equals, bVar));
            if (d.a.q0.m.e.a.g().c()) {
                aVar.f53900f = true;
            }
            aVar.f53901g = true;
            d.a.q0.m.e.a.g().e(aVar);
        }
    }

    public d.a.q0.a.u.h.b R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Base", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.q0.a.u.h.b(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new d.a.q0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(i())) {
                return new d.a.q0.a.u.h.b(1001, "network is not connected");
            }
            if (!d.a.q0.a.a2.d.g().r().j().e(i())) {
                return new d.a.q0.a.u.h.b(1001, "user is not login");
            }
            Object D = d.a.q0.a.a2.d.g().r().D();
            int t1 = d.a.q0.a.a2.d.g().r().L().t1();
            Object u1 = d.a.q0.a.a2.d.g().r().L().u1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", D);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(t1));
            hashMap.put("version_code", u1);
            Q("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}
