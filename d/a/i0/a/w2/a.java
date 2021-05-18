package d.a.i0.a.w2;

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
import d.a.i0.a.h;
import d.a.i0.a.k;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45462d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public BearLayout f45463a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f45464b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppBearInfo f45465c;

    /* renamed from: d.a.i0.a.w2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0884a extends ResponseCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public BearLayout.d f45466a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f45467b;

        public C0884a(a aVar, BearLayout.d dVar, boolean z) {
            this.f45466a = dVar;
            this.f45467b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (this.f45466a == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                if (optInt == 0) {
                    if (this.f45467b) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                this.f45466a.a(true);
                            }
                            this.f45466a.a(false);
                        }
                    } else {
                        this.f45466a.a(true);
                    }
                } else if (800200 == optInt) {
                    String optString = jSONObject.optString("errmsg");
                    BearLayout.d dVar = this.f45466a;
                    dVar.b("errNo:" + optInt + ",errMsg:" + optString);
                } else {
                    BearLayout.d dVar2 = this.f45466a;
                    dVar2.b("errNo:" + optInt);
                }
            } catch (JSONException e2) {
                if (a.f45462d) {
                    e2.printStackTrace();
                    this.f45466a.b(e2.getMessage());
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f45462d) {
                exc.printStackTrace();
                this.f45466a.b(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            return (response == null || response.body() == null) ? "" : response.body().string();
        }
    }

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i2) {
        this.f45464b = activity;
        this.f45465c = swanAppBearInfo;
        BearLayout bearLayout = (BearLayout) view.findViewById(i2);
        this.f45463a = bearLayout;
        bearLayout.setVisibility(0);
        this.f45463a.k(activity, swanAppBearInfo, this);
    }

    public void b() {
        if (SwanAppNetworkUtils.i(this.f45464b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f45465c.bearId);
            linkedHashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
            String b2 = d.a.i0.a.b0.b.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.a.i0.m.e.a.g().getRequest().url(b2).addUrlParams(linkedHashMap).cookieManager(d.a.i0.a.c1.a.p().a()).build().executeAsyncOnUIBack(new C0884a(this, this.f45463a.getCallback(), false));
            return;
        }
        d.a.i0.a.z1.b.f.e.f(this.f45464b, h.aiapps_net_error).F();
    }

    public void c() {
        if (SwanAppNetworkUtils.i(this.f45464b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f45465c.bearId);
            String z = d.a.i0.a.c1.a.n().z();
            if (TextUtils.isEmpty(z)) {
                return;
            }
            d.a.i0.m.e.a.g().getRequest().url(z).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(d.a.i0.a.c1.a.p().a()).build().executeAsyncOnUIBack(new C0884a(this, this.f45463a.getCallback(), true));
        }
    }
}
