package d.b.i0.z0.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class d extends d.b.h0.r.q.a {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f62972e;

    public d() {
    }

    public void A(List<c> list) {
        this.f62972e = list;
    }

    @Override // d.b.h0.r.q.a
    public v0 g() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return a.f62963a;
    }

    @Override // d.b.h0.r.q.a
    public a2 n() {
        return null;
    }

    public List<c> z() {
        return this.f62972e;
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.f62972e = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.f62972e.add(new c(list.get(i), i));
        }
        this.f62972e.add(new c());
    }
}
