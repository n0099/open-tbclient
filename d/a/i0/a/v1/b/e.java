package d.a.i0.a.v1.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, ProviderDelegation> f45120a = new ConcurrentHashMap();

    static {
        c(d.a.i0.a.u.b.a());
        c(d.a.i0.a.c1.a.s().d());
    }

    @Nullable
    public static ProviderDelegation a(@NonNull Class<? extends ProviderDelegation> cls) {
        return f45120a.get(cls.getName());
    }

    @Nullable
    public static ProviderDelegation b(@NonNull String str) {
        return f45120a.get(str);
    }

    public static void c(@Nullable Map<Class, Object> map) {
        if (map != null) {
            for (Class cls : map.keySet()) {
                if (cls != null) {
                    Object obj = map.get(cls);
                    if (obj instanceof ProviderDelegation) {
                        f45120a.put(cls.getName(), (ProviderDelegation) obj);
                    }
                }
            }
        }
    }
}
