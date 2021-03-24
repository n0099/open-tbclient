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
    public FrsModelController f57483a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.b.i0.c3.m> f57484b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.b.i0.c3.m> f57485c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.i0.c3.m> f57486d;

    /* renamed from: e  reason: collision with root package name */
    public s f57487e;

    public void a(FrsModelController frsModelController) {
        this.f57483a = frsModelController;
    }

    public void b(s sVar) {
        this.f57487e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.b.i0.c3.m> mvcHttpMessage) {
        this.f57485c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.i0.c3.m> mvcNetMessage) {
        this.f57486d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.b.i0.c3.m> mvcHttpResponsedMessage) {
        this.f57484b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f57483a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f57484b, this.f57485c, this.f57486d);
        s sVar = this.f57487e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
