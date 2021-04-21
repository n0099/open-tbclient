package d.b.j0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.j0.d3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f59604a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.b.j0.d3.m> f59605b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.b.j0.d3.m> f59606c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.j0.d3.m> f59607d;

    /* renamed from: e  reason: collision with root package name */
    public s f59608e;

    public void a(FrsModelController frsModelController) {
        this.f59604a = frsModelController;
    }

    public void b(s sVar) {
        this.f59608e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.b.j0.d3.m> mvcHttpMessage) {
        this.f59606c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.j0.d3.m> mvcNetMessage) {
        this.f59607d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.b.j0.d3.m> mvcHttpResponsedMessage) {
        this.f59605b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f59604a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f59605b, this.f59606c, this.f59607d);
        s sVar = this.f59608e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
