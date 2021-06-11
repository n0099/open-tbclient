package d.a.m0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f53687a;

    /* renamed from: b  reason: collision with root package name */
    public String f53688b;

    /* renamed from: c  reason: collision with root package name */
    public String f53689c;

    /* renamed from: d  reason: collision with root package name */
    public int f53690d;

    /* renamed from: e  reason: collision with root package name */
    public String f53691e;

    /* renamed from: f  reason: collision with root package name */
    public String f53692f;

    /* renamed from: g  reason: collision with root package name */
    public String f53693g;

    /* renamed from: h  reason: collision with root package name */
    public float f53694h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53695i = true;

    public int a() {
        return this.f53687a;
    }

    public String b() {
        return this.f53688b;
    }

    public String c() {
        return this.f53692f;
    }

    public int d() {
        return this.f53690d;
    }

    public String e() {
        return this.f53689c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f53689c)) {
            return false;
        }
        int i2 = this.f53690d;
        if (i2 != 1) {
            return i2 == 2 && !StringUtils.isNull(this.f53691e);
        }
        int i3 = this.f53687a;
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
                this.f53694h = d2 / d3;
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
            this.f53687a = jSONObject.optInt("bannerType");
            this.f53688b = jSONObject.optString("bannerUrl");
            this.f53689c = jSONObject.optString("value");
            this.f53690d = jSONObject.optInt("type");
            this.f53691e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f53692f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f53693g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f53687a = banner.banner_type.intValue();
        this.f53688b = banner.banner_url;
        this.f53689c = banner.value;
        this.f53690d = banner.type.intValue();
        this.f53691e = banner.desc;
        banner.template_id.intValue();
        this.f53692f = banner.obj_id;
        String str = banner.tag_name;
        this.f53693g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
