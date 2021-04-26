package d.a.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import tbclient.Item;
/* loaded from: classes3.dex */
public class h implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f52029g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Item f52030e;

    /* renamed from: f  reason: collision with root package name */
    public String f52031f;

    public h(Item item) {
        this.f52030e = item;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52029g;
    }
}
