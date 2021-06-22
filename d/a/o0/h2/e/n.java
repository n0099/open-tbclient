package d.a.o0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class n extends BaseCardInfo implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f59395f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f59396e = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59395f;
    }
}
