package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f53647a;

    /* renamed from: b  reason: collision with root package name */
    public String f53648b;

    /* renamed from: c  reason: collision with root package name */
    public String f53649c;

    /* renamed from: d  reason: collision with root package name */
    public int f53650d;

    /* renamed from: e  reason: collision with root package name */
    public String f53651e;

    /* renamed from: f  reason: collision with root package name */
    public long f53652f;

    /* renamed from: g  reason: collision with root package name */
    public String f53653g;

    /* renamed from: h  reason: collision with root package name */
    public String f53654h;

    public String a() {
        return this.f53653g;
    }

    public String b() {
        return this.f53649c;
    }

    public int c() {
        return this.f53650d;
    }

    public long d() {
        return this.f53652f;
    }

    public String e() {
        return this.f53647a;
    }

    public String f() {
        return this.f53654h;
    }

    public String g() {
        return this.f53648b;
    }

    public String h() {
        return this.f53651e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53647a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f53648b = jSONObject.optString("summary");
            this.f53649c = jSONObject.optString("code_link");
            this.f53650d = jSONObject.optInt("get_type", 1);
            this.f53651e = jSONObject.optString("surplusgift");
            this.f53652f = jSONObject.optLong("giftworth", 0L);
            this.f53653g = jSONObject.optString("type_text");
            this.f53654h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f53647a = topCode.img_url;
        String str = topCode.game_link;
        this.f53648b = topCode.summary;
        this.f53649c = topCode.code_link;
        this.f53650d = topCode.get_type.intValue();
        this.f53651e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f53652f = 0L;
        } else {
            this.f53652f = topCode.giftworth.longValue();
        }
        this.f53653g = topCode.type_text;
        this.f53654h = topCode.subtitle;
    }
}
