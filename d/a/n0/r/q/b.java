package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f53717a;

    /* renamed from: b  reason: collision with root package name */
    public int f53718b;

    /* renamed from: c  reason: collision with root package name */
    public int f53719c;

    /* renamed from: d  reason: collision with root package name */
    public int f53720d;

    /* renamed from: e  reason: collision with root package name */
    public String f53721e;

    /* renamed from: f  reason: collision with root package name */
    public int f53722f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53723g;

    /* renamed from: h  reason: collision with root package name */
    public int f53724h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f53725i = 1;
    public v1 j;

    public int a() {
        return this.f53717a;
    }

    public int b() {
        return this.f53719c;
    }

    public int c() {
        return this.f53720d;
    }

    public boolean d() {
        return this.f53723g;
    }

    public int e() {
        return this.f53718b;
    }

    public int f() {
        return this.f53722f;
    }

    public String g() {
        return this.f53721e;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53717a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f53718b = jSONObject.optInt("status");
            this.f53719c = jSONObject.optInt("begin_time");
            this.f53720d = jSONObject.optInt(ResultTB.ENDTIME);
            this.f53721e = jSONObject.optString("url");
            this.f53722f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f53723g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!d.a.c.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f53724h = d.a.c.e.m.b.d(split[0], 1);
                this.f53725i = d.a.c.e.m.b.d(split[1], 1);
            }
            if (this.f53724h <= 0) {
                this.f53724h = 1;
            }
            if (this.f53725i <= 0) {
                this.f53725i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(ActInfo actInfo) {
        if (actInfo == null) {
            return;
        }
        Integer num = actInfo.activity_type;
        this.f53717a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f53718b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f53719c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f53720d = num4 != null ? num4.intValue() : -1;
        this.f53721e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f53722f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f53723g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!d.a.c.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f53724h = d.a.c.e.m.b.d(split[0], 1);
                this.f53725i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53724h <= 0) {
            this.f53724h = 1;
        }
        if (this.f53725i <= 0) {
            this.f53725i = 1;
        }
        v1 v1Var = new v1();
        this.j = v1Var;
        v1Var.a(actInfo.lottery_senior);
    }
}
