package d.b.g0.e.a.p;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.qq.e.comm.constants.Constants;
import d.b.g0.e.a.m.e;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.b.g0.e.a.p.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.e.a.m.d f47678a;

        public a(d.b.g0.e.a.m.d dVar) {
            this.f47678a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.e.a.p.a aVar, int i) {
            d.b.g0.e.a.m.d dVar;
            if (aVar == null || (dVar = this.f47678a) == null) {
                return;
            }
            dVar.a(aVar.f47668a, aVar.f47669b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.g0.e.a.p.a parseResponse(Response response, int i) {
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
                            d.b.g0.e.a.p.a aVar = new d.b.g0.e.a.p.a();
                            aVar.f47668a = optJSONObject.optString("clickid");
                            aVar.f47669b = optJSONObject.optString("dstlink");
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

    public static void a(b bVar, AdElementInfo adElementInfo, e eVar, d.b.g0.e.a.m.d dVar) {
        if (adElementInfo == null || TextUtils.isEmpty(adElementInfo.l())) {
            return;
        }
        String c2 = c(adElementInfo.l(), bVar);
        a aVar = new a(dVar);
        if (!SwanAppNetworkUtils.h(AppRuntime.getAppContext()) || eVar == null) {
            return;
        }
        eVar.b(c2, aVar);
    }

    public static void b(String str, e eVar) {
        eVar.d(str);
    }

    public static String c(String str, b bVar) {
        return bVar == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", bVar.f47670a).replaceAll("\\{REQ_HEIGHT\\}", bVar.f47671b).replaceAll("\\{WIDTH\\}", bVar.f47672c).replaceAll("\\{HEIGHT\\}", bVar.f47673d).replaceAll("\\{DOWN_X\\}", bVar.f47674e).replaceAll("\\{DOWN_Y\\}", bVar.f47675f).replaceAll("\\{UP_X\\}", bVar.f47676g).replaceAll("\\{UP_Y\\}", bVar.f47677h).replaceAll("\\{VIDEO_TIME\\}", bVar.i).replaceAll("\\{BEGIN_TIME\\}", bVar.j).replaceAll("\\{END_TIME\\}", bVar.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", bVar.l).replaceAll("\\{PLAY_LAST_FRAME\\}", bVar.m).replaceAll("\\{SCENE\\}", bVar.n).replaceAll("\\{TYPE\\}", bVar.o).replaceAll("\\{BEHAVIOR\\}", bVar.p).replaceAll("\\{STATUS\\}", bVar.q).replaceAll("\\{CONVERSION_ACTION\\}", bVar.r).replaceAll("\\{CLICK_ID\\}", bVar.s);
    }

    public static void d(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.E()) {
            b(c(str, null), eVar);
        }
    }

    public static void e(b bVar, AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.o()) {
            b(c(str, bVar), eVar);
        }
    }

    public static void f(AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.w()) {
            b(c(str, null), eVar);
        }
    }

    public static void g(b bVar, AdElementInfo adElementInfo, e eVar) {
        if (adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.m()) {
            b(c(str, bVar), eVar);
        }
    }
}
