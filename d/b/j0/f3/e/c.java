package d.b.j0.f3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class c extends BaseCardInfo implements n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f56459h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Custom f56460e;

    /* renamed from: f  reason: collision with root package name */
    public UserInfo f56461f;

    /* renamed from: g  reason: collision with root package name */
    public Setting f56462g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56459h;
    }
}
