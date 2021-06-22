package d.a.m0.a.v1.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, ProviderDelegation> f49078a = new ConcurrentHashMap();

    static {
        c(d.a.m0.a.u.b.a());
        c(d.a.m0.a.c1.a.s().d());
    }

    @Nullable
    public static ProviderDelegation a(@NonNull Class<? extends ProviderDelegation> cls) {
        return f49078a.get(cls.getName());
    }

    @Nullable
    public static ProviderDelegation b(@NonNull String str) {
        return f49078a.get(str);
    }

    public static void c(@Nullable Map<Class, Object> map) {
        if (map != null) {
            for (Class cls : map.keySet()) {
                if (cls != null) {
                    Object obj = map.get(cls);
                    if (obj instanceof ProviderDelegation) {
                        f49078a.put(cls.getName(), (ProviderDelegation) obj);
                    }
                }
            }
        }
    }
}
