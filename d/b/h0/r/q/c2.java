package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f50741a;

    /* renamed from: b  reason: collision with root package name */
    public String f50742b;

    /* renamed from: c  reason: collision with root package name */
    public String f50743c;

    /* renamed from: d  reason: collision with root package name */
    public int f50744d;

    /* renamed from: e  reason: collision with root package name */
    public String f50745e;

    /* renamed from: f  reason: collision with root package name */
    public long f50746f;

    /* renamed from: g  reason: collision with root package name */
    public String f50747g;

    /* renamed from: h  reason: collision with root package name */
    public String f50748h;

    public String a() {
        return this.f50747g;
    }

    public String b() {
        return this.f50743c;
    }

    public int c() {
        return this.f50744d;
    }

    public long d() {
        return this.f50746f;
    }

    public String e() {
        return this.f50741a;
    }

    public String f() {
        return this.f50748h;
    }

    public String g() {
        return this.f50742b;
    }

    public String h() {
        return this.f50745e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50741a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f50742b = jSONObject.optString("summary");
            this.f50743c = jSONObject.optString("code_link");
            this.f50744d = jSONObject.optInt("get_type", 1);
            this.f50745e = jSONObject.optString("surplusgift");
            this.f50746f = jSONObject.optLong("giftworth", 0L);
            this.f50747g = jSONObject.optString("type_text");
            this.f50748h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f50741a = topCode.img_url;
        String str = topCode.game_link;
        this.f50742b = topCode.summary;
        this.f50743c = topCode.code_link;
        this.f50744d = topCode.get_type.intValue();
        this.f50745e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f50746f = 0L;
        } else {
            this.f50746f = topCode.giftworth.longValue();
        }
        this.f50747g = topCode.type_text;
        this.f50748h = topCode.subtitle;
    }
}
