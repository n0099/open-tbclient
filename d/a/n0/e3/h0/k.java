package d.a.n0.e3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class k implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f57698a;

    /* renamed from: b  reason: collision with root package name */
    public String f57699b;

    /* renamed from: c  reason: collision with root package name */
    public int f57700c;

    /* renamed from: d  reason: collision with root package name */
    public int f57701d;

    public k(Timgs timgs) {
        this.f57698a = null;
        this.f57699b = null;
        this.f57700c = 1;
        this.f57701d = 1;
        if (timgs == null) {
            return;
        }
        this.f57698a = timgs.img_url;
        timgs.flag.intValue();
        this.f57699b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f57700c = d.a.c.e.m.b.d(split[0], 1);
                this.f57701d = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f57700c <= 0) {
            this.f57700c = 1;
        }
        if (this.f57701d <= 0) {
            this.f57701d = 1;
        }
    }

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f57698a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f57699b;
    }

    public String c() {
        return this.f57698a;
    }

    public k(JSONObject jSONObject) {
        this.f57698a = null;
        this.f57699b = null;
        this.f57700c = 1;
        this.f57701d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f57698a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f57699b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f57700c = Integer.valueOf(split[0]).intValue();
                    this.f57701d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f57700c <= 0) {
                this.f57700c = 1;
            }
            if (this.f57701d <= 0) {
                this.f57701d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
