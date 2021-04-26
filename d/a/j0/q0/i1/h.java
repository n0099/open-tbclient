package d.a.j0.q0.i1;

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
import d.a.j0.q0.i1.g;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public c f57840a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57841b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.s.e.a f57842c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f57843d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f57844e = new a(2001115);

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
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || h.this.f57840a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f13330a) {
                h.this.f57840a.c(updateAttentionMessage.getData().f13331b);
            } else {
                h.this.f57840a.e(data.f13333d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        this.f57841b = tbPageContext;
        this.f57840a = cVar;
        this.f57842c = new d.a.i0.s.e.a(tbPageContext);
        this.f57844e.setSelfListener(true);
        this.f57844e.setTag(this.f57843d);
        MessageManager.getInstance().registerListener(this.f57844e);
    }

    public void b() {
        d.a.i0.s.e.a aVar = this.f57842c;
        if (aVar != null) {
            aVar.g();
        }
        MessageManager.getInstance().unRegisterListener(this.f57844e);
    }

    public void c(g gVar) {
        if (!j.z()) {
            this.f57841b.showToast(R.string.no_network);
        } else if (gVar == null || gVar.y == null || this.f57842c == null || !ViewHelper.checkUpIsLogin(this.f57841b.getPageActivity())) {
        } else {
            d.a.i0.s.e.a aVar = this.f57842c;
            g.b bVar = gVar.y;
            aVar.l(!bVar.f57821e, bVar.f57820d, bVar.f57817a, this.f57843d);
        }
    }

    public void d(g gVar) {
        if (!j.z()) {
            this.f57841b.showToast(R.string.no_network);
        } else if (gVar == null || this.f57840a == null || !ViewHelper.checkUpIsLogin(this.f57841b.getPageActivity())) {
        } else {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.f57807f);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.f57806e);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            if (!StringUtil.isEmpty(gVar.u)) {
                httpMessage.addParam("obj_source", gVar.u);
            }
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.f57840a.d();
        }
    }
}
