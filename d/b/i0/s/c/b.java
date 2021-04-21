package d.b.i0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51875a;

    /* renamed from: b  reason: collision with root package name */
    public String f51876b;

    /* renamed from: c  reason: collision with root package name */
    public String f51877c;

    /* renamed from: d  reason: collision with root package name */
    public String f51878d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51879e;

    /* renamed from: f  reason: collision with root package name */
    public String f51880f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51881g;

    /* renamed from: h  reason: collision with root package name */
    public String f51882h;

    public String a() {
        return this.f51878d;
    }

    public String b() {
        return this.f51876b;
    }

    public String c() {
        return this.f51880f;
    }

    public String d() {
        return this.f51877c;
    }

    public String e() {
        return this.f51882h;
    }

    public boolean f() {
        return this.f51881g;
    }

    public boolean g() {
        return this.f51875a;
    }

    public boolean h() {
        return this.f51879e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f51876b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f51877c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f51878d = str;
        this.f51879e = jSONObject.optInt("user_satisfy") == 1;
        this.f51880f = jSONObject.optString("h5_url");
        this.f51881g = jSONObject.optInt("person_item_switch") == 1;
        this.f51882h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f51875a = z;
    }
}
