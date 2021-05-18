package d.a.j0.a;

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
    public String f48702a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f48703b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f48704c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f48705d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f48706e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f48707f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f48708g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f48709h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f48710i;
    public String j;
    public Integer k;

    public String a() {
        return this.f48707f;
    }

    public String b() {
        return this.f48706e;
    }

    public String c() {
        return this.f48703b;
    }

    public String d() {
        return this.f48704c;
    }

    public String e() {
        return this.f48702a;
    }

    public String f() {
        return this.f48705d;
    }

    public int g() {
        return this.f48710i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.f48710i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f48702a = dataRes.title;
                this.f48705d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f48705d = dataRes.url;
                this.f48702a = dataRes.title;
                this.f48703b = dataRes.img;
                this.f48704c = dataRes.tips;
                this.f48706e = dataRes.btn_sure;
                this.f48707f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f48702a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f48703b = dataRes.img;
        this.f48704c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f48708g = jSONObject.optString("appid");
                this.f48709h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f48705d = d.a.k0.s.a.a(this.f48708g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f48706e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f48707f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
