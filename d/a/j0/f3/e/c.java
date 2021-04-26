package d.a.j0.f3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class c extends BaseCardInfo implements n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f54348h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Custom f54349e;

    /* renamed from: f  reason: collision with root package name */
    public UserInfo f54350f;

    /* renamed from: g  reason: collision with root package name */
    public Setting f54351g;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f54348h;
    }
}
