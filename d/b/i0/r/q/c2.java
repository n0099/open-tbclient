package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f51484a;

    /* renamed from: b  reason: collision with root package name */
    public String f51485b;

    /* renamed from: c  reason: collision with root package name */
    public String f51486c;

    /* renamed from: d  reason: collision with root package name */
    public int f51487d;

    /* renamed from: e  reason: collision with root package name */
    public String f51488e;

    /* renamed from: f  reason: collision with root package name */
    public long f51489f;

    /* renamed from: g  reason: collision with root package name */
    public String f51490g;

    /* renamed from: h  reason: collision with root package name */
    public String f51491h;

    public String a() {
        return this.f51490g;
    }

    public String b() {
        return this.f51486c;
    }

    public int c() {
        return this.f51487d;
    }

    public long d() {
        return this.f51489f;
    }

    public String e() {
        return this.f51484a;
    }

    public String f() {
        return this.f51491h;
    }

    public String g() {
        return this.f51485b;
    }

    public String h() {
        return this.f51488e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51484a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f51485b = jSONObject.optString("summary");
            this.f51486c = jSONObject.optString("code_link");
            this.f51487d = jSONObject.optInt("get_type", 1);
            this.f51488e = jSONObject.optString("surplusgift");
            this.f51489f = jSONObject.optLong("giftworth", 0L);
            this.f51490g = jSONObject.optString("type_text");
            this.f51491h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f51484a = topCode.img_url;
        String str = topCode.game_link;
        this.f51485b = topCode.summary;
        this.f51486c = topCode.code_link;
        this.f51487d = topCode.get_type.intValue();
        this.f51488e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f51489f = 0L;
        } else {
            this.f51489f = topCode.giftworth.longValue();
        }
        this.f51490g = topCode.type_text;
        this.f51491h = topCode.subtitle;
    }
}
