package d.b.i0.t.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61803e;

    /* renamed from: f  reason: collision with root package name */
    public String f61804f;

    /* renamed from: g  reason: collision with root package name */
    public String f61805g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f61806h;
    public boolean i;
    public boolean j;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;

    public a2 g() {
        return this.f61806h;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return n;
    }

    @Deprecated
    public void j(ThreadInfo threadInfo) {
        if (this.f61806h == null) {
            this.f61806h = new a2();
        }
        this.f61806h.R2(threadInfo);
    }
}
