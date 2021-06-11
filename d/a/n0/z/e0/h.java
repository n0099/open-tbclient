package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f67191h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static BdUniqueId f67192i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MetaData f67193e;

    /* renamed from: f  reason: collision with root package name */
    public int f67194f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f67195g = 1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        int i2 = this.f67194f;
        if (i2 != 0) {
            if (i2 != 1) {
                return f67191h;
            }
            return f67192i;
        }
        return f67191h;
    }
}
