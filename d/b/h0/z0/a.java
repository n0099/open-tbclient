package d.b.h0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f51652c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.s.c.a f51653a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f51654b;

    public static a d() {
        if (f51652c == null) {
            synchronized (a.class) {
                if (f51652c == null) {
                    f51652c = new a();
                }
            }
        }
        return f51652c;
    }

    public final void a(d.b.h0.s.c.a aVar) {
        boolean z = aVar == null || this.f51653a == null || aVar.a() != this.f51653a.a();
        this.f51653a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f51654b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f51654b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f51654b.getABTestResult();
    }

    public void e(d.b.h0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f51654b = aBTestExtraData;
    }
}
