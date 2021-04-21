package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes4.dex */
public class g implements d.b.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53937f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53938e;

    public void a(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        this.f53938e = hotThread.hot_title;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53937f;
    }
}
