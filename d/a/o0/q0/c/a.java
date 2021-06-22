package d.a.o0.q0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f62094g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f62095h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f62096i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f62097e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f62098f;

    public a() {
        BdUniqueId bdUniqueId = f62095h;
        this.f62097e = bdUniqueId;
        this.f62097e = bdUniqueId;
    }

    public ArrayList<String> c() {
        return this.f62098f;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.f62097e = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return this.f62097e;
    }

    public a(ArrayList<String> arrayList) {
        this.f62097e = f62095h;
        this.f62098f = arrayList;
        this.f62097e = f62094g;
    }
}
