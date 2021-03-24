package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes3.dex */
public class c2 {

    /* renamed from: a  reason: collision with root package name */
    public String f50740a;

    /* renamed from: b  reason: collision with root package name */
    public String f50741b;

    /* renamed from: c  reason: collision with root package name */
    public String f50742c;

    /* renamed from: d  reason: collision with root package name */
    public int f50743d;

    /* renamed from: e  reason: collision with root package name */
    public String f50744e;

    /* renamed from: f  reason: collision with root package name */
    public long f50745f;

    /* renamed from: g  reason: collision with root package name */
    public String f50746g;

    /* renamed from: h  reason: collision with root package name */
    public String f50747h;

    public String a() {
        return this.f50746g;
    }

    public String b() {
        return this.f50742c;
    }

    public int c() {
        return this.f50743d;
    }

    public long d() {
        return this.f50745f;
    }

    public String e() {
        return this.f50740a;
    }

    public String f() {
        return this.f50747h;
    }

    public String g() {
        return this.f50741b;
    }

    public String h() {
        return this.f50744e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50740a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f50741b = jSONObject.optString("summary");
            this.f50742c = jSONObject.optString("code_link");
            this.f50743d = jSONObject.optInt("get_type", 1);
            this.f50744e = jSONObject.optString("surplusgift");
            this.f50745f = jSONObject.optLong("giftworth", 0L);
            this.f50746g = jSONObject.optString("type_text");
            this.f50747h = jSONObject.optString("subtitle");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        if (topCode == null) {
            return;
        }
        this.f50740a = topCode.img_url;
        String str = topCode.game_link;
        this.f50741b = topCode.summary;
        this.f50742c = topCode.code_link;
        this.f50743d = topCode.get_type.intValue();
        this.f50744e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f50745f = 0L;
        } else {
            this.f50745f = topCode.giftworth.longValue();
        }
        this.f50746g = topCode.type_text;
        this.f50747h = topCode.subtitle;
    }
}
