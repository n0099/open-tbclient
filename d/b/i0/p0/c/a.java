package d.b.i0.p0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58885g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f58886h = BdUniqueId.gen();
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f58887e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f58888f;

    public a() {
        BdUniqueId bdUniqueId = f58886h;
        this.f58887e = bdUniqueId;
        this.f58887e = bdUniqueId;
    }

    public ArrayList<String> g() {
        return this.f58888f;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.f58887e;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f58887e = bdUniqueId;
    }

    public a(ArrayList<String> arrayList) {
        this.f58887e = f58886h;
        this.f58888f = arrayList;
        this.f58887e = f58885g;
    }
}
