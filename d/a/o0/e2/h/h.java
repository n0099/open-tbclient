package d.a.o0.e2.h;

import com.baidu.adp.BdUniqueId;
import tbclient.Item;
/* loaded from: classes5.dex */
public class h implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f56747g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Item f56748e;

    /* renamed from: f  reason: collision with root package name */
    public String f56749f;

    public h(Item item) {
        this.f56748e = item;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56747g;
    }
}
