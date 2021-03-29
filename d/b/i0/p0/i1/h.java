package d.b.i0.p0.i1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.i0.p0.i1.g;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public c f57651a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57652b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.s.e.a f57653c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f57654d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f57655e = new a(2001115);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || h.this.f57651a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f13693a) {
                h.this.f57651a.c(updateAttentionMessage.getData().f13694b);
            } else {
                h.this.f57651a.d(data.f13696d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        this.f57652b = tbPageContext;
        this.f57651a = cVar;
        this.f57653c = new d.b.h0.s.e.a(tbPageContext);
        this.f57655e.setSelfListener(true);
        this.f57655e.setTag(this.f57654d);
        MessageManager.getInstance().registerListener(this.f57655e);
    }

    public void b() {
        d.b.h0.s.e.a aVar = this.f57653c;
        if (aVar != null) {
            aVar.g();
        }
        MessageManager.getInstance().unRegisterListener(this.f57655e);
    }

    public void c(g gVar) {
        if (!j.z()) {
            this.f57652b.showToast(R.string.no_network);
        } else if (gVar == null || gVar.y == null || this.f57653c == null || !ViewHelper.checkUpIsLogin(this.f57652b.getPageActivity())) {
        } else {
            d.b.h0.s.e.a aVar = this.f57653c;
            g.b bVar = gVar.y;
            aVar.l(!bVar.f57633e, bVar.f57632d, bVar.f57629a, this.f57654d);
        }
    }

    public void d(g gVar) {
        if (!j.z()) {
            this.f57652b.showToast(R.string.no_network);
        } else if (gVar == null || this.f57651a == null || !ViewHelper.checkUpIsLogin(this.f57652b.getPageActivity())) {
        } else {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.f57620f);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.f57619e);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            if (!StringUtil.isEmpty(gVar.u)) {
                httpMessage.addParam("obj_source", gVar.u);
            }
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.f57651a.e();
        }
    }
}
