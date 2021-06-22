package d.a.o0.t2.f0.b;

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
    public String f64894a;

    /* renamed from: b  reason: collision with root package name */
    public String f64895b;

    /* renamed from: c  reason: collision with root package name */
    public String f64896c;

    /* renamed from: d  reason: collision with root package name */
    public String f64897d;

    /* renamed from: e  reason: collision with root package name */
    public String f64898e;

    /* renamed from: f  reason: collision with root package name */
    public String f64899f;

    /* renamed from: g  reason: collision with root package name */
    public String f64900g;

    /* renamed from: h  reason: collision with root package name */
    public int f64901h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64902i = false;

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.Y3;
        if (i2 == 3) {
            this.f64894a = "apk_download";
            this.f64899f = advertAppInfo.b4;
            this.f64900g = advertAppInfo.a4;
        } else if (i2 == 1) {
            this.f64894a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f64898e = adCard.getButtonText();
        this.f64895b = adCard.userName;
        this.f64896c = adCard.userImage;
        this.f64897d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f64894a = jSONObject.optString("style");
        this.f64895b = jSONObject.optString("user_name");
        this.f64896c = jSONObject.optString("user_portrait");
        this.f64897d = jSONObject.optString("scheme");
        this.f64898e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f64901h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f64899f = optJSONObject.optString("pkgname");
            this.f64900g = optJSONObject.optString("download_url");
        }
        this.f64902i = true;
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
            jSONObject.put("style", this.f64894a);
            jSONObject.put("user_name", this.f64895b);
            jSONObject.put("user_portrait", this.f64896c);
            jSONObject.put("scheme", this.f64897d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f64898e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f64899f);
            jSONObject2.put("download_url", this.f64900g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f64894a);
            jSONObject.put("user_name", this.f64895b);
            jSONObject.put("user_portrait", this.f64896c);
            jSONObject.put("scheme", this.f64897d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f64898e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f64899f);
            jSONObject2.put("download_url", this.f64900g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
