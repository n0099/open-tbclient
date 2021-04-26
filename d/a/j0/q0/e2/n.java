package d.a.j0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.j0.d3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f57666a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.a.j0.d3.m, ?> f57667b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.a.j0.d3.m> f57668c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.j0.d3.m> f57669d;

    /* renamed from: e  reason: collision with root package name */
    public s f57670e;

    public void a(FrsModelController frsModelController) {
        this.f57666a = frsModelController;
    }

    public void b(s sVar) {
        this.f57670e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.a.j0.d3.m> mvcSocketMessage) {
        this.f57668c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.j0.d3.m> mvcNetMessage) {
        this.f57669d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.a.j0.d3.m, ?> mvcSocketResponsedMessage) {
        this.f57667b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f57666a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.y0(this.f57667b, this.f57668c, this.f57669d);
        s sVar = this.f57670e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
