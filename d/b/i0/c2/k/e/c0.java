package d.b.i0.c2.k.e;

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
/* loaded from: classes4.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public PbModel f52627a;

    /* renamed from: b  reason: collision with root package name */
    public b f52628b;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.b.c.g.a f52630d = new a(CmdConfigHttp.CMD_PB_GOD_MORE, 309446);

    /* renamed from: c  reason: collision with root package name */
    public final BdUniqueId f52629c = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == c0.this.f52629c) {
                if (responsedMessage instanceof LookMoreHttpResMessage) {
                    LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                    List<PostData> data = lookMoreHttpResMessage.getData();
                    String errorString = lookMoreHttpResMessage.getErrorString();
                    int error = lookMoreHttpResMessage.getError();
                    if (error != 0) {
                        c0.this.f52628b.a(error, errorString, "");
                    } else if (ListUtils.isEmpty(data)) {
                    } else {
                        c0.this.f52628b.onSuccess(data);
                    }
                } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                    LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                    List<PostData> data2 = lookMoreSocketResMessage.getData();
                    String errorString2 = lookMoreSocketResMessage.getErrorString();
                    int error2 = lookMoreSocketResMessage.getError();
                    if (error2 != 0) {
                        c0.this.f52628b.a(error2, errorString2, "");
                    } else if (data2 != null) {
                        c0.this.f52628b.onSuccess(data2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, String str2);

        void onSuccess(List<PostData> list);
    }

    public c0(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.f52627a = pbModel;
        e();
        this.f52630d.setTag(baseFragmentActivity.getUniqueId());
        MessageManager.getInstance().registerListener(this.f52630d);
        this.f52628b = null;
    }

    public void c(List<Long> list) {
        PbModel pbModel = this.f52627a;
        if (pbModel == null || pbModel.y0() == null) {
            return;
        }
        int k = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
        int i = d.b.b.e.p.l.i(TbadkCoreApplication.getInst());
        LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
        lookMoreReqMessage.setKz(Long.valueOf(d.b.b.e.m.b.f(this.f52627a.f19731e, 0L)));
        lookMoreReqMessage.setPost_id(list);
        lookMoreReqMessage.setSt_type(d.b.b.e.m.b.d(this.f52627a.mStType, 0));
        lookMoreReqMessage.setWith_floor(1);
        lookMoreReqMessage.setScr_w(k);
        lookMoreReqMessage.setScr_h(i);
        lookMoreReqMessage.setTag(this.f52629c);
        MessageManager.getInstance().sendMessage(lookMoreReqMessage);
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f52630d);
    }

    public final void e() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, d.b.i0.c3.d0.a.a(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.b.i0.c3.d0.a.f(309446, LookMoreSocketResMessage.class, false);
    }

    public void f(b bVar) {
        this.f52628b = bVar;
    }
}
