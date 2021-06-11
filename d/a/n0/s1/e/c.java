package d.a.n0.s1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import d.a.n0.s1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f64174a;

    /* renamed from: b  reason: collision with root package name */
    public long f64175b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f64176c;

    /* renamed from: d  reason: collision with root package name */
    public b f64177d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f64178e = new a(CmdConfigHttp.CMD_MEMBER_TASK, 309427);

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
                        if (c.this.f64177d != null) {
                            c.this.f64177d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f64174a = memberTaskCenterHttpResMessage.getImageList();
                    c.this.f64176c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        c.this.f64175b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f64177d != null) {
                        c.this.f64177d.b(c.this.f64174a, c.this.f64176c, c.this.f64175b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (c.this.f64177d != null) {
                            c.this.f64177d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f64174a = memberTaskCenterSocketResMessage.getImageList();
                    c.this.f64176c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        c.this.f64175b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f64177d != null) {
                        c.this.f64177d.b(c.this.f64174a, c.this.f64176c, c.this.f64175b);
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
        d.a.n0.e3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f64178e);
    }

    public long h() {
        return this.f64175b;
    }

    public List<r> i() {
        return this.f64176c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.f64178e);
    }

    public void l(long j) {
        this.f64175b = j;
    }

    public void m(b bVar) {
        this.f64177d = bVar;
    }
}
