package d.a.n0.g3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55240g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Setting f55241e;

    /* renamed from: f  reason: collision with root package name */
    public IconInfo f55242f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f55240g;
    }
}
