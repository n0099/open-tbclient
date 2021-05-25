package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f49934a;

    /* renamed from: b  reason: collision with root package name */
    public int f49935b;

    /* renamed from: c  reason: collision with root package name */
    public int f49936c;

    /* renamed from: d  reason: collision with root package name */
    public int f49937d;

    /* renamed from: e  reason: collision with root package name */
    public String f49938e;

    /* renamed from: f  reason: collision with root package name */
    public int f49939f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49940g;

    /* renamed from: h  reason: collision with root package name */
    public int f49941h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f49942i = 1;
    public v1 j;

    public int a() {
        return this.f49934a;
    }

    public int b() {
        return this.f49936c;
    }

    public int c() {
        return this.f49937d;
    }

    public boolean d() {
        return this.f49940g;
    }

    public int e() {
        return this.f49935b;
    }

    public int f() {
        return this.f49939f;
    }

    public String g() {
        return this.f49938e;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49934a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f49935b = jSONObject.optInt("status");
            this.f49936c = jSONObject.optInt("begin_time");
            this.f49937d = jSONObject.optInt("end_time");
            this.f49938e = jSONObject.optString("url");
            this.f49939f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f49940g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!d.a.c.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f49941h = d.a.c.e.m.b.d(split[0], 1);
                this.f49942i = d.a.c.e.m.b.d(split[1], 1);
            }
            if (this.f49941h <= 0) {
                this.f49941h = 1;
            }
            if (this.f49942i <= 0) {
                this.f49942i = 1;
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
        this.f49934a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f49935b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f49936c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f49937d = num4 != null ? num4.intValue() : -1;
        this.f49938e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f49939f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f49940g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!d.a.c.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f49941h = d.a.c.e.m.b.d(split[0], 1);
                this.f49942i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f49941h <= 0) {
            this.f49941h = 1;
        }
        if (this.f49942i <= 0) {
            this.f49942i = 1;
        }
        v1 v1Var = new v1();
        this.j = v1Var;
        v1Var.a(actInfo.lottery_senior);
    }
}
