package d.b.j0.h2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryHttpResponsedMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistoryRequestMessage;
import com.baidu.tieba.personExtra.SmartAppBrowseHistorySocketResponsedMessage;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public b f56939b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f56938a = false;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.c.g.a f56940c = new a(CmdConfigHttp.CMD_HISTORY_SWAN, 309638);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.f56938a = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                h.this.c(false, null);
            } else if (responsedMessage instanceof SmartAppBrowseHistorySocketResponsedMessage) {
                h.this.c(true, ((SmartAppBrowseHistorySocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof SmartAppBrowseHistoryHttpResponsedMessage) {
                h.this.c(true, ((SmartAppBrowseHistoryHttpResponsedMessage) responsedMessage).getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, d.b.j0.h2.a aVar);
    }

    public h() {
        e();
        d();
    }

    public final void c(boolean z, d.b.j0.h2.a aVar) {
        b bVar = this.f56939b;
        if (bVar != null) {
            bVar.a(z, aVar);
        }
    }

    public final void d() {
        MessageManager.getInstance().registerListener(this.f56940c);
    }

    public final void e() {
        d.b.j0.d3.d0.a.f(309638, SmartAppBrowseHistorySocketResponsedMessage.class, false);
        d.b.j0.d3.d0.a.c(309638, CmdConfigHttp.CMD_HISTORY_SWAN, TbConfig.URL_HISTORY_SWAN, SmartAppBrowseHistoryHttpResponsedMessage.class, false, false, true, false);
    }

    public void f() {
        if (this.f56938a) {
            return;
        }
        this.f56938a = true;
        MessageManager.getInstance().sendMessage(new SmartAppBrowseHistoryRequestMessage());
    }

    public void g(b bVar) {
        this.f56939b = bVar;
    }
}
