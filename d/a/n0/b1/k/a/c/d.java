package d.a.n0.b1.k.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f55640e;

    /* renamed from: f  reason: collision with root package name */
    public int f55641f;

    /* renamed from: g  reason: collision with root package name */
    public long f55642g;

    /* renamed from: h  reason: collision with root package name */
    public String f55643h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f55644i;

    public void c(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return;
        }
        a2 a2Var = new a2();
        this.f55644i = a2Var;
        a2Var.V2(threadInfo);
        this.f55644i.Z2();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }
}
