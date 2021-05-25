package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f49920a;

    /* renamed from: b  reason: collision with root package name */
    public String f49921b;

    /* renamed from: c  reason: collision with root package name */
    public String f49922c;

    /* renamed from: d  reason: collision with root package name */
    public String f49923d;

    /* renamed from: e  reason: collision with root package name */
    public String f49924e;

    /* renamed from: f  reason: collision with root package name */
    public String f49925f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49926g;

    /* renamed from: h  reason: collision with root package name */
    public String f49927h;

    /* renamed from: i  reason: collision with root package name */
    public float f49928i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f49920a = str;
        this.f49921b = str2;
        this.f49923d = str3;
    }

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f49920a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f49921b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f49920a = this.f49920a;
        a0Var.f49921b = this.f49921b;
        a0Var.f49922c = this.f49922c;
        a0Var.f49923d = this.f49923d;
        a0Var.f49924e = this.f49924e;
        a0Var.f49925f = this.f49925f;
        a0Var.f49927h = this.f49927h;
        a0Var.f49928i = this.f49928i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f49920a;
    }

    public String e() {
        return this.f49921b;
    }

    public String f() {
        return this.f49922c;
    }

    public String g() {
        return this.f49927h;
    }

    public float h() {
        return this.f49928i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f49926g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f49920a = headImgs.img_url;
        this.f49921b = headImgs.pc_url;
        this.f49922c = headImgs.schema;
        this.f49927h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.a.c.e.m.b.d(split[0], 1);
                int d3 = d.a.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.f49928i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f49923d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f49924e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f49925f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f49920a = str;
    }

    public void m(String str) {
        this.f49921b = str;
    }

    public void n(boolean z) {
        this.f49926g = z;
    }

    public a0() {
    }
}
