package d.a.j0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f49927a;

    /* renamed from: b  reason: collision with root package name */
    public String f49928b;

    /* renamed from: c  reason: collision with root package name */
    public String f49929c;

    /* renamed from: d  reason: collision with root package name */
    public int f49930d;

    /* renamed from: e  reason: collision with root package name */
    public String f49931e;

    /* renamed from: f  reason: collision with root package name */
    public long f49932f;

    /* renamed from: g  reason: collision with root package name */
    public String f49933g;

    /* renamed from: h  reason: collision with root package name */
    public String f49934h;

    public String a() {
        return this.f49933g;
    }

    public String b() {
        return this.f49929c;
    }

    public int c() {
        return this.f49930d;
    }

    public long d() {
        return this.f49932f;
    }

    public String e() {
        return this.f49927a;
    }

    public String f() {
        return this.f49934h;
    }

    public String g() {
        return this.f49928b;
    }

    public String h() {
        return this.f49931e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49927a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f49928b = jSONObject.optString("summary");
            this.f49929c = jSONObject.optString("code_link");
            this.f49930d = jSONObject.optInt("get_type", 1);
            this.f49931e = jSONObject.optString("surplusgift");
            this.f49932f = jSONObject.optLong("giftworth", 0L);
            this.f49933g = jSONObject.optString("type_text");
            this.f49934h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f49927a = topCode.img_url;
        String str = topCode.game_link;
        this.f49928b = topCode.summary;
        this.f49929c = topCode.code_link;
        this.f49930d = topCode.get_type.intValue();
        this.f49931e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f49932f = 0L;
        } else {
            this.f49932f = topCode.giftworth.longValue();
        }
        this.f49933g = topCode.type_text;
        this.f49934h = topCode.subtitle;
    }
}
