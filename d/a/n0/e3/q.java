package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f54201g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54202e;

    /* renamed from: f  reason: collision with root package name */
    public String f54203f;

    public void c(ActBtn actBtn) {
        if (actBtn != null) {
            this.f54202e = actBtn.text;
            this.f54203f = actBtn.url;
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f54201g;
    }
}
