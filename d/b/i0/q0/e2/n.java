package d.b.i0.q0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.i0.d3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f59188a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.b.i0.d3.m, ?> f59189b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.b.i0.d3.m> f59190c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.b.i0.d3.m> f59191d;

    /* renamed from: e  reason: collision with root package name */
    public s f59192e;

    public void a(FrsModelController frsModelController) {
        this.f59188a = frsModelController;
    }

    public void b(s sVar) {
        this.f59192e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.b.i0.d3.m> mvcSocketMessage) {
        this.f59190c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.b.i0.d3.m> mvcNetMessage) {
        this.f59191d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.b.i0.d3.m, ?> mvcSocketResponsedMessage) {
        this.f59189b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f59188a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.y0(this.f59189b, this.f59190c, this.f59191d);
        s sVar = this.f59192e;
        if (sVar != null) {
            sVar.c();
        }
        return false;
    }
}
