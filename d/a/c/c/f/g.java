package d.a.c.c.f;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class g<T extends ResponsedMessage<?>> extends h<T> {
    public g(int i2) {
        super(i2);
    }

    public abstract T a(T t);

    public T b(T t) {
        return t != null ? (getCmd() == 0 || getCmd() == t.getCmd()) ? a(t) : t : t;
    }
}
