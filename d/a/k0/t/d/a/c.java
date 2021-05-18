package d.a.k0.t.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.j0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61126e;

    /* renamed from: f  reason: collision with root package name */
    public String f61127f;

    /* renamed from: g  reason: collision with root package name */
    public String f61128g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f61129h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61130i;
    public boolean j;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return n;
    }

    public a2 h() {
        return this.f61129h;
    }

    @Deprecated
    public void l(ThreadInfo threadInfo) {
        if (this.f61129h == null) {
            this.f61129h = new a2();
        }
        this.f61129h.T2(threadInfo);
    }
}
