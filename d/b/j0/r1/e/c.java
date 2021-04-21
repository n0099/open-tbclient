package d.b.j0.r1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import d.b.j0.r1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f61469a;

    /* renamed from: b  reason: collision with root package name */
    public long f61470b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f61471c;

    /* renamed from: d  reason: collision with root package name */
    public b f61472d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f61473e = new a(CmdConfigHttp.CMD_MEMBER_TASK, 309427);

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
                        if (c.this.f61472d != null) {
                            c.this.f61472d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f61469a = memberTaskCenterHttpResMessage.getImageList();
                    c.this.f61471c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        c.this.f61470b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f61472d != null) {
                        c.this.f61472d.b(c.this.f61469a, c.this.f61471c, c.this.f61470b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (c.this.f61472d != null) {
                            c.this.f61472d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f61469a = memberTaskCenterSocketResMessage.getImageList();
                    c.this.f61471c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        c.this.f61470b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f61472d != null) {
                        c.this.f61472d.b(c.this.f61469a, c.this.f61471c, c.this.f61470b);
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
        d.b.j0.d3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f61473e);
    }

    public long h() {
        return this.f61470b;
    }

    public List<r> i() {
        return this.f61471c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.f61473e);
    }

    public void l(long j) {
        this.f61470b = j;
    }

    public void m(b bVar) {
        this.f61472d = bVar;
    }
}
