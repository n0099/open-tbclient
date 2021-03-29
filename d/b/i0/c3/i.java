package d.b.i0.c3;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f53421a;

    /* renamed from: b  reason: collision with root package name */
    public String f53422b;

    /* renamed from: c  reason: collision with root package name */
    public String f53423c;

    /* renamed from: d  reason: collision with root package name */
    public int f53424d;

    /* renamed from: e  reason: collision with root package name */
    public String f53425e;

    /* renamed from: f  reason: collision with root package name */
    public String f53426f;

    /* renamed from: g  reason: collision with root package name */
    public String f53427g;

    /* renamed from: h  reason: collision with root package name */
    public int f53428h;
    public long i;
    public List<j> j;
    public int k;

    public List<j> a() {
        return this.j;
    }

    public long b() {
        return this.i;
    }

    public String c() {
        return this.f53422b;
    }

    public String d() {
        return this.f53423c;
    }

    public int e() {
        return this.f53428h;
    }

    public String f() {
        return this.f53427g;
    }

    public String g() {
        return this.f53425e;
    }

    public int h() {
        return this.k;
    }

    public String i() {
        return this.f53421a;
    }

    public int j() {
        return this.f53424d;
    }

    public String k() {
        return this.f53426f;
    }

    public void l(BusinessPromot businessPromot) {
        if (businessPromot == null) {
            return;
        }
        this.f53421a = businessPromot.title;
        this.f53422b = businessPromot.img;
        this.f53423c = businessPromot.img_popup;
        this.f53424d = businessPromot.type.intValue();
        this.f53425e = businessPromot.thread_id;
        this.f53426f = businessPromot.url;
        this.f53427g = businessPromot.schema;
        this.f53428h = businessPromot.join_num.intValue();
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
    }
}
