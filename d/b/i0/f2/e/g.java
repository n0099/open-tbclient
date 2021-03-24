package d.b.i0.f2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends BaseCardInfo implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f54776g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f54777e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f54778f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f54779a;

        /* renamed from: b  reason: collision with root package name */
        public int f54780b;

        /* renamed from: c  reason: collision with root package name */
        public String f54781c;
    }

    public void g(List<a> list) {
        this.f54777e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f54776g;
    }
}
