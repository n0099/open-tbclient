package d.a.i0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f49148a;

    /* renamed from: b  reason: collision with root package name */
    public String f49149b;

    /* renamed from: c  reason: collision with root package name */
    public String f49150c;

    /* renamed from: d  reason: collision with root package name */
    public int f49151d;

    /* renamed from: e  reason: collision with root package name */
    public String f49152e;

    /* renamed from: f  reason: collision with root package name */
    public String f49153f;

    /* renamed from: g  reason: collision with root package name */
    public String f49154g;

    /* renamed from: h  reason: collision with root package name */
    public float f49155h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49156i = true;

    public int a() {
        return this.f49148a;
    }

    public String b() {
        return this.f49149b;
    }

    public String c() {
        return this.f49153f;
    }

    public int d() {
        return this.f49151d;
    }

    public String e() {
        return this.f49150c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f49150c)) {
            return false;
        }
        int i2 = this.f49151d;
        if (i2 != 1) {
            return i2 == 2 && !StringUtils.isNull(this.f49152e);
        }
        int i3 = this.f49148a;
        return i3 == 1 || i3 == 4 || i3 == 2 || i3 == 3;
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
            int d2 = d.a.c.e.m.b.d(split[0], 1);
            int d3 = d.a.c.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f49155h = d2 / d3;
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
            this.f49148a = jSONObject.optInt("bannerType");
            this.f49149b = jSONObject.optString("bannerUrl");
            this.f49150c = jSONObject.optString("value");
            this.f49151d = jSONObject.optInt("type");
            this.f49152e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f49153f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f49154g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f49148a = banner.banner_type.intValue();
        this.f49149b = banner.banner_url;
        this.f49150c = banner.value;
        this.f49151d = banner.type.intValue();
        this.f49152e = banner.desc;
        banner.template_id.intValue();
        this.f49153f = banner.obj_id;
        String str = banner.tag_name;
        this.f49154g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
