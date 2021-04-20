package d.b.i0.q0.i1;

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
import d.b.c.e.p.j;
import d.b.i0.q0.i1.g;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public c f59350a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59351b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.s.e.a f59352c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f59353d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f59354e = new a(2001115);

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
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || h.this.f59350a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f13354a) {
                h.this.f59350a.c(updateAttentionMessage.getData().f13355b);
            } else {
                h.this.f59350a.d(data.f13357d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        this.f59351b = tbPageContext;
        this.f59350a = cVar;
        this.f59352c = new d.b.h0.s.e.a(tbPageContext);
        this.f59354e.setSelfListener(true);
        this.f59354e.setTag(this.f59353d);
        MessageManager.getInstance().registerListener(this.f59354e);
    }

    public void b() {
        d.b.h0.s.e.a aVar = this.f59352c;
        if (aVar != null) {
            aVar.g();
        }
        MessageManager.getInstance().unRegisterListener(this.f59354e);
    }

    public void c(g gVar) {
        if (!j.z()) {
            this.f59351b.showToast(R.string.no_network);
        } else if (gVar == null || gVar.y == null || this.f59352c == null || !ViewHelper.checkUpIsLogin(this.f59351b.getPageActivity())) {
        } else {
            d.b.h0.s.e.a aVar = this.f59352c;
            g.b bVar = gVar.y;
            aVar.l(!bVar.f59332e, bVar.f59331d, bVar.f59328a, this.f59353d);
        }
    }

    public void d(g gVar) {
        if (!j.z()) {
            this.f59351b.showToast(R.string.no_network);
        } else if (gVar == null || this.f59350a == null || !ViewHelper.checkUpIsLogin(this.f59351b.getPageActivity())) {
        } else {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.f59319f);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.f59318e);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            if (!StringUtil.isEmpty(gVar.u)) {
                httpMessage.addParam("obj_source", gVar.u);
            }
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.f59350a.e();
        }
    }
}
