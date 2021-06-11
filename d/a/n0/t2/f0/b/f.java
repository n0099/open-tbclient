package d.a.n0.t2.f0.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f64769a;

    /* renamed from: b  reason: collision with root package name */
    public String f64770b;

    /* renamed from: c  reason: collision with root package name */
    public String f64771c;

    /* renamed from: d  reason: collision with root package name */
    public String f64772d;

    /* renamed from: e  reason: collision with root package name */
    public String f64773e;

    /* renamed from: f  reason: collision with root package name */
    public String f64774f;

    /* renamed from: g  reason: collision with root package name */
    public String f64775g;

    /* renamed from: h  reason: collision with root package name */
    public int f64776h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64777i = false;

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.Y3;
        if (i2 == 3) {
            this.f64769a = "apk_download";
            this.f64774f = advertAppInfo.b4;
            this.f64775g = advertAppInfo.a4;
        } else if (i2 == 1) {
            this.f64769a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f64773e = adCard.getButtonText();
        this.f64770b = adCard.userName;
        this.f64771c = adCard.userImage;
        this.f64772d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f64769a = jSONObject.optString("style");
        this.f64770b = jSONObject.optString("user_name");
        this.f64771c = jSONObject.optString("user_portrait");
        this.f64772d = jSONObject.optString("scheme");
        this.f64773e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f64776h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f64774f = optJSONObject.optString("pkgname");
            this.f64775g = optJSONObject.optString("download_url");
        }
        this.f64777i = true;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f64769a);
            jSONObject.put("user_name", this.f64770b);
            jSONObject.put("user_portrait", this.f64771c);
            jSONObject.put("scheme", this.f64772d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f64773e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f64774f);
            jSONObject2.put("download_url", this.f64775g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f64769a);
            jSONObject.put("user_name", this.f64770b);
            jSONObject.put("user_portrait", this.f64771c);
            jSONObject.put("scheme", this.f64772d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f64773e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f64774f);
            jSONObject2.put("download_url", this.f64775g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
