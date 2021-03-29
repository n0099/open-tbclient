package d.b.h0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f51057d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f51058a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f51059b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f51060c = new C1092a();

    /* renamed from: d.b.h0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1092a implements FeedRecModel.b {
        public C1092a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i, String str) {
            a.this.f51059b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f51059b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f51058a = feedRecModel;
        feedRecModel.v(this.f51060c);
    }

    public static a b() {
        if (f51057d == null) {
            synchronized (a.class) {
                if (f51057d == null) {
                    f51057d = new a();
                }
            }
        }
        return f51057d;
    }

    public DataRes c() {
        return this.f51059b;
    }
}
