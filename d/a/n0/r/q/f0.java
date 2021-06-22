package d.a.n0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f53794a;

    /* renamed from: b  reason: collision with root package name */
    public String f53795b;

    /* renamed from: c  reason: collision with root package name */
    public String f53796c;

    /* renamed from: d  reason: collision with root package name */
    public int f53797d;

    /* renamed from: e  reason: collision with root package name */
    public String f53798e;

    /* renamed from: f  reason: collision with root package name */
    public String f53799f;

    /* renamed from: g  reason: collision with root package name */
    public String f53800g;

    /* renamed from: h  reason: collision with root package name */
    public float f53801h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53802i = true;

    public int a() {
        return this.f53794a;
    }

    public String b() {
        return this.f53795b;
    }

    public String c() {
        return this.f53799f;
    }

    public int d() {
        return this.f53797d;
    }

    public String e() {
        return this.f53796c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f53796c)) {
            return false;
        }
        int i2 = this.f53797d;
        if (i2 != 1) {
            return i2 == 2 && !StringUtils.isNull(this.f53798e);
        }
        int i3 = this.f53794a;
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
                this.f53801h = d2 / d3;
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
            this.f53794a = jSONObject.optInt("bannerType");
            this.f53795b = jSONObject.optString("bannerUrl");
            this.f53796c = jSONObject.optString("value");
            this.f53797d = jSONObject.optInt("type");
            this.f53798e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f53799f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f53800g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f53794a = banner.banner_type.intValue();
        this.f53795b = banner.banner_url;
        this.f53796c = banner.value;
        this.f53797d = banner.type.intValue();
        this.f53798e = banner.desc;
        banner.template_id.intValue();
        this.f53799f = banner.obj_id;
        String str = banner.tag_name;
        this.f53800g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
