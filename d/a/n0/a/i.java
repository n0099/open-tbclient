package d.a.n0.a;

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
    public String f52507a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f52508b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f52509c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f52510d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f52511e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f52512f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f52513g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f52514h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f52515i;
    public String j;
    public Integer k;

    public String a() {
        return this.f52512f;
    }

    public String b() {
        return this.f52511e;
    }

    public String c() {
        return this.f52508b;
    }

    public String d() {
        return this.f52509c;
    }

    public String e() {
        return this.f52507a;
    }

    public String f() {
        return this.f52510d;
    }

    public int g() {
        return this.f52515i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.f52515i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f52507a = dataRes.title;
                this.f52510d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f52510d = dataRes.url;
                this.f52507a = dataRes.title;
                this.f52508b = dataRes.img;
                this.f52509c = dataRes.tips;
                this.f52511e = dataRes.btn_sure;
                this.f52512f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f52507a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f52508b = dataRes.img;
        this.f52509c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f52513g = jSONObject.optString("appid");
                this.f52514h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f52510d = d.a.o0.u.a.a(this.f52513g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f52511e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f52512f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
