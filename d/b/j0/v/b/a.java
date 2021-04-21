package d.b.j0.v.b;

import tbclient.Search.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f63326a;

    /* renamed from: b  reason: collision with root package name */
    public long f63327b;

    /* renamed from: c  reason: collision with root package name */
    public String f63328c;

    /* renamed from: d  reason: collision with root package name */
    public String f63329d;

    /* renamed from: e  reason: collision with root package name */
    public long f63330e;

    /* renamed from: f  reason: collision with root package name */
    public int f63331f;

    /* renamed from: g  reason: collision with root package name */
    public int f63332g;

    /* renamed from: h  reason: collision with root package name */
    public int f63333h;
    public int i;
    public String j;
    public boolean k;
    public long l;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f63327b = l == null ? 0L : l.longValue();
        this.f63328c = dataRes.portrait;
        this.f63329d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f63330e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f63331f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f63332g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f63333h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}
