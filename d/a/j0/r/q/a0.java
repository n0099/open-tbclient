package d.a.j0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.a.j0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f49876a;

    /* renamed from: b  reason: collision with root package name */
    public String f49877b;

    /* renamed from: c  reason: collision with root package name */
    public String f49878c;

    /* renamed from: d  reason: collision with root package name */
    public String f49879d;

    /* renamed from: e  reason: collision with root package name */
    public String f49880e;

    /* renamed from: f  reason: collision with root package name */
    public String f49881f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49882g;

    /* renamed from: h  reason: collision with root package name */
    public String f49883h;

    /* renamed from: i  reason: collision with root package name */
    public float f49884i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f49876a = str;
        this.f49877b = str2;
        this.f49879d = str3;
    }

    @Override // d.a.j0.r.w.b.a
    public String a() {
        return this.f49876a;
    }

    @Override // d.a.j0.r.w.b.a
    public String b() {
        return this.f49877b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f49876a = this.f49876a;
        a0Var.f49877b = this.f49877b;
        a0Var.f49878c = this.f49878c;
        a0Var.f49879d = this.f49879d;
        a0Var.f49880e = this.f49880e;
        a0Var.f49881f = this.f49881f;
        a0Var.f49883h = this.f49883h;
        a0Var.f49884i = this.f49884i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f49876a;
    }

    public String e() {
        return this.f49877b;
    }

    public String f() {
        return this.f49878c;
    }

    public String g() {
        return this.f49883h;
    }

    public float h() {
        return this.f49884i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f49882g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f49876a = headImgs.img_url;
        this.f49877b = headImgs.pc_url;
        this.f49878c = headImgs.schema;
        this.f49883h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.a.c.e.m.b.d(split[0], 1);
                int d3 = d.a.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.f49884i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f49879d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f49880e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f49881f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f49876a = str;
    }

    public void m(String str) {
        this.f49877b = str;
    }

    public void n(boolean z) {
        this.f49882g = z;
    }

    public a0() {
    }
}
