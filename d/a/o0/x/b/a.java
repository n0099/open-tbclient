package d.a.o0.x.b;

import tbclient.Search.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f66979a;

    /* renamed from: b  reason: collision with root package name */
    public long f66980b;

    /* renamed from: c  reason: collision with root package name */
    public String f66981c;

    /* renamed from: d  reason: collision with root package name */
    public String f66982d;

    /* renamed from: e  reason: collision with root package name */
    public long f66983e;

    /* renamed from: f  reason: collision with root package name */
    public int f66984f;

    /* renamed from: g  reason: collision with root package name */
    public int f66985g;

    /* renamed from: h  reason: collision with root package name */
    public int f66986h;

    /* renamed from: i  reason: collision with root package name */
    public int f66987i;
    public String j;
    public boolean k;
    public long l;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f66980b = l == null ? 0L : l.longValue();
        this.f66981c = dataRes.portrait;
        this.f66982d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f66983e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f66984f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f66985g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f66986h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.f66987i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}
