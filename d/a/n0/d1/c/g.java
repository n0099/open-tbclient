package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes4.dex */
public class g implements d.a.c.k.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56267f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56268e;

    public void b(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        this.f56268e = hotThread.hot_title;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56267f;
    }
}
