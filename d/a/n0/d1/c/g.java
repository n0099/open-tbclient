package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes4.dex */
public class g implements d.a.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52578f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52579e;

    public void c(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        this.f52579e = hotThread.hot_title;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52578f;
    }
}
