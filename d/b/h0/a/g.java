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
    public String f49584a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f49585b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f49586c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f49587d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f49588e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f49589f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f49590g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f49591h = "";
    public int i;
    public String j;
    public Integer k;

    public String a() {
        return this.f49589f;
    }

    public String b() {
        return this.f49588e;
    }

    public String c() {
        return this.f49585b;
    }

    public String d() {
        return this.f49586c;
    }

    public String e() {
        return this.f49584a;
    }

    public String f() {
        return this.f49587d;
    }

    public int g() {
        return this.i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f49584a = dataRes.title;
                this.f49587d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f49587d = dataRes.url;
                this.f49584a = dataRes.title;
                this.f49585b = dataRes.img;
                this.f49586c = dataRes.tips;
                this.f49588e = dataRes.btn_sure;
                this.f49589f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f49584a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f49585b = dataRes.img;
        this.f49586c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f49590g = jSONObject.optString("appid");
                this.f49591h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f49587d = d.b.i0.s.a.a(this.f49590g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f49588e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f49589f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
