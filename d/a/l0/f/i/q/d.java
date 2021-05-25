package d.a.l0.f.i.q;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.qq.e.comm.constants.Constants;
import d.a.l0.f.i.l.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.l0.f.i.k.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.f.i.l.d f46826a;

        public a(d.a.l0.f.i.l.d dVar) {
            this.f46826a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.l0.f.i.k.a aVar, int i2) {
            d.a.l0.f.i.l.d dVar;
            if (aVar == null || (dVar = this.f46826a) == null) {
                return;
            }
            dVar.d(aVar.f46706a, aVar.f46707b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.l0.f.i.k.a parseResponse(Response response, int i2) {
            JSONObject optJSONObject;
            if (response == null || response.body() == null || !response.isSuccessful()) {
                return null;
            }
            try {
                String string = response.body().string();
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        if (TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            d.a.l0.f.i.k.a aVar = new d.a.l0.f.i.k.a();
                            aVar.f46706a = optJSONObject.optString("clickid");
                            aVar.f46707b = optJSONObject.optString("dstlink");
                            return aVar;
                        }
                        return null;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
            return null;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    public static void a(d.a.l0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar, d.a.l0.f.i.l.d dVar) {
        if (adElementInfo == null || TextUtils.isEmpty(adElementInfo.l())) {
            return;
        }
        String c2 = c(adElementInfo.l(), aVar);
        a aVar2 = new a(dVar);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || gVar == null) {
            return;
        }
        gVar.b(c2, aVar2);
    }

    public static void b(String str, g gVar) {
        gVar.d(str);
    }

    public static String c(String str, d.a.l0.f.i.q.a aVar) {
        return aVar == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", aVar.f46815a).replaceAll("\\{REQ_HEIGHT\\}", aVar.f46816b).replaceAll("\\{WIDTH\\}", aVar.f46817c).replaceAll("\\{HEIGHT\\}", aVar.f46818d).replaceAll("\\{DOWN_X\\}", aVar.f46819e).replaceAll("\\{DOWN_Y\\}", aVar.f46820f).replaceAll("\\{UP_X\\}", aVar.f46821g).replaceAll("\\{UP_Y\\}", aVar.f46822h).replaceAll("\\{VIDEO_TIME\\}", aVar.f46823i).replaceAll("\\{BEGIN_TIME\\}", aVar.j).replaceAll("\\{END_TIME\\}", aVar.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", aVar.l).replaceAll("\\{PLAY_LAST_FRAME\\}", aVar.m).replaceAll("\\{SCENE\\}", aVar.n).replaceAll("\\{TYPE\\}", aVar.o).replaceAll("\\{BEHAVIOR\\}", aVar.p).replaceAll("\\{STATUS\\}", aVar.q).replaceAll("\\{CONVERSION_ACTION\\}", aVar.r).replaceAll("\\{CLICK_ID\\}", aVar.s);
    }

    public static void d(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            b(c(str, null), gVar);
        }
    }

    public static void e(d.a.l0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.o()) {
            b(c(str, aVar), gVar);
        }
    }

    public static void f(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.w()) {
            b(c(str, null), gVar);
        }
    }

    public static void g(d.a.l0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.m()) {
            b(c(str, aVar), gVar);
        }
    }
}
