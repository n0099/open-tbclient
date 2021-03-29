package d.b.i0.z0.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f63322e;

    /* renamed from: f  reason: collision with root package name */
    public int f63323f;

    /* renamed from: g  reason: collision with root package name */
    public long f63324g;

    /* renamed from: h  reason: collision with root package name */
    public String f63325h;
    public a2 i;

    public void g(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return;
        }
        a2 a2Var = new a2();
        this.i = a2Var;
        a2Var.Q2(threadInfo);
        this.i.U2();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
