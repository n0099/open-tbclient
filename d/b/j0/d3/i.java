package d.b.j0.d3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f55286a;

    /* renamed from: b  reason: collision with root package name */
    public String f55287b;

    /* renamed from: c  reason: collision with root package name */
    public String f55288c;

    /* renamed from: d  reason: collision with root package name */
    public int f55289d;

    /* renamed from: e  reason: collision with root package name */
    public String f55290e;

    /* renamed from: f  reason: collision with root package name */
    public String f55291f;

    /* renamed from: g  reason: collision with root package name */
    public String f55292g;

    /* renamed from: h  reason: collision with root package name */
    public int f55293h;
    public long i;
    public List<j> j;
    public int k;
    public List<String> l;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.i;
    }

    public String c() {
        return this.f55287b;
    }

    public String d() {
        return this.f55288c;
    }

    public int e() {
        return this.f55293h;
    }

    public String f() {
        return this.f55292g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f55290e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f55286a;
    }

    public int k() {
        return this.f55289d;
    }

    public String l() {
        return this.f55291f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f55286a = businessPromot.title;
        this.f55287b = businessPromot.img;
        this.f55288c = businessPromot.img_popup;
        this.f55289d = businessPromot.type.intValue();
        this.f55290e = businessPromot.thread_id;
        this.f55291f = businessPromot.url;
        this.f55292g = businessPromot.schema;
        this.f55293h = businessPromot.join_num.intValue();
        this.i = businessPromot.id.longValue();
        if (businessPromot.comment_list != null) {
            this.j = new LinkedList();
            for (int i = 0; i < businessPromot.comment_list.size(); i++) {
                if (businessPromot.comment_list.get(i) != null) {
                    j jVar = new j();
                    jVar.c(businessPromot.comment_list.get(i));
                    this.j.add(jVar);
                }
            }
        }
        this.k = businessPromot.thread_type.intValue();
        this.l = businessPromot.third_statistics_url;
    }
}
