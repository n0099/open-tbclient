package d.b.i0.t.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f60238e;

    /* renamed from: f  reason: collision with root package name */
    public String f60239f;

    /* renamed from: g  reason: collision with root package name */
    public String f60240g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f60241h;
    public boolean i;
    public boolean j;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    public a2 g() {
        return this.f60241h;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return n;
    }

    @Deprecated
    public void j(ThreadInfo threadInfo) {
        if (this.f60241h == null) {
            this.f60241h = new a2();
        }
        this.f60241h.Q2(threadInfo);
    }
}
