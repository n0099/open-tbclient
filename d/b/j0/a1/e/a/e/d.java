package d.b.j0.a1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class d extends d.b.i0.r.q.a {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f53013e;

    public d() {
    }

    public void A(List<c> list) {
        this.f53013e = list;
    }

    @Override // d.b.i0.r.q.a
    public v0 g() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return a.f53004a;
    }

    @Override // d.b.i0.r.q.a
    public a2 n() {
        return null;
    }

    public List<c> z() {
        return this.f53013e;
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.f53013e = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.f53013e.add(new c(list.get(i), i));
        }
        this.f53013e.add(new c());
    }
}
