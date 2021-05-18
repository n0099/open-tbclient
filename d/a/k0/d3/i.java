package d.a.k0.d3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f53830a;

    /* renamed from: b  reason: collision with root package name */
    public String f53831b;

    /* renamed from: c  reason: collision with root package name */
    public String f53832c;

    /* renamed from: d  reason: collision with root package name */
    public int f53833d;

    /* renamed from: e  reason: collision with root package name */
    public String f53834e;

    /* renamed from: f  reason: collision with root package name */
    public String f53835f;

    /* renamed from: g  reason: collision with root package name */
    public String f53836g;

    /* renamed from: h  reason: collision with root package name */
    public int f53837h;

    /* renamed from: i  reason: collision with root package name */
    public long f53838i;
    public List<j> j;
    public int k;
    public List<String> l;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.f53838i;
    }

    public String c() {
        return this.f53831b;
    }

    public String d() {
        return this.f53832c;
    }

    public int e() {
        return this.f53837h;
    }

    public String f() {
        return this.f53836g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f53834e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f53830a;
    }

    public int k() {
        return this.f53833d;
    }

    public String l() {
        return this.f53835f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f53830a = businessPromot.title;
        this.f53831b = businessPromot.img;
        this.f53832c = businessPromot.img_popup;
        this.f53833d = businessPromot.type.intValue();
        this.f53834e = businessPromot.thread_id;
        this.f53835f = businessPromot.url;
        this.f53836g = businessPromot.schema;
        this.f53837h = businessPromot.join_num.intValue();
        this.f53838i = businessPromot.id.longValue();
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
