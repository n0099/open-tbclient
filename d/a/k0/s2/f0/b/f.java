package d.a.k0.s2.f0.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f60975a;

    /* renamed from: b  reason: collision with root package name */
    public String f60976b;

    /* renamed from: c  reason: collision with root package name */
    public String f60977c;

    /* renamed from: d  reason: collision with root package name */
    public String f60978d;

    /* renamed from: e  reason: collision with root package name */
    public String f60979e;

    /* renamed from: f  reason: collision with root package name */
    public String f60980f;

    /* renamed from: g  reason: collision with root package name */
    public String f60981g;

    /* renamed from: h  reason: collision with root package name */
    public int f60982h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60983i = false;

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.U3;
        if (i2 == 3) {
            this.f60975a = "apk_download";
            this.f60980f = advertAppInfo.X3;
            this.f60981g = advertAppInfo.W3;
        } else if (i2 == 1) {
            this.f60975a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f60979e = adCard.getButtonText();
        this.f60976b = adCard.userName;
        this.f60977c = adCard.userImage;
        this.f60978d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60975a = jSONObject.optString("style");
        this.f60976b = jSONObject.optString("user_name");
        this.f60977c = jSONObject.optString("user_portrait");
        this.f60978d = jSONObject.optString("scheme");
        this.f60979e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f60982h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f60980f = optJSONObject.optString("pkgname");
            this.f60981g = optJSONObject.optString("download_url");
        }
        this.f60983i = true;
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
            jSONObject.put("style", this.f60975a);
            jSONObject.put("user_name", this.f60976b);
            jSONObject.put("user_portrait", this.f60977c);
            jSONObject.put("scheme", this.f60978d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f60979e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f60980f);
            jSONObject2.put("download_url", this.f60981g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f60975a);
            jSONObject.put("user_name", this.f60976b);
            jSONObject.put("user_portrait", this.f60977c);
            jSONObject.put("scheme", this.f60978d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f60979e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f60980f);
            jSONObject2.put("download_url", this.f60981g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
