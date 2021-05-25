package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f63485e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63486f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f63487g;

    /* renamed from: h  reason: collision with root package name */
    public List<m> f63488h;

    /* renamed from: i  reason: collision with root package name */
    public int f63489i;
    public int j;

    @Override // d.a.n0.z.e0.p
    public void a(boolean z) {
        this.f63485e = z;
    }

    @Override // d.a.n0.z.e0.p
    public boolean g() {
        return true;
    }

    @Override // d.a.n0.z.e0.p
    public int getPosition() {
        return this.f63489i;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    @Override // d.a.n0.z.e0.p
    public void n(boolean z) {
        this.f63486f = z;
    }
}
