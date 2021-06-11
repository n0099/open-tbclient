package d.a.n0.q0.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61969g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f61970h = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f61971i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f61972e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f61973f;

    public a() {
        BdUniqueId bdUniqueId = f61970h;
        this.f61972e = bdUniqueId;
        this.f61972e = bdUniqueId;
    }

    public ArrayList<String> c() {
        return this.f61973f;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.f61972e = bdUniqueId;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return this.f61972e;
    }

    public a(ArrayList<String> arrayList) {
        this.f61972e = f61970h;
        this.f61973f = arrayList;
        this.f61972e = f61969g;
    }
}
