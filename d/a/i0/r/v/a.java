package d.a.i0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f49451d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f49452a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f49453b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f49454c = new C1066a();

    /* renamed from: d.a.i0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1066a implements FeedRecModel.b {
        public C1066a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i2, String str) {
            a.this.f49453b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f49453b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f49452a = feedRecModel;
        feedRecModel.v(this.f49454c);
    }

    public static a b() {
        if (f49451d == null) {
            synchronized (a.class) {
                if (f49451d == null) {
                    f49451d = new a();
                }
            }
        }
        return f49451d;
    }

    public DataRes c() {
        return this.f49453b;
    }
}
