package d.b.b.c.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class a<M extends Message<?>, T extends MessageTask> implements d.b.b.c.b<M, T> {

    /* renamed from: a  reason: collision with root package name */
    public MessageManager f41484a;

    public a(MessageManager messageManager) {
        this.f41484a = null;
        this.f41484a = messageManager;
    }
}
