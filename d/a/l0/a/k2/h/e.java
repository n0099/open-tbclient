package d.a.l0.a.k2.h;

import androidx.annotation.NonNull;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final AshmemFileDescriptor f46965a;

    /* renamed from: b  reason: collision with root package name */
    public volatile SwanKV f46966b;

    static {
        c.B();
    }

    public AshmemFileDescriptor a() {
        return this.f46965a;
    }

    @NonNull
    public SwanKV b() {
        return this.f46966b;
    }

    public void c(@NonNull SwanKV swanKV) {
        this.f46966b = swanKV;
    }
}
