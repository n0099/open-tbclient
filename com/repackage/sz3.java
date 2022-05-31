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
public class sz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public or1 a;

    /* loaded from: classes7.dex */
    public class a implements tf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ sz3 b;

        public a(sz3 sz3Var, uz3 uz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz3Var, uz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sz3Var;
            this.a = uz3Var;
        }

        @Override // com.repackage.tf1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (sz3.b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.b.j("shareVideo: fail, no login in");
                    return;
                }
                if (sz3.b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.b.h(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz3 a;

        public b(sz3 sz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz3Var;
        }

        @Override // com.repackage.tz3
        public void a(uz3 uz3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, uz3Var, str) == null) {
                if (sz3.b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", uz3Var, str));
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
                if (sz3.b) {
                    iOException.printStackTrace();
                }
                sz3.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject != null) {
                        String unused = sz3.c = jSONObject.optString("community_id");
                        sz3.f(jSONObject.optString("url"));
                        return;
                    }
                    sz3.g();
                } catch (JSONException e) {
                    if (sz3.b) {
                        e.printStackTrace();
                    }
                    sz3.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755303291, "Lcom/repackage/sz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755303291, "Lcom/repackage/sz3;");
                return;
            }
        }
        b = rf1.a;
        String str = bw1.c() + "/webpage";
        c = "";
    }

    public sz3(JsObject jsObject) {
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
        this.a = or1.F(jsObject);
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
            nx3 nx3Var = (nx3) hz2.L().h0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, hz2.f0());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            nx3Var.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(uz3 uz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uz3Var) == null) {
            xv3.i().a(uz3Var, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j63 j63Var = new j63();
            j63Var.b = "shareVideo";
            j63Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            a63.h(j63Var);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a == null) {
            return;
        }
        pt3 pt3Var = new pt3();
        pt3Var.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        s14.call(this.a, false, pt3Var);
        i();
    }

    public final uz3 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (hz2.L() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = rb2.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                uz3 uz3Var = new uz3();
                uz3Var.a = B2;
                uz3Var.c = this.a.B("title");
                uz3Var.b = this.a.B("query");
                vz3 vz3Var = new vz3();
                vz3Var.a = this.a.y("clipMaxDuration", 30L);
                vz3Var.b = this.a.y("clipMinDuration", 3L);
                vz3Var.c = this.a.B("topicSource");
                vz3Var.d = this.a.C("publishTitle", oi2.c().getResources().getString(R.string.obfuscated_res_0x7f0f1343));
                vz3Var.e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                vz3Var.i = this.a.r("sourceType", 1);
                vz3Var.j = this.a.C("sourceFrom", "tiny");
                vz3Var.g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                vz3Var.f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                vz3Var.h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                vz3Var.k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, hz2.f0());
                    jSONObject.put("frame_type", gz2.J().l());
                    jSONObject.put("query", uz3Var.b);
                    if (hz2.L() != null && hz2.L().X() != null) {
                        jSONObject.put("title", hz2.L().X().K());
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
                        if (hz2.L() != null && hz2.L().X() != null) {
                            jSONObject2.put("name", hz2.L().X().K());
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
                    vz3Var.l = jSONObject3.toString();
                    vz3Var.m = -1;
                } else {
                    vz3Var.m = 0;
                }
                uz3Var.e = vz3Var;
                return uz3Var;
            }
        }
        return (uz3) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j63 j63Var = new j63();
            j63Var.b = "shareVideo";
            a63.h(j63Var);
            uz3 k = k();
            if (k == null) {
                return;
            }
            uf1 M = hz2.L().M();
            if (M.e(oi2.c())) {
                h(k);
                return;
            }
            SwanAppActivity activity = uk2.U().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                M.f(activity, null, new a(this, k));
            }
        }
    }
}
