package d.a.n0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f54760c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.s.c.a f54761a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f54762b;

    public static a d() {
        if (f54760c == null) {
            synchronized (a.class) {
                if (f54760c == null) {
                    f54760c = new a();
                }
            }
        }
        return f54760c;
    }

    public final void a(d.a.n0.s.c.a aVar) {
        boolean z = aVar == null || this.f54761a == null || aVar.a() != this.f54761a.a();
        this.f54761a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f54762b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f54762b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f54762b.getABTestResult();
    }

    public void e(d.a.n0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f54762b = aBTestExtraData;
    }
}
