package d.a.j0.s2.e0.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f60230a;

    /* renamed from: b  reason: collision with root package name */
    public String f60231b;

    /* renamed from: c  reason: collision with root package name */
    public String f60232c;

    /* renamed from: d  reason: collision with root package name */
    public String f60233d;

    /* renamed from: e  reason: collision with root package name */
    public String f60234e;

    /* renamed from: f  reason: collision with root package name */
    public String f60235f;

    /* renamed from: g  reason: collision with root package name */
    public String f60236g;

    /* renamed from: h  reason: collision with root package name */
    public int f60237h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60238i = false;

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.G3;
        if (i2 == 3) {
            this.f60230a = "apk_download";
            this.f60235f = advertAppInfo.J3;
            this.f60236g = advertAppInfo.I3;
        } else if (i2 == 1) {
            this.f60230a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f60234e = adCard.buttonText;
        this.f60231b = adCard.userName;
        this.f60232c = adCard.userPortrait;
        this.f60233d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60230a = jSONObject.optString("style");
        this.f60231b = jSONObject.optString("user_name");
        this.f60232c = jSONObject.optString("user_portrait");
        this.f60233d = jSONObject.optString("scheme");
        this.f60234e = jSONObject.optString("button_text");
        this.f60237h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f60235f = optJSONObject.optString("pkgname");
            this.f60236g = optJSONObject.optString("download_url");
        }
        this.f60238i = true;
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
            jSONObject.put("style", this.f60230a);
            jSONObject.put("user_name", this.f60231b);
            jSONObject.put("user_portrait", this.f60232c);
            jSONObject.put("scheme", this.f60233d);
            jSONObject.put("button_text", this.f60234e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f60235f);
            jSONObject2.put("download_url", this.f60236g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f60230a);
            jSONObject.put("user_name", this.f60231b);
            jSONObject.put("user_portrait", this.f60232c);
            jSONObject.put("scheme", this.f60233d);
            jSONObject.put("button_text", this.f60234e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f60235f);
            jSONObject2.put("download_url", this.f60236g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
