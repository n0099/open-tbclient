package d.a.i0.a.k2.h;

import androidx.annotation.NonNull;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final AshmemFileDescriptor f43115a;

    /* renamed from: b  reason: collision with root package name */
    public volatile SwanKV f43116b;

    static {
        c.B();
    }

    public AshmemFileDescriptor a() {
        return this.f43115a;
    }

    @NonNull
    public SwanKV b() {
        return this.f43116b;
    }

    public void c(@NonNull SwanKV swanKV) {
        this.f43116b = swanKV;
    }
}
