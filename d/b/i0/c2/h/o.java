package d.b.i0.c2.h;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes4.dex */
public class o implements d.b.b.j.e.n {
    public static final BdUniqueId l = BdUniqueId.gen();
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52454e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f52455f;

    /* renamed from: g  reason: collision with root package name */
    public int f52456g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52457h = false;
    public boolean i;
    public boolean j;
    public List<PbSortType> k;

    public o(BdUniqueId bdUniqueId) {
        this.f52455f = m;
        this.f52455f = bdUniqueId;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return this.f52455f;
    }
}
