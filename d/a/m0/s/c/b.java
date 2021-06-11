package d.a.m0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54087a;

    /* renamed from: b  reason: collision with root package name */
    public String f54088b;

    /* renamed from: c  reason: collision with root package name */
    public String f54089c;

    /* renamed from: d  reason: collision with root package name */
    public String f54090d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54091e;

    /* renamed from: f  reason: collision with root package name */
    public String f54092f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54093g;

    /* renamed from: h  reason: collision with root package name */
    public String f54094h;

    public String a() {
        return this.f54090d;
    }

    public String b() {
        return this.f54088b;
    }

    public String c() {
        return this.f54092f;
    }

    public String d() {
        return this.f54089c;
    }

    public String e() {
        return this.f54094h;
    }

    public boolean f() {
        return this.f54093g;
    }

    public boolean g() {
        return this.f54087a;
    }

    public boolean h() {
        return this.f54091e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f54088b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f54089c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f54090d = str;
        this.f54091e = jSONObject.optInt("user_satisfy") == 1;
        this.f54092f = jSONObject.optString("h5_url");
        this.f54093g = jSONObject.optInt("person_item_switch") == 1;
        this.f54094h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f54087a = z;
    }
}
