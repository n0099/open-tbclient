package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f62481e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62482f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f62483g;

    /* renamed from: h  reason: collision with root package name */
    public List<m> f62484h;

    /* renamed from: i  reason: collision with root package name */
    public int f62485i;
    public int j;

    @Override // d.a.j0.x.e0.p
    public void a(boolean z) {
        this.f62481e = z;
    }

    @Override // d.a.j0.x.e0.p
    public boolean g() {
        return true;
    }

    @Override // d.a.j0.x.e0.p
    public int getPosition() {
        return this.f62485i;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    @Override // d.a.j0.x.e0.p
    public void n(boolean z) {
        this.f62482f = z;
    }
}
