package d.a.n0.s1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.FinishMemberTaskHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.FinishMemberTaskReqMessage;
import com.baidu.tieba.memberCenter.memberTask.FinishMemberTaskSocketMessage;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public int f64162b;

    /* renamed from: c  reason: collision with root package name */
    public int f64163c;

    /* renamed from: d  reason: collision with root package name */
    public long f64164d;

    /* renamed from: a  reason: collision with root package name */
    public b f64161a = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f64165e = new C1648a(CmdConfigHttp.CMD_FINISH_MEMBER_TASK, 309429);

    /* renamed from: d.a.n0.s1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1648a extends d.a.c.c.g.a {
        public C1648a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FinishMemberTaskHttpResMessage;
            if (z || (responsedMessage instanceof FinishMemberTaskSocketMessage)) {
                if (z) {
                    a.this.f64162b = ((FinishMemberTaskHttpResMessage) responsedMessage).getStatus();
                } else if (responsedMessage instanceof FinishMemberTaskSocketMessage) {
                    a.this.f64162b = ((FinishMemberTaskSocketMessage) responsedMessage).getStatus();
                }
                if (a.this.f64161a != null) {
                    a.this.f64161a.a(responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f64162b, a.this.f64163c, a.this.f64164d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, String str, int i3, int i4, long j);
    }

    public a() {
        d.a.n0.e3.d0.a.h(309429, FinishMemberTaskSocketMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309429, CmdConfigHttp.CMD_FINISH_MEMBER_TASK, TbConfig.FINISH_MEMBER_TASK, FinishMemberTaskHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f64165e);
    }

    public void f(long j, int i2) {
        this.f64164d = j;
        this.f64163c = i2;
        FinishMemberTaskReqMessage finishMemberTaskReqMessage = new FinishMemberTaskReqMessage();
        finishMemberTaskReqMessage.setTaskId(j);
        MessageManager.getInstance().sendMessage(finishMemberTaskReqMessage);
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f64165e);
    }

    public void h(b bVar) {
        this.f64161a = bVar;
    }
}
