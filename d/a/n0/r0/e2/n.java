package d.a.n0.r0.e2;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.n0.e3.s;
/* loaded from: classes4.dex */
public class n implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f58549a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.a.n0.e3.m, ?> f58550b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.a.n0.e3.m> f58551c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.n0.e3.m> f58552d;

    /* renamed from: e  reason: collision with root package name */
    public s f58553e;

    public void a(FrsModelController frsModelController) {
        this.f58549a = frsModelController;
    }

    public void b(s sVar) {
        this.f58553e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.a.n0.e3.m> mvcSocketMessage) {
        this.f58551c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.n0.e3.m> mvcNetMessage) {
        this.f58552d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.a.n0.e3.m, ?> mvcSocketResponsedMessage) {
        this.f58550b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f58549a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.y0(this.f58550b, this.f58551c, this.f58552d);
        s sVar = this.f58553e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
