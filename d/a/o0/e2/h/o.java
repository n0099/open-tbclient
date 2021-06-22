package d.a.o0.e2.h;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class o implements d.a.c.k.e.n {
    public static final BdUniqueId l = BdUniqueId.gen();
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56769e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f56770f;

    /* renamed from: g  reason: collision with root package name */
    public int f56771g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56772h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56773i;
    public boolean j;
    public List<PbSortType> k;

    public o(BdUniqueId bdUniqueId) {
        this.f56770f = m;
        this.f56770f = bdUniqueId;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return this.f56770f;
    }
}
