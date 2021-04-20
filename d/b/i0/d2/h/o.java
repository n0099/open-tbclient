package d.b.i0.d2.h;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class o implements d.b.c.j.e.n {
    public static final BdUniqueId l = BdUniqueId.gen();
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53849e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f53850f;

    /* renamed from: g  reason: collision with root package name */
    public int f53851g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53852h = false;
    public boolean i;
    public boolean j;
    public List<PbSortType> k;

    public o(BdUniqueId bdUniqueId) {
        this.f53850f = m;
        this.f53850f = bdUniqueId;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.f53850f;
    }
}
