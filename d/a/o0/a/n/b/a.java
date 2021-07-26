package d.a.o0.a.n.b;

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
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.w;
import d.a.o0.a.z1.b.b.h;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f46670d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0828a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46671e;

        public RunnableC0828a(a aVar) {
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
            this.f46671e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.z1.b.f.e f2 = d.a.o0.a.z1.b.f.e.f(this.f46671e.i(), d.a.o0.a.h.swan_bookshelf_insert_async);
                f2.l(10);
                f2.r(false);
                f2.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f46672a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.j.b f46673b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f46674c;

        /* renamed from: d.a.o0.a.n.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0829a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0829a(b bVar) {
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
                    d.a.o0.a.z1.b.f.e.a();
                }
            }
        }

        /* renamed from: d.a.o0.a.n.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0830b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0830b(b bVar) {
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
                    d.a.o0.a.z1.b.f.e.f(d.a.o0.a.c1.a.b(), d.a.o0.a.h.swan_bookshelf_insert_failed).F();
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    d.a.o0.a.z1.b.f.e.a();
                }
            }
        }

        public b(a aVar, boolean z, d.a.o0.a.h0.j.b bVar) {
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
            this.f46674c = aVar;
            this.f46672a = z;
            this.f46673b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.f46672a) {
                    q0.b0(new RunnableC0829a(this));
                }
                if (jSONObject == null) {
                    this.f46674c.H(this.f46673b, 1001, "server response fail", this.f46672a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.f46672a) {
                        q0.b0(new RunnableC0830b(this));
                    }
                    this.f46674c.H(this.f46673b, optInt, jSONObject.optString("errmsg"), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f46674c.H(this.f46673b, 0, jSONObject.optString("errmsg"), this.f46672a);
                } else {
                    this.f46674c.I(this.f46673b, optJSONObject, this.f46672a);
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
                if (this.f46672a) {
                    q0.b0(new c(this));
                }
                a aVar = this.f46674c;
                d.a.o0.a.h0.j.b bVar = this.f46673b;
                aVar.H(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f46672a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46675e;

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
            this.f46675e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.z1.b.f.e.g(d.a.o0.a.c1.a.b(), this.f46675e).F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46676e;

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
            this.f46676e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.z1.b.f.e.f(this.f46676e.i(), d.a.o0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46677e;

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
            this.f46677e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.z1.b.f.e.f(this.f46677e.i(), d.a.o0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f46681h;

        /* renamed from: d.a.o0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0831a implements d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f46682a;

            public C0831a(f fVar) {
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
                this.f46682a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.h0.j.b
            /* renamed from: b */
            public void a(d.a.o0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    f fVar = this.f46682a;
                    fVar.f46681h.d(fVar.f46680g, bVar);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f46683e;

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
                this.f46683e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.a.z1.b.f.e.f(this.f46683e.f46681h.i(), d.a.o0.a.h.swan_bookshelf_authorize_fail).F();
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
            this.f46681h = aVar;
            this.f46678e = jSONArray;
            this.f46679f = str;
            this.f46680g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    int t1 = d.a.o0.a.a2.d.g().r().L().t1();
                    String u1 = d.a.o0.a.a2.d.g().r().L().u1();
                    String D = d.a.o0.a.a2.d.g().r().D();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", D);
                    hashMap.put("contentIds", this.f46678e);
                    hashMap.put("category", this.f46679f);
                    hashMap.put("pkg_type", Integer.valueOf(t1));
                    hashMap.put("version_code", u1);
                    this.f46681h.Q("INSERT", hashMap, new C0831a(this));
                    return;
                }
                this.f46681h.d(this.f46680g, new d.a.o0.a.u.h.b(iVar.b(), d.a.o0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46684e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46685f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46686g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f46687h;

        /* renamed from: d.a.o0.a.n.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0832a implements d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f46688a;

            public C0832a(g gVar) {
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
                this.f46688a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.h0.j.b
            /* renamed from: b */
            public void a(d.a.o0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    g gVar = this.f46688a;
                    gVar.f46687h.d(gVar.f46686g, bVar);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f46689e;

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
                this.f46689e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.a.z1.b.f.e.f(this.f46689e.f46687h.i(), d.a.o0.a.h.swan_bookshelf_authorize_fail).F();
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
            this.f46687h = aVar;
            this.f46684e = jSONArray;
            this.f46685f = str;
            this.f46686g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    int t1 = d.a.o0.a.a2.d.g().r().L().t1();
                    String u1 = d.a.o0.a.a2.d.g().r().L().u1();
                    String D = d.a.o0.a.a2.d.g().r().D();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", D);
                    hashMap.put("contentIds", this.f46684e);
                    hashMap.put("category", this.f46685f);
                    hashMap.put("pkg_type", Integer.valueOf(t1));
                    hashMap.put("version_code", u1);
                    this.f46687h.Q(HttpDelete.METHOD_NAME, hashMap, new C0832a(this));
                    return;
                }
                this.f46687h.d(this.f46686g, new d.a.o0.a.u.h.b(iVar.b(), d.a.o0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46690a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f46691b;

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
            this.f46691b = aVar;
            this.f46690a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.o0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f46691b.d(this.f46690a, bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46692a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f46693b;

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
            this.f46693b = aVar;
            this.f46692a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.o0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f46693b.d(this.f46692a, bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46695f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f46696g;

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
            this.f46696g = aVar;
            this.f46694e = z;
            this.f46695f = str;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    if (!this.f46694e) {
                        d.a.o0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.f46696g.d(this.f46695f, new d.a.o0.a.u.h.b(1001, "user is not login"));
                    return;
                }
                if (!this.f46694e) {
                    d.a.o0.a.j2.k.M("success", 10, RetrieveTaskManager.KEY);
                }
                this.f46696g.M(this.f46695f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46698f;

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
            this.f46698f = aVar;
            this.f46697e = str;
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
                this.f46698f.K(str2, this.f46697e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46701g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46702h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f46703i;

        /* renamed from: d.a.o0.a.n.b.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnClickListenerC0833a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0833a(l lVar) {
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

        /* loaded from: classes7.dex */
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
                    d.a.o0.a.a2.d.g().r().T().E();
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
            this.f46703i = aVar;
            this.f46699e = str;
            this.f46700f = str2;
            this.f46701g = str3;
            this.f46702h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a aVar = new h.a(this.f46703i.i());
                aVar.V(this.f46699e);
                aVar.x(this.f46700f);
                aVar.y();
                aVar.n(new d.a.o0.a.w2.h.a());
                aVar.m(false);
                aVar.P(this.f46701g, new b(this));
                aVar.C(this.f46702h, new DialogInterface$OnClickListenerC0833a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.o0.a.u.c.b bVar) {
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
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void C(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            d.a.o0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void D(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            d.a.o0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public d.a.o0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Base", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.o0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    q0.b0(new e(this));
                    return new d.a.o0.a.u.h.b(1001, "network is not connected");
                } else if (L()) {
                    G();
                    return new d.a.o0.a.u.h.b(10003, d.a.o0.a.e2.c.d.f(10003));
                } else {
                    C(optJSONArray, optString, optString2);
                    return new d.a.o0.a.u.h.b(0);
                }
            }
            return new d.a.o0.a.u.h.b(201, "contentIds is invalid");
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
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
                        return d.a.o0.a.c1.a.n().E();
                    }
                    return d.a.o0.a.c1.a.n().w();
                }
                return d.a.o0.a.c1.a.n().h();
            }
            return d.a.o0.a.c1.a.n().u();
        }
        return (String) invokeL.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.b0(new l(this, i().getString(d.a.o0.a.h.swan_bookshelf_setting_dialog_title), i().getString(d.a.o0.a.h.swan_bookshelf_setting_dialog_content), i().getString(d.a.o0.a.h.swanapp_string_go_settings), i().getString(d.a.o0.a.h.swanapp_close)));
        }
    }

    public final void H(d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> bVar, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (bVar != null) {
                bVar.a(new d.a.o0.a.u.h.b(i2, str));
            }
            if (z) {
                q0.b0(new c(this, str));
            }
        }
    }

    public final void I(d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> bVar, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, bVar, jSONObject, z) == null) {
            if (bVar != null && jSONObject != null) {
                bVar.a(new d.a.o0.a.u.h.b(0, jSONObject));
            }
            if (z) {
                d.a.o0.a.c1.a.e0().b(i());
            }
        }
    }

    public d.a.o0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Base", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f46670d = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.o0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    q0.b0(new d(this));
                    return new d.a.o0.a.u.h.b(1001, "network is not connected");
                } else if (L()) {
                    G();
                    return new d.a.o0.a.u.h.b(10003, d.a.o0.a.e2.c.d.f(10003));
                } else {
                    D(optJSONArray, f46670d, optString2);
                    return new d.a.o0.a.u.h.b(0);
                }
            }
            return new d.a.o0.a.u.h.b(201, "contentIds is invalid");
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new d.a.o0.a.u.h.b(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    e2.printStackTrace();
                }
            }
            if (i2 == 0) {
                d(str2, new d.a.o0.a.u.h.b(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new d.a.o0.a.u.h.b(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.o0.a.e2.c.f fVar = d.a.o0.a.n1.q.c.a.g(true).get("scope_insert_bookshelf");
            if (fVar != null) {
                return fVar.j < 0 && !fVar.f44833d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            d.a.o0.a.c1.a.e0().d(new k(this, str));
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.o0.a.a2.e r = d.a.o0.a.a2.d.g().r();
            r.j().f(r.x(), null, new j(this, r.j().e(i()), str));
        }
    }

    public d.a.o0.a.u.h.b O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Base", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            f46670d = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.o0.a.u.h.b(202, "cb is invalid");
            }
            if (!d.a.o0.a.a2.d.g().r().j().e(i())) {
                d.a.o0.a.j2.k.M("show", 10, RetrieveTaskManager.KEY);
                N(optString);
                return new d.a.o0.a.u.h.b(0);
            }
            M(optString);
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Base", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    return new d.a.o0.a.u.h.b(1001, "network is not connected");
                }
                if (!d.a.o0.a.a2.d.g().r().j().e(i())) {
                    return new d.a.o0.a.u.h.b(1001, "user is not login");
                }
                Object D = d.a.o0.a.a2.d.g().r().D();
                int t1 = d.a.o0.a.a2.d.g().r().L().t1();
                Object u1 = d.a.o0.a.a2.d.g().r().L().u1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", D);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(t1));
                hashMap.put("version_code", u1);
                Q("QUERY", hashMap, new h(this, optString));
                return new d.a.o0.a.u.h.b(0);
            }
            return new d.a.o0.a.u.h.b(201, "contentIds is invalid");
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void Q(String str, HashMap<String, Object> hashMap, d.a.o0.a.h0.j.b<d.a.o0.a.u.h.b> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, bVar) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    e2.printStackTrace();
                }
            }
            RequestBody create = RequestBody.create(d.a.o0.a.n1.f.f46829a, jSONObject.toString());
            String F = F(str);
            if (TextUtils.isEmpty(F)) {
                H(bVar, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                q0.b0(new RunnableC0828a(this));
            }
            d.a.o0.m.d.a aVar = new d.a.o0.m.d.a(F, create, new b(this, equals, bVar));
            if (d.a.o0.m.e.a.g().c()) {
                aVar.f51102f = true;
            }
            aVar.f51103g = true;
            d.a.o0.m.e.a.g().e(aVar);
        }
    }

    public d.a.o0.a.u.h.b R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Base", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.o0.a.u.h.b(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.o0.a.u.h.b(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new d.a.o0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(i())) {
                return new d.a.o0.a.u.h.b(1001, "network is not connected");
            }
            if (!d.a.o0.a.a2.d.g().r().j().e(i())) {
                return new d.a.o0.a.u.h.b(1001, "user is not login");
            }
            Object D = d.a.o0.a.a2.d.g().r().D();
            int t1 = d.a.o0.a.a2.d.g().r().L().t1();
            Object u1 = d.a.o0.a.a2.d.g().r().L().u1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", D);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(t1));
            hashMap.put("version_code", u1);
            Q("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
