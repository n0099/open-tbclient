package d.b.c.c.f;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class f<T extends Message<?>, M extends MessageTask> extends h<T> {
    public f(int i) {
        super(i);
    }

    public abstract T process(T t, M m);

    public T rule(T t, M m) {
        return t != null ? (getCmd() == 0 || getCmd() == t.getCmd()) ? process(t, m) : t : t;
    }
}
