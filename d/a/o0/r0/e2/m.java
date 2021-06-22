package d.a.o0.r0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.o0.e3.s;
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f62360a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<d.a.o0.e3.m> f62361b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, d.a.o0.e3.m> f62362c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.o0.e3.m> f62363d;

    /* renamed from: e  reason: collision with root package name */
    public s f62364e;

    public void a(FrsModelController frsModelController) {
        this.f62360a = frsModelController;
    }

    public void b(s sVar) {
        this.f62364e = sVar;
    }

    public void c(MvcHttpMessage<FrsRequestData, d.a.o0.e3.m> mvcHttpMessage) {
        this.f62362c = mvcHttpMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.o0.e3.m> mvcNetMessage) {
        this.f62363d = mvcNetMessage;
    }

    public void e(MvcHttpResponsedMessage<d.a.o0.e3.m> mvcHttpResponsedMessage) {
        this.f62361b = mvcHttpResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f62360a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.A0(this.f62361b, this.f62362c, this.f62363d);
        s sVar = this.f62364e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
