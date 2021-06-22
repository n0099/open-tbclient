package d.a.o0.e3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f57857a;

    /* renamed from: b  reason: collision with root package name */
    public String f57858b;

    /* renamed from: c  reason: collision with root package name */
    public String f57859c;

    /* renamed from: d  reason: collision with root package name */
    public int f57860d;

    /* renamed from: e  reason: collision with root package name */
    public String f57861e;

    /* renamed from: f  reason: collision with root package name */
    public String f57862f;

    /* renamed from: g  reason: collision with root package name */
    public String f57863g;

    /* renamed from: h  reason: collision with root package name */
    public int f57864h;

    /* renamed from: i  reason: collision with root package name */
    public long f57865i;
    public List<j> j;
    public int k;
    public List<String> l;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.f57865i;
    }

    public String c() {
        return this.f57858b;
    }

    public String d() {
        return this.f57859c;
    }

    public int e() {
        return this.f57864h;
    }

    public String f() {
        return this.f57863g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f57861e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f57857a;
    }

    public int k() {
        return this.f57860d;
    }

    public String l() {
        return this.f57862f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f57857a = businessPromot.title;
        this.f57858b = businessPromot.img;
        this.f57859c = businessPromot.img_popup;
        this.f57860d = businessPromot.type.intValue();
        this.f57861e = businessPromot.thread_id;
        this.f57862f = businessPromot.url;
        this.f57863g = businessPromot.schema;
        this.f57864h = businessPromot.join_num.intValue();
        this.f57865i = businessPromot.id.longValue();
        if (businessPromot.comment_list != null) {
            this.j = new LinkedList();
            for (int i2 = 0; i2 < businessPromot.comment_list.size(); i2++) {
                if (businessPromot.comment_list.get(i2) != null) {
                    j jVar = new j();
                    jVar.c(businessPromot.comment_list.get(i2));
                    this.j.add(jVar);
                }
            }
        }
        this.k = businessPromot.thread_type.intValue();
        this.l = businessPromot.third_statistics_url;
    }
}
