package d.b.i0.e3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f54594g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Setting f54595e;

    /* renamed from: f  reason: collision with root package name */
    public IconInfo f54596f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f54594g;
    }
}
