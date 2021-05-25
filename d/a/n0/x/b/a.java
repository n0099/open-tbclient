package d.a.n0.x.b;

import tbclient.Search.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f63139a;

    /* renamed from: b  reason: collision with root package name */
    public long f63140b;

    /* renamed from: c  reason: collision with root package name */
    public String f63141c;

    /* renamed from: d  reason: collision with root package name */
    public String f63142d;

    /* renamed from: e  reason: collision with root package name */
    public long f63143e;

    /* renamed from: f  reason: collision with root package name */
    public int f63144f;

    /* renamed from: g  reason: collision with root package name */
    public int f63145g;

    /* renamed from: h  reason: collision with root package name */
    public int f63146h;

    /* renamed from: i  reason: collision with root package name */
    public int f63147i;
    public String j;
    public boolean k;
    public long l;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        this.f63140b = l == null ? 0L : l.longValue();
        this.f63141c = dataRes.portrait;
        this.f63142d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        this.f63143e = l2 == null ? 0L : l2.longValue();
        Integer num = dataRes.vote_num;
        this.f63144f = num == null ? 0 : num.intValue();
        Integer num2 = dataRes.agree_num;
        this.f63145g = num2 == null ? 0 : num2.intValue();
        Integer num3 = dataRes.thread_num;
        this.f63146h = num3 == null ? 0 : num3.intValue();
        Integer num4 = dataRes.post_num;
        this.f63147i = num4 == null ? 0 : num4.intValue();
        Boolean bool = dataRes.is_vote;
        this.k = bool != null ? bool.booleanValue() : false;
        Long l3 = dataRes.tid;
        this.l = l3 != null ? l3.longValue() : 0L;
    }
}
