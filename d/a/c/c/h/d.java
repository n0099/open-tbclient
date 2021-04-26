package d.a.c.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import d.a.c.c.e.c.g;
import d.a.c.c.f.k;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {

    /* renamed from: i  reason: collision with root package name */
    public g f39488i;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.f39488i = null;
        this.f39488i = new g(messageManager);
        this.f39485e = d.a.c.c.j.c.c();
    }

    @Override // d.a.c.c.b
    public LinkedList<SocketMessage> e(int i2, BdUniqueId bdUniqueId) {
        return this.f39488i.e(i2, bdUniqueId);
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        this.f39488i.h(i2, bdUniqueId);
    }

    public LinkedList<SocketMessage> v(BdUniqueId bdUniqueId) {
        return this.f39488i.n(bdUniqueId);
    }

    public g w() {
        return this.f39488i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.h.c
    /* renamed from: x */
    public SocketMessage l(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.f39481a.getController().m(socketMessage, socketMessageTask);
    }

    public void y(BdUniqueId bdUniqueId) {
        this.f39488i.C(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
    /* renamed from: z */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.f39488i.f(socketMessage, socketMessageTask);
    }
}
