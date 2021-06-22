package d.a.o0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f67316h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static BdUniqueId f67317i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MetaData f67318e;

    /* renamed from: f  reason: collision with root package name */
    public int f67319f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f67320g = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        int i2 = this.f67319f;
        if (i2 != 0) {
            if (i2 != 1) {
                return f67316h;
            }
            return f67317i;
        }
        return f67316h;
    }
}
