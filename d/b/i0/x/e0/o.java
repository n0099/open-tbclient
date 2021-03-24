package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId n = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f62224e;

    /* renamed from: f  reason: collision with root package name */
    public String f62225f;

    /* renamed from: g  reason: collision with root package name */
    public String f62226g;

    /* renamed from: h  reason: collision with root package name */
    public String f62227h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;

    @Override // d.b.i0.x.e0.p
    public void b(boolean z) {
    }

    @Override // d.b.i0.x.e0.p
    public int getPosition() {
        return (int) this.l;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return n;
    }

    @Override // d.b.i0.x.e0.p
    public void h(boolean z) {
    }

    @Override // d.b.i0.x.e0.p
    public boolean m() {
        return false;
    }
}
