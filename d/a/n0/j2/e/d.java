package d.a.n0.j2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f60084e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60085f;

    /* renamed from: g  reason: collision with root package name */
    public String f60086g;

    /* renamed from: h  reason: collision with root package name */
    public String f60087h;

    /* renamed from: i  reason: collision with root package name */
    public int f60088i;
    public List<UserData> j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
