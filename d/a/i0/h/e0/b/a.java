package d.a.i0.h.e0.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.share.QzonePublish;
import d.a.i0.a.a2.e;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.a.r0.n;
import d.a.i0.f.g;
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
    public static final boolean f47139b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static String f47140c = "";

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.y.b.a f47141a;

    /* renamed from: d.a.i0.h.e0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1010a implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.e0.b.c f47142e;

        public C1010a(d.a.i0.h.e0.b.c cVar) {
            this.f47142e = cVar;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                if (a.f47139b) {
                    Log.d("ShareVideoApi", "login fail");
                }
                a.this.j("shareVideo: fail, no login in");
                return;
            }
            if (a.f47139b) {
                Log.d("ShareVideoApi", "login success");
            }
            a.this.h(this.f47142e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.h.e0.b.b {
        public b() {
        }

        @Override // d.a.i0.h.e0.b.b
        public void a(d.a.i0.h.e0.b.c cVar, String str) {
            if (a.f47139b) {
                Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar, str));
            }
            a.this.j(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Callback {
        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a.f47139b) {
                iOException.printStackTrace();
            }
            a.g();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                if (jSONObject != null) {
                    String unused = a.f47140c = jSONObject.optString("community_id");
                    a.f(jSONObject.optString("url"));
                } else {
                    a.g();
                }
            } catch (JSONException e2) {
                if (a.f47139b) {
                    e2.printStackTrace();
                }
                a.g();
            }
        }
    }

    static {
        r0 = d.a.i0.a.d0.a.c() + "/webpage";
    }

    public a(JsObject jsObject) {
        this.f47141a = d.a.i0.a.y.b.a.G(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        f47140c = "";
    }

    public static void l() {
        d.a.i0.h.y.b bVar = (d.a.i0.h.y.b) e.i().X();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", e.V());
        } catch (JSONException e2) {
            if (f47139b) {
                e2.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        bVar.b(new Request.Builder().url(newBuilder.build()).build(), new c());
    }

    public final void h(d.a.i0.h.e0.b.c cVar) {
        d.a.i0.h.t.a.h().a(cVar, new b());
    }

    public final void i() {
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = "shareVideo";
        eVar.f43015e = "fail";
        d.a.i0.a.j2.k.h(eVar);
    }

    public final void j(String str) {
        if (this.f47141a == null) {
            return;
        }
        d.a.i0.h.d.c.b bVar = new d.a.i0.h.d.c.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        d.a.i0.h.m0.c.a(this.f47141a, false, bVar);
        i();
    }

    public final d.a.i0.h.e0.b.c k() {
        if (this.f47141a == null) {
            i();
            return null;
        } else if (e.i() == null) {
            j("shareVideo: fail, swanApp is null");
            return null;
        } else {
            String C = this.f47141a.C(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(C)) {
                j("shareVideo: videoPath is invalid");
                return null;
            }
            String y = n.y(C);
            if (TextUtils.isEmpty(y)) {
                j("shareVideo: videoPath is invalid");
                return null;
            }
            d.a.i0.h.e0.b.c cVar = new d.a.i0.h.e0.b.c();
            cVar.f47145a = y;
            cVar.f47147c = this.f47141a.C("title");
            cVar.f47146b = this.f47141a.C("query");
            d dVar = new d();
            dVar.f47150a = this.f47141a.z("clipMaxDuration", 30L);
            dVar.f47151b = this.f47141a.z("clipMinDuration", 3L);
            dVar.f47152c = this.f47141a.C("topicSource");
            dVar.f47153d = this.f47141a.D("publishTitle", d.a.i0.a.c1.a.b().getResources().getString(g.swangame_publish_video));
            dVar.f47154e = this.f47141a.D("publishURL", "/searchbox?action=ugc&cmd=177");
            dVar.f47158i = this.f47141a.s("sourceType", 1);
            dVar.j = this.f47141a.D("sourceFrom", "tiny");
            dVar.f47156g = this.f47141a.D("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
            dVar.f47155f = this.f47141a.D("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
            dVar.f47157h = this.f47141a.D("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
            dVar.k = this.f47141a.D("publishType", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_key", e.V());
                jSONObject.put("frame_type", d.a.i0.a.a2.d.g().l());
                jSONObject.put("query", cVar.f47146b);
                if (e.i() != null && e.i().N() != null) {
                    jSONObject.put("title", e.i().N().K());
                }
            } catch (JSONException e2) {
                if (f47139b) {
                    Log.d("ShareVideoApi", e2.toString());
                }
            }
            jSONObject.toString();
            if (!TextUtils.isEmpty(f47140c)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", f47140c);
                    if (e.i() != null && e.i().N() != null) {
                        jSONObject2.put("name", e.i().N().K());
                    }
                    jSONObject2.put("type", "interest");
                    jSONObject2.put("post_id", "");
                } catch (JSONException e3) {
                    if (f47139b) {
                        Log.d("ShareVideoApi", e3.toString());
                    }
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("tag", jSONArray);
                } catch (JSONException e4) {
                    if (f47139b) {
                        Log.d("ShareVideoApi", e4.toString());
                    }
                }
                dVar.l = jSONObject3.toString();
                dVar.m = -1;
            } else {
                dVar.m = 0;
            }
            cVar.f47149e = dVar;
            return cVar;
        }
    }

    public void m() {
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = "shareVideo";
        d.a.i0.a.j2.k.h(eVar);
        d.a.i0.h.e0.b.c k = k();
        if (k == null) {
            return;
        }
        d.a.i0.a.m.b j = e.i().j();
        if (j.e(d.a.i0.a.c1.a.b())) {
            h(k);
            return;
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            j("shareVideo: swanAppActivity is null");
        } else {
            j.f(activity, null, new C1010a(k));
        }
    }
}
