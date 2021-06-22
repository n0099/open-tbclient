package d.a.o0.i2;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class e implements d.a.o0.j2.d.c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.n2.n.a f59556a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59557b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f59558c;

    /* renamed from: e  reason: collision with root package name */
    public int f59560e = 0;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f59559d = new a(CmdConfigHttp.SET_PRIVATE_CMD);

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage().getTag() != e.this.f59558c) {
                return;
            }
            if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                if (e.this.f59557b == null || StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    return;
                }
                e.this.f59557b.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            if (e.this.f59557b != null) {
                e.this.f59557b.showToast(R.string.privacy_setting_toast);
            }
            e.this.f59560e = 1;
            e.this.f59556a.e();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921065 || customResponsedMessage.getData() == null || e.this.f59560e == (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                return;
            }
            e.this.f59560e = intValue;
            if (intValue != 1) {
                return;
            }
            e.this.f59556a.e();
        }
    }

    public e(TbPageContext tbPageContext, d.a.o0.n2.n.a aVar, BdUniqueId bdUniqueId) {
        this.f59557b = tbPageContext;
        this.f59556a = aVar;
        this.f59558c = bdUniqueId;
        b bVar = new b(2921065);
        this.f59559d.setTag(this.f59558c);
        bVar.setTag(this.f59558c);
        MessageManager.getInstance().registerListener(this.f59559d);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // d.a.o0.j2.d.c
    public void a() {
        if (!j.z()) {
            TbPageContext tbPageContext = this.f59557b;
            if (tbPageContext != null) {
                tbPageContext.showToast(R.string.neterror);
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(1));
        httpMessage.setTag(this.f59558c);
        MessageManager.getInstance().sendMessage(httpMessage);
        TiebaStatic.log(new StatisticItem("c12515").param("obj_locate", 1));
    }
}
