package d.a.j0.r1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import d.a.j0.r1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f59615a;

    /* renamed from: b  reason: collision with root package name */
    public long f59616b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f59617c;

    /* renamed from: d  reason: collision with root package name */
    public b f59618d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f59619e = new a(CmdConfigHttp.CMD_MEMBER_TASK, 309427);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof MemberTaskCenterHttpResMessage;
            if (z || (responsedMessage instanceof MemberTaskCenterSocketResMessage)) {
                if (z) {
                    MemberTaskCenterHttpResMessage memberTaskCenterHttpResMessage = (MemberTaskCenterHttpResMessage) responsedMessage;
                    if (memberTaskCenterHttpResMessage.hasError()) {
                        if (c.this.f59618d != null) {
                            c.this.f59618d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f59615a = memberTaskCenterHttpResMessage.getImageList();
                    c.this.f59617c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        c.this.f59616b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f59618d != null) {
                        c.this.f59618d.b(c.this.f59615a, c.this.f59617c, c.this.f59616b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (c.this.f59618d != null) {
                            c.this.f59618d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f59615a = memberTaskCenterSocketResMessage.getImageList();
                    c.this.f59617c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        c.this.f59616b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f59618d != null) {
                        c.this.f59618d.b(c.this.f59615a, c.this.f59617c, c.this.f59616b);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<ImgInfo> list, List<r> list2, long j);
    }

    public c() {
        d.a.j0.d3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f59619e);
    }

    public long h() {
        return this.f59616b;
    }

    public List<r> i() {
        return this.f59617c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.f59619e);
    }

    public void l(long j) {
        this.f59616b = j;
    }

    public void m(b bVar) {
        this.f59618d = bVar;
    }
}
