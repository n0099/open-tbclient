package d.a.m0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes3.dex */
public class h {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.tb_token);
    public static final String m = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
    public static final String n = TbadkCoreApplication.getInst().getString(R.string.cancel);
    public static final String o = TbadkCoreApplication.getInst().getString(R.string.check_immediately);

    /* renamed from: a  reason: collision with root package name */
    public String f48724a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f48725b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f48726c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f48727d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f48728e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f48729f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f48730g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f48731h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f48732i;
    public String j;
    public Integer k;

    public String a() {
        return this.f48729f;
    }

    public String b() {
        return this.f48728e;
    }

    public String c() {
        return this.f48725b;
    }

    public String d() {
        return this.f48726c;
    }

    public String e() {
        return this.f48724a;
    }

    public String f() {
        return this.f48727d;
    }

    public int g() {
        return this.f48732i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.f48732i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f48724a = dataRes.title;
                this.f48727d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f48727d = dataRes.url;
                this.f48724a = dataRes.title;
                this.f48725b = dataRes.img;
                this.f48726c = dataRes.tips;
                this.f48728e = dataRes.btn_sure;
                this.f48729f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f48724a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f48725b = dataRes.img;
        this.f48726c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f48730g = jSONObject.optString("appid");
                this.f48731h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f48727d = d.a.n0.u.a.a(this.f48730g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f48728e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f48729f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
