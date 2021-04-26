package d.a.j0.d3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53281g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53282e;

    /* renamed from: f  reason: collision with root package name */
    public String f53283f;

    public void c(ActBtn actBtn) {
        if (actBtn != null) {
            this.f53282e = actBtn.text;
            this.f53283f = actBtn.url;
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f53281g;
    }
}
