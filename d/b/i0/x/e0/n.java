package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f62221e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62222f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f62223g;

    /* renamed from: h  reason: collision with root package name */
    public List<m> f62224h;
    public int i;
    public int j;

    @Override // d.b.i0.x.e0.p
    public void b(boolean z) {
        this.f62221e = z;
    }

    @Override // d.b.i0.x.e0.p
    public int getPosition() {
        return this.i;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    @Override // d.b.i0.x.e0.p
    public void h(boolean z) {
        this.f62222f = z;
    }

    @Override // d.b.i0.x.e0.p
    public boolean m() {
        return true;
    }
}
