package d.b.h0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f51056d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f51057a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f51058b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f51059c = new C1091a();

    /* renamed from: d.b.h0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1091a implements FeedRecModel.b {
        public C1091a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i, String str) {
            a.this.f51058b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f51058b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f51057a = feedRecModel;
        feedRecModel.v(this.f51059c);
    }

    public static a b() {
        if (f51056d == null) {
            synchronized (a.class) {
                if (f51056d == null) {
                    f51056d = new a();
                }
            }
        }
        return f51056d;
    }

    public DataRes c() {
        return this.f51058b;
    }
}
