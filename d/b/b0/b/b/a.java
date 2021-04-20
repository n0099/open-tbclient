package d.b.b0.b.b;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public abstract class a<T> implements b<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f41959b = AppConfig.isDebug();

    /* renamed from: a  reason: collision with root package name */
    public T f41960a;

    public abstract T a() throws ServiceNotFoundException;

    @Override // d.b.b0.b.b.b
    public final T getService() {
        synchronized (this) {
            if (this.f41960a == null) {
                try {
                    this.f41960a = a();
                } catch (ServiceNotFoundException e2) {
                    if (f41959b) {
                        e2.printStackTrace();
                        throw e2;
                    }
                }
            }
        }
        return this.f41960a;
    }
}
