package d.a.l0.a.k2.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
import d.a.l0.a.k;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43291a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, e> f43292b = new ArrayMap();

    @Nullable
    public static AshmemFileDescriptor a(@NonNull String str, int i2) {
        try {
            if (ProcessUtils.isMainProcess()) {
                synchronized (f43292b) {
                    e eVar = f43292b.get(str);
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
            if (f43291a) {
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
            e eVar = f43292b.get(ashmemFileDescriptor.b());
            if (eVar != null && eVar.a() != null && eVar.a().a() != ashmemFileDescriptor.a()) {
                SwanKV b2 = eVar.b();
                eVar.c(new SwanKV(ashmemFileDescriptor));
                b2.o();
            }
        }
    }
}
