package d.a.k0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f63193h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static BdUniqueId f63194i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MetaData f63195e;

    /* renamed from: f  reason: collision with root package name */
    public int f63196f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63197g = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        int i2 = this.f63196f;
        if (i2 != 0) {
            if (i2 != 1) {
                return f63193h;
            }
            return f63194i;
        }
        return f63193h;
    }
}
