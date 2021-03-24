package d.b.h0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes3.dex */
public class g {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.tb_token);
    public static final String m = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
    public static final String n = TbadkCoreApplication.getInst().getString(R.string.cancel);
    public static final String o = TbadkCoreApplication.getInst().getString(R.string.check_immediately);

    /* renamed from: a  reason: collision with root package name */
    public String f49583a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f49584b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f49585c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f49586d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f49587e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f49588f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f49589g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f49590h = "";
    public int i;
    public String j;
    public Integer k;

    public String a() {
        return this.f49588f;
    }

    public String b() {
        return this.f49587e;
    }

    public String c() {
        return this.f49584b;
    }

    public String d() {
        return this.f49585c;
    }

    public String e() {
        return this.f49583a;
    }

    public String f() {
        return this.f49586d;
    }

    public int g() {
        return this.i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f49583a = dataRes.title;
                this.f49586d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f49586d = dataRes.url;
                this.f49583a = dataRes.title;
                this.f49584b = dataRes.img;
                this.f49585c = dataRes.tips;
                this.f49587e = dataRes.btn_sure;
                this.f49588f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f49583a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f49584b = dataRes.img;
        this.f49585c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f49589g = jSONObject.optString("appid");
                this.f49590h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f49586d = d.b.i0.s.a.a(this.f49589g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f49587e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f49588f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
