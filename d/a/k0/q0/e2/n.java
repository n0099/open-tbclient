package d.a.k0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.k0.d3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f58408a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.a.k0.d3.m, ?> f58409b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.a.k0.d3.m> f58410c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.k0.d3.m> f58411d;

    /* renamed from: e  reason: collision with root package name */
    public s f58412e;

    public void a(FrsModelController frsModelController) {
        this.f58408a = frsModelController;
    }

    public void b(s sVar) {
        this.f58412e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.a.k0.d3.m> mvcSocketMessage) {
        this.f58410c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.k0.d3.m> mvcNetMessage) {
        this.f58411d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.a.k0.d3.m, ?> mvcSocketResponsedMessage) {
        this.f58409b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f58408a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.y0(this.f58409b, this.f58410c, this.f58411d);
        s sVar = this.f58412e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
