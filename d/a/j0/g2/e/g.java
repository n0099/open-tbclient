package d.a.j0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f54569g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f54570e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f54571f;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f54572a;

        /* renamed from: b  reason: collision with root package name */
        public int f54573b;

        /* renamed from: c  reason: collision with root package name */
        public String f54574c;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f54569g;
    }

    public void h(List<a> list) {
        this.f54570e = list;
    }
}
