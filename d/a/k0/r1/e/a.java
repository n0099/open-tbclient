package d.a.k0.r1.e;

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
    public int f60348b;

    /* renamed from: c  reason: collision with root package name */
    public int f60349c;

    /* renamed from: d  reason: collision with root package name */
    public long f60350d;

    /* renamed from: a  reason: collision with root package name */
    public b f60347a = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f60351e = new C1580a(CmdConfigHttp.CMD_FINISH_MEMBER_TASK, 309429);

    /* renamed from: d.a.k0.r1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1580a extends d.a.c.c.g.a {
        public C1580a(int i2, int i3) {
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
                    a.this.f60348b = ((FinishMemberTaskHttpResMessage) responsedMessage).getStatus();
                } else if (responsedMessage instanceof FinishMemberTaskSocketMessage) {
                    a.this.f60348b = ((FinishMemberTaskSocketMessage) responsedMessage).getStatus();
                }
                if (a.this.f60347a != null) {
                    a.this.f60347a.a(responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f60348b, a.this.f60349c, a.this.f60350d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, String str, int i3, int i4, long j);
    }

    public a() {
        d.a.k0.d3.d0.a.h(309429, FinishMemberTaskSocketMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309429, CmdConfigHttp.CMD_FINISH_MEMBER_TASK, TbConfig.FINISH_MEMBER_TASK, FinishMemberTaskHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f60351e);
    }

    public void f(long j, int i2) {
        this.f60350d = j;
        this.f60349c = i2;
        FinishMemberTaskReqMessage finishMemberTaskReqMessage = new FinishMemberTaskReqMessage();
        finishMemberTaskReqMessage.setTaskId(j);
        MessageManager.getInstance().sendMessage(finishMemberTaskReqMessage);
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f60351e);
    }

    public void h(b bVar) {
        this.f60347a = bVar;
    }
}
