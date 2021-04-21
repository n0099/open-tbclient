package d.b.j0.h2;

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
import d.b.c.e.p.j;
/* loaded from: classes3.dex */
public class e implements d.b.j0.i2.d.c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.m2.n.a f56931a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56932b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f56933c;

    /* renamed from: e  reason: collision with root package name */
    public int f56935e = 0;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f56934d = new a(CmdConfigHttp.SET_PRIVATE_CMD);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage().getTag() != e.this.f56933c) {
                return;
            }
            if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                if (e.this.f56932b == null || StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    return;
                }
                e.this.f56932b.showToast(httpResponsedMessage.getErrorString());
                return;
            }
            if (e.this.f56932b != null) {
                e.this.f56932b.showToast(R.string.privacy_setting_toast);
            }
            e.this.f56935e = 1;
            e.this.f56931a.e();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921065 || customResponsedMessage.getData() == null || e.this.f56935e == (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                return;
            }
            e.this.f56935e = intValue;
            if (intValue != 1) {
                return;
            }
            e.this.f56931a.e();
        }
    }

    public e(TbPageContext tbPageContext, d.b.j0.m2.n.a aVar, BdUniqueId bdUniqueId) {
        this.f56932b = tbPageContext;
        this.f56931a = aVar;
        this.f56933c = bdUniqueId;
        b bVar = new b(2921065);
        this.f56934d.setTag(this.f56933c);
        bVar.setTag(this.f56933c);
        MessageManager.getInstance().registerListener(this.f56934d);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // d.b.j0.i2.d.c
    public void a() {
        if (!j.z()) {
            TbPageContext tbPageContext = this.f56932b;
            if (tbPageContext != null) {
                tbPageContext.showToast(R.string.neterror);
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(1));
        httpMessage.setTag(this.f56933c);
        MessageManager.getInstance().sendMessage(httpMessage);
        TiebaStatic.log(new StatisticItem("c12515").param("obj_locate", 1));
    }
}
