package d.a.i0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49526a;

    /* renamed from: b  reason: collision with root package name */
    public String f49527b;

    /* renamed from: c  reason: collision with root package name */
    public String f49528c;

    /* renamed from: d  reason: collision with root package name */
    public String f49529d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49530e;

    /* renamed from: f  reason: collision with root package name */
    public String f49531f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49532g;

    /* renamed from: h  reason: collision with root package name */
    public String f49533h;

    public String a() {
        return this.f49529d;
    }

    public String b() {
        return this.f49527b;
    }

    public String c() {
        return this.f49531f;
    }

    public String d() {
        return this.f49528c;
    }

    public String e() {
        return this.f49533h;
    }

    public boolean f() {
        return this.f49532g;
    }

    public boolean g() {
        return this.f49526a;
    }

    public boolean h() {
        return this.f49530e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f49527b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f49528c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f49529d = str;
        this.f49530e = jSONObject.optInt("user_satisfy") == 1;
        this.f49531f = jSONObject.optString("h5_url");
        this.f49532g = jSONObject.optInt("person_item_switch") == 1;
        this.f49533h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f49526a = z;
    }
}
