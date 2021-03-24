package d.b.i0.q1.e;

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
    public int f59341b;

    /* renamed from: c  reason: collision with root package name */
    public int f59342c;

    /* renamed from: d  reason: collision with root package name */
    public long f59343d;

    /* renamed from: a  reason: collision with root package name */
    public b f59340a = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f59344e = new C1479a(CmdConfigHttp.CMD_FINISH_MEMBER_TASK, 309429);

    /* renamed from: d.b.i0.q1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1479a extends d.b.b.c.g.a {
        public C1479a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FinishMemberTaskHttpResMessage;
            if (z || (responsedMessage instanceof FinishMemberTaskSocketMessage)) {
                if (z) {
                    a.this.f59341b = ((FinishMemberTaskHttpResMessage) responsedMessage).getStatus();
                } else if (responsedMessage instanceof FinishMemberTaskSocketMessage) {
                    a.this.f59341b = ((FinishMemberTaskSocketMessage) responsedMessage).getStatus();
                }
                if (a.this.f59340a != null) {
                    a.this.f59340a.a(responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f59341b, a.this.f59342c, a.this.f59343d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str, int i2, int i3, long j);
    }

    public a() {
        d.b.i0.c3.d0.a.h(309429, FinishMemberTaskSocketMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309429, CmdConfigHttp.CMD_FINISH_MEMBER_TASK, TbConfig.FINISH_MEMBER_TASK, FinishMemberTaskHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f59344e);
    }

    public void f(long j, int i) {
        this.f59343d = j;
        this.f59342c = i;
        FinishMemberTaskReqMessage finishMemberTaskReqMessage = new FinishMemberTaskReqMessage();
        finishMemberTaskReqMessage.setTaskId(j);
        MessageManager.getInstance().sendMessage(finishMemberTaskReqMessage);
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f59344e);
    }

    public void h(b bVar) {
        this.f59340a = bVar;
    }
}
