package d.b.i0.e3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class c extends BaseCardInfo implements n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f54596h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Custom f54597e;

    /* renamed from: f  reason: collision with root package name */
    public UserInfo f54598f;

    /* renamed from: g  reason: collision with root package name */
    public Setting f54599g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f54596h;
    }
}
