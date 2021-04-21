package d.b.i0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f52407c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.s.c.a f52408a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f52409b;

    public static a d() {
        if (f52407c == null) {
            synchronized (a.class) {
                if (f52407c == null) {
                    f52407c = new a();
                }
            }
        }
        return f52407c;
    }

    public final void a(d.b.i0.s.c.a aVar) {
        boolean z = aVar == null || this.f52408a == null || aVar.a() != this.f52408a.a();
        this.f52408a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f52409b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f52409b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f52409b.getABTestResult();
    }

    public void e(d.b.i0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f52409b = aBTestExtraData;
    }
}
