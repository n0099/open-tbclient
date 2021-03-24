package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f62209h = BdUniqueId.gen();
    public static BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MetaData f62210e;

    /* renamed from: f  reason: collision with root package name */
    public int f62211f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f62212g = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        int i2 = this.f62211f;
        if (i2 != 0) {
            if (i2 != 1) {
                return f62209h;
            }
            return i;
        }
        return f62209h;
    }
}
