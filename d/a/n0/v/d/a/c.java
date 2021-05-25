package d.a.n0.v.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61414e;

    /* renamed from: f  reason: collision with root package name */
    public String f61415f;

    /* renamed from: g  reason: collision with root package name */
    public String f61416g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f61417h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61418i;
    public boolean j;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return n;
    }

    public a2 h() {
        return this.f61417h;
    }

    @Deprecated
    public void l(ThreadInfo threadInfo) {
        if (this.f61417h == null) {
            this.f61417h = new a2();
        }
        this.f61417h.U2(threadInfo);
    }
}
