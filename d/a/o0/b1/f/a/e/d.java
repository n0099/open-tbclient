package d.a.o0.b1.f.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class d extends d.a.n0.r.q.a {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f55386e;

    public d() {
    }

    public void A(List<c> list) {
        this.f55386e = list;
    }

    @Override // d.a.n0.r.q.a
    public v0 c() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return a.f55377a;
    }

    @Override // d.a.n0.r.q.a
    public a2 i() {
        return null;
    }

    public List<c> z() {
        return this.f55386e;
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.f55386e = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f55386e.add(new c(list.get(i2), i2));
        }
        this.f55386e.add(new c());
    }
}
