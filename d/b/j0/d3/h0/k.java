package d.b.j0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class k implements d.b.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f55252a;

    /* renamed from: b  reason: collision with root package name */
    public String f55253b;

    /* renamed from: c  reason: collision with root package name */
    public int f55254c;

    /* renamed from: d  reason: collision with root package name */
    public int f55255d;

    public k(Timgs timgs) {
        this.f55252a = null;
        this.f55253b = null;
        this.f55254c = 1;
        this.f55255d = 1;
        if (timgs == null) {
            return;
        }
        this.f55252a = timgs.img_url;
        timgs.flag.intValue();
        this.f55253b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f55254c = d.b.c.e.m.b.d(split[0], 1);
                this.f55255d = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f55254c <= 0) {
            this.f55254c = 1;
        }
        if (this.f55255d <= 0) {
            this.f55255d = 1;
        }
    }

    @Override // d.b.i0.r.w.b.a
    public String a() {
        return this.f55252a;
    }

    @Override // d.b.i0.r.w.b.a
    public String b() {
        return this.f55253b;
    }

    public String c() {
        return this.f55252a;
    }

    public k(JSONObject jSONObject) {
        this.f55252a = null;
        this.f55253b = null;
        this.f55254c = 1;
        this.f55255d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f55252a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f55253b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f55254c = Integer.valueOf(split[0]).intValue();
                    this.f55255d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f55254c <= 0) {
                this.f55254c = 1;
            }
            if (this.f55255d <= 0) {
                this.f55255d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
