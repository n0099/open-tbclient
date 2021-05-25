package d.a.n0.y0;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import d.a.c.c.f.j;
/* loaded from: classes4.dex */
public class c extends j {
    public c() {
        super(0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
    @Override // d.a.c.c.f.g
    public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        c(socketResponsedMessage2);
        return socketResponsedMessage2;
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 1990055 && !a.c(socketResponsedMessage.getCmd())) {
            a.d();
        }
        return socketResponsedMessage;
    }
}
