package d.a.o0.g3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class c extends BaseCardInfo implements n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f59057h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Custom f59058e;

    /* renamed from: f  reason: collision with root package name */
    public UserInfo f59059f;

    /* renamed from: g  reason: collision with root package name */
    public Setting f59060g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f59057h;
    }
}
