package d.a.m0.r.v;

import com.baidu.tbadk.core.feedManager.FeedRecModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f50334d;

    /* renamed from: a  reason: collision with root package name */
    public FeedRecModel f50335a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f50336b;

    /* renamed from: c  reason: collision with root package name */
    public FeedRecModel.b f50337c = new C1150a();

    /* renamed from: d.a.m0.r.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1150a implements FeedRecModel.b {
        public C1150a() {
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void a(int i2, String str) {
            a.this.f50336b = null;
        }

        @Override // com.baidu.tbadk.core.feedManager.FeedRecModel.b
        public void b(DataRes dataRes, boolean z, boolean z2) {
            a.this.f50336b = dataRes;
        }
    }

    public a() {
        FeedRecModel feedRecModel = new FeedRecModel();
        this.f50335a = feedRecModel;
        feedRecModel.v(this.f50337c);
    }

    public static a b() {
        if (f50334d == null) {
            synchronized (a.class) {
                if (f50334d == null) {
                    f50334d = new a();
                }
            }
        }
        return f50334d;
    }

    public DataRes c() {
        return this.f50336b;
    }
}
