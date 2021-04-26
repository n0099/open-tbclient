package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.a.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f49057a;

    /* renamed from: b  reason: collision with root package name */
    public String f49058b;

    /* renamed from: c  reason: collision with root package name */
    public String f49059c;

    /* renamed from: d  reason: collision with root package name */
    public String f49060d;

    /* renamed from: e  reason: collision with root package name */
    public String f49061e;

    /* renamed from: f  reason: collision with root package name */
    public String f49062f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49063g;

    /* renamed from: h  reason: collision with root package name */
    public String f49064h;

    /* renamed from: i  reason: collision with root package name */
    public float f49065i;
    public List<String> j;

    public a0(String str, String str2, String str3) {
        this.f49057a = str;
        this.f49058b = str2;
        this.f49060d = str3;
    }

    @Override // d.a.i0.r.w.b.a
    public String a() {
        return this.f49057a;
    }

    @Override // d.a.i0.r.w.b.a
    public String b() {
        return this.f49058b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f49057a = this.f49057a;
        a0Var.f49058b = this.f49058b;
        a0Var.f49059c = this.f49059c;
        a0Var.f49060d = this.f49060d;
        a0Var.f49061e = this.f49061e;
        a0Var.f49062f = this.f49062f;
        a0Var.f49064h = this.f49064h;
        a0Var.f49065i = this.f49065i;
        a0Var.j = this.j;
        return a0Var;
    }

    public String d() {
        return this.f49057a;
    }

    public String e() {
        return this.f49058b;
    }

    public String f() {
        return this.f49059c;
    }

    public String g() {
        return this.f49064h;
    }

    public float h() {
        return this.f49065i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.f49063g;
    }

    public void k(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f49057a = headImgs.img_url;
        this.f49058b = headImgs.pc_url;
        this.f49059c = headImgs.schema;
        this.f49064h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.a.c.e.m.b.d(split[0], 1);
                int d3 = d.a.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.f49065i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f49060d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f49061e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f49062f = str4.trim();
        }
        this.j = headImgs.third_statistics_url;
    }

    public void l(String str) {
        this.f49057a = str;
    }

    public void m(String str) {
        this.f49058b = str;
    }

    public void n(boolean z) {
        this.f49063g = z;
    }

    public a0() {
    }
}
