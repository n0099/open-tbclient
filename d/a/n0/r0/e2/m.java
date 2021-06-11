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
    public FrsModelController f62235a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.a.n0.e3.m> f62236b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.a.n0.e3.m> f62237c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.n0.e3.m> f62238d;

    /* renamed from: e  reason: collision with root package name */
    public s f62239e;

    public void a(FrsModelController frsModelController) {
        this.f62235a = frsModelController;
    }

    public void b(s sVar) {
        this.f62239e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.a.n0.e3.m> mvcHttpMessage) {
        this.f62237c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.n0.e3.m> mvcNetMessage) {
        this.f62238d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.a.n0.e3.m> mvcHttpResponsedMessage) {
        this.f62236b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f62235a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.A0(this.f62236b, this.f62237c, this.f62238d);
        s sVar = this.f62239e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
