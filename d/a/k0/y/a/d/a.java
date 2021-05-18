package d.a.k0.y.a.d;

import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import d.a.j0.g0.b.d;
import d.a.j0.g0.b.g;
import d.a.j0.z0.w;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes4.dex */
public class a implements g, d {

    /* renamed from: e  reason: collision with root package name */
    public int f63423e;

    public void a() {
        this.f63423e++;
    }

    @Override // d.a.j0.g0.b.i
    public Object c(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.f63423e);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        DataReq build = builder.build(false);
        builder2.data = build;
        w.a(build, true);
        return builder2.build(false);
    }

    @Override // d.a.j0.g0.b.c
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // d.a.j0.g0.b.d
    public boolean i() {
        return true;
    }

    @Override // d.a.j0.g0.b.d
    public boolean isNeedUid() {
        return false;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, Object> o() {
        return null;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, String> q() {
        return null;
    }

    @Override // d.a.j0.g0.b.d
    public String r() {
        return "tb.pb_normal";
    }
}
