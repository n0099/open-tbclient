package d.a.j0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f50270d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f50271a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f50272b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f50273c = new C1141a();

    /* renamed from: d.a.j0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1141a implements FeedRecModel.b {
        public C1141a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i2, String str) {
            a.this.f50272b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f50272b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f50271a = feedRecModel;
        feedRecModel.v(this.f50273c);
    }

    public static a b() {
        if (f50270d == null) {
            synchronized (a.class) {
                if (f50270d == null) {
                    f50270d = new a();
                }
            }
        }
        return f50270d;
    }

    public DataRes c() {
        return this.f50272b;
    }
}
