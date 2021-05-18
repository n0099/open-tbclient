package d.a.k0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.k0.d3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f58403a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.a.k0.d3.m> f58404b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.a.k0.d3.m> f58405c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.k0.d3.m> f58406d;

    /* renamed from: e  reason: collision with root package name */
    public s f58407e;

    public void a(FrsModelController frsModelController) {
        this.f58403a = frsModelController;
    }

    public void b(s sVar) {
        this.f58407e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.a.k0.d3.m> mvcHttpMessage) {
        this.f58405c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.k0.d3.m> mvcNetMessage) {
        this.f58406d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.a.k0.d3.m> mvcHttpResponsedMessage) {
        this.f58404b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f58403a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.w0(this.f58404b, this.f58405c, this.f58406d);
        s sVar = this.f58407e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
