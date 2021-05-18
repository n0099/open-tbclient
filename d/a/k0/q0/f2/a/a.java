package d.a.k0.q0.f2.a;

import d.a.j0.g0.b.g;
import d.a.j0.z0.w;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes4.dex */
public class a implements g {

    /* renamed from: e  reason: collision with root package name */
    public int f58416e;

    /* renamed from: f  reason: collision with root package name */
    public long f58417f;

    /* renamed from: g  reason: collision with root package name */
    public String f58418g;

    /* renamed from: h  reason: collision with root package name */
    public int f58419h;

    /* renamed from: i  reason: collision with root package name */
    public int f58420i;

    @Override // d.a.j0.g0.b.i
    public Object c(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.forum_id = Long.valueOf(d.a.c.e.m.b.f(this.f58418g, 0L));
        builder.thread_id = Long.valueOf(this.f58417f);
        builder.req_type = Integer.valueOf(this.f58419h == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, Object> o() {
        return null;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, String> q() {
        return null;
    }
}
