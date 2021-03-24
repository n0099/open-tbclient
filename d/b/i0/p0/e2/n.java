package d.b.i0.p0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.i0.c3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f57488a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.b.i0.c3.m, ?> f57489b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.b.i0.c3.m> f57490c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.i0.c3.m> f57491d;

    /* renamed from: e  reason: collision with root package name */
    public s f57492e;

    public void a(FrsModelController frsModelController) {
        this.f57488a = frsModelController;
    }

    public void b(s sVar) {
        this.f57492e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.b.i0.c3.m> mvcSocketMessage) {
        this.f57490c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.i0.c3.m> mvcNetMessage) {
        this.f57491d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.b.i0.c3.m, ?> mvcSocketResponsedMessage) {
        this.f57489b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f57488a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.y0(this.f57489b, this.f57490c, this.f57491d);
        s sVar = this.f57492e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
