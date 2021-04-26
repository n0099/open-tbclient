package d.a.j0.d3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f53123a;

    /* renamed from: b  reason: collision with root package name */
    public String f53124b;

    /* renamed from: c  reason: collision with root package name */
    public String f53125c;

    /* renamed from: d  reason: collision with root package name */
    public int f53126d;

    /* renamed from: e  reason: collision with root package name */
    public String f53127e;

    /* renamed from: f  reason: collision with root package name */
    public String f53128f;

    /* renamed from: g  reason: collision with root package name */
    public String f53129g;

    /* renamed from: h  reason: collision with root package name */
    public int f53130h;

    /* renamed from: i  reason: collision with root package name */
    public long f53131i;
    public List<j> j;
    public int k;
    public List<String> l;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.f53131i;
    }

    public String c() {
        return this.f53124b;
    }

    public String d() {
        return this.f53125c;
    }

    public int e() {
        return this.f53130h;
    }

    public String f() {
        return this.f53129g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f53127e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f53123a;
    }

    public int k() {
        return this.f53126d;
    }

    public String l() {
        return this.f53128f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f53123a = businessPromot.title;
        this.f53124b = businessPromot.img;
        this.f53125c = businessPromot.img_popup;
        this.f53126d = businessPromot.type.intValue();
        this.f53127e = businessPromot.thread_id;
        this.f53128f = businessPromot.url;
        this.f53129g = businessPromot.schema;
        this.f53130h = businessPromot.join_num.intValue();
        this.f53131i = businessPromot.id.longValue();
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
