package d.b.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import tbclient.Item;
/* loaded from: classes3.dex */
public class h implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f54248g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Item f54249e;

    /* renamed from: f  reason: collision with root package name */
    public String f54250f;

    public h(Item item) {
        this.f54249e = item;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54248g;
    }
}
