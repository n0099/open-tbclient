package d.a.k0.d2.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreReqMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes5.dex */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    public PbModel f53035a;

    /* renamed from: b  reason: collision with root package name */
    public b f53036b;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.c.c.g.a f53038d = new a(CmdConfigHttp.CMD_PB_GOD_MORE, 309446);

    /* renamed from: c  reason: collision with root package name */
    public final BdUniqueId f53037c = BdUniqueId.gen();

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == e0.this.f53037c) {
                if (responsedMessage instanceof LookMoreHttpResMessage) {
                    LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                    List<PostData> data = lookMoreHttpResMessage.getData();
                    String errorString = lookMoreHttpResMessage.getErrorString();
                    int error = lookMoreHttpResMessage.getError();
                    if (error != 0) {
                        e0.this.f53036b.a(error, errorString, "");
                    } else if (ListUtils.isEmpty(data)) {
                    } else {
                        e0.this.f53036b.onSuccess(data);
                    }
                } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                    LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                    List<PostData> data2 = lookMoreSocketResMessage.getData();
                    String errorString2 = lookMoreSocketResMessage.getErrorString();
                    int error2 = lookMoreSocketResMessage.getError();
                    if (error2 != 0) {
                        e0.this.f53036b.a(error2, errorString2, "");
                    } else if (data2 != null) {
                        e0.this.f53036b.onSuccess(data2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, String str2);

        void onSuccess(List<PostData> list);
    }

    public e0(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.f53035a = pbModel;
        e();
        this.f53038d.setTag(baseFragmentActivity.getUniqueId());
        MessageManager.getInstance().registerListener(this.f53038d);
        this.f53036b = null;
    }

    public void c(List<Long> list) {
        PbModel pbModel = this.f53035a;
        if (pbModel == null || pbModel.y0() == null) {
            return;
        }
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst());
        LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
        lookMoreReqMessage.setKz(Long.valueOf(d.a.c.e.m.b.f(this.f53035a.f19179e, 0L)));
        lookMoreReqMessage.setPost_id(list);
        lookMoreReqMessage.setSt_type(d.a.c.e.m.b.d(this.f53035a.mStType, 0));
        lookMoreReqMessage.setWith_floor(1);
        lookMoreReqMessage.setScr_w(k);
        lookMoreReqMessage.setScr_h(i2);
        lookMoreReqMessage.setTag(this.f53037c);
        MessageManager.getInstance().sendMessage(lookMoreReqMessage);
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f53038d);
    }

    public final void e() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, d.a.k0.d3.d0.a.a(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.a.k0.d3.d0.a.f(309446, LookMoreSocketResMessage.class, false);
    }

    public void f(b bVar) {
        this.f53036b = bVar;
    }
}
