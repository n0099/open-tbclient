package d.b.b.c.f;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class g<T extends ResponsedMessage<?>> extends h<T> {
    public g(int i) {
        super(i);
    }

    public abstract T a(T t);

    public T b(T t) {
        return t != null ? (getCmd() == 0 || getCmd() == t.getCmd()) ? a(t) : t : t;
    }
}
