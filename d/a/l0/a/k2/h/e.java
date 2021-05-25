package d.a.l0.a.k2.h;

import androidx.annotation.NonNull;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final AshmemFileDescriptor f43289a;

    /* renamed from: b  reason: collision with root package name */
    public volatile SwanKV f43290b;

    static {
        c.B();
    }

    public AshmemFileDescriptor a() {
        return this.f43289a;
    }

    @NonNull
    public SwanKV b() {
        return this.f43290b;
    }

    public void c(@NonNull SwanKV swanKV) {
        this.f43290b = swanKV;
    }
}
