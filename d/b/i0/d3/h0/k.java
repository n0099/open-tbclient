package d.b.i0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class k implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f54831a;

    /* renamed from: b  reason: collision with root package name */
    public String f54832b;

    /* renamed from: c  reason: collision with root package name */
    public int f54833c;

    /* renamed from: d  reason: collision with root package name */
    public int f54834d;

    public k(Timgs timgs) {
        this.f54831a = null;
        this.f54832b = null;
        this.f54833c = 1;
        this.f54834d = 1;
        if (timgs == null) {
            return;
        }
        this.f54831a = timgs.img_url;
        timgs.flag.intValue();
        this.f54832b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f54833c = d.b.c.e.m.b.d(split[0], 1);
                this.f54834d = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f54833c <= 0) {
            this.f54833c = 1;
        }
        if (this.f54834d <= 0) {
            this.f54834d = 1;
        }
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f54831a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f54832b;
    }

    public String c() {
        return this.f54831a;
    }

    public k(JSONObject jSONObject) {
        this.f54831a = null;
        this.f54832b = null;
        this.f54833c = 1;
        this.f54834d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54831a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f54832b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f54833c = Integer.valueOf(split[0]).intValue();
                    this.f54834d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f54833c <= 0) {
                this.f54833c = 1;
            }
            if (this.f54834d <= 0) {
                this.f54834d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
