package d.a.n0.q0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58278g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f58279h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f58280i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f58281e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f58282f;

    public a() {
        BdUniqueId bdUniqueId = f58279h;
        this.f58281e = bdUniqueId;
        this.f58281e = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.f58281e;
    }

    public ArrayList<String> h() {
        return this.f58282f;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.f58281e = bdUniqueId;
    }

    public a(ArrayList<String> arrayList) {
        this.f58281e = f58279h;
        this.f58282f = arrayList;
        this.f58281e = f58278g;
    }
}
