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
    public b f65452a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65454c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f65455d = new C1711a(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f65453b = BdUniqueId.gen();

    /* renamed from: d.a.n0.v.d.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1711a extends HttpMessageListener {
        public C1711a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f65454c = false;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021093 && (httpResponsedMessage instanceof SpecialLiveResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.f65453b) {
                SpecialLiveResponseMessage specialLiveResponseMessage = (SpecialLiveResponseMessage) httpResponsedMessage;
                if (!specialLiveResponseMessage.isSuccess() || specialLiveResponseMessage.getData() == null) {
                    if (a.this.f65452a != null) {
                        a.this.f65452a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (a.this.f65452a != null) {
                    a.this.f65452a.b(specialLiveResponseMessage.getData());
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
        this.f65452a = bVar;
        h();
        g();
    }

    public boolean d() {
        return this.f65454c;
    }

    public void e() {
        if (this.f65454c) {
            return;
        }
        this.f65454c = true;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        httpMessage.setTag(this.f65453b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA);
        MessageManager.getInstance().unRegisterListener(this.f65455d);
    }

    public final void g() {
        MessageManager.getInstance().registerListener(this.f65455d);
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_LIVE_DATA, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_DATA);
        tbHttpMessageTask.setResponsedClass(SpecialLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
