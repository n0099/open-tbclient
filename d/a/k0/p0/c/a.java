package d.a.k0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58082g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f58083h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f58084i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f58085e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f58086f;

    public a() {
        BdUniqueId bdUniqueId = f58083h;
        this.f58085e = bdUniqueId;
        this.f58085e = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.f58085e;
    }

    public ArrayList<String> h() {
        return this.f58086f;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.f58085e = bdUniqueId;
    }

    public a(ArrayList<String> arrayList) {
        this.f58085e = f58083h;
        this.f58086f = arrayList;
        this.f58085e = f58082g;
    }
}
