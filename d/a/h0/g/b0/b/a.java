package d.a.h0.g.b0.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.share.QzonePublish;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.z0.f;
import d.a.h0.a.z1.h;
import d.a.h0.g.l.n;
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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46100b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static String f46101c = "";

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.e.d.c f46102a;

    /* renamed from: d.a.h0.g.b0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0923a implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.b0.b.c f46103e;

        public C0923a(d.a.h0.g.b0.b.c cVar) {
            this.f46103e = cVar;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                if (a.f46100b) {
                    Log.d("ShareVideoApi", "login fail");
                }
                a.this.j("shareVideo: fail, no login in");
                return;
            }
            if (a.f46100b) {
                Log.d("ShareVideoApi", "login success");
            }
            a.this.h(this.f46103e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.g.b0.b.b {
        public b() {
        }

        @Override // d.a.h0.g.b0.b.b
        public void a(d.a.h0.g.b0.b.c cVar, String str) {
            if (a.f46100b) {
                Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar, str));
            }
            a.this.j(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Callback {
        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a.f46100b) {
                iOException.printStackTrace();
            }
            a.g();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                if (jSONObject != null) {
                    String unused = a.f46101c = jSONObject.optString("community_id");
                    a.f(jSONObject.optString("url"));
                } else {
                    a.g();
                }
            } catch (JSONException e2) {
                if (a.f46100b) {
                    e2.printStackTrace();
                }
                a.g();
            }
        }
    }

    public a(JsObject jsObject) {
        this.f46102a = d.a.h0.g.e.d.c.F(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        f46101c = "";
    }

    public static void l() {
        d.a.h0.g.w.b V = e.h().V();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put(com.alipay.sdk.cons.b.f1831h, e.T());
        } catch (JSONException e2) {
            if (f46100b) {
                e2.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        V.b(new Request.Builder().url(newBuilder.build()).build(), new c());
    }

    public final void h(d.a.h0.g.b0.b.c cVar) {
        d.a.h0.g.r.a.e().a(cVar, new b());
    }

    public final void i() {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "shareVideo";
        eVar.f45414d = "fail";
        h.j(eVar);
    }

    public final void j(String str) {
        if (this.f46102a == null) {
            return;
        }
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        d.a.h0.g.i0.b.a(this.f46102a, false, bVar);
        i();
    }

    public final d.a.h0.g.b0.b.c k() {
        if (this.f46102a == null) {
            i();
            return null;
        } else if (e.h() == null) {
            j("shareVideo: fail, swanApp is null");
            return null;
        } else {
            String B = this.f46102a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(B)) {
                j("shareVideo: videoPath is invalid");
                return null;
            }
            String y = n.y(B);
            if (TextUtils.isEmpty(y)) {
                j("shareVideo: videoPath is invalid");
                return null;
            }
            d.a.h0.g.b0.b.c cVar = new d.a.h0.g.b0.b.c();
            cVar.f46106a = y;
            cVar.f46108c = this.f46102a.B("title");
            cVar.f46107b = this.f46102a.B("query");
            d dVar = new d();
            dVar.f46111a = this.f46102a.y("clipMaxDuration", 30L);
            dVar.f46112b = this.f46102a.y("clipMinDuration", 3L);
            dVar.f46113c = this.f46102a.B("topicSource");
            dVar.f46114d = this.f46102a.C("publishTitle", d.a.h0.a.w0.a.c().getResources().getString(d.a.h0.a.h.swangame_publish_video));
            dVar.f46115e = this.f46102a.C("publishURL", "/searchbox?action=ugc&cmd=177");
            dVar.f46119i = this.f46102a.s("sourceType", 1);
            dVar.j = this.f46102a.C("sourceFrom", "tiny");
            dVar.f46117g = this.f46102a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
            dVar.f46116f = this.f46102a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
            dVar.f46118h = this.f46102a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
            dVar.k = this.f46102a.C("publishType", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.alipay.sdk.cons.b.f1831h, e.T());
                jSONObject.put("frame_type", d.a.h0.a.r1.d.e().j());
                jSONObject.put("query", cVar.f46107b);
                if (e.h() != null && e.h().L() != null) {
                    jSONObject.put("title", e.h().L().J());
                }
            } catch (JSONException e2) {
                if (f46100b) {
                    Log.d("ShareVideoApi", e2.toString());
                }
            }
            jSONObject.toString();
            if (!TextUtils.isEmpty(f46101c)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", f46101c);
                    if (e.h() != null && e.h().L() != null) {
                        jSONObject2.put("name", e.h().L().J());
                    }
                    jSONObject2.put("type", "interest");
                    jSONObject2.put("post_id", "");
                } catch (JSONException e3) {
                    if (f46100b) {
                        Log.d("ShareVideoApi", e3.toString());
                    }
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("tag", jSONArray);
                } catch (JSONException e4) {
                    if (f46100b) {
                        Log.d("ShareVideoApi", e4.toString());
                    }
                }
                dVar.l = jSONObject3.toString();
                dVar.m = -1;
            } else {
                dVar.m = 0;
            }
            cVar.f46110e = dVar;
            return cVar;
        }
    }

    public void m() {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "shareVideo";
        h.j(eVar);
        d.a.h0.g.b0.b.c k = k();
        if (k == null) {
            return;
        }
        d.a.h0.a.m.b i2 = e.h().i();
        if (i2.e(d.a.h0.a.w0.a.c())) {
            h(k);
            return;
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            j("shareVideo: swanAppActivity is null");
        } else {
            i2.f(activity, null, new C0923a(k));
        }
    }
}
