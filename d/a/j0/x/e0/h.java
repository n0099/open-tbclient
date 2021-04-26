package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f62469h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static BdUniqueId f62470i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MetaData f62471e;

    /* renamed from: f  reason: collision with root package name */
    public int f62472f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f62473g = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        int i2 = this.f62472f;
        if (i2 != 0) {
            if (i2 != 1) {
                return f62469h;
            }
            return f62470i;
        }
        return f62469h;
    }
}
