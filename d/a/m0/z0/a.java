package d.a.m0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f54653c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.s.c.a f54654a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f54655b;

    public static a d() {
        if (f54653c == null) {
            synchronized (a.class) {
                if (f54653c == null) {
                    f54653c = new a();
                }
            }
        }
        return f54653c;
    }

    public final void a(d.a.m0.s.c.a aVar) {
        boolean z = aVar == null || this.f54654a == null || aVar.a() != this.f54654a.a();
        this.f54654a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f54655b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f54655b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f54655b.getABTestResult();
    }

    public void e(d.a.m0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f54655b = aBTestExtraData;
    }
}
