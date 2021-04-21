package d.b.i0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f51803d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f51804a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f51805b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f51806c = new C1127a();

    /* renamed from: d.b.i0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1127a implements FeedRecModel.b {
        public C1127a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i, String str) {
            a.this.f51805b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f51805b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f51804a = feedRecModel;
        feedRecModel.v(this.f51806c);
    }

    public static a b() {
        if (f51803d == null) {
            synchronized (a.class) {
                if (f51803d == null) {
                    f51803d = new a();
                }
            }
        }
        return f51803d;
    }

    public DataRes c() {
        return this.f51805b;
    }
}
