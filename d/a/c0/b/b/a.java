package d.a.c0.b.b;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public abstract class a<T> implements b<T> {
    public static final boolean DEBUG = AppConfig.isDebug();
    public T mCachedInstance;

    public abstract T createService() throws ServiceNotFoundException;

    @Override // d.a.c0.b.b.b
    public final T getService() {
        synchronized (this) {
            if (this.mCachedInstance == null) {
                try {
                    this.mCachedInstance = createService();
                } catch (ServiceNotFoundException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                        throw e2;
                    }
                }
            }
        }
        return this.mCachedInstance;
    }
}
