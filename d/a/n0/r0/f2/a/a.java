package d.a.n0.r0.f2.a;

import d.a.m0.g0.b.g;
import d.a.m0.z0.w;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes4.dex */
public class a implements g {

    /* renamed from: e  reason: collision with root package name */
    public int f58557e;

    /* renamed from: f  reason: collision with root package name */
    public long f58558f;

    /* renamed from: g  reason: collision with root package name */
    public String f58559g;

    /* renamed from: h  reason: collision with root package name */
    public int f58560h;

    /* renamed from: i  reason: collision with root package name */
    public int f58561i;

    @Override // d.a.m0.g0.b.i
    public Object c(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.forum_id = Long.valueOf(d.a.c.e.m.b.f(this.f58559g, 0L));
        builder.thread_id = Long.valueOf(this.f58558f);
        builder.req_type = Integer.valueOf(this.f58560h == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, Object> o() {
        return null;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, String> q() {
        return null;
    }
}
