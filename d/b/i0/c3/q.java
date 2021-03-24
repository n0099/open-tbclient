package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53571g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53572e;

    /* renamed from: f  reason: collision with root package name */
    public String f53573f;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.f53572e = actBtn.text;
            this.f53573f = actBtn.url;
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53571g;
    }
}
