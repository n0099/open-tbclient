package d.a.n0.a0.a.d;

import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import d.a.m0.g0.b.d;
import d.a.m0.g0.b.g;
import d.a.m0.z0.w;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes4.dex */
public class a implements g, d {

    /* renamed from: e  reason: collision with root package name */
    public int f54816e;

    public void a() {
        this.f54816e++;
    }

    @Override // d.a.m0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.f54816e);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        DataReq build = builder.build(false);
        builder2.data = build;
        w.a(build, true);
        return builder2.build(false);
    }

    @Override // d.a.m0.g0.b.c
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // d.a.m0.g0.b.d
    public boolean isNeedUid() {
        return false;
    }

    @Override // d.a.m0.g0.b.d
    public boolean l() {
        return true;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, Object> s() {
        return null;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, String> u() {
        return null;
    }

    @Override // d.a.m0.g0.b.d
    public String v() {
        return "tb.pb_normal";
    }
}
