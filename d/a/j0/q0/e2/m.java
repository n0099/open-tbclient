package d.a.j0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.j0.d3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f57661a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.a.j0.d3.m> f57662b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.a.j0.d3.m> f57663c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.j0.d3.m> f57664d;

    /* renamed from: e  reason: collision with root package name */
    public s f57665e;

    public void a(FrsModelController frsModelController) {
        this.f57661a = frsModelController;
    }

    public void b(s sVar) {
        this.f57665e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.a.j0.d3.m> mvcHttpMessage) {
        this.f57663c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.j0.d3.m> mvcNetMessage) {
        this.f57664d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.a.j0.d3.m> mvcHttpResponsedMessage) {
        this.f57662b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f57661a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f57662b, this.f57663c, this.f57664d);
        s sVar = this.f57665e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
