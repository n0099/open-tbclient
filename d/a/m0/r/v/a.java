package d.a.m0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f54010d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f54011a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f54012b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f54013c = new C1206a();

    /* renamed from: d.a.m0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1206a implements FeedRecModel.b {
        public C1206a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i2, String str) {
            a.this.f54012b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f54012b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f54011a = feedRecModel;
        feedRecModel.z(this.f54013c);
    }

    public static a b() {
        if (f54010d == null) {
            synchronized (a.class) {
                if (f54010d == null) {
                    f54010d = new a();
                }
            }
        }
        return f54010d;
    }

    public DataRes c() {
        return this.f54012b;
    }
}
