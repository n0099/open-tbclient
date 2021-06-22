package d.a.o0.r0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.o0.e3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f62365a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.a.o0.e3.m, ?> f62366b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.a.o0.e3.m> f62367c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.o0.e3.m> f62368d;

    /* renamed from: e  reason: collision with root package name */
    public s f62369e;

    public void a(FrsModelController frsModelController) {
        this.f62365a = frsModelController;
    }

    public void b(s sVar) {
        this.f62369e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.a.o0.e3.m> mvcSocketMessage) {
        this.f62367c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.o0.e3.m> mvcNetMessage) {
        this.f62368d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.a.o0.e3.m, ?> mvcSocketResponsedMessage) {
        this.f62366b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f62365a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.C0(this.f62366b, this.f62367c, this.f62368d);
        s sVar = this.f62369e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
