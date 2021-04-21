package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f51449a;

    /* renamed from: b  reason: collision with root package name */
    public int f51450b;

    /* renamed from: c  reason: collision with root package name */
    public int f51451c;

    /* renamed from: d  reason: collision with root package name */
    public int f51452d;

    /* renamed from: e  reason: collision with root package name */
    public String f51453e;

    /* renamed from: f  reason: collision with root package name */
    public int f51454f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51455g;

    /* renamed from: h  reason: collision with root package name */
    public int f51456h = 1;
    public int i = 1;
    public v1 j;

    public int a() {
        return this.f51449a;
    }

    public int b() {
        return this.f51451c;
    }

    public int c() {
        return this.f51452d;
    }

    public boolean d() {
        return this.f51455g;
    }

    public int e() {
        return this.f51450b;
    }

    public int f() {
        return this.f51454f;
    }

    public String g() {
        return this.f51453e;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51449a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f51450b = jSONObject.optInt("status");
            this.f51451c = jSONObject.optInt("begin_time");
            this.f51452d = jSONObject.optInt("end_time");
            this.f51453e = jSONObject.optString("url");
            this.f51454f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f51455g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!d.b.c.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f51456h = d.b.c.e.m.b.d(split[0], 1);
                this.i = d.b.c.e.m.b.d(split[1], 1);
            }
            if (this.f51456h <= 0) {
                this.f51456h = 1;
            }
            if (this.i <= 0) {
                this.i = 1;
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
        this.f51449a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f51450b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f51451c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f51452d = num4 != null ? num4.intValue() : -1;
        this.f51453e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f51454f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f51455g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!d.b.c.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f51456h = d.b.c.e.m.b.d(split[0], 1);
                this.i = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f51456h <= 0) {
            this.f51456h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        v1 v1Var = new v1();
        this.j = v1Var;
        v1Var.a(actInfo.lottery_senior);
    }
}
