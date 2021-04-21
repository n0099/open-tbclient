package d.b.c.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import d.b.c.c.e.c.g;
import d.b.c.c.f.k;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {
    public g i;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.i = null;
        this.i = new g(messageManager);
        this.f42294e = d.b.c.c.j.c.c();
    }

    @Override // d.b.c.c.b
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        return this.i.e(i, bdUniqueId);
    }

    @Override // d.b.c.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        this.i.h(i, bdUniqueId);
    }

    public LinkedList<SocketMessage> v(BdUniqueId bdUniqueId) {
        return this.i.n(bdUniqueId);
    }

    public g w() {
        return this.i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.h.c
    /* renamed from: x */
    public SocketMessage l(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.f42290a.getController().m(socketMessage, socketMessageTask);
    }

    public void y(BdUniqueId bdUniqueId) {
        this.i.C(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.b
    /* renamed from: z */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.i.f(socketMessage, socketMessageTask);
    }
}
