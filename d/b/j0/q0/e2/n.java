package d.b.j0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.j0.d3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f59609a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.b.j0.d3.m, ?> f59610b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.b.j0.d3.m> f59611c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.j0.d3.m> f59612d;

    /* renamed from: e  reason: collision with root package name */
    public s f59613e;

    public void a(FrsModelController frsModelController) {
        this.f59609a = frsModelController;
    }

    public void b(s sVar) {
        this.f59613e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.b.j0.d3.m> mvcSocketMessage) {
        this.f59611c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.j0.d3.m> mvcNetMessage) {
        this.f59612d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.b.j0.d3.m, ?> mvcSocketResponsedMessage) {
        this.f59610b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f59609a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.y0(this.f59610b, this.f59611c, this.f59612d);
        s sVar = this.f59613e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
