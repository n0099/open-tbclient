package d.b.i0.h2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f55275e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55276f;

    /* renamed from: g  reason: collision with root package name */
    public String f55277g;

    /* renamed from: h  reason: collision with root package name */
    public String f55278h;
    public int i;
    public List<UserData> j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
