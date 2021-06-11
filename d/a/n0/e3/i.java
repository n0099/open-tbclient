package d.a.n0.e3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f57732a;

    /* renamed from: b  reason: collision with root package name */
    public String f57733b;

    /* renamed from: c  reason: collision with root package name */
    public String f57734c;

    /* renamed from: d  reason: collision with root package name */
    public int f57735d;

    /* renamed from: e  reason: collision with root package name */
    public String f57736e;

    /* renamed from: f  reason: collision with root package name */
    public String f57737f;

    /* renamed from: g  reason: collision with root package name */
    public String f57738g;

    /* renamed from: h  reason: collision with root package name */
    public int f57739h;

    /* renamed from: i  reason: collision with root package name */
    public long f57740i;
    public List<j> j;
    public int k;
    public List<String> l;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.f57740i;
    }

    public String c() {
        return this.f57733b;
    }

    public String d() {
        return this.f57734c;
    }

    public int e() {
        return this.f57739h;
    }

    public String f() {
        return this.f57738g;
    }

    public List<String> g() {
        return this.l;
    }

    public String h() {
        return this.f57736e;
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.f57732a;
    }

    public int k() {
        return this.f57735d;
    }

    public String l() {
        return this.f57737f;
    }

    public void m(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f57732a = businessPromot.title;
        this.f57733b = businessPromot.img;
        this.f57734c = businessPromot.img_popup;
        this.f57735d = businessPromot.type.intValue();
        this.f57736e = businessPromot.thread_id;
        this.f57737f = businessPromot.url;
        this.f57738g = businessPromot.schema;
        this.f57739h = businessPromot.join_num.intValue();
        this.f57740i = businessPromot.id.longValue();
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
