package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57890g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57891e;

    /* renamed from: f  reason: collision with root package name */
    public String f57892f;

    public void b(ActBtn actBtn) {
        if (actBtn != null) {
            this.f57891e = actBtn.text;
            this.f57892f = actBtn.url;
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f57890g;
    }
}
