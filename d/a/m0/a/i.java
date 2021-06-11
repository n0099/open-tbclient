package d.a.m0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes3.dex */
public class i {
    public static final String l = TbadkCoreApplication.getInst().getString(R.string.tb_token);
    public static final String m = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
    public static final String n = TbadkCoreApplication.getInst().getString(R.string.cancel);
    public static final String o = TbadkCoreApplication.getInst().getString(R.string.check_immediately);

    /* renamed from: a  reason: collision with root package name */
    public String f52400a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f52401b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f52402c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f52403d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f52404e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f52405f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f52406g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f52407h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f52408i;
    public String j;
    public Integer k;

    public String a() {
        return this.f52405f;
    }

    public String b() {
        return this.f52404e;
    }

    public String c() {
        return this.f52401b;
    }

    public String d() {
        return this.f52402c;
    }

    public String e() {
        return this.f52400a;
    }

    public String f() {
        return this.f52403d;
    }

    public int g() {
        return this.f52408i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.f52408i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f52400a = dataRes.title;
                this.f52403d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f52403d = dataRes.url;
                this.f52400a = dataRes.title;
                this.f52401b = dataRes.img;
                this.f52402c = dataRes.tips;
                this.f52404e = dataRes.btn_sure;
                this.f52405f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f52400a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f52401b = dataRes.img;
        this.f52402c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f52406g = jSONObject.optString("appid");
                this.f52407h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f52403d = d.a.n0.u.a.a(this.f52406g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f52404e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f52405f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
