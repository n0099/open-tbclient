package d.a.h0.a.j2;

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
import d.a.h0.a.h;
import d.a.h0.a.k;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43006d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public BearLayout f43007a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f43008b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppBearInfo f43009c;

    /* renamed from: d.a.h0.a.j2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0681a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public BearLayout.d f43010a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43011b;

        public C0681a(a aVar, BearLayout.d dVar, boolean z) {
            this.f43010a = dVar;
            this.f43011b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (this.f43010a == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                if (optInt == 0) {
                    if (this.f43011b) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                this.f43010a.a(true);
                            }
                            this.f43010a.a(false);
                        }
                    } else {
                        this.f43010a.a(true);
                    }
                } else if (800200 == optInt) {
                    String optString = jSONObject.optString("errmsg");
                    BearLayout.d dVar = this.f43010a;
                    dVar.b("errNo:" + optInt + ",errMsg:" + optString);
                } else {
                    BearLayout.d dVar2 = this.f43010a;
                    dVar2.b("errNo:" + optInt);
                }
            } catch (JSONException e2) {
                if (a.f43006d) {
                    e2.printStackTrace();
                    this.f43010a.b(e2.getMessage());
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f43006d) {
                exc.printStackTrace();
                this.f43010a.b(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }
    }

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i2) {
        this.f43008b = activity;
        this.f43009c = swanAppBearInfo;
        BearLayout bearLayout = (BearLayout) view.findViewById(i2);
        this.f43007a = bearLayout;
        bearLayout.setVisibility(0);
        this.f43007a.k(activity, swanAppBearInfo, this);
    }

    public void b() {
        if (SwanAppNetworkUtils.h(this.f43008b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f43009c.bearId);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String G = d.a.h0.a.w0.a.l().G();
            if (TextUtils.isEmpty(G)) {
                return;
            }
            d.a.h0.k.e.a.f().getRequest().url(G).addUrlParams(linkedHashMap).cookieManager(d.a.h0.a.w0.a.m().a()).build().executeAsyncOnUIBack(new C0681a(this, this.f43007a.getCallback(), false));
            return;
        }
        d.a.h0.a.q1.b.f.d.e(this.f43008b, h.aiapps_net_error).C();
    }

    public void c() {
        if (SwanAppNetworkUtils.h(this.f43008b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f43009c.bearId);
            String D = d.a.h0.a.w0.a.l().D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            d.a.h0.k.e.a.f().getRequest().url(D).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(d.a.h0.a.w0.a.m().a()).build().executeAsyncOnUIBack(new C0681a(this, this.f43007a.getCallback(), true));
        }
    }
}
