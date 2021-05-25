package d.a.m0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f50976c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.s.c.a f50977a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f50978b;

    public static a d() {
        if (f50976c == null) {
            synchronized (a.class) {
                if (f50976c == null) {
                    f50976c = new a();
                }
            }
        }
        return f50976c;
    }

    public final void a(d.a.m0.s.c.a aVar) {
        boolean z = aVar == null || this.f50977a == null || aVar.a() != this.f50977a.a();
        this.f50977a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f50978b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f50978b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f50978b.getABTestResult();
    }

    public void e(d.a.m0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f50978b = aBTestExtraData;
    }
}
