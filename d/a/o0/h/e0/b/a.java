package d.a.o0.h.e0.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import d.a.o0.a.a2.e;
import d.a.o0.a.g1.f;
import d.a.o0.a.k;
import d.a.o0.a.r0.n;
import d.a.o0.f.g;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50445b;

    /* renamed from: c  reason: collision with root package name */
    public static String f50446c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.y.b.a f50447a;

    /* renamed from: d.a.o0.h.e0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1098a implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.e0.b.c f50448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50449f;

        public C1098a(a aVar, d.a.o0.h.e0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50449f = aVar;
            this.f50448e = cVar;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    if (a.f50445b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.f50449f.j("shareVideo: fail, no login in");
                    return;
                }
                if (a.f50445b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.f50449f.h(this.f50448e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.h.e0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50450a;

        public b(a aVar) {
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
            this.f50450a = aVar;
        }

        @Override // d.a.o0.h.e0.b.b
        public void a(d.a.o0.h.e0.b.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
                if (a.f50445b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar, str));
                }
                this.f50450a.j(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (a.f50445b) {
                    iOException.printStackTrace();
                }
                a.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject != null) {
                        String unused = a.f50446c = jSONObject.optString("community_id");
                        a.f(jSONObject.optString("url"));
                        return;
                    }
                    a.g();
                } catch (JSONException e2) {
                    if (a.f50445b) {
                        e2.printStackTrace();
                    }
                    a.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1982687589, "Ld/a/o0/h/e0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1982687589, "Ld/a/o0/h/e0/b/a;");
                return;
            }
        }
        f50445b = k.f46335a;
        String str = d.a.o0.a.d0.a.c() + "/webpage";
        f50446c = "";
    }

    public a(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50447a = d.a.o0.a.y.b.a.G(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            f50446c = "";
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            d.a.o0.h.y.b bVar = (d.a.o0.h.y.b) e.i().X();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put("app_key", e.V());
            } catch (JSONException e2) {
                if (f50445b) {
                    e2.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            bVar.b(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(d.a.o0.h.e0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            d.a.o0.h.t.a.h().a(cVar, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.o0.a.j2.p.e eVar = new d.a.o0.a.j2.p.e();
            eVar.f46322b = "shareVideo";
            eVar.f46325e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            d.a.o0.a.j2.k.h(eVar);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f50447a == null) {
            return;
        }
        d.a.o0.h.d.c.b bVar = new d.a.o0.h.d.c.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        d.a.o0.h.m0.c.a(this.f50447a, false, bVar);
        i();
    }

    public final d.a.o0.h.e0.b.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f50447a == null) {
                i();
                return null;
            } else if (e.i() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String C = this.f50447a.C(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(C)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String y = n.y(C);
                if (TextUtils.isEmpty(y)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                d.a.o0.h.e0.b.c cVar = new d.a.o0.h.e0.b.c();
                cVar.f50451a = y;
                cVar.f50453c = this.f50447a.C("title");
                cVar.f50452b = this.f50447a.C("query");
                d dVar = new d();
                dVar.f50456a = this.f50447a.z("clipMaxDuration", 30L);
                dVar.f50457b = this.f50447a.z("clipMinDuration", 3L);
                dVar.f50458c = this.f50447a.C("topicSource");
                dVar.f50459d = this.f50447a.D("publishTitle", d.a.o0.a.c1.a.b().getResources().getString(g.swangame_publish_video));
                dVar.f50460e = this.f50447a.D("publishURL", "/searchbox?action=ugc&cmd=177");
                dVar.f50464i = this.f50447a.s("sourceType", 1);
                dVar.j = this.f50447a.D("sourceFrom", "tiny");
                dVar.f50462g = this.f50447a.D("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                dVar.f50461f = this.f50447a.D("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                dVar.f50463h = this.f50447a.D("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                dVar.k = this.f50447a.D("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("app_key", e.V());
                    jSONObject.put("frame_type", d.a.o0.a.a2.d.g().l());
                    jSONObject.put("query", cVar.f50452b);
                    if (e.i() != null && e.i().N() != null) {
                        jSONObject.put("title", e.i().N().K());
                    }
                } catch (JSONException e2) {
                    if (f50445b) {
                        Log.d("ShareVideoApi", e2.toString());
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(f50446c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", f50446c);
                        if (e.i() != null && e.i().N() != null) {
                            jSONObject2.put("name", e.i().N().K());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e3) {
                        if (f50445b) {
                            Log.d("ShareVideoApi", e3.toString());
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e4) {
                        if (f50445b) {
                            Log.d("ShareVideoApi", e4.toString());
                        }
                    }
                    dVar.l = jSONObject3.toString();
                    dVar.m = -1;
                } else {
                    dVar.m = 0;
                }
                cVar.f50455e = dVar;
                return cVar;
            }
        }
        return (d.a.o0.h.e0.b.c) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.o0.a.j2.p.e eVar = new d.a.o0.a.j2.p.e();
            eVar.f46322b = "shareVideo";
            d.a.o0.a.j2.k.h(eVar);
            d.a.o0.h.e0.b.c k = k();
            if (k == null) {
                return;
            }
            d.a.o0.a.m.b j = e.i().j();
            if (j.e(d.a.o0.a.c1.a.b())) {
                h(k);
                return;
            }
            SwanAppActivity activity = f.V().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                j.f(activity, null, new C1098a(this, k));
            }
        }
    }
}
