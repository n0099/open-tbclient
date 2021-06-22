package d.a.o0.s1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import d.a.o0.s1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f64299a;

    /* renamed from: b  reason: collision with root package name */
    public long f64300b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f64301c;

    /* renamed from: d  reason: collision with root package name */
    public b f64302d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f64303e = new a(CmdConfigHttp.CMD_MEMBER_TASK, 309427);

    /* loaded from: classes4.dex */
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
                        if (c.this.f64302d != null) {
                            c.this.f64302d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f64299a = memberTaskCenterHttpResMessage.getImageList();
                    c.this.f64301c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        c.this.f64300b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f64302d != null) {
                        c.this.f64302d.b(c.this.f64299a, c.this.f64301c, c.this.f64300b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (c.this.f64302d != null) {
                            c.this.f64302d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    c.this.f64299a = memberTaskCenterSocketResMessage.getImageList();
                    c.this.f64301c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        c.this.f64300b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (c.this.f64302d != null) {
                        c.this.f64302d.b(c.this.f64299a, c.this.f64301c, c.this.f64300b);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<ImgInfo> list, List<r> list2, long j);
    }

    public c() {
        d.a.o0.e3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f64303e);
    }

    public long h() {
        return this.f64300b;
    }

    public List<r> i() {
        return this.f64301c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.f64303e);
    }

    public void l(long j) {
        this.f64300b = j;
    }

    public void m(b bVar) {
        this.f64302d = bVar;
    }
}
