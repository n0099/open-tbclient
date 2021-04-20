package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f63785h = BdUniqueId.gen();
    public static BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MetaData f63786e;

    /* renamed from: f  reason: collision with root package name */
    public int f63787f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63788g = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        int i2 = this.f63787f;
        if (i2 != 0) {
            if (i2 != 1) {
                return f63785h;
            }
            return i;
        }
        return f63785h;
    }
}
