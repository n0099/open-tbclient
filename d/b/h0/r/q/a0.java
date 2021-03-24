package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class a0 implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f50693a;

    /* renamed from: b  reason: collision with root package name */
    public String f50694b;

    /* renamed from: c  reason: collision with root package name */
    public String f50695c;

    /* renamed from: d  reason: collision with root package name */
    public String f50696d;

    /* renamed from: e  reason: collision with root package name */
    public String f50697e;

    /* renamed from: f  reason: collision with root package name */
    public String f50698f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50699g;

    /* renamed from: h  reason: collision with root package name */
    public String f50700h;
    public float i;

    public a0(String str, String str2, String str3) {
        this.f50693a = str;
        this.f50694b = str2;
        this.f50696d = str3;
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f50693a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f50694b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public a0 clone() {
        a0 a0Var = new a0();
        a0Var.f50693a = this.f50693a;
        a0Var.f50694b = this.f50694b;
        a0Var.f50695c = this.f50695c;
        a0Var.f50696d = this.f50696d;
        a0Var.f50697e = this.f50697e;
        a0Var.f50698f = this.f50698f;
        a0Var.f50700h = this.f50700h;
        a0Var.i = this.i;
        return a0Var;
    }

    public String d() {
        return this.f50693a;
    }

    public String e() {
        return this.f50694b;
    }

    public String f() {
        return this.f50695c;
    }

    public String g() {
        return this.f50700h;
    }

    public float h() {
        return this.i;
    }

    public boolean i() {
        return this.f50699g;
    }

    public void j(HeadImgs headImgs) {
        if (headImgs == null) {
            return;
        }
        this.f50693a = headImgs.img_url;
        this.f50694b = headImgs.pc_url;
        this.f50695c = headImgs.schema;
        this.f50700h = headImgs.tag_name_url;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int d2 = d.b.b.e.m.b.d(split[0], 1);
                int d3 = d.b.b.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.i = d2 / d3;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.f50696d = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.f50697e = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.f50698f = str4.trim();
        }
    }

    public void k(String str) {
        this.f50693a = str;
    }

    public void l(String str) {
        this.f50694b = str;
    }

    public void m(boolean z) {
        this.f50699g = z;
    }

    public a0() {
    }
}
