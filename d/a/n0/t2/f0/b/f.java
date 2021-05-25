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
    public String f61077a;

    /* renamed from: b  reason: collision with root package name */
    public String f61078b;

    /* renamed from: c  reason: collision with root package name */
    public String f61079c;

    /* renamed from: d  reason: collision with root package name */
    public String f61080d;

    /* renamed from: e  reason: collision with root package name */
    public String f61081e;

    /* renamed from: f  reason: collision with root package name */
    public String f61082f;

    /* renamed from: g  reason: collision with root package name */
    public String f61083g;

    /* renamed from: h  reason: collision with root package name */
    public int f61084h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61085i = false;

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        if (advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.V3;
        if (i2 == 3) {
            this.f61077a = "apk_download";
            this.f61082f = advertAppInfo.Y3;
            this.f61083g = advertAppInfo.X3;
        } else if (i2 == 1) {
            this.f61077a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f61081e = adCard.getButtonText();
        this.f61078b = adCard.userName;
        this.f61079c = adCard.userImage;
        this.f61080d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61077a = jSONObject.optString("style");
        this.f61078b = jSONObject.optString("user_name");
        this.f61079c = jSONObject.optString("user_portrait");
        this.f61080d = jSONObject.optString("scheme");
        this.f61081e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f61084h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f61082f = optJSONObject.optString("pkgname");
            this.f61083g = optJSONObject.optString("download_url");
        }
        this.f61085i = true;
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
            jSONObject.put("style", this.f61077a);
            jSONObject.put("user_name", this.f61078b);
            jSONObject.put("user_portrait", this.f61079c);
            jSONObject.put("scheme", this.f61080d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f61081e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f61082f);
            jSONObject2.put("download_url", this.f61083g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", this.f61077a);
            jSONObject.put("user_name", this.f61078b);
            jSONObject.put("user_portrait", this.f61079c);
            jSONObject.put("scheme", this.f61080d);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f61081e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkgname", this.f61082f);
            jSONObject2.put("download_url", this.f61083g);
            jSONObject.put("ext_data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
