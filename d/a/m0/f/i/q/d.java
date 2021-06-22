package d.a.m0.f.i.q;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.qq.e.comm.constants.Constants;
import d.a.m0.f.i.l.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.m0.f.i.k.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.f.i.l.d f50608a;

        public a(d.a.m0.f.i.l.d dVar) {
            this.f50608a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.m0.f.i.k.a aVar, int i2) {
            d.a.m0.f.i.l.d dVar;
            if (aVar == null || (dVar = this.f50608a) == null) {
                return;
            }
            dVar.d(aVar.f50488a, aVar.f50489b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.m0.f.i.k.a parseResponse(Response response, int i2) {
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
                            d.a.m0.f.i.k.a aVar = new d.a.m0.f.i.k.a();
                            aVar.f50488a = optJSONObject.optString("clickid");
                            aVar.f50489b = optJSONObject.optString("dstlink");
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

    public static void a(d.a.m0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar, d.a.m0.f.i.l.d dVar) {
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

    public static String c(String str, d.a.m0.f.i.q.a aVar) {
        return aVar == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", aVar.f50597a).replaceAll("\\{REQ_HEIGHT\\}", aVar.f50598b).replaceAll("\\{WIDTH\\}", aVar.f50599c).replaceAll("\\{HEIGHT\\}", aVar.f50600d).replaceAll("\\{DOWN_X\\}", aVar.f50601e).replaceAll("\\{DOWN_Y\\}", aVar.f50602f).replaceAll("\\{UP_X\\}", aVar.f50603g).replaceAll("\\{UP_Y\\}", aVar.f50604h).replaceAll("\\{VIDEO_TIME\\}", aVar.f50605i).replaceAll("\\{BEGIN_TIME\\}", aVar.j).replaceAll("\\{END_TIME\\}", aVar.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", aVar.l).replaceAll("\\{PLAY_LAST_FRAME\\}", aVar.m).replaceAll("\\{SCENE\\}", aVar.n).replaceAll("\\{TYPE\\}", aVar.o).replaceAll("\\{BEHAVIOR\\}", aVar.p).replaceAll("\\{STATUS\\}", aVar.q).replaceAll("\\{CONVERSION_ACTION\\}", aVar.r).replaceAll("\\{CLICK_ID\\}", aVar.s);
    }

    public static void d(AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            b(c(str, null), gVar);
        }
    }

    public static void e(d.a.m0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar) {
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

    public static void g(d.a.m0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.m()) {
            b(c(str, aVar), gVar);
        }
    }
}
