package d.a.j0.a1.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f51085e;

    /* renamed from: f  reason: collision with root package name */
    public int f51086f;

    /* renamed from: g  reason: collision with root package name */
    public long f51087g;

    /* renamed from: h  reason: collision with root package name */
    public String f51088h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f51089i;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public void h(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return;
        }
        a2 a2Var = new a2();
        this.f51089i = a2Var;
        a2Var.R2(threadInfo);
        this.f51089i.V2();
    }
}
