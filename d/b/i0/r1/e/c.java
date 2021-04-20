package d.b.i0.r1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import d.b.i0.r1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f61048a;

    /* renamed from: b  reason: collision with root package name */
    public long f61049b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f61050c;

    /* renamed from: d  reason: collision with root package name */
    public b f61051d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f61052e = new a(CmdConfigHttp.CMD_MEMBER_TASK, 309427);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof MemberTaskCenterHttpResMessage;
            if (z || (responsedMessage instanceof MemberTaskCenterSocketResMessage)) {
                if (z) {
                    MemberTaskCenterHttpResMessage memberTaskCenterHttpResMessage = (MemberTaskCenterHttpResMessage) responsedMessage;
                    if (memberTaskCenterHttpResMessage.hasError()) {
                        if (c.this.f61051d != null) {
                            c.this.f61051d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f61048a = memberTaskCenterHttpResMessage.getImageList();
                    c.this.f61050c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        c.this.f61049b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f61051d != null) {
                        c.this.f61051d.b(c.this.f61048a, c.this.f61050c, c.this.f61049b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (c.this.f61051d != null) {
                            c.this.f61051d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f61048a = memberTaskCenterSocketResMessage.getImageList();
                    c.this.f61050c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        c.this.f61049b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f61051d != null) {
                        c.this.f61051d.b(c.this.f61048a, c.this.f61050c, c.this.f61049b);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str);

        void b(List<ImgInfo> list, List<r> list2, long j);
    }

    public c() {
        d.b.i0.d3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f61052e);
    }

    public long h() {
        return this.f61049b;
    }

    public List<r> i() {
        return this.f61050c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.f61052e);
    }

    public void l(long j) {
        this.f61049b = j;
    }

    public void m(b bVar) {
        this.f61051d = bVar;
    }
}
