package d.a.m0.a.k2.h;

import androidx.annotation.NonNull;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final AshmemFileDescriptor f47073a;

    /* renamed from: b  reason: collision with root package name */
    public volatile SwanKV f47074b;

    static {
        c.B();
    }

    public AshmemFileDescriptor a() {
        return this.f47073a;
    }

    @NonNull
    public SwanKV b() {
        return this.f47074b;
    }

    public void c(@NonNull SwanKV swanKV) {
        this.f47074b = swanKV;
    }
}
