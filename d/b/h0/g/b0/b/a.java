package d.b.h0.g.b0.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.share.QzonePublish;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.z0.f;
import d.b.h0.a.z1.h;
import d.b.h0.g.l.n;
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
    public static final boolean f48636b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static String f48637c = "";

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.e.d.c f48638a;

    /* renamed from: d.b.h0.g.b0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0984a implements d.b.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.b0.b.c f48639e;

        public C0984a(d.b.h0.g.b0.b.c cVar) {
            this.f48639e = cVar;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                if (a.f48636b) {
                    Log.d("ShareVideoApi", "login fail");
                }
                a.this.j("shareVideo: fail, no login in");
                return;
            }
            if (a.f48636b) {
                Log.d("ShareVideoApi", "login success");
            }
            a.this.h(this.f48639e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.g.b0.b.b {
        public b() {
        }

        @Override // d.b.h0.g.b0.b.b
        public void a(d.b.h0.g.b0.b.c cVar, String str) {
            if (a.f48636b) {
                Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar, str));
            }
            a.this.j(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Callback {
        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a.f48636b) {
                iOException.printStackTrace();
            }
            a.g();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                if (jSONObject != null) {
                    String unused = a.f48637c = jSONObject.optString("community_id");
                    a.f(jSONObject.optString("url"));
                } else {
                    a.g();
                }
            } catch (JSONException e2) {
                if (a.f48636b) {
                    e2.printStackTrace();
                }
                a.g();
            }
        }
    }

    public a(JsObject jsObject) {
        this.f48638a = d.b.h0.g.e.d.c.F(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        f48637c = "";
    }

    public static void l() {
        d.b.h0.g.w.b V = e.y().V();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put(com.alipay.sdk.cons.b.f1883h, e.T());
        } catch (JSONException e2) {
            if (f48636b) {
                e2.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        V.b(new Request.Builder().url(newBuilder.build()).build(), new c());
    }

    public final void h(d.b.h0.g.b0.b.c cVar) {
        d.b.h0.g.r.a.e().a(cVar, new b());
    }

    public final void i() {
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = "shareVideo";
        eVar.f47975d = "fail";
        h.j(eVar);
    }

    public final void j(String str) {
        if (this.f48638a == null) {
            return;
        }
        d.b.h0.g.e.d.b bVar = new d.b.h0.g.e.d.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        d.b.h0.g.i0.b.a(this.f48638a, false, bVar);
        i();
    }

    public final d.b.h0.g.b0.b.c k() {
        if (this.f48638a == null) {
            i();
            return null;
        } else if (e.y() == null) {
            j("shareVideo: fail, swanApp is null");
            return null;
        } else {
            String B = this.f48638a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(B)) {
                j("shareVideo: videoPath is invalid");
                return null;
            }
            String y = n.y(B);
            if (TextUtils.isEmpty(y)) {
                j("shareVideo: videoPath is invalid");
                return null;
            }
            d.b.h0.g.b0.b.c cVar = new d.b.h0.g.b0.b.c();
            cVar.f48642a = y;
            cVar.f48644c = this.f48638a.B("title");
            cVar.f48643b = this.f48638a.B("query");
            d dVar = new d();
            dVar.f48647a = this.f48638a.y("clipMaxDuration", 30L);
            dVar.f48648b = this.f48638a.y("clipMinDuration", 3L);
            dVar.f48649c = this.f48638a.B("topicSource");
            dVar.f48650d = this.f48638a.C("publishTitle", d.b.h0.a.w0.a.c().getResources().getString(d.b.h0.a.h.swangame_publish_video));
            dVar.f48651e = this.f48638a.C("publishURL", "/searchbox?action=ugc&cmd=177");
            dVar.i = this.f48638a.s("sourceType", 1);
            dVar.j = this.f48638a.C("sourceFrom", "tiny");
            dVar.f48653g = this.f48638a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
            dVar.f48652f = this.f48638a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
            dVar.f48654h = this.f48638a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
            dVar.k = this.f48638a.C("publishType", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.alipay.sdk.cons.b.f1883h, e.T());
                jSONObject.put("frame_type", d.b.h0.a.r1.d.e().h());
                jSONObject.put("query", cVar.f48643b);
                if (e.y() != null && e.y().L() != null) {
                    jSONObject.put("title", e.y().L().J());
                }
            } catch (JSONException e2) {
                if (f48636b) {
                    Log.d("ShareVideoApi", e2.toString());
                }
            }
            jSONObject.toString();
            if (!TextUtils.isEmpty(f48637c)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", f48637c);
                    if (e.y() != null && e.y().L() != null) {
                        jSONObject2.put("name", e.y().L().J());
                    }
                    jSONObject2.put("type", "interest");
                    jSONObject2.put("post_id", "");
                } catch (JSONException e3) {
                    if (f48636b) {
                        Log.d("ShareVideoApi", e3.toString());
                    }
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("tag", jSONArray);
                } catch (JSONException e4) {
                    if (f48636b) {
                        Log.d("ShareVideoApi", e4.toString());
                    }
                }
                dVar.l = jSONObject3.toString();
                dVar.m = -1;
            } else {
                dVar.m = 0;
            }
            cVar.f48646e = dVar;
            return cVar;
        }
    }

    public void m() {
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = "shareVideo";
        h.j(eVar);
        d.b.h0.g.b0.b.c k = k();
        if (k == null) {
            return;
        }
        d.b.h0.a.m.b z = e.y().z();
        if (z.e(d.b.h0.a.w0.a.c())) {
            h(k);
            return;
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            j("shareVideo: swanAppActivity is null");
        } else {
            z.f(activity, null, new C0984a(k));
        }
    }
}
