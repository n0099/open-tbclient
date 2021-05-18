package d.a.j0.a;

import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.GetTokenHttpResponsedMessage;
import com.baidu.tbadk.BdToken.GetTokenRequestMessage;
import com.baidu.tbadk.BdToken.GetTokenSocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public b f48684b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48683a = false;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f48685c = new a(CmdConfigHttp.CMD_GET_TOKEN, 309608);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e.this.f48683a = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                e.this.d(false, null);
            } else if (responsedMessage instanceof GetTokenSocketResponsedMessage) {
                e.this.d(true, ((GetTokenSocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GetTokenHttpResponsedMessage) {
                e.this.d(true, ((GetTokenHttpResponsedMessage) responsedMessage).getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, a0 a0Var);
    }

    public e() {
        f();
        e();
    }

    public void c(String str) {
        if (this.f48683a) {
            return;
        }
        this.f48683a = true;
        GetTokenRequestMessage getTokenRequestMessage = new GetTokenRequestMessage();
        getTokenRequestMessage.setToken(Base64.encodeToString(str.getBytes(), 2));
        getTokenRequestMessage.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        MessageManager.getInstance().sendMessage(getTokenRequestMessage);
    }

    public final void d(boolean z, a0 a0Var) {
        b bVar = this.f48684b;
        if (bVar != null) {
            bVar.a(z, a0Var);
        }
    }

    public final void e() {
        MessageManager.getInstance().registerListener(this.f48685c);
    }

    public final void f() {
        d.a.k0.d3.d0.a.h(309608, GetTokenSocketResponsedMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309608, CmdConfigHttp.CMD_GET_TOKEN, TbConfig.URL_GET_TOKEN, GetTokenHttpResponsedMessage.class, false, false, false, false);
    }

    public void g(b bVar) {
        this.f48684b = bVar;
    }
}
