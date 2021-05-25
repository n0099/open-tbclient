package d.a.n0.r0.i1;

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
import d.a.c.e.p.j;
import d.a.n0.r0.i1.g;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public c f58723a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58724b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.s.e.a f58725c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58726d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f58727e = new a(2001115);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || h.this.f58723a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f12574a) {
                h.this.f58723a.c(updateAttentionMessage.getData().f12575b);
            } else {
                h.this.f58723a.e(data.f12577d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        this.f58724b = tbPageContext;
        this.f58723a = cVar;
        this.f58725c = new d.a.m0.s.e.a(tbPageContext);
        this.f58727e.setSelfListener(true);
        this.f58727e.setTag(this.f58726d);
        MessageManager.getInstance().registerListener(this.f58727e);
    }

    public void b() {
        d.a.m0.s.e.a aVar = this.f58725c;
        if (aVar != null) {
            aVar.g();
        }
        MessageManager.getInstance().unRegisterListener(this.f58727e);
    }

    public void c(g gVar) {
        if (!j.z()) {
            this.f58724b.showToast(R.string.no_network);
        } else if (gVar == null || gVar.y == null || this.f58725c == null || !ViewHelper.checkUpIsLogin(this.f58724b.getPageActivity())) {
        } else {
            d.a.m0.s.e.a aVar = this.f58725c;
            g.b bVar = gVar.y;
            aVar.l(!bVar.f58704e, bVar.f58703d, bVar.f58700a, this.f58726d);
        }
    }

    public void d(g gVar) {
        if (!j.z()) {
            this.f58724b.showToast(R.string.no_network);
        } else if (gVar == null || this.f58723a == null || !ViewHelper.checkUpIsLogin(this.f58724b.getPageActivity())) {
        } else {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.f58690f);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.f58689e);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            if (!StringUtil.isEmpty(gVar.u)) {
                httpMessage.addParam("obj_source", gVar.u);
            }
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.f58723a.d();
        }
    }
}
