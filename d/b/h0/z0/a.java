package d.b.h0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f52071c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.s.c.a f52072a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f52073b;

    public static a d() {
        if (f52071c == null) {
            synchronized (a.class) {
                if (f52071c == null) {
                    f52071c = new a();
                }
            }
        }
        return f52071c;
    }

    public final void a(d.b.h0.s.c.a aVar) {
        boolean z = aVar == null || this.f52072a == null || aVar.a() != this.f52072a.a();
        this.f52072a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f52073b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f52073b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f52073b.getABTestResult();
    }

    public void e(d.b.h0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f52073b = aBTestExtraData;
    }
}
