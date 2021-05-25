package d.a.n0.v.d.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveResponseMessage;
import d.a.n0.v.d.f.c.h;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f61738a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61740c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f61741d = new C1654a(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f61739b = BdUniqueId.gen();

    /* renamed from: d.a.n0.v.d.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1654a extends HttpMessageListener {
        public C1654a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f61740c = false;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021093 && (httpResponsedMessage instanceof SpecialLiveResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.f61739b) {
                SpecialLiveResponseMessage specialLiveResponseMessage = (SpecialLiveResponseMessage) httpResponsedMessage;
                if (!specialLiveResponseMessage.isSuccess() || specialLiveResponseMessage.getData() == null) {
                    if (a.this.f61738a != null) {
                        a.this.f61738a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (a.this.f61738a != null) {
                    a.this.f61738a.b(specialLiveResponseMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(h hVar);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        this.f61738a = bVar;
        h();
        g();
    }

    public boolean d() {
        return this.f61740c;
    }

    public void e() {
        if (this.f61740c) {
            return;
        }
        this.f61740c = true;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        httpMessage.setTag(this.f61739b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        MessageManager.getInstance().unRegisterListener(this.f61741d);
    }

    public final void g() {
        MessageManager.getInstance().registerListener(this.f61741d);
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_DATA);
        tbHttpMessageTask.setResponsedClass(SpecialLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
