package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f51101a;

    /* renamed from: b  reason: collision with root package name */
    public String f51102b;

    /* renamed from: c  reason: collision with root package name */
    public String f51103c;

    /* renamed from: d  reason: collision with root package name */
    public String f51104d;

    /* renamed from: e  reason: collision with root package name */
    public String f51105e;

    /* renamed from: f  reason: collision with root package name */
    public String f51106f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51107g;

    /* renamed from: h  reason: collision with root package name */
    public String f51108h;
    public float i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f51101a = str;
        this.f51102b = str2;
        this.f51104d = str3;
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f51101a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f51102b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f51101a = this.f51101a;
        a0Var.f51102b = this.f51102b;
        a0Var.f51103c = this.f51103c;
        a0Var.f51104d = this.f51104d;
        a0Var.f51105e = this.f51105e;
        a0Var.f51106f = this.f51106f;
        a0Var.f51108h = this.f51108h;
        a0Var.i = this.i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f51101a;
    }

    public String e() {
        return this.f51102b;
    }

    public String f() {
        return this.f51103c;
    }

    public String g() {
        return this.f51108h;
    }

    public float h() {
        return this.i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f51107g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f51101a = headImgs.img_url;
        this.f51102b = headImgs.pc_url;
        this.f51103c = headImgs.schema;
        this.f51108h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.b.c.e.m.b.d(split[0], 1);
                int d3 = d.b.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f51104d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f51105e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f51106f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f51101a = str;
    }

    public void m(String str) {
        this.f51102b = str;
    }

    public void n(boolean z) {
        this.f51107g = z;
    }

    public a0() {
    }
}
