package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f53596a;

    /* renamed from: b  reason: collision with root package name */
    public String f53597b;

    /* renamed from: c  reason: collision with root package name */
    public String f53598c;

    /* renamed from: d  reason: collision with root package name */
    public String f53599d;

    /* renamed from: e  reason: collision with root package name */
    public String f53600e;

    /* renamed from: f  reason: collision with root package name */
    public String f53601f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53602g;

    /* renamed from: h  reason: collision with root package name */
    public String f53603h;

    /* renamed from: i  reason: collision with root package name */
    public float f53604i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f53596a = str;
        this.f53597b = str2;
        this.f53599d = str3;
    }

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f53596a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f53597b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f53596a = this.f53596a;
        a0Var.f53597b = this.f53597b;
        a0Var.f53598c = this.f53598c;
        a0Var.f53599d = this.f53599d;
        a0Var.f53600e = this.f53600e;
        a0Var.f53601f = this.f53601f;
        a0Var.f53603h = this.f53603h;
        a0Var.f53604i = this.f53604i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f53596a;
    }

    public String e() {
        return this.f53597b;
    }

    public String f() {
        return this.f53598c;
    }

    public String g() {
        return this.f53603h;
    }

    public float h() {
        return this.f53604i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f53602g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f53596a = headImgs.img_url;
        this.f53597b = headImgs.pc_url;
        this.f53598c = headImgs.schema;
        this.f53603h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.a.c.e.m.b.d(split[0], 1);
                int d3 = d.a.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.f53604i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f53599d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f53600e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f53601f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f53596a = str;
    }

    public void m(String str) {
        this.f53597b = str;
    }

    public void n(boolean z) {
        this.f53602g = z;
    }

    public a0() {
    }
}
