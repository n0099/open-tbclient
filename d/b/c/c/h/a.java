package d.b.c.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, d.b.c.c.f.b, CustomResponsedMessage<?>> {
    public d.b.c.c.e.b i;

    public a(MessageManager messageManager) {
        super(messageManager);
        this.i = null;
        this.i = new d.b.c.c.e.b(messageManager);
        this.f42294e = d.b.c.c.j.a.c();
    }

    @Override // d.b.c.c.b
    public LinkedList<CustomMessage<?>> e(int i, BdUniqueId bdUniqueId) {
        return this.i.e(i, bdUniqueId);
    }

    @Override // d.b.c.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        this.i.h(i, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> v(BdUniqueId bdUniqueId) {
        return this.i.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.h.c
    /* renamed from: w */
    public CustomMessage<?> l(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.f42290a.getController().g(customMessage, customMessageTask);
    }

    public void x(BdUniqueId bdUniqueId) {
        this.i.j(bdUniqueId);
    }

    public <T> CustomResponsedMessage<T> y(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        return this.i.k(customMessage, customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.b
    /* renamed from: z */
    public void f(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.i.f(customMessage, customMessageTask);
    }
}
