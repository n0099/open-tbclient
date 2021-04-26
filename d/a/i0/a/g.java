package d.a.i0.a;

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
    public String f47863a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f47864b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f47865c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f47866d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f47867e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f47868f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f47869g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f47870h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f47871i;
    public String j;
    public Integer k;

    public String a() {
        return this.f47868f;
    }

    public String b() {
        return this.f47867e;
    }

    public String c() {
        return this.f47864b;
    }

    public String d() {
        return this.f47865c;
    }

    public String e() {
        return this.f47863a;
    }

    public String f() {
        return this.f47866d;
    }

    public int g() {
        return this.f47871i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.f47871i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f47863a = dataRes.title;
                this.f47866d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f47866d = dataRes.url;
                this.f47863a = dataRes.title;
                this.f47864b = dataRes.img;
                this.f47865c = dataRes.tips;
                this.f47867e = dataRes.btn_sure;
                this.f47868f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f47863a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f47864b = dataRes.img;
        this.f47865c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f47869g = jSONObject.optString("appid");
                this.f47870h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f47866d = d.a.j0.s.a.a(this.f47869g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f47867e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f47868f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
