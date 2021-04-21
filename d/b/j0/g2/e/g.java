package d.b.j0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends BaseCardInfo implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f56668g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f56669e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f56670f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f56671a;

        /* renamed from: b  reason: collision with root package name */
        public int f56672b;

        /* renamed from: c  reason: collision with root package name */
        public String f56673c;
    }

    public void g(List<a> list) {
        this.f56669e = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56668g;
    }
}
