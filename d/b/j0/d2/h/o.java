package d.b.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class o implements d.b.c.j.e.n {
    public static final BdUniqueId l = BdUniqueId.gen();
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54270e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f54271f;

    /* renamed from: g  reason: collision with root package name */
    public int f54272g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54273h = false;
    public boolean i;
    public boolean j;
    public List<PbSortType> k;

    public o(BdUniqueId bdUniqueId) {
        this.f54271f = m;
        this.f54271f = bdUniqueId;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.f54271f;
    }
}
