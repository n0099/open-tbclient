package d.b.i0.v.b;

import tbclient.Search.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f62905a;

    /* renamed from: b  reason: collision with root package name */
    public long f62906b;

    /* renamed from: c  reason: collision with root package name */
    public String f62907c;

    /* renamed from: d  reason: collision with root package name */
    public String f62908d;

    /* renamed from: e  reason: collision with root package name */
    public long f62909e;

    /* renamed from: f  reason: collision with root package name */
    public int f62910f;

    /* renamed from: g  reason: collision with root package name */
    public int f62911g;

    /* renamed from: h  reason: collision with root package name */
    public int f62912h;
    public int i;
    public String j;
    public boolean k;
    public long l;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f62906b = l == null ? 0L : l.longValue();
        this.f62907c = dataRes.portrait;
        this.f62908d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f62909e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f62910f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f62911g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f62912h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}
