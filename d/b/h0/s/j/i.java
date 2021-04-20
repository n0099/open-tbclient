package d.b.h0.s.j;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import d.b.c.c.f.j;
/* loaded from: classes3.dex */
public class i extends j {
    public i() {
        super(0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
    @Override // d.b.c.c.f.g
    public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        c(socketResponsedMessage2);
        return socketResponsedMessage2;
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 110004 && socketResponsedMessage.getCmd() != 1001) {
            d.b.h0.c0.a.b(0, 0, 0, 1, 11);
            BdSocketLinkService.startService(true, "be server kicked off");
        }
        return socketResponsedMessage;
    }
}
