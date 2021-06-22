package d.a.n0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54194a;

    /* renamed from: b  reason: collision with root package name */
    public String f54195b;

    /* renamed from: c  reason: collision with root package name */
    public String f54196c;

    /* renamed from: d  reason: collision with root package name */
    public String f54197d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54198e;

    /* renamed from: f  reason: collision with root package name */
    public String f54199f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54200g;

    /* renamed from: h  reason: collision with root package name */
    public String f54201h;

    public String a() {
        return this.f54197d;
    }

    public String b() {
        return this.f54195b;
    }

    public String c() {
        return this.f54199f;
    }

    public String d() {
        return this.f54196c;
    }

    public String e() {
        return this.f54201h;
    }

    public boolean f() {
        return this.f54200g;
    }

    public boolean g() {
        return this.f54194a;
    }

    public boolean h() {
        return this.f54198e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f54195b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f54196c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f54197d = str;
        this.f54198e = jSONObject.optInt("user_satisfy") == 1;
        this.f54199f = jSONObject.optString("h5_url");
        this.f54200g = jSONObject.optInt("person_item_switch") == 1;
        this.f54201h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f54194a = z;
    }
}
