package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f53754a;

    /* renamed from: b  reason: collision with root package name */
    public String f53755b;

    /* renamed from: c  reason: collision with root package name */
    public String f53756c;

    /* renamed from: d  reason: collision with root package name */
    public int f53757d;

    /* renamed from: e  reason: collision with root package name */
    public String f53758e;

    /* renamed from: f  reason: collision with root package name */
    public long f53759f;

    /* renamed from: g  reason: collision with root package name */
    public String f53760g;

    /* renamed from: h  reason: collision with root package name */
    public String f53761h;

    public String a() {
        return this.f53760g;
    }

    public String b() {
        return this.f53756c;
    }

    public int c() {
        return this.f53757d;
    }

    public long d() {
        return this.f53759f;
    }

    public String e() {
        return this.f53754a;
    }

    public String f() {
        return this.f53761h;
    }

    public String g() {
        return this.f53755b;
    }

    public String h() {
        return this.f53758e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53754a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f53755b = jSONObject.optString("summary");
            this.f53756c = jSONObject.optString("code_link");
            this.f53757d = jSONObject.optInt("get_type", 1);
            this.f53758e = jSONObject.optString("surplusgift");
            this.f53759f = jSONObject.optLong("giftworth", 0L);
            this.f53760g = jSONObject.optString("type_text");
            this.f53761h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f53754a = topCode.img_url;
        String str = topCode.game_link;
        this.f53755b = topCode.summary;
        this.f53756c = topCode.code_link;
        this.f53757d = topCode.get_type.intValue();
        this.f53758e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f53759f = 0L;
        } else {
            this.f53759f = topCode.giftworth.longValue();
        }
        this.f53760g = topCode.type_text;
        this.f53761h = topCode.subtitle;
    }
}
