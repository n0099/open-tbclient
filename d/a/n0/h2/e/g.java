package d.a.n0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends BaseCardInfo implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f55550g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f55551e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f55552f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f55553a;

        /* renamed from: b  reason: collision with root package name */
        public int f55554b;

        /* renamed from: c  reason: collision with root package name */
        public String f55555c;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55550g;
    }

    public void h(List<a> list) {
        this.f55551e = list;
    }
}
