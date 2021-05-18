package d.a.j0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f50903c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.s.c.a f50904a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f50905b;

    public static a d() {
        if (f50903c == null) {
            synchronized (a.class) {
                if (f50903c == null) {
                    f50903c = new a();
                }
            }
        }
        return f50903c;
    }

    public final void a(d.a.j0.s.c.a aVar) {
        boolean z = aVar == null || this.f50904a == null || aVar.a() != this.f50904a.a();
        this.f50904a = aVar;
        if (z) {
            b("zan_or_cai_smallflow");
        }
    }

    public final void b(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public String c() {
        if (this.f50905b == null) {
            ABTestExtraData aBTestExtraData = new ABTestExtraData();
            this.f50905b = aBTestExtraData;
            aBTestExtraData.parserABTestExtraFormSharedPref();
        }
        return this.f50905b.getABTestResult();
    }

    public void e(d.a.j0.s.c.a aVar) {
        a(aVar);
    }

    public void f(ABTestExtraData aBTestExtraData) {
        this.f50905b = aBTestExtraData;
    }
}
