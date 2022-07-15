package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
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
public class s04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public os1 a;

    /* loaded from: classes7.dex */
    public class a implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u04 a;
        public final /* synthetic */ s04 b;

        public a(s04 s04Var, u04 u04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s04Var, u04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s04Var;
            this.a = u04Var;
        }

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (s04.b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.b.j("shareVideo: fail, no login in");
                    return;
                }
                if (s04.b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.b.h(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements t04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s04 a;

        public b(s04 s04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s04Var;
        }

        @Override // com.repackage.t04
        public void a(u04 u04Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, u04Var, str) == null) {
                if (s04.b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", u04Var, str));
                }
                this.a.j(str);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (s04.b) {
                    iOException.printStackTrace();
                }
                s04.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject != null) {
                        String unused = s04.c = jSONObject.optString("community_id");
                        s04.f(jSONObject.optString("url"));
                        return;
                    }
                    s04.g();
                } catch (JSONException e) {
                    if (s04.b) {
                        e.printStackTrace();
                    }
                    s04.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755374374, "Lcom/repackage/s04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755374374, "Lcom/repackage/s04;");
                return;
            }
        }
        b = rg1.a;
        String str = bx1.c() + "/webpage";
        c = "";
    }

    public s04(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = os1.F(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c = "";
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            ny3 ny3Var = (ny3) h03.M().i0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, h03.g0());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            ny3Var.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(u04 u04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u04Var) == null) {
            xw3.i().a(u04Var, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j73 j73Var = new j73();
            j73Var.b = "shareVideo";
            j73Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            a73.h(j73Var);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a == null) {
            return;
        }
        pu3 pu3Var = new pu3();
        pu3Var.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        s24.call(this.a, false, pu3Var);
        i();
    }

    public final u04 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (h03.M() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = rc2.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                u04 u04Var = new u04();
                u04Var.a = B2;
                u04Var.c = this.a.B("title");
                u04Var.b = this.a.B("query");
                v04 v04Var = new v04();
                v04Var.a = this.a.y("clipMaxDuration", 30L);
                v04Var.b = this.a.y("clipMinDuration", 3L);
                v04Var.c = this.a.B("topicSource");
                v04Var.d = this.a.C("publishTitle", oj2.c().getResources().getString(R.string.obfuscated_res_0x7f0f1349));
                v04Var.e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                v04Var.i = this.a.r("sourceType", 1);
                v04Var.j = this.a.C("sourceFrom", "tiny");
                v04Var.g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                v04Var.f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                v04Var.h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                v04Var.k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, h03.g0());
                    jSONObject.put("frame_type", g03.K().k());
                    jSONObject.put("query", u04Var.b);
                    if (h03.M() != null && h03.M().Y() != null) {
                        jSONObject.put("title", h03.M().Y().K());
                    }
                } catch (JSONException e) {
                    if (b) {
                        Log.d("ShareVideoApi", e.toString());
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", c);
                        if (h03.M() != null && h03.M().Y() != null) {
                            jSONObject2.put("name", h03.M().Y().K());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e2) {
                        if (b) {
                            Log.d("ShareVideoApi", e2.toString());
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e3) {
                        if (b) {
                            Log.d("ShareVideoApi", e3.toString());
                        }
                    }
                    v04Var.l = jSONObject3.toString();
                    v04Var.m = -1;
                } else {
                    v04Var.m = 0;
                }
                u04Var.e = v04Var;
                return u04Var;
            }
        }
        return (u04) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j73 j73Var = new j73();
            j73Var.b = "shareVideo";
            a73.h(j73Var);
            u04 k = k();
            if (k == null) {
                return;
            }
            ug1 N = h03.M().N();
            if (N.e(oj2.c())) {
                h(k);
                return;
            }
            SwanAppActivity activity = ul2.U().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                N.f(activity, null, new a(this, k));
            }
        }
    }
}
