package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f49971a;

    /* renamed from: b  reason: collision with root package name */
    public String f49972b;

    /* renamed from: c  reason: collision with root package name */
    public String f49973c;

    /* renamed from: d  reason: collision with root package name */
    public int f49974d;

    /* renamed from: e  reason: collision with root package name */
    public String f49975e;

    /* renamed from: f  reason: collision with root package name */
    public long f49976f;

    /* renamed from: g  reason: collision with root package name */
    public String f49977g;

    /* renamed from: h  reason: collision with root package name */
    public String f49978h;

    public String a() {
        return this.f49977g;
    }

    public String b() {
        return this.f49973c;
    }

    public int c() {
        return this.f49974d;
    }

    public long d() {
        return this.f49976f;
    }

    public String e() {
        return this.f49971a;
    }

    public String f() {
        return this.f49978h;
    }

    public String g() {
        return this.f49972b;
    }

    public String h() {
        return this.f49975e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49971a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f49972b = jSONObject.optString("summary");
            this.f49973c = jSONObject.optString("code_link");
            this.f49974d = jSONObject.optInt("get_type", 1);
            this.f49975e = jSONObject.optString("surplusgift");
            this.f49976f = jSONObject.optLong("giftworth", 0L);
            this.f49977g = jSONObject.optString("type_text");
            this.f49978h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f49971a = topCode.img_url;
        String str = topCode.game_link;
        this.f49972b = topCode.summary;
        this.f49973c = topCode.code_link;
        this.f49974d = topCode.get_type.intValue();
        this.f49975e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f49976f = 0L;
        } else {
            this.f49976f = topCode.giftworth.longValue();
        }
        this.f49977g = topCode.type_text;
        this.f49978h = topCode.subtitle;
    }
}
