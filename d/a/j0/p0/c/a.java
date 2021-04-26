package d.a.j0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57340g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57341h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f57342i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f57343e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f57344f;

    public a() {
        BdUniqueId bdUniqueId = f57341h;
        this.f57343e = bdUniqueId;
        this.f57343e = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.f57343e;
    }

    public ArrayList<String> h() {
        return this.f57344f;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.f57343e = bdUniqueId;
    }

    public a(ArrayList<String> arrayList) {
        this.f57343e = f57341h;
        this.f57344f = arrayList;
        this.f57343e = f57340g;
    }
}
