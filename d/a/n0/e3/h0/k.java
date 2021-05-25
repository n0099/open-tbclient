package d.a.n0.e3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class k implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f54009a;

    /* renamed from: b  reason: collision with root package name */
    public String f54010b;

    /* renamed from: c  reason: collision with root package name */
    public int f54011c;

    /* renamed from: d  reason: collision with root package name */
    public int f54012d;

    public k(Timgs timgs) {
        this.f54009a = null;
        this.f54010b = null;
        this.f54011c = 1;
        this.f54012d = 1;
        if (timgs == null) {
            return;
        }
        this.f54009a = timgs.img_url;
        timgs.flag.intValue();
        this.f54010b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f54011c = d.a.c.e.m.b.d(split[0], 1);
                this.f54012d = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f54011c <= 0) {
            this.f54011c = 1;
        }
        if (this.f54012d <= 0) {
            this.f54012d = 1;
        }
    }

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f54009a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f54010b;
    }

    public String c() {
        return this.f54009a;
    }

    public k(JSONObject jSONObject) {
        this.f54009a = null;
        this.f54010b = null;
        this.f54011c = 1;
        this.f54012d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54009a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f54010b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f54011c = Integer.valueOf(split[0]).intValue();
                    this.f54012d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f54011c <= 0) {
                this.f54011c = 1;
            }
            if (this.f54012d <= 0) {
                this.f54012d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
