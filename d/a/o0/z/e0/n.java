package d.a.o0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f67328e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67329f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f67330g;

    /* renamed from: h  reason: collision with root package name */
    public List<m> f67331h;

    /* renamed from: i  reason: collision with root package name */
    public int f67332i;
    public int j;

    @Override // d.a.o0.z.e0.p
    public void a(boolean z) {
        this.f67328e = z;
    }

    @Override // d.a.o0.z.e0.p
    public int getPosition() {
        return this.f67332i;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }

    @Override // d.a.o0.z.e0.p
    public boolean j() {
        return true;
    }

    @Override // d.a.o0.z.e0.p
    public void r(boolean z) {
        this.f67329f = z;
    }
}
