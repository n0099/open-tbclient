package d.b.i0.r1.e;

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
    public int f61036b;

    /* renamed from: c  reason: collision with root package name */
    public int f61037c;

    /* renamed from: d  reason: collision with root package name */
    public long f61038d;

    /* renamed from: a  reason: collision with root package name */
    public b f61035a = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f61039e = new C1544a(CmdConfigHttp.CMD_FINISH_MEMBER_TASK, 309429);

    /* renamed from: d.b.i0.r1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1544a extends d.b.c.c.g.a {
        public C1544a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FinishMemberTaskHttpResMessage;
            if (z || (responsedMessage instanceof FinishMemberTaskSocketMessage)) {
                if (z) {
                    a.this.f61036b = ((FinishMemberTaskHttpResMessage) responsedMessage).getStatus();
                } else if (responsedMessage instanceof FinishMemberTaskSocketMessage) {
                    a.this.f61036b = ((FinishMemberTaskSocketMessage) responsedMessage).getStatus();
                }
                if (a.this.f61035a != null) {
                    a.this.f61035a.a(responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f61036b, a.this.f61037c, a.this.f61038d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str, int i2, int i3, long j);
    }

    public a() {
        d.b.i0.d3.d0.a.h(309429, FinishMemberTaskSocketMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309429, CmdConfigHttp.CMD_FINISH_MEMBER_TASK, TbConfig.FINISH_MEMBER_TASK, FinishMemberTaskHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f61039e);
    }

    public void f(long j, int i) {
        this.f61038d = j;
        this.f61037c = i;
        FinishMemberTaskReqMessage finishMemberTaskReqMessage = new FinishMemberTaskReqMessage();
        finishMemberTaskReqMessage.setTaskId(j);
        MessageManager.getInstance().sendMessage(finishMemberTaskReqMessage);
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f61039e);
    }

    public void h(b bVar) {
        this.f61035a = bVar;
    }
}
