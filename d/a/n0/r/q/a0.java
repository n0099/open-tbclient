package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.a.n0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f53703a;

    /* renamed from: b  reason: collision with root package name */
    public String f53704b;

    /* renamed from: c  reason: collision with root package name */
    public String f53705c;

    /* renamed from: d  reason: collision with root package name */
    public String f53706d;

    /* renamed from: e  reason: collision with root package name */
    public String f53707e;

    /* renamed from: f  reason: collision with root package name */
    public String f53708f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53709g;

    /* renamed from: h  reason: collision with root package name */
    public String f53710h;

    /* renamed from: i  reason: collision with root package name */
    public float f53711i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f53703a = str;
        this.f53704b = str2;
        this.f53706d = str3;
    }

    @Override // d.a.n0.r.w.b.a
    public String a() {
        return this.f53703a;
    }

    @Override // d.a.n0.r.w.b.a
    public String b() {
        return this.f53704b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f53703a = this.f53703a;
        a0Var.f53704b = this.f53704b;
        a0Var.f53705c = this.f53705c;
        a0Var.f53706d = this.f53706d;
        a0Var.f53707e = this.f53707e;
        a0Var.f53708f = this.f53708f;
        a0Var.f53710h = this.f53710h;
        a0Var.f53711i = this.f53711i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f53703a;
    }

    public String e() {
        return this.f53704b;
    }

    public String f() {
        return this.f53705c;
    }

    public String g() {
        return this.f53710h;
    }

    public float h() {
        return this.f53711i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f53709g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f53703a = headImgs.img_url;
        this.f53704b = headImgs.pc_url;
        this.f53705c = headImgs.schema;
        this.f53710h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.a.c.e.m.b.d(split[0], 1);
                int d3 = d.a.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.f53711i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f53706d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f53707e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f53708f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f53703a = str;
    }

    public void m(String str) {
        this.f53704b = str;
    }

    public void n(boolean z) {
        this.f53709g = z;
    }

    public a0() {
    }
}
