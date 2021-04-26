package d.a.i0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f50084c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.s.c.a f50085a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f50086b;

    public static a d() {
        if (f50084c == null) {
            synchronized (a.class) {
                if (f50084c == null) {
                    f50084c = new a();
                }
            }
        }
        return f50084c;
    }

    public final void a(d.a.i0.s.c.a aVar) {
        boolean z = aVar == null || this.f50085a == null || aVar.a() != this.f50085a.a();
        this.f50085a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f50086b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f50086b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f50086b.getABTestResult();
    }

    public void e(d.a.i0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f50086b = aBTestExtraData;
    }
}
