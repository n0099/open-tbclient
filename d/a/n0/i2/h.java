package d.a.n0.i2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryHttpResponsedMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryRequestMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistorySocketResponsedMessage;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public b f55750b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55749a = false;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f55751c = new a(CmdConfigHttp.CMD_HISTORY_SWAN, 309638);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.f55749a = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                h.this.c(false, null);
            } else if (responsedMessage instanceof SmartAppBrowseHistorySocketResponsedMessage) {
                h.this.c(true, ((SmartAppBrowseHistorySocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof SmartAppBrowseHistoryHttpResponsedMessage) {
                h.this.c(true, ((SmartAppBrowseHistoryHttpResponsedMessage) responsedMessage).getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, d.a.n0.i2.a aVar);
    }

    public h() {
        e();
        d();
    }

    public final void c(boolean z, d.a.n0.i2.a aVar) {
        b bVar = this.f55750b;
        if (bVar != null) {
            bVar.a(z, aVar);
        }
    }

    public final void d() {
        MessageManager.getInstance().registerListener(this.f55751c);
    }

    public final void e() {
        d.a.n0.e3.d0.a.f(309638, SmartAppBrowseHistorySocketResponsedMessage.class, false);
        d.a.n0.e3.d0.a.c(309638, CmdConfigHttp.CMD_HISTORY_SWAN, TbConfig.URL_HISTORY_SWAN, SmartAppBrowseHistoryHttpResponsedMessage.class, false, false, true, false);
    }

    public void f() {
        if (this.f55749a) {
            return;
        }
        this.f55749a = true;
        MessageManager.getInstance().sendMessage(new SmartAppBrowseHistoryRequestMessage());
    }

    public void g(b bVar) {
        this.f55750b = bVar;
    }
}
