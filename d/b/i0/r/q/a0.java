package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.b.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f51437a;

    /* renamed from: b  reason: collision with root package name */
    public String f51438b;

    /* renamed from: c  reason: collision with root package name */
    public String f51439c;

    /* renamed from: d  reason: collision with root package name */
    public String f51440d;

    /* renamed from: e  reason: collision with root package name */
    public String f51441e;

    /* renamed from: f  reason: collision with root package name */
    public String f51442f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51443g;

    /* renamed from: h  reason: collision with root package name */
    public String f51444h;
    public float i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f51437a = str;
        this.f51438b = str2;
        this.f51440d = str3;
    }

    @Override // d.b.i0.r.w.b.a
    public String a() {
        return this.f51437a;
    }

    @Override // d.b.i0.r.w.b.a
    public String b() {
        return this.f51438b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f51437a = this.f51437a;
        a0Var.f51438b = this.f51438b;
        a0Var.f51439c = this.f51439c;
        a0Var.f51440d = this.f51440d;
        a0Var.f51441e = this.f51441e;
        a0Var.f51442f = this.f51442f;
        a0Var.f51444h = this.f51444h;
        a0Var.i = this.i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f51437a;
    }

    public String e() {
        return this.f51438b;
    }

    public String f() {
        return this.f51439c;
    }

    public String g() {
        return this.f51444h;
    }

    public float h() {
        return this.i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f51443g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f51437a = headImgs.img_url;
        this.f51438b = headImgs.pc_url;
        this.f51439c = headImgs.schema;
        this.f51444h = headImgs.tag_name_url;
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
            this.f51440d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f51441e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f51442f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f51437a = str;
    }

    public void m(String str) {
        this.f51438b = str;
    }

    public void n(boolean z) {
        this.f51443g = z;
    }

    public a0() {
    }
}
