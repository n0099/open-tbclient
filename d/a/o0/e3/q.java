package d.a.o0.e3;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class q implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58015g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58016e;

    /* renamed from: f  reason: collision with root package name */
    public String f58017f;

    public void b(ActBtn actBtn) {
        if (actBtn != null) {
            this.f58016e = actBtn.text;
            this.f58017f = actBtn.url;
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f58015g;
    }
}
