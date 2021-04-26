package d.a.j0.v.b;

import tbclient.Search.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61553a;

    /* renamed from: b  reason: collision with root package name */
    public long f61554b;

    /* renamed from: c  reason: collision with root package name */
    public String f61555c;

    /* renamed from: d  reason: collision with root package name */
    public String f61556d;

    /* renamed from: e  reason: collision with root package name */
    public long f61557e;

    /* renamed from: f  reason: collision with root package name */
    public int f61558f;

    /* renamed from: g  reason: collision with root package name */
    public int f61559g;

    /* renamed from: h  reason: collision with root package name */
    public int f61560h;

    /* renamed from: i  reason: collision with root package name */
    public int f61561i;
    public String j;
    public boolean k;
    public long l;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f61554b = l == null ? 0L : l.longValue();
        this.f61555c = dataRes.portrait;
        this.f61556d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f61557e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f61558f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f61559g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f61560h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.f61561i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}
