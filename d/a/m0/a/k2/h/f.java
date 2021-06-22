package d.a.m0.a.k2.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
import d.a.m0.a.k;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47075a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, e> f47076b = new ArrayMap();

    @Nullable
    public static AshmemFileDescriptor a(@NonNull String str, int i2) {
        try {
            if (ProcessUtils.isMainProcess()) {
                synchronized (f47076b) {
                    e eVar = f47076b.get(str);
                    if (eVar != null && eVar.a() != null) {
                        return eVar.a();
                    }
                    int ashmemFD = SwanKV.getAshmemFD(str, i2);
                    if (ashmemFD >= 0) {
                        AshmemFileDescriptor ashmemFileDescriptor = new AshmemFileDescriptor(str, ashmemFD, i2);
                        b.e(ashmemFileDescriptor);
                        return ashmemFileDescriptor;
                    }
                    return null;
                }
            }
            return a.a(str, i2);
        } catch (Throwable th) {
            if (f47075a) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static synchronized void b(@NonNull AshmemFileDescriptor ashmemFileDescriptor) {
        synchronized (f.class) {
            if (ProcessUtils.isMainProcess()) {
                return;
            }
            e eVar = f47076b.get(ashmemFileDescriptor.b());
            if (eVar != null && eVar.a() != null && eVar.a().a() != ashmemFileDescriptor.a()) {
                SwanKV b2 = eVar.b();
                eVar.c(new SwanKV(ashmemFileDescriptor));
                b2.o();
            }
        }
    }
}
