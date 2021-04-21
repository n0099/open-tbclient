package d.b.j0.s2.c0.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f62017a;

    /* renamed from: b  reason: collision with root package name */
    public String f62018b;

    /* renamed from: c  reason: collision with root package name */
    public String f62019c;

    /* renamed from: d  reason: collision with root package name */
    public String f62020d;

    /* renamed from: e  reason: collision with root package name */
    public String f62021e;

    /* renamed from: f  reason: collision with root package name */
    public String f62022f;

    /* renamed from: g  reason: collision with root package name */
    public String f62023g;

    /* renamed from: h  reason: collision with root package name */
    public int f62024h;
    public boolean i = false;

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i = advertAppInfo.G3;
        if (i == 3) {
            this.f62017a = "apk_download";
            this.f62022f = advertAppInfo.J3;
            this.f62023g = advertAppInfo.I3;
        } else if (i == 1) {
            this.f62017a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f62021e = adCard.buttonText;
        this.f62018b = adCard.userName;
        this.f62019c = adCard.userPortrait;
        this.f62020d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62017a = jSONObject.optString("style");
        this.f62018b = jSONObject.optString("user_name");
        this.f62019c = jSONObject.optString("user_portrait");
        this.f62020d = jSONObject.optString("scheme");
        this.f62021e = jSONObject.optString("button_text");
        this.f62024h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f62022f = optJSONObject.optString("pkgname");
            this.f62023g = optJSONObject.optString("download_url");
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
            jSONObject.put("style", this.f62017a);
            jSONObject.put("user_name", this.f62018b);
            jSONObject.put("user_portrait", this.f62019c);
            jSONObject.put("scheme", this.f62020d);
            jSONObject.put("button_text", this.f62021e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f62022f);
            jSONObject2.put("download_url", this.f62023g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f62017a);
            jSONObject.put("user_name", this.f62018b);
            jSONObject.put("user_portrait", this.f62019c);
            jSONObject.put("scheme", this.f62020d);
            jSONObject.put("button_text", this.f62021e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f62022f);
            jSONObject2.put("download_url", this.f62023g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
