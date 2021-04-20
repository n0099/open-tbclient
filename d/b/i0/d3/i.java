package d.b.i0.d3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f54865a;

    /* renamed from: b  reason: collision with root package name */
    public String f54866b;

    /* renamed from: c  reason: collision with root package name */
    public String f54867c;

    /* renamed from: d  reason: collision with root package name */
    public int f54868d;

    /* renamed from: e  reason: collision with root package name */
    public String f54869e;

    /* renamed from: f  reason: collision with root package name */
    public String f54870f;

    /* renamed from: g  reason: collision with root package name */
    public String f54871g;

    /* renamed from: h  reason: collision with root package name */
    public int f54872h;
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
        return this.f54866b;
    }

    public String d() {
        return this.f54867c;
    }

    public int e() {
        return this.f54872h;
    }

    public String f() {
        return this.f54871g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f54869e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f54865a;
    }

    public int k() {
        return this.f54868d;
    }

    public String l() {
        return this.f54870f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f54865a = businessPromot.title;
        this.f54866b = businessPromot.img;
        this.f54867c = businessPromot.img_popup;
        this.f54868d = businessPromot.type.intValue();
        this.f54869e = businessPromot.thread_id;
        this.f54870f = businessPromot.url;
        this.f54871g = businessPromot.schema;
        this.f54872h = businessPromot.join_num.intValue();
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
