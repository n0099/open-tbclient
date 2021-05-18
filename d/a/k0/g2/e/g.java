package d.a.k0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends BaseCardInfo implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f55276g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f55277e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f55278f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f55279a;

        /* renamed from: b  reason: collision with root package name */
        public int f55280b;

        /* renamed from: c  reason: collision with root package name */
        public String f55281c;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55276g;
    }

    public void h(List<a> list) {
        this.f55277e = list;
    }
}
