package d.a.c.c.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class a<M extends Message<?>, T extends MessageTask> implements d.a.c.c.b<M, T> {

    /* renamed from: a  reason: collision with root package name */
    public MessageManager f38316a;

    public a(MessageManager messageManager) {
        this.f38316a = null;
        this.f38316a = messageManager;
    }
}
