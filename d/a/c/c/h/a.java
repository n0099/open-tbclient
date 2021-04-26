package d.a.c.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, d.a.c.c.f.b, CustomResponsedMessage<?>> {

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.e.b f39478i;

    public a(MessageManager messageManager) {
        super(messageManager);
        this.f39478i = null;
        this.f39478i = new d.a.c.c.e.b(messageManager);
        this.f39485e = d.a.c.c.j.a.c();
    }

    @Override // d.a.c.c.b
    public LinkedList<CustomMessage<?>> e(int i2, BdUniqueId bdUniqueId) {
        return this.f39478i.e(i2, bdUniqueId);
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        this.f39478i.h(i2, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> v(BdUniqueId bdUniqueId) {
        return this.f39478i.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.h.c
    /* renamed from: w */
    public CustomMessage<?> l(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.f39481a.getController().g(customMessage, customMessageTask);
    }

    public void x(BdUniqueId bdUniqueId) {
        this.f39478i.j(bdUniqueId);
    }

    public <T> CustomResponsedMessage<T> y(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        return this.f39478i.k(customMessage, customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
    /* renamed from: z */
    public void f(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.f39478i.f(customMessage, customMessageTask);
    }
}
