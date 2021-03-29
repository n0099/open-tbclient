package d.b.g0.a.j2;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.BearLayout;
import com.baidubce.services.vod.VodClient;
import d.b.g0.a.h;
import d.b.g0.a.k;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44960d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public BearLayout f44961a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f44962b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppBearInfo f44963c;

    /* renamed from: d.b.g0.a.j2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0710a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public BearLayout.d f44964a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44965b;

        public C0710a(a aVar, BearLayout.d dVar, boolean z) {
            this.f44964a = dVar;
            this.f44965b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            if (this.f44964a == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                if (optInt == 0) {
                    if (this.f44965b) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                this.f44964a.b(true);
                            }
                            this.f44964a.b(false);
                        }
                    } else {
                        this.f44964a.b(true);
                    }
                } else if (800200 == optInt) {
                    String optString = jSONObject.optString("errmsg");
                    BearLayout.d dVar = this.f44964a;
                    dVar.a("errNo:" + optInt + ",errMsg:" + optString);
                } else {
                    BearLayout.d dVar2 = this.f44964a;
                    dVar2.a("errNo:" + optInt);
                }
            } catch (JSONException e2) {
                if (a.f44960d) {
                    e2.printStackTrace();
                    this.f44964a.a(e2.getMessage());
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f44960d) {
                exc.printStackTrace();
                this.f44964a.a(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }
    }

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        this.f44962b = activity;
        this.f44963c = swanAppBearInfo;
        BearLayout bearLayout = (BearLayout) view.findViewById(i);
        this.f44961a = bearLayout;
        bearLayout.setVisibility(0);
        this.f44961a.k(activity, swanAppBearInfo, this);
    }

    public void b() {
        if (SwanAppNetworkUtils.h(this.f44962b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f44963c.bearId);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String s = d.b.g0.a.w0.a.l().s();
            if (TextUtils.isEmpty(s)) {
                return;
            }
            d.b.g0.k.e.a.f().getRequest().url(s).addUrlParams(linkedHashMap).cookieManager(d.b.g0.a.w0.a.m().a()).build().executeAsyncOnUIBack(new C0710a(this, this.f44961a.getCallback(), false));
            return;
        }
        d.b.g0.a.q1.b.f.d.e(this.f44962b, h.aiapps_net_error).C();
    }

    public void c() {
        if (SwanAppNetworkUtils.h(this.f44962b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f44963c.bearId);
            String m = d.b.g0.a.w0.a.l().m();
            if (TextUtils.isEmpty(m)) {
                return;
            }
            d.b.g0.k.e.a.f().getRequest().url(m).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(d.b.g0.a.w0.a.m().a()).build().executeAsyncOnUIBack(new C0710a(this, this.f44961a.getCallback(), true));
        }
    }
}
