package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f51148a;

    /* renamed from: b  reason: collision with root package name */
    public String f51149b;

    /* renamed from: c  reason: collision with root package name */
    public String f51150c;

    /* renamed from: d  reason: collision with root package name */
    public int f51151d;

    /* renamed from: e  reason: collision with root package name */
    public String f51152e;

    /* renamed from: f  reason: collision with root package name */
    public long f51153f;

    /* renamed from: g  reason: collision with root package name */
    public String f51154g;

    /* renamed from: h  reason: collision with root package name */
    public String f51155h;

    public String a() {
        return this.f51154g;
    }

    public String b() {
        return this.f51150c;
    }

    public int c() {
        return this.f51151d;
    }

    public long d() {
        return this.f51153f;
    }

    public String e() {
        return this.f51148a;
    }

    public String f() {
        return this.f51155h;
    }

    public String g() {
        return this.f51149b;
    }

    public String h() {
        return this.f51152e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51148a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f51149b = jSONObject.optString("summary");
            this.f51150c = jSONObject.optString("code_link");
            this.f51151d = jSONObject.optInt("get_type", 1);
            this.f51152e = jSONObject.optString("surplusgift");
            this.f51153f = jSONObject.optLong("giftworth", 0L);
            this.f51154g = jSONObject.optString("type_text");
            this.f51155h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f51148a = topCode.img_url;
        String str = topCode.game_link;
        this.f51149b = topCode.summary;
        this.f51150c = topCode.code_link;
        this.f51151d = topCode.get_type.intValue();
        this.f51152e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f51153f = 0L;
        } else {
            this.f51153f = topCode.giftworth.longValue();
        }
        this.f51154g = topCode.type_text;
        this.f51155h = topCode.subtitle;
    }
}
