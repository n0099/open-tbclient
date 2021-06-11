package d.a.n0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends BaseCardInfo implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f59239g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f59240e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f59241f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f59242a;

        /* renamed from: b  reason: collision with root package name */
        public int f59243b;

        /* renamed from: c  reason: collision with root package name */
        public String f59244c;
    }

    public void c(List<a> list) {
        this.f59240e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59239g;
    }
}
