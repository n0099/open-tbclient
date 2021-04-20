package d.b.c.c.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class a<M extends Message<?>, T extends MessageTask> implements d.b.c.c.b<M, T> {

    /* renamed from: a  reason: collision with root package name */
    public MessageManager f41982a;

    public a(MessageManager messageManager) {
        this.f41982a = null;
        this.f41982a = messageManager;
    }
}
