package d.b.j0.d3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55437g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f55438e;

    /* renamed from: f  reason: collision with root package name */
    public String f55439f;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.f55438e = actBtn.text;
            this.f55439f = actBtn.url;
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f55437g;
    }
}
