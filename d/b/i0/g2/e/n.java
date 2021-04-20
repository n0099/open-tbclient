package d.b.i0.g2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends BaseCardInfo implements d.b.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static BdUniqueId f56277f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<a> f56278e = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56277f;
    }
}
