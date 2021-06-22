package d.a.n0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f54117d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f54118a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f54119b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f54120c = new C1209a();

    /* renamed from: d.a.n0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1209a implements FeedRecModel.b {
        public C1209a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i2, String str) {
            a.this.f54119b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f54119b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f54118a = feedRecModel;
        feedRecModel.z(this.f54120c);
    }

    public static a b() {
        if (f54117d == null) {
            synchronized (a.class) {
                if (f54117d == null) {
                    f54117d = new a();
                }
            }
        }
        return f54117d;
    }

    public DataRes c() {
        return this.f54119b;
    }
}
