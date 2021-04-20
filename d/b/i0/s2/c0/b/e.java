package d.b.i0.s2.c0.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f61596a;

    /* renamed from: b  reason: collision with root package name */
    public String f61597b;

    /* renamed from: c  reason: collision with root package name */
    public String f61598c;

    /* renamed from: d  reason: collision with root package name */
    public String f61599d;

    /* renamed from: e  reason: collision with root package name */
    public String f61600e;

    /* renamed from: f  reason: collision with root package name */
    public String f61601f;

    /* renamed from: g  reason: collision with root package name */
    public String f61602g;

    /* renamed from: h  reason: collision with root package name */
    public int f61603h;
    public boolean i = false;

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i = advertAppInfo.G3;
        if (i == 3) {
            this.f61596a = "apk_download";
            this.f61601f = advertAppInfo.J3;
            this.f61602g = advertAppInfo.I3;
        } else if (i == 1) {
            this.f61596a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f61600e = adCard.buttonText;
        this.f61597b = adCard.userName;
        this.f61598c = adCard.userPortrait;
        this.f61599d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61596a = jSONObject.optString("style");
        this.f61597b = jSONObject.optString("user_name");
        this.f61598c = jSONObject.optString("user_portrait");
        this.f61599d = jSONObject.optString("scheme");
        this.f61600e = jSONObject.optString("button_text");
        this.f61603h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f61601f = optJSONObject.optString("pkgname");
            this.f61602g = optJSONObject.optString("download_url");
        }
        this.i = true;
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
            jSONObject.put("style", this.f61596a);
            jSONObject.put("user_name", this.f61597b);
            jSONObject.put("user_portrait", this.f61598c);
            jSONObject.put("scheme", this.f61599d);
            jSONObject.put("button_text", this.f61600e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f61601f);
            jSONObject2.put("download_url", this.f61602g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f61596a);
            jSONObject.put("user_name", this.f61597b);
            jSONObject.put("user_portrait", this.f61598c);
            jSONObject.put("scheme", this.f61599d);
            jSONObject.put("button_text", this.f61600e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f61601f);
            jSONObject2.put("download_url", this.f61602g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
