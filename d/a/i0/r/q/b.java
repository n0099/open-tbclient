package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f49071a;

    /* renamed from: b  reason: collision with root package name */
    public int f49072b;

    /* renamed from: c  reason: collision with root package name */
    public int f49073c;

    /* renamed from: d  reason: collision with root package name */
    public int f49074d;

    /* renamed from: e  reason: collision with root package name */
    public String f49075e;

    /* renamed from: f  reason: collision with root package name */
    public int f49076f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49077g;

    /* renamed from: h  reason: collision with root package name */
    public int f49078h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f49079i = 1;
    public v1 j;

    public int a() {
        return this.f49071a;
    }

    public int b() {
        return this.f49073c;
    }

    public int c() {
        return this.f49074d;
    }

    public boolean d() {
        return this.f49077g;
    }

    public int e() {
        return this.f49072b;
    }

    public int f() {
        return this.f49076f;
    }

    public String g() {
        return this.f49075e;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49071a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f49072b = jSONObject.optInt("status");
            this.f49073c = jSONObject.optInt("begin_time");
            this.f49074d = jSONObject.optInt("end_time");
            this.f49075e = jSONObject.optString("url");
            this.f49076f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f49077g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!d.a.c.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f49078h = d.a.c.e.m.b.d(split[0], 1);
                this.f49079i = d.a.c.e.m.b.d(split[1], 1);
            }
            if (this.f49078h <= 0) {
                this.f49078h = 1;
            }
            if (this.f49079i <= 0) {
                this.f49079i = 1;
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
        this.f49071a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f49072b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f49073c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f49074d = num4 != null ? num4.intValue() : -1;
        this.f49075e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f49076f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f49077g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!d.a.c.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f49078h = d.a.c.e.m.b.d(split[0], 1);
                this.f49079i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f49078h <= 0) {
            this.f49078h = 1;
        }
        if (this.f49079i <= 0) {
            this.f49079i = 1;
        }
        v1 v1Var = new v1();
        this.j = v1Var;
        v1Var.a(actInfo.lottery_senior);
    }
}
