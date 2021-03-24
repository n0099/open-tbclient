package d.b.i0.o0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57238g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57239h = BdUniqueId.gen();
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f57240e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f57241f;

    public a() {
        BdUniqueId bdUniqueId = f57239h;
        this.f57240e = bdUniqueId;
        this.f57240e = bdUniqueId;
    }

    public ArrayList<String> g() {
        return this.f57241f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return this.f57240e;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f57240e = bdUniqueId;
    }

    public a(ArrayList<String> arrayList) {
        this.f57240e = f57239h;
        this.f57241f = arrayList;
        this.f57240e = f57238g;
    }
}
