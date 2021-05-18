package d.a.k0.i2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f56211e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56212f;

    /* renamed from: g  reason: collision with root package name */
    public String f56213g;

    /* renamed from: h  reason: collision with root package name */
    public String f56214h;

    /* renamed from: i  reason: collision with root package name */
    public int f56215i;
    public List<UserData> j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
