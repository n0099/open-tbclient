package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f49108a;

    /* renamed from: b  reason: collision with root package name */
    public String f49109b;

    /* renamed from: c  reason: collision with root package name */
    public String f49110c;

    /* renamed from: d  reason: collision with root package name */
    public int f49111d;

    /* renamed from: e  reason: collision with root package name */
    public String f49112e;

    /* renamed from: f  reason: collision with root package name */
    public long f49113f;

    /* renamed from: g  reason: collision with root package name */
    public String f49114g;

    /* renamed from: h  reason: collision with root package name */
    public String f49115h;

    public String a() {
        return this.f49114g;
    }

    public String b() {
        return this.f49110c;
    }

    public int c() {
        return this.f49111d;
    }

    public long d() {
        return this.f49113f;
    }

    public String e() {
        return this.f49108a;
    }

    public String f() {
        return this.f49115h;
    }

    public String g() {
        return this.f49109b;
    }

    public String h() {
        return this.f49112e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49108a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f49109b = jSONObject.optString("summary");
            this.f49110c = jSONObject.optString("code_link");
            this.f49111d = jSONObject.optInt("get_type", 1);
            this.f49112e = jSONObject.optString("surplusgift");
            this.f49113f = jSONObject.optLong("giftworth", 0L);
            this.f49114g = jSONObject.optString("type_text");
            this.f49115h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f49108a = topCode.img_url;
        String str = topCode.game_link;
        this.f49109b = topCode.summary;
        this.f49110c = topCode.code_link;
        this.f49111d = topCode.get_type.intValue();
        this.f49112e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f49113f = 0L;
        } else {
            this.f49113f = topCode.giftworth.longValue();
        }
        this.f49114g = topCode.type_text;
        this.f49115h = topCode.subtitle;
    }
}
