package d.b.h0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f51653c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.s.c.a f51654a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f51655b;

    public static a d() {
        if (f51653c == null) {
            synchronized (a.class) {
                if (f51653c == null) {
                    f51653c = new a();
                }
            }
        }
        return f51653c;
    }

    public final void a(d.b.h0.s.c.a aVar) {
        boolean z = aVar == null || this.f51654a == null || aVar.a() != this.f51654a.a();
        this.f51654a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f51655b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f51655b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f51655b.getABTestResult();
    }

    public void e(d.b.h0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f51655b = aBTestExtraData;
    }
}
