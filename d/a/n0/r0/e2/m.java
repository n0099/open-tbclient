package d.a.n0.r0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.n0.e3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f58544a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.a.n0.e3.m> f58545b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.a.n0.e3.m> f58546c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.n0.e3.m> f58547d;

    /* renamed from: e  reason: collision with root package name */
    public s f58548e;

    public void a(FrsModelController frsModelController) {
        this.f58544a = frsModelController;
    }

    public void b(s sVar) {
        this.f58548e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.a.n0.e3.m> mvcHttpMessage) {
        this.f58546c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.n0.e3.m> mvcNetMessage) {
        this.f58547d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.a.n0.e3.m> mvcHttpResponsedMessage) {
        this.f58545b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f58544a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f58545b, this.f58546c, this.f58547d);
        s sVar = this.f58548e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
