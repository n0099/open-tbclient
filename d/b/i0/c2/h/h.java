package d.b.i0.c2.h;

import com.baidu.adp.BdUniqueId;
import tbclient.Item;
/* loaded from: classes4.dex */
public class h implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static BdUniqueId f52432g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public Item f52433e;

    /* renamed from: f  reason: collision with root package name */
    public String f52434f;

    public h(Item item) {
        this.f52433e = item;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f52432g;
    }
}
