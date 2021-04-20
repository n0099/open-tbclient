package d.b.i0.d3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes3.dex */
public class q implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55016g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f55017e;

    /* renamed from: f  reason: collision with root package name */
    public String f55018f;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.f55017e = actBtn.text;
            this.f55018f = actBtn.url;
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f55016g;
    }
}
