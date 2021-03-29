package d.b.i0.p0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.i0.c3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f57484a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.b.i0.c3.m> f57485b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.b.i0.c3.m> f57486c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.i0.c3.m> f57487d;

    /* renamed from: e  reason: collision with root package name */
    public s f57488e;

    public void a(FrsModelController frsModelController) {
        this.f57484a = frsModelController;
    }

    public void b(s sVar) {
        this.f57488e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.b.i0.c3.m> mvcHttpMessage) {
        this.f57486c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.i0.c3.m> mvcNetMessage) {
        this.f57487d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.b.i0.c3.m> mvcHttpResponsedMessage) {
        this.f57485b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f57484a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f57485b, this.f57486c, this.f57487d);
        s sVar = this.f57488e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
