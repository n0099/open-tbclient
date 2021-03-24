package d.b.i0.c3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes5.dex */
public class k implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f53388a;

    /* renamed from: b  reason: collision with root package name */
    public String f53389b;

    /* renamed from: c  reason: collision with root package name */
    public int f53390c;

    /* renamed from: d  reason: collision with root package name */
    public int f53391d;

    public k(Timgs timgs) {
        this.f53388a = null;
        this.f53389b = null;
        this.f53390c = 1;
        this.f53391d = 1;
        if (timgs == null) {
            return;
        }
        this.f53388a = timgs.img_url;
        timgs.flag.intValue();
        this.f53389b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f53390c = d.b.b.e.m.b.d(split[0], 1);
                this.f53391d = d.b.b.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53390c <= 0) {
            this.f53390c = 1;
        }
        if (this.f53391d <= 0) {
            this.f53391d = 1;
        }
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f53388a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f53389b;
    }

    public String c() {
        return this.f53388a;
    }

    public k(JSONObject jSONObject) {
        this.f53388a = null;
        this.f53389b = null;
        this.f53390c = 1;
        this.f53391d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53388a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f53389b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f53390c = Integer.valueOf(split[0]).intValue();
                    this.f53391d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f53390c <= 0) {
                this.f53390c = 1;
            }
            if (this.f53391d <= 0) {
                this.f53391d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
