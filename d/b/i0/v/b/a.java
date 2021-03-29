package d.b.i0.v.b;

import tbclient.Search.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61896a;

    /* renamed from: b  reason: collision with root package name */
    public long f61897b;

    /* renamed from: c  reason: collision with root package name */
    public String f61898c;

    /* renamed from: d  reason: collision with root package name */
    public String f61899d;

    /* renamed from: e  reason: collision with root package name */
    public long f61900e;

    /* renamed from: f  reason: collision with root package name */
    public int f61901f;

    /* renamed from: g  reason: collision with root package name */
    public int f61902g;

    /* renamed from: h  reason: collision with root package name */
    public int f61903h;
    public int i;
    public String j;
    public boolean k;
    public long l;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f61897b = l == null ? 0L : l.longValue();
        this.f61898c = dataRes.portrait;
        this.f61899d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f61900e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f61901f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f61902g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f61903h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}
