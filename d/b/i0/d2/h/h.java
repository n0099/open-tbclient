package d.b.i0.d2.h;

import com.baidu.adp.BdUniqueId;
import tbclient.Item;
/* loaded from: classes3.dex */
public class h implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f53827g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Item f53828e;

    /* renamed from: f  reason: collision with root package name */
    public String f53829f;

    public h(Item item) {
        this.f53828e = item;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53827g;
    }
}
