package d.a.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class o implements d.a.c.j.e.n {
    public static final BdUniqueId l = BdUniqueId.gen();
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52051e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f52052f;

    /* renamed from: g  reason: collision with root package name */
    public int f52053g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52054h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52055i;
    public boolean j;
    public List<PbSortType> k;

    public o(BdUniqueId bdUniqueId) {
        this.f52052f = m;
        this.f52052f = bdUniqueId;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.f52052f;
    }
}
