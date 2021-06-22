package d.a.o0.v.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.n0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f65252e;

    /* renamed from: f  reason: collision with root package name */
    public String f65253f;

    /* renamed from: g  reason: collision with root package name */
    public String f65254g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f65255h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65256i;
    public boolean j;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    public a2 c() {
        return this.f65255h;
    }

    @Deprecated
    public void g(ThreadInfo threadInfo) {
        if (this.f65255h == null) {
            this.f65255h = new a2();
        }
        this.f65255h.V2(threadInfo);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return n;
    }
}
