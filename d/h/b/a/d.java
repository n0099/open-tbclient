package d.h.b.a;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class d implements ArCoreApk.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f67040a;

    public d(AtomicReference atomicReference) {
        this.f67040a = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.f67040a.set(availability);
    }
}
