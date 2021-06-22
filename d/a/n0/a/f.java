package d.a.n0.a;

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
public class f {

    /* renamed from: b  reason: collision with root package name */
    public b f52489b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52488a = false;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f52490c = new a(CmdConfigHttp.CMD_GET_TOKEN, 309608);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.f52488a = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                f.this.d(false, null);
            } else if (responsedMessage instanceof GetTokenSocketResponsedMessage) {
                f.this.d(true, ((GetTokenSocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GetTokenHttpResponsedMessage) {
                f.this.d(true, ((GetTokenHttpResponsedMessage) responsedMessage).getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, b0 b0Var);
    }

    public f() {
        f();
        e();
    }

    public void c(String str) {
        if (this.f52488a) {
            return;
        }
        this.f52488a = true;
        GetTokenRequestMessage getTokenRequestMessage = new GetTokenRequestMessage();
        getTokenRequestMessage.setToken(Base64.encodeToString(str.getBytes(), 2));
        getTokenRequestMessage.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        MessageManager.getInstance().sendMessage(getTokenRequestMessage);
    }

    public final void d(boolean z, b0 b0Var) {
        b bVar = this.f52489b;
        if (bVar != null) {
            bVar.a(z, b0Var);
        }
    }

    public final void e() {
        MessageManager.getInstance().registerListener(this.f52490c);
    }

    public final void f() {
        d.a.o0.e3.d0.a.h(309608, GetTokenSocketResponsedMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309608, CmdConfigHttp.CMD_GET_TOKEN, TbConfig.URL_GET_TOKEN, GetTokenHttpResponsedMessage.class, false, false, false, false);
    }

    public void g(b bVar) {
        this.f52489b = bVar;
    }
}
