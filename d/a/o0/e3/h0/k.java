package d.a.o0.e3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class k implements d.a.n0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f57823a;

    /* renamed from: b  reason: collision with root package name */
    public String f57824b;

    /* renamed from: c  reason: collision with root package name */
    public int f57825c;

    /* renamed from: d  reason: collision with root package name */
    public int f57826d;

    public k(Timgs timgs) {
        this.f57823a = null;
        this.f57824b = null;
        this.f57825c = 1;
        this.f57826d = 1;
        if (timgs == null) {
            return;
        }
        this.f57823a = timgs.img_url;
        timgs.flag.intValue();
        this.f57824b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f57825c = d.a.c.e.m.b.d(split[0], 1);
                this.f57826d = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f57825c <= 0) {
            this.f57825c = 1;
        }
        if (this.f57826d <= 0) {
            this.f57826d = 1;
        }
    }

    @Override // d.a.n0.r.w.b.a
    public String a() {
        return this.f57823a;
    }

    @Override // d.a.n0.r.w.b.a
    public String b() {
        return this.f57824b;
    }

    public String c() {
        return this.f57823a;
    }

    public k(JSONObject jSONObject) {
        this.f57823a = null;
        this.f57824b = null;
        this.f57825c = 1;
        this.f57826d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f57823a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f57824b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f57825c = Integer.valueOf(split[0]).intValue();
                    this.f57826d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f57825c <= 0) {
                this.f57825c = 1;
            }
            if (this.f57826d <= 0) {
                this.f57826d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
