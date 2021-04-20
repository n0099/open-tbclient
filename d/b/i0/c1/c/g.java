package d.b.i0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes4.dex */
public class g implements d.b.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f53516f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53517e;

    public void a(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        this.f53517e = hotThread.hot_title;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53516f;
    }
}
