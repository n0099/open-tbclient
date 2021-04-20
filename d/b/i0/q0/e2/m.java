package d.b.i0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.i0.d3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f59183a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.b.i0.d3.m> f59184b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.b.i0.d3.m> f59185c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.i0.d3.m> f59186d;

    /* renamed from: e  reason: collision with root package name */
    public s f59187e;

    public void a(FrsModelController frsModelController) {
        this.f59183a = frsModelController;
    }

    public void b(s sVar) {
        this.f59187e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.b.i0.d3.m> mvcHttpMessage) {
        this.f59185c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.i0.d3.m> mvcNetMessage) {
        this.f59186d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.b.i0.d3.m> mvcHttpResponsedMessage) {
        this.f59184b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f59183a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f59184b, this.f59185c, this.f59186d);
        s sVar = this.f59187e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
