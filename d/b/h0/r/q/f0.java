package d.b.h0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f50779a;

    /* renamed from: b  reason: collision with root package name */
    public String f50780b;

    /* renamed from: c  reason: collision with root package name */
    public String f50781c;

    /* renamed from: d  reason: collision with root package name */
    public int f50782d;

    /* renamed from: e  reason: collision with root package name */
    public String f50783e;

    /* renamed from: f  reason: collision with root package name */
    public String f50784f;

    /* renamed from: g  reason: collision with root package name */
    public String f50785g;

    /* renamed from: h  reason: collision with root package name */
    public float f50786h;
    public boolean i = true;

    public int a() {
        return this.f50779a;
    }

    public String b() {
        return this.f50780b;
    }

    public String c() {
        return this.f50784f;
    }

    public int d() {
        return this.f50782d;
    }

    public String e() {
        return this.f50781c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f50781c)) {
            return false;
        }
        int i = this.f50782d;
        if (i != 1) {
            return i == 2 && !StringUtils.isNull(this.f50783e);
        }
        int i2 = this.f50779a;
        return i2 == 1 || i2 == 4 || i2 == 2 || i2 == 3;
    }

    public final void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split == null || split.length < 2) {
                return;
            }
            int d2 = d.b.b.e.m.b.d(split[0], 1);
            int d3 = d.b.b.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f50786h = d2 / d3;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50779a = jSONObject.optInt("bannerType");
            this.f50780b = jSONObject.optString("bannerUrl");
            this.f50781c = jSONObject.optString("value");
            this.f50782d = jSONObject.optInt("type");
            this.f50783e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f50784f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f50785g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f50779a = banner.banner_type.intValue();
        this.f50780b = banner.banner_url;
        this.f50781c = banner.value;
        this.f50782d = banner.type.intValue();
        this.f50783e = banner.desc;
        banner.template_id.intValue();
        this.f50784f = banner.obj_id;
        String str = banner.tag_name;
        this.f50785g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
