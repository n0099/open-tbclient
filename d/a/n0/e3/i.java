package d.a.n0.e3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f54043a;

    /* renamed from: b  reason: collision with root package name */
    public String f54044b;

    /* renamed from: c  reason: collision with root package name */
    public String f54045c;

    /* renamed from: d  reason: collision with root package name */
    public int f54046d;

    /* renamed from: e  reason: collision with root package name */
    public String f54047e;

    /* renamed from: f  reason: collision with root package name */
    public String f54048f;

    /* renamed from: g  reason: collision with root package name */
    public String f54049g;

    /* renamed from: h  reason: collision with root package name */
    public int f54050h;

    /* renamed from: i  reason: collision with root package name */
    public long f54051i;
    public List<j> j;
    public int k;
    public List<String> l;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.f54051i;
    }

    public String c() {
        return this.f54044b;
    }

    public String d() {
        return this.f54045c;
    }

    public int e() {
        return this.f54050h;
    }

    public String f() {
        return this.f54049g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f54047e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f54043a;
    }

    public int k() {
        return this.f54046d;
    }

    public String l() {
        return this.f54048f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f54043a = businessPromot.title;
        this.f54044b = businessPromot.img;
        this.f54045c = businessPromot.img_popup;
        this.f54046d = businessPromot.type.intValue();
        this.f54047e = businessPromot.thread_id;
        this.f54048f = businessPromot.url;
        this.f54049g = businessPromot.schema;
        this.f54050h = businessPromot.join_num.intValue();
        this.f54051i = businessPromot.id.longValue();
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
