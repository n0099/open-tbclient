package d.b.j0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59306g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f59307h = BdUniqueId.gen();
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f59308e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f59309f;

    public a() {
        BdUniqueId bdUniqueId = f59307h;
        this.f59308e = bdUniqueId;
        this.f59308e = bdUniqueId;
    }

    public ArrayList<String> g() {
        return this.f59309f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.f59308e;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f59308e = bdUniqueId;
    }

    public a(ArrayList<String> arrayList) {
        this.f59308e = f59307h;
        this.f59309f = arrayList;
        this.f59308e = f59306g;
    }
}
