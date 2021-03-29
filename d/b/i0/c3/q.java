package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53572g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53573e;

    /* renamed from: f  reason: collision with root package name */
    public String f53574f;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.f53573e = actBtn.text;
            this.f53574f = actBtn.url;
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53572g;
    }
}
