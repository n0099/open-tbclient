package d.a.h0.e.a.p;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.qq.e.comm.constants.Constants;
import d.a.h0.e.a.m.e;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.h0.e.a.p.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.e.a.m.d f45855a;

        public a(d.a.h0.e.a.m.d dVar) {
            this.f45855a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.h0.e.a.p.a aVar, int i2) {
            d.a.h0.e.a.m.d dVar;
            if (aVar == null || (dVar = this.f45855a) == null) {
                return;
            }
            dVar.d(aVar.f45844a, aVar.f45845b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.h0.e.a.p.a parseResponse(Response response, int i2) {
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
                            d.a.h0.e.a.p.a aVar = new d.a.h0.e.a.p.a();
                            aVar.f45844a = optJSONObject.optString("clickid");
                            aVar.f45845b = optJSONObject.optString("dstlink");
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

    public static void a(b bVar, AdElementInfo adElementInfo, e eVar, d.a.h0.e.a.m.d dVar) {
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
        return bVar == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", bVar.f45846a).replaceAll("\\{REQ_HEIGHT\\}", bVar.f45847b).replaceAll("\\{WIDTH\\}", bVar.f45848c).replaceAll("\\{HEIGHT\\}", bVar.f45849d).replaceAll("\\{DOWN_X\\}", bVar.f45850e).replaceAll("\\{DOWN_Y\\}", bVar.f45851f).replaceAll("\\{UP_X\\}", bVar.f45852g).replaceAll("\\{UP_Y\\}", bVar.f45853h).replaceAll("\\{VIDEO_TIME\\}", bVar.f45854i).replaceAll("\\{BEGIN_TIME\\}", bVar.j).replaceAll("\\{END_TIME\\}", bVar.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", bVar.l).replaceAll("\\{PLAY_LAST_FRAME\\}", bVar.m).replaceAll("\\{SCENE\\}", bVar.n).replaceAll("\\{TYPE\\}", bVar.o).replaceAll("\\{BEHAVIOR\\}", bVar.p).replaceAll("\\{STATUS\\}", bVar.q).replaceAll("\\{CONVERSION_ACTION\\}", bVar.r).replaceAll("\\{CLICK_ID\\}", bVar.s);
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
