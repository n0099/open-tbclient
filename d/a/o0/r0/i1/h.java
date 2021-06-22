package d.a.o0.r0.i1;

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
import d.a.o0.r0.i1.g;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public c f62539a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62540b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.s.e.a f62541c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f62542d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62543e = new a(2001115);

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
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || h.this.f62539a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f12718a) {
                h.this.f62539a.c(updateAttentionMessage.getData().f12719b);
            } else {
                h.this.f62539a.e(data.f12721d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        this.f62540b = tbPageContext;
        this.f62539a = cVar;
        this.f62541c = new d.a.n0.s.e.a(tbPageContext);
        this.f62543e.setSelfListener(true);
        this.f62543e.setTag(this.f62542d);
        MessageManager.getInstance().registerListener(this.f62543e);
    }

    public void b() {
        d.a.n0.s.e.a aVar = this.f62541c;
        if (aVar != null) {
            aVar.g();
        }
        MessageManager.getInstance().unRegisterListener(this.f62543e);
    }

    public void c(g gVar) {
        if (!j.z()) {
            this.f62540b.showToast(R.string.no_network);
        } else if (gVar == null || gVar.y == null || this.f62541c == null || !ViewHelper.checkUpIsLogin(this.f62540b.getPageActivity())) {
        } else {
            d.a.n0.s.e.a aVar = this.f62541c;
            g.b bVar = gVar.y;
            aVar.l(!bVar.f62520e, bVar.f62519d, bVar.f62516a, this.f62542d);
        }
    }

    public void d(g gVar) {
        if (!j.z()) {
            this.f62540b.showToast(R.string.no_network);
        } else if (gVar == null || this.f62539a == null || !ViewHelper.checkUpIsLogin(this.f62540b.getPageActivity())) {
        } else {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.f62506f);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.f62505e);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            if (!StringUtil.isEmpty(gVar.u)) {
                httpMessage.addParam("obj_source", gVar.u);
            }
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.f62539a.d();
        }
    }
}
