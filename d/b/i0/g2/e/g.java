package d.b.i0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends BaseCardInfo implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f56247g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f56248e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f56249f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f56250a;

        /* renamed from: b  reason: collision with root package name */
        public int f56251b;

        /* renamed from: c  reason: collision with root package name */
        public String f56252c;
    }

    public void g(List<a> list) {
        this.f56248e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56247g;
    }
}
