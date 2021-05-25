package d.a.n0.h2.e;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes5.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId p = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f55556e;

    /* renamed from: f  reason: collision with root package name */
    public int f55557f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55558g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55559h;

    /* renamed from: i  reason: collision with root package name */
    public String f55560i;
    public boolean j = false;
    public String k;
    public UserData l;
    public j m;
    public Bundle n;
    public int o;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return p;
    }
}
