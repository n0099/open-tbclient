package d.a.j0.t.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f60402e;

    /* renamed from: f  reason: collision with root package name */
    public String f60403f;

    /* renamed from: g  reason: collision with root package name */
    public String f60404g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f60405h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60406i;
    public boolean j;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return n;
    }

    public a2 h() {
        return this.f60405h;
    }

    @Deprecated
    public void l(ThreadInfo threadInfo) {
        if (this.f60405h == null) {
            this.f60405h = new a2();
        }
        this.f60405h.R2(threadInfo);
    }
}
