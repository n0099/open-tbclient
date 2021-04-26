package d.a.j0.a1.e.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class d extends d.a.i0.r.q.a {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f50716e;

    public d() {
    }

    public void A(List<c> list) {
        this.f50716e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f50707a;
    }

    @Override // d.a.i0.r.q.a
    public v0 h() {
        return null;
    }

    @Override // d.a.i0.r.q.a
    public a2 m() {
        return null;
    }

    public List<c> z() {
        return this.f50716e;
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.f50716e = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f50716e.add(new c(list.get(i2), i2));
        }
        this.f50716e.add(new c());
    }
}
