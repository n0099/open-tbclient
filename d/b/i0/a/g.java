package d.b.i0.a;

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
    public String f50312a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f50313b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f50314c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f50315d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f50316e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f50317f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f50318g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f50319h = "";
    public int i;
    public String j;
    public Integer k;

    public String a() {
        return this.f50317f;
    }

    public String b() {
        return this.f50316e;
    }

    public String c() {
        return this.f50313b;
    }

    public String d() {
        return this.f50314c;
    }

    public String e() {
        return this.f50312a;
    }

    public String f() {
        return this.f50315d;
    }

    public int g() {
        return this.i;
    }

    public void h(DataRes dataRes) {
        int intValue = dataRes.type.intValue();
        this.i = intValue;
        if (intValue != 0 && intValue != 1) {
            if (intValue == 2) {
                this.f50312a = dataRes.title;
                this.f50315d = dataRes.url;
                return;
            } else if (intValue != 4 && intValue == 3) {
                this.f50315d = dataRes.url;
                this.f50312a = dataRes.title;
                this.f50313b = dataRes.img;
                this.f50314c = dataRes.tips;
                this.f50316e = dataRes.btn_sure;
                this.f50317f = dataRes.btn_cancel;
                return;
            } else {
                return;
            }
        }
        this.f50312a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
        this.f50313b = dataRes.img;
        this.f50314c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.f50318g = jSONObject.optString("appid");
                this.f50319h = jSONObject.optString("appname");
                String optString = jSONObject.optString("url");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                this.k = valueOf;
                this.f50315d = d.b.j0.s.a.a(this.f50318g, optString, "9104", valueOf);
                this.j = jSONObject.optString("swan_app_id");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.f50316e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
        this.f50317f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
    }
}
