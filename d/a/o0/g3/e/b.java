package d.a.o0.g3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo implements n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59054g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Setting f59055e;

    /* renamed from: f  reason: collision with root package name */
    public IconInfo f59056f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59054g;
    }
}
