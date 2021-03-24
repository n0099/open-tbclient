package d.b.i0.q1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import d.b.i0.q1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f59353a;

    /* renamed from: b  reason: collision with root package name */
    public long f59354b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f59355c;

    /* renamed from: d  reason: collision with root package name */
    public b f59356d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f59357e = new a(CmdConfigHttp.CMD_MEMBER_TASK, 309427);

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof MemberTaskCenterHttpResMessage;
            if (z || (responsedMessage instanceof MemberTaskCenterSocketResMessage)) {
                if (z) {
                    MemberTaskCenterHttpResMessage memberTaskCenterHttpResMessage = (MemberTaskCenterHttpResMessage) responsedMessage;
                    if (memberTaskCenterHttpResMessage.hasError()) {
                        if (c.this.f59356d != null) {
                            c.this.f59356d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f59353a = memberTaskCenterHttpResMessage.getImageList();
                    c.this.f59355c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        c.this.f59354b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f59356d != null) {
                        c.this.f59356d.b(c.this.f59353a, c.this.f59355c, c.this.f59354b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (c.this.f59356d != null) {
                            c.this.f59356d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f59353a = memberTaskCenterSocketResMessage.getImageList();
                    c.this.f59355c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        c.this.f59354b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f59356d != null) {
                        c.this.f59356d.b(c.this.f59353a, c.this.f59355c, c.this.f59354b);
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
        d.b.i0.c3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f59357e);
    }

    public long h() {
        return this.f59354b;
    }

    public List<r> i() {
        return this.f59355c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.f59357e);
    }

    public void l(long j) {
        this.f59354b = j;
    }

    public void m(b bVar) {
        this.f59356d = bVar;
    }
}
