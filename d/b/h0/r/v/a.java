package d.b.h0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f51467d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f51468a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f51469b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f51470c = new C1105a();

    /* renamed from: d.b.h0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1105a implements FeedRecModel.b {
        public C1105a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i, String str) {
            a.this.f51469b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f51469b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f51468a = feedRecModel;
        feedRecModel.v(this.f51470c);
    }

    public static a b() {
        if (f51467d == null) {
            synchronized (a.class) {
                if (f51467d == null) {
                    f51467d = new a();
                }
            }
        }
        return f51467d;
    }

    public DataRes c() {
        return this.f51469b;
    }
}
