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
    public FrsModelController f62240a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.a.n0.e3.m, ?> f62241b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.a.n0.e3.m> f62242c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.n0.e3.m> f62243d;

    /* renamed from: e  reason: collision with root package name */
    public s f62244e;

    public void a(FrsModelController frsModelController) {
        this.f62240a = frsModelController;
    }

    public void b(s sVar) {
        this.f62244e = sVar;
    }

    public void c(MvcSocketMessage<FrsRequestData, d.a.n0.e3.m> mvcSocketMessage) {
        this.f62242c = mvcSocketMessage;
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.n0.e3.m> mvcNetMessage) {
        this.f62243d = mvcNetMessage;
    }

    public void e(MvcSocketResponsedMessage<d.a.n0.e3.m, ?> mvcSocketResponsedMessage) {
        this.f62241b = mvcSocketResponsedMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        FrsModelController frsModelController = this.f62240a;
        if (frsModelController == null) {
            return false;
        }
        frsModelController.C0(this.f62241b, this.f62242c, this.f62243d);
        s sVar = this.f62244e;
        if (sVar != null) {
            sVar.b();
        }
        return false;
    }
}
